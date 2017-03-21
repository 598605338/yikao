package com.linjia.web.thirdService.eleme.interfaces.entity.message;

public class CallBackMessage {

	//Number	应用id，应用创建时系统分配的唯一id
	private Integer appId;	
	
	//String	消息的唯一id，用于唯一标记每个消息
	private String requestId;
	
	//Number	消息类型,参加下方【消息类型】
	private Integer type;	
	
	//String JSON格式的字符串，每种消息包含的消息体内容不一样，具体以消息定义的消息体为准
	private String message;		
	
	//Number	商户的店铺id
	private Integer shopId;	
	
	//Number	消息发送的时间戳，每次回调时生成，单位毫秒
	private Long timestamp;	
	
	//Number	授权商户的账号id，注意这里的userId跟订单结构体中的userId(下单用户的id)不一样
	private Long userId;
	
	//String	消息签名，32位全大写
	private String signature;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}	
	
	
}
