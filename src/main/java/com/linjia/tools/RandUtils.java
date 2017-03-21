package com.linjia.tools;

import java.util.Random;

public class RandUtils {

	static char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	static char[] chr_num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	public static char get09az(){
		Random random = new Random(System.currentTimeMillis());
		int index=random.nextInt(chr.length);
		return chr[index];
	}
	
	/**
	 * 产生六位随机邀请码
	 * @return
	 */
	public static String getInvitionCode(){
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<6;i++){
			sb.append(chr[random.nextInt(chr.length)]);
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 产生五位随机数字提货码
	 * @return
	 */
	public static String getTakeGoodsCode(){
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<5;i++){
			sb.append(chr_num[random.nextInt(chr_num.length)]);
		}
		return sb.toString();
	}
	
	/**
	 * 产生digit位随机数
	 * @return
	 */
	public static String getRandomNum(int digit){
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<digit;i++){
			sb.append(chr_num[random.nextInt(chr_num.length)]);
		}
		return sb.toString();
	}
}
