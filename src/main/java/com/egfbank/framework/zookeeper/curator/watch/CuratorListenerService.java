package com.egfbank.framework.zookeeper.curator.watch;

/**
 * 功能：
 * ---提供数据节点本身监听
 * -----
 * ---提供数据节点子节点监听
 * -----add node
 * -----delete node 
 * @author tonny
 *
 */
public interface CuratorListenerService {

	/**
	 * 监听数据节点本身
	 * @param path
	 * @param dataIsCompressed
	 */
	public void  watchCurrentNode(String path);

	 
	
	/**
	 * 
	 * @param path
	 */
	public void  watchChildrenNode(String path);
}
