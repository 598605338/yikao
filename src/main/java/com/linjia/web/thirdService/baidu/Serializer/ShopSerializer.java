package com.linjia.web.thirdService.baidu.Serializer;

import java.lang.reflect.Type;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.linjia.web.thirdService.baidu.model.BusinessTime;
import com.linjia.web.thirdService.baidu.model.Category;
import com.linjia.web.thirdService.baidu.model.Delivery_region;
import com.linjia.web.thirdService.baidu.model.Shop;

public class ShopSerializer implements JsonSerializer<Shop>{
	@Override
    public JsonElement serialize(Shop shop, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
//        object.add("baidu_shop_id", context.serialize(shop.getBaidu_shop_id()));
//        object.add("id", context.serialize(shop.getId()));
        object.add("address", context.serialize(shop.getAddress()));
        object.add("book_ahead_time", context.serialize(shop.getBook_ahead_time()));
        object.add("brand", context.serialize(shop.getBrand()));
        object.add("business_time", context.serialize(shop.getBusiness_time()));
        object.add("categorys", context.serialize(shop.getCategorys()));
        object.add("city", context.serialize(shop.getCity()));
        object.add("coord_type", context.serialize(shop.getCoord_type()));
        object.add("county", context.serialize(shop.getCounty()));
        object.add("delivery_region", context.serialize(shop.getDelivery_region()));
        object.add("invoice_support", context.serialize(shop.getInvoice_support()));
        object.add("latitude", context.serialize(shop.getLatitude()));
        object.add("longitude", context.serialize(shop.getLongitude()));
        object.add("min_order_price", context.serialize(shop.getMin_order_price()));
        object.add("name", context.serialize(shop.getMall_name()));
        object.add("package_box_price", context.serialize(shop.getPackage_box_price()));
        object.add("phone", context.serialize(shop.getPhone()));
        object.add("province", context.serialize(shop.getProvince()));
        object.add("service_phone", context.serialize(shop.getService_phone()));
        object.add("shop_id", context.serialize(shop.getMall_code()));
        object.add("shop_logo", context.serialize(shop.getShop_logo()));
        
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//        prePayParams.put("address", "address");
//        prePayParams.put("book_ahead_time", "");
//        prePayParams.put("brand", "");
//        prePayParams.put("business_time","");
//        prePayParams.put("categorys","");
//        prePayParams.put("city", "");
//        prePayParams.put("coord_type", "");
//        prePayParams.put("county", "");
//        prePayParams.put("delivery_region", "");
//        prePayParams.put("invoice_support", "");
//        prePayParams.put("latitude", "");
//        prePayParams.put("longitude","");
//        prePayParams.put("min_order_price","");
//        prePayParams.put("name", "");
//        prePayParams.put("package_box_price","");
//        prePayParams.put("phone","");
//        prePayParams.put("province", "");
//        prePayParams.put("service_phone","");
//        prePayParams.put("shop_id","");
//        prePayParams.put("shop_logo","");
//	   for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//		}
}
