package com.linjia.web.dao;

import java.util.List;
import com.linjia.base.dao.BaseDao;
import com.linjia.web.query.ThirdLogisOrderQuery;
import com.linjia.web.thirdService.baidu.model.BaiduData;
import com.linjia.web.thirdService.baidu.model.BaiduReOrder;
import com.linjia.web.thirdService.baidu.model.Order;


public interface BaiduLogsticsMapper extends BaseDao<BaiduData, Long>{
	
	/**
	 * 插入订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	 Integer insertBdOrder(BaiduData bd);
	
	/**
	 * 更新订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	boolean updateBdOrder(BaiduData bd);
	
	/**
	 * 删除订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	boolean deleteBdOrder(String orderId);
	
	/**
	 * 查询订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	BaiduReOrder selectBdOrder(ThirdLogisOrderQuery query);
	
	/**
	 * 查询订单数据
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param shopId
	 * @return
	 */
	List<BaiduReOrder> selectBdOrderlist(ThirdLogisOrderQuery query);
	
	/**
	 * 订单状态推送
	 * @param order  orderId 订单id
	 * @param order  status  订单状态
	 * @return
	 */
	Integer updateBdOrderStatus(Order order);
	
	/**
	 * 订单状态查询
	 * @param orderId 订单id
	 * @return
	 */
	Order selectBdOrderStatus(String orderId);
	
	/**
	 * 查询抛单订单对象
	 * @param order_id
	 * @return
	 */
	BaiduReOrder selectPdOrder(Long order_id);
}