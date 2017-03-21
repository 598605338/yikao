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
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.web.session.HttpServletSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.linjia.base.controller.BaseController;
import com.linjia.constants.Constants;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.tools.Util;
import com.linjia.web.model.Brand;
import com.linjia.web.model.CardCoupon;
import com.linjia.web.model.CardCouponProduct;
import com.linjia.web.model.CardCouponThird;
import com.linjia.web.model.ExportUserCardCoupon;
import com.linjia.web.model.Product;
import com.linjia.web.model.SecUser;
import com.linjia.web.model.SelectCustSendCardCoupon;
import com.linjia.web.model.UserCardCoupon;
import com.linjia.web.poi.Common;
import com.linjia.web.poi.ExportExcel;
import com.linjia.web.poi.ReadExcel;
import com.linjia.web.query.BrandQuery;
import com.linjia.web.query.CardCouponQuery;
import com.linjia.web.query.CardCouponThirdQuery;
import com.linjia.web.query.ProductQuery;
import com.linjia.web.query.UserCardCouponQuery;
import com.linjia.web.service.BrandService;
import com.linjia.web.service.CardCouponProductService;
import com.linjia.web.service.CardCouponService;
import com.linjia.web.service.CustMasterService;
import com.linjia.web.service.UserCardCouponService;

/**
 * 卡券模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/cardCoupon")
public class CardCouponController extends BaseController {
	
	@Autowired
	private CardCouponService cardCouponService;

	@Autowired
	private CardCouponProductService cardCouponProductService;

	@Autowired
	private UserCardCouponService userCardCouponService;
	
	@Autowired
	private CustMasterService custMasterService;

	/**
	 * 取得卡券列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getCardCouponList(CardCouponQuery query, Model model, Integer popupFlg, String params) {

		if (!Tools.isEmpty(query.getStartTimeStr()))
			query.setStartTime(DateComFunc.strToDate(query.getStartTimeStr(), "yyyy-MM-dd"));
		if (!Tools.isEmpty(query.getEndTimeStr()))
			query.setEndTime(DateComFunc.strToDate(query.getEndTimeStr(), "yyyy-MM-dd"));
		if (!Tools.isEmpty(query.getCardName()))
			query.setCardNameQuery("%" + query.getCardName() + "%");

		if (popupFlg != null) {
			query.setPopupFlg(popupFlg);
		}

		List<CardCoupon> cardCouponList = cardCouponService.selectByPageList(query);
		int pnums = cardCouponService.countByExample(query);

		model.addAttribute("pnums", pnums);
		model.addAttribute("cardCouponList", cardCouponList);
		model.addAttribute("query", query);

		// 是否是打开popup页面:0否,1是
		model.addAttribute("popupFlg", popupFlg);
		// popup页需要返回的参数
		model.addAttribute("params", params);

		return "card_coupon/card_coupon_list";
	}

	/**
	 * 添加卡券
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param cardCoupon
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String addCardCouponInfo(HttpServletRequest request, CardCoupon cardCoupon, Model model, String pName) {
		if (cardCoupon == null || Tools.isEmpty(cardCoupon.getCardName()) || Tools.isEmpty(cardCoupon.getDescription())
				|| cardCoupon.getCardType() == null) {
			model.addAttribute("message", "请填写正确的卡券信息");
			return "card_coupon/card_coupon_add";
		}
		try {
			cardCoupon.setCreatetime(new Date());
			cardCoupon.setCreator(Util.getUser(request).getLogin());

			if (!Tools.isEmpty(cardCoupon.getStartTimeStr()))
				cardCoupon.setStartTime(DateComFunc.strToDate(cardCoupon.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(cardCoupon.getEndTimeStr()))
				cardCoupon.setEndTime(DateComFunc.strToDate(cardCoupon.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(cardCoupon.getUseStartTimeStr()))
				cardCoupon.setUseStartTime(DateComFunc.strToDate(cardCoupon.getUseStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(cardCoupon.getUseEndTimeStr()))
				cardCoupon.setUseEndTime(DateComFunc.strToDate(cardCoupon.getUseEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			cardCoupon.setUseflg(1);
			cardCouponService.insertCardCoupon(cardCoupon, pName);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			model.addAttribute("cardType", cardCoupon.getCardType());
			return "card_coupon/card_coupon_add";
		}
		return "redirect:/cardCoupon/select";
	}

	/**
	 * 跳转到添加卡券页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(String userId, int cardType, Model model) {
		model.addAttribute("cardType", cardType);
		return "card_coupon/card_coupon_add";
	}

	/**
	 * 删除卡券
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteCardCoupon")
	public String deleteCardCoupon(Long cardId, Model model) {
		if (cardId == null) {
			model.addAttribute("message", "请选择要删除的品牌");
			return "redirect:/cardCoupon/select";
		}
		try {
			cardCouponService.delete(cardId);
		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "redirect:/cardCoupon/select";
		}
		return "redirect:/cardCoupon/select";
	}

	/**
	 * 跳转到编辑卡券页
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
			return "card_coupon/card_coupon_list";
		}
		CardCoupon cardCoupon = cardCouponService.selectById(id);
		CardCouponProduct cardCouponProduct = cardCouponProductService.selectByCardCouponId(cardCoupon.getCardId());
		model.addAttribute("cardCoupon", cardCoupon);
		model.addAttribute("cardCouponProduct", cardCouponProduct);
		return "card_coupon/card_coupon_edit";
	}

	/**
	 * 编辑卡券
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String editCardCouponInfo(CardCoupon cardCoupon, Model model, Integer cardCouponProductId, String pName) {
		if (cardCoupon == null || Tools.isEmpty(cardCoupon.getCardName()) || Tools.isEmpty(cardCoupon.getDescription())) {
			model.addAttribute("message", "请填写正确的品牌名称和描述");
			return "card_coupon/card_coupon_edit";
		}
		try {
			if (!Tools.isEmpty(cardCoupon.getStartTimeStr()))
				cardCoupon.setStartTime(DateComFunc.strToDate(cardCoupon.getStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(cardCoupon.getEndTimeStr()))
				cardCoupon.setEndTime(DateComFunc.strToDate(cardCoupon.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(cardCoupon.getUseStartTimeStr()))
				cardCoupon.setUseStartTime(DateComFunc.strToDate(cardCoupon.getUseStartTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			if (!Tools.isEmpty(cardCoupon.getUseEndTimeStr()))
				cardCoupon.setUseEndTime(DateComFunc.strToDate(cardCoupon.getUseEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));

			cardCouponService.update(cardCoupon);

		} catch (Exception e) {
			model.addAttribute("message", "系统错误");
			return "card_coupon/card_coupon_edit";
		}
		return "redirect:/cardCoupon/select";
	}

	/**
	 * 跳转到查看券码页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toCheckCardCoupon")
	public String toCheckCardCoupon(UserCardCouponQuery userCardCouponQuery, Model model) {
		if (userCardCouponQuery.getCardCouponId() == null || userCardCouponQuery.getCardCouponId().longValue() == 0) {
			model.addAttribute("message", "请选择要查看的记录!");
			return "redirect:/cardCoupon/select";
		}
		List<UserCardCoupon> userCardCouponList = userCardCouponService.selectByPageList(userCardCouponQuery);
		int pnums = userCardCouponService.countByExample(userCardCouponQuery);

		model.addAttribute("pnums", pnums);
		model.addAttribute("userCardCouponList", userCardCouponList);
		model.addAttribute("query", userCardCouponQuery);
		return "card_coupon/card_coupon_check_list";
	}
	
	/**
	 * 导出券码详情excel
	 * lixinling 
	 * 2017年2月9日 下午2:23:04
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/exportCardCouponDetail")
	public void export(HttpServletRequest request, HttpServletResponse response, UserCardCouponQuery userCardCouponQuery) {

		// 设置导出flag为1
		userCardCouponQuery.setExportFlag(1);

		List<UserCardCoupon> userCardCouponList = userCardCouponService.selectByPageList(userCardCouponQuery);
		//int pnums = userCardCouponService.countByExample(userCardCouponQuery);
		
		List<ExportUserCardCoupon> exportResultSet = null;
		if(userCardCouponList != null && userCardCouponList.size() > 0){
			//结果集转换
			exportResultSet = this.convertResultSet(userCardCouponList);
		}
		ServletOutputStream out = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-excel");
			response.setCharacterEncoding("UTF-8");

			String filename = "查看券码_" + userCardCouponQuery.getCardCouponId() + "_" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
			ExportExcel<ExportUserCardCoupon> ex = new ExportExcel<ExportUserCardCoupon>();
			String[] headers = { "劵码", "卡券类型", "卡券名称", "券有效期", "发放时间", "领取时间", "码状态", "会员名", "会员手机号", "使用门店", "抵扣金额", "使用时间", "订单号" };
			out = response.getOutputStream();
			
			ex.exportExcel(headers, exportResultSet, out);
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
	 * 转换成导出结果集
	 * lixinling 
	 * 2017年2月9日 下午4:42:05
	 * @param userCardCouponList
	 * @return
	 */
	public List<ExportUserCardCoupon> convertResultSet(List<UserCardCoupon> userCardCouponList){
		List<ExportUserCardCoupon> list = new ArrayList<ExportUserCardCoupon>();
		for(UserCardCoupon item : userCardCouponList){
			ExportUserCardCoupon model = new ExportUserCardCoupon();
			model.setId(item.getId());
			switch (item.getCardType()){
			case Constants.CARD_COUPON_TYPE.SPQ:
				model.setCardType("商品券");break;
			case Constants.CARD_COUPON_TYPE.DJQ:
				model.setCardType("代金券");break;
			case Constants.CARD_COUPON_TYPE.MYFQ:
				model.setCardType("免运费券");break;
			}
			
			model.setCardName(item.getCardName());
			
			String sFormat = "yyyy-MM-dd HH:mm:ss";
			model.setValidTime(DateComFunc.formatDate(item.getUseStartTime(), sFormat) + "～" + DateComFunc.formatDate(item.getUseEndTime(), sFormat));
			model.setStartTime(DateComFunc.formatDate(item.getStartTime(), sFormat));
			model.setReceiveTime(DateComFunc.formatDate(item.getReceiveTime(), sFormat));
			model.setUseStatus(item.getUseStatus() == 1 ? "已使用":"未使用");
			model.setUserId(item.getUserId());
			model.setPhone(item.getPhone());
			model.setMallCode(item.getMallCode());
			model.setCardCouponPrice(item.getCardCouponPrice());
			model.setUseTime(DateComFunc.formatDate(item.getUseTime(), sFormat));
			model.setGroupId(item.getGroupId() == null ? null :item.getGroupId() + "");
			
			list.add(model);
		}
		return list;
	}

	/**
	 * 跳转到发放券码页
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toSendCardCoupon")
	public String toSendCardCoupon(Long cardId, String phone, String userId, Model model) {
		if (cardId == null || cardId.longValue() == 0) {
			model.addAttribute("message", "请选择要发放的记录!");
			return "redirect:/cardCoupon/select";
		}
		CardCoupon cardCoupon = cardCouponService.selectById(cardId);
		model.addAttribute("cardCoupon", cardCoupon);

		if (!Tools.isEmpty(phone) || !Tools.isEmpty(userId)) {
			UserCardCouponQuery userCardCouponQuery = new UserCardCouponQuery();
			userCardCouponQuery.setCardCouponId(cardId);
			if (!Tools.isEmpty(phone))
				userCardCouponQuery.setPhone("%" + phone + "%");
			userCardCouponQuery.setUserId(userId);
			// 选择会员列表
			List<SelectCustSendCardCoupon> selectCustSendCardCouponList = userCardCouponService
					.selectCustSendCardCoupon(userCardCouponQuery);
			model.addAttribute("selectCustSendCardCouponList", selectCustSendCardCouponList);
			model.addAttribute("phone", phone);
			model.addAttribute("userId", userId);
		}

		model.addAttribute("cardId", cardId);
		return "card_coupon/card_coupon_send_list";
	}

	/**
	 * 发放券码页发放操作
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sendCardCoupon")
	@ResponseBody
	public Object sendCardCoupon(String data, Long cardId, Integer surplusNum, Integer sendNumTotal, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		System.out.println("data:" + data);
		if (surplusNum != null && sendNumTotal != null) {
			if (sendNumTotal > surplusNum) {
				resMap.put("message", "本次发放数量已超过剩余可发放数量，请重新发放");
			}
		}
		if (!Tools.isEmpty(data)) {
			String[] dataArr = data.split(",");
			SelectCustSendCardCoupon[] selectCustSendCardCouponArray = new SelectCustSendCardCoupon[dataArr.length];
			for (int i = 0; i < dataArr.length; i++) {
				String s = dataArr[i];
				SelectCustSendCardCoupon selectCustSendCardCoupon = new SelectCustSendCardCoupon();
				selectCustSendCardCoupon.setUserId(s.split(":")[0]);
				selectCustSendCardCoupon.setWillSendNum(Integer.valueOf(s.split(":")[1]));

				selectCustSendCardCouponArray[i] = selectCustSendCardCoupon;
			}
			try {
				int row = userCardCouponService.insertBatch(selectCustSendCardCouponArray, cardId);
				if (row > 0) {
					resMap.put("message", "发放成功");
				}
			} catch (Exception e) {
				resMap.put("message", "系统错误");
			}
		}
		return resMap;
	}

	/**
	 * 取得第三方合作券列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectThird")
	public String getCardCouponThirdList(CardCouponQuery query, Model model) {
		if (!Tools.isEmpty(query.getCardName())) {
			query.setCardNameQuery("%" + query.getCardName() + "%");
		}
		if (!Tools.isEmpty(query.getStartTimeStr()))
			query.setStartTime(DateComFunc.strToDate(query.getStartTimeStr(), "yyyy-MM-dd"));
		if (!Tools.isEmpty(query.getEndTimeStr()))
			query.setEndTime(DateComFunc.strToDate(query.getEndTimeStr(), "yyyy-MM-dd"));

		List<CardCoupon> cardCouponList = cardCouponService.selectThirdByPageList(query);

		// 查询分页数据总数量
		int pnums = cardCouponService.countSelectThird(query);
		model.addAttribute("cardCouponList", cardCouponList);
		model.addAttribute("pnums", pnums);
		model.addAttribute("query", query);

		return "card_coupon/card_coupon_third_list";
	}

	/**
	 * 取得第三方合作券查看详情列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectThirdDetail")
	public String getCardCouponThirdDetailList(CardCouponThirdQuery query, Model model) {
		List<CardCouponThird> cardCouponThirdList = cardCouponService.selectThirdDetailByPageList(query);
		model.addAttribute("cardCouponThirdList", cardCouponThirdList);
		model.addAttribute("query", query);

		return "card_coupon/card_coupon_third_detail_list";
	}

	/**
	 * 客服核销操作
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/kefuVoucherVerification")
	public String kefuVoucherVerification(Long userCardCouponId, Long cardCouponId, Integer pageIndex, String phone, Integer useStatus) {
		UserCardCoupon userCardCoupon = new UserCardCoupon();
		userCardCoupon.setId(userCardCouponId);
		userCardCoupon.setUseStatus(Constants.CARD_USED_STATUS.KEFU_VERIFICATIONED);
		int row = userCardCouponService.updateUseStatusByPrimaryKey(userCardCoupon);

		String url = "redirect:toCheckCardCoupon?cardCouponId=" + cardCouponId + "&pageIndex=" + pageIndex + "&phone=" + phone;
		if(!Tools.isEmpty(useStatus)){
			url += "&useStatus="+useStatus;
		}
		return url;
	}

	/**
	 * 导出excel
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/exportCard")
	public void export(HttpServletRequest request, HttpServletResponse response, CardCouponQuery query) {

		// 设置导出flag为1
		query.setExportFlag(1);

		if (!Tools.isEmpty(query.getCardName())) {
			query.setCardNameQuery("%" + query.getCardName() + "%");
		}

		List<CardCoupon> cardCouponList = cardCouponService.selectThirdByPageList(query);

		ServletOutputStream out = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-excel");
			response.setCharacterEncoding("UTF-8");

			String filename = "第三方合作券列表" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
			ExportExcel<CardCoupon> ex = new ExportExcel<CardCoupon>();
			String[] headers = { "卡券ID", "创建时间", "卡券名称", "劵码/链接", "卡券类型(6.链接券/7.券码)", "发放数量", "开始时间", "结束时间" };
			out = response.getOutputStream();
			ex.exportExcel(headers, cardCouponList, out);
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
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response) {

		BufferedInputStream in = new BufferedInputStream(request.getSession().getServletContext()
				.getResourceAsStream("/template/第三方合作券.xls"));
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(response.getOutputStream());
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-excel");
			response.setCharacterEncoding("UTF-8");

			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("第三方合作券.xls", "UTF-8"));
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
	 * 导入第三方合作券
	 * lixinling 
	 * 2016年10月21日 下午10:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/importCardCouponThird")
	@ResponseBody
	public Object importProduct(HttpServletRequest request, MultipartFile file) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (file != null) {

			// 文件名
			String fileName = file.getOriginalFilename();

			// 后缀名
			String suffix = fileName.substring(fileName.lastIndexOf(Common.POINT) + 1);
			if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(suffix)) {
				try {
					List<CardCouponThird> list = readXls(file.getInputStream());
					SecUser user = (SecUser) request.getSession().getAttribute("user");
					cardCouponService.insertCardCouponThird(list, user.getLogin());
					resMap.put("message", "导入成功");
				} catch (Exception e) {
					resMap.put("message", "导入失败");
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

	public List<CardCouponThird> readXls(InputStream is) throws Exception {
		List<CardCouponThird> list = new ArrayList<CardCouponThird>();
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
					if (hssfRow == null) {
						continue;
					} else {
						HSSFCell nameCell = hssfRow.getCell(0);
						HSSFCell contentCell = hssfRow.getCell(1);
						HSSFCell typeCell = hssfRow.getCell(2);
						HSSFCell validStartTimeCell = hssfRow.getCell(3);
						HSSFCell validEndTimeCell = hssfRow.getCell(4);

						if (nameCell == null || typeCell == null || contentCell == null || validStartTimeCell == null
								|| validEndTimeCell == null)
							continue;

						String name = nameCell == null ? null : (String) ReadExcel.getValue(nameCell);
						String content = contentCell == null ? null : (String) ReadExcel.getValue(contentCell);
						Integer type = typeCell == null ? null : Integer.valueOf(typeCell.getStringCellValue());
						Date validStartTime = validStartTimeCell == null ? null : DateComFunc.strToDate(
								validStartTimeCell.getStringCellValue(), "yyyy-MM-dd");
						Date validEndTime = validEndTimeCell == null ? null : DateComFunc.strToDate(validEndTimeCell.getStringCellValue(),
								"yyyy-MM-dd");

						CardCouponThird cardCoupon = new CardCouponThird();
						cardCoupon.setName(name);
						cardCoupon.setContent(content);
						cardCoupon.setType(type);
						cardCoupon.setValidStartTime(validStartTime);
						cardCoupon.setValidEndTime(validEndTime);

						cardCoupon.setStatus(0);
						list.add(cardCoupon);
					}
				}
			}
			return list;
		}

	}

	/**
	 * 导入发放会员信息 
	 * lixinling 
	 * 2016年10月21日 下午10:23:04
	 * @param brand
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/importSendMember")
	@ResponseBody
	public Object importSendMember(HttpServletRequest request, MultipartFile file, Long cardId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (file != null) {

			// 文件名
			String fileName = file.getOriginalFilename();

			// 后缀名
			String suffix = fileName.substring(fileName.lastIndexOf(Common.POINT) + 1);
			if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(suffix)) {
				try {
					List<Map<String, String>> list = readXlsBySendMember(file.getInputStream());
					if (list != null && list.size() > 0) {
						List<Map<String,String>> userIdPhoneList = custMasterService.selectUserIdByPhone(list);
						SelectCustSendCardCoupon[] selectCustSendCardCouponArray = new SelectCustSendCardCoupon[userIdPhoneList.size()];
						
						Map<String, String> sendNumMap = new HashMap<String, String>();
						for(Map<String, String> map:list){
							//处理发放数量
							String phone = map.get("userPhone");
							sendNumMap.put(phone, map.get(phone));
						}
						
						for (int i = 0; i < userIdPhoneList.size(); i++) {
							Map<String, String> userIdPhoneMap = userIdPhoneList.get(i);
							SelectCustSendCardCoupon selectCustSendCardCoupon = new SelectCustSendCardCoupon();
							String userPhone = userIdPhoneMap.get("phone");
							selectCustSendCardCoupon.setUserId(userIdPhoneMap.get("user_id"));
							selectCustSendCardCoupon.setWillSendNum(Integer.valueOf(sendNumMap.get(userPhone)));

							selectCustSendCardCouponArray[i] = selectCustSendCardCoupon;
						}
						try {
							int row = userCardCouponService.insertBatch(selectCustSendCardCouponArray, cardId);
							if (row > 0) {
								resMap.put("message", "发放成功");
							}
						} catch (Exception e) {
							resMap.put("message", "系统错误");
						}
					}
				} catch (Exception e) {
					resMap.put("message", "发放失败 ");
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
			resMap.put("message", "导入失败。请选择正确的文件进行导入");
			logger.info("导入失败。请选择正确的文件进行导入。");
		}

		return resMap;
	}

	public List<Map<String, String>> readXlsBySendMember(InputStream is) throws IOException {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
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
					if (hssfRow == null) {
						continue;
					} else {
						HSSFCell userPhoneCell = hssfRow.getCell(0);
						HSSFCell sendNumCell = hssfRow.getCell(1);

						String userPhone = userPhoneCell == null ? null : (String) ReadExcel.getValue(userPhoneCell);
						String sendNum = sendNumCell == null ? "1" : sendNumCell.getStringCellValue();

						if(Tools.isEmpty(userPhone))
							continue;
						
						Map<String, String> map = new HashMap<String, String>();
						map.put("userPhone", userPhone);
						map.put(userPhone, sendNum);
						list.add(map);
					}
				}
			}

			return list;
		}

	}
}
