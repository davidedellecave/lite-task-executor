package ddc.task.impl;

import java.nio.file.Path;

import org.springframework.context.support.GenericApplicationContext;

import ddc.config.ConfigurationException;
import ddc.config.ConfigurationName;
import ddc.config.ConfigurationPath;
import ddc.config.SpringConfiguration;
import ddc.support.task.Task;
import ddc.support.task.TaskException;

public class ConfigurationTask extends Task {
	public final static String PARAM_NAME_CONF_CLASS = "configuration.class";
	public final static String PARAM_NAME_CONF_PATH = "configuration.path";

	@Override
	public void doRun() throws ConfigurationException {
		Class<?> clazz = (Class<?>) this.get(PARAM_NAME_CONF_CLASS);
		Path path = ConfigurationPath.getPath(new ConfigurationName(clazz));
		System.out.println("Configuration file:[" + path.toString() + "]");
		this.set(PARAM_NAME_CONF_PATH, path.getParent());
		GenericApplicationContext ctx = SpringConfiguration.getApplicationContext(path, false);
		Object v = ctx.getBean(clazz.getSimpleName());
		this.set(v);
	}

	public Path getConfigurationPath() {
		return (Path) this.get(PARAM_NAME_CONF_PATH);
	}

}
