package com.egfbank.mq.consumer.pull;

import java.util.List;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.consumer.PullStatus;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.egfbank.mq.consumer.EgfBankMQPullConsume;
import com.egfbank.mq.consumer.status.EgfConsumeStatus;
import com.egfbank.mq.message.EgfReceiveMessage;
import com.egfbank.serialize.EgfJdkSerializeService;

public abstract class AbstractEgfMQPullConsume implements EgfBankMQPullConsume {

	private DefaultMQPullConsumer consumer;
	
	private String consumerGroup;
	
	private String namesrvAddr;
	
	private String instanceName;
	
	private String topic;
	
	private String tag;
	
	
	public void init(){
		consumer = new DefaultMQPullConsumer();
		validate();
		consumer.setConsumerGroup(consumerGroup);
		consumer.setNamesrvAddr(namesrvAddr);
		consumer.setInstanceName(instanceName);
		
		try {
			consumer.start();
			System.out.println("****pull consumer started!***");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consumeMessage(String topic, String tag) {
		  try { 
			  Set<MessageQueue> queuelist = consumer.fetchSubscribeMessageQueues(topic);
			  for(MessageQueue queue:queuelist){
				  long offset =  consumer.fetchConsumeOffset(queue,true);
				  System.out.println("offset : "+offset);
				  PullResult result =  consumer.pullBlockIfNotFound(queue, tag, offset, 1);
				 
				  if(PullStatus.FOUND.equals(result.getPullStatus())){
					  List<MessageExt> msglist = result.getMsgFoundList();
					  if(null ==msglist||msglist.size()!=1){
						   continue;
					  }
					 
					  MessageExt msg = msglist.get(0);
					  EgfReceiveMessage receiveMsg = generateEgfMessage(msg);
					  EgfConsumeStatus status= doConsume(receiveMsg);
					  if(EgfConsumeStatus.SUCCESS.equals(status)){
						// 消费成功之后，更新offset
						consumer.updateConsumeOffset(queue, result.getNextBeginOffset());
					  }
				  }else{
					  continue;
				  }		 
				  
			  }
		  } catch (MQClientException e) {
			 
			e.printStackTrace();
		} catch (RemotingException e) {
			 
			e.printStackTrace();
		} catch (MQBrokerException e) {
			 
			e.printStackTrace();
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
		 
	}

	public void validate(){
		if(StringUtils.isEmpty(this.getConsumerGroup())){
			throw new IllegalArgumentException("consumerGroup is null : "+consumerGroup);
		}
		
		if(StringUtils.isEmpty(this.getInstanceName())){
			throw new IllegalArgumentException("instanceName is null : "+instanceName);
		}
		
		if(StringUtils.isEmpty(this.getNamesrvAddr())){
			throw new IllegalArgumentException("namesrvAddr is null : "+namesrvAddr);
		}
		
		 
	}
	
	public abstract EgfConsumeStatus doConsume(EgfReceiveMessage receiveMsg);

	private EgfReceiveMessage generateEgfMessage(MessageExt msg){
		EgfReceiveMessage receiveMsg = new EgfReceiveMessage();
		byte[] body = msg.getBody();
		  Object obj = EgfJdkSerializeService.deserializeBytes2Object(body);
		  receiveMsg.setObj(obj);
			 receiveMsg.setBornHost(msg.getBornHost());
			 receiveMsg.setBornTimestamp(msg.getBornTimestamp());
			 receiveMsg.setMsgId(msg.getMsgId());
			 receiveMsg.setMsgKey(msg.getKeys());
			 receiveMsg.setQueueOffset(msg.getQueueOffset());
			 receiveMsg.setQueueId(msg.getQueueId());
			 receiveMsg.setReconsumeTimes(msg.getReconsumeTimes());
			 receiveMsg.setStoreHost(msg.getStoreHost());
			 receiveMsg.setStoreTimestamp(msg.getStoreTimestamp());
			 receiveMsg.setCommitLogOffset(msg.getCommitLogOffset());
		  return receiveMsg;
	}
	
	public DefaultMQPullConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(DefaultMQPullConsumer consumer) {
		this.consumer = consumer;
	}

	public String getConsumerGroup() {
		return consumerGroup;
	}

	public void setConsumerGroup(String consumerGroup) {
		this.consumerGroup = consumerGroup;
	}

	public String getNamesrvAddr() {
		return namesrvAddr;
	}

	public void setNamesrvAddr(String namesrvAddr) {
		this.namesrvAddr = namesrvAddr;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	
	
}
