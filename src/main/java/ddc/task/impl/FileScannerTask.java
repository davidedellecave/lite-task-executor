package ddc.task.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import ddc.support.files.scan.ScanFolderUtil;
import ddc.support.task.Task;
import ddc.support.task.TaskException;
import ddc.support.util.Timespan;
import ddc.task.model.FileBag;
import ddc.task.model.FileScannerConfig;

public class FileScannerTask extends Task {
	private final static Logger logger = Logger.getLogger(FileScannerTask.class);
	private final static String LOG_HEADER = "File Scanner - ";
	public void doRun() throws Exception {
		
		FileScannerConfig conf = (FileScannerConfig)this.get(FileScannerConfig.class);		
		FileBag bag = (FileBag)this.make(FileBag.class);
		
		logger.info(LOG_HEADER + "source:[" + Arrays.toString(conf.getPaths()) + "]");
		logger.info(LOG_HEADER + "recursive:[" + conf.isRecursive() + "]");
		logger.info(LOG_HEADER + "include extension:[" + Arrays.toString(conf.getIncludeExtension())+ "]");
		logger.info(LOG_HEADER + "esclude extension:[" + Arrays.toString(conf.getEscludeExtension()) + "]");
		if (conf.getSelectOlderThanMillis()>0) {
			logger.info(LOG_HEADER + "select files older than " + Timespan.getHumanReadable(conf.getSelectOlderThanMillis()));	
		}
		
		for (String p : conf.getPaths()) {
			Path path = Paths.get(p);
			List<Path> list = ScanFolderUtil.getFiles(path, conf.isRecursive(), conf.getSelectOlderThanMillis(), conf.getIncludeExtension(), conf.getEscludeExtension());				
			bag.sourceFiles.addAll(list);
		}		
		if (bag.sourceFiles.size()<=0) {
			logger.warn(LOG_HEADER + "file not found");
			return;
		} else {
			logger.info(LOG_HEADER + "file to process:[" + bag.sourceFiles.size() + "]");
		}
	}
	
	@Override
	public void run() {
		try {
			doRun();
		} catch (Throwable e) {
			throw new TaskException(e);
		}
	}

}
