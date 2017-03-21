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
import com.linjia.web.query.BrandQuery;
import com.linjia.web.service.BrandService;

/**
 * 品牌模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController {

	@Autowired
	private BrandService brandService;

	/**
	 * 取得品牌列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/select")
	public String getBrandList(BrandQuery query, Model model, String message) throws UnsupportedEncodingException {
		if(!Tools.isEmpty(query.getName())){
			query.setNameQuery("%"+query.getName()+"%");
		}
		List<Brand> brandList = brandService.selectBySerach(query);
		
		//查询列表总数量
		int pnums = brandService.countByExample(query);
		model.addAttribute("query",query);
		model.addAttribute(brandList);
		model.addAttribute("pnums",pnums);
		if(!Tools.isEmpty(message))
			model.addAttribute("message", new String(message.getBytes("ISO-8859-1"),"utf-8"));

		return "brand/brand_list";
	}

	/**
	 * 添加品牌
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addBrandInfo(Brand brand, Model model) {
		if (brand == null || Tools.isEmpty(brand.getName()) || Tools.isEmpty(brand.getDescription())) {
			model.addAttribute("message", "请填写正确的品牌名称和描述");
			return "brand/brand_add";
		}
		try {
			brand.setCreDate(new Date());
			brand.setDeleted(false);
			brandService.insert(brand);
//			model.addAttribute("message", "添加成功");
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "brand/brand_add";
		}
		return "redirect:/brand/select";
	}

	/**
	 * 跳转到添加品牌页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId) {
		return "brand/brand_add";
	}

	/**
	 * 删除品牌
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteBrand")
	public String deleteBrand(String brandIds, Model model) {
		if (brandIds == null) {
			model.addAttribute("message", "请选择要删除的品牌");
			return "brand/brand_list";
		}
		try {
			String[] brandIdArray = brandIds.split(",");
			for (String brandId : brandIdArray) {
				brandService.delete(Long.valueOf(brandId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "brand/brand_list";
		}
		return "redirect:/brand/select";
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
			return "brand/brand_list";
		}
		Brand brand = brandService.selectById(id);
		model.addAttribute("brand", brand);
		return "brand/brand_edit";
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
	public String editBrandInfo(Brand brand, Model model) {
		if (brand == null || Tools.isEmpty(brand.getName()) || Tools.isEmpty(brand.getDescription())) {
			model.addAttribute("message", "请填写正确的品牌名称和描述");
			return "brand/brand_edit";
		}
		try {
			brandService.update(brand);
//			model.addAttribute("message", "编辑成功");
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "brand/brand_edit";
		}
		return "redirect:/brand/select";
	}

	/**
	 * 修改品牌状态
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateUseStatus")
	public String updateUseStatus(Brand brand, Model model) {
		if (brand == null || Tools.isEmpty(brand.getId()) || brand.getId() ==0) {
			model.addAttribute("message", "请传入正确参数");
			return "redirect:/brand/select";
		}
		try {
			brand.setUseStatus(!brand.getUseStatus());
			brandService.updateUseStatusByPrimaryKey(brand);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/brand/select";
		}
		return "redirect:/brand/select";
	}
}
