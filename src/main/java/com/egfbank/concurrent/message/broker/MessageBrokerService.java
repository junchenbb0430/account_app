package com.egfbank.concurrent.message.broker;

import java.util.ArrayList;
import java.util.List;

/**
 * producer将消息发送至storeService，
 * consumer从storeService中consume消息
 * @author tonny
 * 单例模式，确保只有一个实例
 */
public class MessageBrokerService {
	
	private static MessageBrokerService instance = null;
	
	private static List<String> oneMsgPool = new ArrayList<String>();
	
	private MessageBrokerService(){}
	
	public void putMessage(String msg){
		if(!oneMsgPool.isEmpty()){
			throw new IllegalArgumentException("队列中消息个数不是一个");
		}
		oneMsgPool.add(msg);
	}
	
	public String getMessage(){
		return oneMsgPool.remove(0);
	}
	
	/**
	 * 单例模式
	 * @return
	 */
	public static MessageBrokerService newInstance(){
		if(null == instance){
			synchronized(MessageBrokerService.class){
				if(null == instance){
					instance = new MessageBrokerService();
				}
			}
		}
		return instance;
	}
}
