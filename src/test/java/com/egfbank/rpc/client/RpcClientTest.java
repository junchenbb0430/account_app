package com.egfbank.rpc.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egfbank.account.utils.EgfDateUtils;
import com.egfbank.rpc.consumer.impl.RpcClientServiceImpl;
import com.egfbank.rpc.producer.RpcServerService;
import com.egfbank.rpc.request.MessageRequest;
import com.egfbank.rpc.response.MessageResponse;

public class RpcClientTest {

	public static void main(String[] args) {
		String fileName= "classpath:config/rpc-consumer-context.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(fileName);
		RpcClientServiceImpl client = context.getBean(RpcClientServiceImpl.class);
		RpcServerService rpcService = (RpcServerService)context.getBean("rpcServerService");
		client.sendBepsDebtTrans();
		client.sendHvpsTrans();
		MessageRequest request = new MessageRequest();
		request.setMessageId(EgfDateUtils.formateCurrentDate());
		MessageResponse response = rpcService.openAccount(request);
		System.out.println(response.getAcctSerialNo());
	}

}
