package com.taro.platform.service.impl;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import com.taro.platform.entity.PlatformBaseAttrEntity;import com.taro.platform.mapper.PlatformBaseAttrMapper;import com.taro.platform.service.PlatformBaseAttrService;import com.taro.service.impl.BaseServiceImpl;/** *<p>Title:PlatformBaseAttrServiceImpl.java</p> *<p>Description:数据数据类型属性 ServiceImpl</p> *@author taro *@version 1.0 *@Automatically generate by Coder in 2020-07-27 14:51:56 */@Servicepublic class PlatformBaseAttrServiceImpl extends BaseServiceImpl<PlatformBaseAttrEntity> implements PlatformBaseAttrService {		@Autowired	private PlatformBaseAttrMapper platformBaseAttrMapper;	    @Override    protected PlatformBaseAttrMapper getMapper() {        return platformBaseAttrMapper;    }    }