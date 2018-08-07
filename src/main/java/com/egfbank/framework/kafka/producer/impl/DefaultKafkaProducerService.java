package com.egfbank.framework.kafka.producer.impl;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.egfbank.framework.kafka.KafkaUtil;
import com.egfbank.framework.kafka.message.MessageSendResult;
import com.egfbank.framework.kafka.producer.EgfBankKafkaProducerService;
import com.egfbank.framework.utils.EgfDateUtils;

public class DefaultKafkaProducerService<K,V> implements EgfBankKafkaProducerService<K,V>  {

	
	private Producer<K,V> producer = null;
	
	private Properties props = null;
	
	/**
	 * 
	 */
	private String bootstrapServer = null;
	
	private int acts = 1;
	
	/**
	 * 
	 */
	private String keySerializer = null;
	
	/**
	 * 
	 */
	private String valueSerializer = null;
	
	
	public void init(){
		checkProducerParameter();
		producer = new KafkaProducer<K,V>(props);
	}
	
	
	
	public DefaultKafkaProducerService() {
		this.init();
	}



	public void checkProducerParameter(){
		props = KafkaUtil.loadProperties();
		bootstrapServer = props.getProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG);
		keySerializer = props.getProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG);
		valueSerializer = props.getProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG);
		 
	}
	
	/**
	 * 同步发送消息
	 */
	public MessageSendResult sendSyncMessages(ProducerRecord<K,V> producerData) {
		Future<RecordMetadata> future = producer.send(producerData);
		MessageSendResult sendResult = new MessageSendResult();
		try {
			sendResult = generateSendResult(future);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return sendResult;
	}

	public MessageSendResult sendAsyncMessages(ProducerRecord<K,V> producerData) {
		producer.send(producerData, new Callback(){
		public void onCompletion(RecordMetadata metadata,
					Exception exception) {
				 
				
			}});
		return null;
	}
	
	
	
	private MessageSendResult generateSendResult(Future<RecordMetadata> future) throws InterruptedException, ExecutionException{
		MessageSendResult sendResult = new MessageSendResult();
		RecordMetadata record = future.get();
		sendResult.setOffset(record.offset());
		sendResult.setPartition(record.partition());
		sendResult.setTimeStamp(record.timestamp());
		sendResult.setTopicName(record.topic());
		 
		return sendResult;
	}
	
	 
	
	public Producer<K, V> getProducer() {
		return producer;
	}


	public void setProducer(Producer<K, V> producer) {
		this.producer = producer;
	}


	public Properties getProps() {
		return props;
	}


	public void setProps(Properties props) {
		this.props = props;
	}


	public String getBootstrapServer() {
		return bootstrapServer;
	}


	public void setBootstrapServer(String bootstrapServer) {
		this.bootstrapServer = bootstrapServer;
	}


	public int getActs() {
		return acts;
	}


	public void setActs(int acts) {
		this.acts = acts;
	}


	public String getKeySerializer() {
		return keySerializer;
	}


	public void setKeySerializer(String keySerializer) {
		this.keySerializer = keySerializer;
	}


	public String getValueSerializer() {
		return valueSerializer;
	}


	public void setValueSerializer(String valueSerializer) {
		this.valueSerializer = valueSerializer;
	}


	public  static void main(String[] args){
		String topicName = "egf-payment";
		
		DefaultKafkaProducerService defaultProducer = new DefaultKafkaProducerService();
		for(int i=0;i<20;i++){
			String key = EgfDateUtils.formateCurrentDate();
			String value = key+"____"+i;
			ProducerRecord record = new ProducerRecord(topicName,key,value);
			MessageSendResult sendResult = defaultProducer.sendSyncMessages(record);
			System.out.println("send message : "+sendResult.toString()+"key=["+key+"],[value=["+value+"]");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
