package com.egfbank.framework.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;

/**
 * Kryo是线程非安全的，必须做到每个线程都使用单独的kryo对象去完成序列化和反序列化。
 * 使用资源池的思想，尽量避免频繁创建和销毁kryo对象
 * 为了实现线程安全获取kryo对象，可以使用ConcurrentLinkedQueue存储kryo对象
 * 由于序列化和反序列化在内存中实现，为了加快内存的GC，可以使用软引用SoftReference
 * 管理Kryo。SoftReference引用的对象在没有使用的时候，GC会优先回收
 * Kyro资源池：
 * @author tonny
 *
 */
public interface KryoPool {
    /**
     * 从资源池中获取kryo对象
     * @return
     */
	Kryo  borrow();
    
	/**
	 * 释放使用完毕的kryo
	 * @param kryo
	 */
    void release(Kryo kryo);
}
