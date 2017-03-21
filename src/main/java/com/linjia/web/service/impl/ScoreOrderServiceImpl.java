package com.linjia.web.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Util;
import com.linjia.web.dao.CardCouponMapper;
import com.linjia.web.dao.ScoreChangeMapper;
import com.linjia.web.dao.ScoreOrderMapper;
import com.linjia.web.dao.UserCardCouponMapper;
import com.linjia.web.model.CardCoupon;
import com.linjia.web.model.ScoreChange;
import com.linjia.web.model.ScoreOrder;
import com.linjia.web.model.ScoreProduct;
import com.linjia.web.model.UserCardCoupon;
import com.linjia.web.query.ScoreProductQuery;
import com.linjia.web.service.OrderPayService;
import com.linjia.web.service.ScoreOrderService;

@Service
@Transactional
public class ScoreOrderServiceImpl extends BaseServiceImpl<ScoreOrder, Long> implements ScoreOrderService {

	@Resource
	private ScoreOrderMapper mapper;

	@Resource
	private ScoreChangeMapper scoreChangeMapper;
	
	@Resource
	private UserCardCouponMapper userCardCouponMapper;
	
	@Resource
	private CardCouponMapper cardCouponMapper;

	@Override
	public BaseDao<ScoreOrder, Long> getDao() {
		return mapper;
	}

	@Autowired
	private OrderPayService orderPayService;

	/**
	 * 积分兑换订单生成(纯积分兑换的情况下)
	 * 
	 * lixinling 
	 * 2016年8月10日 上午10:18:57
	 * @param query
	 * @param userId
	 * @return
	 */
	@Override
	public boolean insertScoreOrder(ScoreProduct scoreProduct, String userId, String loginCode, int cardCouponId) {
		boolean flag = false;
		ScoreOrder model = new ScoreOrder();
//		model.setScoreProductId(scoreProduct.getId());
		model.setName(scoreProduct.getName());
		model.setQuantity(1);
		model.setType(scoreProduct.getType());
		model.setOrderStatus(Constants.SCORE_STATUS.UNPAY);
		model.setPayType(Constants.PAY_TYPE.ONLYSCORE);
		model.setPrice(scoreProduct.getPrice());
		model.setScore(scoreProduct.getScore());
//		model.setComment(scoreProduct.getHiddenInfo());
		model.setUserId(userId);

		Date startTime = new Date();
		model.setStartTime(startTime);
		model.setEndTime(DateComFunc.addMinute(startTime, 45));
		model.setCreDate(startTime);

		synchronized (userId) {
			// 防止同一用户多点登陆同时操作
			// 查询用户现在的积分
			JSONObject resObj = Util.queryDesaccount(userId);
			if (resObj.optInt("score") >= model.getScore()) {
				// 生成积分兑换订单
				int row = mapper.insertSelective(model);
				if (row == 1) {
					if (model.getPrice() != null && model.getPrice().doubleValue() == 0 && model.getScore() > 0) {
						// 纯积分兑换的情况下直接兑换
						decScoreByExchange(model.getScore(), Constants.SCORE_WAY.CASH_PRIZE, userId, loginCode, cardCouponId);
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 通过兑换扣减积分
	 * lixinling 
	 * 2016年8月10日 下午2:57:11
	 * @param score
	 * @param type
	 * @param userId
	 * @param loginCode
	 * @return
	 */
	public boolean decScoreByExchange(int score, int type, String userId, String loginCode, int cardCouponId) {
		// 积分记录表写入数据
		ScoreChange scoreChange = new ScoreChange();
		scoreChange.setUserId(userId);
		scoreChange.setScore(-score);
		scoreChange.setType(type);
		scoreChange.setCreDate(new Date());
		scoreChange.setDeleted(false);
		scoreChangeMapper.insertSelective(scoreChange);

		JSONObject result = Util.decScoreAccount(scoreChange.getId(), loginCode, "积分商城兑换", scoreChange.getType(), scoreChange.getScore());
		if (result.optJSONArray("subjectAccounts") != null) {
			CardCoupon cardCoupon = cardCouponMapper.selectByPrimaryKey(Long.valueOf(cardCouponId));
			if(cardCoupon != null){
			// 将兑换的商品券放入用户我的优惠券中
			UserCardCoupon userCardCoupon = new UserCardCoupon();
			userCardCoupon.setUserId(userId);
			userCardCoupon.setCardCouponId(Long.valueOf(cardCouponId));
			userCardCoupon.setReceiveTime(new Date());
			userCardCoupon.setUseStartTime(cardCoupon.getUseStartTime());
			userCardCoupon.setUseEndTime(cardCoupon.getUseEndTime());
			userCardCoupon.setUseStatus(Constants.CARD_USED_STATUS.UNUSED);
			userCardCoupon.setUpdateDate(new Date());
			userCardCoupon.setDeleted(false);
			int row = userCardCouponMapper.insertSelective(userCardCoupon);
			if(row == 1)
				return true;
			}
		}

		return false;
	}

	/**
	 * 积分兑换订单生成(积分+金钱兑换的情况下)
	 * 
	 * lixinling 
	 * 2016年8月10日 上午10:18:57
	 * @param query
	 * @param userId
	 * @return
	 */
	@Override
	public boolean insertPayScoreOrder(ScoreProduct scoreProduct, ScoreOrder model, String userId, String loginCode, String spbill_create_ip) {
		boolean flag = false;
//		model.setScoreProductId(scoreProduct.getId());
		model.setName(scoreProduct.getName());
		model.setQuantity(1);
		model.setType(scoreProduct.getType());
		model.setOrderStatus(Constants.SCORE_STATUS.UNPAY);
		model.setPrice(scoreProduct.getPrice());
		model.setScore(scoreProduct.getScore());
//		model.setComment(scoreProduct.getHiddenInfo());
		model.setUserId(userId);

		Date startTime = new Date();
		model.setStartTime(startTime);
		model.setEndTime(DateComFunc.addMinute(startTime, 45));
		model.setCreDate(startTime);

		// 查询用户现在的积分
		JSONObject resObj = Util.queryDesaccount(userId);
		if (resObj.optInt("score") >= model.getScore()) {
			// 生成积分兑换订单
			int row = mapper.insertSelective(model);
			if (row == 1 && model.getPrice() != null && model.getPrice().doubleValue() > 0) {
				// 积分+金钱兑换的情况下先进行金钱支付,再进行积分支付
				String body = model.getName();
				JSONObject attObj = new JSONObject();
				attObj.put("score", model.getScore());
				attObj.put("userId", userId);
				attObj.put("loginCode", loginCode);
				attObj.put("cardCouponId", scoreProduct.getCardCouponId());
				// 进行支付
				Map<String, Object> resMap = orderPayService.payHandle(model.getPayType(), body, attObj.toString(), model.getPrice(),
						model.getId(), spbill_create_ip);
				if ("ok".equals(resMap.get("status"))) {
					flag = true;
				}
			}
		}
		return flag;
	}

	/**
	 * 金钱支付完成后进行积分支付并更改订单状态
	 * 
	 * lixinling 
	 * 2016年8月10日 上午10:18:57
	 * @param query
	 * @param userId
	 * @return
	 */
	@Override
	public boolean updatePayScoreOrderStatus(Long outTradeNo, int score, String userId, String loginCode, int cardCouponId) {
		boolean flag = false;
		logger.info("金钱支付成功，开始执行积分扣减工作！");
		// 扣减积分
		boolean res = decScoreByExchange(score, Constants.SCORE_WAY.CASH_PRIZE, userId, loginCode, cardCouponId);
		if (res) {
			// 更新积分支付订单状态
			flag = this.updateStatusById(outTradeNo, Constants.SCORE_STATUS.SUCCESS);
			logger.info("更新积分支付订单状态完成！");
		}
		return flag;
	}

	/**
	 * 更新积分订单状态
	 * lixinling 
	 * 2016年8月11日 下午1:21:56
	 * @param id
	 * @param orderStatus
	 * @return
	 */
	@Override
	public boolean updateStatusById(Long id, int orderStatus) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("orderStatus", orderStatus);
		return mapper.updateStatusById(params);
	}
}
