package com.egfbank.mq.consumer.impl;

import java.util.List;
import java.util.Set;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.consumer.PullStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.egfbank.mq.egfenum.EgfTopicInfoEnum;
import com.egfbank.serialize.EgfJdkSerializeService;
import com.egfbank.serialize.Person;
import com.egfbank.serialize.UcfSerializer;


public class EgfPullConsumer {
	 
	public static void main(String[] args) {
		
		
		DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("consuermGroup");
		consumer.setNamesrvAddr("192.168.121.5:9876");
		consumer.setInstanceName("consumer");
		  
		try {
			consumer.start();
			// 队列个数，默认4个，程序自动创建topic，
			// 集群模式创建，列队默认为8个
			Set<MessageQueue> queueList =  consumer.fetchSubscribeMessageQueues(EgfTopicInfoEnum.topicTestE.getTopicName());
			 
			for(MessageQueue queue:queueList){
				System.out.println("message queue info : "+queue.toString());
				// 获取broker存储的offset
				long commitLogOffset = consumer.fetchConsumeOffset(queue, true);
				System.out.println("commitLogOffset = "+commitLogOffset);
				/**
				 * MessageQueue mq：topic中对应的具体消息存储队列
				 * String subExpression：topic中tag
				 *  long offset：从当前位置去拉取消息
				 *  int maxNums：每次最大拉取maxNums-1条消息,最少1条消息
				 */
				PullResult result = consumer
						.pullBlockIfNotFound(queue, EgfTopicInfoEnum.topicTestE.getTagName(), commitLogOffset, 1); 
				// TODO 建议，消息消费成功之后，再去更新offset
				consumer.updateConsumeOffset(queue, result.getNextBeginOffset());
				 
				PullStatus status = result.getPullStatus();
				System.out.println("pull Status : "+status);
				if(PullStatus.FOUND == status){
					List<MessageExt> msgList = result.getMsgFoundList();
					System.out.println("每条消息队列中消息个数 ： "+msgList.size());
					for(MessageExt messageExt:msgList){
						Person person = (Person)UcfSerializer.deSerialize(messageExt.getBody());
						 
						System.out.println("person : "+person.toString());
					}
				}
			}
			Thread.sleep(20*1000);
			consumer.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	 
	
	
}
