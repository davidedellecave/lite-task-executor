package ddc.task.model;

public class HttpConfig {
	public final static String PROPNAME_HTTP_CONFIG="HttpConfig";
	private String endpoint = "http://localhost:8080";
	private String secretKey = "";	
	private int bulkSize = 1;
	//
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public int getBulkSize() {
		return bulkSize;
	}
	public void setBulkSize(int bulkSize) {
		this.bulkSize = bulkSize;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
}
