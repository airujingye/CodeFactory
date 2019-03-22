package com.greatmap.gmtravel.${table.packageName}mapper;

import java.util.List;

import com.greatmap.gmtravel.${table.packageName}entity.${table.className};
import com.greatmap.gmtravel.common.util.Page;

/**
 * ${table.tableTitle}的数据库映射类
 * 
 * @author zhaosj
 * 
 */
public interface ${table.className}Mapper {

	/**
	 * 保存一个新的${table.tableTitle}信息
	 * 
	 * @param bean 要保存的${table.tableTitle}对象${table.className}
	 * @return
	 */
	int insert(${table.className} bean);

	/**
	 * 修改一个${table.tableTitle}的信息
	 * 
	 * @param bean 将要修改的${table.tableTitle}对象，包含了新的数据
	 * @return 更新了几条，一般可用来验证是否成功更新
	 */
	int update(${table.className} bean);

	/**
	 * 删除一个${table.tableTitle}
	 * 
	 * @param id 删除的${table.tableTitle}的主键值
	 * @return 删除了几条
	 */
	int delete(${table.primaryKey.type} id);

	/**
	 * 根据主键查询
	 * 
	 * @param id ${table.tableTitle}的主键值
	 * @return ${table.tableTitle}信息对象
	 */
	${table.className} selectById(${table.primaryKey.type} id);

	/**
	 * 根据分页信息进行查询
	 * 
	 * @param page 分页信息，包括开始行数，结束行数等信息
	 * @return 获取到的${table.tableTitle}信息列表
	 */
	List<${table.className}> selectByPage(Page page);

	/**
	 * 查询所有的${table.tableTitle}信息
	 * 
	 * @return ${table.tableTitle}信息的对象列表
	 */
	List<${table.className}> selectAll();

	/**
	 * 查询总共有多少条记录
	 * 
	 * @return 记录的个数
	 */
	int count();

}
