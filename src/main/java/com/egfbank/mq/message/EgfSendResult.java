package com.egfbank.mq.message;



import com.alibaba.rocketmq.client.producer.SendStatus;
 
public class EgfSendResult   {

	 
	
	 private SendStatus sendStatus;
	 
	 private String msgId;
	 
	 private String msgkey;
	 
	 private long queueOffset;
	 
	 private String topicName;
	 
	 private String brokerName;
	 
	 private String transactionId;

	public SendStatus getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(SendStatus sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public long getQueueOffset() {
		return queueOffset;
	}

	public void setQueueOffset(long queueOffset) {
		this.queueOffset = queueOffset;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	
	
	public String getMsgkey() {
		return msgkey;
	}

	public void setMsgkey(String msgkey) {
		this.msgkey = msgkey;
	}

	@Override
	public String toString() {
		return "EgfSendResult [sendStatus=" + sendStatus + ", msgId=" + msgId
				+ ", msgkey=" + msgkey + ", queueOffset=" + queueOffset
				+ ", topicName=" + topicName + ", brokerName=" + brokerName
				+ ", transactionId=" + transactionId + "]";
	}

 
	 
}
