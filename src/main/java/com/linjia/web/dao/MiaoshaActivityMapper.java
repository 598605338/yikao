package com.linjia.web.dao;



import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.MiaoshaActivityBase;
import com.linjia.web.query.MiaoshaActivityBaseQuery;

public interface MiaoshaActivityMapper extends BaseDao<MiaoshaActivityBase, Long>{
	
	/**
	 * 查询一条数据
	 * 
	 * @param id
	 * @return
	 */
	MiaoshaActivityBase selectOne(MiaoshaActivityBaseQuery query);
	
	
	/**
	 * 分页查询数据
	 * 
	 * @param id
	 * @return
	 */
	List<MiaoshaActivityBase> selectByPageList(MiaoshaActivityBaseQuery query);
	
	/**
	 * 分页查询数据总数量
	 * 
	 * @param id
	 * @return
	 */
	int countByExample(MiaoshaActivityBaseQuery query);
	
	
	
}
