package com.egfbank.framework.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.springframework.stereotype.Service;

/**
 * 单例模式--创建CuratorFramework客户端
 * @author tonny
 *
 */
 
public class CuratorFrameworkCreator {

	 /**
	  * zookeeper连接字符串
	  */
	 private  String connectStr;
	 /**
	  * 会话超时时间
	  */
	 private  int sessionTimeOut;
	 /**
	  * 连接超时时间
	  */
	 private  int connectTimeOut;
	 /**
	  * 重试策略
	  */
	 private RetryPolicy retryPolicy;
	 
	 /**
	  * curatorFramework客户端
	  */
	 private  CuratorFramework curatorFrameWork;
	 /**
	  * 命名空间--业务场景隔离使用
	  */
	 private String nameSpace;
	 
	 public CuratorFrameworkCreator(){
		
	 }
	 
	 
	 private    CuratorFramework curatorFrameWorkInstance(){		  
		 curatorFrameWork = CuratorFrameworkFactory.builder()
					 .connectString(connectStr)
					 .connectionTimeoutMs(connectTimeOut)
					 .sessionTimeoutMs(sessionTimeOut)
					 .retryPolicy(retryPolicy)
					 .build();
		 
		 return curatorFrameWork;
	 }
	 
	 
	 public void init(){
		 curatorFrameWorkInstance();
		 curatorFrameWork.start();
	 }
	 
	 
	 
	 public String getConnectStr() {
		return connectStr;
	}


	public void setConnectStr(String connectStr) {
		this.connectStr = connectStr;
	}


	public int getSessionTimeOut() {
		return sessionTimeOut;
	}


	public void setSessionTimeOut(int sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}


	public int getConnectTimeOut() {
		return connectTimeOut;
	}


	public void setConnectTimeOut(int connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}


	public RetryPolicy getRetryPolicy() {
		return retryPolicy;
	}


	public void setRetryPolicy(RetryPolicy retryPolicy) {
		this.retryPolicy = retryPolicy;
	}


	 
	public CuratorFramework getCuratorFrameWork() {
		return curatorFrameWork;
	}


	public void setCuratorFrameWork(CuratorFramework curatorFrameWork) {
		this.curatorFrameWork = curatorFrameWork;
	}


	public String getNameSpace() {
		return nameSpace;
	}


	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}


	public static void main(String[] args){
		
		 
	 }
}

 
	
	
 