package com.shopingCart.baseResponce;

public class BaseResponce<T> {
	private T t;
	
	private String statusMessage;
	private long statusCode;
	private long timeSramp;
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public long getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public long getTimeSramp() {
		return timeSramp;
	}
	public void setTimeSramp(long timeSramp) {
		this.timeSramp = timeSramp;
	}
	

}
