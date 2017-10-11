package ddc.task.impl;

import ddc.email.LiteMailConfig;
import ddc.ftp.FtpLiteConfig;
import ddc.support.util.Clone;
import ddc.task.model.HttpConfig;

public class ItemConfig {
	private String name = "TaskName";
	private boolean enabled = true;
	private boolean simulate = true;
	private String remoteFileMatcher = "prefix-*.csv";
//	private String targetFolder = "/target/folder/";
	private CsvConfig csvSource = new CsvConfig();
	private CsvConfig csvTarget = new CsvConfig();
	private HttpConfig api = new HttpConfig();
	private FtpLiteConfig ftpDownload = new FtpLiteConfig();
	private FtpLiteConfig ftpUpload = new FtpLiteConfig();
	private LiteMailConfig mailConfig = new LiteMailConfig();

	public ItemConfig clone() throws CloneNotSupportedException {
		ItemConfig c = (ItemConfig) Clone.clone(this);
		c.setApi((HttpConfig)Clone.clone(this.getApi()));
		c.setCsvSource((CsvConfig)Clone.clone(this.getCsvSource()));
		c.setCsvTarget((CsvConfig)Clone.clone(this.getCsvTarget()));
		c.setFtpDownload((FtpLiteConfig)Clone.clone(this.getFtpDownload()));
		c.setFtpUpload((FtpLiteConfig)Clone.clone(this.getFtpUpload()));
		c.setMailConfig((LiteMailConfig)Clone.clone(this.getMailConfig()));
		return c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isSimulate() {
		return simulate;
	}

	public void setSimulate(boolean simulate) {
		this.simulate = simulate;
	}

	public String getRemoteFileMatcher() {
		return remoteFileMatcher;
	}

	public void setRemoteFileMatcher(String remoteFileMatcher) {
		this.remoteFileMatcher = remoteFileMatcher;
	}

	public CsvConfig getCsvSource() {
		return csvSource;
	}

	public void setCsvSource(CsvConfig csvSource) {
		this.csvSource = csvSource;
	}

	public CsvConfig getCsvTarget() {
		return csvTarget;
	}

	public void setCsvTarget(CsvConfig csvTarget) {
		this.csvTarget = csvTarget;
	}

	public HttpConfig getApi() {
		return api;
	}

	public void setApi(HttpConfig api) {
		this.api = api;
	}

	public FtpLiteConfig getFtpDownload() {
		return ftpDownload;
	}

	public void setFtpDownload(FtpLiteConfig ftpDownload) {
		this.ftpDownload = ftpDownload;
	}

	public FtpLiteConfig getFtpUpload() {
		return ftpUpload;
	}

	public void setFtpUpload(FtpLiteConfig ftpUpload) {
		this.ftpUpload = ftpUpload;
	}

	public LiteMailConfig getMailConfig() {
		return mailConfig;
	}

	public void setMailConfig(LiteMailConfig mailConfig) {
		this.mailConfig = mailConfig;
	}
}
