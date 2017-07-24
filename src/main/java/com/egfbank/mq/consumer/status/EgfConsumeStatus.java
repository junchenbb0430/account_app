package com.egfbank.mq.consumer.status;

public enum EgfConsumeStatus {
	
	/**
	 * 消息消费成功
	 */
	SUCCESS,
	
	/**
	 * 消费失败
	 */
	LATER,
	
	/**
	 * 消息失败
	 */
	FALIURE;
}
