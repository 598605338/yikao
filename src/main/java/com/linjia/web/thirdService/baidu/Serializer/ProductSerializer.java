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
import com.linjia.web.thirdService.baidu.model.Product;

public class ProductSerializer implements JsonSerializer<Product>{
	@Override
    public JsonElement serialize(Product product, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.add("package_amount", context.serialize(product.getPackage_amount()));
        object.add("package_fee", context.serialize(product.getPackage_fee()));
        object.add("package_price", context.serialize(product.getPackage_price()));
        object.add("product_amount", context.serialize(product.getProduct_amount()));
        object.add("product_fee", context.serialize(product.getProduct_fee()));
        object.add("product_id", context.serialize(product.getProduct_id()));
    	object.add("product_name", context.serialize(product.getProduct_name()));
    	object.add("product_price", context.serialize(product.getProduct_price()));
    	object.add("total_fee", context.serialize(product.getTotal_fee()));
    	object.add("upc", context.serialize(product.getUpc()));
        return object;
    }
	
//	public static void main(String[] args) {
//		SortedMap<String, String> prePayParams = new TreeMap<String, String>();
//		prePayParams.put("package_amount",  "");
//        prePayParams.put("package_fee",  "");
//        prePayParams.put("package_price",  "");
//        prePayParams.put("product_amount", "");
//        prePayParams.put("product_fee", "");
//        prePayParams.put("product_id", "");
//    	prePayParams.put("product_name", "");
//    	prePayParams.put("product_price", "");
//    	prePayParams.put("total_fee", "");
//    	prePayParams.put("upc", "");
//	   for(Entry<String, String> p : prePayParams.entrySet()){
//	           System.out.println(p.getKey());
//	        }
//		}
}
