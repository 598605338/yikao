package com.linjia.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.OrderGroupProductMapper;
import com.linjia.web.model.OrderGroupProduct;
import com.linjia.web.model.ShoppingCar;
import com.linjia.web.service.OrderGroupProductService;

@Service
@Transactional
public class OrderGroupProductServiceImpl extends BaseServiceImpl<OrderGroupProduct, Long> implements OrderGroupProductService {

	@Resource
	private OrderGroupProductMapper mapper;

	@Override
	public BaseDao<OrderGroupProduct, Long> getDao() {
		return mapper;
	}

	/**
	 * 批量插入确认下单中购买的商品数据
	 * lixinling 
	 * 2016年7月25日 下午1:37:41
	 * 
	 * @param shoppingCarList
	 * @return
	 */
	@Override
	public int insertBatchProductList(List<ShoppingCar> shoppingCarList, Long groupId) {
		int row = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", shoppingCarList);
		map.put("groupId", groupId);
		try {
			row = mapper.insertBatchProductList(map);
			logger.info("批量插入确认下单中购买的商品数据成功，插入数据条数：" + row);
		} catch (Exception e) {
			logger.error("批量插入确认下单中购买的商品数据失败", e);
		}
		return row;
	}

	/**
	 * 根据订单id查询购买的商品数据
	 * lixinling
	 * 2016年7月25日 下午1:37:41
	 * @param groupId
	 * @return
	 */
	@Override
	public List<OrderGroupProduct> selectProductListByGroupId(long groupId) {
		return mapper.selectProductListByGroupId(groupId);
	}

	@Override
	public boolean updateProductQuantity(long groupId) {
		boolean updateFlg = false;
		String pCode = null;
		long productId = 0;
		int quantity = 0;
		List<OrderGroupProduct> list = mapper.selectProductListByGroupId(groupId);
		if(list != null && list.size() > 0){
			for(OrderGroupProduct item:list){
				pCode = item.getpCode();
				productId = item.getProductId();
				quantity = item.getQuantity();
				//TODO ERP库存 恢复
				
				updateFlg = true;
			}
		}
		return updateFlg;
		
	}

}
