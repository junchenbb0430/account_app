package com.egfbank.framework.zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;


public class ZKClientInstance {

	private static volatile ZkClient instance;
	
	private static String zkString= "192.168.121.13:2181,192.168.121.47:2181,192.168.121.48:2181";
	
	private ZKClientInstance(){}
	
	public  static ZkClient newInstance(){
		if(null == instance){
			synchronized(ZKClientInstance.class){
				if(null == instance){
					instance = new ZkClient(zkString);
				}
			}
		}
		return instance;
	}
	
}
