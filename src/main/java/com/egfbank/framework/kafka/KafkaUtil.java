package com.egfbank.framework.kafka;

import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

public class KafkaUtil  {

	 
	private static Producer producer = null;
	 
	private static String FILE_NAME = "/config/kafka-config.properties";
	
	public static Producer createProducer(){
		if(null == producer){
			Properties props = loadProperties();
			producer = new KafkaProducer(props); 
		}
		
		return producer;
	}
	
	
	public static Consumer createConsumer(){
		
		Properties props = loadProperties();
		return  new KafkaConsumer(props);
	}
	
	public static Properties loadProperties(){
		Properties props = new Properties();
		
		try {
			InputStream inputStream = KafkaUtil.class.getResourceAsStream(FILE_NAME);
			 
			 props.load(inputStream);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	
	
	public static void main(String[] args){
		KafkaUtil.loadProperties();
	}
}
