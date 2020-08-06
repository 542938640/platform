package ${mongo.package_name}.controller.${mongo.module_name};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${mongo.package_name}.controller.mongo.BaseMongoController;
import ${mongo.package_name}.entity.${mongo.module_name}.${mongo.class_name}Entity;
import ${mongo.package_name}.service.${mongo.module_name}.${mongo.class_name}Service;

import io.swagger.annotations.Api;

/**
 *<p>Title:${mongo.class_name}Controller.java</p>
 *<p>Description:${mongo.name} Controller</p>
 *@author ${mongo.author}
 *@version 1.0
 *@Automatically generate by Coder in ${mongo.generator_time}
 */
@Api(tags = "${mongo.name}")
@RestController
@RequestMapping(value="/${mongo.class_name?uncap_first}")
public class ${mongo.class_name}Controller extends BaseMongoController<${mongo.class_name}Entity> {
	
	@Autowired
	private ${mongo.class_name}Service ${mongo.class_name?uncap_first}Service;
	
	@Override
    protected ${mongo.class_name}Service getService () {
        return ${mongo.class_name?uncap_first}Service;
    }

}