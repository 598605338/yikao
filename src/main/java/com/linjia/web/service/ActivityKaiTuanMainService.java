package com.linjia.web.service;


import java.util.List;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.ActivityKaiTuanMain;
import com.linjia.web.query.ActivityKaiTuanMainQuery;

public interface ActivityKaiTuanMainService extends BaseService<ActivityKaiTuanMain, Long>{
	
	/**
	 * 插入单个开团记录数据
	 * xiangsy
	 * 2016年7月20日 下午10:45:33
	 * @param query
	 * @return
	 */
	int insertOneKaiTuanActivity(ActivityKaiTuanMain model);
	
	/**
	 * 根据id取得拼团商品详情信息
	 * xiangsy
	 * 2016年7月20日 下午10:48:33
	 * @param query
	 * @return
	 */
	int updateOneKaiTuanActivity(ActivityKaiTuanMain model);
	
	/**
	 * 根据UserId取得单个用户的所有参团信息
	 * xiangsy
	 * 2016年7月20日 下午10:48:33
	 * @param query
	 * @return
	 */
	List<ActivityKaiTuanMain> selectUserAllKaiTuan(ActivityKaiTuanMainQuery query);
	
	
	/**
	 * 查询开团记录
	 * xiangsy
	 * 2016年7月20日 下午10:58:33
	 * @param query
	 * @return
	 */
	ActivityKaiTuanMain selectKaiTuanActivity(ActivityKaiTuanMainQuery query);
	
	/**
	 * 根据商品id即baseid统计该商品销售数量
	 * xiangsy
	 * 2016年7月20日 下午10:45:33
	 * @param query
	 * @return
	 */
	int selectSumSalesNum(int baseId);
	
	/**
	 * 根据需要生成订单的商品记录
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ActivityKaiTuanMain> selectOrderList();
}
