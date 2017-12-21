package com.egfbank.redis.sentinel;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class JedisSentinelConnectionPool implements InitializingBean,DisposableBean{

	// 主节点名称
	private String masterName;
	
	// sentinel连接信息
	private String sentinelHosts;
	
	// 连接池配置
	private GenericObjectPoolConfig poolConfig ;

	private JedisSentinelPool jedisSentinelPool;
	
	public Jedis  getJedisInstance(){
		return  getJedisSentinelPool().getResource();
	}
	
	private void initSentinelPool(){
		String[] hostPorts = getSentinelHosts().split(",");
		Set<String> sentinelSet = new HashSet<String>();
		for(String hostPort: hostPorts){
			sentinelSet.add(hostPort);
		}
		jedisSentinelPool = new JedisSentinelPool(masterName,sentinelSet,poolConfig); 
	}
	
	
	
	
	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getSentinelHosts() {
		return sentinelHosts;
	}

	public void setSentinelHosts(String sentinelHosts) {
		this.sentinelHosts = sentinelHosts;
	}
	
	
	
	public GenericObjectPoolConfig getPoolConfig() {
		return poolConfig;
	}

	public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}

	
	
	 
	public JedisSentinelPool getJedisSentinelPool() {
		return jedisSentinelPool;
	}

	public void afterPropertiesSet() throws Exception {
		 if(null == this.getMasterName()||0==this.getMasterName().length()){
			 throw new IllegalArgumentException("{masterName} is not null!");
		 }
		 if(null == this.getSentinelHosts() || 0==this.getSentinelHosts().length()){
			 throw new IllegalArgumentException("{sentinelHosts} is not null!");
		 }
		 initSentinelPool(); 
	}
	
	public void close(Jedis jedis){
		jedis.close();
	}

	public void destroy() throws Exception {
		 if(null != this.getJedisSentinelPool()){
			 jedisSentinelPool.close();
		 }
	}

 
	
	
}
