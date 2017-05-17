package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.Contract;
import com.xxx.sys.service.ContractService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

public class ContractServiceImpl implements ContractService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<Contract> find(String hql, Class<Contract> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Contract get(Class<Contract> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Contract> findPage(String hql, Page<Contract> page, Class<Contract> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Contract entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			// 新增
			entity.setTotalAmount(0d);
			entity.setState(0);// 0草稿  1已上报 2已报运
			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Contract> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Contract> entityClass, Serializable id) {
		
		baseDao.deleteById(entityClass, id);// 删除一个
	}

	@Override
	public void delete(Class<Contract> entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(entityClass, id);
		}
	}

	@Override
	public void changeState(String[] ids, Integer state) {
		//遍历ids，加载每个购销合同对象，修改状态
		for (String id : ids) {
			Contract c = baseDao.get(Contract.class, id);
			c.setState(state);
			baseDao.saveOrUpdate(c);//可以不写，持久态对象自动保存
		}
	}

}
