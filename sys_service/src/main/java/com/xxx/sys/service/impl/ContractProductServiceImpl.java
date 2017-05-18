package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.domain.ContractProduct;
import com.xxx.sys.domain.ExtCproduct;
import com.xxx.sys.service.ContractProductService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

public class ContractProductServiceImpl implements ContractProductService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<ContractProduct> find(String hql, Class<ContractProduct> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public ContractProduct get(Class<ContractProduct> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<ContractProduct> findPage(String hql, Page<ContractProduct> page, Class<ContractProduct> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(ContractProduct entity) {
		double amount = 0d;
		if(UtilFuns.isEmpty(entity.getId())){
			//新增
			if(UtilFuns.isNotEmpty(entity.getPrice())&&UtilFuns.isNotEmpty(entity.getCnumber())){
				amount = entity.getPrice()*entity.getCnumber();
				entity.setAmount(amount);
			}
			// 修改购销合同总金额
			Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
			contract.setTotalAmount(contract.getTotalAmount()+amount);
			// 保存
			baseDao.saveOrUpdate(contract);//可以不写
		}else{
			// 修改
			double oldAmount = entity.getAmount();// 取出原有总金额
			if(UtilFuns.isNotEmpty(entity.getPrice())&&UtilFuns.isNotEmpty(entity.getCnumber())){
				amount = entity.getPrice()*entity.getCnumber();
				entity.setAmount(amount);
			}
			// 修改购销合同总金额
			Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
			contract.setTotalAmount(contract.getTotalAmount()-oldAmount+amount);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ContractProduct> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<ContractProduct> entityClass, Serializable id) {
		
		baseDao.deleteById(entityClass, id);// 删除一个
	}

	@Override
	public void delete(Class<ContractProduct> entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(entityClass, id);
		}
	}

	@Override
	public void delete(Class<ContractProduct> entityClass, ContractProduct model) {
		// 1.加载出要删除的货物对象
		ContractProduct cp = baseDao.get(ContractProduct.class, model);
		// 2.通过关联级别的数据加载，得到当前货物下的所有附件列表
		Set<ExtCproduct> extCSet = cp.getExtCproducts();
		// 3.加载购销合同
		Contract c = baseDao.get(Contract.class, model.getContract().getId());
		// 4. 遍历附件列表，并修改购销合同的总金额
		for (ExtCproduct ec : extCSet) {
			c.setTotalAmount(c.getTotalAmount()-ec.getAmount());
		}
		// 5.购销合同总金额-货物总金额
		c.setTotalAmount(c.getTotalAmount()-cp.getAmount());
		// 6.更新购销合同总金额
		baseDao.saveOrUpdate(c);
		// 删除货物对象 级联删除附件
		baseDao.deleteById(ContractProduct.class, model.getId());	
	}
}
