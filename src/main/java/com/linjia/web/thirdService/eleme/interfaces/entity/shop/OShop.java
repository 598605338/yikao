package com.linjia.web.thirdService.eleme.interfaces.entity.shop;

import java.util.List;

import com.linjia.web.thirdService.eleme.interfaces.enumeration.shop.OBusyLevel;
import com.linjia.web.thirdService.eleme.interfaces.enumeration.shop.OOrderMode;

/**
 * 店铺
 */
public class OShop {

    /**
     * 店铺Id||968514
     */
    private long id;

    /**
     * 店铺地址||"上海市长宁区龙溪路虹桥路1923号"
     */
    private String addressText;

    /**
     * 店铺默认配送费||3.0
     */
    private double agentFee;

    /**
     * 店铺营业状态||"busyLevel"
     */
    private OBusyLevel busyLevel;

    /**
     * 城市Id||511
     */
    private int cityId;

    /**
     * 城市区号||"200097"
     */
    private String cityCode;

    /**
     * 店铺关闭的原因||"业务繁忙"
     */
    private String closeDescription;

    /**
     * 起送价||20.0
     */
    private double deliverAmount;

    /**
     * 配送区域详情||"额外4元配送费"
     */
    private String deliverDescription;

    /**
     * 配送范围||{ "type": "FeatureCollection",  "features": [{"geometry": {"type": "Polygon", "coordinates": [[[121.381303, 31.243521], [121.380938, 31.242778], [121.380735, 31.242421], [121.380627, 31.242196], [121.380541, 31.24204], [121.38037, 31.241664], [121.380284, 31.241499], [121.38023, 31.241389], [121.380166, 31.241269], [121.380134, 31.241178], [121.379951, 31.24093], [121.379748, 31.24071], [121.379565, 31.240499], [121.379426, 31.24037], [121.379297, 31.240205], [121.379104, 31.239967], [121.378911, 31.239747], [121.378696, 31.239471], [121.377881, 31.238554], [121.377291, 31.237848], [121.376561, 31.237077], [121.37566, 31.236013], [121.375123, 31.235435], [121.374684, 31.234967], [121.374265, 31.234499], [121.374126, 31.23427], [121.374072, 31.234105], [121.374029, 31.233912], [121.3739, 31.233334], [121.373782, 31.232738], [121.373675, 31.232334], [121.3736, 31.231967], [121.373342, 31.230821], [121.374319, 31.23038], [121.375542, 31.22983], [121.377065, 31.229133], [121.377913, 31.228775], [121.378857, 31.228545], [121.37964, 31.228399], [121.381539, 31.228096], [121.382891, 31.227903], [121.38361, 31.229628], [121.384661, 31.231977], [121.385713, 31.23449], [121.386753, 31.236527], [121.386764, 31.236554], [121.387183, 31.237426], [121.387504, 31.238095], [121.388213, 31.239499], [121.388695, 31.24049], [121.387912, 31.240701], [121.386839, 31.240985], [121.385766, 31.241315], [121.385251, 31.241389], [121.383728, 31.24226], [121.381582, 31.243361], [121.381679, 31.243297], [121.381303, 31.243521]]]}, "type": "Feature","properties": {"area_agent_fee": 20,"delivery_price": 10, "manual_weight": 0,"system_weight": 0,"weight_type": 1}}]}
     *
     * @desc #### geoJson说明
     * geo_json的定义参考了 GEOJSON官网 http://geojson.org/ ，当前只支持Polygon一种type
     * 示例如下:
     * ###### 包含跟配送范围相关的属性：
     * 1. 配送范围
     * 2. 起送价
     * 3. 配送费
     * 4. 多时段设置
     * ```javascript
     * "properties": {
     * "delivery_price": 20,   //起送价 必选
     * "area_agent_fee": 3,    //配送费 必选
     * "manual_weight": 0,     //权重（无需更改） 必选
     * "system_weight": 0,     //系统权重（无需更改） 必选
     * "weight_type": 1,       //权重类型（无需更改） 必选
     * "multiPeriod":{		   //多时段 可选
     * "times":[["10:00:00", "23:59:59"]]
     * }
     * }
     * ```
     * #### Json串示例
     * ```javascript
     * { "type": "FeatureCollection",  "features": [{"geometry": {"type": "Polygon", "coordinates": [[[121.381303, 31.243521], [121.380938, 31.242778], [121.380735, 31.242421], [121.380627, 31.242196], [121.380541, 31.24204], [121.38037, 31.241664], [121.380284, 31.241499], [121.38023, 31.241389], [121.380166, 31.241269], [121.380134, 31.241178], [121.379951, 31.24093], [121.379748, 31.24071], [121.379565, 31.240499], [121.379426, 31.24037], [121.379297, 31.240205], [121.379104, 31.239967], [121.378911, 31.239747], [121.378696, 31.239471], [121.377881, 31.238554], [121.377291, 31.237848], [121.376561, 31.237077], [121.37566, 31.236013], [121.375123, 31.235435], [121.374684, 31.234967], [121.374265, 31.234499], [121.374126, 31.23427], [121.374072, 31.234105], [121.374029, 31.233912], [121.3739, 31.233334], [121.373782, 31.232738], [121.373675, 31.232334], [121.3736, 31.231967], [121.373342, 31.230821], [121.374319, 31.23038], [121.375542, 31.22983], [121.377065, 31.229133], [121.377913, 31.228775], [121.378857, 31.228545], [121.37964, 31.228399], [121.381539, 31.228096], [121.382891, 31.227903], [121.38361, 31.229628], [121.384661, 31.231977], [121.385713, 31.23449], [121.386753, 31.236527], [121.386764, 31.236554], [121.387183, 31.237426], [121.387504, 31.238095], [121.388213, 31.239499], [121.388695, 31.24049], [121.387912, 31.240701], [121.386839, 31.240985], [121.385766, 31.241315], [121.385251, 31.241389], [121.383728, 31.24226], [121.381582, 31.243361], [121.381679, 31.243297], [121.381303, 31.243521]]]}, "type": "Feature","properties": {"area_agent_fee": 20,"delivery_price": 10, "manual_weight": 0,"system_weight": 0,"weight_type": 1}}]}
     * ```
     * 可以看出geo_json是一个List，如果一家餐厅有多个多边形配送范围，那么就是多个多边形定义的List
     * 该示例配送范围在「上海普陀区真北路地铁站」附近
     */
    private String deliverGeoJson;

    /**
     * 2周内的平均送餐时间||10
     */
    private int deliverSpent;

    /**
     * 店铺描述||"便宜好吃的小食"
     */
    private String description;

    /**
     * 店铺口味||"辣"
     */
    private String flavors;

    /**
     * 店铺Logo地址||"http://pic.ele.me/321341.jpg"
     */
    private String imageUrl;

    /**
     * 是否支持开发票||1
     *
     * @desc 0 不支持开发票，1 支持开发票
     */
    private int invoice;

    /**
     * 支持的最小发票金额||100.0
     */
    private double invoiceMinAmount;

    /**
     * 是否支持预定(n=0表示不支持预定,7>n>=1表示支持n天内的预定）||1
     *
     * @desc 餐厅的状态可以参考 餐厅营业状态，当餐厅是营业状态的时候，有以下几种情况：
     * <p>
     * ##### 当前时间在营业时间内
     * - 餐厅is_bookable=1（可以预定），则用户下单时可以选择立即送（deliver_time不传），也可以定时送（预订单），但是定时的选项要从餐厅的deliver_times里选择一个
     * - 餐厅is_bookable=0（不可以预定），则用户只能选择立即送
     * <p>
     * ##### 当前时间不在营业时间内
     * - 餐厅is_bookable=1，则用户可以下预订单，预订单的选项从deliver_times里选择一个
     * - 餐厅is_bookable=0，则用户不可以下单，显示餐厅休息中
     */
    private int isBookable;

    /**
     * 营业时间bitmap||000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000
     *
     * @desc open_time_bitmap/book_time_bitmap（营业时间/预定时间）是一个字符串，在判断餐厅是否营业/可预订的时候，将当前的小时h以及当前的分钟m计算出index:
     * <p>
     * ```java
     * index = now.hour * 12 + now.minute / 5
     * ```
     * <p>
     * 然后在open_time_bitmap/book_time_bitmap这个string中取第index个字符，如果是1则餐厅营业/可预订，否则不营业/不可预订:
     * <p>
     * ```java
     * is_open = int(open_time_bitmap[now.hour * 12 + now.minute / 5])
     * ```
     */
    private String openTimeBitmap;

    /**
     * 预定时间bitmap||000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
     *
     * @desc open_time_bitmap/book_time_bitmap（营业时间/预定时间）是一个字符串，在判断餐厅是否营业/可预订的时候，将当前的小时h以及当前的分钟m计算出index:
     * <p>
     * ```java
     * index = now.hour * 12 + now.minute / 5
     * ```
     * <p>
     * 然后在open_time_bitmap/book_time_bitmap这个string中取第index个字符，如果是1则餐厅营业/可预订，否则不营业/不可预订:
     * <p>
     * ```java
     * is_open = int(open_time_bitmap[now.hour * 12 + now.minute / 5])
     * ```
     */
    private String bookTimeBitmap;

    /**
     * 预定时间选项||"["19:00:00","19:30:00"]"
     */
    private List<String> deliverTimes;

    /**
     * 是否正在营业||1
     *
     * @desc 0 未营业，1 正在营业
     */
    private int isOpen;


    /**
     * 是否隐藏电话号码||1
     *
     * @desc 0 不隐藏电话号码，1 隐藏电话号码
     */
    private int isPhoneHidden;


    /**
     * 是否品牌馆餐厅||1
     *
     * @desc 0 不是品牌餐厅，1 不是品牌餐厅
     */
    private int isPremium;

    /**
     * 是否支持超时赔付||1
     *
     * @desc 0 不支持，1 支持
     */
    private int isTimeEnsure;

    /**
     * 超时赔付详细信息||"超60分钟85折。雨天除外。"
     */
    private String timeEnsureFullDescription;

    /**
     * 店铺地址坐标-纬度||31.242582
     */
    private double latitude;

    /**
     * 店铺地址坐标-经度||121.56724
     */
    private double longitude;

    /**
     * 店铺接收饿了么短信的手机号码||"18516307707"
     */
    private String mobile;

    /**
     * 免配送费的最低消费额度||20.0
     */
    private double noAgentFeeTotal;

    /**
     * 店铺评价的列表||"[2,0,3,6,66]"
     *
     * @desc 依次为1-5星评价的数目
     */
    private List<Short> numRatings;

    /**
     * 订单模式||"busyLevelFree"
     */
    private OOrderMode orderMode;

    /**
     * 是否支持在线支付||1
     */
    private int onlinePayment;

    /**
     * 店铺的联系电话的列表||"["18516307705","13482893679"]"
     */
    private List<String> phones;

    /**
     * 店铺促销文案信息||"本店商品均为虚拟商品，只为方便大家体验订餐流程，订单不配送，请各位知悉。"
     */
    private String promotionInfo;

    /**
     * 最近一个月美食销量||27522
     */
    private int recentFoodPopularity;

    /**
     * 店铺名称||"实验餐厅20号"
     */
    private String name;

    /**
     * 店铺手机站url||"http://r.ele.me/b3bdj6t87h"
     */
    private String mobileUrl;

    /**
     * 营业时间的列表||"[["08:00:00-23:00:00"],["01:00:00-03:00:00"]]"
     */
    private List<String> servingTime;

    /**
     * 是否支持在线订餐||true
     */
    private boolean supportOnline;

    /**
     * 自配送餐厅合作类型||1
     */
    private int serviceCategory;

    /**
     * 订单打包费||3.0
     *
     * @desc 对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。
     */
    private double packingFee;

    /**
     * 餐厅外部的唯一标识||8389292348123
     */
    private String openId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public double getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(double agentFee) {
        this.agentFee = agentFee;
    }

    public OBusyLevel getBusyLevel() {
        return busyLevel;
    }

    public void setBusyLevel(OBusyLevel busyLevel) {
        this.busyLevel = busyLevel;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCloseDescription() {
        return closeDescription;
    }

    public void setCloseDescription(String closeDescription) {
        this.closeDescription = closeDescription;
    }

    public double getDeliverAmount() {
        return deliverAmount;
    }

    public void setDeliverAmount(double deliverAmount) {
        this.deliverAmount = deliverAmount;
    }

    public String getDeliverDescription() {
        return deliverDescription;
    }

    public void setDeliverDescription(String deliverDescription) {
        this.deliverDescription = deliverDescription;
    }

    public String getDeliverGeoJson() {
        return deliverGeoJson;
    }

    public void setDeliverGeoJson(String deliverGeoJson) {
        this.deliverGeoJson = deliverGeoJson;
    }

    public int getDeliverSpent() {
        return deliverSpent;
    }

    public void setDeliverSpent(int deliverSpent) {
        this.deliverSpent = deliverSpent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public double getInvoiceMinAmount() {
        return invoiceMinAmount;
    }

    public void setInvoiceMinAmount(double invoiceMinAmount) {
        this.invoiceMinAmount = invoiceMinAmount;
    }

    public int getIsBookable() {
        return isBookable;
    }

    public void setIsBookable(int isBookable) {
        this.isBookable = isBookable;
    }

    public String getOpenTimeBitmap() {
        return openTimeBitmap;
    }

    public void setOpenTimeBitmap(String openTimeBitmap) {
        this.openTimeBitmap = openTimeBitmap;
    }

    public String getBookTimeBitmap() {
        return bookTimeBitmap;
    }

    public void setBookTimeBitmap(String bookTimeBitmap) {
        this.bookTimeBitmap = bookTimeBitmap;
    }

    public List<String> getDeliverTimes() {
        return deliverTimes;
    }

    public void setDeliverTimes(List<String> deliverTimes) {
        this.deliverTimes = deliverTimes;
    }

    public int getIsPhoneHidden() {
        return isPhoneHidden;
    }

    public void setIsPhoneHidden(int isPhoneHidden) {
        this.isPhoneHidden = isPhoneHidden;
    }

    public int getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(int isPremium) {
        this.isPremium = isPremium;
    }

    public int getIsTimeEnsure() {
        return isTimeEnsure;
    }

    public void setIsTimeEnsure(int isTimeEnsure) {
        this.isTimeEnsure = isTimeEnsure;
    }

    public String getTimeEnsureFullDescription() {
        return timeEnsureFullDescription;
    }

    public void setTimeEnsureFullDescription(String timeEnsureFullDescription) {
        this.timeEnsureFullDescription = timeEnsureFullDescription;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getNoAgentFeeTotal() {
        return noAgentFeeTotal;
    }

    public void setNoAgentFeeTotal(double noAgentFeeTotal) {
        this.noAgentFeeTotal = noAgentFeeTotal;
    }

    public List<Short> getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(List<Short> numRatings) {
        this.numRatings = numRatings;
    }

    public int getOnlinePayment() {
        return onlinePayment;
    }

    public void setOnlinePayment(int onlinePayment) {
        this.onlinePayment = onlinePayment;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public int getRecentFoodPopularity() {
        return recentFoodPopularity;
    }

    public void setRecentFoodPopularity(int recentFoodPopularity) {
        this.recentFoodPopularity = recentFoodPopularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getServingTime() {
        return servingTime;
    }

    public void setServingTime(List<String> servingTime) {
        this.servingTime = servingTime;
    }

    public boolean isSupportOnline() {
        return supportOnline;
    }

    public void setSupportOnline(boolean supportOnline) {
        this.supportOnline = supportOnline;
    }

    public int getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(int serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public double getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(double packingFee) {
        this.packingFee = packingFee;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public OOrderMode getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(OOrderMode orderMode) {
        this.orderMode = orderMode;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
