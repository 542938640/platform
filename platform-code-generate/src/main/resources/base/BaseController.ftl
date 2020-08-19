package ${config.package_name}.${config.module_name}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${config.package_name}.controller.BaseController;
import ${config.package_name}.${config.module_name}.entity.${config.class_name}Entity;
import ${config.package_name}.${config.module_name}.service.${config.class_name}Service;

import io.swagger.annotations.Api;

/**
 *<p>Title:${config.class_name}Controller.java</p>
 *<p>Description:${tableInfo.remarks} Controller</p>
 *@author ${config.author}
 *@version 1.0
 *@Automatically generate by Coder in ${config.generator_time}
 */
@Api(tags = "${tableInfo.remarks}")
@RestController
@RequestMapping(value="${base.apiPath}")
public class ${config.class_name}Controller extends BaseController<${config.class_name}Entity> {
	
	@Autowired
	private ${config.class_name}Service ${config.class_name?uncap_first}Service;
	
	@Override
    protected ${config.class_name}Service getService () {
        return ${config.class_name?uncap_first}Service;
    }

}