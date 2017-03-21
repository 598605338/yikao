package com.linjia.base.service;

import java.util.List;

/**
 * 所有自定义Service的顶级接口，封装常用的增删改查操作
 * @author lixinling
 *
 * @param <Model> ：代表数据库中表映射的Java对象类型
 * @param <PK> ： 代表对象的主键类型
 */
public interface BaseService<Model, PK> {

	/**
	 * 插入对象
	 * 
	 * @param model  对象
	 */
	int insert(Model model);
	
	/**
	 * 更新对象
	 * 
	 * @param model 对象
	 * @return
	 */
	boolean update(Model model);
	
	/**
	 * 通过主键，删除对象
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(PK id);
	
	/**
	 * 通过主键，查询对象
	 * 
	 * @param id
	 * @return
	 */
	Model selectById(PK id);
	
	/**
	 * 查询单个对象
	 * 
	 * @return
	 */
	Model selectOne();
	
	/**
	 * 查询Model对象列表
	 * 
	 * @return
	 */
	List<Model> selectList();
	
}
