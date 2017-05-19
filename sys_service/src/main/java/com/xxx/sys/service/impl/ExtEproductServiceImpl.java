package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.ExtEproduct;
import com.xxx.sys.service.ExtEproductService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

public class ExtEproductServiceImpl implements ExtEproductService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<ExtEproduct> find(String hql, Class<ExtEproduct> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public ExtEproduct get(Class<ExtEproduct> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<ExtEproduct> findPage(String hql, Page<ExtEproduct> page, Class<ExtEproduct> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(ExtEproduct entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			// 新增

			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ExtEproduct> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<ExtEproduct> entityClass, Serializable id) {
		
		baseDao.deleteById(entityClass, id);// 删除一个
	}

	@Override
	public void delete(Class<ExtEproduct> entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(entityClass, id);
		}
	}

}
