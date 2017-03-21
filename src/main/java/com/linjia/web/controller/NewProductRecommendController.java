package com.linjia.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.constants.Application;
import com.linjia.tools.Tools;
import com.linjia.web.model.Brand;
import com.linjia.web.model.NewProductRecommend;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.service.BrandService;
import com.linjia.web.service.NewProductRecommendService;

/**
 * 新品推荐活动模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/newProductRecommend")
public class NewProductRecommendController extends BaseController {

	@Autowired
	private NewProductRecommendService newProductRecommendService;

	/**
	 * 取得新品推荐数据列表信息
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/select")
	public String getNewProductRecommendList(Model model) {
		List<NewProductRecommend> newProductRecommendList = newProductRecommendService.selectNewProductList();
		model.addAttribute("newProductRecommendList", newProductRecommendList);
		return "activity_new_product_recommend/activity_new_product_recommend_list";
	}


	/**
	 * 批量更新新品推荐数据
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String updateBatchNewProductRecommend(Long[] id, Long[] productId, String[] pCode, String[] pName, String[] imagePath, BigDecimal[] marketPrice, Model model) {
		List<NewProductRecommend> list = new ArrayList<NewProductRecommend>();
		if (id == null || productId == null || pCode == null || pName == null || imagePath == null || marketPrice == null) {
			model.addAttribute("message", "传入必填参数不正确");
			return "activity_new_product_recommend/activity_new_product_recommend_list";
		}
		try {
			Date date = new Date();
			for(int i =0;i< id.length;i++){
				NewProductRecommend item = new NewProductRecommend(id[i],productId[i],pCode[i],pName[i],marketPrice[i],imagePath[i].replace(Application.SERVER_BASE_PATH, ""),date);
				list.add(item);
			}
			newProductRecommendService.updateBatchByPrimaryKey(list);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "activity_new_product_recommend/activity_new_product_recommend_list";
		}
		return "redirect:/newProductRecommend/select";
	}
}
