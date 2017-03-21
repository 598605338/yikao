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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import com.linjia.base.controller.BaseController;
import com.linjia.tools.Util;
import com.linjia.web.model.AdvitisePage;
import com.linjia.web.service.AdvertisePageService;

/**
 * 页面制作管理模块
 * 
 * @author xiangsy
 *
 */
@Controller
@RequestMapping("/advPage")
public class AdvertisePageController extends BaseController{
	
	private static Logger LOG = LoggerFactory.getLogger(AdvertisePageController.class);
	
	@Autowired
	private AdvertisePageService advertisePageService;
	
	/**
	 * 插入广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertAdvPage")
	public String insertAdvPage(HttpServletRequest request,AdvitisePage info){
		Integer id=null;
		try{
			boolean b=advertisePageService.insertAdvPage(info);
			if(b){
				request.setAttribute("message", "添加成功！");
				request.setAttribute("status", "ok");
				id=info.getId();
				if(id!=null){
					request.setAttribute("pageInfo", info);
					return "advitise_manage/pageUeditor";
				}
			}else{
				request.setAttribute("message", "添加失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("message","添加异常");
			request.setAttribute("status", "error");
			request.setAttribute("pageInfo", info);
			e.printStackTrace();
			return "advPage/advitise_page_add";
		}
		return "redirect:/advPage/selectAdvPageAll";
	}
	
	/**
	 * 更新广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateAdvPageById")
	public String updateAdvPageById(HttpServletRequest request,AdvitisePage info){
		try{
			boolean b=advertisePageService.updateAdvPageById(info);
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
		return "redirect:/advPage/selectAdvPageAll";
	}
	
	/**
	 * 删除广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteAdvPageById")
	public Object deleteAdvPageById(HttpServletRequest request,int id){
		try{
			boolean b=advertisePageService.deleteAdvPageById(id);
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
		return "redirect:/advPage/selectAdvPageAll";
	}
	
	/**
	 * 查询单条广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectAdvPageById")
	public String selectAdvPageById(HttpServletRequest request,int id){
		AdvitisePage info=null;
		try{
			info=advertisePageService.selectAdvPageById(id);
			request.setAttribute("advitisePage", info);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "advitise_manage/advitise_page_edit";
	}
	
	/**
	 * 查询多条广告信息数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectAdvPageAll")
	public String selectAdvPageAll(HttpServletRequest request){
		List<AdvitisePage> list=null;
		try{
			list=advertisePageService.selectAdvPageAll();
			request.setAttribute("advPagelist", list);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("message", "异常");
			request.setAttribute("status", "ok");
			e.printStackTrace();
		}
		return "advitise_manage/advitise_page_list";
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
	public String createHtml(HttpServletRequest request,AdvitisePage info) {  
		try {  
			//获取tomcate下webapps路径
			String realPath =request.getSession().getServletContext().getRealPath("/");
			boolean flag=false;
			String filePath=Util.createHtml(realPath, info.getHtmlContent(),info.getPage_name());
				if(filePath!=null){
					if(info.getId()!=null){
						info.setPage_link(filePath);
						info.setPage_type(1);
						flag=advertisePageService.updateAdvPageById(info);
					}
				}
				
				if(flag){
					request.setAttribute("status", "ok");
					request.setAttribute("message", "生成html文件成功！");
				}else{
					request.setAttribute("status", "error");
					request.setAttribute("message", "上传的文件内容错误！");
				}
		}catch (Exception e) {
			request.setAttribute("status", "error");
			request.setAttribute("message", "生成html文件错误！");
			e.printStackTrace();
		} 
		return "redirect:/advPage/selectAdvPageAll";
	}
}
