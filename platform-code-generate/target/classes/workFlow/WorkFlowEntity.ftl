package ${config.package_name}.${config.module_name}.entity;

import ${config.package_name}.entity.BaseWorkFlowEntity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
<#list tableColumn as field>
	<#if field.field_type == "Date">
import java.util.Date;
		<#break>
	</#if>
</#list>
<#list tableColumn as field>
	<#if field.field_type == "BigDecimal">
import java.math.BigDecimal;
		<#break>
	</#if>
</#list>

/**
 *<p>Title:${config.class_name}Entity.java</p>
 *<p>Description:${tableInfo.remarks} Entity(对应表名:${tableInfo.table_name})</p>
 *@author ${config.author}
 *@version 1.0
 *@Automatically generate by Coder in ${config.generator_time}
 */
@TableName(value = "${tableInfo.table_name}")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ${config.class_name}Entity extends BaseWorkFlowEntity {

	private static final long serialVersionUID = 1L;
	
<#list tableColumn as field>
	<#if field.field_name != "id"
		&& field.field_name != "remark"
		&& field.field_name != "sysFlag"
		&& field.field_name != "creator"
		&& field.field_name != "createTime"
		&& field.field_name != "updater"
		&& field.field_name != "updateTime"
		&& field.field_name != "flowState"
		&& field.field_name != "flowTaskName"
		&& field.field_name != "flowIdea"
		&& field.field_name != "flowIdeaMsg"
		&& field.field_name != "flowOptUser"
		&& field.field_name != "flowOptTime">
    /**
     * ${field.remarks}
     */
    private ${field.field_type} ${field.field_name};
    
	</#if>
</#list>
}