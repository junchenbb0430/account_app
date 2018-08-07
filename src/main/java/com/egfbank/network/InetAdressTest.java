package com.egfbank.network;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress inetAdress = InetAddress.getByName("www.baidu.com");
			 byte[] ipBytes = inetAdress.getAddress();
			 
			System.out.println(inetAdress.getHostAddress());//返回远程主机IP地址
			System.out.println(inetAdress.getHostName());// 返回远程主机名
			System.out.println(InetAddress.getLocalHost().toString());//返回本机相关信息
			byte[] addr = {(byte)220,(byte)181,111,(byte)188};
			InetAddress ia = InetAddress.getByAddress(addr);
			System.out.println(ia.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
