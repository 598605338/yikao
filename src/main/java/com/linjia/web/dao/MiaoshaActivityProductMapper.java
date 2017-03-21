package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.query.MiaoshaActivityProductQuery;

public interface MiaoshaActivityProductMapper extends BaseDao<MiaoshaActivityProduct, Long> {
	
	
	List<MiaoshaActivityProduct> selectAllByBaseId(MiaoshaActivityProductQuery query);
	
	
	/**
	 * 根据商品id，判断该商品是否正在进行秒杀
	 * lixinling
	 * 2016年7月18日 上午10:17:11
	 * @param product_id
	 * @return
	 */
	MiaoshaActivityProduct getPanicingProductByProductId(Map map);
	
	/**
	 * 根据baseId更新活动抢购时间
	 * lixinling
	 * 2016年11月25日 上午10:17:11
	 * @param product_id
	 * @return
	 */
	boolean updatePanicBuyingTimeByBaseId(Map<String,Object> map);
}