package com.linjia.web.service.impl;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.Util;
import com.linjia.web.dao.ProductMapper;
import com.linjia.web.model.Product;
import com.linjia.web.query.ProductQuery;
import com.linjia.web.service.MallProductStoreService;
import com.linjia.web.service.ProductService;
import com.linjia.web.service.ProductSpecService;
import com.linjia.web.service.ProductTagsService;
import com.linjia.web.uhd123.service.UhdOrderService;

@Service
@Transactional
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {
	
	@Resource
	private ProductMapper mapper;
	
	@Autowired
	private ProductSpecService productSpecService;
	
	@Autowired
	private MallProductStoreService mallProductStoreService;
	
	@Autowired
	private ProductTagsService productTagsService;
	
	@Autowired
	private UhdOrderService uhdOrderService;
	
	@Override
	public BaseDao<Product, Long> getDao() {
		return mapper;
	}

	@Override
	public List<Product> selectCatagoryProductList(ProductQuery query) {
		return mapper.selectCatagoryProductList(query);
	}


	/* 
	 * 	根据商品id取得商品当前的库存量
	 */
	@Override
	public int getCurrentQty(long product_id, String p_code, String mallCode) {
		int currentQty = 0;
		int safeQty = 0;
		
		//ERP库存数
		int storeQty = 0;
		
		//currentQty = ERP库存数 - 安全库存;
		//取得ERP库存量
		storeQty = Util.queryQtyByStore(mallCode, p_code);
		//取得安全库存
		safeQty = mallProductStoreService.selectSafeQtyByMallAndPCode(mallCode, p_code);
		currentQty = storeQty - safeQty;
		return currentQty;
	}

	@Override
	public int selectQuantityByPrimaryKey(Long id) {
		return mapper.selectQuantityByPrimaryKey(id);
	}

	@Override
	public int insertProduct(Product product) {
		int row = mapper.insertSelective(product);
		if(row == 1){
			//插入商品标签和促销标签(标签类型：0默认标签;1促销标签；2商品标签)
			String pLabel = product.getpLabel();
			String pPromotionLabel = product.getpPromotionLabel();
			
			if(pLabel != null && pLabel.split(",").length > 0){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("productId", product.getId());
				map.put("type", 2);
				productTagsService.deleteTagsByProductId(map);
				
				map.clear();
				map.put("type", 2);
				map.put("productId", product.getId());
				map.put("deleted",0);
				map.put("list", pLabel.split(","));
				productTagsService.insertBatch(map);
			}
			
			if(pPromotionLabel != null && pPromotionLabel.split(",").length > 0){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("productId", product.getId());
				map.put("type", 1);
				productTagsService.deleteTagsByProductId(map);
				
				map.clear();
				map.put("type", 1);
				map.put("productId", product.getId());
				map.put("deleted",0);
				map.put("list", pPromotionLabel.split(","));
				productTagsService.insertBatch(map);
			}
				
			if(uhdOrderService.ptmskus(product, product.getCreator())){
				logger.info("【同步平台商品范围到鼎力云】成功。");
			}else{
				logger.info("【同步平台商品范围到鼎力云】失败。");
			}
		}
		return row;
	}

	@Override
	public int insertBatch(List<Product> list, String userId) {
		int row = mapper.insertBatch(list);
		if(row > 0){
			if(uhdOrderService.ptmskus(list, userId)){
				logger.info("【同步平台商品范围到鼎力云】成功。");
			}else{
				logger.info("【同步平台商品范围到鼎力云】失败。");
			}
		}
		return row;
	}

	@Override
	public int countByExample(ProductQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public int checkPCode(String pCode) {
		return mapper.checkPCode(pCode);
	}

	@Override
	public boolean updateCatagoryBatchByPCode(List<Product> list) {
		return mapper.updateCatagoryBatchByPCode(list);
	}
	

	
}
