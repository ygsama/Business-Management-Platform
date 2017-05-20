package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.domain.ContractProduct;
import com.xxx.sys.domain.Export;
import com.xxx.sys.domain.ExportProduct;
import com.xxx.sys.domain.ExtCproduct;
import com.xxx.sys.domain.ExtEproduct;
import com.xxx.sys.service.ExportService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

public class ExportServiceImpl implements ExportService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<Export> find(String hql, Class<Export> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Export get(Class<Export> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Export> findPage(String hql, Page<Export> page, Class<Export> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Export entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			// 新增报运单
			entity.setState(0);//默认状态为0
			
			String[] ids = entity.getContractIds().split(", ");
			// 遍历每个购销合同的id，得到每个购销合同对象，并修改状态为2
			StringBuilder sb = new StringBuilder();
			for (String id : ids) {
				Contract contract = baseDao.get(Contract.class, id);
				contract.setState(2);
				baseDao.saveOrUpdate(contract);
				sb.append(contract.getContractNo()).append(" ");
			}
			entity.setCustomerContract(sb.toString());// 设置合同及确认书号
			entity.setContractIds(UtilFuns.joinStr(ids,","));
			entity.setInputDate(new Date());// 设置制单日期
			
			// 通过购销合同的集合，跳跃查询出购销合同下面的货物列表	'100,101,102'-->'100','101','102'
			String hql="from ContractProduct where contract.id in ("+UtilFuns.joinInStr(ids)+")";
			List<ContractProduct> list = baseDao.find(hql, ContractProduct.class, null);
			
			// 数据搬家
			Set<ExportProduct> epSet = new HashSet<ExportProduct>();
			for (ContractProduct cp : list) {
				// 报运单下的商品
				ExportProduct ep = new ExportProduct();
				
				ep.setBoxNum(cp.getBoxNum());
				ep.setCnumber(cp.getCnumber());
				ep.setFactory(cp.getFactory());
				ep.setOrderNo(cp.getOrderNo());
				ep.setPackingUnit(cp.getPackingUnit());
				ep.setPrice(cp.getPrice());
				ep.setProductNo(cp.getProductNo());
				ep.setExport(entity);// 设置商品与报运单，多对一
				epSet.add(ep);
				
				// 加载购销合同下当前货物下的附件列表
				Set<ExtCproduct> extCSet = cp.getExtCproducts();
				
				// 报运单下的附件列表
				Set<ExtEproduct> extESet = new HashSet<ExtEproduct>();
				
				// 附件数据搬家
				for(ExtCproduct extC:extCSet){
					ExtEproduct extE = new ExtEproduct();
					
					// 拷贝对象属性
					BeanUtils.copyProperties(extC, extE);
					extE.setId(null);
					
					//附件与商品，多对一
					extE.setExportProduct(ep);
					
					// 向列表中添加元素
					extESet.add(extE);
				}
				
				// 向报运单下的商品对象中添加附件列表
				ep.setExtEproducts(extESet);
			}
			
			// 外层循环退出时，设置一个报运单下有多个商品 ---> 级联保存商品，商品中级联保存附件商品
			entity.setExportProducts(epSet);
			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Export> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Export> entityClass, Serializable id) {
		
		baseDao.deleteById(entityClass, id);// 删除一个
	}

	@Override
	public void delete(Class<Export> entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(entityClass, id);
		}
	}

	@Override
	public void changeState(String[] ids, Integer state) {
		//遍历ids，加载每个购销合同对象，修改状态
		for (String id : ids) {
			Export c = baseDao.get(Export.class, id);
			c.setState(state);
			baseDao.saveOrUpdate(c);//可以不写，持久态对象自动保存
		}
	}

}
