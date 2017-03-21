package com.linjia.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.constants.Application;
import com.linjia.tools.Util;
import com.linjia.web.dao.ElemeOrderGroupMapper;
import com.linjia.web.dao.ElemeOrderMapper;
import com.linjia.web.dao.ElemeOrderProductMapper;
import com.linjia.web.model.LogistisDmInfo;
import com.linjia.web.model.ThirdOrderProduct;
import com.linjia.web.query.OOrderQuery;
import com.linjia.web.service.ElemeOrderService;
import com.linjia.web.thirdService.eleme.interfaces.entity.message.OMessage;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OGoodsGroup;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OGoodsItem;
import com.linjia.web.thirdService.eleme.interfaces.entity.order.OOrder;
import com.linjia.web.thirdService.eleme.interfaces.enumeration.order.OInvalidateType;
import com.linjia.web.thirdService.eleme.interfaces.exception.ServiceException;
import com.linjia.web.thirdService.eleme.interfaces.service.MessageService;
import com.linjia.web.thirdService.eleme.interfaces.service.OrderService;
import com.linjia.web.thirdService.eleme.oauth.Token;

@Service
@Transactional
public class ElemeOrderServiceImpl implements ElemeOrderService {
	
	@Resource
	private ElemeOrderMapper mapper;
	
	@Resource
	private ElemeOrderGroupMapper groupMapper;
	
	@Resource
	private ElemeOrderProductMapper elemeGoodsMapper;

	@Override
	public boolean insertElemeOrder(String orderId) {
		boolean flag=false;
		try {
//			OAuthClient client=new OAuthClient();
//			Token token=client.getTokenInClientCredentials();
			Token token=Util.getElemeToken();
			if(token!=null){
				OrderService orderService = new OrderService(token);
				OOrder order= orderService.getOrder(orderId);
				if(order!=null){
//					System.out.println(JSONUtil.ObjToJSON(order));
					List<String> phoneList=order.getPhoneList();
					if(phoneList!=null&&phoneList.size()>0){
						String phone=String.join(";",phoneList);
						order.setPhone(phone);
					}
					flag=mapper.insertElemeOrder(order);
					String oderId=order.getId();
					if(flag){
						List<OGoodsGroup> groups=order.getGroups();
						if(groups!=null&&groups.size()>0){
							for (OGoodsGroup oGoodsGroup : groups) {
								List<OGoodsItem> items=oGoodsGroup.getItems();
								Long categoryId=null;
								if(items!=null&&items.size()>0){
									for (OGoodsItem oGoodsItem : items) {
										categoryId=oGoodsItem.getCategoryId();
										oGoodsItem.setOrderId(oderId);
										flag=elemeGoodsMapper.insertElemeOrderProduct(oGoodsItem);
									}
								}
								oGoodsGroup.setOrder_id(oderId);
								oGoodsGroup.setCategoryId(categoryId);
								flag=groupMapper.insertElemeOrderGroup(oGoodsGroup);
							}
						}
					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return flag;
	}

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
	@Override
	public boolean updateElemeOrder(String orderId,String remark,int updType,Integer type) {
		boolean oflag=false;
		try {
//			OAuthClient client=new OAuthClient();
//			Token token=client.getTokenInClientCredentials();
			Token token=Util.getElemeToken();
			if(token!=null){
				OrderService orderService = new OrderService(token);
				OOrder order=null;
				if(updType==1){
					order=orderService.confirmOrder(orderId);
					order.setRecive_time(new Date());
					order.setOrder_status(2);
					//当天第几单
					Integer orderNum=Util.getTodayOrderNum("E",order.getShopId()+"");
					order.setOrderNum(orderNum);
				}
				if(updType==2){
					if(type==99){
						type=0;
					}
					OInvalidateType otype=OInvalidateType.findValue(type);
					order=orderService.cancelOrder(orderId,otype,remark);
					order.setOrder_cancel_time(new Date());
					order.setCancelReason(type+"");
					order.setOrder_status(8);
				}
				if(updType==3){
					order=orderService.agreeRefund(orderId);
					order.setOrder_cancel_time(new Date());
					order.setCancelReason("同意客户退单");
					order.setOrder_status(8);
				}
				if(updType==4){
					order=orderService.disagreeRefund(orderId,remark);
					order.setOrderremark("不同意客户退单");
				}
				if(order!=null){
					List<String> phoneList=order.getPhoneList();
					if(phoneList!=null&&phoneList.size()>0){
						String phone=String.join(";",phoneList);
						order.setPhone(phone);
					}
					oflag=mapper.updateElemeOrder(order);
					//更新商品信息
//					String oderId=order.getId();
//					if(oflag){
//						List<OGoodsGroup> groups=order.getGroups();
//						if(groups!=null&&groups.size()>0){
//							for (OGoodsGroup oGoodsGroup : groups) {
//								List<OGoodsItem> items=oGoodsGroup.getItems();
//								Long categoryId=null;
//								if(items!=null&&items.size()>0){
//									for (OGoodsItem oGoodsItem : items) {
//										categoryId=oGoodsItem.getCategoryId();
//										oGoodsItem.setOrderId(oderId);
//										oflag=elemeGoodsMapper.updateElemeOrderProduct(oGoodsItem);
//									}
//								}
//								oGoodsGroup.setOrder_id(oderId);
//								oGoodsGroup.setCategoryId(categoryId);
//								oflag=groupMapper.updateElemeOrderGroup(oGoodsGroup);
//							}
//						}
//					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return oflag;
	}

	@Override
	public OOrder selectElemeOrderById(String orderId) {
		return mapper.selectElemeOrderById(orderId);
	}

	@Override
	public List<OOrder> selectElemeOrders(OOrderQuery query) {
		return mapper.selectElemeOrders(query);
	}

	@Override
	public boolean deleteElemeOrderById(String orderId) {
		return mapper.deleteElemeOrderById(orderId);
	}

	public boolean updateElemeLocalOrder(OOrder order){
		boolean oflag=mapper.updateElemeOrder(order);
		return oflag;
	}

	@Override
	public boolean insertElemeLocalOrder(OOrder order) {
		boolean flag=false;
		try {
			if(order!=null){
//				System.out.println(JSONUtil.ObjToJSON(order));
				List<String> phoneList=order.getPhoneList();
				if(phoneList!=null&&phoneList.size()>0){
					String phone=String.join(";",phoneList);
					order.setPhone(phone);
				}
				flag=mapper.insertElemeOrder(order);
				String oderId=order.getId();
				if(flag){
					List<OGoodsGroup> groups=order.getGroups();
					if(groups!=null&&groups.size()>0){
						for (OGoodsGroup oGoodsGroup : groups) {
							List<OGoodsItem> items=oGoodsGroup.getItems();
							Long categoryId=null;
							if(items!=null&&items.size()>0){
								for (OGoodsItem oGoodsItem : items) {
									categoryId=oGoodsItem.getCategoryId();
									oGoodsItem.setOrderId(oderId);
									flag=elemeGoodsMapper.insertElemeOrderProduct(oGoodsItem);
								}
							}
							oGoodsGroup.setOrder_id(oderId);
							oGoodsGroup.setCategoryId(categoryId);
							flag=groupMapper.insertElemeOrderGroup(oGoodsGroup);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public List<String> getNonReachedMessages(){
		List<String> messages=null;
		try{
			Token token=Util.getElemeToken();
			MessageService msgService=new MessageService(token);
			messages=msgService.getNonReachedMessages(Application.ELEME_APPID);
		}catch(Exception e){
			e.printStackTrace();
			return messages;
		}
		return messages;
	}
	
	public List<OMessage> getNonReachedOMessages(){
		List<OMessage> messages=null;
		try{
			Token token=Util.getElemeToken();
			MessageService msgService=new MessageService(token);
			messages=msgService.getNonReachedOMessages(Application.ELEME_APPID);
		}catch(Exception e){
			e.printStackTrace();
			return messages;
		}
		return messages;
	}
	
	@Override
	public List<ThirdOrderProduct> selectElemeOrderGoods(String orderId) {
		List<ThirdOrderProduct> list=elemeGoodsMapper.selectElemeOrderGoods(orderId);
		return list;
	}
	
	@Override
	public List<OGoodsItem> selectElemeOrderProducts(String orderId) {
		OOrderQuery query=new OOrderQuery();
		query.setOrder_id(orderId);
		List<OGoodsItem> list=elemeGoodsMapper.selectElemeOrderProducts(query);
		return list;
	}

	@Override
	public LogistisDmInfo selectLogisByOrderId(String orderId) {
		return mapper.selectLogisByOrderId(orderId);
	}
}
