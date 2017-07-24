package com.egfbank.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 

 
public class UcfSerializer {

	 

	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream bis = null;
		ObjectOutputStream os = null;
		byte[] byteArray = (byte[]) null;
		try {
			bis = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bis);
			os.writeObject(obj);
			os.flush();
			byteArray = bis.toByteArray();
		} catch (IOException e) {
			 
			throw e;
		} finally {
			closeOutputStream(os, bis);
		}
		return byteArray;
	}

	public static Object deSerialize(byte[] byteArray) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream bos = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			bos = new ByteArrayInputStream(byteArray);
			ois = new ObjectInputStream(bos);
			obj = ois.readObject();
		} catch (IOException e) {
			  
			throw e;
		} catch (ClassNotFoundException e) {
			 
			throw e;
		} finally {
			closeInputStream(bos, ois);
		}
		return obj;
	}

	private static void closeOutputStream(ObjectOutputStream os,
			ByteArrayOutputStream bis) throws IOException {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				 
				throw e;
			}
		}
		if (bis != null) {
			try {
				bis.close();
			} catch (IOException e) {
				 
				throw e;
			}
		}
	}

	private static void closeInputStream(ByteArrayInputStream bos,
			ObjectInputStream ois) throws IOException {
		if (bos != null) {
			try {
				bos.close();
			} catch (IOException e) {
				 
				throw e;
			}
		}
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				 
				throw e;
			}
		}
	}

}
