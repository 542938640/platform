package com.taro.platform.entity;import com.baomidou.mybatisplus.annotation.TableName;import com.taro.entity.BaseEntity;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.experimental.Accessors;/** *<p>Title:PlatformUserEntity.java</p> *<p>Description:系统用户 Entity(对应表名:platform_user)</p> *@author taro *@version 1.0 *@Automatically generate by Coder in 2020-07-29 10:45:49 */@TableName(value = "platform_user")@Data@EqualsAndHashCode(callSuper = true)@Accessors(chain = true)public class PlatformUserEntity extends BaseEntity {	private static final long serialVersionUID = 1L;	    /**     * 用户名     */    private String username;        /**     * 密码     */    private String password;        /**     * 昵称     */    private String nickname;        /**     * 状态(1:启用,0:停用)     */    private String status;        /**     * 性别(0:未知,1:男,2:女)     */    private String sex;        /**     * email     */    private String email;        /**     * 手机号码     */    private String mobile;        /**     * 生日     */    private String birthday;        /**     * 年龄     */    private Integer age;        /**     * 照片     */    private String picture;        /**     * 加密盐     */    private String salt;        /**     * 排序     */    private Integer sort;        /**     * 是否系统内置(1:是,0:否)     */    private String isSystem;        /**     *      */    private String c1;        /**     *      */    private String c2;        /**     *      */    private String c3;        /**     *      */    private String c4;        /**     *      */    private String c5;        /**     *      */    private String c6;        /**     *      */    private String c7;        /**     *      */    private String c8;        /**     *      */    private String c9;        /**     *      */    private String c10;    }