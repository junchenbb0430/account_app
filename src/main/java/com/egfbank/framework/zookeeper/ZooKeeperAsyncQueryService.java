package com.egfbank.framework.zookeeper;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback.ChildrenCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.egfbank.framework.zookeeper.factory.ZooKeeperFactory;

public class ZooKeeperAsyncQueryService implements Watcher {

	private static CountDownLatch semaphore = new CountDownLatch(1);
	private static ZooKeeper  zk = null;			
	public void process(WatchedEvent event) {
		 System.out.println(" watchedEvent : "+event);
		 if(KeeperState.SyncConnected == event.getState()){
			 if(EventType.None == event.getType()&&null==event.getPath()){
				 semaphore.countDown();
			 }else if(EventType.NodeChildrenChanged == event.getType()){
				 try {
					System.out.println("reGet children : "+zk.getChildren(event.getPath(), true));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 
			 }
			 }
		 }
	}

	public static void main(String[] args) {
		 zk = ZooKeeperFactory.newZooKeeperInstance(new ZooKeeperAsyncQueryService());
		 try {
			semaphore.await();
			 String path = "/zk-root/trans";
			 String ctx = "I query trans";
			 zk.getChildren(path, true, new ChildrenCallbackImpl(), ctx);
			 zk.create(path+"/fastpay","20160417".getBytes(),Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
			 
			 Thread.sleep(15000);
		} catch (Exception e) {		 
			e.printStackTrace();
		}
		
	}

}

class ChildrenCallbackImpl implements ChildrenCallback{

	public void processResult(int rc, String path, Object ctx,
			List<String> children) {
		 System.out.println("[rc = "+rc+"],[ path = "+path+"],[ctx = "+ctx+"],[children = "+children+"]");
	}
	
}
