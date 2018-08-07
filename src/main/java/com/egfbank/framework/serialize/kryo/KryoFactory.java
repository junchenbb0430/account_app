package com.egfbank.framework.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;

/***
 * Kryo工厂，创建kryo对象
 * @author tonny
 *
 */
public interface KryoFactory {

	Kryo createKryo();
}
