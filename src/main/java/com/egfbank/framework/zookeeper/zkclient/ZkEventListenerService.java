package com.egfbank.framework.zookeeper.zkclient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import com.egfbank.framework.utils.EgfDateUtils;

/**
 * 
 * @author tonny
 *  提供ZkClient各种监听服务，主要包括
 *  ---
 */
public class ZkEventListenerService {

	private ZkClient zkClient;
	
	public ZkEventListenerService(){
		zkClient = ZKClientInstance.newInstance();
	}
	
	/**
	 * parentPath:当前父节点
	 * 服务端发生如下变化时，会通知客户端
	 * ---新增子节点
	 * ---删除子节点
	 * ---删除子节点
	 */
	public void  listenChildNodeChange(String parentPath){
		zkClient.subscribeChildChanges(parentPath, new IZkChildListener(){

			public void handleChildChange(String parentPath,
					List<String> currentChilds) throws Exception {
				 System.out.println("父节点是 ： "+parentPath);
				 for(String child:currentChilds){
					 System.out.println("子节点路径为-->"+child);
				 }
			}});
	}
	
	/**
	 * IZkDataListener接口主要有两个方法：
	 * ---handleDataChange(dataPath,data)
	 * ---handleDataDeleted(dataPath)
	 * @param parentPath
	 */
	public void listenDataChange(String currentPath){
		zkClient.subscribeDataChanges(currentPath,new IZkDataListener(){

			public void handleDataChange(String dataPath, Object data)
					throws Exception {
				 System.out.println("dataPath="+dataPath+",data = "+data);
			}

			public void handleDataDeleted(String dataPath) throws Exception {
				 System.out.println("deleted node = "+dataPath);
			}});
			 
	}
	
	 
	/**
	 * 
	 * @param parentPath
	 */
	public void listenStatChange(){
		zkClient.subscribeStateChanges(new IZkStateListener(){

			public void handleStateChanged(KeeperState state) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("状态值变化： "+state.getIntValue());
			}

			public void handleNewSession() throws Exception {
				// TODO Auto-generated method stub
				
			}});
	}
	
	public  static void main(String[] args){
		ZkEventListenerService zkEventService = new ZkEventListenerService();
		try { 
		String parentPath = "/zk-order";
		// 注册当前节点变化
		zkEventService.listenChildNodeChange(parentPath);
		System.out.println("************************");
		String path = parentPath+"/"+EgfDateUtils.formateCurrentDateTime();
		// 注册当前节点内容变化
		zkEventService.listenDataChange(path);
		// 
		zkEventService.listenStatChange();
		ZookeeperService zkService = new ZookeeperService();
		zkService.createNode(path,EgfDateUtils.formateCurrentDate());
		
		//zkService.updateData(path, EgfDateUtils.formateCurrentDateTime());
		List<String> children = zkService.queyChildrenNode(parentPath);
//		for(String node:children){
//			StringBuilder sb = new StringBuilder();
//			sb.append(parentPath);
//			sb.append("/");
//			sb.append(node);
//			zkService.deleteNode(sb.toString());
//			Thread.sleep(1000);
//		}
		 children = zkService.queyChildrenNode(parentPath);
		System.out.println(children);
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
