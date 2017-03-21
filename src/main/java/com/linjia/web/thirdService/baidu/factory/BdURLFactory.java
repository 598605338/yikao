package com.linjia.web.thirdService.baidu.factory;

import java.util.HashMap;
import java.util.Map;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;
import com.linjia.web.thirdService.meituan.utils.PropertiesUtil;

/**
 * Created by xiangshouyi on 16/08/11
 */
public class BdURLFactory {

	private static String urlPrefix = "";
	private static Map<String, String> urlMap;
	private static Map<String, String> urlTypeMap;

	static {
		urlMap = new HashMap<String, String>();
		urlTypeMap = new HashMap<String, String>();

		// 门店
		// 创建商户
		urlMap.put("shopCreate", "shop.create");
		// 修改商户
		urlMap.put("shopUpdate", "shop.update");
		// 商户列表
		urlMap.put("shopList", "shop.list");
		// 下线商户
		urlMap.put("shopOffline", "shop.offline");
		// 商户开业
		urlMap.put("shopOpen", "shop.open");
		// 商户歇业
		urlMap.put("shopClose", "shop.close");
		// 查看商户
		urlMap.put("shopGet", "shop.get");
		// 商户订单阈值设置(已下线)
		urlMap.put("shopThresholdSet", "shop.threshold.set");
		// 商户配送时延设置
		urlMap.put("shopDeliveryDelay", "shop.delivery.delay");
		// 商户资质图片上传
		urlMap.put("shopPicUpload", "shop.pic.upload");
		// 商户公告
		urlMap.put("shopAnnouncementSet", "shop.announcement.set");
		// 查看商户代码
		urlMap.put("shopCode", "shop.code");

		urlTypeMap.put("shopCreate", "post");
		urlTypeMap.put("shopUpdate", "post");
		urlTypeMap.put("shopList", "post");
		urlTypeMap.put("shopOffline", "post");
		urlTypeMap.put("shopOpen", "post");
		urlTypeMap.put("shopClose", "post");
		urlTypeMap.put("shopGet", "post");
		urlTypeMap.put("shopThresholdSet", "post");
		urlTypeMap.put("shopDeliveryDelay", "post");
		urlTypeMap.put("shopPicUpload", "post");
		urlTypeMap.put("shopAnnouncementSet", "post");
		urlTypeMap.put("shopCode", "post");

		// 图片
		// urlMap.put("imageUpload", "image/upload");
		// urlTypeMap.put("imageUpload","POST");

		// 订单
		// 确认订单
		urlMap.put("orderConfirm", "order.confirm");
		// 取消订单
		urlMap.put("orderCancel", "order.cancel");
		// 完成订单
		urlMap.put("orderComplete", "order.complete");
		// 查看订单状态
		urlMap.put("orderStatusGet", "order.status.get");
		// 查看订单详情
		urlMap.put("orderGet", "order.get");
		// 查看订单列表
		urlMap.put("orderList", "order.list");
		// 扫码取餐（非开放）
		urlMap.put("orderScancode", "order.scan.code");
		// 锁定订单（非开放）
		urlMap.put("orderLock", "order.lock");
		// 订单退款（非开放）
		urlMap.put("orderRefund", "order.refund");
		// 创建订单
		urlMap.put("orderCreate", "order.create");
		// 订单状态查询
		urlMap.put("orderStatusGet", "order.status.get");
		// 订单状态推送
		urlMap.put("orderStatusPush", "order.status.push");

		urlTypeMap.put("orderConfirm", "post");
		urlTypeMap.put("orderCancel", "post");
		urlTypeMap.put("orderComplete", "post");
		urlTypeMap.put("orderStatusGet", "post");
		urlTypeMap.put("orderGet", "post");
		urlTypeMap.put("orderList", "post");
		urlTypeMap.put("orderScancode", "post");
		urlTypeMap.put("orderLock", "post");
		urlTypeMap.put("orderRefund", "post");
		urlTypeMap.put("orderCreate", "post");
		urlTypeMap.put("orderStatusGet", "post");
		urlTypeMap.put("orderStatusPush", "post");
		
		//商品
		//商品上传	
		urlMap.put("skuCreate","sku.create");
		//商品修改	
		urlMap.put("skuUpdate","sku.update");
		//商品列表	
		urlMap.put("skuList","sku.list");
		//商品上线	
		urlMap.put("skuOnline","sku.online");
		//商品下线	
		urlMap.put("skuOffline","sku.offline");
		//批量修改商品库存	
		urlMap.put("skuStockUpdateBatch","sku.stock.update.batch");
		//批量修改商品价格	
		urlMap.put("skuPriceUpdateBatch","sku.price.update.batch");

		urlTypeMap.put("skuCreate","post");
		urlTypeMap.put("skuUpdate","post");
		urlTypeMap.put("skuList","post");
		urlTypeMap.put("skuOnline","post");
		urlTypeMap.put("skuOffline","post");
		urlTypeMap.put("skuStockUpdateBatch","post");
		urlTypeMap.put("skuPriceUpdateBatch","post");
	}

	/**
	 * 通过方法名生成url
	 * 
	 * @param methodName
	 * @return
	 */
	public static String genUrlPrefix(){
		try {
			if (urlPrefix.equals("")) {
				String env = PropertiesUtil.getEnvironmentMode();
				if ("0".equals(env)) {
					urlPrefix = "http://api.waimai.baidu.com";
				} else if ("1".equals(env)) {
					urlPrefix = "http://api.waimai.baidu.com";
				} else if ("2".equals(env)) {
					urlPrefix = "http://127.0.0.1:8080/api/v1/";
				}
			}
		 }catch (ApiSysException e) {
			e.printStackTrace();
		}
		String url = urlPrefix;
		return url;
	}

	/**
	 * 获取请求的类型
	 * 
	 * @param methodName
	 * @return
	 */
	public static String genUrlType(String methodName) {
		String methodType = urlTypeMap.get(methodName);
		return methodType;
	}

	/**
	 * 获取请求的命令
	 * 
	 * @param methodName
	 * @return
	 */
	public static String genUrlCmd(String cmdStr) {
		String cmd = urlMap.get(cmdStr);
		return cmd;
	}
}
