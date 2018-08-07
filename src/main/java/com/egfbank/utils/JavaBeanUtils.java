package com.egfbank.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @descritpion
 * @author lijunshi
 * @date 2018年6月14日
 */
public class JavaBeanUtils {

	/**
	 * 根据JavaBean中的attribute生成setterOrgetter方法名称，即setXXXX或getXXXX
	 * @param methodType
	 * @param attrName
	 * @return
	 */
	public static String  generateSetOrGetMethod(String methodType,String attrName) {
		StringBuffer buffer = new StringBuffer();
		String methodNameSuffix = generateSetterOrGetterMethodSuffix(attrName);
		buffer.append(methodType);
		buffer.append(methodNameSuffix);
		return buffer.toString();
	}
	
	/**
	 * 根据javaBean属性生成getter或者setter方法后缀，
	 * 例如，officeCity--->OfficeCity
	 * @param str
	 * @return
	 */
	public static String generateSetterOrGetterMethodSuffix(String attrName) {
		StringBuffer buffer = new StringBuffer();
		String firstChar = String.valueOf(attrName.charAt(0)).toUpperCase();
		buffer.append(firstChar);
		buffer.append(attrName.substring(1));
		return buffer.toString();
	}
	
	/**
	 * 
	 * @param attrNameValue
	 * @return
	 */
	public static String getAttrName(String attrNameValue) {
		return attrNameValue.substring(0, attrNameValue.indexOf("-"));
	}
	
	/**
	 * 
	 * @param attrNameValue
	 * @return
	 */
	public static String getAttrValue(String attrNameValue) {
	
		return attrNameValue.substring(attrNameValue.indexOf("-")+1);
	}
	
	/***
	 * 将JavaBean转换为Map,其中key为属性名，value为属性值
	 * @return
	 */
	public static Map<String,Object>  convertBean2Map(Object  obj){
		Map<String,Object>  beanMap = new HashMap<String,Object>();
		return  beanMap;
	}
}
