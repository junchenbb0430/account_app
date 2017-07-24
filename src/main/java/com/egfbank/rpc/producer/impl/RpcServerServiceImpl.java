package com.egfbank.rpc.producer.impl;

import com.egfbank.account.utils.EgfDateUtils;
import com.egfbank.rpc.producer.RpcServerService;
import com.egfbank.rpc.request.MessageRequest;
import com.egfbank.rpc.response.MessageResponse;

public class RpcServerServiceImpl implements RpcServerService {

	public String sendHvpsMessage(String message) {
		
		return "HVPS : "+message;
	}

	public String sendBepsDebtMessage(String message) {
		// TODO Auto-generated method stub
		return "BEPS : "+message;
	}

	public MessageResponse openAccount(MessageRequest request) {
		 MessageResponse response = new MessageResponse();
		 response.setMessageId(request.getMessageId());
		 response.setAcctSerialNo(EgfDateUtils.formateCurrentDateTime());
		 response.setResCode("0000");
		 response.setStatus("S");
		return response;
	}

}
