package com.egfbank.framework.zookeeper.curator.watch;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CuratorListenerServiceImpl implements CuratorListenerService {

	@Autowired
	private CuratorFramework curatorFramework;
	/**
	 * 当前节点内容监听
	 */
	@Autowired
	private NodeCache nodeCache;
	/**
	 * 子节点列表监听
	 */
	@Autowired
	private PathChildrenCache childrenCache;
	
	public void watchCurrentNode(final String path) {
		nodeCache.getListenable().addListener(new NodeCacheListener(){

			public void nodeChanged() throws Exception {
				
				 System.out.println("当前节点"+path+"数据内容是 ： "+nodeCache.getCurrentData().toString());
			}});
	}

	/**
	 * 
	 */
	public void watchChildrenNode(final String path) {
		childrenCache.getListenable().addListener(new PathChildrenCacheListener(){

			public void childEvent(CuratorFramework client,
					PathChildrenCacheEvent event) throws Exception {
				 switch(event.getType()){
				 case CHILD_ADDED:
					 System.out.println("当前路径 ："+event.getData().getPath()+",数据内容："+new String(event.getData().getData()));
					 break;
				 case CHILD_UPDATED:
					 System.out.println("当前路径 ："+event.getData().getPath()+",数据内容："+new String(event.getData().getData()));
					 break;
				 case CHILD_REMOVED:
					 
					 break;
				 default:
				   System.out.println("当前节点"+path+"下没有发生子节点变更");
					 
				 }
			}});
	}

}
