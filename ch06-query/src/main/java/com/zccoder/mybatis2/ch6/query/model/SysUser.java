package com.zccoder.mybatis2.ch6.query.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 标题：用户表<br>
 * 描述：用户表<br>
 * 时间：2018/06/20<br>
 *
 * @author zc
 **/
public class SysUser implements Serializable{

    private static final long serialVersionUID = -8280230645677496806L;

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 邮箱
     */
    private String userEmail;
    /**
     * 简介
     */
    private String userInfo;
    /**
     * 头像
     */
    private byte[] headImg;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户角色（假定一个用户只有一个角色）
     */
    private SysRole role;
    /**
     * 用户角色集合
     */
    private List<SysRole> roleList;

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", headImg=" + Arrays.toString(headImg) +
                ", createTime=" + createTime +
                ", role=" + role +
                ", roleList=" + roleList +
                '}';
    }

    /**
     * 获取 用户ID
     *
     * @return id 用户ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 用户ID
     *
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 用户名
     *
     * @return userName 用户名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 密码
     *
     * @return userPassword 密码
     */
    public String getUserPassword() {
        return this.userPassword;
    }

    /**
     * 设置 密码
     *
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取 邮箱
     *
     * @return userEmail 邮箱
     */
    public String getUserEmail() {
        return this.userEmail;
    }

    /**
     * 设置 邮箱
     *
     * @param userEmail 邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取 简介
     *
     * @return userInfo 简介
     */
    public String getUserInfo() {
        return this.userInfo;
    }

    /**
     * 设置 简介
     *
     * @param userInfo 简介
     */
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * 获取 头像
     *
     * @return headImg 头像
     */
    public byte[] getHeadImg() {
        return this.headImg;
    }

    /**
     * 设置 头像
     *
     * @param headImg 头像
     */
    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    /**
     * 获取 创建时间
     *
     * @return createTime 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 用户角色（假定一个用户只有一个角色）
     *
     * @return role 用户角色（假定一个用户只有一个角色）
     */
    public SysRole getRole() {
        return this.role;
    }

    /**
     * 设置 用户角色（假定一个用户只有一个角色）
     *
     * @param role 用户角色（假定一个用户只有一个角色）
     */
    public void setRole(SysRole role) {
        this.role = role;
    }

    /**
     * 获取 用户角色集合
     *
     * @return roleList 用户角色集合
     */
    public List<SysRole> getRoleList() {
        return this.roleList;
    }

    /**
     * 设置 用户角色集合
     *
     * @param roleList 用户角色集合
     */
    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
