package com.egfbank.rpc.consumer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egfbank.rpc.consumer.RpcClientService;
import com.egfbank.rpc.producer.RpcServerService;
@Service
public class RpcClientServiceImpl implements RpcClientService {
	
	@Autowired
	private RpcServerService serverService;
	
	public void sendHvpsTrans() {
		 String result = serverService.sendHvpsMessage("hvps.111.001.1");
		 System.out.println(result);
	}

	public void sendBepsDebtTrans() {
		 String result = serverService.sendBepsDebtMessage("beps.121.001.1");
		 System.out.println(result);
	}

	
	
		
}
