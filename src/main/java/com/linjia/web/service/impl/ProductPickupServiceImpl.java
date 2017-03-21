package com.linjia.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.tools.Tools;
import com.linjia.web.dao.ProductPickupMapper;
import com.linjia.web.model.ProductPickup;
import com.linjia.web.query.ProductPickupQuery;
import com.linjia.web.service.ProductPickupService;
import com.linjia.web.service.ProductService;

@Service
@Transactional
public class ProductPickupServiceImpl extends BaseServiceImpl<ProductPickup, Long> implements ProductPickupService {
	
	@Resource
	private ProductPickupMapper mapper;
	
	@Autowired
	private ProductService productService;

	@Override
	public BaseDao<ProductPickup, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ProductPickup> selectProductPickupList(ProductPickupQuery query) {
		List<ProductPickup> list = mapper.selectProductPickupList(query);
		if(list != null && list.size() > 0){
			//判断商品的库存量
			for(ProductPickup item : list){
				int currentQty = productService.getCurrentQty(item.getProductId(), item.getpCode(), query.getMallCode());
				if(currentQty > 0){
					item.setItemStatus(Constants.QTY_STATUS.NORMAL);
				}else{
					item.setItemStatus(Constants.QTY_STATUS.LOW);
				}
			}
		}
		return list;
	}

	@Override
	public int delMyProductPickupItem(String itemIds) {
		if(!Tools.isEmpty(itemIds)){
			String itemIdArr[] = itemIds.split(",");
			for(String id:itemIdArr){
				mapper.deleteByPrimaryKey(Long.valueOf(id));
			}
		}
		return 1;
	}
	

}
