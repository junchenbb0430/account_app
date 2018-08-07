package com.egfbank.framework.serialize.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.egfbank.framework.serialize.kryo.KryoPool;
import com.egfbank.framework.serialize.service.AbstractSerializeService;
import com.egfbank.framework.serialize.test.Person;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


/**
 * 
 * @author tonny
 *
 */
public class KryoSerializerService extends AbstractSerializeService {
   
	public byte[] serializeObject(Object obj) {
		
		KryoPool pool = this.getKryoPool();
		Kryo kryo = pool.borrow();
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		Output  output = null;
		try{
			output = new Output(byteOutputStream);
			kryo.writeClassAndObject(output, obj);
			output.flush();
		}catch(Exception ex){
			//TODO
		}finally{
			output.close();
			pool.release(kryo);
		}
		
		return byteOutputStream.toByteArray();
	}

	public Object deserializeObject(byte[] byteArray,Class classType) {
		KryoPool pool = this.getKryoPool();
		Kryo kryo = pool.borrow();
		Input input = null;
		Object obj  = null;
		try{
		    input = new Input(new ByteArrayInputStream(byteArray));	 
		    obj = kryo.readClassAndObject(input);
		}catch(Exception ex){
			//TODO
		}finally{
			input.close();
			pool.release(kryo);
		}
	
		pool.release(kryo);
		return obj;
	}

	public static void main(String[] args){

		 
		KryoSerializerService serializer = new KryoSerializerService();
		Person person = new Person("zhangsan","nanjing");
		byte[] byteArray = serializer.serializeObject(person);
		Person p2 = (Person)serializer.deserializeObject(byteArray,Person.class);
		System.out.println(p2);
	} 
	
}
