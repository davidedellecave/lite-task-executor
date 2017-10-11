package ddc.task.impl;

import java.nio.file.Path;
import java.util.List;

import org.apache.log4j.Logger;

import ddc.support.files.scan.ScanFolderUtil;
import ddc.support.task.Task;
import ddc.support.task.TaskException;
import ddc.task.model.FileBag;

public class AppFileInputLocatorTask extends Task {
	private final static Logger logger = Logger.getLogger(AppFileInputLocatorTask.class);

	public void doRun() throws Exception {
		
		FileBag bag = (FileBag)this.get(FileBag.class);
		
		logger.info("--------------------------------");
		logger.info("Source:[" + bag.sourceFolder + "]");
				
		List<Path> list = ScanFolderUtil.getFiles(bag.sourceFolder, true, bag.sourceFileIncludeExtension, bag.sourceFileExcludeExtension);				
		bag.sourceFiles.addAll(list);
		
		if (list.size()<=0) {
			logger.warn("File to process not found");
			return;
		} else {
			logger.info("File to process #:[" + list.size() + "]");
		}
	}
	
	@Override
	public void run() {
		try {
			doRun();
		} catch (Exception e) {
			throw new TaskException(e);
		}
	}

}
