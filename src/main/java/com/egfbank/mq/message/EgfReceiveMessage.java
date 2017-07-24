package com.egfbank.mq.message;

import java.net.SocketAddress;

public class EgfReceiveMessage extends EgfMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1449548620507702293L;

	/**
	 * 消息队列ID
	 */
	private int queueId;
	
	/**
	 * 消息id
	 */
	private String msgId;
	
	/**
	 * 队列偏移量
	 */
	private long queueOffset;
	
	/**
	 * 消息在commitLog中的offset位置
	 */
	private long commitLogOffset;
	
	/**
	 * 队列存储大小
	 */
	private int storeSieze;
	
	/**
	 * 消息在客户端时间戳
	 */
    private long bornTimestamp;
    /**
     * 消息来源
     */
    private SocketAddress bornHost;
    /**
     * 消息在服务器存储时间戳
     */
    private long storeTimestamp;
    /**
     * 消息存储服务器
     */
    private SocketAddress storeHost;
    
    /**
     * 消息被消费了几次
     */
    private int reconsumeTimes;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public long getQueueOffset() {
		return queueOffset;
	}

	public void setQueueOffset(long queueOffset) {
		this.queueOffset = queueOffset;
	}

	public int getStoreSieze() {
		return storeSieze;
	}

	public void setStoreSieze(int storeSieze) {
		this.storeSieze = storeSieze;
	}

	public long getBornTimestamp() {
		return bornTimestamp;
	}

	public void setBornTimestamp(long bornTimestamp) {
		this.bornTimestamp = bornTimestamp;
	}

	public SocketAddress getBornHost() {
		return bornHost;
	}

	public void setBornHost(SocketAddress bornHost) {
		this.bornHost = bornHost;
	}

	public long getStoreTimestamp() {
		return storeTimestamp;
	}

	public void setStoreTimestamp(long storeTimestamp) {
		this.storeTimestamp = storeTimestamp;
	}

	public SocketAddress getStoreHost() {
		return storeHost;
	}

	public void setStoreHost(SocketAddress storeHost) {
		this.storeHost = storeHost;
	}

	public int getReconsumeTimes() {
		return reconsumeTimes;
	}

	public void setReconsumeTimes(int reconsumeTimes) {
		this.reconsumeTimes = reconsumeTimes;
	}

	public int getQueueId() {
		return queueId;
	}

	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}

	public long getCommitLogOffset() {
		return commitLogOffset;
	}

	public void setCommitLogOffset(long commitLogOffset) {
		this.commitLogOffset = commitLogOffset;
	}
    
    
}
