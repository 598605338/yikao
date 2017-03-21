package com.linjia.web.dao;

import java.util.List;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.query.ThirdLogisOrderQuery;
import com.linjia.web.thirdService.meituan.model.MtOrder;
import com.linjia.web.thirdService.meituan.model.MtReOrder;


public interface MtLogsticsMapper extends BaseDao<MtOrder, Long>{
	
	/**
	 * 插入订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	 boolean insertMtOrder(MtOrder mt);
	
	/**
	 * 更新订单数据(已支付)
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	boolean updateOrderPayed(MtOrder mt);
	
	/**
	 * 更新订单数据(已确认)
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	boolean updateOrderConfirmed(MtOrder mt);
	
	/**
	 * 更新订单数据(已完成)
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	boolean updateOrderOver(MtOrder mt);
	
	/**
	 * 删除订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	boolean deleteMtOrder(String orderId);
	
	/**
	 * 查询订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	MtReOrder selectMtOrder(ThirdLogisOrderQuery query);
	
	/**
	 * 查询店铺订单数据列表
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @return
	 */
	List<MtReOrder> selectMtOrderlist(ThirdLogisOrderQuery query);
	
	/**
	 * 更新订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	int updateMtOrder(MtOrder mt);
	
}