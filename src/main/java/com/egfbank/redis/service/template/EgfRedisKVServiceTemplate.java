package com.egfbank.redis.service.template;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.egfbank.redis.callback.EgfRedisCallback;
import com.egfbank.redis.factory.EgfRedisConnectionFactory;
import com.egfbank.redis.helper.EgfRedisConnectionHelper;
import com.egfbank.redis.service.EgfKeyValueService;
import com.egfbank.serialize.EgfJdkSerializeService;
import com.egfbank.serialize.Person;
/**
 * 
 * @author lijunshi
 * 提供Redis操作的封装，屏蔽对象的序列化和反序列化
 * 同时对于redis的连接进行底层管理，无需关注连接获取和释放
 * 提供线程安全的操作，防止并发操作的危险
 * @param <T>
 */
@Service
public class EgfRedisKVServiceTemplate<K,V, T> extends RedisDataAccessor{
	
 
	private EgfKeyValueService egfKVService;
	
	public static int DEFAULT_SECOND = 30*60;
	
	/**
	 * 持有回调接口EgfRedisCallback的引用
	 */
	public T execute(EgfRedisCallback action){
		
		EgfRedisConnectionFactory factory = this.getJedisFactory();
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(factory);
		//action.doInRedis(conn);
		
		return null;
	}
	
	
	public EgfKeyValueService operationForKeyValue(){
		return this.getEgfKVService();
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void set(String key,String value){
		// TODO
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		jedis.set(key, value);
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getByStrKey(String key){
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		return jedis.get(key);
	}
	/**
	 * @param key
	 * @return
	 */
	public Object getValueByByteKey(byte[] key){
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		byte[] values = jedis.get(key);
		if(null == values){
			return null;
		}
		return EgfJdkSerializeService.deserializeBytes2Object(values);
	}
	
	public void setByte(String key,Object value){
	 this.storeObj(key, value);
	}
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void storeObj(Object key,Object value){
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		byte[] keyByte = EgfJdkSerializeService.serializeObject2Byte(key);
		byte[] valueByte = EgfJdkSerializeService.serializeObject2Byte(value);
		String result = jedis.set(keyByte, valueByte);
		System.out.println(result);
	}
	
	public boolean existsKey(String key){
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		return jedis.exists(key);
	}
	
	public boolean existKey(Object key){
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		byte[] keyByte = EgfJdkSerializeService.serializeObject2Byte(key);
		return jedis.exists(keyByte);
	}
	/**
	 * 设置过期时间
	 * @param key
	 */
	public void expireKey(String key){
		this.expireKey(key, DEFAULT_SECOND);
	}
	
	public void expireKey(String key,int second){
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		jedis.expire(key, second);
	}
	
	public void expireObject(Object key,int second){
		byte[] byteKey = EgfJdkSerializeService.serializeObject2Byte(key);
		Jedis jedis = EgfRedisConnectionHelper.getRedisConnection(getJedisFactory());
		jedis.expire(byteKey, second);
	}
	
	public void expireObject(Object key){
		this.expireObject(key, DEFAULT_SECOND);
	}
	
	public List<Object> getVlauesOfkeys(List<String> keyList){
		return null;
	}
	
	

	public EgfKeyValueService getEgfKVService() {
		return egfKVService;
	}


	public static void main(String[] args) {
		String configXml ="classpath:config/spring-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configXml);
		
		EgfRedisKVServiceTemplate redisService = context.getBean(EgfRedisKVServiceTemplate.class);
		try {
			Person p= new Person("法印",35,"男");
			redisService.setByte("006",p);
			byte[] key =  EgfJdkSerializeService.serializeObject2Byte("004");
			System.out.println(redisService.getValueByByteKey(key));
			key = EgfJdkSerializeService.serializeObject2Byte("006");
			System.out.println(redisService.getValueByByteKey(key));
			key ="005".getBytes("utf-8");
			System.out.println(redisService.getValueByByteKey(key));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		RedisTemplate<String,String> redisTemplate = context.getBean(RedisTemplate.class);
//		System.out.println(redisTemplate);
//		ValueOperations<String,String> valueOperation = redisTemplate.opsForValue();
//		valueOperation.set("floor04", "咖啡厅");
//		System.out.println(valueOperation.get("floor15"));
//		valueOperation.set("floor09", "北明软件");
	}
	
}
