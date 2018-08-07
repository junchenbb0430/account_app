package com.egfbank.framework.zookeeper.zkclient;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import com.egfbank.framework.utils.EgfDateUtils;

public class ZookeeperService {

	private ZkClient zkClient;
	
	public ZookeeperService(){
		zkClient = ZKClientInstance.newInstance();
	}
	
	public String createNode(String path,Object data,CreateMode mode){
		return zkClient.create(path, data, mode);
	}
	
	public String  createNode(String path,Object data){
		return zkClient.create(path, data, CreateMode.PERSISTENT);
	}
	/**
	 * 查询当前节点的内容
	 * @param path
	 * @return
	 */
	public String queryCurrentNodeContent(String path){
		return zkClient.readData(path);
	}
	
	public void updateData(String path,Object data){
		zkClient.writeData(path, data);
	}
	
	/**
	 * 查询当前节点的子节点列表
	 * @param parentPath
	 * @return 返回的是子结点相对路径列表
	 */
	public List<String> queyChildrenNode(String parentPath){
		return zkClient.getChildren(parentPath);
	}
	
	/**
	 * 删除当前节点
	 * @param path
	 */
	public void deleteNode(String path){
		zkClient.delete(path);
	}
	
	/**
	 * 
	 * @param path
	 * @param data
	 */
	public void createEphermeralNode(String path,Object data){
		zkClient.createEphemeral(path, data);
		 
	}
	
	public static void main(String[] args) {
		ZookeeperService zkService = new ZookeeperService();
		String path = "/zk_client/order";
		String data = EgfDateUtils.formateCurrentDate();
		String resultPath =zkService.createNode(path, data);
		System.out.println(resultPath);
		System.out.println("查询结果如下 ： "+zkService.queryCurrentNodeContent(path));
		
//		zkService.updateData(path, EgfDateUtils.formateCurrentDateTime());
//		System.out.println("查询结果如下 ： "+zkService.queryData(path));
		
	}

}
