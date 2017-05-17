package com.xxx.sys.domain;

import java.util.HashSet;
import java.util.Set;

public class User extends BaseEntity {

	private String id;
	private Dept dept;//用户与部门   多对一
	private Userinfo userinfo ;  //用户与用户扩展信息    一对一
	private Set<Role> roles = new HashSet<Role>(0);//用户角色多对多
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	private String userName;//用户名
	private String password;//密码  要加密
	private Integer state;//状态
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	
}
