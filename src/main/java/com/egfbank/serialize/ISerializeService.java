package com.egfbank.serialize;

public interface ISerializeService{
	
	/**
	 * 序列化服务
	 * @param t
	 * @return
	 */
	public  byte[] serializeObject2Byte(Object t);

	/**
	 * 反序列化服务
	 * @param bytes
	 * @return
	 */
	public  Object deserializeBytes2Object(byte[] bytes);
}
