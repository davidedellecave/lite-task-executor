package ddc.task.exec;

import java.util.ArrayList;
import java.util.List;

import ddc.support.task.TaskContext;
import ddc.support.task.TaskInstance;
import ddc.support.util.Chronometer;
import ddc.support.util.LogConsole;
import ddc.support.util.LogListener;

public class TaskExecutor implements Runnable {
	private static LogListener logger = new LogConsole(TaskExecutor.class);
	private TaskContext ctx = new TaskContext();
	private TaskSchema schema = null;
	private List<TaskInstance> executedTask = new ArrayList<>();

	
	public TaskExecutor(TaskSchema schema) {
		super();
		this.schema = schema;
	}
	
	public TaskExecutor(TaskSchema schema, Object contextValue) {
		super();
		this.schema = schema;
		this.ctx.set(contextValue);
	}
	
	public TaskExecutor(TaskSchema schema, Object[] contextValueList) {
		super();
		this.schema = schema;
		for (Object obj : contextValueList)
			this.ctx.set(obj);
	}
	
	public void setLogListener(LogListener logger) {
		TaskExecutor.logger = logger;
	}
	
	public TaskContext getContext() {
		return ctx;
	}

	public Object getContextValue(Class<?> clazz) {
		return ctx.get(clazz);
	}

	public Object getContextParam(String name) {
		return ctx.getParam(name);
	}
	
	private final static String INFO = "executing - ";
	
	@Override
	public void run() {
		Chronometer chron = new Chronometer();
		logger.info(INFO + "\n" + schema.toSchemaString());
		doRun(schema);
		logger.info(INFO + "\n" + toExecutedTaskString());
		if (!hasFailedTask()) {
			logger.info(INFO + "All tasks are completed successfully in " + chron.toString());
		} else {
			logger.error(INFO + "All tasks are completed with ERROR in " + chron.toString());
			List<TaskInstance> list = getFailedTask();
			for (TaskInstance ti : list)
				logger.error(INFO + "\t task failed - " + ti.toString() + "\n");
		}
	}
	
	private void doRun(TaskSchema node) {
		if (node == null) {
			return;
		}
		String info = INFO + "task:["+ node.getName() + "]";
		logger.info(info + " - starting...");
		TaskInstance t = null;
		try {
			t = TaskInstance.create(node.getTaskClass(), ctx);
			executedTask.add(t);
			t.start();
			t.getInstance().run();
			t.terminateAsSucceeded();
			logger.info(info + " - terminated");			
			doRun(node.getOnSuccess());
		} catch (Throwable e) {			
			info = INFO + " - task:["+ node.getName() + "] error:[" + e.getMessage() + "]"; 
			logger.error(info, e);
			getContext().setException(e);
			if (t!=null) t.terminatedAsFailed(e);
			doRun(node.getOnFail());
		}
	}

	public String toExecutedTaskString() {
		StringBuilder b = new StringBuilder();
		for (TaskInstance t : executedTask) {
			b.append(" > " + t.getInstance().getClass().getSimpleName() + "[" + t.getTaskInfo().getExitCode() + "]");
		}
		return b.toString();
	}
	
	public List<TaskInstance> getExecutedTask() {
		return executedTask;
	}

	public boolean hasFailedTask() {
		for (TaskInstance t : executedTask) {
			if (t.isFailed()) return true;
		}
		return false;
	}
	
	public List<TaskInstance> getFailedTask() {
		List<TaskInstance> list = new ArrayList<>();
		for (TaskInstance t : executedTask) {
			if (t.isFailed()) list.add(t);
		}
		return list;
	}

}
