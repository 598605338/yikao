package com.linjia.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.linjia.base.controller.BaseController;
import com.linjia.constants.Constants;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.LargeCatagory;
import com.linjia.web.model.MiddleCatagory;
import com.linjia.web.model.Product;
import com.linjia.web.poi.Common;
import com.linjia.web.poi.ReadExcel;
import com.linjia.web.query.CatagoryQuery;
import com.linjia.web.service.LargeCatagoryService;
import com.linjia.web.service.MiddleCatagoryService;
import com.linjia.web.service.ProductService;

/**
 * 分类模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/productCatagory")
public class ProductCatagoryController extends BaseController {

	@Autowired
	private LargeCatagoryService largeCatagoryService;

	@Autowired
	private MiddleCatagoryService middleCatagoryService;

	@Autowired
	private ProductService productService;

	/**
	 * 取得一级分类列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/selectLargeCatagory")
	public String selectLargeCatagory(CatagoryQuery query, Model model, String message) throws UnsupportedEncodingException {

		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");

		List<LargeCatagory> catagoryList = largeCatagoryService.selectPageList(query);

		// 查询总记录数
		int pnums = largeCatagoryService.countByExample(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute("catagoryList", catagoryList);
		model.addAttribute("query", query);
		model.addAttribute("level", "large");
		if (!Tools.isEmpty(message))
			model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));
		return "catagory/catagory_list";
	}

	/**
	 * 取得二级分类列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/selectMiddleCatagory")
	public String selectMiddleCatagory(CatagoryQuery query, Model model, String message) throws UnsupportedEncodingException {
		if (query.getLargeCatagoryId() == null || query.getLargeCatagoryId().longValue() == 0) {
			model.addAttribute("message", "请传入正确一级分类id");
			return "catagory/catagory_list";
		}

		if (!Tools.isEmpty(query.getName()))
			query.setNameQuery("%" + query.getName() + "%");

		List<MiddleCatagory> catagoryList = middleCatagoryService.selectByLargeCatagoryId(query);

		int pnums = middleCatagoryService.countByExample(query);
		model.addAttribute("pnums", pnums);
		model.addAttribute("catagoryList", catagoryList);
		model.addAttribute("level", "middle");
		model.addAttribute("query", query);
		model.addAttribute("largeCatagoryId", query.getLargeCatagoryId());
		if (!Tools.isEmpty(message))
			model.addAttribute("message", new String(message.getBytes("ISO-8859-1"), "utf-8"));

		return "catagory/catagory_list";
	}

	/**
	 * 添加分类
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addCatagory(CatagoryQuery query, Model model) {
		if (query == null || Tools.isEmpty(query.getName())) {
			model.addAttribute("message", "请填写正确的分类信息");
			return "catagory/catagory_add";
		}
		try {
			if (query.getLargeCatagoryId() == null || query.getLargeCatagoryId().longValue() == 0) {
				LargeCatagory largeCatagory = new LargeCatagory();
				largeCatagory.setName(query.getName());
				largeCatagory.setSortIndex(query.getSortIndex());
				largeCatagoryService.insert(largeCatagory);
			} else {
				MiddleCatagory middleCatagory = new MiddleCatagory();
				middleCatagory.setLargeCatagoryId(query.getLargeCatagoryId().intValue());
				middleCatagory.setName(query.getName());
				middleCatagory.setSortIndex(query.getSortIndex());
				middleCatagoryService.insert(middleCatagory);
				return "redirect:/productCatagory/selectMiddleCatagory?largeCatagoryId=" + middleCatagory.getLargeCatagoryId();
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "catagory/catagory_add";
		}
		return "redirect:/productCatagory/selectLargeCatagory";
	}

	/**
	 * 跳转到添加分类页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId, Long largeCatagoryId, Model model) {
		model.addAttribute("largeCatagoryId", largeCatagoryId);
		if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
			Long maxSortIndex = largeCatagoryService.selectMaxSortIndex();
			model.addAttribute("maxSortIndex", maxSortIndex);
		} else {
			Long maxSortIndex = middleCatagoryService.selectMaxSortIndex();
			model.addAttribute("maxSortIndex", maxSortIndex);
		}
		return "catagory/catagory_add";
	}

	/**
	 * 删除分类
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteCatagory")
	public String deleteCatagory(String[] catagoryIds, Long largeCatagoryId, Model model) {
		if (catagoryIds == null) {
			model.addAttribute("message", "请选择要删除的分类");
			if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
				return "redirect:/productCatagory/selectLargeCatagory";
			} else {
				return "redirect:/productCatagory/selectMiddleCatagory?largeCatagoryId=" + largeCatagoryId;
			}
		}
		try {
			for (String catagoryId : catagoryIds) {
				if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
					largeCatagoryService.delete(Long.valueOf(catagoryId));
				} else {
					middleCatagoryService.delete(Long.valueOf(catagoryId));
				}
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "catagory/catagory_list";
		}

		if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
			return "redirect:/productCatagory/selectLargeCatagory";
		} else {
			return "redirect:/productCatagory/selectMiddleCatagory?largeCatagoryId=" + largeCatagoryId;
		}
	}

	/**
	 * 跳转到编辑分类页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Long id, Long largeCatagoryId, Model model) {
		if (id == null || id.longValue() == 0) {
			model.addAttribute("message", "请选择要编辑的记录!");
			if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
				return "redirect:/productCatagory/selectLargeCatagory";
			} else {
				return "redirect:/productCatagory/selectMiddleCatagory?largeCatagoryId=" + largeCatagoryId;
			}
		}
		if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
			LargeCatagory catagory = largeCatagoryService.selectById(id);
			model.addAttribute("catagory", catagory);
		} else {
			MiddleCatagory catagory = middleCatagoryService.selectById(id);
			model.addAttribute("catagory", catagory);
		}
		model.addAttribute("largeCatagoryId", largeCatagoryId);
		return "catagory/catagory_edit";
	}

	/**
	 * 编辑分类
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editCatagoryInfo(String name, Long id, Long largeCatagoryId, int sortIndex, Model model) {
		if (name == null) {
			model.addAttribute("message", "请填写正确的分类信息");
			model.addAttribute("largeCatagoryId", largeCatagoryId);
			return "/catagory/catagory_edit";
		}
		try {
			if (id == null || id.longValue() == 0 || Tools.isEmpty(name)) {
				model.addAttribute("message", "请填写正确的分类信息");
				model.addAttribute("largeCatagoryId", largeCatagoryId);
				return "/catagory/catagory_edit";
			} else if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
				// 一级分类更改
				LargeCatagory largeCatagory = new LargeCatagory();
				largeCatagory.setId(id);
				largeCatagory.setName(name);
				largeCatagory.setSortIndex(sortIndex);
				largeCatagoryService.update(largeCatagory);
				return "redirect:/productCatagory/selectLargeCatagory";
			} else {
				// 二级分类更改
				MiddleCatagory middleCatagory = new MiddleCatagory();
				middleCatagory.setId(id);
				middleCatagory.setName(name);
				middleCatagory.setSortIndex(sortIndex);
				middleCatagoryService.update(middleCatagory);
				return "redirect:/productCatagory/selectMiddleCatagory?largeCatagoryId=" + largeCatagoryId;
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "/catagory/selectLargeCatagory";
		}
	}

	/**
	 * 更改使用状态
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateUseStatus")
	public String editUseStatus(Long id, boolean useStatus, Long largeCatagoryId, Model model) {
		try {
			if (largeCatagoryId == null || largeCatagoryId.longValue() == 0) {
				// 一级分类更改
				LargeCatagory largeCatagory = new LargeCatagory();
				largeCatagory.setId(id);
				largeCatagory.setUseStatus(!useStatus);
				largeCatagoryService.updateUseStatusByPrimaryKey(largeCatagory);
				return "redirect:/productCatagory/selectLargeCatagory";
			} else {
				// 二级分类更改
				MiddleCatagory middleCatagory = new MiddleCatagory();
				middleCatagory.setId(id);
				middleCatagory.setUseStatus(!useStatus);
				middleCatagoryService.updateUseStatusByPrimaryKey(middleCatagory);
				return "redirect:/productCatagory/selectMiddleCatagory?largeCatagoryId=" + largeCatagoryId;
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "/catagory/selectLargeCatagory";
		}
	}

	/**
	 * 下载批量编辑商品分类模板
	 * lixinling 
	 * 2017年2月8日 上午11:55:56
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		BufferedInputStream in = new BufferedInputStream(request.getSession().getServletContext().getResourceAsStream("/template/批量编辑商品分类.xls"));
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(response.getOutputStream());
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-excel");
			response.setCharacterEncoding("UTF-8");

			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("批量编辑商品分类.xls", "UTF-8"));
			byte[] b = new byte[8 * 1024];
			int len;
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			out.flush();
		} catch (IOException e) {
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
	 * 导入批量编辑分类的商品
	 * lixinling 
	 * 2016年10月21日 下午10:23:04
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/importEditProduct")
	@ResponseBody
	public Object importEditProduct(HttpServletRequest request, MultipartFile file) {
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
						productService.updateCatagoryBatchByPCode(list);
					}

					resMap.put("message", "导入成功" + list.size() + "条");
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
						HSSFCell largeCatagoryNameCell = hssfRow.getCell(1);
						HSSFCell middleCatagoryNameCell = hssfRow.getCell(2);

						String pCode = pCodeCell == null ? null : (String) ReadExcel.getValue(pCodeCell);

						if (Tools.isEmpty(pCode))
							continue;

						String largeCatagoryName = largeCatagoryNameCell == null ? null : (String) ReadExcel.getValue(largeCatagoryNameCell);
						String middleCatagoryName = middleCatagoryNameCell == null ? null : (String) ReadExcel.getValue(middleCatagoryNameCell);

						Product product = new Product();
						product.setpCode(pCode == null ? null : pCode.trim());

						// 查询largeCatagoryId
						if (!Tools.isEmpty(largeCatagoryName)) {
							product.setLargeCatagoryId(largeCatagoryService.selectIdByName(largeCatagoryName == null ? null : largeCatagoryName.trim()));
							product.setLargeCatagoryName(largeCatagoryName == null ? null : largeCatagoryName.trim());
						}

						// 查询middleCatagoryId
						if (!Tools.isEmpty(middleCatagoryName)) {
							product.setMiddleCatagoryId(middleCatagoryService.selectIdByName(middleCatagoryName == null ? null : middleCatagoryName.trim()));
							product.setMiddleCatagoryName(middleCatagoryName == null ? null : middleCatagoryName.trim());
						}

						product.setUpdateDate(new Date());

						list.add(product);
					}
				}
			}

			return list;
		}

	}
}
