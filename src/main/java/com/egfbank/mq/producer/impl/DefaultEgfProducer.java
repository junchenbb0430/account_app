package com.egfbank.mq.producer.impl;



import org.springframework.util.StringUtils;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.egfbank.mq.message.EgfMessage;
import com.egfbank.mq.message.EgfSendResult;
import com.egfbank.mq.producer.EgfBankMQProducer;
import com.egfbank.serialize.ISerializeService;
import com.egfbank.serialize.EgfJdkSerializeService;

public   class DefaultEgfProducer implements EgfBankMQProducer {

	/**
	 * 生产者
	 */
	private DefaultMQProducer producer;
	
	/**
	 * nameServerAddr地址
	 */
	private String namesrvAddr;
	
	/**
	 * 生产者组
	 */
	private String producerGroup;
	
	/**
	 * 实例名字
	 */
	private String instanceName;
	
	 
	
	public void init(){
		
		
		producer = new DefaultMQProducer(producerGroup);
		producer.setNamesrvAddr(namesrvAddr);
		producer.setInstanceName(instanceName);
		try {
			this.validate();
			producer.start();
			System.out.println("producer started !");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EgfSendResult sendMessage(String topicName,String tag,EgfMessage egfMessage) {
		 
		 
		 byte[] body = EgfJdkSerializeService.serializeObject2Byte(egfMessage.getObj());
		 
		 Message message = new Message(topicName,tag,egfMessage.getMsgKey(),body);
		 SendResult sendResult = doSend(message);
		 if(sendResult == null){
			 return null;
		 }	
		 EgfSendResult egfResult= new EgfSendResult();
		 egfResult.setBrokerName(sendResult.getMessageQueue().getBrokerName());
		 egfResult.setMsgId(sendResult.getMsgId());
		 egfResult.setQueueOffset(sendResult.getQueueOffset());
		 egfResult.setTopicName(sendResult.getMessageQueue().getTopic());
		 egfResult.setMsgkey(egfMessage.getMsgKey());
		 egfResult.setSendStatus(sendResult.getSendStatus());
		return egfResult;
	}
	
	private SendResult doSend(Message message){
		 SendResult sendResult = null;
		try {
			sendResult = producer.send(message);
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemotingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MQBrokerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResult;
	}
	
	 
	
	private void validate(){
		 
		if(StringUtils.isEmpty(this.namesrvAddr)){
			throw new IllegalArgumentException(" nameServerAddr is null ");
		}
		
		if(StringUtils.isEmpty(instanceName)){
			throw new IllegalArgumentException(" instanceName is : "+instanceName);
		}
		
		if(StringUtils.isEmpty(producerGroup)){
			throw new IllegalArgumentException(" producerGroup is : "+producerGroup);
		}
	}

	public DefaultMQProducer getProducer() {
		return producer;
	}

	public void setProducer(DefaultMQProducer producer) {
		this.producer = producer;
	}

	 
	public String getNamesrvAddr() {
		return namesrvAddr;
	}

	public void setNamesrvAddr(String namesrvAddr) {
		this.namesrvAddr = namesrvAddr;
	}

	public String getProducerGroup() {
		return producerGroup;
	}

	public void setProducerGroup(String producerGroup) {
		this.producerGroup = producerGroup;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public void destroy(){
		producer.shutdown();
	}
	

}
