package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.sun.xml.bind.Util;
import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.Dept;
import com.xxx.sys.service.DeptService;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.UtilFuns;

public class DeptServiceImpl implements DeptService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Dept get(Class<Dept> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Dept entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			entity.setState(1);//1启用
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Dept> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Dept> entityClass, Serializable id) {
		
		// 有哪些子部门，父部门编号是第二个参数
		String hql="from Dept where parent.id=?";
		List<Dept> list = baseDao.find(hql, Dept.class, new Object[]{id});
		if(list!=null && list.size()>0){
			for(Dept dept:list){
				deleteById(entityClass, dept.getId());//递归删除子部门
			}
		}
		baseDao.deleteById(entityClass, id);// 删除父部门
	}

	@Override
	public void delete(Class<Dept> entityClass, Serializable[] ids) {
		System.out.println(entityClass.getName()+"点击了删除");
		for(Serializable id:ids){
			// 判断是否存在
			List list = baseDao.isExist(entityClass, id);
			String str = list.get(0).toString();
			if(Integer.parseInt(str)<=0){
				continue;
			}
			this.deleteById(entityClass, id);
		}
	}

}
