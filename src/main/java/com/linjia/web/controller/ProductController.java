package com.linjia.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.linjia.base.controller.BaseController;
import com.linjia.constants.Constants;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.ImportProductImage;
import com.linjia.tools.RandUtils;
import com.linjia.tools.Tools;
import com.linjia.tools.UploadImage;
import com.linjia.tools.Util;
import com.linjia.web.model.Brand;
import com.linjia.web.model.LargeCatagory;
import com.linjia.web.model.MiddleCatagory;
import com.linjia.web.model.Product;
import com.linjia.web.model.ProductBannerImages;
import com.linjia.web.model.ProductUnit;
import com.linjia.web.model.Tags;
import com.linjia.web.poi.Common;
import com.linjia.web.poi.ExportExcel;
import com.linjia.web.poi.ReadExcel;
import com.linjia.web.query.ProductQuery;
import com.linjia.web.service.BrandService;
import com.linjia.web.service.LargeCatagoryService;
import com.linjia.web.service.MiddleCatagoryService;
import com.linjia.web.service.ProductBannerImagesService;
import com.linjia.web.service.ProductService;
import com.linjia.web.service.ProductUnitService;
import com.linjia.web.service.TagsService;
import com.linjia.web.uhd123.service.UhdOrderService;

/**
 * 商品模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private ProductUnitService productUnitService;

	@Autowired
	private LargeCatagoryService largeCatagoryService;

	@Autowired
	private MiddleCatagoryService middleCatagoryService;

	@Autowired
	private TagsService tagsService;

	@Autowired
	private ProductBannerImagesService productBannerImagesService;
	
	@Autowired
	private UhdOrderService uhdOrderService;

	/**
	 * 取得商品列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getProductList(ProductQuery query, Model model, Integer popupFlg, Integer activityFlg, String params) {
		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");

		if (activityFlg != null && activityFlg == 1)
			query.setpSendType(Constants.PRODUCT_SEND_TYPE.PREPARE);

		List<Product> productList = productService.selectCatagoryProductList(query);

		// 查询总条数
		int pnums = productService.countByExample(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute(productList);
		model.addAttribute("query", query);

		// 一级分类列表
		List<LargeCatagory> largeCatagoryList = largeCatagoryService.selectAllLargeCatagoryList();
		model.addAttribute("largeCatagoryList", largeCatagoryList);
		if (query.getLargeCatagoryId() != null && query.getLargeCatagoryId() != 0) {
			List<MiddleCatagory> middleCatagoryList = middleCatagoryService.selectAllByLargeCatagoryId(query.getLargeCatagoryId());
			model.addAttribute("middleCatagoryList", middleCatagoryList);
		}

		// 是否是打开popup页面:0否,1是单选，2多选
		model.addAttribute("popupFlg", popupFlg);
		// popup页面需要返回的参数
		model.addAttribute("params", params);
		return "product/product_list";
	}

	/**
	 * 添加商品
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addProductInfo(HttpServletRequest request, Product product, Model model) {
		if (product == null || Tools.isEmpty(product.getName()) || Tools.isEmpty(product.getpCode())) {
			model.addAttribute("message", "请填写正确的商品名称和商品条形码");
			return "product/product_add";
		}
		try {
			String userId = Util.getUser(request).getLogin();
			handleProductParam(request, userId, product);
			product.setCreDate(new Date());
			product.setCreator(userId);

			productService.insertProduct(product);
			model.addAttribute("message", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "系统错误");
			return "product/product_add";
		}
		return "redirect:/product/select";
	}

	/**
	 * 处理新增或修改商品信息
	 * lixinling 
	 * 2016年8月23日 下午3:57:53
	 * @param userId
	 * @param product
	 */
	public void handleProductParam(HttpServletRequest request, String userId, Product product) {
		if (product.getUploadImage() != null) {
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = UploadImage.uploadProductImage(realPath, product.getUploadImage());
			product.setImagePath(uploadPath);
		}

		// 设置库存类型
		if (product.getpSendType() == Constants.PRODUCT_SEND_TYPE.IMMEDIATE) {
			product.setStockType(Constants.STOCK_TYPE.MENDIAN);
		} else {
			product.setStockType(Constants.STOCK_TYPE.CANGKU);
		}

		product.setAvailable(Constants.AVAILABLE.AVAILABLED);
		product.setpCode(product.getpCode().trim());

		product.setUpdateDate(new Date());
		product.setDeleted(false);
	}

	/**
	 * 跳转到添加商品编码页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toPcode")
	public String toPcode(Model model) {

		return "product/product_pcode";
	}

	/**
	 * 生成商品编码
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/generatePcode")
	@ResponseBody
	public Object generatePcode(Model model) {
		String pCode = RandUtils.getRandomNum(13);
		// pCode = pCode + "_linjia";

		Map<String, Object> resMap = new HashMap<String, Object>();

		resMap.put("pCode", pCode);
		resMap.put("status", "ok");
		return resMap;
	}

	/**
	 * 跳转到添加商品页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId, String pCode, Model model) {

		this.prepareData(model);

		// 查看pCode是否存在(存在的话只能选择非门店库存)
		/*
		 * int count = productService.checkPCode(pCode); if(count > 0){
		 * model.addAttribute("pCodeExist", 1); }else{
		 * model.addAttribute("pCodeExist", 0); }
		 */
		pCode = pCode.trim();
		model.addAttribute("pCode", pCode);
		return "product/product_add";
	}

	/**
	 * 检查商品code是否存在
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/checkPCode")
	@ResponseBody
	public Object checkPCode(String pCode) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		int count = productService.checkPCode(pCode);
		if (count > 0) {
			resMap.put("message", "该商品编码已存在!");
			resMap.put("status", "error");
			return resMap;
		}

		resMap.put("message", "校验通过!");
		resMap.put("status", "ok");
		return resMap;
	}

	/**
	 * 删除商品
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteProduct")
	public String deleteProduct(String productIds, Integer pageIndex, Model model) {
		if (productIds == null) {
			model.addAttribute("message", "请选择要删除的品牌");
			return "product/product_list";
		}
		try {
			String[] productIdArray = productIds.split(",");
			for (String productId : productIdArray) {
				productService.delete(Long.valueOf(productId));
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "product/product_list";
		}

		return "redirect:/product/select?pageIndex=" + pageIndex;
	}

	/**
	 * 跳转到编辑品牌页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Integer pageIndex, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			return "product/product_list";
		}

		Product product = productService.selectById(id);
		model.addAttribute("product", product);

		this.prepareData(model);

		if (product.getLargeCatagoryId() != null && product.getLargeCatagoryId() > 0) {
			List<MiddleCatagory> middleCatagoryList = middleCatagoryService.selectAllByLargeCatagoryId(product.getLargeCatagoryId());
			model.addAttribute("middleCatagoryList", middleCatagoryList);
		}
		model.addAttribute("pageIndex", pageIndex);

		return "product/product_edit";
	}

	/**
	 * 编辑品牌
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editProductInfo(HttpServletRequest request, Product product, Integer pageIndex, Model model) {
		if (product == null || Tools.isEmpty(product.getName()) || Tools.isEmpty(product.getpCode())) {
			model.addAttribute("message", "请填写正确的品牌名称和描述");
			return "redirect:/product/select";
		}
		try {
			String userId = Util.getUser(request).getLogin();
			handleProductParam(request, userId, product);
			productService.update(product);
			model.addAttribute("message", "编辑成功");
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/product/toEdit?id=" + product.getId();
		}
		return "redirect:/product/select?pageIndex=" + pageIndex;
	}

	/**
	 * 下拉列表数据
	 * lixinling 
	 * 2016年10月14日 上午10:43:18
	 * @param model
	 */
	public void prepareData(Model model) {
		// 品牌列表
		List<Brand> brandList = brandService.selectAllBrandList();
		model.addAttribute("brandList", brandList);

		// 单位列表
		List<ProductUnit> productUnitList = productUnitService.selectAllUnitList();
		model.addAttribute("productUnitList", productUnitList);

		// 一级分类列表
		List<LargeCatagory> largeCatagoryList = largeCatagoryService.selectAllLargeCatagoryList();
		model.addAttribute("largeCatagoryList", largeCatagoryList);

		// (标签类型：0默认标签;1促销标签；2商品标签)
		// 商品标签列表
		List<Tags> productTagsList = tagsService.selectAllTagsByType(2);
		model.addAttribute("productTagsList", productTagsList);

		// 促销标签列表
		/*List<Tags> promotionTagsList = tagsService.selectAllTagsByType(1);
		model.addAttribute("promotionTagsList", promotionTagsList);*/
	}

	/**
	 * 根据一级分类Id查询二级分类
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryMidCatagoryByLargeId")
	@ResponseBody
	public Object queryMidCatagoryByLargeId(Long largeId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (largeId == null || largeId.longValue() == 0) {
			resMap.put("message", "请先选择一级分类!");
			resMap.put("status", "error");
			return resMap;
		}

		List<MiddleCatagory> middleCatagoryList = middleCatagoryService.selectAllByLargeCatagoryId(largeId);
		resMap.put("middleCatagoryList", middleCatagoryList);
		resMap.put("status", "ok");

		return resMap;
	}

	/**
	 * 跳转到商品描述
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toDetail")
	public String toDetail(String userId, Long id, Integer pageIndex, Model model) {
		if (id == null || id.longValue() == 0) {
			return "redirect:/product/select";
		}

		Product product = productService.selectById(id);
		model.addAttribute("product", product);
		model.addAttribute("pageIndex", pageIndex);

		return "product/product_detail";
	}

	/**
	 * 提交商品描述
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/submitDetail")
	public String submitDetail(HttpServletRequest request, String htmlContent, int pageType, Long id, Integer pageIndex, Model model) {

		String realPath = request.getSession().getServletContext().getRealPath("/");
		String fileName = "product_" + id;
		String filePath = Util.createHtml(realPath, htmlContent, fileName);
		if (!Tools.isEmpty(filePath)) {
			// 更新商品信息
			Product product = new Product();
			product.setId(id);
			product.setDetailPath(filePath);
			product.setDetailText(htmlContent);
			productService.update(product);
		}

		return "redirect:/product/select?pageIndex=" + pageIndex;
	}

	/**
	 * 导出excel
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/exportProduct")
	public void export(HttpServletRequest request, HttpServletResponse response, ProductQuery query) {

		// 设置导出flag为1
		query.setExportFlag(1);

		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");

		List<Product> productList = productService.selectCatagoryProductList(query);

		ServletOutputStream out = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-excel");
			response.setCharacterEncoding("UTF-8");

			String filename = "商品信息列表" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
			ExportExcel<Product> ex = new ExportExcel<Product>();
			String[] headers = { "商品编码", "创建时间", "商品类型(0门店/1非门店)", "商品名称", "市场价格", "一级分类", "二级分类" };
			out = response.getOutputStream();
			ex.exportExcel(headers, productList, out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 下载模板
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response) {

		BufferedInputStream in = new BufferedInputStream(request.getSession().getServletContext().getResourceAsStream("/template/商品导入.xls"));
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(response.getOutputStream());
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-excel");
			response.setCharacterEncoding("UTF-8");

			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("商品导入.xls", "UTF-8"));
			byte[] b = new byte[1024 * 8];
			int len;
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 导入商品信息
	 * lixinling 
	 * 2016年10月21日 下午10:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/importProduct")
	@ResponseBody
	public Object importProduct(HttpServletRequest request, MultipartFile file) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String userId = (String) Util.getUser(request).getLogin();
		if (file != null) {

			// 文件名
			String fileName = file.getOriginalFilename();

			// 后缀名
			String suffix = fileName.substring(fileName.lastIndexOf(Common.POINT) + 1);
			if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(suffix)) {
				try {
					StringBuilder repeatPcode = new StringBuilder();
					List<Product> list = readXls(file.getInputStream(), userId, repeatPcode);
					if (list != null && list.size() > 0) {
						productService.insertBatch(list, userId);
					}

					String repeatStr = ", 发现重复商品编码：";
					if (repeatPcode.length() > 0) {
						String tempStr = repeatPcode.toString().substring(0, repeatPcode.lastIndexOf(","));
						repeatStr += tempStr;
					}
					resMap.put("message", "导入成功" + list.size() + "条" + repeatStr);
				} catch (Exception e) {
					resMap.put("message", "导入失败  ");
					logger.info("导入失败。");
					e.printStackTrace();
				}
			} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(suffix)) {
				resMap.put("message", "请下载模板进行导入，暂不支持xlsx类型文件导入。");
				logger.info("导入失败。请下载模板进行导入，暂不支持xlsx类型文件导入。");
				// 预留
				// readXlsx(file.getInputStream());
			} else {
				resMap.put("message", "导入失败。选择的文件格式不正确。");
				logger.info("导入失败。选择的文件格式不正确。");
			}

		} else {
			resMap.put("message", "导入失败。请选择正确的文件进行导入。");
			logger.info("导入失败。请选择正确的文件进行导入。");
		}

		return resMap;
	}

	public List<Product> readXls(InputStream is, String userId, StringBuilder repeatPcode) throws Exception {
		List<Product> list = new ArrayList<Product>();
		if (is == null) {
			logger.info("==========》导入文件流为空。");
			return list;
		} else {
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

			// 读取sheet
			for (int sheetNum = 0; sheetNum < hssfWorkbook.getNumberOfSheets(); sheetNum++) {
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNum);
				if (hssfSheet == null)
					continue;

				// 读取Row
				for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					if (hssfRow == null || hssfRow.getCell(0) == null) {
						continue;
					} else {
						HSSFCell pCodeCell = hssfRow.getCell(0);
						HSSFCell pNameCell = hssfRow.getCell(1);
						HSSFCell largeCatagoryNameCell = hssfRow.getCell(2);
						HSSFCell middleCatagoryNameCell = hssfRow.getCell(3);
						HSSFCell brandNameCell = hssfRow.getCell(4);
						HSSFCell unitNameCell = hssfRow.getCell(5);
						HSSFCell shelfLifeCell = hssfRow.getCell(6);
						HSSFCell descriptionCell = hssfRow.getCell(7);
						HSSFCell pTypeCell = hssfRow.getCell(8);
						HSSFCell marketPriceCell = hssfRow.getCell(9);
						HSSFCell sendScoreCell = hssfRow.getCell(10);
						HSSFCell pWeightCell = hssfRow.getCell(11);
						HSSFCell pSendTypeCell = hssfRow.getCell(12);
						HSSFCell imagePathCell = hssfRow.getCell(13);

						String pCode = pCodeCell == null ? null : (String) ReadExcel.getValue(pCodeCell);

						if(Tools.isEmpty(pCode))
							continue;
						
						// 验证此商品code是否已经存在
						int count = productService.checkPCode(pCode);
						if (count > 0) {
							repeatPcode.append(pCode + ",");
							continue;
						}
						String pName = pNameCell == null ? null :  ReadExcel.getValue(pNameCell)+"";
						String largeCatagoryName = largeCatagoryNameCell == null ? null : ReadExcel
								.getValue(largeCatagoryNameCell)+"";
						String middleCatagoryName = middleCatagoryNameCell == null ? null : ReadExcel
								.getValue(middleCatagoryNameCell)+"";
						String brandName = brandNameCell == null ? null :  ReadExcel.getValue(brandNameCell)+"";
						String unitName = unitNameCell == null ? null : ReadExcel.getValue(unitNameCell)+"";
						String shelfLife = shelfLifeCell == null ? null : String.valueOf(ReadExcel.getValue(shelfLifeCell));
						String description = descriptionCell == null ? null : ReadExcel.getValue(descriptionCell)+"";
						Integer pType = pTypeCell == null ? null : Integer.valueOf(pTypeCell.getStringCellValue());
						BigDecimal marketPrice = marketPriceCell == null ? null : new BigDecimal(ReadExcel.getValue(marketPriceCell)+"");
						Integer sendScore = sendScoreCell == null ? null : Integer.valueOf(sendScoreCell.getStringCellValue());
						BigDecimal pWeight = pWeightCell == null ? null : new BigDecimal(ReadExcel.getValue(pWeightCell)+"");
						Integer pSendType = pSendTypeCell == null ? null : Integer.valueOf(pSendTypeCell.getStringCellValue());
						String imagePath = imagePathCell == null ? null : ReadExcel.getValue(imagePathCell)+"";

						Product product = new Product();
						product.setpCode(pCode == null ? null : pCode.trim());
						product.setName(pName == null ? null : pName.trim());

						// 查询largeCatagoryId
						if (!Tools.isEmpty(largeCatagoryName)) {
							product.setLargeCatagoryId(largeCatagoryService.selectIdByName(largeCatagoryName == null ? null
									: largeCatagoryName.trim()));
							product.setLargeCatagoryName(largeCatagoryName == null ? null : largeCatagoryName.trim());
						}

						// 查询middleCatagoryId
						if (!Tools.isEmpty(middleCatagoryName)) {
							product.setMiddleCatagoryId(middleCatagoryService.selectIdByName(middleCatagoryName == null ? null
									: middleCatagoryName.trim()));
							product.setMiddleCatagoryName(middleCatagoryName == null ? null : middleCatagoryName.trim());
						}

						// 查询brandId
						if (!Tools.isEmpty(brandName)) {
							product.setBrandId(brandService.selectIdByName(brandName == null ? null : brandName.trim()));
							product.setBrandName(brandName == null ? null : brandName.trim());
						}

						// 查询unitId
						if (!Tools.isEmpty(unitName)) {
							product.setUnitId(productUnitService.selectIdByName(unitName == null ? null : unitName.trim()));
							product.setUnitName(unitName == null ? null : unitName.trim());
						}

						product.setShelfLife(shelfLife);
						product.setDescription(description);
						product.setpType(pType);
						product.setMarketPrice(marketPrice);
						product.setSendScore(Integer.valueOf(sendScore));
						product.setpWeight(pWeight);
						product.setpSendType(pSendType);

						// 设置库存类型
						if (product.getpSendType() == Constants.PRODUCT_SEND_TYPE.IMMEDIATE) {
							product.setStockType(Constants.STOCK_TYPE.MENDIAN);
						} else {
							product.setStockType(Constants.STOCK_TYPE.CANGKU);
						}

						product.setAvailable(Constants.AVAILABLE.AVAILABLED);
						product.setImagePath(imagePath);

						product.setUpdateDate(new Date());
						product.setDeleted(false);
						product.setCreDate(new Date());
						product.setCreator(userId);

						list.add(product);
					}
				}
			}

			return list;
		}

	}

	/**
	 * 跳转到上传轮播图页面
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toUploadBannerImage")
	public String toUploadBannerImage(Long id, Integer pageIndex, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择商品记录!");
			return "redirect:/product/select";
		}

		// 根据商品id取得轮播图列表
		List<ProductBannerImages> bannerImageList = productBannerImagesService.selectAllByProductId(id);

		model.addAttribute("bannerImageList", bannerImageList);
		model.addAttribute("id", id);
		model.addAttribute("pageIndex", pageIndex);
		return "product/product_banner_image";
	}

	/**
	 * 上传轮播图
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/uploadBannerImage")
	@ResponseBody
	public Object uploadBannerImage(HttpServletRequest request, Long id, @RequestParam("uploadImage") MultipartFile[] uploadImage,
			Long[] bannerImageId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (uploadImage == null || uploadImage.length == 0) {
			resMap.put("message", "请选择要上传的图片!");
			Util.writeError(resMap);
			return resMap;
		}

		String realPath = request.getSession().getServletContext().getRealPath("/");
		// List<String> bannerPathList = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < uploadImage.length; i++) {
			String uploadPath = UploadImage.uploadProductImage(realPath, uploadImage[i]);
			// bannerPathList.add(uploadPath);
			map.put("productId", id);
			map.put("path", uploadPath);
			// map.put("list", bannerPathList);
			map.put("bannerImageId", bannerImageId[i]);
			productBannerImagesService.updateOrInsertProductBannerImageById(map);
		}

		resMap.put("message", "上传成功");
		Util.writeOk(resMap);

		return resMap;
	}

	/**
	 * 删除轮播图
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteBannerImage")
	@ResponseBody
	public Object deleteBannerImage(Long id, String path) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (id == null || id.longValue() == 0) {
			resMap.put("message", "请选择要删除的图片!");
			Util.writeError(resMap);
			return resMap;
		}

		if (productBannerImagesService.delete(id)) {
			Util.deleteFile(path);
		}

		resMap.put("message", "删除成功");
		Util.writeOk(resMap);
		return resMap;
	}
	
	/**
	 * 取得商品列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectPopup")
	public String getPopupProductList(ProductQuery query, Model model, Integer popupFlg, Integer activityFlg, String params, String productIds, String tradeProductIds) {
		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");

		if (activityFlg != null && activityFlg == 1)
			query.setpSendType(Constants.PRODUCT_SEND_TYPE.PREPARE);

		List<Product> productList = productService.selectCatagoryProductList(query);

		// 查询总条数
		int pnums = productService.countByExample(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute(productList);
		model.addAttribute("query", query);

		// 一级分类列表
		List<LargeCatagory> largeCatagoryList = largeCatagoryService.selectAllLargeCatagoryList();
		model.addAttribute("largeCatagoryList", largeCatagoryList);
		if (query.getLargeCatagoryId() != null && query.getLargeCatagoryId() != 0) {
			List<MiddleCatagory> middleCatagoryList = middleCatagoryService.selectAllByLargeCatagoryId(query.getLargeCatagoryId());
			model.addAttribute("middleCatagoryList", middleCatagoryList);
		}

		// 是否是打开popup页面:0否,1是单选，2多选
		model.addAttribute("popupFlg", popupFlg);
		// popup页面需要返回的参数
		model.addAttribute("params", params);
		model.addAttribute("productIds", productIds);
		model.addAttribute("tradeProductIds", tradeProductIds);
		return "product/product_popup_list";
	}
}
