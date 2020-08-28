package com.taro.codegenerator.base;import java.io.StringWriter;import java.io.Writer;import java.sql.Connection;import java.sql.SQLException;import java.text.SimpleDateFormat;import java.util.Date;import java.util.HashMap;import java.util.Map;import org.apache.commons.lang3.StringUtils;import com.taro.codegenerator.ConfigEntity;import com.taro.database.DbManage;import com.taro.exception.BusinessException;import com.taro.utils.DatabaseUtil;import com.taro.utils.FileUtil;import freemarker.template.Configuration;import freemarker.template.Template;public class GeneratorBase {		public static void generate(Configuration configuration, ConfigEntity config) {		if(null == config) {			throw new BusinessException("配置为空,生成失败!");		}else if(StringUtils.isBlank(config.getClass_name())) {			throw new BusinessException("类名为空,生成失败!");		}else if(StringUtils.isBlank(config.getPackage_name())) {			throw new BusinessException("包名为空,生成失败!");		}else if(StringUtils.isBlank(config.getModule_name())) {			throw new BusinessException("模块名为空,生成失败!");		}				BaseEntity base = config.getBaseEntity();		if(null == base) {			throw new BusinessException("配置为空,生成失败!");		}else if(StringUtils.isBlank(base.getDb_type())) {			throw new BusinessException("数据库类型为空,生成失败!");		}else if(StringUtils.isBlank(base.getDb_host())) {			throw new BusinessException("数据库主机名或ip地址为空,生成失败!");		}else if(StringUtils.isBlank(base.getDb_port())) {			throw new BusinessException("数据库端口为空,生成失败!");		}else if(StringUtils.isBlank(base.getDb_database())) {			throw new BusinessException("数据库名为空,生成失败!");		}else if(StringUtils.isBlank(base.getDb_username())) {			throw new BusinessException("数据库用户名为空,生成失败!");		}else if(StringUtils.isBlank(base.getDb_password())) {			throw new BusinessException("数据库密码为空,生成失败!");		}else if(StringUtils.isBlank(base.getTable_name())) {			throw new BusinessException("表名为空,生成失败!");		}						// 变量名(首字母小写)		config.setGenerator_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));				Map<String, Object> param = getTableParam(config, base);		if(null == param) {			throw new BusinessException("变量错误,生成失败!");		}				// java路径		if(StringUtils.isNotBlank(config.getJava_url())) {			String java_url = config.getJava_url();			String resources_url = config.getJava_url();			if(java_url.indexOf("\\src\\main") == -1) {				java_url += "\\src\\main\\java";				resources_url += "\\src\\main\\resources";			}else {				resources_url.replace("java", "resources");			}			String[] packages = config.getPackage_name().split("\\.");			if(null != packages) {				for(String package_name : packages) {					java_url += "\\" + package_name;				}			}			generateController(configuration, java_url, config, param);			generateMapper(configuration, java_url, config, param);			generateEntity(configuration, java_url, config, param);			generateService(configuration, java_url, config, param);			generateServiceImpl(configuration, java_url, config, param);			generateMapperXML(configuration, resources_url, config, param);		}	}		public static void generateController(Configuration configuration, String java_url, ConfigEntity config, Map<String, Object> param) {		if(StringUtils.isNotBlank(java_url) && null != param) {			Writer out = new StringWriter();			try {				Template template = configuration.getTemplate("java/BaseController.ftl");				template.process(param, out);				FileUtil.writerFile(java_url + "\\" + config.getModule_name() + "\\controller\\" + config.getClass_name() + "Controller.java", out.toString());			} catch (Exception e) {				System.out.println("Controller文件生成失败!");				e.printStackTrace();			}		}	}	public static void generateMapper(Configuration configuration, String java_url, ConfigEntity config, Map<String, Object> param) {		if(StringUtils.isNotBlank(java_url) && null != param) {			Writer out = new StringWriter();			try {				Template template = configuration.getTemplate("java/BaseMapper.ftl");				template.process(param, out);				FileUtil.writerFile(java_url + "\\" + config.getModule_name() + "\\mapper\\" + config.getClass_name() + "Mapper.java", out.toString());			} catch (Exception e) {				System.out.println("Mapper文件生成失败!");				e.printStackTrace();			}		}	}	public static void generateEntity(Configuration configuration, String java_url, ConfigEntity config, Map<String, Object> param) {		if(StringUtils.isNotBlank(java_url) && null != param) {			Writer out = new StringWriter();			try {				Template template = configuration.getTemplate("java/BaseEntity.ftl");				template.process(param, out);				FileUtil.writerFile(java_url + "\\" + config.getModule_name() + "\\entity\\" + config.getClass_name() + "Entity.java", out.toString());			} catch (Exception e) {				System.out.println("Entity文件生成失败!");				e.printStackTrace();			}		}	}		public static void generateService(Configuration configuration, String java_url, ConfigEntity config, Map<String, Object> param) {		if(StringUtils.isNotBlank(java_url) && null != param) {			Writer out = new StringWriter();			try {				Template template = configuration.getTemplate("java/BaseService.ftl");				template.process(param, out);				FileUtil.writerFile(java_url + "\\" + config.getModule_name() + "\\service\\" + config.getClass_name() + "Service.java", out.toString());			} catch (Exception e) {				System.out.println("Service文件生成失败!");				e.printStackTrace();			}		}	}	public static void generateServiceImpl(Configuration configuration, String java_url, ConfigEntity config, Map<String, Object> param) {		if(StringUtils.isNotBlank(java_url) && null != param) {			Writer out = new StringWriter();			try {				Template template = configuration.getTemplate("java/BaseServiceImpl.ftl");				template.process(param, out);				FileUtil.writerFile(java_url + "\\" + config.getModule_name() + "\\service\\impl\\" + config.getClass_name() + "ServiceImpl.java", out.toString());			} catch (Exception e) {				System.out.println("ServiceImpl文件生成失败!");				e.printStackTrace();			}		}	}		public static void generateMapperXML(Configuration configuration, String resources_url, ConfigEntity config, Map<String, Object> param) {		if(StringUtils.isNotBlank(resources_url) && null != param) {			Writer out = new StringWriter();			try {				Template template = configuration.getTemplate("java/BaseMapperXML.ftl");				template.process(param, out);				FileUtil.writerFile(resources_url + "\\mapper\\" + config.getClass_name() + "Mapper.xml", out.toString());			} catch (Exception e) {				System.out.println("Mapper.XML文件生成失败!");				e.printStackTrace();			}		}	}	public static Map<String, Object> getTableParam(ConfigEntity config, BaseEntity base) {				Connection conn = null;		try {			conn = new DbManage(base.getDb_type())				.getConnection(base.getDb_host(), base.getDb_port(), base.getDb_database(), base.getDb_username(), base.getDb_password());		} catch (Exception e) {			e.printStackTrace();		}		if(null == conn) {			throw new BusinessException("数据库连接失败!");		}				String table_name = base.getTable_name();		String apiPath = "/";    	if(table_name.indexOf("_") != -1) {    		String[] humpArr = table_name.split("_");    		if(null != humpArr && humpArr.length > 1) {    			apiPath += humpArr[0];    			for(int i = 1, l = humpArr.length; i < l; i++) {    				apiPath += "/" + humpArr[i].substring(0, 1).toLowerCase() + humpArr[i].substring(1);    			}    		}    	}    	base.setApiPath(apiPath);				// 变量map		Map<String, Object> param = new HashMap<String, Object>();		param.put("config", config);		param.put("base", base);		param.put("tableInfo", DatabaseUtil.getTableInfo(conn, base.getTable_name()));		param.put("tableColumn", DatabaseUtil.getTableColumns(conn, base.getTable_name(), base));		param.put("tablePrimaryKey", DatabaseUtil.getTablePrimaryKey(conn, base.getTable_name()));		        try {        	conn.close();        } catch (SQLException e) {			throw new BusinessException("数据库关闭失败!");        }				return param;	}	}