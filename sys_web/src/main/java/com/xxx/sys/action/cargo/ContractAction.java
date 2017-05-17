package com.xxx.sys.action.cargo;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.service.ContractService;
import com.xxx.sys.utils.Page;

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
		contractService.findPage("from Contract", page, Contract.class,null);
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
}
