package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.LargeCatagory;
import com.linjia.web.model.MiddleCatagory;
import com.linjia.web.query.CatagoryQuery;


public interface LargeCatagoryMapper extends BaseDao<LargeCatagory, Long> {
	
	/**
	 * 查询分页数据
	 * lixinling 
	 * 2016年8月27日 下午3:47:12
	 * @param query
	 */
	List<LargeCatagory> selectPageList(CatagoryQuery query);
	
	/**
	 * 查询分页数据总条数
	 * lixinling 
	 * 2016年8月27日 下午3:47:12
	 * @param query
	 */
	int countByExample(CatagoryQuery query);
	
	/**
	 * 查询所有数据
	 * lixinling 
	 * 2016年8月27日 下午3:47:12
	 * @param query
	 */
	List<LargeCatagory> selectAllLargeCatagoryList();
	
	/**
	 * 根据name查询Id
	 * lixinling 
	 * 2016年8月27日 下午3:47:12
	 * @param query
	 */
	Long selectIdByName(String name);
	
	/**
	 * 取得当前最大的排序数
	 * lixinling 
	 * 2016年11月23日 下午3:47:12
	 * @param query
	 */
	Long selectMaxSortIndex();
	
	/**
	 * 更改使用状态
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	int updateUseStatusByPrimaryKey(LargeCatagory largeCatagory);
}