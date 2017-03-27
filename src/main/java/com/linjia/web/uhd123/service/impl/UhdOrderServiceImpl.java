package com.linjia.web.uhd123.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;

import com.linjia.tools.HttpRequestUtils;
import com.linjia.web.model.Product;
import com.linjia.web.uhd123.common.Configure;
import com.linjia.web.uhd123.model.PlatformSku;
import com.linjia.web.uhd123.service.UhdOrderService;

/** 
 * 鼎力云订单
 * @author  lixinling: 
 * @date 2016年10月11日 上午10:30:41 
 * @version 1.0 
*/
@Service
public class UhdOrderServiceImpl implements UhdOrderService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean ptmskus(List<Product> list, String operator) {
		PlatformSku[] skus = new PlatformSku[list.size()];
		for (int i = 0; i < list.size(); i++) {
			skus[i] = createPlatformSku(list.get(i));
		}

		// 同步平台商品范围到鼎力云
		JSONObject result = ptmskusToUhd(operator, skus);
        return result.optBoolean("success");
	}
	
	@Override
	public boolean ptmskus(Product product, String operator) {
		PlatformSku[] skus = new PlatformSku[1];
		skus[0] = createPlatformSku(product);

		// 同步平台商品范围到鼎力云
		JSONObject result = ptmskusToUhd(operator, skus);
        return result.optBoolean("success");
	}

	/**
	 * 创建PlatformSku对象
	 * lixinling 
	 * 2016年12月26日 上午11:18:48
	 * @param product
	 * @return
	 */
	public PlatformSku createPlatformSku(Product product) {
		PlatformSku sku = new PlatformSku();
		sku.setPlatform_id(Configure.platform_id);
		sku.setShop_id(Configure.shop_id);
		sku.setSp_sku_id(product.getpCode());
		sku.setSku_id(product.getpCode());
		sku.setSku_name(product.getName());
		sku.setStatus("上架");

		return sku;
	}

	/**
	 * 同步平台商品范围到鼎力云
	 * lixinling 
	 * 2016年10月15日 下午5:22:09
	 * tenant_id 租户ID
	 * @param operator 操作人
	 * id 退换货id
	 * @return
	 */
	public static JSONObject ptmskusToUhd(String operator, PlatformSku[] skus) {
		Map<String, String> infoMap = com.linjia.web.uhd123.common.Configure.getRequestBaseInfo();
		String tenant_id = infoMap.get("tenant_id");
		String baseUrl = infoMap.get("baseUrl");
		String authorization = infoMap.get("authorization");
		String urlstr = baseUrl + tenant_id + "/eshop/ptmskuservice/ptmskus?operator=" + operator;
		JSONArray array = new JSONArray(Arrays.asList(skus));
		JSONObject body = new JSONObject();
		body.put("skus", array);
		JSONObject result = HttpRequestUtils.httpPost(urlstr, body, authorization);
		return result;
	}

}
