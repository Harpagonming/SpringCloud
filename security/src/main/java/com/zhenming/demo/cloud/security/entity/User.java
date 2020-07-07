package com.zhenming.demo.cloud.security.entity;

import java.io.Serializable;

/**
 * t_user
 *
 * @author
 */
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  /**
   * 用户ID
   */
  private Integer userId;
  /**
   * 用户名
   */
  private String userName;
  /**
   * 密码
   */
  private String password;
  /**
   * 用户角色ID
   */
  private Integer roleId;
  /**
   * 删除状态
   */
  private Integer deleteStatus;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Integer getDeleteStatus() {
    return deleteStatus;
  }

  public void setDeleteStatus(Integer deleteStatus) {
    this.deleteStatus = deleteStatus;
  }
}