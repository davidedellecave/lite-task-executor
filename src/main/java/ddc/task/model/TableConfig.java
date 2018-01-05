package ddc.task.model;

public class TableConfig {
	private boolean enabled;
	private String table;
	private String columns;
	private int maxrows = -1;
	private String selectScriptFile;
	
	public TableConfig clone() {
		TableConfig t = new TableConfig();		
		t.setColumns(this.columns);
		t.setEnabled(this.enabled);
		t.setMaxrows(this.maxrows);
		t.setTable(this.table);
		t.setSelectScriptFile(this.selectScriptFile);
		return t;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = columns;
	}
	public int getMaxrows() {
		return maxrows;
	}
	public void setMaxrows(int maxrows) {
		this.maxrows = maxrows;
	}
	public String getSelectScriptFile() {
		return selectScriptFile;
	}
	public void setSelectScriptFile(String selectScriptFile) {
		this.selectScriptFile = selectScriptFile;
	}
}
