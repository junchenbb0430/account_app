package com.egfbank.redis.factory;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egfbank.account.utils.EgfDateUtils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;

public class RedisConnectionFactory implements InitializingBean{
	
	private String clusterConnStr;

	private JedisPool pool;
	
	private boolean usePool = true;
	
	private JedisCluster cluster;
	
	private JedisShardInfo jedisShardInfo;

	public Jedis getRedisConnection(){
		//如果cluster不为空，优先使用集群
		if(null!=cluster){
			// TODO
			 
			return null;
		}else if(usePool){
			return pool.getResource();
		}else{
			Jedis jedis = new Jedis(jedisShardInfo);
			jedis.connect();
			return jedis;
		}
	
	}
	
	public void setPool(JedisPool pool) {
		this.pool = pool;
	}

	public void setUsePool(boolean usePool) {
		this.usePool = usePool;
	}

	public void setCluster(JedisCluster cluster) {
		this.cluster = cluster;
	}

	public void setJedisShardInfo(JedisShardInfo jedisShardInfo) {
		this.jedisShardInfo = jedisShardInfo;
	}
	
	
	
	
	public String getClusterConnStr() {
		return clusterConnStr;
	}

	public void setClusterConnStr(String clusterConnStr) {
		this.clusterConnStr = clusterConnStr;
	}

	
	
	public JedisCluster getCluster() {
		return cluster;
	}

	public void afterPropertiesSet() throws Exception {
		 String[] redisConnStrs = clusterConnStr.split(",");
		 Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		 for(String connStr:redisConnStrs){
			 int index = connStr.indexOf(":");
			 int port = Integer.valueOf(connStr.substring(index+1));
			 HostAndPort hostPort = new HostAndPort(connStr.substring(0,index),port);
			 nodes.add(hostPort);
		 }
		 this.cluster = new JedisCluster(nodes);
	}
	
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/config/spring-redis.xml");
		RedisConnectionFactory redisFactory = context.getBean(RedisConnectionFactory.class);
		JedisCluster jedisCluster = redisFactory.getCluster();
		System.out.println(jedisCluster);
		String date = EgfDateUtils.formateCurrentDate();
		jedisCluster.set(date,date+"--"); 
		 
	}

}
