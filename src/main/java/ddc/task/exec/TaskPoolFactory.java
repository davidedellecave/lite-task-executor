package ddc.task.exec;

import ddc.support.task.TaskException;

public interface TaskPoolFactory {
	public TaskPool create(String[] args) throws TaskException;
	public TaskPool onNext(TaskPool prevJobs) throws TaskException;
}
