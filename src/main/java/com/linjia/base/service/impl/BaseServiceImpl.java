package com.linjia.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.BaseService;

/**
 * BaseService的实现类,其他的自定义的ServiceImpl继承自它，可以获得常用的增删改查操作;
 * 未实现的方法由子类各自实现
 * 
 * @author lixinling
 *
 * @param <Model> ：代表数据库中表映射的Java对象类型
 * @param <PK> ：代表对象的主键类型
 */
public abstract class BaseServiceImpl<Model, PK> implements BaseService<Model, PK> {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public abstract BaseDao<Model, PK> getDao();
	
	@Override
	public int insert(Model model) {
		return getDao().insertSelective(model);
	}

	@Override
	public boolean update(Model model) {
		return getDao().updateByPrimaryKeySelective(model);
	}

	@Override
	public boolean delete(PK id) {
		return getDao().deleteByPrimaryKey(id);
	}

	@Override
	public Model selectById(PK id) {
		return getDao().selectByPrimaryKey(id);
	}

	@Override
	public Model selectOne() {
		return null;
	}

	@Override
	public List<Model> selectList() {
		return getDao().selectAll();
	}

}
