package com.egfbank.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @descritpion
 * @author lijunshi
 * @date 2018年6月14日
 */
public class ObjectUtils {

	/**
	 * 根据Class对象获取javaBean中getter方法的Method对象集合
	 * 
	 * @param classType
	 * @return
	 */
	public static List<Method> returnGetMethods(Class classType) {
		List<Method> mList = new ArrayList<Method>();
		Method[] methods = classType.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Class type = methods[i].getReturnType();
			String methodName = methods[i].getName();
			if (type.equals(String.class) && methodName.startsWith("get")) {
				mList.add(methods[i]);
			}
		}
		return mList;
	}

	/**
	 * 根据Class对象创建当前对象实例
	 * 
	 * @param classType
	 * @return
	 */
	public static Object createInstance(Class classType) {
		Object obj = null;
		try {
			obj = classType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * 创建Method对象method
	 * @param classType
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	public static Method createMethod(Class classType,String methodName, Class<?>... parameterTypes) {
		Method method = null;
		try {
			method = classType.getMethod(methodName, parameterTypes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return method;
	}
	
	/**
	 * 根据Method对象当前对象的方法
	 * @param method 当前方法的Method对象
	 * @param obj  当前对象
	 * @param paramters  当前方法参数
	 * @return  当前对象
	 */
	public static Object invokeMethod(Method method,Object obj,Object... paramters) {
		try {
			method.invoke(obj, paramters);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * 根据当前Class类型，方法名，方法参数类型，参数值执行当前方法
	 * @param classType
	 * @param methodName
	 * @param parameterTypes
	 * @param paramters
	 * @return
	 */
	public static Object  invokeMethod(Class  classType,String methodName,  Class  parameterTypes,Object paramters ) {
		 
		Object  obj = null;
		try {
			Method method = classType.getMethod(methodName, parameterTypes);
			// 生成对象实例 
			obj = createInstance(classType);
			method.invoke(obj, paramters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	 
	
	/**
	 * 
	 * @param classType
	 * @param obj
	 * @param attrNameValue
	 * @return
	 */
	public static void  invokeMethodByAttrNameValue(Class classType,Object obj,String attrNameValue) {
		// 1. 获取方法名
		String attrName = JavaBeanUtils.getAttrName(attrNameValue);
		String methodName = JavaBeanUtils.generateSetOrGetMethod("set", attrName);
		// 2. 获取传递到方法中的值
		String attrValue = JavaBeanUtils.getAttrValue(attrNameValue);
		// 3.获取Method对象
		Method method = createMethod(classType, methodName, String.class);
		// 4.执行当前对象方法 
		 invokeMethod(method,obj,attrValue);
	} 
	
	
	public static void main(String[] args) {
		 
	}
}
