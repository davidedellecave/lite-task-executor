package ddc.task.impl;

import java.sql.Connection;
import java.sql.SQLException;

import ddc.support.jdbc.JdbcConnectionFactory;
import ddc.support.jdbc.PooledDatasourceFactory;
import ddc.support.task.Task;

public abstract class SqlDataDTask extends Task {
	private static PooledDatasourceFactory dsFactory = null;

	public PooledDatasourceFactory getDatasourceFactory() {
		if (dsFactory == null) {
			dsFactory = new PooledDatasourceFactory();
		}
		return dsFactory;
	}

	public Connection getConnection(JdbcConnectionFactory connFactory) throws SQLException, ClassNotFoundException {
		return getDatasourceFactory().createDataSource(connFactory).getConnection();
	}

	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed())
			conn.close();
	}

	public void commitAndCloseConnection(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed())
			conn.commit();
		if (conn != null && !conn.isClosed())
			conn.close();
	}
}
