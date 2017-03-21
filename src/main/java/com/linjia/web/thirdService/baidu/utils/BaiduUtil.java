package com.linjia.web.thirdService.baidu.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.linjia.web.thirdService.baidu.constants.BaiduConfig;
import com.linjia.web.thirdService.baidu.model.Cmd;

public class BaiduUtil {
	
	/**
	 * 计算MD5
	 * @param input
	 * @return
	 */
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * 把中文转成Unicode码
	 * @param str
	 * @return
	 */
	public static String chinaToUnicode(String str){
		String result="";
		for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
                result+="\\u" + Integer.toHexString(chr1);
            }else{
            	result+=str.charAt(i);
            }
        }
		return result;
	}
	
	/**
	 * 签名计算的样例
	 * @param args
	 */
	public static JSONObject getReqJson(String orderCmd,Object body,Gson gson){
		//准备CMD签名计算数据
		Cmd cmd = new Cmd();
		cmd.setCmd(orderCmd);
		cmd.setSource(BaiduConfig.getSource());
		cmd.setSecret(BaiduConfig.getSecret());
		cmd.setTicket(UUID.randomUUID().toString().toUpperCase());
		cmd.setTimestamp((int)(System.currentTimeMillis() / 1000)+"");
		cmd.setVersion("2");
		cmd.setBody(body);
		cmd.setSign(null);
		
		String signJson = gson.toJson(cmd);
		//对所有/进行转义
		signJson = signJson.replace("/", "\\/");
		//中文字符转为unicode
		signJson = BaiduUtil.chinaToUnicode(signJson);
		System.out.println("md5前:"+signJson);
		String sign = BaiduUtil.getMD5(signJson);
		System.out.println("sign:"+sign);
		//准备生成请求数据，此处注意secret不参与传递，故设置为null
		cmd.setSign(sign);
		cmd.setSecret(null);
		String requestJson = gson.toJson(cmd);
		//对所有/进行转义
		requestJson = requestJson.replace("/", "\\/");
		//中文字符转为unicode
		requestJson = BaiduUtil.chinaToUnicode(requestJson);
		System.out.println("json前:"+requestJson);
		JSONObject json=new JSONObject(requestJson);
		System.out.println("json后:"+json);
		return json;
	}
	
	public static void main(String[] args) {
//		Shop shop=BaiduShopData.getShopTest01();
//		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer()).registerTypeAdapter(BusinessTime.class, new BusinessTimeSerializer())
//				.registerTypeAdapter(Delivery_region.class, new Delivery_regionSerializer()).registerTypeAdapter(Coord.class, new CoordSerializer())
//				.registerTypeAdapter(Shop.class, new ShopSerializer()).disableHtmlEscaping().create();
//		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("shopUpdate"),shop,gson);
		
//		PushReData prd=new PushReData();
//		prd.setSource_order_id("34");
//		PushReBody prb=new PushReBody(0,"success",prd);
//		Gson gson = new GsonBuilder().registerTypeAdapter(Cmd.class, new CmdSerializer())
//				.registerTypeAdapter(PushReBody.class, new PushReBodySerializer()).disableHtmlEscaping().create();
//		JSONObject respJson=BaiduUtil.getReqJson(BdURLFactory.genUrlCmd("orderCreate"),prb,gson);
	}
	
//	public static void main(String[] args) {
////		//准备body数据
////		Shop shop = new Shop();
////		shop.setBaidu_shop_id("10027821");
//////		shop.setName("测试商户<>http://abc.com/a.jpg");
////		getReqJson("shop.get",shop,Shop.class,new ShopSerializer());
////	
////		Order order = new Order();
////		order.setOrder_id("10005");
////		getReqJson("shop.get",order,Order.class,new OrderSerializer());
//		
//		//准备body数据
//		OrderData orderData = new OrderData();
//		Order order=new Order();
//		order.setOrder_id("10002");
//		order.setSend_immediately(1);
//		order.setSend_time("1");
//		order.setSend_fee(13);
//		order.setPackage_fee(12);
//		order.setDiscount_fee(11);
//		order.setTotal_fee(23);
//		order.setShop_fee(16);
//		order.setUser_fee(19);
//		order.setPay_type(1);
//		order.setPay_status(1);
//		order.setNeed_invoice(1);
//		order.setInvoice_title("个人");
//		order.setRemark("测试订单");
//		order.setDeliver_party(2);
//		order.setCreate_time(1470972231+"");
//		order.setCancel_time(1470978231+"");
//		
//		Coord coord=new Coord();
//		coord.setLatitude("74.000022");
//		coord.setLongitude("40.054065");
//		
//		User user=new User();
//		user.setId(007);
//		user.setName("向先生");
//		user.setPhone("13555554892");
//		user.setGender(1);
//		user.setAddress("地铁6号线五路居");
//		user.setCoord(coord);
//		
//		
//		Shop shop=new Shop();
//		shop.setId("007");
//		shop.setName("海鼎测试店铺2");
////		shop.setBaidu_shop_id("1656859523");
//		shop.setShop_id("hd00001");
//		
//		
//		List<Product> products=new ArrayList<Product>();
//		Product product=new Product();
//		product.setProduct_id("7305179757366483271");
//		product.setUpc("6920584471017");
//		product.setProduct_name("南瓜百合粥");
//		product.setProduct_price(700f);
//		product.setProduct_amount(1);
//		product.setProduct_fee(100f);
//		product.setPackage_price(50f);
//		product.setPackage_amount(2);
//		product.setPackage_fee(10f);
//		product.setTotal_fee(680f);
//		products.add(product);
//		List<Discount> discounts=new ArrayList<Discount>();
//		Discount discount=new Discount();
//		discount.setType("jian");
//		discount.setActicity_id("50105");
//		discount.setRule_id("103145");
//		discount.setFee(1500f);
//		discount.setBaidu_rate(1300f);
//		discount.setShop_rate(200f);
//		discount.setAgent_rate(0f);
//		discount.setLogistics_rate(0f);
//		discount.setDesc("立减优惠");
//		
//		discounts.add(discount);
//		orderData.setOrder(order);
//		orderData.setUser(user);
//		orderData.setShop(shop);
//		orderData.setProducts(products);
//		orderData.setDiscount(discounts);
//		getReqJson("order.create",orderData,OrderData.class,new OrderDataSerializer());
//	}
	
}
