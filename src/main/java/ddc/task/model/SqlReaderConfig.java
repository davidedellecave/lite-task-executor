package ddc.task.model;

import org.apache.commons.lang3.StringUtils;

import ddc.support.jdbc.JdbcConfig;

public class SqlReaderConfig {
	private JdbcConfig jbdc = null;
	private String sqlTable = null;
	private String sqlColMark = null;
	private String sqlSelectMark = null;
	private String sqlSelectRows = null;
	
	
	public String buildSql(String sql) {
		sql = StringUtils.replace(sql, "$SQLTABLE", sqlTable);		
		sql = StringUtils.replace(sql, "$SQLMARK_NAME", sqlColMark);				
		return sql;
	}
	
	public String buildSql(String sql, String sqlMarkValue) {
		sql = StringUtils.replace(sql, "$SQLTABLE", sqlTable);
		sql = StringUtils.replace(sql, "$SQLMARK_NAME", sqlColMark);
		sql = StringUtils.replace(sql, "$SQLMARK_VALUE", sqlMarkValue);		
		return sql;
	}
	
	public JdbcConfig getJbdc() {
		return jbdc;
	}
	public void setJbdc(JdbcConfig jbdc) {
		this.jbdc = jbdc;
	}
	public String getSqlTable() {
		return sqlTable;
	}
	public void setSqlTable(String sqlTable) {
		this.sqlTable = sqlTable;
	}
	public String getSqlSelectMark() {
		return sqlSelectMark;
	}
	public void setSqlSelectMark(String sqlSelectMark) {
		this.sqlSelectMark = sqlSelectMark;
	}
	public String getSqlSelectRows() {
		return sqlSelectRows;
	}
	public void setSqlSelectRows(String sqlSelectRows) {
		this.sqlSelectRows = sqlSelectRows;
	}

	public String getSqlColMark() {
		return sqlColMark;
	}

	public void setSqlColMark(String sqlColMark) {
		this.sqlColMark = sqlColMark;
	}
}
