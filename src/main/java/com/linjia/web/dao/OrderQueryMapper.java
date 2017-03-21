package com.linjia.web.dao;

import java.util.List;
import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.Logistics;
import com.linjia.web.model.OrderRefundManage;
import com.linjia.web.model.OrderSerch;
import com.linjia.web.model.PinTuanOrder;
import com.linjia.web.model.ScoreOrder;
import com.linjia.web.model.ScoreOrderProduct;
import com.linjia.web.model.ThirdOrder;
import com.linjia.web.model.ThirdOrderProduct;
import com.linjia.web.query.LogisticsQuery;
import com.linjia.web.query.OrderRefundManageQuery;
import com.linjia.web.query.OrderSerchQuery;
import com.linjia.web.query.ThirdLogisOrderQuery;


public interface OrderQueryMapper  extends BaseDao<OrderSerch, Long>{
	
	/**
	 * 总销售额统计
	 * @param request
	 * @return
	 */
	List<OrderSerch> selectSumAllSales(OrderSerchQuery query);
	
	/**
	 * 查询百度订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ThirdOrderProduct> selectBdOrderProduct(Long orderId);
	
	/**
	 * 查询美团订单商品
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ThirdOrderProduct> selectMtOrderProduct(Long order_Id);
	
	/**
	 * 查询京东订单商品
	 * lxl
	 * 2016年7月29日 下午16:45:33
	 * @param query
	 * @return
	 */
	List<ThirdOrderProduct> selectJdOrderProduct(Long orderId);
	
	/**
	 * 获取所有来源订单列表
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	List<ThirdOrder> selectOrderlist(ThirdLogisOrderQuery query);
	
	/**
	 * 获取积分订单列表
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	List<ScoreOrder> selectScoreOrderlist(ThirdLogisOrderQuery query);
	
	/**
	 * 获取拼团订单列表
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	List<PinTuanOrder> selectPinTuanOrderlist(ThirdLogisOrderQuery query);
	
	/**
	 * 获取退款订单列表
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	List<OrderRefundManage> selectRefundOrderlist(OrderRefundManageQuery query);
	
	/**
	 * 查询邻家店铺订单详情
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @return
	 */
	ThirdOrder selectMyOrder(ThirdLogisOrderQuery query);
	
	/**
	 * 查询百度店铺订单详情
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @return
	 */
	ThirdOrder selectBdOrder(ThirdLogisOrderQuery query);
	
	/**
	 * 查询美团店铺订单详情
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @return
	 */
	ThirdOrder selectMtOrder(ThirdLogisOrderQuery query);
	
	/**
	 * 查询京东店铺订单详情
	 * lxl
	 * 2017年3月14日 下午16:45:33
	 * @return
	 */
	ThirdOrder selectJdOrder(ThirdLogisOrderQuery query);
	
	/**
	 * 查询邻家商品详情
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @return
	 */
	List<ThirdOrderProduct> selectMyOrderDetail(Long order_id);
	
	/**
	 * 查询邻家订单物流信息
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @return
	 */
	Logistics selectLogisticsById(LogisticsQuery query);
	
	/**
	 * 查询积分订单详情
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @return
	 */
	List<ScoreOrderProduct> selectScoreOrderProduct(Long orderId);
	
	/**
	 * 获取所有来源订单总数
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	Integer selectOrderNum(ThirdLogisOrderQuery query);
	
	/**
	 * 获取积分订单总数
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	Integer selectScoreOrderNum(ThirdLogisOrderQuery query);
	
	/**
	 * 获取拼团订单总数
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	Integer selectPinTuanOrderNum(ThirdLogisOrderQuery query);
	
	/**
	 * 获取退款订单总数
	 * xiangsy
	 * 2016年7月29日 下午16:45:33
	 * @param app_poi_code 店铺码
	 * @param status 订单状态
	 * @return
	 */
	Integer selectRefundOrderNum(OrderRefundManageQuery query);
	
	/**
	 * 拼团订单详情
	 * @param query
	 * @return
	 */
	PinTuanOrder selectPinTuanOrder(ThirdLogisOrderQuery query);

	/**
	 * 根据订单id查询单条退款单
	 * xiangsy 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	ThirdOrder selectPtOrder(Long id);
	
	/**
	 * 根据订单id查询单条退款单
	 * xiangsy 
	 * 2016年7月29日 上午11:31:40
	 * @return
	 */
	List<ThirdOrderProduct> selectPtProOrderList(Long id);

	/**
	 * 更新拼团订单数据
	 * @param pt
	 * @return
	 */
	boolean updatePtOrderById(PinTuanOrder pt);
	
	/**
	 * 查询退款积分订单数据
	 * xiangsy
	 * 2017年2月15日 下午10:45:33
	 * @return
	 */
	ThirdOrder selectReScoreOrder(Long orderId);
	
	/**
	 * 查询饿了么订单详情
	 * @param orderId
	 * @return
	 */
	List<ThirdOrder> selectElemeOrder(ThirdLogisOrderQuery query);
}