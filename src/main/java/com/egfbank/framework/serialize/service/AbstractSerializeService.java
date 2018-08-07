package com.egfbank.framework.serialize.service;

import com.egfbank.framework.serialize.kryo.KryoFactory;
import com.egfbank.framework.serialize.kryo.KryoPool;
import com.egfbank.framework.serialize.kryo.KryoPoolImpl;
import com.esotericsoftware.kryo.Kryo;

public abstract class AbstractSerializeService implements ISerializerService {

	 private final KryoPool kryoPool;
	 
	 public AbstractSerializeService(){
		 KryoFactory factory = new KryoFactory(){

				public Kryo createKryo() {
					// TODO Auto-generated method stub
					// 配置生成的kryo对象实例
					return new Kryo();
				}
			};
			
			kryoPool = KryoPoolImpl.createBuilder(factory).build();
	 }
	
	 
	
	
	public KryoPool getKryoPool() {
		return kryoPool;
	}



 

}
