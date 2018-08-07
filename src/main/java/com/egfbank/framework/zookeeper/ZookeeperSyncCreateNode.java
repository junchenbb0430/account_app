package com.egfbank.framework.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.egfbank.framework.utils.EgfDateUtils;
import com.egfbank.framework.zookeeper.factory.ZooKeeperFactory;

public class ZookeeperSyncCreateNode implements Watcher {
	// 同步类
	private static CountDownLatch semaphore = new CountDownLatch(1);
	
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("watchedEvent event : "+event);
		if(KeeperState.SyncConnected == event.getState()){
			semaphore.countDown();
		}
	}
	
	public static void main(String[] args){
		 
		String path = "/zk-order";
		try {
			ZooKeeper zk =ZooKeeperFactory.newZooKeeperInstance(new ZookeeperSyncCreateNode())  ;
			semaphore.await();
			String actualPath = zk.create(path, EgfDateUtils.formateCurrentDate().getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println("success create znode = "+actualPath);
			 
			String ephemeralNode = zk.create("/zk-order/subOrder", EgfDateUtils.formateCurrentDate().getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			System.out.println("success create ephemeral znode = "+ephemeralNode);
			Thread.sleep(10000);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
