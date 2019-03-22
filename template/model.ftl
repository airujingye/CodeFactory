package com.greatmap.gmtravel.${table.packageName}entity;
<#list table.imports as import>
<#if import_index = 0>

</#if>
import ${import};
</#list>
/**
 * ${table.tableTitle}
 * 
 * @author zhaosj
 * 
 */
public class ${table.className} {
	
	/*
	* ${table.primaryKey.title}
	*/
	private ${table.primaryKey.type} ${table.primaryKey.name};
	
	<#list table.fieldList as f>
	/*
	* ${f.title}
	*/
	private ${f.type} ${f.name};
	
	</#list>

	
	/**
	* ${table.primaryKey.title}
	* @return
	*/
	public ${table.primaryKey.type} get${table.primaryKey.name?cap_first}() {
		return ${table.primaryKey.name};
	}

	/**
	* ${table.primaryKey.title}
	* @param ${table.primaryKey.name}
	*/
	public void set${table.primaryKey.name?cap_first}(${table.primaryKey.type} ${table.primaryKey.name}) {
		this.${table.primaryKey.name} = ${table.primaryKey.name};
	}
	
	<#list table.fieldList as f>
	/**
	* ${f.title}
	* @return
	*/
	public ${f.type} get${f.name?cap_first}() {
		return ${f.name};
	}

	/**
	* ${f.title}
	* @param ${f.name}
	*/
	public void set${f.name?cap_first}(${f.type} ${f.name}) {
		this.${f.name} = ${f.name};
	}
	
	</#list>
}
