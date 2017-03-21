package com.linjia.constants;

import java.math.BigDecimal;


/** 
 * 常量类
 * 
 * @author  lixinling: 
 * @date 2016年7月1日 下午2:51:25 
 * @version 1.0 
 */
public class Constants {
	
	/**
	 * 系统资源根路径
	 */
	public final static BigDecimal LIMIT_SEND_AMOUNT = new BigDecimal("9.9");

	/**
	 * 状态(0失败，1成功)
	 * 
	 * @author lxl
	 * 
	 */
	public interface STATUS{
		/** 失败*/
		final static int FAIL = 0;
		/** 成功*/
		final static int SUCCESS = 1;
	}
	
	/**
	 * 商品类型
	 * 
	 * @author lxl
	 * 
	 */
	public interface PRO_TYPE{
		/** 现实商品*/
		final static int XSSP = 0;
		/** 虚拟商品*/
		final static int XJZF = 1;
	}
	
	/**
	 * 秒杀时间点
	 * 
	 * @author lxl
	 * 
	 */
	public interface MIAOSHA_TIME{
		/** 9点*/
		final static int NINE = 9;
		/** 12点*/
		final static int TWELVE = 12;
		/** 15点*/
		final static int FIFTEEN = 15;
		/** 18点*/
		final static int EIGHTEEN = 18;
	}
	
	/**
	 * 秒杀抢购状态:抢购中；即将开始；已结束
	 * 
	 * @author lxl
	 * 
	 */
	public interface MIAOSHA_PANIC_STATUS{
		/** 即将开始*/
		final static String UNSTART = "即将开始";
		/** 抢购中*/
		final static String PANICING = "抢购中";
		/** 15点*/
		final static String ENDED = "已结束";
	}
	
	/**
	 * 显示信息1:即将开始；抢购已开始；抢购结束，敬请期待；
	 * 
	 * @author lxl
	 * 
	 */
	public interface MIAOSHA_SHOW_LABEL1{
		/** 即将开始*/
		final static String UNSTART = "即将开始";
		/** 抢购已开始 */
		final static String PANICING = "抢购已开始";
		/** 抢购结束，敬请期待 */
		final static String ENDED = "抢购结束，敬请期待";
	}
	
	/**
	 * 显示信息2:距离开始；距离结束；
	 * 
	 * @author lxl
	 * 
	 */
	public interface MIAOSHA_SHOW_LABEL2{
		/** 距离开始 */
		final static String UNSTART = "距离开始";
		/** 距离结束 */
		final static String PANICING = "距离结束";
	}
	
	/**
	 * 配送方式
	 * 
	 * @author lxl
	 * 
	 */
	public interface SEND_TYPE{
		/** 送货上门 */
		final static int SHSM = 0;
		/** 上门自提 */
		final static int SMZT = 1;
	}
	
	/**
	 * 是否符合订单满减
	 * 
	 * @author lxl
	 * 
	 */
	public interface FULL_SUBTRACT{
		/** 否 */
		final static boolean NO = false;
		/** 是 */
		final static boolean YES = true;
	}
	
	/**
	 * 库存状态(0:正常；1：库存不足)
	 * 
	 * @author lxl
	 * 
	 */
	public interface QTY_STATUS{
		/** 0:正常 */
		final static int NORMAL = 0;
		/** 1：库存不足 */
		final static int LOW = 1;
	}
	
	/**
	 * 支付类型(0:微信支付；1：钱包支付;2：纯积分支付)
	 * 
	 * @author lxl
	 * 
	 */
	public interface PAY_TYPE{
		/** 0:微信支付 */
		final static int WX = 0;
		/** 1：钱包支付 */
		final static int PURSE = 1;
		/** 2：纯积分支付 */
		final static int ONLYSCORE = 2;
	}
	
	/**
	 * 支付状态(0未支付；1已支付)
	 * 
	 * @author lxl
	 * 
	 */
	public interface PAY_STATUS{
		/** 0:未付款 */
		final static int UNPAY = 0;
		/** 1：已付款 */
		final static int PAYD = 1;
	}
	
	/**
	 * 订单总状态(0未付款；1已付款；2商家已确认；3商家已取消；4派送中；5已完成；6客户取消订单)
	 * 
	 * @author lxl
	 * 
	 */
	public interface ORDER_GROUP_STATUS{
		/** 0:未付款 */
		final static int UNPAY = 0;
		/** 1：已付款 */
		final static int PAYD = 1;
		/** 2：商家已确认 */
		final static int CONFIRM = 2;
		/** 3：商家已取消*/
		final static int BUSSINESS_CANCELE = 3;
		/** 4：派送中 */
		final static int SENDING = 4;
		/** 5：已完成 */
		final static int SUCCESS = 5;
		/** 6：客户取消订单 */
		final static int CUSTOMER_CANCELE = 6;
	}
	
	/**
	 * 在线支付退款状态(0、无退款 1、等待退款 2、正在退款 3、已退款 4、退款失败 5、未确定 6、转入代发)
	 * 
	 * @author lxl
	 * 
	 */
	public interface ORDER_REFUND_STATUS{
		/** 0:无退款  */
		final static int NO_REFUND = 0;
		/** 1：等待退款 */
		final static int WAIT_REFUND = 1;
		/** 2：正在退款 */
		final static int REFUNDDING = 2;
		/** 3：已退款 */
		final static int REFUNDED = 3;
		/** 4：退款失败 */
		final static int FAIL_REFUND = 4;
		/** 5：未确定 */
		final static int UNCONFIRM = 5;
		/** 6：转入代发 */
		final static int ZRDF = 6;
	}
	
	/**
	 * 手机号注册会员状态（0:注册失败；1注册成功）
	 * 
	 * @author lxl
	 * 
	 */
	public interface REGIST_PHONE_STATUS{
		/** 注册失败*/
		final static int FAIL = 0;
		/** 注册成功*/
		final static int SUCCESS = 1;
	}
	
	/**
	 * 积分的获取和使用途径
	 * 消费("101"), 储值("102"), 加速("103"), 调整("104"), 转出("105"), 转入("106"), 兑奖("107"), 抵扣("108"), 抽奖("109"), 
	 * 登录("201"), 评价("202"), 清除("203"), 开卡("204"), 注册("205"), 便民("206"), 储值转积分("207"), 赠送("208"), 积分转储值("209");
	 * @author lxl
	 * 
	 */
	public interface SCORE_WAY{
		/** 消费*/
		final static int SPENDING = 101;
		/** 储值*/
		final static int STOREVALUE = 102;
		/** 加速*/
		final static int SPEED_UP = 103;
		/** 调整*/
		final static int ADJUST = 104;
		/** 转出*/
		final static int TURN_OUT = 105;
		/** 转入*/
		final static int TURN_IN = 106;
		/** 兑奖*/
		final static int CASH_PRIZE = 107;
		/** 抵扣*/
		final static int DEDUCT = 108;
		/** 抽奖*/
		final static int RAFFLE = 109;
		/** 登录*/
		final static int LOGIN = 201;
		/** 评价*/
		final static int RATED = 202;
		/** 清除*/
		final static int CLEAR = 203;
		/** 开卡*/
		final static int OPEN_CARD = 204;
		/** 注册*/
		final static int REGISTE = 205;
		/** 便民*/
		final static int CONVENIENCE = 206;
		/** 储值转积分*/
		final static int STORECONVERSCORE = 207;
		/** 赠送*/
		final static int GIFTS = 208;
		/** 积分转储值*/
		final static int SCOREVONVERSTORE = 209;
	}
	/**
	 * 团购状态描述
	 * 
	 * @author xiangsy
	 * 
	 */
	public interface PINTUAN_SHOW_LABEL{
		//组团中
		final static String PINTUANING = "组团中";
		//已成团
		final static String  PINTUANOVER= "已成团";
		//组团失败
		final static String PINTUANFALI = "组团失败";

		
	}
	
	/**
	 * 团购状态描述
	 * 
	 * @author xiangsy
	 * 
	 */
	public interface PINTUAN_SHOW_VAL{
		//组团中
		final static int PINTUANINGVAL = 0;
		//已成团
		final static int  PINTUANOVERVAL= 1;
		//组团失败
		final static int PINTUANFALIVAL = 2;
		
	}
	
	/**
	 * 团购有效时间
	 * 
	 * @author xiangsy
	 * 
	 */
	public interface PINTUAN_TIME_LIMIT{
		//拼团有效时间(小时)
		final static int TIMELIMITNUM = 10;
		
	}
	
	/**
	 * 返回结果状态字符窜
	 * 
	 * @author xiangsy
	 * 
	 */
	public interface RESULT_TEXT{
		final static String OK = "ok";
		final static String FAIL = "fail";
	}
	
	
	/**
	 * 积分订单状态(0未支付；1已完成)
	 * 
	 * @author lxl
	 * 
	 */
	public interface SCORE_STATUS{
		/** 未支付*/
		final static int UNPAY = 0;
		/** 已完成*/
		final static int SUCCESS = 1;
	}
	
	/**
	 * 卡券使用状态:0未使用；1已使用
	 * 
	 * @author lxl
	 * 
	 */
	public interface CARD_USED_STATUS{
		/** 0未使用*/
		final static int UNUSED = 0;
		/** 1已使用*/
		final static int USED = 1;
		/** 2客服已核销(废弃)*/
		final static int KEFU_VERIFICATIONED = 2;
	}
	
	/**
	 * 商品发货类型：0及时送；1预约配送
	 * 
	 * @author lxl
	 * 
	 */
	public interface PRODUCT_SEND_TYPE{
		/** 0及时送*/
		final static int IMMEDIATE = 0;
		/** 1次日达*/
		final static int PREPARE = 1;
	}
	
	/**
	 * 订单配送方式：0立即配送；1预约配送；2立即配送+预约配送
	 * 
	 * @author lxl
	 * 
	 */
	public interface ORDER_SEND_TYPE{
		/** 0立即配送*/
		final static int IMMEDIATE_SEND = 0;
		/** 1预约配送*/
		final static int PREPARE_SEND = 1;
		/** 2立即配送+预约配送*/
		final static int DOUBLE = 2;
	}
	
	/**
	 * 订单生成 返回 CODE
	 * 
	 * @author lxl
	 * 
	 */
	public interface ORDER_RETURN_CODE{
		/** 10000 全部补货中*/
		final static int PRODUCT_ALL_LOW_STOCK = 10000;
		/** 10001 部分库存不足*/
		final static int PRODUCT_LOW_STOCK = 10001;
		/** 10002订单金额小于起送金额*/
		final static int LOW_LIMIT_AMOUNT = 10002;
	}
	

	/**
	 * 退款方式: 1、人工退款 2、自动退款
	 * 
	 * @author lxl
	 * 
	 */
	public interface REFUND_TYPE{
		/** 1、人工退款*/
		final static int ARTIFICIAL = 1;
		/** 2、自动退款*/
		final static int AUTO = 2;
	}
	
	/**
	 * 退款来源:0取消订单；1手工退款
	 * 
	 * @author lxl
	 * 
	 */
	public interface REFUND_SOURCE{
		/** 0取消订单*/
		final static int CANCEL = 0;
		/** 1手工退款*/
		final static int ARTIFICIAL = 1;
	}
	
	/**
	 * 审核状态：1.未审核 2.已审核 3.取消
	 * 
	 * @author lxl
	 * 
	 */
	public interface REFUND_STATUS{
		/** 1.未审核*/
		final static int UNREVIEW = 1;
		/** 2.已审核*/
		final static int REVIEWED = 2;
		/** 3.取消*/
		final static int CANCEL = 3;
	}
	
	/**
	 * 是否上架：0未上架；1已上架
	 * 
	 * @author lxl
	 * 
	 */
	public interface AVAILABLE{
		/** 0未上架*/
		final static int UNAVAILABLE = 0;
		/** 1已上架*/
		final static int AVAILABLED = 1;
	}
	
	/**
	 * 库存类型：0仓库库存；1门店库存
	 * 
	 * @author lxl
	 * 
	 */
	public interface STOCK_TYPE{
		/** 0仓库库存*/
		final static int CANGKU = 0;
		/** 1门店库存*/
		final static int MENDIAN = 1;
	}
	
	public interface PAGE{
		/** 每页条数*/
		final static int SIZE = 5;
	}
	
	/**
	 * 自定义页面存放路径
	 * @author xiangshouyi
	 *
	 */
	public interface CUST_PAGE_URL{
		/** 每页条数*/
		final static String PAGE_DIR ="/custom/customPages/html/";
		final static String FILE_TYPE =".html";
	}
	

	/**
	 * 卡券类型：3.代金券 1.商品券 5.免运费券
	 * 
	 * @author lxl
	 * 
	 */
	public interface CARD_COUPON_TYPE{
		/** 3.代金券*/
		final static int DJQ = 3;
		/** 1.商品券*/
		final static int SPQ = 1;
		/** 5.免运费券*/
		final static int MYFQ = 5;
		/** 6.链接券 */
		final static int THIRD_LJQ = 6;
		/** 7.券码*/
		final static int THIRD_QM = 7;
	}
	
	/**
	 * 门店编码基数数字(生成账户密码使用)
	 * @author xiangshouyi
	 *
	 */
	public interface SHOP_USE{
		final static int MALLCODEBEGIN =100000;
		final static String ACCOUNTBEGIN ="linjia";
	}
}
