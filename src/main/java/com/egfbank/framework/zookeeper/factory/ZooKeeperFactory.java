package com.egfbank.framework.zookeeper.factory;

import java.io.IOException;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;


public class ZooKeeperFactory {

	private static String connectStr = "192.168.121.13:2181,192.168.121.47:2181,192.168.121.48:2181";
	private static int sessionTimeout = 5000;
	
	
	public static ZooKeeper newZooKeeperInstance(String connectStr,int sessionOut,Watcher watcher){
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(connectStr,sessionOut,watcher);
		} catch (IOException e) {
			throw  new RuntimeException(e);
			 
		}
		return zk;
	}
	
	public static ZooKeeper newZooKeeperInstance(Watcher watcher){
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(connectStr,sessionTimeout,watcher);
		} catch (IOException e) {
			throw  new RuntimeException(e);
			 
		}
		return zk;
	}
	public static ZooKeeper newZooKeeperInstance(){
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(connectStr,sessionTimeout,null);
		} catch (IOException e) {
			throw  new RuntimeException(e);
			 
		}
		return zk;
	}
	
	
}
