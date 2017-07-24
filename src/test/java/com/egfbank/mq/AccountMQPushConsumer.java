package com.egfbank.mq;

import com.egfbank.mq.consumer.push.AbstractEgfMQPushConsumer;
import com.egfbank.mq.consumer.status.EgfConsumeStatus;
import com.egfbank.mq.egfenum.EgfTopicInfoEnum;
import com.egfbank.mq.message.EgfReceiveMessage;
import com.egfbank.serialize.Person;

public class AccountMQPushConsumer extends AbstractEgfMQPushConsumer {

	@Override
	public EgfConsumeStatus doConsume(EgfReceiveMessage receiveMsg) {
		Object obj = receiveMsg.getObj();
		System.out.println(receiveMsg.getObj());
//		Person person = (Person)receiveMsg.getObj();
//		System.out.println(person.toString());
		System.out.println("commitLogOffset : "+receiveMsg.getCommitLogOffset());
		System.out.println("queueOffset : "+receiveMsg.getQueueOffset());
		return EgfConsumeStatus.SUCCESS;
	}

	public static void main(String[] args) {
		AccountMQPushConsumer acctConsumer = new AccountMQPushConsumer();
		acctConsumer.setConsumerGroup("accountConsumerGroup");
		acctConsumer.setNamesrvAddr("192.168.121.5:9876");
		acctConsumer.setInstanceName("accountConsumer");
		acctConsumer.setTopicName(EgfTopicInfoEnum.topicTestE.getTopicName());
		acctConsumer.setTags(EgfTopicInfoEnum.topicTestE.getTagName());
		acctConsumer.init();
		 
	}

}
