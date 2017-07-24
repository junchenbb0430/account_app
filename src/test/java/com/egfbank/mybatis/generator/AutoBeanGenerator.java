package com.egfbank.mybatis.generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AutoBeanGenerator {

	private static Connection conn;
	private static Statement stm;
	private static ResultSet rs;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/egf_account";

	public static void main(String[] args) {

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(url, "root",
					"320721Cba");
			stm = conn.createStatement();
			List<String> ltn = getAllTabName();
			Map<String,List<Colm>> mtcn = getTabColName(ltn);
			mtcn = toUL(mtcn);
			WriteDBToJava.writeJavaBean(mtcn);
			WriteDBToJava.writeXML(mtcn);
			WriteDBToJava.writeDAO(mtcn);
			WriteDBToJava.writeDAOImpl(mtcn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static List<String> getAllTabName() {
		List<String> ltn = new ArrayList<String>();
		try {
			// select table_name from all_tables WHERE owner='root'
			
			rs = stm.executeQuery("select table_name from information_schema.tables where table_schema='egf_account'");
			while (rs.next()) {
				ltn.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ltn;
	}

	private static Map<String,List<Colm>> getTabColName(List<String> allTabName) {
		Map<String,List<Colm>> mtcn = new HashMap<String,List<Colm>>();
		try {
			for (String n : allTabName) {
				rs = stm.executeQuery("select * from " + n + " where 1 < 0");
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String columnName = rsmd.getColumnLabel(i);
					String columnType = rsmd.getColumnTypeName(i);
					String typeImport = rsmd.getColumnClassName(i);
					String typeName = typeImport.substring(typeImport.lastIndexOf(".")+1, typeImport.length());
					
					//System.out.println(rsmd.getColumnClassName(i));
					List<Colm> l = mtcn.get(n);
					Colm colm = new Colm();
					colm.setDbName(columnName);
					colm.setType(columnType);
					colm.setTypeName(typeDbToJava(typeName));
					
					System.out.println(typeDbToJava(typeName));
					colm.setTypeImport(typeDbToJava(typeImport));
					if(null == l){
						l = new ArrayList<Colm>();
						l.add(colm);
						mtcn.put(n, l);
					}else{
						l.add(colm);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mtcn;
	}
	
	private static Map<String,List<Colm>> toUL(Map<String,List<Colm>> mtcn){
		Map<String,List<Colm>> allTab = new HashMap<String,List<Colm>>();
		Set<String> s = mtcn.keySet();
		for (Iterator<String> iterator = s.iterator(); iterator.hasNext();) {
			String tn = (String) iterator.next();
			boolean b = true;
			StringBuffer sbTabName = new StringBuffer();
			//表名转换
			for(int i = 0; i < tn.length(); i++){
				char c = tn.charAt(i);
				if(b){
					sbTabName.append(toU(c));
					b = false;
				}else{
					if(c =='_'){
						b = true;
					}else{
						sbTabName.append(toL(c));
					}
				}
			}
			//sbTabName.append(".java");
			//System.out.println(sbTabName);
			//字段名转换
			List<Colm> lcn = mtcn.get(tn);
			for (Colm cn : lcn) {
				StringBuffer sbColumName = new StringBuffer();
				boolean bb = false;
				for(int i = 0; i < cn.getDbName().length(); i++){
					char c = cn.getDbName().charAt(i);
					if(bb){
						sbColumName.append(toU(c));
						bb = false;
					}else{
						if(c =='_'){
							bb = true;
						}else{
							sbColumName.append(toL(c));
						}
					}
				}
				List<Colm> allColum = allTab.get(sbTabName.toString());
				Colm colm = new Colm();
				colm.setName(sbColumName.toString());
				colm.setDbName(cn.getDbName());
				colm.setType(cn.getType());
				colm.setTypeImport(cn.getTypeImport());
				colm.setTypeName(cn.getTypeName());
//				System.out.println(sbColumName.toString());
//				System.out.println(cn.getDbName());
//				System.out.println(cn.getType());
//				System.out.println(cn.getTypeName());
//				System.out.println("------------------------------");
				if(null == allColum){
					allColum = new ArrayList<Colm>();
					allTab.put(sbTabName.toString(), allColum);
					allColum.add(colm);
				}else{
					allColum.add(colm);
				}
				//System.out.println(sbColumName);
			}
		}
		return allTab;
	}
	
	//大写
	public static char toU(char c){
		if (c >= 'a' && c <= 'z') {
			return c -= 32;
		}
		return c;
	}
	
	//小写
	public static char toL(char c){
		if (c >= 'A' && c <= 'Z') {
			return c += 32;
		}
		return c;
	}
	
	//大写
	public static boolean isU(char c){
		if (c >= 'A' && c <= 'Z') {
			return true;
		}
		return false;
	}
	
	public static String jNameToDbName(String jName){
		char[] cs = jName.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cs.length; i++) {
			if(i > 0 && AutoBeanGenerator.isU(cs[i])){
				sb.append("_");
			}
			sb.append(AutoBeanGenerator.toU(cs[i]));
		}
		return sb.toString();
	}
	
	public static String typeDbToJava(String type){
		if(type.equals("")){
			return "";
		}else if(type.equals("TIMESTAMP") || type.equals("Timestamp")){
			return "Date";
		}else if(type.equals("")){
			return "java.lang.String";
		}else if(type.equals("mysql.sql.TIMESTAMP") || type.equals("java.sql.Timestamp")){
			return "java.sql.Date";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "String";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else{
			return type;
		}
	}
	
	public static String typeDbToJava2(String type){
		if(type.equals("VARCHAR2")){
			return "VARCHAR";
		}else if(type.equals("NUMBER")){
			return "NUMERIC";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else if(type.equals("")){
			return "";
		}else{
			return type;
		}
	}
	
}
