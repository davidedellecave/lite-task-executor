package ddc.task.exec;

import ddc.config.ArgsValue;
import ddc.support.task.TaskException;

public interface TaskPoolFactory {
	public TaskPool create(ArgsValue args) throws TaskException;
	public TaskPool onNext(TaskPool prevJobs) throws TaskException;
}
