package com.xxx.sys.action.sysadmin;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Module;
import com.xxx.sys.service.ModuleService;
import com.xxx.sys.utils.Page;

/**
 * 
 * @author G
 *
 */
public class ModuleAction extends BaseAction implements ModelDriven<Module> {

	private Module model = new Module();
	
	@Override
	public Module getModel() {
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
	
	// 注入ModuleService
	private ModuleService moduleService;
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception{
		moduleService.findPage("from Module", page, Module.class,null);
		// 设置分页的url地址
		page.setUrl("moduleAction_list");
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
		Module Module = moduleService.get(Module.class, model.getId());
		// 放入栈顶
		super.push(Module);
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
		moduleService.saveOrUpdate(model);
		return "alist";
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		Module Module = moduleService.get(Module.class, model.getId());
		// 放入值栈
		super.push(Module);
	
		// 将查询结果放入值栈中
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() {
		// 调用业务
		Module obj = moduleService.get(Module.class, model.getId());
		// 设置修改的值
		obj.setName(model.getName());
		obj.setLayerNum(model.getLayerNum());
		obj.setCpermission(model.getCpermission());
		obj.setCurl(model.getCurl());
		obj.setCtype(model.getCtype());
		obj.setState(model.getState());
		obj.setBelong(model.getBelong());
		obj.setCwhich(model.getCwhich());
		obj.setOrderNo(model.getOrderNo());
		
		moduleService.saveOrUpdate(obj);
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
		
		moduleService.delete(Module.class, ids);
		
		return "alist";
	}
}
