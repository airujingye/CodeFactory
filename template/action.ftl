package com.greatmap.gmtravel.${table.packageName}action;

import javax.annotation.Resource;
import com.greatmap.gmtravel.common.util.StringUtil;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatmap.gmtravel.${table.packageName}entity.${table.className};
import com.greatmap.gmtravel.${table.packageName}service.I${table.className}Service;
import com.greatmap.gmtravel.common.util.Page;

/**
 * ${table.tableTitle}的控制类
 * 
 * @author zhaosj
 * 
 */
@Controller
@RequestMapping("/${table.pageFolder}")
public class ${table.className}Controller {

	// 注入${table.tableTitle}的业务服务类
	@Resource
	I${table.className}Service ${table.className?uncap_first}Service;

	/**
	 * 跳转到列表页面
	 * 
	 * @return 列表页面
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView gotoList() {

		return doSelect(new Page(1));
	}

	/**
	 * 
	 * 查询与翻页的控制
	 * @param page
	 * @return 列表页面
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView doSelect(Page page) {
		ModelAndView mav = new ModelAndView("${table.pageFolder}/${table.pageName}_list");
		page.setResult(${table.className?uncap_first}Service.selectByPage(page));
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 跳转到增加页面
	 * 
	 * @return 增加页面
	 */
	@RequestMapping(value = "/add_page", method = RequestMethod.GET)
	public ModelAndView gotoAddPage() {

		ModelAndView mav = new ModelAndView("${table.pageFolder}/${table.pageName}_input");
		return mav;
	}

	/**
	 * 保存一个新的${table.tableTitle}
	 * @param ${table.className?uncap_first}
	 * @return 增加页面
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView doAdd(${table.className} ${table.className?uncap_first}) {
		${table.className?uncap_first}.setId(StringUtil.getUUID());
		${table.className?uncap_first}Service.insert(${table.className?uncap_first});
		return new ModelAndView("redirect:list");
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @param ${table.primaryKey.name} 待修改的${table.tableTitle}的主键值
	 * @return 修改页面
	 */
	@RequestMapping(value = "/update_page", method = RequestMethod.GET)
	public ModelAndView gotoUpdatePage(@RequestParam("${table.primaryKey.name}") ${table.primaryKey.type} ${table.primaryKey.name}) {

		ModelAndView mav = new ModelAndView("${table.pageFolder}/${table.pageName}_input");
		mav.addObject("${table.className?uncap_first}", ${table.className?uncap_first}Service.selectById(${table.primaryKey.name}));

		return mav;
	}

	/**
	 * 修改一个${table.tableTitle}的信息
	 * 
	 * @param bean
	 * @return 修改页面
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView doUpdate(${table.className} bean) {

		${table.className?uncap_first}Service.update(bean);

		return new ModelAndView("redirect:list");
	}

	/**
	 * 删除一个${table.tableTitle}
	 * 
	 * @param ${table.primaryKey.name} 待删除的${table.tableTitle}的主键值
	 * @return 列表页面
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView doDelete(@RequestParam("${table.primaryKey.name}") ${table.primaryKey.type} ${table.primaryKey.name}) {

		${table.className?uncap_first}Service.delete(${table.primaryKey.name});

		return new ModelAndView("redirect:list");
	}

}
