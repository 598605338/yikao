package com.linjia.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.linjia.base.controller.BaseController;
import com.linjia.constants.Application;
import com.linjia.tools.UploadImage;
import com.linjia.web.model.ActivityPintuanBase;
import com.linjia.web.model.ProductBannerImages;
import com.linjia.web.query.ActivityPintuanBaseQuery;
import com.linjia.web.service.ActivityPintuanBaseService;
import com.linjia.web.service.ProductBannerImagesService;
import com.linjia.web.service.ProductTagsService;

/**
 * 拼团模块
 * 
 * @author xiangsy
 *
 */
@Controller
@RequestMapping("/pintuan")
public class ActivityPintuanController extends BaseController{
	private static Logger LOG = LoggerFactory.getLogger(ActivityPintuanController.class);
	
	@Autowired
	private ActivityPintuanBaseService activityPintuanBaseService;
	@Autowired
	private ProductBannerImagesService productBannerImagesService;
	@Autowired
	private ProductTagsService productTagsService;
	
	/**
	 * 取得拼团商品列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPtBaseList")
	public String getPintuanProductList(HttpServletRequest request,ActivityPintuanBaseQuery query){
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createDate=query.getCreateTime();
			String createEndTime=query.getCreateEndTime();
			String activityDate=query.getActivityTimeStr();  
			String activityEndDate=query.getActivityEndTimeStr();
			if(createDate!=null&&!"".equals(createDate)){
				query.setCreDate(sdf.parse(createDate));
			}
			if(createEndTime!=null&&!"".equals(createEndTime)){
				query.setCreEndDate(sdf.parse(createEndTime));
			}
			if(activityDate!=null&&!"".equals(activityDate)){
				query.setStartTime(sdf.parse(activityDate));
			}
			if(activityEndDate!=null&&!"".equals(activityEndDate)){
				query.setEndTime(sdf.parse(activityEndDate));
			}
			List<ActivityPintuanBase> productList = activityPintuanBaseService.selectPtListManage(query);
			if(productList!=null){
				int productsNum = activityPintuanBaseService.selectPtListManageNum(query);
				query.setTotalNums(productsNum);
			}
			request.setAttribute("baseProducts", productList);
			request.setAttribute("query", query);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "查询出错");
			request.setAttribute("status", "error");
			e.printStackTrace();
		}
		
		return "activity_pintuan/pintuan_list";
	}
	
	/**
	 * 根据id取得拼团商品详情信息
	 * 
	 * @param id 商品id
	 * @return
	 */
	@RequestMapping("/getPtBaseInfo")
	public String getPintuanProductDetailInfo(HttpServletRequest request,int id){
		try{
			//取得基本信息
			ActivityPintuanBase activityPintuanBase = activityPintuanBaseService.selectDetailById(id);
			
			if(activityPintuanBase!=null){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date start=activityPintuanBase.getStartTime();
				Date end =activityPintuanBase.getEndTime();
				if(start!=null){
					activityPintuanBase.setStartTimeStr(sdf.format(start));
				}
				if(end!=null){
					activityPintuanBase.setEndTimeStr(sdf.format(end));
				}
				long productId = activityPintuanBase.getProductId();
				
				//取得商品轮播图
				List<ProductBannerImages> bannerList = productBannerImagesService.selectAllByProductId(productId);
				activityPintuanBase.setBannerList(bannerList);
				
				//取得商品标签
				List<String> tagList = productTagsService.selectTagsByProductId(productId);
				activityPintuanBase.setTagList(tagList);
				request.setAttribute("BaseDetail", activityPintuanBase);
				request.setAttribute("status", "ok");
			}
		}catch(Exception e){
			request.setAttribute("message", "查询拼团商品详情出错！");
			request.setAttribute("status", "error");
			e.printStackTrace();
			return "redirect:/pintuan/getPtBaseList?pageIndex=1";
		}
		return "activity_pintuan/pintuan_detail";
	}
	
	/**
	 * 添加拼团商品
	 * @return
	 */
	@RequestMapping("/addBaseInfo")
	public String addBaseInfo(HttpServletRequest request,ActivityPintuanBase baseInfo){
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String beginDate=baseInfo.getStartTimeStr();
			String endDate=baseInfo.getEndTimeStr();  
			if(beginDate!=null&&(!beginDate.isEmpty())){
				baseInfo.setStartTime(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				baseInfo.setEndTime(sdf.parse(endDate));
			}
//			ProductSpec productSpec=new ProductSpec();
//			productSpec.setBussinessCode("");
//			productSpec.setGiveScore(baseInfo.getGiveScore());
//			productSpec.setProductId(baseInfo.getProductId());
//			productSpec.setSafeQuantity(baseInfo.getQuantity());
//			productSpec.setUnit("个");
//			baseInfo.setProductSpec(productSpec);
			if (baseInfo.getUploadImage() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String uploadPath = UploadImage.uploadProductImage(realPath,baseInfo.getUploadImage());
				baseInfo.setImagePath(uploadPath);
			}
			String bImg=baseInfo.getImagePath();
			if(bImg==null||bImg.isEmpty()){
				String img2=baseInfo.getImagePath2();
				if(img2!=null||(!img2.isEmpty())){
					String img=img2.replaceFirst(Application.SERVER_BASE_PATH,"");
					baseInfo.setImagePath(img);
				}
			}	
			boolean b= activityPintuanBaseService.insertPtBase(baseInfo);
			if(b){
				request.setAttribute("message", "添加成功");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message", "添加拼团商品失败！");
				request.setAttribute("baseInfo", baseInfo);
				request.setAttribute("status", "fail");
				return "activity_pintuan/pintuan_add";
			}
		}catch(Exception e){
			request.setAttribute("message", "添加拼团商品出错！");
			request.setAttribute("baseInfo", baseInfo);
			request.setAttribute("status", "error");
			e.printStackTrace();
			return "activity_pintuan/pintuan_add";
		}
		
		return "redirect:/pintuan/getPtBaseList?pageIndex=1";
	}
	
	/**
	 * 批量删除拼团商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/delPtProducts")
	public String delPtProducts(HttpServletRequest request,@RequestParam String baseIds){
		try{
			int j=0;
			if(baseIds!=null&&(!baseIds.isEmpty())){
				System.out.println("baseIds:"+baseIds);
				String[] idStr=baseIds.split(",");
				for (String idAndPid : idStr) {
					String[] idAndPidArr=idAndPid.split("@");
					String id=idAndPidArr[0];
					if(id!=null&&!id.isEmpty()){
						int idInt=Integer.parseInt(id);
						boolean falg=activityPintuanBaseService.delPtProducts(idInt);
						if(falg){
							j++;
						}
					}
				}
			}
			request.setAttribute("delNums", j);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "删除失败！");
			request.setAttribute("status", "error");
			e.printStackTrace();
		}
		return "redirect:/pintuan/getPtBaseList?pageIndex=1";
	}
	
	/**
	 * 批量上下架门店商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/onlinePtProducts")
	public String onlinePtProducts(HttpServletRequest request,@RequestParam String baseIds,@RequestParam String type){
		try{
			int j=0;
			if(baseIds!=null&&(!baseIds.isEmpty())){
				System.out.println("baseIds:"+baseIds);
				String[] idStr=baseIds.split("-");
				for (String idAndPid : idStr) {
						if(idAndPid!=null&&!idAndPid.isEmpty()){
							String[] idAndPidArr=idAndPid.split("@");
							String id=idAndPidArr[0];
							String pid=idAndPidArr[1];
							Long idLong=Long.valueOf(id);
							Long pidLong=Long.valueOf(pid);
						if(type!=null&&(!type.isEmpty())){
							ActivityPintuanBase base=new ActivityPintuanBase();
							base.setProductId(pidLong);
							base.setId(idLong);
							if("1".equals(type)){
								base.setOnline(true);
							}else if("2".equals(type)){
								base.setOnline(false);
							}
							boolean falg=activityPintuanBaseService.updateBaseProduct(base);
							if(falg){
								j++;
							}
						}
					}
				}
			}
			request.setAttribute("Nums", j);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "上下架失败！");
			request.setAttribute("status", "error");
			e.printStackTrace();
		}
		return "redirect:/pintuan/getPtBaseList?pageIndex=1";
	}
	
	/**
	 * 更新拼团商品
	 * @return
	 */
	@RequestMapping("/updBaseInfo")
	public String updBaseInfo(HttpServletRequest request,ActivityPintuanBase baseInfo){
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String beginDate=baseInfo.getStartTimeStr();
			String endDate=baseInfo.getEndTimeStr();  
			if(beginDate!=null&&(!beginDate.isEmpty())){
				baseInfo.setStartTime(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				baseInfo.setEndTime(sdf.parse(endDate));
			}
//			ProductSpec productSpec=new ProductSpec();
//			productSpec.setBussinessCode("");
//			productSpec.setGiveScore(baseInfo.getGiveScore());
//			productSpec.setProductId(baseInfo.getProductId());
//			productSpec.setSafeQuantity(baseInfo.getQuantity());
//			productSpec.setUnit("个");
//			baseInfo.setProductSpec(productSpec);
//			baseInfo.setIfUpdSpec(true);
			if (baseInfo.getUploadImage() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String uploadPath = UploadImage.uploadProductImage(realPath,baseInfo.getUploadImage());
				baseInfo.setImagePath(uploadPath);
			}
			boolean b= activityPintuanBaseService.updateBaseProduct(baseInfo);
			if(b){
				request.setAttribute("message", "更新成功");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message", "更新拼团商品失败！");
				request.setAttribute("baseInfo", baseInfo);
				request.setAttribute("status", "fail");
				return "activity_pintuan/pintuan_add";
			}
		}catch(Exception e){
			request.setAttribute("message", "更新拼团商品出错！");
			request.setAttribute("baseInfo", baseInfo);
			request.setAttribute("status", "error");
			e.printStackTrace();
			return "activity_pintuan/pintuan_edit";
		}
		return "redirect:/pintuan/getPtBaseList?pageIndex=1";
	}
}
