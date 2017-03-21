package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.MiddleCatagory;
import com.linjia.web.query.CatagoryQuery;

public interface MiddleCatagoryService extends BaseService<MiddleCatagory, Long>{
	
	/**
	 * 根据largeCatagoryId查询中分类
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	List<MiddleCatagory> selectByLargeCatagoryId(CatagoryQuery query);

	/**
	 * 根据largeCatagoryId查询中分类的总条数
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	int countByExample(CatagoryQuery query);
	
	/**
	 * 更改使用状态
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	int updateUseStatusByPrimaryKey(MiddleCatagory middleCatagory);
	
	/**
	 * 根据largeCatagoryId查询中分类
	 * lixinling
	 * 2016年7月8日 上午10:11:59
	 * @param productId
	 * @return
	 */
	List<MiddleCatagory> selectAllByLargeCatagoryId(Long largeId);

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
}
