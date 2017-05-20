package com.xxx.sys.action.cargo;

import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ModelDriven;
import com.xxx.sys.action.BaseAction;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.domain.Export;
import com.xxx.sys.domain.ExportProduct;
import com.xxx.sys.domain.User;
import com.xxx.sys.service.ContractService;
import com.xxx.sys.service.ExportProductService;
import com.xxx.sys.service.ExportService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

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
	
	private ExportProductService exportProductService;
	public void setExportProductService(ExportProductService exportProductService) {
		this.exportProductService = exportProductService;
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
		Export obj = exportService.get(Export.class, model.getId());
		// 放入值栈
		super.push(obj);
	
		// addTRRecord(mRecordTable, "id","productNo","cnumber","grossWeight","netWeight","sizeLength","sizeWidth","sizeHeight","exPrice","tax");
		StringBuilder sb = new StringBuilder();
		Set<ExportProduct> epSet = obj.getExportProducts();// 关联级别的数据检索 ，对象导航
		for (ExportProduct ep : epSet) {
			sb.append("addTRRecord(\"mRecordTable\", \"").append(ep.getId());
			sb.append("\",\"").append(ep.getProductNo());
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getCnumber()));
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getGrossWeight()));
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getNetWeight()));
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getSizeLength()));
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getSizeWidth()));
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getSizeHeight()));
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getExPrice()));
			sb.append("\",\"").append(UtilFuns.convertNull(ep.getTax()));
			sb.append("\");");
		}
		
		// 将拼接好的串放入值栈
		super.put("mRecordData", sb.toString());
		
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update()  throws Exception{
		// 调用业务
		Export obj = exportService.get(Export.class, model.getId());
		// 设置修改的值
		obj.setInputDate(model.getInputDate());
		
		obj.setLcno(model.getLcno());
		obj.setConsignee(model.getConsignee());
		obj.setShipmentPort(model.getShipmentPort());
		obj.setDestinationPort(model.getDestinationPort());
		obj.setTransportMode(model.getTransportMode());
		obj.setPriceCondition(model.getPriceCondition());
		obj.setMarks(model.getMarks());//唛头是指具有一定格式的备注说明
		obj.setRemark(model.getRemark());
		
		Set<ExportProduct> epSet = new HashSet<ExportProduct>();//商品列表
		for(int i = 0;i<mr_id.length;i++){
			// 遍历数组，得到每个商品对象
			ExportProduct ep = exportProductService.get(ExportProduct.class, mr_id[i]);
			
			if("1".equals(mr_changed[i])){
				ep.setCnumber(mr_cnumber[i]);
				ep.setGrossWeight(mr_grossWeight[i]);
				ep.setNetWeight(mr_netWeight[i]);
				ep.setSizeLength(mr_sizeLength[i]);
				ep.setSizeWidth(mr_sizeWidth[i]);
				ep.setSizeHeight(mr_sizeHeight[i]);
				ep.setExPrice(mr_exPrice[i]);
				ep.setTax(mr_tax[i]);
			}
			epSet.add(ep);
		}
		// 设置报运单与商品列表的关系
		obj.setExportProducts(epSet);
		
		exportService.saveOrUpdate(obj);
		return "alist";
	}
	
	private String mr_changed[];
	private String mr_id[];
	private Integer mr_cnumber[];
	private Double mr_grossWeight[];
	private Double mr_netWeight[];
	private Double mr_sizeLength[];
	private Double mr_sizeWidth[];
	private Double mr_sizeHeight[];
	private Double mr_exPrice[];
	private Double mr_tax[];
	public void setMr_changed(String[] mr_changed) {
		this.mr_changed = mr_changed;
	}
	public void setMr_id(String[] mr_id) {
		this.mr_id = mr_id;
	}
	public void setMr_cnumber(Integer[] mr_cnumber) {
		this.mr_cnumber = mr_cnumber;
	}
	public void setMr_grossWeight(Double[] mr_grossWeight) {
		this.mr_grossWeight = mr_grossWeight;
	}
	public void setMr_netWeight(Double[] mr_netWeight) {
		this.mr_netWeight = mr_netWeight;
	}
	public void setMr_sizeLength(Double[] mr_sizeLength) {
		this.mr_sizeLength = mr_sizeLength;
	}
	public void setMr_sizeWidth(Double[] mr_sizeWidth) {
		this.mr_sizeWidth = mr_sizeWidth;
	}
	public void setMr_sizeHeight(Double[] mr_sizeHeight) {
		this.mr_sizeHeight = mr_sizeHeight;
	}
	public void setMr_exPrice(Double[] mr_exPrice) {
		this.mr_exPrice = mr_exPrice;
	}
	public void setMr_tax(Double[] mr_tax) {
		this.mr_tax = mr_tax;
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
	 * 取消提交
	 */
	public String cancel() throws Exception{
		String[] ids =model.getId().split(",");
		exportService.changeState(ids, 0);
		return "alist";
	}
}
