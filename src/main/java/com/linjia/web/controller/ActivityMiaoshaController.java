package com.linjia.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.Brand;
import com.linjia.web.model.MiaoshaActivityBase;
import com.linjia.web.model.MiaoshaActivityProduct;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.query.MiaoshaActivityBaseQuery;
import com.linjia.web.service.BrandService;
import com.linjia.web.service.MiaoshaActivityService;

/**
 * 秒杀模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/activityMiaosha")
public class ActivityMiaoshaController extends BaseController {

	@Autowired
	private MiaoshaActivityService miaoshaActivityService;

	/**
	 * 取得秒杀活动列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getMiaoshaProductList(MiaoshaActivityBaseQuery query, Model model) {
		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");
		if (!Tools.isEmpty(query.getCreDateStartStr()))
			query.setCreDateStart(DateComFunc.strToDate(query.getCreDateStartStr(), "yyyy-MM-dd"));
		if (!Tools.isEmpty(query.getCreDateEndStr()))
			query.setCreDateEnd(DateComFunc.strToDate(query.getCreDateEndStr(), "yyyy-MM-dd"));

		List<MiaoshaActivityBase> miaoshaActivityBaseList = miaoshaActivityService.selectByPageList(query);
		
		//分页查询数据总数量
		int pnums = miaoshaActivityService.countByExample(query);
		model.addAttribute(miaoshaActivityBaseList);
		model.addAttribute("pnums",pnums);
		model.addAttribute("query", query);

		return "activity_miaosha/activity_miaosha_list";
	}

	/**
	 * 新增秒杀活动Base
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param miaoshaActivityProduct
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addMiaoshaBase")
	public String addMiaoshaBase(MiaoshaActivityBase miaoshaActivityBase, Model model) {
		if (miaoshaActivityBase == null || Tools.isEmpty(miaoshaActivityBase.getTimeNode())
				|| Tools.isEmpty(miaoshaActivityBase.getPublishDateStr())) {
			model.addAttribute("message", "请填写正确的活动信息");
			return "activity_miaosha/activity_miaosha_base_add";
		}
		try {
			miaoshaActivityService.insertMiaoshaBaseActivity(miaoshaActivityBase);
			model.addAttribute("miaoshaActivityBase", miaoshaActivityBase);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "activity_miaosha/activity_miaosha_base_add";
		}
		return "activity_miaosha/activity_miaosha_product_add";
	}

	/**
	 * 新增秒杀活动Product
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param miaoshaActivityProduct
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addMiaoshaProduct")
	@ResponseBody
	public Object addMiaoshaProduct(MiaoshaActivityProduct miaoshaActivityProduct, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingStartTimeStr()))
				miaoshaActivityProduct.setPanicBuyingStartTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingEndTimeStr()))
				miaoshaActivityProduct.setPanicBuyingEndTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			miaoshaActivityProduct.setImagePath(Util.replacePath(miaoshaActivityProduct.getImagePath()));
			miaoshaActivityService.insertMiaoshaProductActivity(miaoshaActivityProduct);
		} catch (Exception e) {
			resMap.put("message", "系统错误");
			Util.writeError(resMap);
			return resMap;
		}
		Util.writeOk(resMap);
		resMap.put("id", miaoshaActivityProduct.getId());
		resMap.put("message", "保存成功");
		return resMap;
	}

	/**
	 * 跳转到添加活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "activity_miaosha/activity_miaosha_base_add";
	}
	
	/**
	 * 跳转到添加活动商品页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/toAddProduct")
	public String toAddProduct(String userId) {
		return "activity_miaosha/activity_miaosha_product_add";
	}

	/**
	 * 删除活动Base
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteMiaoshaBase")
	public String deleteMiaoshaBase(String recordIds, Model model) {
		if (recordIds == null) {
			model.addAttribute("message", "请选择要删除的活动记录");
			return "redirect:/activityMiaosha/select";
		}
		try {
			String[] baseIdArray = recordIds.split(",");
			for (String baseId : baseIdArray) {
				miaoshaActivityService.delete(Long.valueOf(baseId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/activityMiaosha/select";
		}
		return "redirect:/activityMiaosha/select";
	}

	/**
	 * 跳转到Base编辑活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model, String message) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "redirect:/activityMiaosha/select";
		}
		MiaoshaActivityBase miaoshaActivityBase = miaoshaActivityService.selectById(id);
		model.addAttribute("miaoshaActivityBase", miaoshaActivityBase);
		if(!Tools.isEmpty(message))
			model.addAttribute("message", message);
		return "activity_miaosha/activity_miaosha_base_edit";
	}

	/**
	 * 编辑活动Base
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editBaseInfo(MiaoshaActivityBase miaoshaActivityBase, Model model) {
		try {
			miaoshaActivityService.updateMiaoshaBaseActivity(miaoshaActivityBase);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/activityMiaosha/toEdit";
		}
		model.addAttribute("message", "编辑成功");
		return "redirect:/activityMiaosha/toEditProduct?baseId=" + miaoshaActivityBase.getId();
	}

	/**
	 * 跳转到Product编辑活动页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEditProduct")
	public String toEditProduct(Long baseId, Model model) {
		if (baseId == null || baseId.longValue() == 0) {
			model.addAttribute("message", "活动记录Id不能为空!");
			return "redirect:/activityMiaosha/select";
		}
		
		MiaoshaActivityBase miaoshaActivityBase = miaoshaActivityService.selectById(baseId);
		model.addAttribute("miaoshaActivityBase", miaoshaActivityBase);
		
		List<MiaoshaActivityProduct> productList = miaoshaActivityService.selectProductListByBaseId(baseId);
		model.addAttribute("productList", productList);
		model.addAttribute("productListSize", productList.size());
		return "activity_miaosha/activity_miaosha_product_edit";
	}

	/**
	 * 编辑活动Product
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editProduct")
	@ResponseBody
	public Object editProductInfo(MiaoshaActivityProduct miaoshaActivityProduct, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (miaoshaActivityProduct == null || Tools.isEmpty(miaoshaActivityProduct.getpCode())
				|| Tools.isEmpty(miaoshaActivityProduct.getpName())) {
			resMap.put("message", "请填写正确的商品信息");
			Util.writeError(resMap);
			return resMap;
		}
		try {
			if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingStartTimeStr()))
				miaoshaActivityProduct.setPanicBuyingStartTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if(!Tools.isEmpty(miaoshaActivityProduct.getPanicBuyingEndTimeStr()))
				miaoshaActivityProduct.setPanicBuyingEndTime(DateComFunc.strToDate(miaoshaActivityProduct.getPanicBuyingEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			
			miaoshaActivityProduct.setImagePath(Util.replacePath(miaoshaActivityProduct.getImagePath()));
			miaoshaActivityService.updateActivityProduct(miaoshaActivityProduct);
		} catch (Exception e) {
			resMap.put("message", "系统错误");
			Util.writeError(resMap);
			return resMap;
		}
		resMap.put("message", "编辑成功");
		Util.writeOk(resMap);
		return resMap;
	}

	/**
	 * 删除活动Product
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param productId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteMiaoshaProduct")
	@ResponseBody
	public Object deleteMiaoshaProduct(Long id, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (id == null) {
			resMap.put("message", "缺少必填参数miaoshaProductId");
			Util.writeError(resMap);
			return resMap;
		}
		try {
			miaoshaActivityService.deleteActivityProduct(id);
		} catch (Exception e) {
			resMap.put("message", "系统错误");
			Util.writeError(resMap);
		}
		
		resMap.put("message", "删除成功");
		Util.writeOk(resMap);
		return resMap;
	}
}
