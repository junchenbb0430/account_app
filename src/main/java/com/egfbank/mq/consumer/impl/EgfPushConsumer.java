package com.egfbank.mq.consumer.impl;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.egfbank.mq.egfenum.EgfTopicInfoEnum;
import com.egfbank.serialize.ISerializeService;
import com.egfbank.serialize.EgfJdkSerializeService;
import com.egfbank.serialize.Person;

public class EgfPushConsumer {

	 public static void main(String[] args){
		 try{
			 /**
		         * Consumer组名，多个Consumer如果属于一个应用，订阅同样的消息，且消费逻辑一致，则应该将它们归为同一组
		         * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br>
		         * 注意：ConsumerGroupName需要由应用来保证唯一
		         */
		        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumerGroup");
		        consumer.setNamesrvAddr("192.168.121.5:9876");
		        consumer.setInstanceName("Consumber");

		        /**
		         * 订阅指定topic下tags分别等于TagA或TagB或TagC
		         * topicTestA
		         */
		        
		        consumer.subscribe(EgfTopicInfoEnum.topicTestE.getTopicName(), EgfTopicInfoEnum.topicTestE.getTagName());
		        /**
		         * 订阅指定topic下所有消息<br>
		         * 注意：一个consumer对象可以订阅多个topic
		         */
		        /*consumer.subscribe("TopicTest12", "*");*/
		        
		       
		        consumer.registerMessageListener(new MessageListenerConcurrently() {
		        
		            /**
		             * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
		             * consumeThreadMin:消费线程池数量 默认最小值10
		             * consumeThreadMax:消费线程池数量 默认最大值20
		             */
		            public ConsumeConcurrentlyStatus consumeMessage(
		                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		                if(null==msgs||msgs.size()!=1){
		                	return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		                } 
		                MessageExt msg = msgs.get(0);
		                String brokerName = context.getMessageQueue().getBrokerName(); 
		                int queueId = context.getMessageQueue().getQueueId();
		                String topicName = context.getMessageQueue().getTopic();
		                
		                System.out.println("brokerName = "+brokerName+" , topicName = "+topicName+" ,queueId = "+queueId);
		                 byte[] body = msg.getBody();
		                 if(null != body){
		                	 Person person = (Person)EgfJdkSerializeService.deserializeBytes2Object(body);
			                 System.out.println(person.toString());
		                 }
		                
		                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		            }
		        });
		        /**
		         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
		         */
		        consumer.start();
		        System.out.println("Consumer Started.");
		       

		       
		 }catch(Exception e){
			 
		 }
	 }
}
