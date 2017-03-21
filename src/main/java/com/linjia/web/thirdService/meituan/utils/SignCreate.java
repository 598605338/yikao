package com.linjia.web.thirdService.meituan.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.linjia.web.thirdService.meituan.constants.ReqUrl;

/**
 * 生成每天签名
 * @author xiangshouyi
 *
 */
public class SignCreate {

	public static String getUrlString(String url,Map<String, Object> params) {
		String urlString="";
		try {
			if (params != null) {
				Iterator<Map.Entry<String, Object>> iter = params.entrySet()
						.iterator();
				StringBuffer urlParamsBuffer = new StringBuffer();
				while (iter.hasNext()) {
					Map.Entry<String, Object> entry = iter.next();
					urlParamsBuffer.append(entry.getKey() + "="
							+ entry.getValue() + "&");
				}
				if (urlParamsBuffer.length() > 0) {
					urlParamsBuffer.deleteCharAt(urlParamsBuffer.length() - 1);
					urlString +=urlParamsBuffer.toString();
				}
			}
			urlString=url+"?"+urlString+ReqUrl.CONSUMERSECRET;
		}catch(Exception e){
			e.printStackTrace();
		}
		return urlString;
	}
	
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
	
	public static String getSign(String url,Map<String, Object> params) {
		String sign="";
		try{
			String urlString=getUrlString(url,params);
			if(!"".equals(urlString)){
				sign=getMD5(urlString);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sign;
	}
	
	public static String toMD5(String plainText) {
		String sign="";
	     try {
	        //生成实现指定摘要算法的 MessageDigest 对象。
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        //使用指定的字节数组更新摘要。
	        md.update(plainText.getBytes());
	        //通过执行诸如填充之类的最终操作完成哈希计算。
	        byte b[] = md.digest();
	        //生成具体的md5密码到buf数组
	        int i;
	        StringBuffer buf = new StringBuffer("");
	        for (int offset = 0; offset < b.length; offset++) {
	          i = b[offset];
	          if (i < 0)
	            i += 256;
	          if (i < 16)
	            buf.append("0");
	          buf.append(Integer.toHexString(i));
	        }
	        sign=buf.toString();// 32位的加密
//	        sign=buf.toString().substring(8, 24);// 16位的加密，其实就是32位加密后的截取
	     } 
	     catch (Exception e) {
	       e.printStackTrace();
	     }
	     return sign;
	   }
	
//	public static void main(String[] args) {
//		String url="http://waimaiopen.meituan.com/api/v1/poi/mget";
//		SortedMap<String, Object> param = new TreeMap<String, Object>();
//		param.put("app_id",1235123121);
//		param.put("app_poi_code",31); 
//		param.put("timestamp",1389751221);
//		String urlString=getUrlString(url,param);
//		System.out.println("MYurlString1:"+urlString);
//		System.out.println("MTurlString2:"+"http://waimaiopen.meituan.com/api/v1/poi/mget?app_id=1235123121&app_poi_code=31&timestamp=1389751221d31ba58fd73c71db697ab5e4946d52d");
//		String sign=getSign(url, param);
//		System.out.println("MYsign:"+sign);
////		String sign2=toMD5(urlString);
////		System.out.println("MYsign:"+sign2);
//		System.out.println("MTsign:"+"00934d00d0aea6f12161edfb6456143d");
//	}
}
