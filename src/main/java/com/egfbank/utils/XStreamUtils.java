package com.egfbank.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public abstract class XStreamUtils {

	private static final String xmlPrefix = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	 
	
	
	/**
	 * 将xml对象转为java对象
	 * 
	 * @param xmlStr
	 * @param classType
	 * @return
	 */
	public static <T> T covertXml2JavaBean(String xmlStr, Class<T> classType) {
		XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_"))); 
		xstream.processAnnotations(classType);

		return (T) xstream.fromXML(xmlStr);
	}

	public static <T> String convertBean2Xml(Object obj, Class<T> classType) {
		XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_"))); 
		xstream.processAnnotations(classType);
		StringBuilder sb = new StringBuilder();
		sb.append(xmlPrefix);
		sb.append(xstream.toXML(obj));
		return sb.toString();
	}

}
