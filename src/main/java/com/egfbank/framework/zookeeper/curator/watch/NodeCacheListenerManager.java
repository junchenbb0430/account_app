package com.egfbank.framework.zookeeper.curator.watch;

import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.springframework.beans.factory.annotation.Autowired;

import com.egfbank.framework.zookeeper.curator.CuratorFrameworkCreator;

public class NodeCacheListenerManager {

	private NodeCache nodeCache;
	
	private PathChildrenCache childrenCache;
	
	@Autowired
	private CuratorFrameworkCreator creator;
	 
    private String dataPath;
    
    private String nodePath;
	
    public void init(){
    	this.initNodeCache();
    	this.initPathChildrenCache();
    }
    
	private void initNodeCache(){
		nodeCache = new NodeCache(creator.getCuratorFrameWork(),dataPath);
		try {
			nodeCache.start(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initPathChildrenCache(){
		childrenCache = new PathChildrenCache(creator.getCuratorFrameWork(),getNodePath(),true);
		try {
			childrenCache.start(StartMode.NORMAL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NodeCache getNodeCache() {
		return nodeCache;
	}

	 
	public PathChildrenCache getChildrenCache() {
		return childrenCache;
	}

 
	public CuratorFrameworkCreator getCreator() {
		return creator;
	}

	public void setCreator(CuratorFrameworkCreator creator) {
		this.creator = creator;
	}

	public String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public void setNodeCache(NodeCache nodeCache) {
		this.nodeCache = nodeCache;
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	
}
