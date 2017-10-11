package ddc.task.impl;

import ddc.support.task.Task;
import ddc.support.task.TaskException;
import ddc.support.util.Statistics;

public class AppStatisticsTask extends Task {
	
	@Override
	public void  doRun() {
		Statistics stats = new Statistics();
		this.set(stats);		
	}
}
