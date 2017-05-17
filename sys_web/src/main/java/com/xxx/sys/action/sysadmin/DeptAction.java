package com.xxx.sys.action.sysadmin;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Dept;
import com.xxx.sys.service.DeptService;
import com.xxx.sys.utils.Page;

/**
 * 部门管理的Action
 * @author G
 *
 */
public class DeptAction extends BaseAction implements ModelDriven<Dept> {

	private Dept model = new Dept();
	
	@Override
	public Dept getModel() {
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
	
	// 注入DeptService
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception{
		deptService.findPage("from Dept", page, Dept.class,null);
		// 设置分页的url地址
		page.setUrl("deptAction_list");
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
		Dept dept = deptService.get(Dept.class, model.getId());
		// 放入栈顶
		super.push(dept);
		return "toview";
	}
	
	/**
	 * 进入新增页
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		// 调用业务方法
		List<Dept> deptList = deptService.find("from Dept where state=1 ", Dept.class, null);
		// 将查询结果放入值栈中
		super.put("deptList", deptList);
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
		deptService.saveOrUpdate(model);
		return "alist";
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		Dept dept = deptService.get(Dept.class, model.getId());
		// 放入值栈
		super.push(dept);
		// 查询父部门
		List<Dept> deptList = deptService.find("from Dept where state=1 ", Dept.class, null);
		// 从列表中移除被选中修改的部门
		deptList.remove(dept);
		// 将查询结果放入值栈中
		super.put("deptList", deptList);
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() {
		// 调用业务
		Dept obj = deptService.get(Dept.class, model.getId());
		// 设置修改的值
		obj.setParent(model.getParent());
		obj.setDeptName(model.getDeptName());
		deptService.saveOrUpdate(obj);
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
	public String delete() {
		String[] ids = model.getId().split(",");
		
		deptService.delete(Dept.class, ids);
		
		return "alist";
	}
}
