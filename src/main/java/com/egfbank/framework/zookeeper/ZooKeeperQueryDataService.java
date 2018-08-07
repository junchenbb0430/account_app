package com.egfbank.framework.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.egfbank.framework.zookeeper.factory.ZooKeeperFactory;

public class ZooKeeperQueryDataService implements Watcher {

	private static CountDownLatch semaphore = new CountDownLatch(1);
	
	private static ZooKeeper zk = null;
	
	private static Stat state = new Stat();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  zk = ZooKeeperFactory.newZooKeeperInstance( new ZooKeeperQueryDataService());
		try {
			semaphore.await();
			String path = "/zk-root/trans/fastpay";
			byte[]  dataContent = zk.getData(path, true, state);
			 System.out.println(path+" : " + new String(dataContent));
			 System.out.println("stat : "+ state.getVersion());
			  
			 zk.setData(path, "2016071".getBytes(), state.getVersion());
			 
			 Thread.sleep(20000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void process(WatchedEvent event) {
		 
		System.out.println("[ WatchedEvent ]: "+event);
		if(KeeperState.SyncConnected == event.getState()){
			if(EventType.None == event.getType()&&null == event.getPath()){
				semaphore.countDown();
			}else if(EventType.NodeDataChanged ==event.getType()){
				 
				try {
					 System.out.println(" new data  : " + new String(zk.getData(event.getPath(), true, state)));
					 System.out.println("new state : "+state.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
				 
			}
		} 
	}
	}
}
