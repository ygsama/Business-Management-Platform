package com.xxx.sys.domain;

import java.util.HashSet;
import java.util.Set;

public class Role extends BaseEntity{
	private String id;
	private Set<User> users = new HashSet<User>(0);//角色与用户    多对多
	private Set<Module> modules = new HashSet<Module>(0);//角色模块多对多
	public Set<Module> getModules() {
		return modules;
	}
	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	private String name;//角色名
	private String remark;//备注
	private String orderNo;//排序号
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


}
