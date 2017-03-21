package com.linjia.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.tools.DateComFunc;
import com.linjia.web.dao.CardCouponMapper;
import com.linjia.web.dao.UserCardCouponMapper;
import com.linjia.web.model.CardCoupon;
import com.linjia.web.model.SelectCustSendCardCoupon;
import com.linjia.web.model.UserCardCoupon;
import com.linjia.web.query.UserCardCouponQuery;
import com.linjia.web.service.UserCardCouponService;

@Service
@Transactional
public class UserCardCouponServiceImpl extends BaseServiceImpl<UserCardCoupon, Long> implements UserCardCouponService {

	@Resource
	private UserCardCouponMapper mapper;

	@Resource
	private CardCouponMapper cardCouponMapper;

	@Override
	public BaseDao<UserCardCoupon, Long> getDao() {
		return mapper;
	}

	@Override
	public List<UserCardCoupon> selectByPageList(UserCardCouponQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public List<SelectCustSendCardCoupon> selectCustSendCardCoupon(UserCardCouponQuery query) {
		return mapper.selectCustSendCardCoupon(query);
	}

	@Override
	public int insertBatch(SelectCustSendCardCoupon[] selectCustSendCardCouponArray, Long cardId) {
		CardCoupon cardCoupon = cardCouponMapper.selectByPrimaryKey(cardId);
		List<UserCardCoupon> list = new ArrayList<UserCardCoupon>();
		for (SelectCustSendCardCoupon item : selectCustSendCardCouponArray) {
			for (int i = 0; i < item.getWillSendNum(); i++) {
				UserCardCoupon uccItem = new UserCardCoupon();
				uccItem.setUserId(item.getUserId());
				uccItem.setUserCardno(item.getUserId());
				uccItem.setCardCouponId(cardId);

				Date currentTime = new Date();
				uccItem.setReceiveTime(currentTime);

				// 使用时间类型：1.静态区间 2.动态时间（天）
				if (cardCoupon.getTimeType() == 1) {
					uccItem.setUseStartTime(cardCoupon.getUseStartTime());
					uccItem.setUseEndTime(cardCoupon.getUseEndTime());
				} else if (cardCoupon.getTimeType() == 2) {
					uccItem.setUseStartTime(DateComFunc.addDay(currentTime, cardCoupon.getValidBeginDay()));
					uccItem.setUseEndTime(DateComFunc.addDay(currentTime, cardCoupon.getValidBeginDay() + cardCoupon.getValidDay()));
				}

				// 卡券类型：3.代金券 1.商品券 5.免运费券
				uccItem.setCardType(cardCoupon.getCardType());
				if (cardCoupon.getCardType() == Constants.CARD_COUPON_TYPE.DJQ) {
					uccItem.setCardCouponPrice(cardCoupon.getAmount());
				}
				uccItem.setSourceType(2);
				uccItem.setUseStatus(Constants.CARD_USED_STATUS.UNUSED);
				uccItem.setUpdateDate(new Date());
				list.add(uccItem);
			}
		}
		int row = mapper.insertBatch(list);
		if (row > 0) {
			
			//更新卡券数量
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cardId", cardId);
			param.put("minusNum", list.size());
			cardCouponMapper.updateTotalNumByCardId(param);
		}
		return row;
	}

	@Override
	public int updateUseStatusByPrimaryKey(UserCardCoupon model) {
		return mapper.updateUseStatusByPrimaryKey(model);
	}

	@Override
	public Integer countByExample(UserCardCouponQuery query) {
		return mapper.countByExample(query);
	}

}
