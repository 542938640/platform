package ${mongo.package_name}.entity.${mongo.module_name};

import ${mongo.package_name}.entity.BaseMongoEntity;
import java.io.Serializable;

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

/**
 *<p>Title:${mongo.class_name}Entity.java</p>
 *<p>Description:${tableInfo.remarks} Entity(对应集合名:${mongo.table_name})</p>
 *@author ${mongo.author}
 *@version 1.0
 *@Automatically generate by Coder in ${mongo.generator_time}
 */
@Document(collection = "${mongo.collection}")
public class ${mongo.class_name}Entity extends BaseMongoEntity {

	private static final long serialVersionUID = 1L;
	
<#list config.fieldList as field>
	<#if field.field_name != "id"
		&& field.field_name != "creator"
		&& field.field_name != "create_time"
		&& field.field_name != "updater"
		&& field.field_name != "update_time">
    /**
     * ${field.remarks}
     */
    private ${field.field_type} ${field.field_name};
    
	</#if>
</#list>
}