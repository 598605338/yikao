package com.linjia.web.service;

import java.util.List;

import com.linjia.web.model.LogistisDmInfo;
import com.linjia.web.model.ThirdOrderProduct;
import com.linjia.web.query.OOrderQuery;
import com.linjia.web.thirdService.eleme.interfaces.entity.message.OMessage;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OGoodsItem;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OOrder;

public interface ElemeOrderService {
	
	/**
	 * 插入订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param OOrder
	 * @return
	 */
	public boolean insertElemeOrder(String orderId);
	
	/**
	 * 更改订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @param remark 备注，取消原因
	 * @param updType 1，确认订单；2，取消订单；3，同意退单；4，不同意退单
	 * @param type 订单无效类型，枚举类
	 * @return
	 */
	public boolean updateElemeOrder(String orderId,String reason,int updType,Integer type);
	
	/**
	 * 查询订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	public OOrder selectElemeOrderById(String orderId);
	
	/**
	 * 查询多个订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	public List<OOrder> selectElemeOrders(OOrderQuery query);
	
	/**
	 * 删除订单记录
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	public boolean deleteElemeOrderById(String orderId);
	
	/**
	 * 修改本地订单数据
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param orderId
	 * @return
	 */
	public boolean updateElemeLocalOrder(OOrder order);
	
	/**
	 * 插入本地订单数据
	 * xiangsy 
	 * 2017年2月23日 上午10:21:41
	 * @param order
	 * @return
	 */
	public boolean insertElemeLocalOrder(OOrder order);
	
	/**
	 * 获取未到达的推送消息
	 * xiangsy 
	 * 2017年3月1日 上午10:21:41
	 * @param order
	 * @return
	 */
	public List<String> getNonReachedMessages();
	
	/**
	 * 获取未到达的推送消息实体
	 * xiangsy 
	 * 2017年3月1日 上午10:21:41
	 * @param order
	 * @return
	 */
	public List<OMessage> getNonReachedOMessages();
	
	/**
	 * 饿了么订单商品查询
	 * xiangsy 
	 * 2017年3月6日 上午10:21:41
	 * @param order
	 * @return
	 */
	public List<ThirdOrderProduct> selectElemeOrderGoods(String orderId);
	
	/**
	 * 饿了么订单商品查询
	 * xiangsy 
	 * 2017年3月6日 上午10:21:41
	 * @param order
	 * @return
	 */
	public List<OGoodsItem> selectElemeOrderProducts(String orderId);
	
	/**
	 * 饿了么订单物流信息查询
	 * xiangsy 
	 * 2017年3月6日 上午10:21:41
	 * @param order
	 * @return
	 */
	public LogistisDmInfo selectLogisByOrderId(String orderId);
}
