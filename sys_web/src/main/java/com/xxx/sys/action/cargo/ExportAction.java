package com.xxx.sys.action.cargo;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.domain.Export;
import com.xxx.sys.domain.User;
import com.xxx.sys.service.ContractService;
import com.xxx.sys.service.ExportService;
import com.xxx.sys.utils.Page;

/**
 * 
 * @author G
 *
 */
public class ExportAction extends BaseAction implements ModelDriven<Export> {

	private Export model = new Export();
	@Override
	public Export getModel() {
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
	
	// 注入ExportService
	private ExportService exportService;
	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}
	
	// 注入ContractService
	private ContractService contractService;
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception{
		String hql = "from Export where 1=1";
/*		User user = super.getCurUser();
		// 确定用户身份等级
//    	<input type="radio" name="userinfo.degree" value="0">超级管理员
//    	<input type="radio" name="userinfo.degree" value="1">跨部门跨人员
//    	<input type="radio" name="userinfo.degree" value="2">管理所有下属部门和人员
//    	<input type="radio" name="userinfo.degree" value="3">管理本部门
//    	<input type="radio" name="userinfo.degree" value="4">普通员工
 		int degree = user.getUserinfo().getDegree();
		if(degree == 4){
			// 普通员工
			hql += " and createBy='"+ user.getId() +"'";
		}else if(degree == 3){
			// 部门经理，管理本部门
			hql += " and createDept='"+ user.getDept().getId() +"'";
		}else if(degree == 2){
			// 管理所有下属部门和人员
			
		}else if(degree == 1){
			// 是副总
			
		}else if(degree == 0){
			// 是总经理，不需要条件
		}
*/		
		exportService.findPage(hql, page, Export.class,null);
		// 设置分页的url地址
		page.setUrl("exportAction_list");
		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}
	/**
	 * 查询状态为1的购销合同
	 * @return
	 * @throws Exception
	 */
	public String contractList() throws Exception {
		String hql = "from Contract where state=1";
		// 分页查询
		contractService.findPage(hql, page,Contract.class, null);
		page.setUrl("exportAction_contractList");
		// 放入值栈
		super.push(page);
		return "contractList";
	}
	
	
	/**
	 * 点击查看
	 * 		id=123
	 * model对象
	 * 		id=123
	 */
	public String toview() throws Exception {
		// 调用业务方法，根据id
		Export Export = exportService.get(Export.class, model.getId());
		// 放入栈顶
		super.push(Export);
		return "toview";
	}
	
	/**
	 * 进入报运单填写页面
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
		// 1.加入细粒度权限控制需要的数据
		User user = super.getCurUser();
		model.setCreateBy(user.getId());//设置创建者id
		model.setCreateDept(user.getDept().getId());//设置创建者所在部门的id
		
		// 调用业务方法
		exportService.saveOrUpdate(model);
		return contractList();
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		Export Export = exportService.get(Export.class, model.getId());
		// 放入值栈
		super.push(Export);
	
		// 将查询结果放入值栈中
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update()  throws Exception{
		// 调用业务
		Export obj = exportService.get(Export.class, model.getId());
		// 设置修改的值
		

		
		exportService.saveOrUpdate(obj);
		return "alist";
	}
	
	/**
	 * 删除
	 */
	public String delete() throws Exception{
		String[] ids = model.getId().split(",");
		
		exportService.delete(Export.class, ids);
		
		return "alist";
	}
	
	
	/**
	 * 提交
	 */
	public String submit() throws Exception{
		String[] ids =model.getId().split(",");
		exportService.changeState(ids, 1);
		return "alist";
	}
	
	/**
	 * 取消
	 */
	public String cancel() throws Exception{
		String[] ids =model.getId().split(",");
		exportService.changeState(ids, 0);
		return "alist";
	}
}
