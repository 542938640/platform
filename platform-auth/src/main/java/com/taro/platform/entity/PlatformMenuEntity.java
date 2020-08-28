package com.taro.platform.entity;import com.baomidou.mybatisplus.annotation.TableName;import com.taro.entity.BaseEntity;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.experimental.Accessors;/** *<p>Title:PlatformMenuEntity.java</p> *<p>Description:系统菜单 Entity(对应表名:platform_menu)</p> *@author taro *@version 1.0 *@Automatically generate by Coder in 2020-07-29 10:31:26 */@TableName(value = "platform_menu")@Data@EqualsAndHashCode(callSuper = true)@Accessors(chain = true)public class PlatformMenuEntity extends BaseEntity {	private static final long serialVersionUID = 1L;	    /**     * 父级id     */    private String fkParentId;        /**     * 菜单名称     */    private String menuName;        /**     * 菜单编码     */    private String menuCode;        /**     * 菜单路由     */    private String menuUrl;        /**     * 菜单图标     */    private String menuIcon;        /**     * 国际化     */    private String i18n;        /**     * 状态(1:启用,0:停用)     */    private String status;        /**     * 排序     */    private Integer sort;        /**     * 是否系统内置(1:是,0:否)     */    private String isSystem;        /**     *      */    private String c1;        /**     *      */    private String c2;        /**     *      */    private String c3;        /**     *      */    private String c4;        /**     *      */    private String c5;    }