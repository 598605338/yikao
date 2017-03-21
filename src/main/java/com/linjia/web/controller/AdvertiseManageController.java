package com.linjia.web.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import com.linjia.base.controller.BaseController;
import com.linjia.tools.JSONUtil;
import com.linjia.tools.UploadImage;
import com.linjia.tools.Util;
import com.linjia.web.model.ActivityAdvertise;
import com.linjia.web.model.AdvertisePosition;
import com.linjia.web.model.BannerInfo;
import com.linjia.web.service.AdvertiseManageService;

/**
 * 广告管理模块
 * 
 * @author xiangsy
 *
 */
@Controller
@RequestMapping("/advManage")
public class AdvertiseManageController extends BaseController{
	
	private static Logger LOG = LoggerFactory.getLogger(AdvertiseManageController.class);
	
	@Autowired
	private AdvertiseManageService advertiseManageService;
	
	/**
	 * 插入广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertAdvInfo")
	@ResponseBody
	public Object insertAdvInfo(HttpServletRequest request,AdvertisePosition info){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=advertiseManageService.insertAdvInfo(info);
		map.put("resultData", info);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 更新广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateAdvInfoById")
	public String updateAdvInfoById(HttpServletRequest request,AdvertisePosition info){
		try{
			if (info.getUploadImage() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String uploadPath = UploadImage.uploadProductImage(realPath,info.getUploadImage());
				info.setPicture(uploadPath);
			}
			boolean b=advertiseManageService.updateAdvInfoById(info);
			if(b){
				request.setAttribute("message", "更新成功！");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message", "更新失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "redirect:/advManage/selectAdvInfoAll";
	}
	
	/**
	 * 删除广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteAdvInfoById")
	@ResponseBody
	public Object deleteAdvInfoById(HttpServletRequest request,@RequestParam int id){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=advertiseManageService.deleteAdvInfoById(id);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 查询单条广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectAdvInfoById")
	public String selectAdvInfoById(HttpServletRequest request,int id){
		AdvertisePosition info=null;
		try{
			info=advertiseManageService.selectAdvInfoById(id);
			request.setAttribute("advitise", info);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "advitise_manage/advitise_position_edit";
	}
	
	/**
	 * 查询多条广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectAdvInfoAll")
	public String selectAdvInfoAll(HttpServletRequest request){
		List<AdvertisePosition> list=null;
		try{
			list=advertiseManageService.selectAdvInfoAll();
			request.setAttribute("advlist", list);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "advitise_manage/advitise_position_list";
	}
	
	
	
	/**
	 * 插入Banner数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertBannerInfo")
	public String insertBannerInfo(HttpServletRequest request,BannerInfo info){
		String idAndType="?ad_id="+info.getAd_id()+"&ad_type="+info.getAd_type();
		try{
			if (info.getUploadImage() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String uploadPath = UploadImage.uploadProductImage(realPath,info.getUploadImage());
				info.setBan_picture(uploadPath);
			}
			boolean b=advertiseManageService.insertBannerInfo(info);
			if(!b){
				request.setAttribute("message", "插入失败!");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "redirect:/advManage/selectBannerInfoAll"+idAndType;
	}
	
	/**
	 * 更新Banner数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateBannerInfoById")
	public String updateBannerInfoById(HttpServletRequest request,BannerInfo info){
		if (info.getUploadImage() != null) {
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = UploadImage.uploadProductImage(realPath,info.getUploadImage());
			info.setBan_picture(uploadPath);
		}
		String idAndType="";
		try{
			boolean b=advertiseManageService.updateBannerInfoById(info);
			if(b){
				idAndType="?ad_id="+info.getAd_id()+"&ad_type="+info.getAd_type();
				request.setAttribute("message", "更新成功！");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message", "更新失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "redirect:/advManage/selectBannerInfoAll"+idAndType;
	}
	
	/**
	 * 删除Banner数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteBannerInfoById")
	public String deleteBannerInfoById(HttpServletRequest request,int id,int ad_id,int ad_type){
		String idAndType="";
		try{
			boolean b=advertiseManageService.deleteBannerInfoById(id);
			if(b){
				//更新广告表数据
				AdvertisePosition info=new AdvertisePosition();
				info.setDownNums(1);
				info.setId(ad_id);
				boolean m=advertiseManageService.updateAdvInfoById(info);
				if(m){
					idAndType="?ad_id="+ad_id+"&ad_type="+ad_type;
					request.setAttribute("message", "删除成功！");
					request.setAttribute("status", "ok");
				}else{
					request.setAttribute("message", "更新主表失败！");
					request.setAttribute("status", "ok");
				}
			}else{
				request.setAttribute("message", "删除失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "redirect:/advManage/selectBannerInfoAll"+idAndType;
	}
	
	/**
	 * 查询单条Banner数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectBannerInfoById")
	public String selectBannerInfoById(HttpServletRequest request,int id){
		BannerInfo info=null;
		String pageUrl="";
		try{
			info=advertiseManageService.selectBannerInfoById(id);
			if(info!=null&&info.getAd_type()==1){
				pageUrl="advitise_manage/banner_edit";
			}else{
				pageUrl="advitise_manage/new_goods_edit";
			}
			request.setAttribute("bannerInfo",info);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return pageUrl;
	}
	
	/**
	 * 查询多条Banner数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectBannerInfoAll")
	public String selectBannerInfoAll(HttpServletRequest request,int ad_id,int ad_type){
		List<BannerInfo> list=null;
		Map<String,Object> map=new HashMap<String, Object>();
		String pageUrl="";
		try{
			if(ad_type==1){
				pageUrl="advitise_manage/banner_list";
				request.setAttribute("ad_id", ad_id);
			}else{
				pageUrl="advitise_manage/new_goods_list";
				request.setAttribute("ad_id", ad_id);
			}
			map.put("ad_id", ad_id);
			map.put("ad_type", ad_type);
			list=advertiseManageService.selectBannerInfoAll(map);
			
			request.setAttribute("bannerlist", list);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return pageUrl;
	}
	
	/**
	 * 插入活动广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertAyAdvInfo")
	public String insertAyAdvInfo(HttpServletRequest request,ActivityAdvertise info){
		try{
			boolean b=advertiseManageService.insertAyAdvInfo(info);
			if(b){
				request.setAttribute("message", "添加成功！");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message", "添加失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message","添加异常");
			request.setAttribute("status", "error");
			request.setAttribute("actAdvitise", info);
			e.printStackTrace();
			return "advitise_manage/advitise_act_add";
		}
		return "redirect:/advManage/selectAdvPageAll";
	}
	
	/**
	 * 更新活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateAyAdvInfoById")
	public String updateAyAdvInfoById(HttpServletRequest request,ActivityAdvertise info){
		try{
			if (info.getUploadImage() != null) {
				String realPath = request.getSession().getServletContext().getRealPath("/");
				String uploadPath = UploadImage.uploadProductImage(realPath,info.getUploadImage());
				info.setPicture(uploadPath);
			}
			boolean b=advertiseManageService.updateAyAdvInfoById(info);
			if(b){
				request.setAttribute("message", "更新成功！");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message", "更新失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			request.setAttribute("actAdvitise", info);
			e.printStackTrace();
			return "advitise_manage/advitise_act_edit";
		}
		return "redirect:/advManage/selectAyAdvInfoAll";
	}
	
	/**
	 * 删除活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteAyAdvInfoById")
	public String deleteAyAdvInfoById(HttpServletRequest request,int id){
		try{
			boolean b=advertiseManageService.deleteAyAdvInfoById(id);
			if(b){
				request.setAttribute("message", "删除成功！");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message", "删除失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message", "删除异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "redirect:/advManage/selectAyAdvInfoAll";
	}
	
	/**
	 * 查询活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectAyAdvInfoById")
	public String selectAyAdvInfoById(HttpServletRequest request,int id){
		ActivityAdvertise info=null;
		try{
			info=advertiseManageService.selectAyAdvInfoById(id);
			request.setAttribute("actAdvitise", info);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "advitise_manage/advitise_act_edit";
	}
	
	/**
	 * 查询多个活动广告基本信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectAyAdvInfoAll")
	public String selectAyAdvInfoAll(HttpServletRequest request){
		List<ActivityAdvertise> list=null;
		try{
			list=advertiseManageService.selectAyAdvInfoAll();
			request.setAttribute("actAdvlist", list);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "advitise_manage/advitise_act_list";
	}
	
	/**
	 *文件上传
	 * @param request
	 * @return
	 */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public Object uploadFile(HttpServletRequest request) {  
		Map<String, Object> map = new HashMap<String, Object>();
		try {  
			if (request instanceof DefaultMultipartHttpServletRequest) {
				MultipartFile file = ((MultipartRequest) request).getFile("file");
				if(file!=null){
					System.out.println("开始");  
					//保存在apache-tomcat-7.0.70/webapps/linjia_1/upload文件夹下
			        String path = request.getSession().getServletContext().getRealPath("upload")+"\\";  
			        String fileName = file.getOriginalFilename();  
//		        String fileName = new Date().getTime()+".jpg";
//					String fileName = UUID.randomUUID() + orignName.substring(orignName.indexOf("."));
					File picFile = new File(path+fileName);
					if(!picFile.exists()){  
						picFile.mkdirs();  
				    } 
			        //保存  
			        file.transferTo(picFile);
			        String fileUrl=path+fileName;
			        map.put("status", "ok");
			        map.put("message", "上传文件成功！");
			        map.put("fileUrl", fileUrl);
				}
			}  
		} catch (Exception e) {  
			map.put("status", "fail");
			map.put("message", "上传文件错误！");
			e.printStackTrace();  
		}  
	   return map;
	}
	
	/**
	 *生成html文件
	 * @param request
	 * @return
	 */
	@RequestMapping("/createHtml")
	public String createHtml(HttpServletRequest request,String htmlContent) {  
		try {  
			//获取tomcate下webapps路径
			String realPath =request.getSession().getServletContext().getRealPath("/");
			
			String filePath=Util.createHtml(realPath, htmlContent,"myTest");
				if(filePath!=null){
					request.setAttribute("status", "ok");
					request.setAttribute("message", "生成html文件成功！");
					request.setAttribute("fileUrl", filePath);
				}else{
					request.setAttribute("status", "error");
					request.setAttribute("message", "上传的文件内容错误！");
				} 
		}catch (Exception e) {
			request.setAttribute("status", "error");
			request.setAttribute("message", "生成html文件错误！");
			e.printStackTrace();
		} 
	   return "";
	}
	
	/**
	 * 批量更新Banner数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updBatchBaseInfos")
	public String updBatchBaseInfos(HttpServletRequest request,BannerInfo info){
		if (info.getUploadImage() != null) {
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = UploadImage.uploadProductImage(realPath,info.getUploadImage());
			info.setBan_picture(uploadPath);
		}
		String idAndType="";
		try{
			List<BannerInfo> list=JSONUtil.json2List(info.getBaseInfos(), BannerInfo.class);
			if(list!=null&&list.size()>0){
				boolean b=advertiseManageService.updBatchBaseInfos(list);
				if(b){
					idAndType="?ad_id="+info.getAd_id()+"&ad_type="+info.getAd_type();
					request.setAttribute("message", "更新成功！");
					request.setAttribute("status", "ok");
				}else{
					request.setAttribute("message", "更新失败！");
					request.setAttribute("status", "fail");
				}
			}else{
				request.setAttribute("message", "传入数据异常");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "redirect:/advManage/selectBannerInfoAll"+idAndType;
	}
}
