package com.sweet.helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * 数据模型工具类
 * 用于读取数据库表，封装成TableInfo
 * 
 * @author liuliang
 *
 */
public class ModelUtil {
	
	private static String[] sqlDataType = new String[]{"varchar","text","int","datetime","date","double","float","timestamp","bit","mediumtext"};
	private static String[] dataTypes = new String[]{"String","String","Integer","Timestamp","Timestamp","Double","Float","Timestamp","Boolean","String"};
	private static String[] imports = new String[]{"","","","java.sql.Timestamp","java.sql.Timestamp","","","java.sql.Timestamp","",""};
	
	private static Map<String,String[]> dataType = new HashMap<String,String[]>();
	
	// 初始化数据类型对应关系
	static{
		for (int i = 0; i < sqlDataType.length; i++) {
			dataType.put(sqlDataType[i], new String[]{dataTypes[i],imports[i]});
		}
	}
	
	/**
	 * 读取数据库表，生成表模型类
	 * 
	 * @param tableName  数据库表名
	 * @param className  生成的实体bean的类名
	 * @param pageFolder 生成的jap页面存放文件夹路径
	 * @param pageName   生成的jsp页面的前缀名称
	 * @return
	 */
	public static TableInfo creatModel(String tableName,String packageName,String className,String pageFolder,String pageName){
		
		TableInfo t = new TableInfo(tableName); 
		t.setClassName(className);
		
		LinkedList<Object> params = new LinkedList<Object>();  
        params.add(tableName);  
        DBHelper dbHelper = new DBHelper(); 
        try {
        	// 查询表名
            ResultSet rs = dbHelper.executeQuery("select * from information_schema.tables where table_name=? and TABLE_SCHEMA = 'gmtravel_global' ", params);
            if(rs.next()){
            	String tableTitle = rs.getString("TABLE_COMMENT");
            	t.setTableTitle(tableTitle);
            }
            // 查询主键字段
            rs = dbHelper.executeQuery("select * from information_schema.columns where table_name=? and TABLE_SCHEMA = 'gmtravel_global' and COLUMN_KEY = 'PRI'", params); 
            if(rs.next()){
            	String name = rs.getString("COLUMN_NAME");
            	String type = rs.getString("DATA_TYPE");
            	t.addImport(dataType.get(type)[1]);
            	type = dataType.get(type)[0];
            	String title = rs.getString("COLUMN_COMMENT");
            	t.setPrimaryKey(new FieldInfo(name, type, title,true));
            }
            // 查询普通字段名
            rs = dbHelper.executeQuery("select * from information_schema.columns where table_name=? and TABLE_SCHEMA = 'gmtravel_global' and COLUMN_KEY <> 'PRI'", params);  
    		List<FieldInfo> fieldList = new ArrayList<FieldInfo>();
            while(rs.next()){
            	String name = rs.getString("COLUMN_NAME");
            	String type = rs.getString("DATA_TYPE");
            	t.addImport(dataType.get(type)[1]);
            	type = dataType.get(type)[0];
            	String title = rs.getString("COLUMN_COMMENT");
        		fieldList.add(new FieldInfo(name, type, title));
    		}
            t.setFieldList(fieldList);
            t.setPageFolder(pageFolder);
    		t.setPageName(pageName);
    		t.setPackageName(packageName);
            dbHelper.close();
		} catch (Exception e) {
			e.printStackTrace();
			dbHelper.close();
		}
        
		return t;
	}
}
