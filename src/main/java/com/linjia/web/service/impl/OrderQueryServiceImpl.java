package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.OrderQueryMapper;
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
import com.linjia.web.service.OrderQueryService;

@Service
@Transactional
public class OrderQueryServiceImpl extends BaseServiceImpl<OrderSerch, Long> implements OrderQueryService{

	@Resource
	private OrderQueryMapper mapper;

	@Override
	public BaseDao<OrderSerch, Long> getDao() {
		return null;
	}

	@Override
	public List<OrderSerch> selectSumAllSales(OrderSerchQuery query) {
		return mapper.selectSumAllSales(query);
	}
	
	@Override
	public List<ThirdOrder> selectOrderlist(ThirdLogisOrderQuery query) {
		List<ThirdOrder> list=null;
		try{
			list=mapper.selectOrderlist(query);
		}catch(Exception e){
			 e.printStackTrace();
		}
		return list;
	}

	@Override
	public ThirdOrder selectMyOrder(String shopId, Long orderId) {
		ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
		query.setOrder_id(orderId);
		query.setMall_code(shopId);
		ThirdOrder tirdOrder=mapper.selectMyOrder(query);
		return tirdOrder;
	}

	@Override
	public ThirdOrder selectBdOrder(String shopId, Long orderId) {
		ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
		query.setOrder_id(orderId);
		query.setShop_id(shopId);
		ThirdOrder tirdOrder=mapper.selectBdOrder(query);
		return tirdOrder;
	}

	@Override
	public ThirdOrder selectMtOrder(String shopId, Long orderId) {
		ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
		query.setOrder_id(orderId);
		query.setApp_poi_code(shopId);
		ThirdOrder tirdOrder=mapper.selectMtOrder(query);
		return tirdOrder;
	}

	@Override
	public ThirdOrder selectJdOrder(String shopId, Long orderId) {
		ThirdLogisOrderQuery query=new ThirdLogisOrderQuery();
		query.setOrder_id(orderId);
		query.setProduceStationNoIsv(shopId);
		ThirdOrder tirdOrder=mapper.selectJdOrder(query);
		return tirdOrder;
	}

	@Override
	public List<ThirdOrderProduct> selectMyOrderDetail(Long order_id) {
		List<ThirdOrderProduct> list=mapper.selectMyOrderDetail(order_id);
		return list;
	}

	@Override
	public List<ThirdOrderProduct> selectMtOrderProduct(Long orderId) {
		List<ThirdOrderProduct> list=mapper.selectMtOrderProduct(orderId);
		return list;
	}

	@Override
	public List<ThirdOrderProduct> selectBdOrderProduct(Long orderId) {
		List<ThirdOrderProduct> list=mapper.selectBdOrderProduct(orderId);
		return list;
	}
	

	@Override
	public List<ThirdOrderProduct> selectJdOrderProduct(Long orderId) {
		List<ThirdOrderProduct> list=mapper.selectJdOrderProduct(orderId);
		return list;
	}

	@Override
	public List<PinTuanOrder> selectPinTuanOrderlist(ThirdLogisOrderQuery query) {
		return mapper.selectPinTuanOrderlist(query);
	}

	@Override
	public List<OrderRefundManage> selectRefundOrderlist(
			OrderRefundManageQuery query) {
		return mapper.selectRefundOrderlist(query);
	}

	@Override
	public Logistics selectLogisticsById(LogisticsQuery query) {
		return mapper.selectLogisticsById(query);
	}

	@Override
	public List<ScoreOrder> selectScoreOrderlist(ThirdLogisOrderQuery query) {
		return mapper.selectScoreOrderlist(query);
	}

	@Override
	public List<ScoreOrderProduct> selectScoreOrderInfo(Long orderId) {
		return mapper.selectScoreOrderProduct(orderId);
	}

	@Override
	public Integer selectOrderNum(ThirdLogisOrderQuery query) {
		return mapper.selectOrderNum(query);
	}

	@Override
	public Integer selectScoreOrderNum(ThirdLogisOrderQuery query) {
		return mapper.selectScoreOrderNum(query);
	}

	@Override
	public Integer selectPinTuanOrderNum(ThirdLogisOrderQuery query) {
		return mapper.selectPinTuanOrderNum(query);
	}

	@Override
	public Integer selectRefundOrderNum(OrderRefundManageQuery query) {
		return mapper.selectRefundOrderNum(query);
	}

	@Override
	public PinTuanOrder selectPinTuanOrder(ThirdLogisOrderQuery query) {
		return mapper.selectPinTuanOrder(query);
	}

	@Override
	public ThirdOrder selectPtOrder(Long id) {
		return mapper.selectPtOrder(id);
	}

	@Override
	public List<ThirdOrderProduct> selectPtProOrderList(Long id) {
		return mapper.selectPtProOrderList(id);
	}

	@Override
	public boolean updatePtOrderById(PinTuanOrder pt) {
		return mapper.updatePtOrderById(pt);
	}

	@Override
	public ThirdOrder selectReScoreOrder(Long orderId) {
		return mapper.selectReScoreOrder(orderId);
	}

	@Override
	public List<ThirdOrder> selectElemeOrder(ThirdLogisOrderQuery query) {
		return mapper.selectElemeOrder(query);
	}
}
