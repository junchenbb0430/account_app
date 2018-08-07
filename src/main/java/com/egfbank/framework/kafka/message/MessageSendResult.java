/**
 * 
 */
package com.egfbank.framework.kafka.message;

import java.io.Serializable;

/**
 * @author tonny
 *
 */
public class MessageSendResult implements Serializable{
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3535313815216025836L;

	/**
	 * 主题
	 */
	private String topicName;
	
	/**
	 * 偏移量
	 */
	private long offset; 
	
	/**
	 * 具体partition
	 */
	private int partition;
	
	/**
	 * 发送时间戳
	 */
	private long timeStamp;
	
	/**
	 * 
	 */
	private int serializedKeySize;
	
	/**
	 * 
	 */
	private int serializedValueSize;

	
	
	public int getSerializedKeySize() {
		return serializedKeySize;
	}

	public void setSerializedKeySize(int serializedKeySize) {
		this.serializedKeySize = serializedKeySize;
	}

	public int getSerializedValueSize() {
		return serializedValueSize;
	}

	public void setSerializedValueSize(int serializedValueSize) {
		this.serializedValueSize = serializedValueSize;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public int getPartition() {
		return partition;
	}

	public void setPartition(int partition) {
		this.partition = partition;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[topic="+topicName+"],[partition="+this.partition+"],[offset="+offset+"],"
				+ "[serializedKeySize="+this.serializedKeySize+"],[serializedValueSize="+this.serializedValueSize+"]";
	}
	
	
	
}
