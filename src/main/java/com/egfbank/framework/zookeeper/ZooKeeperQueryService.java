package com.egfbank.framework.zookeeper;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.egfbank.framework.zookeeper.factory.ZooKeeperFactory;

public class ZooKeeperQueryService implements Watcher{

	private static CountDownLatch semaphore = new CountDownLatch(1);
	
	private static ZooKeeper zk = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  zk = ZooKeeperFactory.newZooKeeperInstance( new ZooKeeperQueryService());
		try {
			semaphore.await();
			String path = "/zk-root/trans";
			 List<String>  pathList = zk.getChildren(path, new ZooKeeperQueryService());
			 System.out.println("nodeList : "+pathList);
			 String currentNode= zk.create (path+"/fastpay", "20160616".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			  currentNode= zk.create (path+"/fastpay", "20160616".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			 
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
			}else if(EventType.NodeChildrenChanged ==event.getType()){
				 
				try {
					System.out.println("current node list : "+zk.getChildren(event.getPath(), true));
				} catch (Exception e) {
					// TODO Auto-generated catch block
				 
			}
		} 
	}
	}
}
