package com.egfbank.mq.consumer.push;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.egfbank.mq.consumer.status.EgfConsumeStatus;
import com.egfbank.mq.message.EgfReceiveMessage;
import com.egfbank.serialize.EgfJdkSerializeService;
/**
 * 
 * @author tonny
 *
 */
public abstract class AbstractEgfMQPushConsumer implements MessageListenerConcurrently{

	/**
	 * 推模式的consumer
	 */
	private DefaultMQPushConsumer consumer;
	
	/**
	 * 消费者应用组
	 */
	private String consumerGroup;
	
	/**
	 * nameServer地址，支持ip:port,ip:port模式
	 */
	private String namesrvAddr;
	
	/**
	 * 应用实例名称
	 */
	private String instanceName;
	
	/**
	 * topic名称
	 */
	private String topicName;
	
	/**
	 * topic下面的消息类型标识
	 */
	private String tags;
	/**
	 * 消费者最少线程数
	 */
	private int consumeThreadMin = 6;
	
	/**
	 * 消费者最大线程数
	 */
	private int consumeThreadMax = 10;
	
	/**
	 * -1：消费失败，直接进入死信队列；
	 * 0：broker控制重新消费策略
	 * >0:consumer控制消费策略
	 */
	private int delayLevel=0;
	
	public void init(){
		consumer = new DefaultMQPushConsumer();
		consumer.setConsumerGroup(consumerGroup);
		consumer.setInstanceName(instanceName);
		consumer.setNamesrvAddr(namesrvAddr);
		consumer.setConsumeThreadMin(consumeThreadMin);
		consumer.setConsumeThreadMax(consumeThreadMax);
		consumer.registerMessageListener(this);
		/**
		 * 第一次从开始位置进行消费
		 */
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		try {
			consumer.subscribe(topicName, tags);
			consumer.start();
			System.out.println("consumer started !");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
			ConsumeConcurrentlyContext context) {
		 
		if(null == msgs||msgs.size()!=1){
			 return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		 }
		  
		  EgfReceiveMessage receiveMsg =  generateEgfMessage(msgs.get(0));
		  EgfConsumeStatus consumeStatus =  doConsume(receiveMsg);
		  if(EgfConsumeStatus.SUCCESS == consumeStatus){
			  return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		  }else{
			  context.setDelayLevelWhenNextConsume(delayLevel);
			  return ConsumeConcurrentlyStatus.RECONSUME_LATER;

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

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public DefaultMQPushConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(DefaultMQPushConsumer consumer) {
		this.consumer = consumer;
	}

	public int getConsumeThreadMin() {
		return consumeThreadMin;
	}

	public void setConsumeThreadMin(int consumeThreadMin) {
		this.consumeThreadMin = consumeThreadMin;
	}

	public int getConsumeThreadMax() {
		return consumeThreadMax;
	}

	public void setConsumeThreadMax(int consumeThreadMax) {
		this.consumeThreadMax = consumeThreadMax;
	}

	public int getDelayLevel() {
		return delayLevel;
	}

	public void setDelayLevel(int delayLevel) {
		this.delayLevel = delayLevel;
	}

	
	
	
}
