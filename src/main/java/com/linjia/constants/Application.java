package com.linjia.constants;

/** 
 * 系统常量类
 * 
 * @author  lixinling: 
 * @date 2016年7月1日 下午2:51:25 
 * @version 1.0 
 */
public class Application {

	/**
	 * 系统资源根路径
	 */
	public final static String BASE_PATH = "http://linjia.ebsig.com";
	
	/**
	 * 系统资源根路径
	 */
	public final static String SERVER_BASE_PATH = "http://www.linjia-cvs.cn";
	
	/**
	 * 系统资源根路径
	 */
	public final static String LOCAL_BASE_PATH = "http://hl-js-02.linjia-cvs.com:8089";
	
	/**
	 * RedisKeyPrefix:登陆用户信息
	 */
	public final static String USERINFO_PREFIX = "USERINFO_";
	
	/**
	 * RedisKeyExpire:过期时间
	 */
	public final static int USERINFO_EXPIRE = 30*24*60*60;
	
	/**
	 * 登陆用户密码加
	 */
	public final static String SALT = "";
	
	/**
	 * LBS AK
	 */
	public final static String AK = "";
	
	/**
	 * LBS geotable_id
	 */
	public final static String GEOTABLE_ID = "";
	
	/**
	 * LBS AK(测试)
	 */
//	public final static String AK = "";
	
	/**
	 * LBS geotable_id(测试)
	 */
//	public final static String GEOTABLE_ID = "";
	
	/**
	 * LBS添加url
	 */
	public final static String LBS_CREATEURL = "http://api.map.baidu.com/geodata/v3/poi/create";
	
	/**
	 * LBS修改url
	 */
	public final static String LBS_UPDATEURL = "http://api.map.baidu.com/geodata/v3/poi/update";
	
	/**
	 * LBS删除url
	 */
	public final static String LBS_DELETEURL = "http://api.map.baidu.com/geodata/v3/poi/delete";
	
	/**
	 * LBS查询url
	 */
	public final static String LBS_QUERYURL = "http://api.map.baidu.com/geodata/v3/poi/detai";
	
	/**
	 * LBS坐标类型
	 */
	public final static String LBS_COORD_TYPE="3";
	
	/**
	 * LBS起送金额
	 */
	public final static String SEND_LIMIT_MONEY="20";
	
	/**
	 * LBS门店企业状态码：启用
	 */
	public final static Integer LBS_MALL_WORK=1;
	
	/**
	 * LBS门店企业状态码：关闭
	 */
	public final static Integer LBS_MALL_STOP=0;
	
	/**
	 * LBS默认配送范围
	 */
	public final static String  LBS_SENDDISTANCE="3";

	//LBS请求编码
	public static String CHARSET="UTF-8";
	
	// 加密key
	private static final String LINJIA_KEY = "linjia";
	
	//饿了么邻家APPID
	public final static int ELEME_APPID = 0;
	
	public static String getljKey() {
		return LINJIA_KEY;
	}
	
}
