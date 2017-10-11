package ddc.task.template;

import ddc.support.task.TaskException;
import ddc.task.exec.TaskExecutor;
import ddc.task.exec.TaskPool;
import ddc.task.exec.TaskPoolFactory;
import ddc.task.exec.TaskPoolManager;
import ddc.task.exec.TaskSchema;
import ddc.task.impl.AppStatisticsTask;
import ddc.task.impl.ConfigurationTask;
import ddc.task.impl.FailTask;

public class Main_Template implements TaskPoolFactory {
//	private final static Logger logger = Logger.getLogger(DbExport_Main.class);
	
	public static void main(String[] args) throws InterruptedException {
		Main_Template main = new Main_Template();
		TaskPoolManager m = new TaskPoolManager();
		m.run(main, args);
	}


	@Override
	public TaskPool create(String[] args) throws TaskException {
		TaskSchema schema1 = createSchema1();
		TaskExecutor e = new TaskExecutor(schema1);
		e.getContext().setParam(ConfigurationTask.PARAM_NAME_CONF_CLASS, Config_Template.class);
		TaskPool p1 = new TaskPool(TaskPool.ExecutionType.Sequence);
		p1.add(e);
		return p1;
	}

	@Override
	public TaskPool onNext(TaskPool prevJobs) throws TaskException {
		return null;
	}
	
	private TaskSchema createSchema1() {
		TaskSchema schema = new TaskSchema(AppStatisticsTask.class, FailTask.class);
		schema.nextSuccess(ConfigurationTask.class, FailTask.class);
//		.nextSuccess(DbExport_SetupTask.class, FailTask.class)
//		.nextSuccess(DbExport_BuildSchemaTask.class, FailTask.class)
//		.nextSuccess(DbExport_BuildSqlScript.class, FailTask.class)
//		.nextSuccess(DbExport_BuildAvroTask.class, ReportAggregateTask.class)
//		.nextSuccess(ReportAggregateTask.class, FailTask.class);
		//
		return schema;
	}
}