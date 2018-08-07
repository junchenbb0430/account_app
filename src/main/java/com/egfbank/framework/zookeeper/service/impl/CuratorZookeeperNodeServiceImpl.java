package com.egfbank.framework.zookeeper.service.impl;

import javax.annotation.Resource;

import org.apache.zookeeper.CreateMode;

import com.egfbank.framework.serialize.service.ISerializerService;
import com.egfbank.framework.zookeeper.curator.CuratorFrameworkCreator;
import com.egfbank.framework.zookeeper.service.IZookeeperNodeService;

public class CuratorZookeeperNodeServiceImpl implements IZookeeperNodeService {

	@Resource
	private ISerializerService serializerService;
	
	@Resource
	private CuratorFrameworkCreator  curatorCreator;
	
	 
	public String createNode(String path) {
		String currentNode = null;
		try {
			currentNode = curatorCreator.getCuratorFrameWork().create().creatingParentsIfNeeded()
			.forPath(path);
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return currentNode;
	}
	
	
	public String createNode(String path, Object data) {
		byte[] dataByte = serializerService.serializeObject(data);
		String node = null;
		try {
			node = curatorCreator.getCuratorFrameWork().create().creatingParentsIfNeeded()
					.withMode(CreateMode.PERSISTENT).forPath(path, dataByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return node;
	}

	public String createPesistentNode(String path, Object data) {
		 
		return createNode(path, data);
	}

	public String createPersistentSequenceNode(String path, Object data) {
		byte[] dataByte = serializerService.serializeObject(data);
		String node = null;
		try {
			node = curatorCreator.getCuratorFrameWork().create().creatingParentsIfNeeded()
					.withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath(path, dataByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return node;
	}

	public String createEphemeralNode(String path) {
		String currentNode = null;
		try {
			currentNode = curatorCreator.getCuratorFrameWork().create().creatingParentsIfNeeded()
					.withMode(CreateMode.EPHEMERAL).forPath(path);
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return currentNode;
	}

	public String createEphemeralNode(String path, Object data) {
		byte[] dataByte = serializerService.serializeObject(data);
		String currentNode = null;
		try {
			currentNode = curatorCreator.getCuratorFrameWork().create().creatingParentsIfNeeded()
					.withMode(CreateMode.EPHEMERAL).forPath(path, dataByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentNode;
	}

	public String createEphemeralSequenceNode(String path, Object data) {
		byte[] dataByte = serializerService.serializeObject(data);
		String currentNode = null;
		try {
			currentNode = curatorCreator.getCuratorFrameWork().create().creatingParentsIfNeeded()
					.withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, dataByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentNode;
	}

	public void updateNodeData(String path, Object obj) {
		byte[] data = serializerService.serializeObject(obj);
		 try {
			curatorCreator.getCuratorFrameWork().setData().forPath(path, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteCurrentNode(String path) {
		try {
			curatorCreator.getCuratorFrameWork().delete().forPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	public void guaranteeDeleteNode(String path) {
		try {
			curatorCreator.getCuratorFrameWork().delete().guaranteed().forPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
}
