package com.greatmap.gmtravel.${table.packageName}service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatmap.gmtravel.${table.packageName}entity.${table.className};
import com.greatmap.gmtravel.common.util.Page;

/**
 * ${table.tableTitle}的业务服务类
 * 
 * @author zhaosj
 * 
 */
public interface I${table.className}Service {

	/**
	 * 查询${table.tableTitle}的数据
	 * 
	 * @return ${table.tableTitle}对象${table.className}的列表
	 */
	List<${table.className}> selectByPage(Page page);

	/**
	 * 查询一个${table.tableTitle}的信息
	 * 
	 * @param ${table.primaryKey.name} ${table.tableTitle}的主键值
	 * @return ${table.tableTitle}对象${table.className}
	 */
	${table.className} selectById(${table.primaryKey.type} ${table.primaryKey.name});

	/**
	 * 更新一个${table.tableTitle}的信息
	 * 
	 * @param bean 待更新的${table.tableTitle}对象
	 */
	void update(${table.className} bean);

	/**
	 * 新增一个${table.tableTitle}
	 * 
	 * @param bean ${table.tableTitle}对象
	 */
	void insert(${table.className} bean);

	/**
	 * 删除一个${table.tableTitle}
	 * 
	 * @param ${table.primaryKey.name} ${table.tableTitle}的主键值
	 */
	void delete(${table.primaryKey.type} ${table.primaryKey.name});
}
