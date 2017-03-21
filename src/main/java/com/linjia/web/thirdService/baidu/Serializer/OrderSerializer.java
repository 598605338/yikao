package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.Order;

public class OrderSerializer implements JsonSerializer<Order>{
	@Override
    public JsonElement serialize(Order order, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.add("cancel_time", context.serialize(order.getCancel_time()));
        object.add("create_time", context.serialize(order.getCreate_time()));
        object.add("delivery_party", context.serialize(order.getDelivery_party()));
        object.add("discount_fee", context.serialize(order.getDiscount_fee()));
        object.add("invoice_title", context.serialize(order.getInvoice_title()));
        object.add("need_invoice", context.serialize(order.getNeed_invoice()));
        object.add("order_id", context.serialize(order.getOrder_id()));
        object.add("package_fee", context.serialize(order.getPackage_fee()));
        object.add("pay_status", context.serialize(order.getPay_status()));
        object.add("pay_type", context.serialize(order.getPay_type()));
        object.add("remark", context.serialize(order.getRemark()));
        object.add("reason", context.serialize(order.getReason()));
        object.add("send_fee", context.serialize(order.getSend_fee()));
        object.add("send_immediately", context.serialize(order.getSend_immediately()));
        object.add("send_time", context.serialize(order.getSend_time()));
        object.add("shop_fee", context.serialize(order.getShop_fee()));
//        object.add("status", context.serialize(order.getStatus()));
    	object.add("total_fee", context.serialize(order.getTotal_fee()));
    	object.add("type", context.serialize(order.getType()));
    	object.add("user_fee", context.serialize(order.getUser_fee()));
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//		prePayParams.put("cancel_time", "");
//        prePayParams.put("create_time", "");
//        prePayParams.put("deliver_party", "");
//        prePayParams.put("discount_fee","");
//        prePayParams.put("invoice_title", "");
//        prePayParams.put("need_invoice","");
//        prePayParams.put("order_id","");
//        prePayParams.put("package_fee","");
//        prePayParams.put("pay_status","");
//        prePayParams.put("pay_type","");
//        prePayParams.put("remark","");
//        prePayParams.put("send_fee","");
//        prePayParams.put("send_immediately","");
//        prePayParams.put("send_time","");
//        prePayParams.put("shop_fee","");
////        prePayParams.put("status","");
//    	prePayParams.put("total_fee","");
//    	prePayParams.put("user_fee","");
//	    
//	        for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//		}
}
