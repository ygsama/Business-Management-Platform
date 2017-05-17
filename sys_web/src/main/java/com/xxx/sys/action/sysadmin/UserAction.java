package com.xxx.sys.action.sysadmin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Dept;
import com.xxx.sys.domain.Role;
import com.xxx.sys.domain.User;
import com.xxx.sys.service.DeptService;
import com.xxx.sys.service.RoleService;
import com.xxx.sys.service.UserService;
import com.xxx.sys.utils.Page;

/**
 * 用户管理的Action
 * @author G
 *
 */
public class UserAction extends BaseAction implements ModelDriven<User> {

	private User model = new User();
	
	@Override
	public User getModel() {
		return model;
	}

	// 分页
	private Page page = new Page();

	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	// 注入UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	// 注入DeptService
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	// 注入RoleService
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception{
		userService.findPage("from User", page, User.class,null);
		// 设置分页的url地址
		page.setUrl("userAction_list");
		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}
	
	/**
	 * 点击查看
	 * 		id=123
	 * model对象
	 * 		id=123
	 */
	public String toview() throws Exception {
		// 调用业务方法，根据id
		User user = userService.get(User.class, model.getId());
		// 放入栈顶
		super.push(user);
		return "toview";
	}
	
	/**
	 * 进入新增页
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		// 调用业务方法
		List<Dept> deptList = deptService.find("from Dept where state=1", Dept.class, null);
		List<User> userList = userService.find("from User where state=1", User.class, null);
		// 将查询结果放入值栈中
		super.put("deptList",deptList);
		super.put("userList",userList);
		// 跳页面
		return "tocreate";
	}
	
	/**
	 * 保存
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		// 调用业务方法
		userService.saveOrUpdate(model);
		return "alist";
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		User user = userService.get(User.class, model.getId());
		// 放入值栈
		super.push(user);
		// 查询父部门
		List<Dept> deptList = deptService.find("from Dept where state=1 ", Dept.class, null);
		
		// 将查询结果放入值栈中
		super.put("deptList", deptList);
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() {
		// 调用业务
		User obj = userService.get(User.class, model.getId());
		// 设置修改的值
		obj.setDept(model.getDept());
		obj.setUserName(model.getUserName());
		obj.setState(model.getState());
		userService.saveOrUpdate(obj);
		return "alist";
	}
	
	/**
	 * 删除
	 * model 
	 * 		id String 
	 * 		同名的checkbox一组值如何封装数据
	 * 			String类型会由逗号分隔
	 * 		id Integer Float Double Date
	 * 		只保留最后一个值
	 * 			Integer[] id 用数组或list集合接
	 */
	public String delete() throws Exception {
		String[] ids = model.getId().split(",");
		
		userService.delete(User.class, ids);
		
		return "alist";
	}
	
	/**
	 * 设置权限
	 */
	public String torole() throws Exception {
		
		// 根据ID得到对象，并放入值栈顶
		User obj = userService.get(User.class, model.getId());
		super.push(obj);
		// 调用角色业务方法，得到所有角色列表，并放入值栈
		List<Role> roleList = roleService.find("from Role", Role.class, null);
		super.put("roleList", roleList);
		// 得到当前用户的角色列表,将遍历的角色名字符串放入值栈
		Set<Role> roleSet = obj.getRoles();
		StringBuilder sb = new StringBuilder();
		for (Role role : roleSet) {
			sb.append(role.getName()).append(",");
		}
		super.put("roleStr",sb.toString());
		return "torole";
	}
	
	/**
	 * 分配角色，保存
	 */
	public String role() throws Exception {
		// 根据id得到对象;遍历roleIds，获得角色列表，将角色列表设置给用户
		User obj = userService.get(User.class, model.getId());
		Set<Role> roles = new HashSet<Role>();//选中的角色列表
		for (String id : roleIds) {
			Role role = roleService.get(Role.class, id);
			roles.add(role);
		}
		obj.setRoles(roles);
		userService.saveOrUpdate(obj);//影响的是用户角色中间表
		return "alist";
	}
	private String[] roleIds;//保存jsp中选中的角色列表
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
}
