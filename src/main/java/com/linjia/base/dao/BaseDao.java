package com.linjia.base.dao;

import java.util.List;

/**
 * 所有自定义Dao的顶级接口，封装常用的增删改查操作;
 * 手动编码时继承BaseDao即可
 * @author lixinling
 *
 * @param <Model> ：代表数据库中表映射的Java对象类型
 * @param <PK> ：代表对象的主键类型
 */
public interface BaseDao<Model, PK> {

	/**
	 * 插入对象
	 * 
	 * @param model  对象
	 */
	int insertSelective(Model model);
	
	/**
	 * 更新对象
	 * 
	 * @param model 对象
	 * @return
	 */
	boolean updateByPrimaryKeySelective(Model model);
	
	/**
	 * 通过主键，删除对象
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteByPrimaryKey(PK id);
	
	/**
	 * 通过主键，查询对象
	 * 
	 * @param id
	 * @return
	 */
	Model selectByPrimaryKey(PK id);
	
	/**
	 * 查询Model对象列表
	 * 
	 * @return
	 */
	List<Model> selectAll();
	
	/**
	 * 查询count数
	 * 
	 * @return
	 */
	long count();
}
