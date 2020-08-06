package ${config.package_name}.${config.module_name}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${config.package_name}.${config.module_name}.mapper.${config.class_name}Mapper;
import ${config.package_name}.${config.module_name}.entity.${config.class_name}Entity;
import ${config.package_name}.service.impl.BaseServiceImpl;
import ${config.package_name}.${config.module_name}.service.${config.class_name}Service;

/**
 *<p>Title:${config.class_name}ServiceImpl.java</p>
 *<p>Description:${tableInfo.remarks} ServiceImpl</p>
 *@author ${config.author}
 *@version 1.0
 *@Automatically generate by Coder in ${config.generator_time}
 */
@Service
public class ${config.class_name}ServiceImpl extends BaseServiceImpl<${config.class_name}Entity> implements ${config.class_name}Service {
	
	@Autowired
	private ${config.class_name}Mapper ${config.class_name?uncap_first}Mapper;
	
    @Override
    protected ${config.class_name}Mapper getMapper() {
        return ${config.class_name?uncap_first}Mapper;
    }
    
}