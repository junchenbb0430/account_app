package com.egfbank.framework.serialize.kryo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.esotericsoftware.kryo.Kryo;

/**
 * KryoPool资源池的实现，具体包含了实现资源kryo的获取和释放
 * 使用ConcurrentLinkedQueue队列进行管理kryo对象
 * @author tonny
 *
 */
public class KryoPoolImpl implements KryoPool {

	private final  Queue<Kryo> queue;
	private final KryoFactory factory;
	
	 
	private  KryoPoolImpl(KryoFactory factory ,Queue<Kryo> queue){
		this.queue = queue;
		this.factory = factory;
	}
	
	public Kryo borrow() {
		Kryo kryo = queue.poll();
		if(null == kryo){
			kryo = factory.createKryo();
		} 
		 
		return kryo;
	}
	
	public void release(Kryo kryo) {
		 queue.offer(kryo);
	}
	
	public static Builder  createBuilder(KryoFactory factory){
		return new Builder(factory);
	}
	
	/**
	 * 根据kryo工厂构建构造，由构造器实例化KryoPool实例
	 * @author tonny
	 *
	 */
	public static class Builder{
		private final KryoFactory factory;
		
		private final Queue<Kryo> queue = new ConcurrentLinkedQueue<Kryo>();
		
		private boolean softReference = false;
		
		public Builder(KryoFactory factory){
			if(null == factory){
				throw new IllegalArgumentException("factory must not be null!");
			}
			this.factory = factory;
		}
		
		public Builder softReference(){
			this.softReference = true;
			return this;
		}
		
		public KryoPool build(){
			return new KryoPoolImpl(factory,queue);
		}
		
	}

	public Kryo createKryo() {
		 
		return new Kryo();
	}

}
