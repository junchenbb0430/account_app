package com.egfbank.framework.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperDemoSession implements Watcher{
	private static CountDownLatch semaphore = new CountDownLatch(1);
	public static void main(String[] args) {
		String connectStr = "192.168.121.13:2181"; 
		try {
			ZooKeeper zk = new ZooKeeper(connectStr,5000,new ZooKeeperDemoSession());
			semaphore.await();//挂起当前线程
			long sessionId = zk.getSessionId();
			byte[] passwd = zk.getSessionPasswd();
			System.out.println("sessionId-->"+sessionId+", passwd-->"+passwd);
			// 使用错误的sessionId和sessionPasswd
			ZooKeeper zkfail  = new ZooKeeper(connectStr,5000,new ZooKeeperDemoSession(),1,"test".getBytes());
			
			//使用正确的sessionId和sessionPasswd
			zk = new ZooKeeper(connectStr,5000,new ZooKeeperDemoSession(),sessionId,passwd);
			Thread.sleep(5000);
			System.out.println("sessionId-->"+zk.getSessionId()+", passwd-->"+zk.getSessionPasswd());
			System.out.println("finish");
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
	}

	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("receive ZooKeeper state : "+event.getState()+",Type: "+event.getType());
		
		if(KeeperState.SyncConnected==event.getState()){
			semaphore.countDown();
		}
	}

}
