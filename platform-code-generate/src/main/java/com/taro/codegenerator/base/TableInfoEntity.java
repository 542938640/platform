package com.taro.codegenerator.base;import lombok.Getter;import lombok.Setter;@Getter@Setterpublic class TableInfoEntity {	private String table_name;		// 表名称	private String table_type;		// 表类型	private String table_cat;		// 表所属数据库	private String table_schem;		// 表所属用户名	private String remarks;			// 表备注}