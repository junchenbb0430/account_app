package com.egfbank.framework.zookeeper.auth;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.egfbank.framework.zookeeper.factory.ZooKeeperFactory;


public class ZooKeeperAuthService  {
	
	private static ZooKeeper zk = null;
	private static Stat stat = new Stat();
	public static void main(String[] args){
		zk = ZooKeeperFactory.newZooKeeperInstance();
		zk.addAuthInfo("digest", "foo:true".getBytes());
		String path = "/zk-root/settlement";
		try {
			String settleNode = zk.create(path,"channel".getBytes(),Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL_SEQUENTIAL);
			System.out.println("current node : "+settleNode);
			byte[] data = zk.getData(settleNode,true,stat);
			
			System.out.println(new String(data)+", stat version : "+stat.getVersion());
			ZooKeeper zk2 = ZooKeeperFactory.newZooKeeperInstance();
			zk2.addAuthInfo("digest", "foo:truD".getBytes());
			 data = zk2.getData(settleNode,false,stat);
			 Thread.sleep(Integer.MAX_VALUE);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}