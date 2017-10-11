package ddc.task.template;

import java.nio.file.Paths;

import ddc.config.ConfigurationException;
import ddc.support.task.Task;
import ddc.task.model.FileBag;

public class DbUploader_SetupTask extends Task {
		
	@Override
	public void doRun() throws ConfigurationException {
		Config_Template conf = (Config_Template) get(Config_Template.class);
		String source = conf.getValue();
		FileBag bag = new FileBag();
		bag.sourceFolder = Paths.get(source);
		bag.sourceFileExcludeExtension = new String[] {"DS_Store"};
		bag.sourceFileIncludeExtension = new String[] {};
		this.set(bag);
	}
	


}
