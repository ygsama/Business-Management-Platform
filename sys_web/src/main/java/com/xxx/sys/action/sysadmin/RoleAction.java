package com.xxx.sys.action.sysadmin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Module;
import com.xxx.sys.domain.Role;
import com.xxx.sys.service.ModuleService;
import com.xxx.sys.service.RoleService;
import com.xxx.sys.utils.Page;

/**
 * 用户管理的Action
 * @author G
 *
 */
public class RoleAction extends BaseAction implements ModelDriven<Role> {

	private Role model = new Role();
	
	@Override
	public Role getModel() {
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
	
	// 注入RoleService
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	private ModuleService moduleService;
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception{
		roleService.findPage("from Role", page, Role.class,null);
		// 设置分页的url地址
		page.setUrl("roleAction_list");
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
		Role Role = roleService.get(Role.class, model.getId());
		// 放入栈顶
		super.push(Role);
		return "toview";
	}
	
	/**
	 * 进入新增页
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {

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
		roleService.saveOrUpdate(model);
		return "alist";
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		Role Role = roleService.get(Role.class, model.getId());
		// 放入值栈
		super.push(Role);
	
		// 将查询结果放入值栈中
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() throws Exception {
		// 调用业务
		Role obj = roleService.get(Role.class, model.getId());
		// 设置修改的值
		obj.setName(model.getName());
		obj.setRemark(model.getRemark());
		roleService.saveOrUpdate(obj);
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
		
		roleService.delete(Role.class, ids);
		
		return "alist";
	}
	
	/**
	 * 进入模块分配页面
	 */
	public String tomodule()throws Exception {
		//根据角色id得到角色对象
		Role obj = roleService.get(Role.class, model.getId());
		super.push(obj);

		return "tomodule";
	}
	/**
	 * 提供zTree树插件需要的json数据
	 * 1.json数组格式
	 * 	[{"id":"模块id","pId"："父模块Id","name":"模块名","checked":"true"},{...},{....}]
	 * 2.常用的json插件
	 * 	json-lib		fastjson	struts-json-plugin-xxx.jar	手动拼接
	 * 3.如何输出？
	 * 	response
	 */
	public String roleModuleJsonStr() throws Exception {
		// 根据角色id得到角色对象
		Role role = roleService.get(Role.class, model.getId());
		// 通过对象导航，加载当前角色的模块列表
		Set<Module> moduleSet = role.getModules();
		// 加载出所有模块列表
		List<Module> moduleList = moduleService.find("from Module", Module.class, null);
		// 拼接json
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for (Module module : moduleList) {
			sb.append("{\"id\":\"").append(module.getId())
				.append("\",\"pId\":\"").append(module.getParentId())
				.append("\",\"name\":\"").append(module.getName())
				.append("\",\"checked\":\"").append(moduleSet.contains(module)?"true":"false")
				.append("\"},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		// 得到response
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-chache");
		// 输出
		response.getWriter().write(sb.toString());
		return NONE;
	}
	
	/**
	 * 进入模块分配页面
	 */
	public String module()throws Exception {
		// 哪个角色
		Role role = roleService.get(Role.class, model.getId());
		// 选中的模块
		String[] ids = moduleIds.split(",");
		// 加载这些模块列表
		Set<Module> moduleSet = new HashSet<Module>();
		if(ids!=null && ids.length>0){
			for (String id : ids) {
				moduleSet.add(moduleService.get(Module.class, id));
			}
		}
		// 角色设置模块
		role.setModules(moduleSet);
		roleService.saveOrUpdate(role);
		return "alist";
	}
	
	private String moduleIds;
	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}
}
