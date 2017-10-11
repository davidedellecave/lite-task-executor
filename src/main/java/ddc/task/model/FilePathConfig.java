package ddc.task.model;

public class FilePathConfig {
	private FileScannerConfig sourceScannerConfig = null;
	private String targetFilename=null;
	private String targetRelativePath=null;
	private String targetBasePath=null;
	private boolean gzipTargetFile=false;
	//
	private String tempFilename=null;
	private String tempRelativePath=null;
	private String tempBasePath=null;
	//
	private String reportFilename=null;
	private String reportRelativePath=null;
	private String reportBasePath=null;
	private boolean reportAppendMode=false;
	//
	private boolean createDirectories=false;
	private boolean overwriteTargetFile=false;
	private boolean preserveLastModifiedDate=false;
	private boolean overwriteChangedTargetFile=false;
	//
	private boolean deleteSourceFile=false;
	private boolean deleteTargetFile=false;
	private boolean deleteReportFile=false;
	
	public FileScannerConfig getSourceScannerConfig() {
		return sourceScannerConfig;
	}
	public void setSourceScannerConfig(FileScannerConfig sourceScannerConfig) {
		this.sourceScannerConfig = sourceScannerConfig;
	}
	public String getTargetFilename() {
		return targetFilename;
	}
	public void setTargetFilename(String targetFilename) {
		this.targetFilename = targetFilename;
	}
	public String getTargetRelativePath() {
		return targetRelativePath;
	}
	public void setTargetRelativePath(String targetRelativePath) {
		this.targetRelativePath = targetRelativePath;
	}
	public String getTargetBasePath() {
		return targetBasePath;
	}
	public void setTargetBasePath(String targetBasePath) {
		this.targetBasePath = targetBasePath;
	}
	public boolean isGzipTargetFile() {
		return gzipTargetFile;
	}
	public void setGzipTargetFile(boolean gzipTargetFile) {
		this.gzipTargetFile = gzipTargetFile;
	}
	public String getTempFilename() {
		return tempFilename;
	}
	public void setTempFilename(String tempFilename) {
		this.tempFilename = tempFilename;
	}
	public String getTempRelativePath() {
		return tempRelativePath;
	}
	public void setTempRelativePath(String tempRelativePath) {
		this.tempRelativePath = tempRelativePath;
	}
	public String getTempBasePath() {
		return tempBasePath;
	}
	public void setTempBasePath(String tempBasePath) {
		this.tempBasePath = tempBasePath;
	}
	public String getReportFilename() {
		return reportFilename;
	}
	public void setReportFilename(String reportFilename) {
		this.reportFilename = reportFilename;
	}
	public String getReportRelativePath() {
		return reportRelativePath;
	}
	public void setReportRelativePath(String reportRelativePath) {
		this.reportRelativePath = reportRelativePath;
	}
	public String getReportBasePath() {
		return reportBasePath;
	}
	public void setReportBasePath(String reportBasePath) {
		this.reportBasePath = reportBasePath;
	}
	public boolean isReportAppendMode() {
		return reportAppendMode;
	}
	public void setReportAppendMode(boolean reportAppendMode) {
		this.reportAppendMode = reportAppendMode;
	}
	public boolean isCreateDirectories() {
		return createDirectories;
	}
	public void setCreateDirectories(boolean createDirectories) {
		this.createDirectories = createDirectories;
	}
	public boolean isOverwriteTargetFile() {
		return overwriteTargetFile;
	}
	public void setOverwriteTargetFile(boolean overwriteTargetFile) {
		this.overwriteTargetFile = overwriteTargetFile;
	}
	public boolean isPreserveLastModifiedDate() {
		return preserveLastModifiedDate;
	}
	public void setPreserveLastModifiedDate(boolean preserveLastModifiedDate) {
		this.preserveLastModifiedDate = preserveLastModifiedDate;
	}
	public boolean isOverwriteChangedTargetFile() {
		return overwriteChangedTargetFile;
	}
	public void setOverwriteChangedTargetFile(boolean overwriteChangedTargetFile) {
		this.overwriteChangedTargetFile = overwriteChangedTargetFile;
	}
	public boolean isDeleteSourceFile() {
		return deleteSourceFile;
	}
	public void setDeleteSourceFile(boolean deleteSourceFile) {
		this.deleteSourceFile = deleteSourceFile;
	}
	public boolean isDeleteTargetFile() {
		return deleteTargetFile;
	}
	public void setDeleteTargetFile(boolean deleteTargetFile) {
		this.deleteTargetFile = deleteTargetFile;
	}
	public boolean isDeleteReportFile() {
		return deleteReportFile;
	}
	public void setDeleteReportFile(boolean deleteReportFile) {
		this.deleteReportFile = deleteReportFile;
	}	
}
