package com.xxx.sys.action.cargo;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.ContractProduct;
import com.xxx.sys.domain.ExtCproduct;
import com.xxx.sys.domain.Factory;
import com.xxx.sys.service.ExtCproductService;
import com.xxx.sys.service.FactoryService;
import com.xxx.sys.utils.Page;

/**
 * 
 * @author G
 *
 */
public class ExtCproductAction extends BaseAction implements ModelDriven<ExtCproduct> {

	private ExtCproduct model = new ExtCproduct();
	
	@Override
	public ExtCproduct getModel() {
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
	
	// 注入ExtCproductService
	private ExtCproductService extCproductService;
	public void setExtCproductService(ExtCproductService extCproductService) {
		this.extCproductService = extCproductService;
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
		// 生产附件厂家
		String hql = "from Factory where ctype = '附件' and state='1'";
		List<Factory> factoryList = factoryService.find(hql, Factory.class, null);
		super.put("factoryList", factoryList);
		// 当前货物下的附件列表
		extCproductService.findPage(
				"from ExtCproduct where contractProduct.id=?"
				, page, ExtCproduct.class
				, new String[]{model.getContractProduct().getId()}
			);
		page.setUrl("cExtCproductAction_tocreate");
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
		extCproductService.saveOrUpdate(model);
		return tocreate();
	}
	
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		// 根据id得到
		ExtCproduct ExtCproduct =extCproductService.get(ExtCproduct.class, model.getId());
		// 放入值栈
		super.push(ExtCproduct);
	
		// 加载生产厂家列表
		String hql = "from Factory where ctype = '附件' and state='1'";
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
		ExtCproduct obj = extCproductService.get(ExtCproduct.class, model.getId());
		obj.setFactory(model.getFactory());
		obj.setFactoryName(model.getFactoryName());
		obj.setProductNo(model.getProductNo());
		obj.setProductImage(model.getProductImage());
		obj.setCnumber(model.getCnumber());
		obj.setAmount(model.getAmount());
		obj.setPackingUnit(model.getPackingUnit());

		obj.setPrice(model.getPrice());
		obj.setOrderNo(model.getOrderNo());
		obj.setProductDesc(model.getProductDesc());
		obj.setProductRequest(model.getProductRequest());
		
		extCproductService.saveOrUpdate(obj);
		return tocreate();
	}
	
	/**
	 * 删除
	 */
	public String delete() throws Exception{
		extCproductService.delete(ExtCproduct.class,model);
	
		return tocreate();
	}

}
