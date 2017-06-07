package com.linjia.web.test;

import java.lang.reflect.Field;
import java.util.Date;

import org.junit.Test;

import com.linjia.tools.DateComFunc;
import com.linjia.tools.RedisUtil;
import com.linjia.tools.UUID;


/** 
 * @author  lixinling: 
 * @date 2016年7月1日 下午3:28:35 
 * @version 1.0 
 */
public class TestP {
	
	
	@Test
	public void test() {
//		Date d = DateComFunc.getHourDate(new Date());
		
//		System.out.println(DateComFunc.formatDate(d, "yyyy-MM-dd HH:mm:ss.sss"));
//		System.out.println(DateComFunc.getSpecifyHourDate(new Date(), Constants.MIAOSHA_TIME.TWELVE));
//		System.out.println(DateComFunc.formatDate(DateComFunc.getSpecifyHourDate(new Date(), Constants.MIAOSHA_TIME.TWELVE), "yyyy-MM-dd HH:mm:ss.sss"));
		
		//倒计时时间
		/*long diff = 7690548;
		long hour = diff/(60*60*1000);
		long min = diff/(60*1000) - hour*60;
		long sec = diff/1000 - hour*60*60 - min*60;
		System.out.println(hour + ":"+min+":"+sec);*/
		
		
		/*BigDecimal totalPrice = new BigDecimal("1.00");
		BigDecimal salePrice = new BigDecimal("7.20");
		int buyQty = 3;
		totalPrice = totalPrice.add(salePrice.multiply(new BigDecimal(String.valueOf(buyQty))));
//		BigDecimal result = salePrice.multiply(new BigDecimal(String.valueOf(buyQty)));
//		totalPrice.add(result);
		System.out.println("totalPrice:"+totalPrice);*/
		
		/*1、转换符
		%s: 字符串类型，如："ljq"
		%b: 布尔类型，如：true
		%d: 整数类型(十进制)，如：99
		%f: 浮点类型，如：99.99
		%%: 百分比类型，如：％
		%n: 换行符
		 */
		/*String str=null;
	    str=String.format("Hi, %s", "林计钦"); // 格式化字符串
	    System.out.println(str); // 输出字符串变量str的内容
	    System.out.printf("3>7的结果是：%b %n", 3>7);
	    System.out.printf("100的一半是：%d %n", 100/2);
	    System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
	    System.out.printf("上面的折扣是%d%% %n", 85);*/
		
		/*String urlstr = "http://124.193.154.242:37080/h4rest-server/rest/h5rest-server/core/mdataservice/store/100007";
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/member/query_by_mobilenum?mobilenum=18510576310";
//		String urlstr = "http://yeeda-app-server.iyeeda.com/YidaAppServer_1_1/getMainPageList?usrid=13332&page=0&appv=235";
		String Authorization = "guest:guest";
		JSONObject obj = NetRequest.requestGet(urlstr, null, Authorization);
		System.out.println("result:"+obj.toString());*/
		
		//取得门店库存
//		String mallCode = "100007";
//		String pCode = "6944732100390";
//		int qty = Util.queryQtyByStore(mallCode, pCode);
//		System.out.println(mallCode+"门店库存数："+qty);
		
		//取得会员信息
//		String phone ="18510576310";
//		JSONObject result = Util.queryMemberByMobile(phone);
//		System.out.println("会员信息:"+result);
		
//		System.out.println(DateComFunc.formatDate(new Date(), "yyMMdd"));
		
		/*User u = new User(2, 25, "LXL", 1, "123", 111L,"13332");
		XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		xStreamForRequestPostData.alias("xml", User.class);
        String postDataXML = xStreamForRequestPostData.toXML(u);
        System.out.println(postDataXML);
        
        User u2 = (User)com.linjia.wxpay.common.Util.getObjectFromXML(postDataXML, User.class);
        System.out.println(u2.toString());
        */
		
		//根据自定义查询条件, 查询储值流水
//		JSONObject result = Util.queryDesaccounthst(null, null, "WEB151215000099", null);
//		System.out.println(result.toString());
		
		//将汉字转成unicode字符
		String s = "wojiuceshi其他未说明原因";
//		System.out.println("\u8ba2\u53551201608050000044763\u6263\u51cf");
//		String result = StringEscapeUtils.escapeJava(s);
//		System.out.println("result:" + result);
		
//		System.out.println(s.charAt(10)=='其');
		
	/*	System.out.println(s.toString() + System.currentTimeMillis());
		
		
		String signJson = "{\"body\":{\"shop\":{\"id\":\"2520\",\"name\":\"百度外卖（测试店）\"},\"order\":{\"order_id\":\"14347012309352\",\"send_immediately\":1,\"send_time\":\"1\",\"send_fee\":500,\"package_fee\":200,\"discount_fee\":0,\"total_fee\":3700,\"shop_fee\":3200,\"user_fee\":3700,\"pay_type\":1,\"pay_status\":1,\"need_invoice\":2,\"invoice_title\":\"\",\"remark\":\"请提供餐具\",\"delivery_party\":1,\"create_time\":\"1434701230\"},\"user\":{\"name\":\"测试订单请勿操作\",\"phone\":\"18912345678\",\"gender\":1,\"address\":\"北京海淀区奎科科技大厦 测试\",\"coord\":{\"longitude\":116.143145,\"latitude\":39.741426}},\"products\":[{\"product_id\":\"12277320\",\"product_name\":\"酱肉包（/份）\",\"product_price\":1200,\"product_amount\":1,\"product_fee\":1200,\"package_price\":100,\"package_amount\":1,\"package_fee\":100,\"total_fee\":1300,\"upc\":\"\"}],\"discount\":[]},\"cmd\":\"order.create\",\"sign\":\"E362B8AACE4F7A77047A885C0C0D230D\",\"source\":\"65400\",\"ticket\":\"909C3B92-8CDD-AF2C-C887-5B660233E2B2\",\"timestamp\":1434701234,\"version\":\"2.0\"}";
		
		//中文字符转为unicode
		String requestJson = BaiduUtil.chinaToUnicode(signJson);
		JSONObject body = new JSONObject(requestJson);
		JSONObject res = NetRequest.requestPost("http://api.waimai.baidu.com", body, null);
		System.out.println(res.toString());*/
		
//		int r = MessageUtil.randomCheckCode();
//		RedisUtil.put("name", "lxl");
//		System.out.println(RedisUtil.get("name"));
//		String publishData = "2015-08-15";
//		String timeSolt = "09:00";
//		Date startT = DateComFunc.strToDate(publishData+timeSolt, "yyyy-MM-ddHH:mm");
//		Date endT = DateComFunc.addHour(startT, 3);
//		System.out.println(endT);
//		System.out.println("TakeGoodsCode :"+RandUtils.getTakeGoodsCode());
		String value="10000.0";
		String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";  
		System.out.println(value.matches(regex));
	}
	
	@Test
	public void test2() {
		try {
			Class c = Class.forName("com.linjia.web.model.Brand");
			Field[] fields = c.getDeclaredFields();
			for(Field field:fields){
//				System.out.println(field.getType().getSimpleName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		String a ="10";
		String b="12c";
		tt(b,a);
		System.out.println("a="+a);
		System.out.println("b="+b);
	}

	public void tt(String a,String b){
		a = a+"sss";
		b = b+"a";
	}
}
