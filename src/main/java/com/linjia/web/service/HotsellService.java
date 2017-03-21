package com.linjia.web.service;


import java.util.List;
import java.util.Map;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.HotsellBase;
import com.linjia.web.model.HotsellProduct;
import com.linjia.web.model.Product;
import com.linjia.web.query.HotsellBaseQuery;

public interface HotsellService extends BaseService<HotsellBase, Long>{

	/**
	 * 查询热销活动数据列表
	 * lixinling 
	 * 2017年2月10日 下午1:45:39
	 * @param query
	 * @return
	 */
	List<HotsellBase> selectByPageList(HotsellBaseQuery query);
	

	/**
	 * 查询热销活动的总数据量
	 * lixinling 
	 * 2017年2月10日 下午1:45:39
	 * @param query
	 * @return
	 */
	Integer totalCountByPage(HotsellBaseQuery query);
	

	/**
	 * 批量插入活动数据
	 * lixinling 
	 * 2017年2月10日 下午5:32:40
	 * @param list
	 * @return
	 */
	int insertActivity(HotsellBase model);
	
	/**
	 * 批量插入活动商品数据
	 * lixinling 
	 * 2017年2月10日 下午5:32:40
	 * @param list
	 * @return
	 */
	int insertBatch(List<Product> list);
	
	/**
	 * 更新活动商品信息
	 * lixinling 
	 * 2017年2月10日 下午5:32:40
	 * @param list
	 * @return
	 */
	boolean updateHotsell(HotsellBase model);
	
	/**
	 * 根据baseId查询活动商品数据
	 * lixinling 
	 * 2017年2月10日 下午5:32:40
	 * @param list
	 * @return
	 */
	List<HotsellProduct> selectByBaseId(Integer baseId);

	/**
	 * 更新使用状态
	 * lixinling 
	 * 2017年2月10日 下午1:45:39
	 * @param query
	 * @return
	 */
	boolean updateStatusByPrimaryKey(Integer id,Integer online);
}
