package com.linjia.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.ReceiveCardCoupon;
import com.linjia.web.query.ReceiveCardCouponQuery;
import com.linjia.web.service.CardCouponService;
import com.linjia.web.service.ReceiveCardCouponService;

/**
 * 领券中心模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/receiveCardCoupon")
public class ReceiveCardCouponController extends BaseController {

	@Autowired
	private ReceiveCardCouponService receiveCardCouponService;
	
	@Autowired
	private CardCouponService cardCouponService;

	/**
	 * 取得领券中心列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getReceiveCardCouponList(ReceiveCardCouponQuery query, Model model) {
		if(!Tools.isEmpty(query.getCardName()))
			query.setCardNameQuery("%"+query.getCardName()+"%");
		List<ReceiveCardCoupon> receiveCardCouponList = receiveCardCouponService.selectByPageList(query);
		
		//查询总数量
		int pnums = receiveCardCouponService.countByExample(query);
		model.addAttribute("pnums",pnums);
		model.addAttribute("receiveCardCouponList",receiveCardCouponList);
		model.addAttribute("query",query);

		return "reveive_card_coupon/reveive_card_coupon_list";
	}

	/**
	 * 添加领券中心活动 
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addReceiveCardCouponInfo(HttpServletRequest request, ReceiveCardCoupon receiveCardCoupon, Model model) {
		if (receiveCardCoupon == null || Tools.isEmpty(receiveCardCoupon.getName())) {
			model.addAttribute("message", "请填写正确的活动信息");
			return "reveive_card_coupon/reveive_card_coupon_add";
		}
		try {
			if(!Tools.isEmpty(receiveCardCoupon.getPublishStartTimeStr()))
				receiveCardCoupon.setPublishStartTime(DateComFunc.strToDate(receiveCardCoupon.getPublishStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(receiveCardCoupon.getPublishEndTimeStr()))
				receiveCardCoupon.setPublishEndTime(DateComFunc.strToDate(receiveCardCoupon.getPublishEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			receiveCardCoupon.setCreDate(new Date());
			receiveCardCoupon.setCreator(Util.getUser(request).getLogin()); //从session中取得
			receiveCardCouponService.insert(receiveCardCoupon);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "reveive_card_coupon/reveive_card_coupon_add";
		}
		return "redirect:/receiveCardCoupon/select";
	}

	/**
	 * 跳转到添加活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "reveive_card_coupon/reveive_card_coupon_add";
	}

	/**
	 * 删除活动记录
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteReceiveCardCoupon")
	public String deleteReceiveCardCoupon(String recordIds, Model model) {
		if (recordIds == null) {
			model.addAttribute("message", "请选择要删除的活动记录");
			return "redirect:/receiveCardCoupon/select";
		}
		try {
			String[] recordIdArray = recordIds.split(",");
			for (String recordId : recordIdArray) {
				receiveCardCouponService.delete(Long.valueOf(recordId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/receiveCardCoupon/select";
		}
		return "redirect:/receiveCardCoupon/select";
	}

	/**
	 * 跳转到编辑活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model) {
		ReceiveCardCoupon receiveCardCoupon = receiveCardCouponService.selectById(id);
		model.addAttribute("receiveCardCoupon", receiveCardCoupon);
		return "reveive_card_coupon/reveive_card_coupon_edit";
	}

	/**
	 * 编辑品牌
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editReceiveCardCouponInfo(ReceiveCardCoupon receiveCardCoupon, Model model) {
		if (receiveCardCoupon == null || Tools.isEmpty(receiveCardCoupon.getName())) {
			model.addAttribute("message", "请填写正确的品牌名称和描述");
			return "reveive_card_coupon/reveive_card_coupon_edit";
		}
		try {
			if(!Tools.isEmpty(receiveCardCoupon.getPublishStartTimeStr()))
				receiveCardCoupon.setPublishStartTime(DateComFunc.strToDate(receiveCardCoupon.getPublishStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(receiveCardCoupon.getPublishEndTimeStr()))
				receiveCardCoupon.setPublishEndTime(DateComFunc.strToDate(receiveCardCoupon.getPublishEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			receiveCardCouponService.update(receiveCardCoupon);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "reveive_card_coupon/reveive_card_coupon_edit";
		}
		return "redirect:/receiveCardCoupon/select";
	}
	
	/**
	 * 更新使用状态
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateUseStatus")
	public String updateUseStatus(int id, boolean useStatus, Model model) {
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			param.put("useStatus", !useStatus);
			receiveCardCouponService.updateUseStatusByPrimaryKey(param);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/receiveCardCoupon/select";
		}
		return "redirect:/receiveCardCoupon/select";
	}
	
	/**
	 * 查询剩余的卡券数量 
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/countSurplusNum")
	@ResponseBody
	public Object countSurplusNum(Long cardId) {
		Map<String,Object> resMap = new HashMap<String,Object>();
		int count = 0;
		try {
			count = cardCouponService.countSurplusNum(cardId);
		} catch (Exception e) {
			count = 0;
		}
		
		resMap.put("count", count);
		Util.writeOk(resMap);
		return resMap;
	}
}
