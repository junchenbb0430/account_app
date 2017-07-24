package com.egfbank.account.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionService {

	private static final String MYBATIS_CONFIG = "./config/mybatis-config.xml";
	
	private static final String MYBATIS_CONFIG_PROPERTIES = "./config/mybatis-config.properties";
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	/**
	 * Resouces.getResourceAsStream()--->InputStream;
	 * SqlSessionFactoryBuilder.builder(InputStream)--->SqlSessionFactory;
	 */
	public  SqlSessionFactory newSqlSessionFactoryInstanceFromXml(){
		 
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = null;
		try {
			if(null == sqlSessionFactory){
				inputStream = createInpustreamByConfigFile(MYBATIS_CONFIG);
				Properties props = loadProperties(createInpustreamByConfigFile(MYBATIS_CONFIG_PROPERTIES));
				sqlSessionFactory = factoryBuilder.build(inputStream,props);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
		return sqlSessionFactory;
	}
	
	public InputStream createInpustreamByConfigFile(String fileName){
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}
	
	public Properties loadProperties(InputStream inputStream){
		Properties props = new Properties();
		try {
			props.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	
	public   SqlSessionFactory newSqlSessionFactoryInstance(){
		SqlSessionFactory sqlSessionFactory = null;
		
		return sqlSessionFactory;
	}
	
	
	private SqlSessionService(){}
	
	public static void main(String[] args) {
		SqlSessionService service = new SqlSessionService();
		SqlSessionFactory sessionFactory = service.newSqlSessionFactoryInstanceFromXml();
		SqlSession session= sessionFactory.openSession(false);
		System.out.println(session); 
	}

}
