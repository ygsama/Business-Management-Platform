package com.xxx.sys.action.cargo;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.domain.User;
import com.xxx.sys.service.ContractService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.SysConstant;

/**
 * 
 * @author G
 *
 */
public class ContractAction extends BaseAction implements ModelDriven<Contract> {

	private Contract model = new Contract();
	@Override
	public Contract getModel() {
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
	
	// 注入ContractService
	private ContractService contractService;
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	
	
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception{
		String hql = "from Contract where 1=1";
		User user = super.getCurUser();
		// 确定用户身份等级
//    	<input type="radio" name="userinfo.degree" value="0">超级管理员
//    	<input type="radio" name="userinfo.degree" value="1">跨部门跨人员
//    	<input type="radio" name="userinfo.degree" value="2">管理所有下属部门和人员
//    	<input type="radio" name="userinfo.degree" value="3">管理本部门
//    	<input type="radio" name="userinfo.degree" value="4">普通员工
 		int degree = user.getUserinfo().getDegree();
 		System.out.println("degree -------------->"+degree);
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
		
		
		contractService.findPage(hql, page, Contract.class,null);
		// 设置分页的url地址
		page.setUrl("contractAction_list");
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
		Contract Contract = contractService.get(Contract.class, model.getId());
		// 放入栈顶
		super.push(Contract);
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
		// 1.加入细粒度权限控制需要的数据
		User user = super.getCurUser();
		model.setCreateBy(user.getId());//设置创建者id
		model.setCreateDept(user.getDept().getId());//设置创建者所在部门的id
		
		
		// 调用业务方法
		contractService.saveOrUpdate(model);
		return "alist";
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		Contract Contract = contractService.get(Contract.class, model.getId());
		// 放入值栈
		super.push(Contract);
	
		// 将查询结果放入值栈中
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update()  throws Exception{
		// 调用业务
		Contract obj = contractService.get(Contract.class, model.getId());
		// 设置修改的值
		
		obj.setCustomName(model.getCustomName());
		obj.setPrintStyle(model.getPrintStyle());
		obj.setContractNo(model.getContractNo());
		obj.setOfferor(model.getOfferor());
		obj.setInputBy(model.getInputBy());
		obj.setCheckBy(model.getCheckBy());
		obj.setInspector(model.getInspector());
		obj.setSigningDate(model.getSigningDate());
		obj.setImportNum(model.getImportNum());
		obj.setShipTime(model.getShipTime());
		obj.setTradeTerms(model.getTradeTerms());
		obj.setDeliveryPeriod(model.getDeliveryPeriod());
		obj.setCrequest(model.getCrequest());
		obj.setRemark(model.getRemark());
		
		contractService.saveOrUpdate(obj);
		return "alist";
	}
	
	/**
	 * 删除
	 */
	public String delete() throws Exception{
		String[] ids = model.getId().split(",");
		
		contractService.delete(Contract.class, ids);
		
		return "alist";
	}
	
	
	/**
	 * 提交
	 */
	public String submit() throws Exception{
		String[] ids =model.getId().split(",");
		contractService.changeState(ids, 1);
		return "alist";
	}
	
	/**
	 * 取消
	 */
	public String cancel() throws Exception{
		String[] ids =model.getId().split(",");
		contractService.changeState(ids, 0);
		return "alist";
	}
	
	/**
	 * 打印
	 */
	public String print() throws Exception{
		// 根据购销合同的id，得到购销合同对象
		Contract contract = contractService.get(Contract.class, model.getId());
		
		// 指定path
		String path = ServletActionContext.getServletContext().getRealPath("/");//应用程序根路经
		
		// 指定response
		HttpServletResponse response = ServletActionContext.getResponse();
		
		ContractPrint cp = new ContractPrint();
		cp.print(contract, path, response);
		
		return NONE;
	}
	
	
	
	
	
	
}
