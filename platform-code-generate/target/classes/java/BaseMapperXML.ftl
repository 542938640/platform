<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- @Automatically generate by Coder in ${config.generator_time} -->
<#assign table_prefix = "t"/>
<mapper namespace="${config.package_name}.${config.module_name}.mapper.${config.class_name}Mapper">

  	<resultMap id="BaseResultMap" type="${config.package_name}.${config.module_name}.entity.${config.class_name}Entity">
	  	<id column="id" property="id" jdbcType="VARCHAR" />
  		<result column="id" property="id" jdbcType="VARCHAR" />
		<#list tableColumn as field>
  		<result column="${field.column_name}" property="${field.field_name}" jdbcType="${field.type_name?upper_case}" />
		</#list>
  	</resultMap>

  	<sql id="Base_Column_List" >
  		<#assign Base_Column_List = "t.id,\r"/>
		<#list tableColumn as field>
			<#assign Base_Column_List = Base_Column_List + "		" + table_prefix + "." + field.column_name +",\r" />
		</#list>
		${Base_Column_List}
  	</sql>

  	<sql id="where_sql">
		<if test="id != null and id != ''" >
			and t.id = ${"#{"}id, jdbcType=VARCHAR}
		</if>
	<#list tableColumn as field>
		<if test="${field.field_name} != null and ${field.field_name} != ''" >
			and ${table_prefix}.${field.column_name} = ${"#{"}${field.field_name}, jdbcType=${field.type_name?upper_case}}
		</if>
	</#list>
  	</sql>

</mapper>