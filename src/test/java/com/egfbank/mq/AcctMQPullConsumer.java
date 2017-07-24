package com.egfbank.mq;

import com.egfbank.mq.consumer.pull.AbstractEgfMQPullConsume;
import com.egfbank.mq.consumer.status.EgfConsumeStatus;
import com.egfbank.mq.egfenum.EgfTopicInfoEnum;
import com.egfbank.mq.message.EgfReceiveMessage;
import com.egfbank.serialize.Person;

public class AcctMQPullConsumer extends AbstractEgfMQPullConsume {

	@Override
	public EgfConsumeStatus doConsume(EgfReceiveMessage receiveMsg) {
		Person person = (Person)receiveMsg.getObj();
		System.out.println(person.toString());
		System.out.println("msgId : "+receiveMsg.getMsgId());
		System.out.println("msgKey : "+receiveMsg.getMsgKey());
		return EgfConsumeStatus.SUCCESS;
	}

	public static void main(String[] args) {
		AcctMQPullConsumer acctConsumer = new AcctMQPullConsumer();
		acctConsumer.setConsumerGroup("accountConsumerGroup");
		acctConsumer.setNamesrvAddr("192.168.121.5:9876");
		acctConsumer.setInstanceName("accountConsumer");
		acctConsumer.init();
		acctConsumer.consumeMessage(EgfTopicInfoEnum.topicTestE.getTopicName(),EgfTopicInfoEnum.topicTestE.getTagName()); 
		
	}

}
