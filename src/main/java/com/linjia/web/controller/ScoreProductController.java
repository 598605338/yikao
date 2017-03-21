package com.linjia.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.tools.UploadImage;
import com.linjia.tools.Util;
import com.linjia.web.model.Product;
import com.linjia.web.model.ScoreProduct;
import com.linjia.web.model.TailGoodsClear;
import com.linjia.web.query.ScoreProductQuery;
import com.linjia.web.query.TailGoodsClearQuery;
import com.linjia.web.service.ScoreProductService;
import com.linjia.web.service.TailGoodsClearService;

/**
 * 积分商城模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/scoreProduct")
public class ScoreProductController extends BaseController {

	@Autowired
	private ScoreProductService scoreProductService;

	/**
	 * 取得积分商城列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getScoreProductList(ScoreProductQuery query, Model model, String message) {
		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");
		List<ScoreProduct> scoreProductList = scoreProductService.selectByPageList(query);
		
		//查询分页数据总数量
		int pnums = scoreProductService.countByExample(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute("scoreProductList", scoreProductList);
		model.addAttribute("query", query);
		if(!Tools.isEmpty(message))
			model.addAttribute("message", message);
		return "score_product/score_product_list";
	}

	/**
	 * 添加积分商城商品
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param scoreProduct
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addScoreProductInfo(HttpServletRequest request, ScoreProduct scoreProduct, Model model) {
		if (scoreProduct == null || Tools.isEmpty(scoreProduct.getName()) || scoreProduct.getCardCouponId() == null) {
			model.addAttribute("message", "请填写正确的积分信息");
			return "redirect:/scoreProduct/select";
		}
		try {
			if (scoreProduct.getUploadImage() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String uploadPath = UploadImage.uploadProductImage(realPath,scoreProduct.getUploadImage());
				scoreProduct.setImagePath(uploadPath);
			}
			
			scoreProduct.setCreDate(new Date());
			scoreProductService.insert(scoreProduct);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "score_product/score_product_add";
		}
		return "redirect:/scoreProduct/select";
	}

	/**
	 * 跳转到新增页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId, Model model) {
		Long maxSortIndex = scoreProductService.selectMaxSortIndex();
		model.addAttribute("maxSortIndex", maxSortIndex);
		return "score_product/score_product_add";
	}

	/**
	 * 删除记录
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param recordIds
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String deleteScoreProduct(String recordIds, Model model) {
		if (recordIds == null) {
			model.addAttribute("message", "请选择要删除的记录");
			return "redirect:/scoreProduct/select";
		}
		try {
			String[] recordIdArray = recordIds.split(",");
			for (String recordId : recordIdArray) {
				scoreProductService.delete(Long.valueOf(recordId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/scoreProduct/select";
		}
		return "redirect:/scoreProduct/select";
	}

	/**
	 * 跳转到编辑页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "redirect:/scoreProduct/select";
		}
		ScoreProduct scoreProduct = scoreProductService.selectById(id);
		model.addAttribute("scoreProduct", scoreProduct);
		return "score_product/score_product_edit";
	}

	/**
	 * 编辑积分商城记录
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editScoreProductInfo(HttpServletRequest request, ScoreProduct scoreProduct, Model model) {
		if (scoreProduct == null || Tools.isEmpty(scoreProduct.getName()) || scoreProduct.getCardCouponId() == null) {
			model.addAttribute("message", "请填写正确的活动信息");
			return "redirect:/scoreProduct/toEdit?id=" + scoreProduct.getId();
		}
		try {
			if (scoreProduct.getUploadImage() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String uploadPath = UploadImage.uploadProductImage(realPath,scoreProduct.getUploadImage());
				scoreProduct.setImagePath(uploadPath);
			}
			
			scoreProductService.update(scoreProduct);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/scoreProduct/toEdit?id=" + scoreProduct.getId();
		}
		return "redirect:/scoreProduct/select";
	}

	/**
	 * 编辑上下架状态
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateStatus")
	public String updateStatus(ScoreProduct scoreProduct, Model model) {
		scoreProduct.setUseStatus(!scoreProduct.getUseStatus());
		scoreProductService.updateStatusByPrimaryKey(scoreProduct);
		return "redirect:/scoreProduct/select";
	}
	

	/**
	 * 跳转到积分商品详情
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toDetail")
	public String toDetail(String userId, Long id, Model model) {
		if(id == null || id.longValue() == 0){
			return "redirect:/scoreProduct/select";
		}
		
		ScoreProduct scoreProduct = scoreProductService.selectById(id);
		model.addAttribute("scoreProduct", scoreProduct);
		
		return "score_product/score_product_detail";
	}
	

	/**
	 * 提交积分商品详情
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/submitDetail")
	public String submitDetail(HttpServletRequest request, String htmlContent, int pageType, Long id, Model model) {
		
		String realPath =request.getSession().getServletContext().getRealPath("/");
		String fileName = "score_product_"+id;
		String filePath=Util.createHtml(realPath, htmlContent, fileName);
		if(!Tools.isEmpty(filePath)){
			//更新商品信息
			ScoreProduct scoreProduct = new ScoreProduct();
			scoreProduct.setId(id);
			scoreProduct.setDetailPath(filePath);
			scoreProduct.setDetailText(htmlContent);
			scoreProductService.update(scoreProduct);
		}
		
		return "redirect:/scoreProduct/select";
	}
}
