package com.taro.codegenerator.base;import lombok.Getter;import lombok.Setter;@Getter@Setterpublic class BaseEntity {	private String db_type;						// 数据库类型	private String db_host;						// 数据库主机名或ip地址	private String db_port;						// 数据库端口	private String db_database;					// 数据库名	private String db_username;					// 数据库用户名	private String db_password;					// 数据库密码	private String table_name;					// 表名	private String apiPath;						// api路径	private String isRelTable;					// 是否是关联关系表}