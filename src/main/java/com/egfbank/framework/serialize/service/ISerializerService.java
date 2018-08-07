package com.egfbank.framework.serialize.service;

/**
 * 序列化业务服务
 * @author tonny
 *
 */
public interface ISerializerService {

	 byte[]  serializeObject(Object obj);
	
	 Object deserializeObject(byte[] byteArray,Class classType);
}
