package com.linjia.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.Tools;
import com.linjia.web.model.Brand;
import com.linjia.web.model.ProductUnit;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.query.ProductUnitQuery;
import com.linjia.web.service.BrandService;
import com.linjia.web.service.ProductUnitService;

/**
 * 单位模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/unit")
public class ProductUnitController extends BaseController {

	@Autowired
	private ProductUnitService productUnitService;

	/**
	 * 取得单位列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/select")
	public String getProductUnitList(ProductUnitQuery query, Model model, String message) throws UnsupportedEncodingException {
		List<ProductUnit> productUnitList = productUnitService.selectByPageList(query);
		
		//取得分页数据的总数量
		int pnums = productUnitService.countByExample(query);
		model.addAttribute(productUnitList);
		model.addAttribute("pnums",pnums);
		model.addAttribute("query", query);
		if(!Tools.isEmpty(message))
			model.addAttribute("message", new String(message.getBytes("ISO-8859-1"),"utf-8"));
		return "unit/product_unit_list";
	}

	/**
	 * 添加单位
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addProductUnitInfo(ProductUnit productUnit, Model model) {
		if (productUnit == null || Tools.isEmpty(productUnit.getName())) {
			model.addAttribute("message", "请填写正确的品牌名称和描述");
			return "unit/product_unit_add";
		}
		try {
			productUnit.setName(productUnit.getName());
			productUnitService.insert(productUnit);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "unit/product_unit_add";
		}
		return "redirect:/unit/select";
	}

	/**
	 * 跳转到添加单位页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "unit/product_unit_add";
	}

	/**
	 * 添加单位
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteUnit")
	public String deleteUnit(String unitIds, Model model) {
		if (unitIds == null) {
			model.addAttribute("message", "请选择要删除的单位");
			return "unit/product_unit_list";
		}
		try {
			String[] unitIdArray = unitIds.split(",");
			for (String unitId : unitIdArray) {
				productUnitService.delete(Long.valueOf(unitId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "unit/product_unit_list";
		}
		return "redirect:/unit/select";
	}

	/**
	 * 跳转到编辑品牌页
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
			return "redirect:/unit/select";
		}
		ProductUnit productUnit = productUnitService.selectById(id);
		model.addAttribute("productUnit", productUnit);
		return "unit/product_unit_edit";
	}

	/**
	 * 编辑单位
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editProductUnitInfo(ProductUnit productUnit, Model model) {
		if (productUnit == null || Tools.isEmpty(productUnit.getName())) {
			model.addAttribute("productUnit", productUnit);
			model.addAttribute("message", "请填写正确的单位名称和描述");
			return "unit/product_unit_edit";
		}
		try {
			productUnitService.update(productUnit);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			model.addAttribute("productUnit", productUnit);
			return "unit/product_unit_edit";
		}
		return "redirect:/unit/select";
	}
	

	/**
	 * 修改单位状态
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param productUnit
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateUseStatus")
	public String updateUseStatus(ProductUnit productUnit, Model model) {
		if (productUnit == null || Tools.isEmpty(productUnit.getId()) || productUnit.getId() ==0) {
			model.addAttribute("message", "请传入正确参数");
			return "redirect:/unit/select";
		}
		try {
			productUnit.setUseStatus(!productUnit.getUseStatus());
			productUnitService.updateUseStatusById(productUnit);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/unit/select";
		}
		return "redirect:/unit/select";
	}
}
