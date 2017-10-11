package ddc.task.model;

import ddc.support.util.ParseUtil;

public class FileScannerConfig {
	private String[] paths = new String[] {};
	private boolean recursive = false;
	private String[] includeExtension = new String[] {};
	private String[] escludeExtension = new String[] {};
	private boolean orderBySize = false;
	private String selectOlderThan = "0 millis";

	public String[] getPaths() {
		return paths;
	}

	public void setPaths(String[] paths) {
		this.paths = paths;
	}

	public boolean isRecursive() {
		return recursive;
	}

	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

	public String[] getIncludeExtension() {
		return includeExtension;
	}

	public void setIncludeExtension(String[] includeExtension) {
		this.includeExtension = includeExtension;
	}

	public String[] getEscludeExtension() {
		return escludeExtension;
	}

	public void setEscludeExtension(String[] escludeExtension) {
		this.escludeExtension = escludeExtension;
	}

	public boolean isOrderBySize() {
		return orderBySize;
	}

	public void setOrderBySize(boolean orderBySize) {
		this.orderBySize = orderBySize;
	}
	
	public long getSelectOlderThanMillis() {
		return ParseUtil.parseTimeAndUnit(selectOlderThan);
	}

	public String getSelectOlderThan() {
		return selectOlderThan;
	}

	public void setSelectOlderThan(String selectOlderThan) {
		this.selectOlderThan = selectOlderThan;
	}
}
