package com.egfbank.framework.springstudy.chap02.xmlbean;

import java.util.Set;

public class SessionIPService {
	
	private Set<IPMessage> ipServices;

	public SessionIPService(Set<IPMessage> ipServices) {
		super();
		this.ipServices = ipServices;
	}

	public Set<IPMessage> getIpServices() {
		return ipServices;
	}

	public void setIpServices(Set<IPMessage> ipServices) {
		this.ipServices = ipServices;
	}
	
	
}
