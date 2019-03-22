package com.sweet.helper;

public class FieldInfo {

	/**
	 * 字段名
	 */
	private String name;
	/**
	 * 字段类型
	 */
	private String type;
	/**
	 * 字段汉字名
	 */
	private String title;
	/**
	 * 组件显示类型,默认为
	 */
	private String dbType = InputType.TEXT;
	/**
	 * 主键是否自增加
	 */
	private boolean autoIncrement = false;

	public FieldInfo(String name, String type, String title) {
		super();
		this.name = name;
		this.type = type;
		this.title = title;
	}

	public FieldInfo(String name, String type, String title, String dbType) {
		super();
		this.name = name;
		this.type = type;
		this.title = title;
		this.dbType = dbType;
	}

	public FieldInfo(String name, String type, String title, boolean autoIncrement) {
		super();
		this.name = name;
		this.type = type;
		this.title = title;
		this.autoIncrement = autoIncrement;
	}

	public FieldInfo(String name, String type, String title, String dbType, boolean autoIncrement) {
		
		super();
		this.name = name;
		this.type = type;
		this.title = title;
		this.dbType = dbType;
		this.autoIncrement = autoIncrement;
	}

	public String getName() {
		name = StringUtil.cfd(name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
}
