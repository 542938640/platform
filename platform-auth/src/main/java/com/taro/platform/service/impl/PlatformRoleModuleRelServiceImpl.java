package com.taro.platform.service.impl;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.cache.annotation.CacheEvict;import org.springframework.stereotype.Service;import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;import com.taro.exception.BusinessException;import com.taro.platform.entity.PlatformRoleModuleRelEntity;import com.taro.platform.mapper.PlatformRoleModuleRelMapper;import com.taro.platform.service.PlatformRoleModuleRelService;import com.taro.service.impl.BaseServiceImpl;import com.taro.utils.MyStringUtil;/** *<p>Title:PlatformRoleModuleRelServiceImpl.java</p> *<p>Description:角色功能关联关系 ServiceImpl</p> *@author taro *@version 1.0 *@Automatically generate by Coder in 2020-07-29 14:12:08 */@Servicepublic class PlatformRoleModuleRelServiceImpl extends BaseServiceImpl<PlatformRoleModuleRelEntity> implements PlatformRoleModuleRelService {		@Autowired	private PlatformRoleModuleRelMapper platformRoleModuleRelMapper;	    @Override    protected PlatformRoleModuleRelMapper getMapper() {        return platformRoleModuleRelMapper;    }	@CacheEvict(value="platform.perm", allEntries=true)	@Override	public PlatformRoleModuleRelEntity insert(PlatformRoleModuleRelEntity model) {		return super.insert(model);	}	@CacheEvict(value="platform.perm", allEntries=true)	@Override	public PlatformRoleModuleRelEntity updateById(PlatformRoleModuleRelEntity model) {		return super.updateById(model);	}	@CacheEvict(value="platform.perm", allEntries=true)	@Override	public PlatformRoleModuleRelEntity save(PlatformRoleModuleRelEntity model) {		return super.save(model);	}	@CacheEvict(value="platform.perm", allEntries=true)	@Override	public int deleteByRoleId(String roleId) {        if (MyStringUtil.isBlank(roleId)) {			throw new BusinessException("roleId为空！");        }		return getMapper().delete(new QueryWrapper<PlatformRoleModuleRelEntity>().eq("fk_role_id", roleId));	}	@CacheEvict(value="platform.perm", allEntries=true)	@Override	public int deleteByModuleId(String moduleId) {        if (MyStringUtil.isBlank(moduleId)) {			throw new BusinessException("moduleId为空！");        }		return getMapper().delete(new QueryWrapper<PlatformRoleModuleRelEntity>().eq("fk_module_id", moduleId));	}    }