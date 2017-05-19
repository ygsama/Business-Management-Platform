package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.Export;
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
			// 遍历每个购销合同的id
			
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
