package ddc.task.exec;

import java.util.ArrayList;
import java.util.UUID;

public class TaskPool extends ArrayList<TaskExecutor> {
	private static final long serialVersionUID = 1L;
	private UUID id = UUID.randomUUID();
	private ExecutionType poolType=ExecutionType.Sequence;
	private int maxThreads = 1;
	//

	public enum ExecutionType {
		Concurrent, Sequence 
	}
	
	public TaskPool(ExecutionType poolType) {
		this.poolType=poolType;
	}	
	
	public TaskPool(ExecutionType poolType, int maxThreads) {
		this.poolType=poolType;
		this.maxThreads=maxThreads;
	}	
	
	//
	public ExecutionType getPoolType() {
		return poolType;
	}
	public void setPoolType(ExecutionType poolType) {
		this.poolType = poolType;
	}
	public int getMaxThreads() {
		return maxThreads;
	}
	public void setMaxThreads(int maxThreads) {
		this.maxThreads = maxThreads;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}