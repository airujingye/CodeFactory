package com.greatmap.gmtravel.${table.packageName}service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.greatmap.gmtravel.common.util.StringUtil;
import org.springframework.stereotype.Service;

import com.greatmap.gmtravel.${table.packageName}entity.${table.className};
import com.greatmap.gmtravel.${table.packageName}service.I${table.className}Service;
import com.greatmap.gmtravel.${table.packageName}mapper.${table.className}Mapper;
import com.greatmap.gmtravel.common.util.Page;

/**
 * ${table.tableTitle}的业务服务类
 * 
 * @author zhaosj
 * 
 */
@Service
public class ${table.className}ServiceImpl implements I${table.className}Service{

	// 注入对表${table.tableName}的数据库操作类
	@Resource
	${table.className}Mapper ${table.className?uncap_first}Mapper;

	/**
	 * 查询${table.tableTitle}的数据
	 * 
	 * @return ${table.tableTitle}对象${table.className}的列表
	 */
	@Override
	public List<${table.className}> selectByPage(Page page) {
		return ${table.className?uncap_first}Mapper.selectByPage(page);
	}

	/**
	 * 查询一个${table.tableTitle}的信息
	 * 
	 * @param ${table.primaryKey.name} ${table.tableTitle}的主键值
	 * @return ${table.tableTitle}对象${table.className}
	 */
	@Override
	public ${table.className} selectById(${table.primaryKey.type} ${table.primaryKey.name}) {
		return ${table.className?uncap_first}Mapper.selectById(${table.primaryKey.name});
	}

	/**
	 * 更新一个${table.tableTitle}的信息
	 * 
	 * @param bean 待更新的${table.tableTitle}对象
	 */
	@Override
	public void update(${table.className} bean) {
		${table.className?uncap_first}Mapper.update(bean);
	}

	/**
	 * 新增一个${table.tableTitle}
	 * 
	 * @param bean ${table.tableTitle}对象
	 */
	@Override
	public void insert(${table.className} bean) {
		//设置id
		if (bean.getId() == null) {
			bean.setId(StringUtil.getUUID());
		}
		${table.className?uncap_first}Mapper.insert(bean);
	}

	/**
	 * 删除一个${table.tableTitle}
	 * 
	 * @param ${table.primaryKey.name} ${table.tableTitle}的主键值
	 */
	@Override
	public void delete(${table.primaryKey.type} ${table.primaryKey.name}) {
		${table.className?uncap_first}Mapper.delete(${table.primaryKey.name});
	}
}
