package ddc.task.impl;

import java.time.Duration;

public class RetryConfig {
	private int maxRetries = 1;
	private long minRetryIntervallMillis = Duration.ofHours(1).toMillis();
	private long resetCountersAfterMillis = Duration.ofHours(24).toMillis();
	
	public int getMaxRetries() {
		return maxRetries;
	}
	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}
	public long getMinRetryIntervallMillis() {
		return minRetryIntervallMillis;
	}
	public void setMinRetryIntervallMillis(long minRetryIntervallMillis) {
		this.minRetryIntervallMillis = minRetryIntervallMillis;
	}
	public long getResetCountersAfterMillis() {
		return resetCountersAfterMillis;
	}
	public void setResetCountersAfterMillis(long resetCountersAfterMillis) {
		this.resetCountersAfterMillis = resetCountersAfterMillis;
	}
	
	
}
