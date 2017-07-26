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
	
	private   List<String> msgPool = new ArrayList<String>();
	
	
	
	private MessageBrokerService(){}
	
	public int getCapacity(){
		return msgPool.size();
	}
	 
	public void putOneMessage(String msg){
		if(!msgPool.isEmpty()){
			throw new IllegalArgumentException("队列中消息个数不是一个");
		}
		msgPool.add(msg);
	}
	
	public String getMessage(){
		return msgPool.remove(0);
	}
	
	public void  putMessage(String msg){
		msgPool.add(msg);
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
