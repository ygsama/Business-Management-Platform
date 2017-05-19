package com.xxx.sys.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.xxx.sys.domain.Export;
import com.xxx.sys.utils.Page;

/**
 * 
 * @author G
 *
 */
public interface ExportService {

	/**
	 * 查询所有，带条件查询
	 * @param hql
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public List<Export> find(String hql, Class<Export> entityClass, Object[] params);
	/**
	 * 获取一条记录
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public Export get(Class<Export> entityClass, Serializable id);
	/**
	 * 分页查询，将数据封装到一个page分页工具类对象
	 * @param hql
	 * @param page
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public Page<Export> findPage(String hql, Page<Export> page, Class<Export> entityClass, Object[] params);
	
	/**
	 * 新增和修改保存
	 * @param entity
	 */
	public void saveOrUpdate(Export entity);
	/**
	 * 批量新增和修改保存
	 * @param entitys
	 */
	public  void saveOrUpdateAll(Collection<Export> entitys);
	
	/**
	 * 单条删除，按id
	 * @param entityClass
	 * @param id
	 */
	public void deleteById(Class<Export> entityClass, Serializable id);
	/**
	 * 批量删除
	 * @param entityClass
	 * @param ids
	 */
	public void delete(Class<Export> entityClass, Serializable[] ids);

	/**
	 * 修改状态
	 */
	public void changeState(String[] ids,Integer state);
	
}
