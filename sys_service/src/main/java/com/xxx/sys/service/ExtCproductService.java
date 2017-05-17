package com.xxx.sys.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.domain.ExtCproduct;
import com.xxx.sys.utils.Page;

/**
 * 
 * @author G
 *
 */
public interface ExtCproductService {

	/**
	 * 查询所有，带条件查询
	 * @param hql
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params);
	/**
	 * 获取一条记录
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public ExtCproduct get(Class<ExtCproduct> entityClass, Serializable id);
	/**
	 * 分页查询，将数据封装到一个page分页工具类对象
	 * @param hql
	 * @param page
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public Page<ExtCproduct> findPage(String hql, Page<ExtCproduct> page, Class<ExtCproduct> entityClass, Object[] params);
	
	/**
	 * 新增和修改保存
	 * @param entity
	 */
	public void saveOrUpdate(ExtCproduct entity);
	/**
	 * 批量新增和修改保存
	 * @param entitys
	 */
	public  void saveOrUpdateAll(Collection<ExtCproduct> entitys);
	
	/**
	 * 单条删除，按id
	 * @param entityClass
	 * @param id
	 */
	public void deleteById(Class<ExtCproduct> entityClass, Serializable id);
	/**
	 * 批量删除
	 * @param entityClass
	 * @param ids
	 */
	public void delete(Class<ExtCproduct> entityClass, Serializable[] ids);
	/**
	 * 删除指定附件对象
	 * @param entityClass
	 * @param model
	 */
	public void delete(Class<ExtCproduct> entityClass, ExtCproduct model);
}
