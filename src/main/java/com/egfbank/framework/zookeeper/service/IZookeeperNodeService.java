/**
 * 
 */
package com.egfbank.framework.zookeeper.service;

/**
 * @author tonny
 *  定义zookeeper服务各种行为
 *  ----创建节点
 *  ----修改节点
 *  ----删除节点
 *  ----更新节点内容
 */
public interface IZookeeperNodeService {

	/**
	 * 创建一个空节点，默认是持久节点
	 * @param path
	 * @return
	 */
	public String  createNode(String path);
	
	/**
	 * 创建非空节点，默认是持久节点
	 * @param path
	 * @param data
	 * @return
	 */
	public String  createNode(String path,Object data);
	
	 
	
	/**
	 * 创建持久化顺序非空节点
	 * @param path
	 * @param data
	 * @return
	 */
	public String  createPersistentSequenceNode(String path,Object data);
	
	/**
	 * 创建临时空节点，节点内容为空
	 * @param path
	 * @return
	 */
	public String createEphemeralNode(String path);
	
	/**
	 * 创建临时顺序非空节点
	 * @param path
	 * @param data
	 * @return
	 */
	public String createEphemeralNode(String path,Object data);
	
	/**
	 * 创建临时顺序非空节点
	 * @param path
	 * @param data
	 * @return
	 */
	public String createEphemeralSequenceNode(String path,Object data);
	
	/**
	 * 更新当前节点内容
	 * @param path
	 * @param data
	 */
	public  void  updateNodeData(String path,Object data);
	
	/**
	 * 删除当前节点
	 * @param path
	 */
	public void deleteCurrentNode(String path);
	
	/**
	 * 强制删除一个节点
	 * @param path
	 */
	public void guaranteeDeleteNode(String path);
	
}
