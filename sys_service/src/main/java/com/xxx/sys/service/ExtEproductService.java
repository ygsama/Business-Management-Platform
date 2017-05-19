package com.xxx.sys.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.domain.ExtEproduct;
import com.xxx.sys.utils.Page;

/**
 * 
 * @author G
 *
 */
public interface ExtEproductService {

	/**
	 * 查询所有，带条件查询
	 * @param hql
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public List<ExtEproduct> find(String hql, Class<ExtEproduct> entityClass, Object[] params);
	/**
	 * 获取一条记录
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public ExtEproduct get(Class<ExtEproduct> entityClass, Serializable id);
	/**
	 * 分页查询，将数据封装到一个page分页工具类对象
	 * @param hql
	 * @param page
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public Page<ExtEproduct> findPage(String hql, Page<ExtEproduct> page, Class<ExtEproduct> entityClass, Object[] params);
	
	/**
	 * 新增和修改保存
	 * @param entity
	 */
	public void saveOrUpdate(ExtEproduct entity);
	/**
	 * 批量新增和修改保存
	 * @param entitys
	 */
	public  void saveOrUpdateAll(Collection<ExtEproduct> entitys);
	
	/**
	 * 单条删除，按id
	 * @param entityClass
	 * @param id
	 */
	public void deleteById(Class<ExtEproduct> entityClass, Serializable id);
	/**
	 * 批量删除
	 * @param entityClass
	 * @param ids
	 */
	public void delete(Class<ExtEproduct> entityClass, Serializable[] ids);


	
}
