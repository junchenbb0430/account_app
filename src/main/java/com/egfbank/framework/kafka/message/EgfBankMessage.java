/**
 * 
 */
package com.egfbank.framework.kafka.message;

import java.io.Serializable;

/**
 * @author tonny
 *主要用于网络传输使用
 */
public class EgfBankMessage<K,V> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2608877589710174384L;
	
	
	private String topicName;
	
	private int partition;
	
	private K key;
	
	private V value;
	
	private long timestamp;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getPartition() {
		return partition;
	}

	public void setPartition(int partition) {
		this.partition = partition;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	 

}
