package ddc.task.model;

import java.util.List;

import ddc.support.jdbc.JdbcConnectionFactory;

public class TablePool2Config {
	private boolean enabled = true;
	private JdbcConnectionFactory jdbcFactory = null;
	private int connectionRetry = 1;
	private int concurrentConnections = 1;
	private List<? extends TableConfig> tables = null;
	private int fetch=0;
	private int batch=0;
	
	public List<? extends TableConfig> getTables() {
		return tables;
	}

	public void setTables(List<? extends TableConfig> tables) {
		this.tables = tables;
	}

	public int getFetch() {
		return fetch;
	}

	public void setFetch(int fetch) {
		this.fetch = fetch;
	}

	public JdbcConnectionFactory getJdbcFactory() {
		return jdbcFactory;
	}

	public void setJdbcFactory(JdbcConnectionFactory jdbcFactory) {
		this.jdbcFactory = jdbcFactory;
	}

	public int getConcurrentConnections() {
		return concurrentConnections;
	}

	public void setConcurrentConnections(int concurrentConnections) {
		this.concurrentConnections = concurrentConnections;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}
	
	public int getConnectionRetry() {
		return connectionRetry;
	}

	public void setConnectionRetry(int connectionRetry) {
		this.connectionRetry = connectionRetry;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		if (jdbcFactory!=null)
			return jdbcFactory.toString();
		return super.toString();
	}
}
