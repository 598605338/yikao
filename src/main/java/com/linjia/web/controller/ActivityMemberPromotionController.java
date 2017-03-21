package com.linjia.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.web.model.ActivityMemberPromotion;
import com.linjia.web.model.Brand;
import com.linjia.web.query.ActivityMemberPromotionQuery;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.service.ActivityMemberPromotionService;
import com.linjia.web.service.BrandService;

/**
 * 会员促销模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/activityMemberPromotion")
public class ActivityMemberPromotionController extends BaseController {

	@Autowired
	private ActivityMemberPromotionService activityMemberPromotionService;

	/**
	 * 取得会员促销活动列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getActivityMemberPromotionList(ActivityMemberPromotionQuery query, Model model) {
		if(!Tools.isEmpty(query.getActivityName()))
			query.setActivityNameQuery("%"+query.getActivityName()+"%");
		if(!Tools.isEmpty(query.getStartTimeStr()))
			query.setStartTime(DateComFunc.strToDate(query.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
		if(!Tools.isEmpty(query.getEndTimeStr()))
			query.setEndTime(DateComFunc.strToDate(query.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
		
		List<ActivityMemberPromotion> activityMemberPromotionList = activityMemberPromotionService.selectByPageList(query);
		
		//查询数据总数量
		int pnums = activityMemberPromotionService.countByExample(query);
		model.addAttribute("pnums",pnums);
		model.addAttribute("activityMemberPromotionList",activityMemberPromotionList);
		model.addAttribute("query", query);

		return "activity_member_promotion/activity_member_promotion_list";
	}

	/**
	 * 添加会员促销活动
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object addActivityMemberPromotionInfo(ActivityMemberPromotion activityMemberPromotion, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (activityMemberPromotion == null || Tools.isEmpty(activityMemberPromotion.getActivityName())
				|| activityMemberPromotion.getStartTimeStr() == null || activityMemberPromotion.getEndTimeStr() == null) {
			resMap.put("message", "请填写正确的活动信息");
			resMap.put("status", "error");
			return resMap;
		}
		try {
			if(!Tools.isEmpty(activityMemberPromotion.getStartTimeStr()))
				activityMemberPromotion.setStartTime(DateComFunc.strToDate(activityMemberPromotion.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityMemberPromotion.getEndTimeStr()))
				activityMemberPromotion.setEndTime(DateComFunc.strToDate(activityMemberPromotion.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			
			// 判断促销排期内是否已有活动安排
			int count = activityMemberPromotionService.selectExistsSameTime(activityMemberPromotion.getStartTime(),
					activityMemberPromotion.getEndTime());
			if (count == 0) {
				activityMemberPromotion.setCreDate(new Date());
				activityMemberPromotionService.insert(activityMemberPromotion);
			} else {
				resMap.put("message", "促销活动排期重复，请选择其他时间段");
				resMap.put("status", "error");
				return resMap;
			}
		} catch (Exception e) {
			resMap.put("message", "系统错误");
			resMap.put("status", "error");
			return resMap;
		}
		resMap.put("message", "success");
		resMap.put("status", "ok");
		return resMap;
	}

	/**
	 * 跳转到添加会员促销活动
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "activity_member_promotion/activity_member_promotion_add";
	}

	/**
	 * 删除会员促销活动
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteActivityMemberPromotion")
	public String deleteActivityMemberPromotion(String recordIds, Model model) {
		if (recordIds == null) {
			model.addAttribute("message", "请选择要删除的促销活动");
			return "redirect:/activityMemberPromotion/select";
		}
		try {
			String[] recordIdArray = recordIds.split(",");
			for (String recordId : recordIdArray) {
				activityMemberPromotionService.delete(Long.valueOf(recordId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/activityMemberPromotion/select";
		}
		return "redirect:/activityMemberPromotion/select";
	}

	/**
	 * 跳转到编辑会员促销活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "redirect:/activityMemberPromotion/select";
		}
		ActivityMemberPromotion activityMemberPromotion = activityMemberPromotionService.selectById(id);
		model.addAttribute("activityMemberPromotion", activityMemberPromotion);
		return "activity_member_promotion/activity_member_promotion_edit";
	}

	/**
	 * 编辑会员促销活动
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	@ResponseBody
	public Object editActivityMemberPromotionInfo(ActivityMemberPromotion activityMemberPromotion) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (activityMemberPromotion == null || Tools.isEmpty(activityMemberPromotion.getActivityName())
				|| activityMemberPromotion.getStartTimeStr() == null || activityMemberPromotion.getEndTimeStr() == null) {
			resMap.put("message", "请填写正确的活动信息");
			resMap.put("status", "error");
			return resMap;
		}
		try {
			if(!Tools.isEmpty(activityMemberPromotion.getStartTimeStr()))
				activityMemberPromotion.setStartTime(DateComFunc.strToDate(activityMemberPromotion.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(activityMemberPromotion.getEndTimeStr()))
				activityMemberPromotion.setEndTime(DateComFunc.strToDate(activityMemberPromotion.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			
			// 判断促销排期内是否已有活动安排
			int count = activityMemberPromotionService.selectExistsSameTime(activityMemberPromotion.getStartTime(),
					activityMemberPromotion.getEndTime());
			if (count == 0) {
				activityMemberPromotionService.update(activityMemberPromotion);
			} else {
				resMap.put("message", "促销活动排期重复，请选择其他时间段");
				resMap.put("status", "error");
				return resMap;
			}
		} catch (Exception e) {
			resMap.put("message", "系统错误");
			resMap.put("status", "error");
			return resMap;
		}
		resMap.put("message", "success");
		resMap.put("status", "ok");
		return resMap;
	}

	/**
	 * 更改使用状态
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateStatus")
	public String updateStatusByPrimaryKey(Long id, boolean useStatus, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "id不能为空");
			return "redirect:/activityMemberPromotion/select";
		}
		try {
			activityMemberPromotionService.updateStatusByPrimaryKey(!useStatus, id);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/activityMemberPromotion/select";
		}
		return "redirect:/activityMemberPromotion/select";
	}

}
