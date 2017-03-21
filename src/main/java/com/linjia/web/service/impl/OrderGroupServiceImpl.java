package com.linjia.web.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.tools.Util;
import com.linjia.web.dao.OrderGroupMapper;
import com.linjia.web.dao.OrderGroupProductMapper;
import com.linjia.web.dao.ScoreChangeMapper;
import com.linjia.web.dao.ShoppingCarMapper;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.model.OrderGroup;
import com.linjia.web.model.OrderProductModel;
import com.linjia.web.model.Product;
import com.linjia.web.model.ScoreChange;
import com.linjia.web.model.ShoppingCar;
import com.linjia.web.query.OrderGroupQuery;
import com.linjia.web.service.MallMasterService;
import com.linjia.web.service.MiaoshaActivityProductService;
import com.linjia.web.service.OrderGroupService;
import com.linjia.web.service.ProductService;

@Service
@Transactional
public class OrderGroupServiceImpl extends BaseServiceImpl<OrderGroup, Long> implements OrderGroupService {

	@Resource
	private OrderGroupMapper mapper;

	@Resource
	private OrderGroupProductMapper orderGroupProductMapper;

	@Resource
	private ScoreChangeMapper scoreChangeMapper;

	@Resource
	private ShoppingCarMapper shoppingCarMapper;

	@Autowired
	private OrderidGenerateServiceImpl orderidGenerateServiceImpl;

	@Autowired
	private ProductService productService;

	@Autowired
	private MiaoshaActivityProductService miaoshaActivityProductService;

	@Override
	public BaseDao<OrderGroup, Long> getDao() {
		return mapper;
	}

	/**
	 * 确认订单操作 
	 * lixinling 
	 * 2016年7月25日 上午11:10:12
	 * 
	 * @param orderGroup
	 * @param shoppingCarList
	 * @return
	 */
	public boolean insertConfirmOrder(OrderGroup orderGroup, List<ShoppingCar> shoppingCarList) {
		try {
			if (orderGroup != null) {

				// 生成groupId
				orderGroup.setId(orderidGenerateServiceImpl.generateOrderGroupId());

				// b_order_group插入记录
				int row = mapper.insertSelective(orderGroup);
				logger.info("确认订单操作：b_order_group插入记录成功，插入条数：" + row + "条,返回主键ID=" + orderGroup.getId());

				// 插入购买商品
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("list", shoppingCarList);
				map.put("groupId", orderGroup.getId());
				row = orderGroupProductMapper.insertBatchProductList(map);
				logger.info("批量插入确认下单中购买的商品数据成功，插入数据条数：" + row);

				// 减少下单商品库存
				// 删除购物车中已下单的商品
				for (ShoppingCar item : shoppingCarList) {
					if (item.getItemStatus() == Constants.QTY_STATUS.NORMAL) {
						// TODO 减少ERP下单商品库存

						// 从购物车中删除已下单的商品
						shoppingCarMapper.deleteByPrimaryKey(new Long(item.getId()));
						logger.info("从购物车中删除已下单的商品");
					}
				}

			} else {
				logger.warn("OrderGroup对象为空或购买商品列表shoppingCarList为空");
				return false;
			}
		} catch (Exception e) {
			logger.error("确认订单操作 error", e);
			throw e;
		}
		return true;
	}

	@Override
	public boolean updateStatusById(Map<String, Object> map) {
		boolean res = false;
		return res;
	}

	/**
	 * 查询我的全部订单
	 * lixinling 
	 * 2016年7月28日 下午3:32:16
	 * @param map
	 * @return
	 */
	@Override
	public List<OrderGroup> selectMyAllOrderList(OrderGroupQuery query) {
		return mapper.selectMyAllOrderList(query);
	}

	/**
	 * 对订单中及时送和预约配送进行分类,判断商品的状态（0库存不足；1正常；），并计算每种商品的总金额
	 * 
	 * @param totalPrice
	 *            购物车总商品数量
	 * @param totalQty
	 *            购物车总价格 lixinling 2016年7月18日 下午1:36:34
	 */
	public Map<String, Object> handleOrderProduct(HttpServletRequest request, List<ShoppingCar> shoppingCarList,
			Map<String, Object> totalMap, String mallCode) {
		// (及时送达对象)库存不足的商品Code
		StringBuilder immediateLowQtyPCode = new StringBuilder();
		// (及时送达对象)库存不足的商品Name
		StringBuilder immediateLowQtyPName = new StringBuilder();
		// (预约配送对象)库存不足的商品Code
		StringBuilder prepareLowQtyPCode = new StringBuilder();
		// (预约配送对象)库存不足的商品Name
		StringBuilder prepareLowQtyPName = new StringBuilder();

		// 及时送达对象
		OrderProductModel immediateSendModel = new OrderProductModel();
		// 预约配送对象
		OrderProductModel prepareSendModel = new OrderProductModel();

		// 及时送达商品数量
		int immediateProductNum = 0;
		// 及时送达商品金额
		BigDecimal immediateProductPrice = new BigDecimal("0.00");
		// 及时送达商品列表
		List<ShoppingCar> immediateProductList = new ArrayList<ShoppingCar>();

		// 预约配送商品数量
		int prepareProductNum = 0;
		// 预约配送商品金额
		BigDecimal prepareProductPrice = new BigDecimal("0.00");
		// 预约配送商品列表
		List<ShoppingCar> prepareProductList = new ArrayList<ShoppingCar>();

		// 购物车每条记录金额
		BigDecimal itemPrice = null;
		int currentQty = 0;
		for (ShoppingCar item : shoppingCarList) {
			itemPrice = new BigDecimal("0.00");
			// 购买商品数量
			int buyQty = item.getQuantity();
			// 及时送的商品处理
			if (Constants.PRODUCT_SEND_TYPE.IMMEDIATE == item.getpSendType()) {
				// 查询ERP的库存
				currentQty = productService.getCurrentQty(item.getProductId(), item.getpCode(), mallCode);

				// 如果库存不足，则不再进行itemPrice的计算
				if (currentQty < buyQty) {
					item.setItemStatus(0);
					if (immediateLowQtyPCode != null) {
						if (immediateLowQtyPCode.length() > 0) {
							immediateLowQtyPCode.append(",").append(item.getpCode());
							immediateLowQtyPName.append(",").append(item.getpName());
						} else {
							immediateLowQtyPCode.append(item.getpCode());
							immediateLowQtyPName.append(item.getpName());
						}
					}
					continue;
				}

				// 判断是否是正在进行的秒杀商品(如果是，则根据每个用户限制数量，按秒杀价进行计算，如果超出限制数量的则按原价进行计算)
				MiaoshaActivityProduct miaoshaActivityProduct = miaoshaActivityProductService.getPanicingProductByProductId(item
						.getProductId());
				if (miaoshaActivityProduct != null) {
					// 每个用户限购数量
					int limitQty = miaoshaActivityProduct.getLimitQuantity();
					// 秒杀价
					BigDecimal panicPrice = miaoshaActivityProduct.getPbPrice();

					if (limitQty >= buyQty) {
						itemPrice = itemPrice.add(panicPrice.multiply(new BigDecimal(String.valueOf(buyQty))));
					} else if (limitQty < buyQty) {
						Product product = productService.selectById(Long.valueOf(item.getProductId()));
						BigDecimal salePrice = product.getSalePrice();
						// 超出限购数量的按原价计算
						int overQty = buyQty - limitQty;
						// 秒杀价商品总和
						itemPrice = itemPrice.add(panicPrice.multiply(new BigDecimal(String.valueOf(limitQty))));

						// 原价商品总和
						itemPrice = itemPrice.add(salePrice.multiply(new BigDecimal(String.valueOf(overQty))));
					}
				} else {
					// 未参加秒杀活动
					Product product = productService.selectById(Long.valueOf(item.getProductId()));
					BigDecimal salePrice = product.getSalePrice();

					// 原价商品总和
					itemPrice = itemPrice.add(salePrice.multiply(new BigDecimal(String.valueOf(buyQty))));
				}

				// 设置购物车每条记录的价格
				item.setItemPrice(itemPrice);

				item.setItemStatus(1);
				// 购买总数量
				immediateProductNum += buyQty;
				immediateProductPrice = immediateProductPrice.add(itemPrice);

				immediateProductList.add(item);
			} else {
				// 预约配送的商品的处理
				// 预约配送的商品的价格和库存
				Product product = productService.selectById(Long.valueOf(item.getProductId()));
				BigDecimal salePrice = product.getSalePrice();
				currentQty = product.getQuantity();

				// 如果库存不足，则不再进行itemPrice的计算
				if (currentQty < buyQty) {
					item.setItemStatus(0);
					if (prepareLowQtyPCode != null) {
						if (prepareLowQtyPCode.length() > 0) {
							prepareLowQtyPCode.append(",").append(item.getpCode());
							prepareLowQtyPName.append(",").append(item.getpName());
						} else {
							prepareLowQtyPCode.append(item.getpCode());
							prepareLowQtyPName.append(item.getpName());
						}
					}
					continue;
				}

				// 原价商品总和
				itemPrice = itemPrice.add(salePrice.multiply(new BigDecimal(String.valueOf(buyQty))));

				// 设置购物车每条记录的价格
				item.setItemPrice(itemPrice);
				item.setItemStatus(1);
				// 购买总数量
				prepareProductNum += buyQty;
				prepareProductPrice = prepareProductPrice.add(itemPrice);
				prepareProductList.add(item);
			}

		}
		immediateSendModel.setProductNum(immediateProductNum);
		immediateSendModel.setProductPrice(immediateProductPrice);
		immediateSendModel.setShoppingCarList(immediateProductList);

		prepareSendModel.setProductNum(prepareProductNum);
		prepareSendModel.setProductPrice(prepareProductPrice);
		prepareSendModel.setShoppingCarList(prepareProductList);

		totalMap.put("immediateSendModel", immediateSendModel);
		totalMap.put("prepareSendModel", prepareSendModel);
		totalMap.put("immediateLowQtyPCode", immediateLowQtyPCode.toString());
		totalMap.put("immediateLowQtyPName", immediateLowQtyPName.toString());
		totalMap.put("prepareLowQtyPCode", prepareLowQtyPCode.toString());
		totalMap.put("prepareLowQtyPName", prepareLowQtyPName.toString());
		return totalMap;
	}

}
