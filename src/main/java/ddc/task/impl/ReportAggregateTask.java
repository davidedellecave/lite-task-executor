package ddc.task.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;

import ddc.http.HClientException;
import ddc.http.HClientExecutor;
import ddc.http.HClientFactory;
import ddc.http.HClientResponse;
import ddc.support.task.Task;
import ddc.support.task.TaskInfo;
import ddc.support.util.DateUtil;
import ddc.support.util.StringOutputStream;
import ddc.task.model.HttpConfig;

public class ReportAggregateTask extends Task {
	public static final String PROPNAME_AGGREGATED_TASK = "AggregatedTask.result";
	private final static Logger logger = Logger.getLogger(ReportAggregateTask.class);
	private static final String LOG_HEADER = "Report - ";

	@Override
	public void doRun() throws FileNotFoundException, IOException, InterruptedException, ExecutionException {
		TaskInfo gTask = (TaskInfo) this.getOptional(PROPNAME_AGGREGATED_TASK);
		HttpConfig httpConfig = (HttpConfig) this.getOptional(HttpConfig.PROPNAME_HTTP_CONFIG);
		if (gTask != null) {
			try {
				exReportToLog(gTask);
			} catch (Throwable t) {
				logger.error(t);
			}
			try {
				if (httpConfig != null) {
					exReportToHttp(httpConfig, gTask);
				} else {
					logger.warn(LOG_HEADER + "Cannot send report to http service - HttpConfig object not found on executing context");
				}
			} catch (Throwable t) {
				logger.error(t);
			}
		} else {
			logger.warn(LOG_HEADER + "aggregated task result is null");
		}
	}

	private void exReportToLog(TaskInfo gTask) throws FileNotFoundException, IOException, InterruptedException, ExecutionException {
		StringOutputStream outStream = new StringOutputStream();
		buildReport(gTask, outStream);
		logger.info(LOG_HEADER + "report - " + outStream.toString());
	}

	private void buildReport(TaskInfo gTask, OutputStream outStream) throws FileNotFoundException, IOException, InterruptedException, ExecutionException {
		outStream.write(("\n ------------------- Report " + DateUtil.formatForISO(new Date())).getBytes());
		if (gTask.getSubTasks() != null) {
			outStream.write(("\n\t Tasks:[" + gTask.getSubTasks().size() + "]").getBytes());
			outStream.write(("\n\t Succeedeed tasks:[" + gTask.getSubTasksSucceeded() + "]").getBytes());
			outStream.write(("\n\t Failed tasks:[" + gTask.getSubTasksFailed() + "]").getBytes());
			for (TaskInfo info : gTask.getSubTasks()) {
				outStream.write(getPrettyTaskInfo(info));
				outStream.write("\n".getBytes());
			}
			outStream.write(getPrettyTaskInfo(gTask));
		}
		outStream.write(("\n -------------------").getBytes());
	}

	private byte[] getPrettyTaskInfo(TaskInfo tInfo) {
		return (tInfo.toPrettyString() + "\n\t startTime:[" + tInfo.getStats().chron.getStartDate() + "] \n\t endTime:[" + tInfo.getStats().chron.getEndDate() + "]").getBytes();
	}

	private void exReportToHttp(HttpConfig config, TaskInfo gTask) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, HClientException {
		for (TaskInfo info : gTask.getSubTasks()) {
			sendHttpReport(config, info);
		}		
	}

	private void sendHttpReport(HttpConfig config, TaskInfo task) throws HClientException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		HClientFactory f = new HClientFactory();
		HClientExecutor client = new HClientExecutor(f.createClient());
		Map<String, String> data = new HashMap<>();
		data.put("job_name", "AME_CRM");
		data.put("tk_name", "unica_import");
		data.put("tk_entity", task.getName());
		data.put("tk_owner", "it.ame.ih.console.dbexport");
		data.put("tk_status", task.getStatus().toString().toLowerCase());
		data.put("tk_exit_code", task.getExitCode().toString().toLowerCase());
		data.put("tk_start_time", DateUtil.formatForISO(task.getStats().chron.getStartDate()));
		data.put("tk_end_time", DateUtil.formatForISO(task.getStats().chron.getEndDate()));
		data.put("tk_elapsed", task.getStats().chron.toString());
		if (task.isFailed()) {
			data.put("tk_msg_level", "error");
			if (task.getException()!=null)
				data.put("tk_msg", task.getException().toString());
		} else {
			data.put("tk_msg_level", "info");
		}
		if (task.getStats()!=null)
			data.put("tk_details", task.getStats().toString());
		data.put("tk_processed_items", String.valueOf(task.getStats().itemsProcessed));
//		data.put("tk_processed_bytes", 0);
		data.put("secretKey", config.getSecretKey());
		HClientResponse res = client.executePostForm(config.getEndpoint(), data);
		if (res.getStatusCode() != 200) {
			throw new HClientException("Http server error - http status code:[" + res.getStatusCode() + "]");
		}
	}
	



}
