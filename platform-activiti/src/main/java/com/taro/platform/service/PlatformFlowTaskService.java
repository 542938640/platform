package com.taro.platform.service;import java.util.List;import com.taro.platform.entity.PlatformFlowTaskEntity;import com.taro.service.BaseService;/** *<p>Title:PlatformFlowTaskService.java</p> *<p>Description:工作流流程任务 Service</p> *@author taro *@version 1.0 *@Automatically generate by Coder in 2020-08-05 09:26:22 */public interface PlatformFlowTaskService extends BaseService<PlatformFlowTaskEntity> {    List<PlatformFlowTaskEntity> selectListByFlowKey(String flowKey);    }