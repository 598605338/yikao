package com.linjia.web.service.impl;

import java.math.BigDecimal;
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
import com.linjia.web.dao.MiaoshaActivityProductMapper;
import com.linjia.web.dao.ShoppingCarMapper;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.model.Product;
import com.linjia.web.model.ShoppingCar;
import com.linjia.web.query.ShoppingCarQuery;
import com.linjia.web.service.MiaoshaActivityProductService;
import com.linjia.web.service.ProductService;
import com.linjia.web.service.ShoppingCarService;

@Service
@Transactional
public class ShoppingCarServiceImpl extends BaseServiceImpl<ShoppingCar, Long> implements ShoppingCarService {

	@Resource
	private ShoppingCarMapper mapper;

	@Resource
	private MiaoshaActivityProductMapper miaoshaMapper;

	@Autowired
	private ProductService productService;

	@Autowired
	private MiaoshaActivityProductService miaoshaActivityProductService;

	@Override
	public BaseDao<ShoppingCar, Long> getDao() {
		return mapper;
	}

	/*
	 * 更新购物车中商品库存
	 */
	@Override
	public boolean updateQuantityByPrimaryKey(int quantity, long id, long product_id, String p_code, String mallCode) {
		// 查询ERP库存进行判断
		int currentQty = productService.getCurrentQty(product_id, p_code, mallCode);
		if (quantity > currentQty) {
			return false;
		}

		return mapper.updateQuantityByPrimaryKey(quantity, id);
	}

	/*
	 * 将商品加入购物车
	 * 
	 * return :0库存不足；1成功过；
	 */
	@Override
	public int insertCar(ShoppingCar shoppingCar, String mallCode) {
		long product_id = shoppingCar.getProductId();
		String p_code = shoppingCar.getpCode();
		
		// 查询ERP库存进行判断
		int currentQty = productService.getCurrentQty(product_id, p_code, mallCode);
		if (currentQty == 0) {
			return 0;
		}

		// 判断当前购物车是否已经存在该商品，如果存在，则商品数量+1，不存在，则加入购物车
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pCode", p_code);
		map.put("userId", shoppingCar.getUserId());

		ShoppingCar resShoppingCar = mapper.selectProductByPCodeAndUserId(map);
		if (resShoppingCar == null) {
			// 将商品加入购物车
			mapper.insertSelective(shoppingCar);
		} else {
			// 商品数量+1
			this.updateQuantityByPrimaryKey(resShoppingCar.getQuantity() + 1, resShoppingCar.getId(), product_id, p_code, mallCode);
		}

		return 1;
	}

	/*
	 * 查询购物车商品列表
	 */
	@Override
	public List<ShoppingCar> selectCarAllProduct(ShoppingCarQuery query) {
		return mapper.selectCarAllProduct(query);
	}

	/*
	 * 根据商品code和userId查询要结算中商品
	 */
	@Override
	public ShoppingCar selectProductByPCodeAndUserId(Map map) {
		return mapper.selectProductByPCodeAndUserId(map);
	}

	
	
	/**
	 * 判断商品的状态（0库存不足；1正常；），并计算每种商品的总金额
	 * 
	 * @param totalPrice
	 *            购物车总商品数量
	 * @param totalQty
	 *            购物车总价格 lixinling 2016年7月18日 下午1:36:34
	 */
	public Map<String, Object> handleProduct(HttpServletRequest request, ShoppingCar item, Map<String, Object> totalMap, String mallCode) {
		//库存不足的商品Code
		StringBuilder lowQtyPName;
		BigDecimal totalProductPrice;
		int totalProductNum;
		if (totalMap == null) {
			totalMap = new HashMap<String, Object>();
			totalProductPrice = new BigDecimal("0.00");
			totalProductNum = 0;
			lowQtyPName = new StringBuilder();
		} else {
			totalProductPrice = (BigDecimal) totalMap.get("totalProductPrice");
			totalProductNum = (int) totalMap.get("totalProductNum");
			lowQtyPName = (StringBuilder)totalMap.get("lowQtyPName");
		}

		BigDecimal itemPrice = new BigDecimal("0.00");
		System.out.println("totalProductPrice:" + totalProductPrice + "   ___totalProductNum:" + totalProductNum);

		// 查询ERP的库存
		int currentQty = productService.getCurrentQty(item.getProductId(), item.getpCode(), mallCode);

		// 购买商品数量
		int buyQty = item.getQuantity();

		// 判断是否是正在进行的秒杀商品(如果是，则根据每个用户限制数量，按秒杀价进行计算，如果超出限制数量的则按原价进行计算)
		MiaoshaActivityProduct miaoshaActivityProduct = miaoshaActivityProductService.getPanicingProductByProductId(item.getProductId());
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

		if (currentQty >= buyQty) {
			item.setItemStatus(1);
			// 购买总数量
			totalProductNum += buyQty;
			totalProductPrice = totalProductPrice.add(itemPrice);
		} else {
			item.setItemStatus(0);
			if(lowQtyPName != null){
				if(lowQtyPName.length() > 0){
					lowQtyPName.append(",").append(item.getpName());
				}else{
					lowQtyPName.append(item.getpName());
				}
			}
		}

		totalMap.put("totalProductPrice", totalProductPrice);
		totalMap.put("totalProductNum", totalProductNum);

		return totalMap;
	}

	/**
	 * 根据商品code列表和userId查询购物车中要结算的商品
	 * lixinling
	 * 2016年7月18日 上午11:43:58
	 * @param map
	 * @return
	 */
	@Override
	public List<ShoppingCar> selectCarProductByChecked(Map map) {
		return mapper.selectCarProductByChecked(map);
	}

}
