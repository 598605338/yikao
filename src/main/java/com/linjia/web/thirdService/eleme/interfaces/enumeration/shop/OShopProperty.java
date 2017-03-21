package com.linjia.web.thirdService.eleme.interfaces.enumeration.shop;

/**
 * 店铺可更新属性
 */
public enum OShopProperty {

    /**
     * String 店铺地址|可选|"上海市长宁区龙溪路虹桥路1923号"
     */
    addressText("店铺地址"),

    /**
     * String 经纬度，longitude和latitude用英文逗号分隔|可选|"111.223,22.233"
     */
    geo("ongitude和latitude用英文逗号分隔"),

    /**
     * double 配送费|可选|3.0
     */
    agentFee("配送费"),

    /**
     * String 关店描述信息|可选|"业务繁忙"
     */
    closeDescription("关店描述信息"),

    /**
     * String 配送区域说明|可选|"超过5公里，100元起送"
     */
    deliverDescription("配送额外说明"),

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
    deliverGeoJson("配送范围，详情请咨询饿了么"),

    /**
     * String 店铺简介|可选|"便宜好吃的小食"
     */
    description("店铺简介"),

    /**
     * String 店铺名称|可选|"烤鸭大王"
     */
    name("店铺名称"),

    /**
     * int 是否接受预定|可选|1
     *
     * @desc 0 不接受预定，1 接受预定
     */
    isBookable("是否接受预定"),

    /**
     * String 店铺营业时间|可选|"10:00-13:00,18:00-21:00"
     *
     * @desc 多个时间用英文逗号分隔
     */
    openTime("店铺营业时间，多个时间用英文逗号分隔：10:00-13:00,18:00-21:00"),

    /**
     * String 店铺联系电话|可选|"18516307705,13482893679"
     *
     * @desc 多个用英文逗号分隔
     */
    phone("店铺联系电话"),

    /**
     * String 店铺公告信息|可选|"本周全场半价"
     */
    promotionInfo("店铺公告信息"),

    /**
     * String 店铺Logo的图片imageHash|可选|"3077080f760e7bf0fc985e23dd3e36e2"
     *
     * @desc 图片上传接口的返回值
     */
    logoImageHash("店铺Logo的图片image_hash（如何获得 /api/merchant/image ）"),

    /**
     * int 是否支持开发票|可选|1
     *
     * @desc 0 不支持，1 支持
     */
    invoice("是否支持开发票(0 代表不支持，1 代表支持)"),

    /**
     * double 支持的最小发票金额|可选|100.0
     */
    invoiceMinAmount("支持的最小发票金额"),

    /**
     * double 满xx元免配送费|可选|20.0
     */
    noAgentFeeTotal("满xx元免配送费"),

    /**
     * int 是否营业|可选|1
     *
     * @desc 1表示营业，0表示不营业
     */
    isOpen("是否营业：1表示营业，0表示不营业"),

    /**
     * double 订单打包费|可选|2.0
     *
     * @desc 对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。
     */
    packingFee("订单打包费，对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。"),

    /**
     * openId 餐厅的外部唯一标识||2132123213123
     */
    openId("餐厅的外部唯一标识");

    private String value;

    private OShopProperty(String value) {
        this.value = value;
    }
}
