package ${mongo.package_name}.service.${mongo.module_name}.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${mongo.package_name}.entity.${mongo.module_name}.${mongo.class_name}Entity;
import ${mongo.package_name}.service.mongo.impl.BaseMongoServiceImpl;
import ${mongo.package_name}.service.${mongo.module_name}.${mongo.class_name}Service;

/**
 *<p>Title:${mongo.class_name}ServiceImpl.java</p>
 *<p>Description:${mongo.name} ServiceImpl</p>
 *@author ${mongo.author}
 *@version 1.0
 *@Automatically generate by Coder in ${mongo.generator_time}
 */
@Service
public class ${mongo.class_name}ServiceImpl extends BaseMongoServiceImpl<${mongo.class_name}Entity> implements ${mongo.class_name}Service {
    
}