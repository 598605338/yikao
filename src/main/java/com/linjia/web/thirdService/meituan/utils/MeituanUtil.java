package com.linjia.web.thirdService.meituan.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MeituanUtil {
	
	/**
	 * url参数排序
	 * @param input
	 * @return
	 */
	public static String paramSort(Map<String,Object> map){
		String formatPath="";
		 ArrayList<String> list = new ArrayList<String>();
	        for(Map.Entry<String,Object> entry:map.entrySet()){
	            if(entry.getValue()!=""){
	                list.add(entry.getKey() + "=" + entry.getValue() + "&");
	            }
	        }
	        int size = list.size();
	        String [] arrayToSort = list.toArray(new String[size]);
	        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
	        formatPath=arrayToSort.toString();
	        
	        SortedMap<String, String> prePayParams = new TreeMap<String, String>();

		return formatPath;
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
	
	public static void main(String[] args) {
		SortedMap<String, Object> tmp = new TreeMap<String, Object>();
		tmp.put("d", "aa"); 
		tmp.put("b", "cc"); 
		tmp.put("c", "dd"); 
		tmp.put("a", "bb"); 
		Iterator<String> iterator_2 = tmp.keySet().iterator(); 
		while (iterator_2.hasNext()) { 
			Object key = iterator_2.next(); 
			System.out.println("key:" + key+"\tvalue:"+tmp.get(key)); 
		} 
	}
	
}
