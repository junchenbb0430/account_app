package com.egfbank.framework.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

/**
 * Hello world!
 *
 */
public class ZookeeperDemoOne implements Watcher
{
	static CountDownLatch cdl = new CountDownLatch(1);
    public static void main( String[] args )
    {
       
    	//ZooKeeper zookeeper = new ZooKeeper("192.168.121.3:2181",5000);
    	 
    	try {
			ZooKeeper zk = new ZooKeeper("192.168.121.48:2181",5000,new ZookeeperDemoOne());
			
			try {
				cdl.await();
				System.out.println(zk.getState());
				System.out.println(zk.getState());
				System.out.println("sessionId---->"+zk.getSessionId());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("finish");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public void process(WatchedEvent event) {
		System.out.println("receive watched event :"+event); 
		System.out.println("event state :"+event.getState());
		if(KeeperState.SyncConnected == event.getState()){
			cdl.countDown();
		}
	}
}
