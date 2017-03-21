package com.linjia.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.web.dao.CardCouponMapper;
import com.linjia.web.dao.CardCouponThirdMapper;
import com.linjia.web.model.CardCoupon;
import com.linjia.web.model.CardCouponProduct;
import com.linjia.web.model.CardCouponThird;
import com.linjia.web.query.CardCouponQuery;
import com.linjia.web.query.CardCouponThirdQuery;
import com.linjia.web.service.CardCouponProductService;
import com.linjia.web.service.CardCouponService;

@Service
@Transactional
public class CardCouponServiceImpl extends BaseServiceImpl<CardCoupon, Long> implements CardCouponService {
	
	@Resource
	private CardCouponMapper mapper;
	
	@Resource
	private CardCouponThirdMapper cardCouponThirdMapper;

	@Autowired
	private CardCouponProductService cardCouponProductService;

	@Override
	public BaseDao<CardCoupon, Long> getDao() {
		return mapper;
	}

	@Override
	public List<CardCoupon> selectByPageList(CardCouponQuery query) {
		return mapper.selectByPageList(query);
	}

	@Override
	public List<CardCouponThird> selectThirdDetailByPageList(CardCouponThirdQuery query) {
		return cardCouponThirdMapper.selectPageListByCardCouponId(query);
	}
	
	@Override
	public List<CardCoupon> selectThirdByPageList(CardCouponQuery query) {
		return mapper.selectThirdByPageList(query);
	}

	@Override
	public boolean insertCardCouponThird(List<CardCouponThird> list, String creator) {
		boolean res = false;
		if(list != null && list.size() > 0){
			CardCouponThird cardCouponThird = list.get(0);
			
			//构造主表数据
			CardCoupon cardCoupon = new CardCoupon();
			cardCoupon.setCardName(cardCouponThird.getName());
			if(Constants.CARD_COUPON_TYPE.THIRD_LJQ == cardCouponThird.getType()){
				cardCoupon.setDescription(cardCouponThird.getContent());
			}else if(Constants.CARD_COUPON_TYPE.THIRD_QM == cardCouponThird.getType()){
				cardCoupon.setDescription("券码点击查看详情");
			}
			cardCoupon.setCreatetime(new Date());
			cardCoupon.setCreator(creator); 
			cardCoupon.setCardType(cardCouponThird.getType());
			cardCoupon.setStartTime(cardCouponThird.getValidStartTime());
			cardCoupon.setEndTime(cardCouponThird.getValidEndTime());
			cardCoupon.setUseStartTime(cardCouponThird.getValidStartTime());
			cardCoupon.setUseEndTime(cardCouponThird.getValidEndTime());
			cardCoupon.setTotalNum(list.size());
			cardCoupon.setUseflg(1);
			int row = mapper.insertSelective(cardCoupon);
			if(row > 0){
				//插入第三方合作券详细信息
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("list", list);
				param.put("cardCouponId", cardCoupon.getCardId());
				param.put("creDate", new Date());
				cardCouponThirdMapper.insertBatch(param);
				res = true;
			}
			
		}
		return res;
	}

	@Override
	public int countByExample(CardCouponQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public int countSelectThird(CardCouponQuery query) {
		return mapper.countSelectThird(query);
	}

	@Override
	public int insertCardCoupon(CardCoupon cardCoupon, String pName) {
		int i = mapper.insertSelective(cardCoupon);
		if(i == 1 && cardCoupon.getCardType() == Constants.CARD_COUPON_TYPE.SPQ){
			CardCouponProduct cardCouponProduct = new CardCouponProduct();
			cardCouponProduct.setCardCouponId(cardCoupon.getCardId());
			cardCouponProduct.setProductId(cardCoupon.getProductId());
			cardCouponProduct.setpCode(cardCoupon.getpCode());
			cardCouponProduct.setpName(pName);
			cardCouponProductService.insert(cardCouponProduct);
		}
		return i;
	}

	@Override
	public boolean updateCardCoupon(CardCoupon cardCoupon, Integer cardCouponProductId, String pName) {
		boolean r = mapper.updateByPrimaryKeySelective(cardCoupon);
		if(r && cardCoupon.getCardType() == Constants.CARD_COUPON_TYPE.SPQ){
			CardCouponProduct cardCouponProduct = new CardCouponProduct();
			cardCouponProduct.setCardCouponId(cardCoupon.getCardId());
			cardCouponProduct.setProductId(cardCoupon.getProductId());
			cardCouponProduct.setpCode(cardCoupon.getpCode());
			cardCouponProduct.setpName(pName);
			cardCouponProduct.setId(cardCouponProductId);
			cardCouponProductService.update(cardCouponProduct);
		}
		return r;
	}

	@Override
	public int countSurplusNum(Long cardId) {
		return mapper.countSurplusNum(cardId);
	}

	@Override
	public int updateTotalNumByCardId(Long cardId, Integer sendNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("cardId", cardId);
		param.put("minusNum", sendNum);
		return mapper.updateTotalNumByCardId(param);
	}

	
}
