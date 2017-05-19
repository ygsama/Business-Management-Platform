package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.ExportProduct;
import com.xxx.sys.service.ExportProductService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

public class ExportProductServiceImpl implements ExportProductService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<ExportProduct> find(String hql, Class<ExportProduct> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public ExportProduct get(Class<ExportProduct> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<ExportProduct> findPage(String hql, Page<ExportProduct> page, Class<ExportProduct> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(ExportProduct entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			// 新增

			
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ExportProduct> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<ExportProduct> entityClass, Serializable id) {
		
		baseDao.deleteById(entityClass, id);// 删除一个
	}

	@Override
	public void delete(Class<ExportProduct> entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(entityClass, id);
		}
	}

}
