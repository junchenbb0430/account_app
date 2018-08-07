package com.egfbank.utils;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.alibaba.fastjson.JSONObject;


/**
 * @descritpion
 * @author lijunshi
 * @date 2018年6月19日
 */
public class ValidateUtils {

	private static Validator  validator;
	
	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	public static void validate(Object object,Class<?>... groups) {
		 
		StringBuffer buffer = new StringBuffer();
		Set<ConstraintViolation<Object>> constraints = validator.validate(object,groups);
		 Iterator it =  constraints.iterator();
		 while(it.hasNext()) {
			 ConstraintViolation<Object> validate =  (ConstraintViolation<Object>)it.next();
			 buffer.append(validate.getPropertyPath().toString()+"-->"+validate.getMessage());
		 } 
		 if(constraints.size()>0) { 
			 throw new RuntimeException(buffer.toString());
		 }	 
	}
	
	public static void validate(Object object) {
		 
		StringBuffer buffer = new StringBuffer();
		Set<ConstraintViolation<Object>> constraints = validator.validate(object);
		 Iterator it =  constraints.iterator();
		 while(it.hasNext()) {
			 ConstraintViolation<Object> validate =  (ConstraintViolation<Object>)it.next();
			 buffer.append(validate.getMessage());
		 } 
		 if(constraints.size()>0) { 
			 throw new RuntimeException(buffer.toString());
		 }	 
	}
	
	/**
	 * 校验当前Bean中指定的属性是否为设置的约束.其中validateProperty要求Property符合JavaBean的标准
	 * @param object
	 * @param propertyName
	 */
	public static void validateProperty(Object object,String propertyName) {
		Set<ConstraintViolation<Object>> constraints =  validator.validateProperty(object, propertyName);
		JSONObject jsonObject = new JSONObject();
		 Iterator it =  constraints.iterator();
		 while(it.hasNext()) {
			 ConstraintViolation<Object> validate =  (ConstraintViolation<Object>)it.next();
			 jsonObject.put(validate.getPropertyPath().toString(), validate.getMessage());   
		 } 
		 if(jsonObject.size()>0) {
			 throw new RuntimeException(jsonObject.toJSONString());
		 }
	}
	
	/**
	 * 校验当前Bean中属性propteryName中的属性值是否为value
	 * @param beanType
	 * @param propertyName
	 * @param value
	 */
	public static void validateValue(Class beanType,String propertyName, Object value ) {
		Set<ConstraintViolation<Object>> constraints = validator.validateValue(beanType, propertyName, value);
		JSONObject jsonObject = new JSONObject();
		 Iterator it =  constraints.iterator();
		 while(it.hasNext()) {
			 ConstraintViolation<Object> validate =  (ConstraintViolation<Object>)it.next();
			 jsonObject.put(validate.getPropertyPath().toString(), validate.getMessage());   
		 } 
		 if(jsonObject.size()>0) {
			 throw new RuntimeException(jsonObject.toJSONString());
		 }
	}
	
	 
}
