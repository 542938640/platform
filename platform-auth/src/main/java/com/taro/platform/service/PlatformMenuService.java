package com.taro.platform.service;import java.util.List;import com.taro.platform.entity.PlatformMenuEntity;import com.taro.platform.vo.dto.MenuTreeDTO;import com.taro.service.BaseService;/** *<p>Title:PlatformMenuService.java</p> *<p>Description:系统菜单 Service</p> *@author taro *@version 1.0 *@Automatically generate by Coder in 2020-07-29 10:31:26 */public interface PlatformMenuService extends BaseService<PlatformMenuEntity> {    List<PlatformMenuEntity> selectAllMenu();    List<String> selectUserMenuIdList(String userId);        List<MenuTreeDTO> selectUserMenu(String userId);}