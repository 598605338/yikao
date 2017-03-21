package com.linjia.tools;

public class UUID {
	
	public static String getUID(){
		String str=java.util.UUID.randomUUID().toString();
		str=str.replace("-", "");
		return str;
	}

}
