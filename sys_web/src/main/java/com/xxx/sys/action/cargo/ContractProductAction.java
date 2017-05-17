package com.xxx.sys.action.cargo;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.ContractProduct;
import com.xxx.sys.domain.Factory;
import com.xxx.sys.service.ContractProductService;
import com.xxx.sys.service.FactoryService;
import com.xxx.sys.utils.Page;

/**
 * 
 * @author G
 *
 */
public class ContractProductAction extends BaseAction implements ModelDriven<ContractProduct> {

	private ContractProduct model = new ContractProduct();
	
	@Override
	public ContractProduct getModel() {
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
	
	// 注入ContractProductService
	private ContractProductService contractProductService;
	public void setContractProductService(ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}
	private FactoryService factoryService;
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}
	

	/**
	 * 进入新增页
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		// 生产货物厂家
		String hql = "from Factory where ctype = '货物' and state='1'";
		List<Factory> factoryList = factoryService.find(hql, Factory.class, null);
		super.put("factoryList", factoryList);
		// 当前购销合同
		contractProductService.findPage(
				"from ContractProduct where contract.id=?"
				, page, ContractProduct.class
				, new String[]{model.getContract().getId()}
			);
		page.setUrl("contractProductAction_tocreate");
		super.push(page);
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
		contractProductService.saveOrUpdate(model);
		return tocreate();
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		ContractProduct contractProduct =contractProductService.get(ContractProduct.class, model.getId());
		// 放入值栈
		super.push(contractProduct);
	
		// 加载生产厂家列表
		String hql = "from Factory where ctype = '货物' and state='1'";
		List<Factory> factoryList = factoryService.find(hql, Factory.class, null);
		super.put("factoryList",factoryList);
		
		// 将查询结果放入值栈中
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update()  throws Exception{
		// 调用业务
		ContractProduct obj = contractProductService.get(ContractProduct.class, model.getId());
		// 设置修改的值
		
		obj.setFactory(model.getFactory());
		obj.setFactoryName(model.getFactoryName());
		obj.setProductNo(model.getProductNo());
		obj.setProductImage(model.getProductImage());
		obj.setCnumber(model.getCnumber());
		obj.setAmount(model.getAmount());
		obj.setPackingUnit(model.getPackingUnit());
		obj.setLoadingRate(model.getLoadingRate());
		obj.setBoxNum(model.getBoxNum());
		obj.setPrice(model.getPrice());
		obj.setOrderNo(model.getOrderNo());
		obj.setProductDesc(model.getProductDesc());
		obj.setProductRequest(model.getProductRequest());
		
		contractProductService.saveOrUpdate(obj);
		return tocreate();
	}
	
	/**
	 * 删除
	 */
	public String delete() throws Exception{
		contractProductService.deleteById(ContractProduct.class,model);
	
		return tocreate();
	}

}
