package ddc.task.impl;

import java.nio.file.Path;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.GenericApplicationContext;

import ddc.config.ArgsValue;
import ddc.config.ConfigurationException;
import ddc.config.ConfigurationLocator;
import ddc.config.SpringConfiguration;
import ddc.support.task.Task;
import ddc.support.util.LogConsole;
import ddc.support.util.LogListener;

public class ConfigurationTask extends Task {
	private final static LogListener logger = new LogConsole(ConfigurationTask.class);
	public final static String PARAM_NAME_CONF_PATH="configuration.path";

	@Override	
	public void doRun() throws ConfigurationException {
		ArgsValue args = ((ArgsValue) this.get(ArgsValue.class));
		Class<?> confClass = args.getConfClass();	
		if (confClass==null)
			throw new ConfigurationException("Configuration class is expected");
		
		Path path = null;
		if (args.getArgs()!=null && args.getArgs().length>0 && StringUtils.isNotBlank(args.getArgs()[0])) {
			path = ConfigurationLocator.getConfigurationFile(confClass, args.getArgs()[0], null);
		} else {
			path = ConfigurationLocator.getConfigurationFile(confClass, "conf.xml");
		}
		logger.info("Configuration file:[" + path.toString() + "]");
		GenericApplicationContext ctx = SpringConfiguration.getApplicationContext(path, false);
		Object v = ctx.getBean(confClass.getSimpleName());		
//		logger.info("Config Path...:" + path.getParent());		
		this.set(PARAM_NAME_CONF_PATH, path.getParent());
		this.set(v);
	}
	
	public Path getConfigurationPath() {
		return (Path)this.get(PARAM_NAME_CONF_PATH);
	}
	
}
