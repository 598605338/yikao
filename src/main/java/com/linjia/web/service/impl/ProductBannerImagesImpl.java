package com.linjia.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.ProductBannerImagesMapper;
import com.linjia.web.dao.ProductSpecMapper;
import com.linjia.web.model.ProductBannerImages;
import com.linjia.web.model.ProductSpec;
import com.linjia.web.service.ProductBannerImagesService;
import com.linjia.web.service.ProductSpecService;

@Service
@Transactional
public class ProductBannerImagesImpl extends BaseServiceImpl<ProductBannerImages, Long> implements ProductBannerImagesService {
	
	@Resource
	private ProductBannerImagesMapper mapper;
	
	@Override
	public BaseDao<ProductBannerImages, Long> getDao() {
		return mapper;
	}

	@Override
	public List<ProductBannerImages> selectAllByProductId(long productId) {
		return mapper.selectAllByProductId(productId);
	}

	@Override
	public int insertBatchProductBannerImageList(Map<String, Object> map) {
		return mapper.insertBatchProductBannerImageList(map);
	}

	@Override
	public int deleteByProductId(Long productId) {
		return mapper.deleteByProductId(productId);
	}

	@Override
	public int insertProductBannerImage(Map<String, Object> map) {
		return mapper.insertProductBannerImage(map);
	}

	@Override
	public int updateProductBannerImageById(Map<String, Object> map) {
		return mapper.updateProductBannerImageById(map);
	}

	@Override
	public boolean updateOrInsertProductBannerImageById(Map<String, Object> map) {
		Long bannerImageId = (Long)map.get("bannerImageId");
		if(bannerImageId != null && bannerImageId.longValue() > 0){
			mapper.updateProductBannerImageById(map);
		}else{
			mapper.insertProductBannerImage(map);
		}
		return true;
	}


	

}
