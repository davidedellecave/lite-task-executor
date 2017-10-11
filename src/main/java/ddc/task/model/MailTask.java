package ddc.task.model;

import org.apache.log4j.Logger;

import ddc.email.LiteMail;
import ddc.email.LiteMailConfig;
import ddc.email.LiteMailException;
import ddc.support.task.Task;

public class MailTask extends Task{
	private final static Logger logger = Logger.getLogger(MailTask.class);

	@Override
	public void doRun() throws LiteMailException {
		logger.info("Sending mail...");
		LiteMailConfig conf = (LiteMailConfig) get(LiteMailConfig.class);
		LiteMail e = new LiteMail();
		e.send(conf);
	}


}
