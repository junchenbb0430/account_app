package com.egfbank.framework.springstudy.chap02.xmlbean;

public class IPMessage {

	private String ip;
	
	private String mac;

	public IPMessage(String ip, String mac) {
		super();
		this.ip = ip;
		this.mac = mac;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	
}
