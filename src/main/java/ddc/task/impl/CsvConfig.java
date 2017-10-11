package ddc.task.impl;

public class CsvConfig {
	private String path="csv/source/folder";
	private boolean removeHeader=false;
	private char eol='\n';
	private char delimiter=',';		
	private char enclose='"';		
	private char escape='\\';		
	private String headerFile = "";
	//
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRemoveHeader() {
		return removeHeader;
	}
	public void setRemoveHeader(boolean removeHeader) {
		this.removeHeader = removeHeader;
	}
	public char getEol() {
		return eol;
	}
	public void setEol(char eol) {
		this.eol = eol;
	}
	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	public String getHeaderFile() {
		return headerFile;
	}
	public void setHeaderFile(String headerFile) {
		this.headerFile = headerFile;
	}
	public char getEnclose() {
		return enclose;
	}
	public void setEnclose(char enclose) {
		this.enclose = enclose;
	}
	public char getEscape() {
		return escape;
	}
	public void setEscape(char escape) {
		this.escape = escape;
	}

}

