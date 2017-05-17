package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.domain.ExtCproduct;
import com.xxx.sys.service.ExtCproductService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

public class ExtCproductServiceImpl implements ExtCproductService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public ExtCproduct get(Class<ExtCproduct> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<ExtCproduct> findPage(String hql, Page<ExtCproduct> page, Class<ExtCproduct> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(ExtCproduct entity) {
		double amount = 0d;
		if(UtilFuns.isEmpty(entity.getId())){
			//新增
			if(UtilFuns.isNotEmpty(entity.getPrice())&&UtilFuns.isNotEmpty(entity.getCnumber())){
				amount = entity.getPrice()*entity.getCnumber();
				entity.setAmount(amount);
			}
			// 修改购销合同总金额
			Contract contract = baseDao.get(Contract.class, entity.getContractProduct().getContract().getId());
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
			Contract contract = baseDao.get(Contract.class, entity.getContractProduct().getContract().getId());
			contract.setTotalAmount(contract.getTotalAmount()-oldAmount+amount);
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ExtCproduct> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<ExtCproduct> entityClass, Serializable id) {
		
		baseDao.deleteById(entityClass, id);// 删除一个
	}

	@Override
	public void delete(Class<ExtCproduct> entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(entityClass, id);
		}
	}

	@Override
	public void delete(Class<ExtCproduct> entityClass, ExtCproduct model) {
		
		ExtCproduct extCproduct = baseDao.get(ExtCproduct.class, model.getId());
		Contract contract = baseDao.get(Contract.class, model.getContractProduct().getContract().getId());
		// 修改购销合同总金额
		contract.setTotalAmount(contract.getTotalAmount()-extCproduct.getAmount());
		baseDao.saveOrUpdate(contract);
		
		baseDao.deleteById(ExtCproduct.class,model.getId());
	}

}
