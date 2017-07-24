package com.egfbank.rpc.response;

import java.io.Serializable;

public class MessageResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6980175366701480559L;
	
	private String messageId;
	
	private String status;
	
	private String resCode;
	
	private String acctSerialNo;

	
	
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getAcctSerialNo() {
		return acctSerialNo;
	}

	public void setAcctSerialNo(String acctSerialNo) {
		this.acctSerialNo = acctSerialNo;
	}

	@Override
	public String toString() {
		return "MessageResponse [messageId=" + messageId + ", status=" + status
				+ ", resCode=" + resCode + ", acctSerialNo=" + acctSerialNo
				+ "]";
	}
	
	

}
