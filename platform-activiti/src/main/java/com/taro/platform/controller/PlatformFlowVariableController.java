package com.taro.platform.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;import com.taro.controller.BaseController;import com.taro.platform.entity.PlatformFlowVariableEntity;import com.taro.platform.service.PlatformFlowVariableService;import io.swagger.annotations.Api;/** *<p>Title:PlatformFlowVariableController.java</p> *<p>Description:工作流流程变量 Controller</p> *@author taro *@version 1.0 *@Automatically generate by Coder in 2020-08-05 09:13:33 */@Api(tags = "工作流流程变量")@RestController@RequestMapping(value="/platform/flow/variable")public class PlatformFlowVariableController extends BaseController<PlatformFlowVariableEntity> {		@Autowired	private PlatformFlowVariableService platformFlowVariableService;		@Override    protected PlatformFlowVariableService getService () {        return platformFlowVariableService;    }}