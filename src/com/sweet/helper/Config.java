package com.sweet.helper;

public class Config {

	/**
	 * 数据库连接配置
	 */
	public static final String DATABASE_URL = "jdbc:mysql://192.168.7.180:3306/gmglobal_travel?characterEncoding=utf-8";
	public static final String DATABASE_USERNAME = "root";
	public static final String DATABASE_PASSWORD = "root";

	/**
	 * 模板路径
	 */
	public static final String FTLS_PATH = "/Users/apple/Documents/workspace/eclipse-workspace/CodeFactory/template";

	/**
	 * 输出项目的路径
	 */
	public static final String PROJECT_PATH = "/Users/apple/Documents/文档/26源码/travle/GMGlobalTravel/";
//	public static final String PROJECT_PATH = "G:/project/cnrgs/course/";

	/**
	 * 默认包路径
	 */
	public static final String OUTPUT_JAVA_PATH = PROJECT_PATH + "src/main/java/com/greatmap/gmtravel/";

	/**
	 * 页面路径
	 */
	public static final String OUTPUT_JSP_PATH = PROJECT_PATH + "WebRoot/WEB-INF/views/";

	public static final String DATE_FROMATE = "yyyy-MM-dd";
	
	public static final String DD_FLOW_JSP_TEMP = "yyyy-MM-dd";

}
