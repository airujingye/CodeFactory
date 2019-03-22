package com.sweet.helper;

import java.util.ArrayList;
import java.util.List;

public class TableInfo {

	/**
	 * 数据库表名
	 */
	private String tableName;
	/**
	 * 主键
	 */
	private FieldInfo primaryKey;
	/**
	 * 表名的语义意思
	 */
	private String tableTitle;
	/**
	 * 表对应的类的名称
	 */
	private String className;

	/**
	 * 字段列表
	 */
	private List<FieldInfo> fieldList;

	/**
	 * 页面的文件夹路径
	 */
	private String pageFolder;

	/**
	 * 页面的名称
	 */
	private String pageName;

	/**
	 * 类的包名
	 */
	private String packageName;

	/**
	 * 导入的包
	 */
	private List<String> imports = new ArrayList<String>();

	public TableInfo() {
		super();
	}

	public TableInfo(String tableName) {
		super();
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public FieldInfo getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(FieldInfo primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getTableTitle() {
		return tableTitle;
	}

	public void setTableTitle(String tableTitle) {
		this.tableTitle = tableTitle;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<FieldInfo> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<FieldInfo> fieldList) {
		this.fieldList = fieldList;
	}

	public String getPageFolder() {
		return pageFolder;
	}

	public void setPageFolder(String pageFolder) {
		this.pageFolder = pageFolder;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<String> getImports() {
		return imports;
	}

	public String getPackageName() {
		return packageName;
	}
	/**
	 * 获得包名
	 * @return
	 */
	public String getOutPutPackageName() {
		//如果存在包名
		if(null!=packageName&&packageName.indexOf('.')>-1){
		//	packageName = packageName.replace(".", "/");
			return packageName.replace(".", "/");// packageName.substring(0, packageName.indexOf('.'));
		}
		return "";
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	public void addImport(String pkg) {
		if (pkg != null && pkg.length() > 0 && !imports.contains(pkg)) {
			this.imports.add(pkg);
		}
	}
}
