package com.egfbank.mq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egfbank.account.utils.EgfDateUtils;
import com.egfbank.mq.egfenum.EgfTopicInfoEnum;
import com.egfbank.mq.message.EgfMessage;
import com.egfbank.mq.message.EgfSendResult;
import com.egfbank.mq.producer.impl.DefaultEgfProducer;
import com.egfbank.serialize.Person;

public class EgfProducerTest {

	public static void main(String[] args) {
		String configXml ="classpath:testconfig/spring-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configXml);
		 
		
		 
		String topic = EgfTopicInfoEnum.topicTestE.getTopicName();
		String tag = EgfTopicInfoEnum.topicTestE.getTagName();
		DefaultEgfProducer producer = context.getBean(DefaultEgfProducer.class);
		 
		for(int i=0;i<24;i++){
			String msgKey = EgfDateUtils.formateCurrentDateTime();
			Person person = new Person("tom",i+30,"male"); 	 
			EgfMessage egfMessage= new EgfMessage(msgKey,person);
			EgfSendResult sendResult = producer.sendMessage(topic,tag,egfMessage);
			System.out.println("msgId->"+sendResult.getMsgId()+",msgKey->"+msgKey);
		}
		
 
	}

}
