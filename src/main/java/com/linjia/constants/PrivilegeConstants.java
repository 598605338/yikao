package com.linjia.constants;


/** 
 * 权限管理常量配置
 * @author  lixinling: 
 * @date 2016年11月17日 下午1:29:06 
 * @version 1.0 
*/
public class PrivilegeConstants {

	/**
	 * 用户角色
	 * 
	 * @author lxl
	 * 
	 */
	public interface ROLE{
		
		/** 超级管理员* */
		final static String ID_1 = "1";
	}
	
	/**
	 * 权限编码
	 * 
	 * @author lxl
	 * 
	 */
	public interface PRIVILEGE{
		
		/** 访问商品管理* */
		final static String ID_1 = "1";
		
		/** 访问活动管理* */
		final static String ID_2 = "2";
		
		/** 访问门店管理* */
		final static String ID_3 = "3";
		
		/** 访问卡券管理* */
		final static String ID_4 = "4";
		
		/** 访问订单管理* */
		final static String ID_5 = "5";
		
		/** 访问运营管理* */
		final static String ID_6 = "6";
		
		/** 访问财务管理* */
		final static String ID_7 = "7";
		
		/** 访问会员管理* */
		final static String ID_8 = "8";
	}
}
