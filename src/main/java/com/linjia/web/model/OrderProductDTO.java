package com.linjia.web.model;


/** 
 * 订单的商品信息
 * @author  lixinling: 
 * @date 2017年1月10日 上午9:55:37 
 * @version 1.0 
*/
public class OrderProductDTO {
	/** 订单主表订单id* */
	private Long orderId;
	/** 调整单记录id（0:原单商品明细;非0:调整单id 或者 确认单id)* */
	private Long adjustId;
	/** 京东SKUID* */
	private Long skuId;
	/** 商品的名称+SKU规格* */
	private String skuName;
	/** 商家SKUID* */
	private String skuIdIsv;
	/** 京东内部商品ID(一个spu下有多个sku比如尺码或颜色不同，spu相同，sku不同)* */
	private Long skuSpuId;
	/** 京东到家销售价* */
	private Long skuJdPrice;
	/** 下单数量* */
	private Integer skuCount;
	/** 0:默认值非赠品;1:赠品* */
	private Boolean isGift;
	/** 调整方式(0:默认值，没调整，原订单明细;1:新增;2:删除;3:修改数量)* */
	private Integer adjustMode;
	/** 商品upc码* */
	private String upcCode;
	/** 技师id(此字段针对服务类业务)* */
	private Integer artificerId;
	/** 技师姓名(此字段针对服务类业务)* */
	private String artificerName;
	/** 门店价* */
	private Long skuStorePrice;
	/** 成本价* */
	private Long skuCostPrice;
	/** 商品级别促销类型(1、无优惠;2、秒杀;3、单品直降;4、限时抢购;1202、加价购;1203、满赠)* */
	private Integer promotionType;
	/** 税率* */
	private String skuTaxRate;
	/** 促销ID* */
	private Long promotionId;
	/** 餐盒费* */
	private Long canteenMoney;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getAdjustId() {
		return adjustId;
	}
	public void setAdjustId(Long adjustId) {
		this.adjustId = adjustId;
	}
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSkuIdIsv() {
		return skuIdIsv;
	}
	public void setSkuIdIsv(String skuIdIsv) {
		this.skuIdIsv = skuIdIsv;
	}
	public Long getSkuSpuId() {
		return skuSpuId;
	}
	public void setSkuSpuId(Long skuSpuId) {
		this.skuSpuId = skuSpuId;
	}
	public Long getSkuJdPrice() {
		return skuJdPrice;
	}
	public void setSkuJdPrice(Long skuJdPrice) {
		this.skuJdPrice = skuJdPrice;
	}
	public Integer getSkuCount() {
		return skuCount;
	}
	public void setSkuCount(Integer skuCount) {
		this.skuCount = skuCount;
	}
	public Boolean getIsGift() {
		return isGift;
	}
	public void setIsGift(Boolean isGift) {
		this.isGift = isGift;
	}
	public Integer getAdjustMode() {
		return adjustMode;
	}
	public void setAdjustMode(Integer adjustMode) {
		this.adjustMode = adjustMode;
	}
	public String getUpcCode() {
		return upcCode;
	}
	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}
	public Integer getArtificerId() {
		return artificerId;
	}
	public void setArtificerId(Integer artificerId) {
		this.artificerId = artificerId;
	}
	public String getArtificerName() {
		return artificerName;
	}
	public void setArtificerName(String artificerName) {
		this.artificerName = artificerName;
	}
	public Long getSkuStorePrice() {
		return skuStorePrice;
	}
	public void setSkuStorePrice(Long skuStorePrice) {
		this.skuStorePrice = skuStorePrice;
	}
	public Long getSkuCostPrice() {
		return skuCostPrice;
	}
	public void setSkuCostPrice(Long skuCostPrice) {
		this.skuCostPrice = skuCostPrice;
	}
	
	public Integer getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}
	public String getSkuTaxRate() {
		return skuTaxRate;
	}
	public void setSkuTaxRate(String skuTaxRate) {
		this.skuTaxRate = skuTaxRate;
	}
	public Long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
	public Long getCanteenMoney() {
		return canteenMoney;
	}
	public void setCanteenMoney(Long canteenMoney) {
		this.canteenMoney = canteenMoney;
	}
	
	
}
