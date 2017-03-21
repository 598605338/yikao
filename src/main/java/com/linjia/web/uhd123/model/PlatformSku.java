package com.linjia.web.uhd123.model;


/** 
 * 同步平台商品范围到鼎力云
 * @author  lixinling: 
 * @date 2016年12月22日 下午5:01:08 
 * @version 1.0 
*/
public class PlatformSku {

	/** 平台ID* */
	private String platform_id;
	
	/** 商家ID* */
	private String shop_id;
	
	/** 平台商品货号* */
	private String sp_sku_id;
	
	/** 商家商品货号* */
	private String sku_id;
	
	/** 商家商品名称* */
	private String sku_name;
	
	/** 上架* */
	private String status;

	public String getPlatform_id() {
		return platform_id;
	}

	public void setPlatform_id(String platform_id) {
		this.platform_id = platform_id;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getSp_sku_id() {
		return sp_sku_id;
	}

	public void setSp_sku_id(String sp_sku_id) {
		this.sp_sku_id = sp_sku_id;
	}

	public String getSku_id() {
		return sku_id;
	}

	public void setSku_id(String sku_id) {
		this.sku_id = sku_id;
	}

	public String getSku_name() {
		return sku_name;
	}

	public void setSku_name(String sku_name) {
		this.sku_name = sku_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
