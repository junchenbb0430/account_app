package com.egfbank.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *  JDK原生的序列化对象方式，性能有很大问题
 * @author tonny
 *
 * @param <T>
 */
public class EgfJdkSerializeService {

	public static  byte[] serializeObject2Byte(Object t) {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		byte[] body = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(t);
			oos.flush();
			body =  bos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return body;
	}

	public static Object deserializeBytes2Object(byte[] bytes) {
		 ByteArrayInputStream bis = null;
		 ObjectInputStream  ois = null;
		 Object obj = null;
		 try {
			bis = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bis);
			obj=  ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ois !=null){
				// TODO
			}
		}
		return obj;
	}

	public static void main(String[] args){
		
		Person person = new Person("tom",24,"male");
		EgfJdkSerializeService serialize = new EgfJdkSerializeService();
		byte[] bytes = serialize.serializeObject2Byte(person);
		Person p = (Person)serialize.deserializeBytes2Object(bytes);
		System.out.println(p.toString());
	}
	
}
