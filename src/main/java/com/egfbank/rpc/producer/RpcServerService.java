package com.egfbank.rpc.producer;

import com.egfbank.rpc.request.MessageRequest;
import com.egfbank.rpc.response.MessageResponse;

public interface RpcServerService {

	String sendHvpsMessage(String message);
	
	String sendBepsDebtMessage(String message);
	
	MessageResponse openAccount(MessageRequest request);
}
