package com.egfbank.mybatis.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WriteDBToJava {
	private static String pakg = "com.egfbank.account.";
	private static String url = "F:\\mybatis-generator\\";
	private static String subUrl1 = "pojo";
	private static String subUrl2 = "mybatis";
	private static String subUrl3 = "dao";
	private static String rowNum = "10";
	public static void writeJavaBean(Map<String,List<Colm>> mTables){
		
		Set<String> set = mTables.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Map<String,String> imports = new HashMap<String,String>();
			try {
				File f = new File(url+subUrl1+"\\");
				f.mkdir();
				f = new File(url+subUrl1+"\\"+key+".java");
				f.createNewFile();
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				List<Colm> l = mTables.get(key);
				output.write("package "+pakg+subUrl1+";\n");
				output.write("\n");
				
				for (Colm colm : l) {
					if(imports.get(colm.getTypeImport()) == null && !"java.lang.String".equals(colm.getTypeImport())){
						output.write("import "+colm.getTypeImport()+";");
						output.write("\n");
						imports.put(colm.getTypeImport(), colm.getTypeImport());
					}
				}
				output.write("\n");
				output.write("public class "+key+" {\n\n");
				StringBuffer line;
				for (Colm colm : l) {
					line = new StringBuffer();
					line.append("\t ");
					line.append("private ");
					line.append(colm.getTypeName() + " ");
					line.append(colm.getName() + ";\n\n");
					output.write(line.toString());
				}
				for (Colm colm : l) {
					//set
					line = new StringBuffer();
					line.append("\t\t");
					line.append("public ");
					line.append("void ");
					line.append("set"+ AutoBeanGenerator.toU(colm.getName().charAt(0)) + colm.getName().substring(1, colm.getName().length()));
					line.append(" ("+colm.getTypeName()+" "+colm.getName()+") {\n");
					output.write(line.toString());
					
					line = new StringBuffer();
					line.append("\t\t\tthis."+colm.getName()+" = "+colm.getName());
					line.append(";\n");
					output.write(line.toString());
					
					
					line = new StringBuffer();
					line.append("\t\t}");
					line.append("\n\n");
					output.write(line.toString());
					
					//get
					line = new StringBuffer();
					line.append("\t\t");
					line.append("public ");
					line.append(colm.getTypeName()+" ");
					line.append("get"+ AutoBeanGenerator.toU(colm.getName().charAt(0)) + colm.getName().substring(1, colm.getName().length()));
					line.append(" () {\n");
					output.write(line.toString());
					
					line = new StringBuffer();
					line.append("\t\t\treturn "+colm.getName());
					line.append(";\n");
					output.write(line.toString());
					
					
					line = new StringBuffer();
					line.append("\t\t}");
					line.append("\n\n");
					output.write(line.toString());
				}
				output.write("}\n");
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void writeXML(Map<String,List<Colm>> mTables){
		Set<String> set = mTables.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			//System.out.println("<typeAlias type=\""+pakg+"pojo."+key+"\" alias=\""+AutoBeanGenerator.toL(key.charAt(0))+key.substring(1)+"\" />");
			Map<String,String> imports = new HashMap<String,String>();
			try {
				File f = new File(url+subUrl2+"\\");
				f.mkdir();
				f = new File(url+subUrl2+"\\"+AutoBeanGenerator.jNameToDbName(key).toLowerCase()+"_sql.xml");
				f.createNewFile();
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				List<Colm> l = mTables.get(key);
				output.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
				output.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
				output.write("<mapper namespace=\"" + pakg.substring(0, pakg.length()-1) + "\">\n");
				
				output.write("<!-- insert "+key+" -->\n");
				output.write("<insert id=\"insert"+key+"\" parameterType=\""+AutoBeanGenerator.toL(key.charAt(0))+key.substring(1)+"\" keyProperty=\"id\" useGeneratedKeys=\"true\">\n");
				output.write("\t<![CDATA[\n");
				output.write("\t\tINSERT INTO " + AutoBeanGenerator.jNameToDbName(key) + " (\n");
				StringBuffer sb1 = new StringBuffer();
				StringBuffer sb2 = new StringBuffer();
				for (int i = 0; i < l.size(); i++) {
					if(i>0){
						sb1.append(",");
						sb2.append(",");
					}
					Colm c = l.get(i);
					sb1.append(c.getDbName());
					sb2.append("#{"+c.getName()+",jdbcType="+AutoBeanGenerator.typeDbToJava2(c.getType())+"}");
//					if(i == 0){
//						// TODO oracle 
//						sb2.append(AutoBeanGenerator.jNameToDbName(key)+"_SEQ.nextval");
//					}else{
//						sb2.append("#{"+c.getName()+",jdbcType="+AutoBeanGenerator.typeDbToJava2(c.getType())+"}");
//					}
				}
				output.write("\t"+sb1.toString()+"\n");
				output.write("\t\t)VALUES(\n");
				output.write("\t\t"+sb2.toString());
				output.write(")\n\t]]>\n</insert>\n");
				output.write("\n");
				
				output.write("<!-- update "+key+" -->\n");
				output.write("<update id=\"update"+key+"\" parameterType=\""+AutoBeanGenerator.toL(key.charAt(0))+key.substring(1)+"\">\n");
				output.write("\t<![CDATA[\n");
				output.write("\t\tUPDATE \n");
				output.write("\t\t" + AutoBeanGenerator.jNameToDbName(key) + " \n");
				output.write("\t\tSET \n");
				Colm cl = l.get(0);
				output.write("\t\t "+cl.getDbName() + "=" +cl.getDbName()+"\n");
				output.write("\t]]>\n");
				StringBuffer sb3 = new StringBuffer("\t\t");
				for (int i = 1; i < l.size(); i++) {
					Colm c = l.get(i);
					if(c.getTypeName().equals("String")){
						sb3.append("\t<if test=\"null != "+c.getName()+" and '' != "+c.getName()+"\">\n");
					}else{
						sb3.append("\t<if test=\"null != "+c.getName()+"\">\n");
					}
					sb3.append("\t<![CDATA[\n");
					sb3.append(",");
					sb3.append(c.getDbName());
					sb3.append(" = #{");
					sb3.append(c.getName());
					sb3.append("}");
					sb3.append("\n\t]]>\n");
					sb3.append("\t</if>\n");
				}
				sb3.append("\t<![CDATA[\n");
				sb3.append("\n");
				output.write(sb3.toString());
				output.write("\t\tWHERE  "+cl.getDbName()+" = #{"+cl.getName()+"} \n");
				output.write("\t]]>\n");
				output.write("</update>\n\n");
				
				
				output.write("<!-- delete "+ key +" -->\n");
				output.write("<delete id=\"delete"+ key +"\" parameterType=\"string\">\n");
				output.write("\t<![CDATA[\n");
				output.write("\t\tDELETE FROM " + AutoBeanGenerator.jNameToDbName(key) + " WHERE id = #{id}\n");
				output.write("\t]]>\n");
				output.write("</delete>\n");
				output.write("\n");
				// 生成forupdate 语句
				output.write("<!-- select "+ key +" for update-->\n");
				output.write("<!-- select "+ key +" -->\n");
				output.write("<select id=\"query"+key+"ForUpdate\" resultType=\""+AutoBeanGenerator.toL(key.charAt(0))+key.substring(1)+"\" parameterType=\""+AutoBeanGenerator.toL(key.charAt(0))+key.substring(1)+"\" >\n");
				output.write("<![CDATA[\n");
				output.write("SELECT \n");
				StringBuffer sb5 = new StringBuffer();
				for (int i = 0; i < l.size(); i++) {
					if(i>0){
						sb5.append(",");
					}
					Colm cc = l.get(i);
					sb5.append(cc.getDbName());
					sb5.append(" as ");
					sb5.append(cc.getName());
				}
				output.write(sb5.toString());
				output.write(" FROM "+AutoBeanGenerator.jNameToDbName(key)+"\n");
				output.write("]]>\n");
				Colm colm = l.get(0);
				output.write("WHERE "+colm.getDbName()+" = #{"+colm.getName()+"} for update \n");
				 
				output.write("</select>\n");
				output.write("\n");
				//
				output.write("<!-- select "+ key +" -->\n");
				output.write("<select id=\"query"+key+"ByWhere\" resultType=\""+AutoBeanGenerator.toL(key.charAt(0))+key.substring(1)+"\" parameterType=\""+AutoBeanGenerator.toL(key.charAt(0))+key.substring(1)+"\" >\n");
				output.write("<![CDATA[\n");
				output.write("SELECT \n");
				StringBuffer sb4 = new StringBuffer();
				for (int i = 0; i < l.size(); i++) {
					if(i>0){
						sb4.append(",");
					}
					Colm cc = l.get(i);
					sb4.append(cc.getDbName());
					sb4.append(" as ");
					sb4.append(cc.getName());
				}
				output.write(sb4.toString());
				output.write(" FROM "+AutoBeanGenerator.jNameToDbName(key)+" WHERE ROWNUM <= "+rowNum+" \n");
				output.write("]]>\n");
				for (Colm colm4 : l) {
					if(colm.getTypeName().equals("String")){
						output.write("<if test=\"null != "+colm4.getName()+" and '' != "+colm4.getName()+"\">\n");
					}else{
						output.write("<if test=\"null != "+colm4.getName()+"\">\n");
					}
					output.write("<![CDATA[\n");
					output.write("AND "+ colm4.getDbName() +" = #{"+colm4.getName()+"}\n");
					output.write("]]>\n");
					output.write("</if>\n");
				}
				output.write("</select>\n");
				output.write("</mapper>\n");
				
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void writeDAO(Map<String,List<Colm>> mTables){
		Set<String> set = mTables.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Map<String,String> imports = new HashMap<String,String>();
			try {
				File f = new File(url+subUrl3+"\\");
				f.mkdir();
				f = new File(url+subUrl3+"\\"+key+"Dao.java");
				f.createNewFile();
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				List<Colm> l = mTables.get(key);
				String s = AutoBeanGenerator.toL(key.charAt(0))+key.substring(1, key.length());
				output.write("package "+pakg+subUrl3+";\n\n");
				output.write("import java.io.Serializable;\n");
				output.write("import java.util.List;\n");
				output.write("import "+pakg+subUrl1+"."+key+";\n");
				//output.write("import com.ucf.onlinepay.framework.exception.in.FnFiTechnicalException;\n\n");
				output.write("public interface "+key+"Dao extends Serializable {\n\n");
				output.write("\tpublic void insert"+key+"("+key+" "+s+");\n\n");
				output.write("\tpublic void update"+key+"("+key+" "+s+");\n\n");
				output.write("\tpublic void delete"+key+"(String "+l.get(0).getName()+");\n\n");
				output.write("\tpublic List<"+key+"> query"+key+"ListByWhere("+key+" "+s+");\n\n");
				output.write("\tpublic List<"+key+"> query"+key+"ForUpdate("+key+" "+s+");\n\n");
				output.write("}");
				output.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	 
	
	public static void writeDAOImpl(Map<String,List<Colm>> mTables){
		Set<String> set = mTables.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Map<String,String> imports = new HashMap<String,String>();
			try {
				File f = new File(url+subUrl3+"\\impl\\");
				f.mkdir();
				f = new File(url+subUrl3+"\\impl\\"+key+"DaoImpl.java");
				f.createNewFile();
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				List<Colm> l = mTables.get(key);
				String s = AutoBeanGenerator.toL(key.charAt(0))+key.substring(1, key.length());
				output.write("package "+pakg+subUrl3+".impl;\n\n");
				output.write("import org.springframework.stereotype.Repository;\n");
				output.write("import java.util.List;\n");
				output.write("import "+pakg+subUrl1+"."+key+";\n");
				output.write("import com.egfbank.account.dao.BaseAccountDao;\n");
				output.write("org.mybatis.spring.support.SqlSessionDaoSupport;\n");
				
				output.write("import "+pakg+subUrl3+"."+key+"Dao;\n");
				//output.write("import com.ucf.onlinepay.framework.exception.in.FnFiTechnicalException;\n\n");
				output.write("@Repository\n");
				output.write("public class "+key+"DaoImpl extends BaseAccountDao implements "+key+"Dao {\n\n");
				output.write("private static final long serialVersionUID = -1L;\n\n");
				output.write("\tpublic void insert"+key+"("+key+" "+s+"){\n");
				output.write("\t\tthis.insert(\""+pakg+"insert"+key+"\", "+s+");\n");
				output.write("\t}\n\n");
				output.write("\tpublic void update"+key+"("+key+" "+s+"){\n");
				output.write("\t\tthis.update(\""+pakg+"update"+key+"\", "+s+");\n");
				output.write("\t}\n\n");
				//output.write("\tpublic void delete"+key+"(String "+l.get(0).getName()+")throws FnFiTechnicalException{\n");
				output.write("\tpublic void delete"+key+"(String "+l.get(0).getName()+"){\n");
				output.write("\t\tthis.delete(\""+pakg+"delete"+key+"\", "+l.get(0).getName()+");\n");
				output.write("\t}\n\n");
				output.write("\tpublic List<"+key+"> query"+key+"ListByWhere("+key+" "+s+"){\n");
				output.write("\t\treturn this.queryForList(\""+pakg+"query"+key+"ByWhere\", "+s+");\n");
				output.write("\t}\n\n");
				output.write("\tpublic List<"+key+"> query"+key+"ForUpdate("+key+" "+s+"){\n");
				output.write("\t\treturn this.queryForList(\""+pakg+"query"+key+"ForUpdate\", "+s+");\n");
				output.write("\t}\n\n");
				output.write("}");
				output.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		
	}
}

