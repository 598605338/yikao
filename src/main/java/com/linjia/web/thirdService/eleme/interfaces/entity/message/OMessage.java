package com.linjia.web.thirdService.eleme.interfaces.entity.message;

/**
 * 消息
 */
public class OMessage {
    /**
     * 请求Id||15110
     */
    private String requestId;

    /**
     * 消息类型||18
     */
    private int type;

    /**
     * 消息体||"{"address":"上海市普陀区金沙江路丹巴路119号","createdAt":"2016-12-06T15:08:41","activeAt":"2016-12-06T15:08:41","deliverFee":2.0,"deliverTime":"2016-12-06T16:48:34","description":"爱吃辣多点辣","groups":[{"name":"1号篮子","type":"NORMAL","items":[{"id":260,"name":"红烧肉","categoryId":1,"price":5.0,"quantity":2,"total":10.0,"discount":0.0,"displayQuantity":false,"additions":[]}]},{"name":"其它费用","type":"EXTRA","items":[{"id":-70000,"name":"餐盒费","categoryId":102,"price":2.0,"quantity":1,"total":2.0,"discount":0.0,"displayQuantity":false,"additions":[]}]}],"invoice":"上海市拉拉队有限公司","orderId":"100027475225737816","phoneList":["13456789012"],"shopId":968861,"shopName":"测试餐厅001","daySn":100,"status":null,"refundStatus":null,"userId":13524069,"totalPrice":5.0,"originalPrice":16.0,"consignee":"老好人 先生","deliveryGeo":"121.83317,31.514559","deliveryPoiAddress":"上海市普陀区金沙江路丹巴路119号","invoiced":true,"income":14.0,"serviceRate":0.0,"serviceFee":-0.0,"hongbao":-1.8,"packageFee":2.0,"activityTotal":-0.0,"shopPart":-0.0,"elemePart":-0.0,"downgraded":false,"onlinePaid":true,"book":true}"
     */
    private String message;

    /**
     * 店铺Id||969567
     */
    private int shopId;

    /**
     * 用户Id||3948322145
     */

    private long userId;

    /**
     * 时间戳||13321234123412345
     */
    private long timestamp;

    private String orderId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}