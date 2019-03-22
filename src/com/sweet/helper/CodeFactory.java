package com.sweet.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

/**
 * SpringMVC 和 MyBatis的代码生成工具
 * 
 * @author chenhy
 * 
 */
public class CodeFactory {
	
	public static void main(String[] args) {
	//	String projectPath = Config.PROJECT_PATH;
	//	File filePath = new File(projectPath);
		/*try {
			// 清除工程
		//	FileUtils.deleteDirectory(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		List<TableInfo> tableInfos = new ArrayList<TableInfo>();
//		tableInfos.add(ModelUtil.creatModel("rgs_bug_temp","","BugTemp","service/bug","temp"));
//		tableInfos.add(ModelUtil.creatModel("rgs_recharge","pay.","Recharge","platform/pay","recharge"));
//		tableInfos.add(ModelUtil.creatModel("rgs_money_dynamic","pay.","MoneyDynamic","platform/pay","money"));
//		tableInfos.add(ModelUtil.creatModel("rgs_points_dynamic","pay.","PointsDynamic","platform/pay","points"));
//		tableInfos.add(ModelUtil.creatModel("rgs_shopping_cart","pay.","ShoppingCart","platform/pay","cart"));
//		tableInfos.add(ModelUtil.creatModel("rgs_orders","pay.","Orders","platform/pay","orders"));
		
		
//		tableInfos.add(ModelUtil.creatModel("rgs_training","","Training","modules/course","course"));
//		tableInfos.add(ModelUtil.creatModel("rgs_course_chapter","course.","CourseChapter","modules/course","course_chapter"));
//		tableInfos.add(ModelUtil.creatModel("rgs_course_section","course.","CourseSection","modules/course","course_section"));
//		tableInfos.add(ModelUtil.creatModel("rgs_course_complete","course.","CourseComplete","modules/course","complete"));
//		tableInfos.add(ModelUtil.creatModel("rgs_course_join","course.","CourseJoin","modules/course","join"));
//		tableInfos.add(ModelUtil.creatModel("rgs_course_judge","course.","CourseJudge","modules/course","judge"));
//		tableInfos.add(ModelUtil.creatModel("t_journal","modules.journal.","Tjournal","modules/journal","journal"));
		tableInfos.add(ModelUtil.creatModel("t_homepage","modules.homepage.","Thomepage","modules/homepage","Thomepage"));
//		tableInfos.add(ModelUtil.creatModel("rgs_training_copy","course.","TrainingCopy","modules/course","course"));
//		tableInfos.add(ModelUtil.creatModel("rgs_course_copy","course.","CourseCopy","modules/course","course"));
		
		createAll(tableInfos);
	}
	
	public static void createAll(List<TableInfo> tableInfos) {
		initConfig();

		for (TableInfo tableInfo : tableInfos) {
			createModel(tableInfo);
			createMapper(tableInfo);
			createMapperXml(tableInfo);
			createService(tableInfo);
			createServiceImpl(tableInfo);
			createAction(tableInfo);
			createJsp(tableInfo);
			
			System.out.println(tableInfo.getTableName()+"：生成完毕！");
		}
		
	}
	
	private static Configuration cfg;

	private static void initConfig() {
		if (cfg == null) {
			cfg = new Configuration(Configuration.VERSION_2_3_23);
			try {
				cfg.setDirectoryForTemplateLoading(new File(Config.FTLS_PATH));
			} catch (IOException e) {
				e.printStackTrace();
			}
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		}
	}


	public static void createModel(TableInfo table) {
		initConfig();
		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("table", table);
			//String packageName=table.getOutPutPackageName();
			String beanPath = Config.OUTPUT_JAVA_PATH + table.getOutPutPackageName()+"/entity/";
			File filePath = new File(beanPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			String filePathOfBean = beanPath + table.getClassName() + ".java";
			File file = new File(filePathOfBean);
			if (!file.exists()) {
				file.createNewFile();
			}

			// 显示生成的数据
			Writer writer = new FileWriter(file);
			Template template = cfg.getTemplate("model.ftl");
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 创建Mapper接口类
	 * 
	 * @param table
	 *            表的注册信息
	 */
	public static void createMapper(TableInfo table) {
		initConfig();

		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("table", table);

			String beanPath = Config.OUTPUT_JAVA_PATH + table.getOutPutPackageName()+"/mapper/";
			File filePath = new File(beanPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			String filePathOfBean = beanPath + table.getClassName()
					+ "Mapper.java";
			File file = new File(filePathOfBean);
			if (!file.exists()) {
				file.createNewFile();
			}

			// 显示生成的数据
			Writer writer = new FileWriter(file);
			Template template = cfg.getTemplate("mapper.ftl");
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

	public static void createMapperXml(TableInfo table) {
		initConfig();

		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("table", table);

			String beanPath = Config.OUTPUT_JAVA_PATH + table.getOutPutPackageName()+"/mapper/";
			File filePath = new File(beanPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			String filePathOfBean = beanPath + table.getClassName()
					+ "Mapper.xml";
			File file = new File(filePathOfBean);
			if (!file.exists()) {
				file.createNewFile();
			}

			// 显示生成的数据
			Writer writer = new FileWriter(file);
			Template template = cfg.getTemplate("mapperxml.ftl");
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

	public static void createService(TableInfo table) {
		initConfig();

		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("table", table);

			String beanPath = Config.OUTPUT_JAVA_PATH + table.getOutPutPackageName()+"/service/";
			File filePath = new File(beanPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			String filePathOfBean = beanPath + "I" + table.getClassName()
					+ "Service.java";
			File file = new File(filePathOfBean);
			if (!file.exists()) {
				file.createNewFile();
			}

			// 显示生成的数据
			Writer writer = new FileWriter(file);
			Template template = cfg.getTemplate("service.ftl");
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}
	
	public static void createServiceImpl(TableInfo table) {
		initConfig();

		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("table", table);

			String beanPath = Config.OUTPUT_JAVA_PATH + table.getOutPutPackageName()+"/service/impl/";
			File filePath = new File(beanPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			String filePathOfBean = beanPath + table.getClassName()
					+ "ServiceImpl.java";
			File file = new File(filePathOfBean);
			if (!file.exists()) {
				file.createNewFile();
			}

			// 显示生成的数据
			Writer writer = new FileWriter(file);
			Template template = cfg.getTemplate("serviceImpl.ftl");
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}
	

	public static void createAction(TableInfo table) {
		initConfig();

		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("table", table);

			String beanPath = Config.OUTPUT_JAVA_PATH + table.getOutPutPackageName() + "/action/";
			File filePath = new File(beanPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			String filePathOfBean = beanPath + table.getClassName()
					+ "Controller.java";
			File file = new File(filePathOfBean);
			if (!file.exists()) {
				file.createNewFile();
			}

			// 显示生成的数据
			Writer writer = new FileWriter(file);
			Template template = cfg.getTemplate("action.ftl");
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

	public static void createJsp(TableInfo table) {
		initConfig();

		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("table", table);

			String beanPath = Config.OUTPUT_JSP_PATH;
			File filePath = new File(beanPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			// 列表页面
			{
				String filePathOfBean = beanPath + table.getPageFolder() + "/"
						+ table.getPageName() + "_list.jsp";
				File file = new File(filePathOfBean);
				File parentFile = file.getParentFile();
				if(!parentFile.exists()){
					parentFile.mkdirs();
				}
				if (!file.exists()) {
					file.createNewFile();
				}

				// 显示生成的数据
				Writer writer = new FileWriter(file);
				Template template = cfg.getTemplate("jsp_list.ftl");
				template.process(root, writer);
				writer.flush();
				writer.close();
			}
			// 添加页面
			{
				String filePathOfBean = beanPath + table.getPageFolder() + "/"
						+ table.getPageName() + "_add.jsp";
				File file = new File(filePathOfBean);
				File parentFile = file.getParentFile();
				if(!parentFile.exists()){
					parentFile.mkdirs();
				}
				if (!file.exists()) {
					file.createNewFile();
				}

				// 显示生成的数据
				Writer writer = new FileWriter(file);
				Template template = cfg.getTemplate("jsp_add.ftl");
				template.process(root, writer);
				writer.flush();
				writer.close();
			}
			// 修改页面
			{
				String filePathOfBean = beanPath + table.getPageFolder() + "/"
						+ table.getPageName() + "_update.jsp";
				File file = new File(filePathOfBean);
				File parentFile = file.getParentFile();
				if(!parentFile.exists()){
					parentFile.mkdirs();
				}
				if (!file.exists()) {
					file.createNewFile();
				}

				// 显示生成的数据
				Writer writer = new FileWriter(file);
				Template template = cfg.getTemplate("jsp_update.ftl");
				template.process(root, writer);
				writer.flush();
				writer.close();
			}
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}
	
}
