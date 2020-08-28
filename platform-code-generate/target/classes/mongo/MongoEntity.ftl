package ${config.package_name}.${config.module_name}.entity;

import ${config.package_name}.entity.BaseMongoEntity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *<p>Title:${config.class_name}Entity.java</p>
 *<p>Description:${mongo.name} Entity(对应集合名:${mongo.collection})</p>
 *@author ${config.author}
 *@version 1.0
 *@Automatically generate by Coder in ${config.generator_time}
 */
@Document(collection = "${mongo.collection}")
public class ${config.class_name}Entity extends BaseMongoEntity {

	private static final long serialVersionUID = 1L;
	
<#list mongo.fieldList as field>
    /**
     * ${field.remarks}
     */
    private ${field.field_type} ${field.field_name};
    
</#list>
}