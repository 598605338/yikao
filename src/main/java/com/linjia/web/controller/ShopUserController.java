package com.linjia.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.linjia.constants.Application;
import com.linjia.constants.Constants;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.HttpRequestUtil;
import com.linjia.tools.MallMasterToLBSMap;
import com.linjia.tools.Util;
import com.linjia.web.model.MallMaster;
import com.linjia.web.model.MallProductStore;
import com.linjia.web.model.ReMallProduct;
import com.linjia.web.model.ShopUser;
import com.linjia.web.poi.Common;
import com.linjia.web.poi.ExportExcel;
import com.linjia.web.poi.ReadExcel;
import com.linjia.web.query.MallMasterQuery;
import com.linjia.web.query.ReMallProductQuery;
import com.linjia.web.query.ShopUserQuery;
import com.linjia.web.service.MallMasterService;
import com.linjia.web.service.MallProductStoreService;
import com.linjia.web.service.ShopUserService;

/** 
 * @author  xiangsy: 
 * @date 2016年8月30日 下午4:16:39 
 * @version 1.0 
 */
@Controller
@RequestMapping("/shop")
public class ShopUserController {
	
	@Autowired
	private ShopUserService shopUserService;
	@Autowired
	private MallMasterService mallMasterService;
	@Autowired
	private MallProductStoreService mallProductStoreService;
	@Autowired
	private ReadExcel readExcel;
	
	/**
	 * 查询店铺列表(测试)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/mallList")
	@ResponseBody
	public Object mallList(HttpServletRequest request,@RequestParam String mall_name,@RequestParam String pageIndex){
		ShopUserQuery query=new ShopUserQuery();
		query.setMall_name(mall_name);
		int pg=0;
		if(pageIndex!=null&&(!pageIndex.isEmpty())){
			pg=Integer.parseInt(pageIndex);
		}
		query.setPageIndex(pg);
		List<ShopUser> shopList=shopUserService.selectShopList(query);
		int shopSize=shopUserService.selectShopNum();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("shopList",shopList);
//		return "shop/queryShoplist";
		return map;
	}
	
	/**
	 * 查询店铺列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/shopList")
	public String shopList(HttpServletRequest request,MallMasterQuery query){
		try{
			List<MallMaster> shopList=mallMasterService.selectSendPriceByRegion(query);
			if(shopList!=null){
				int num=mallMasterService.selectSendPriceByRegionNum(query);
				query.setTotalNums(num);
			}
			request.setAttribute("shopList",shopList);
			request.setAttribute("query",query);
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "查询出错!");
			e.printStackTrace();
		}
		return "mall/mall_list";
	}
	
	/**
	 * 查询门店商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryShopProducts")
	public String queryShopProducts(HttpServletRequest request,ReMallProductQuery query){
		try{
			List<ReMallProduct> mallProList=mallMasterService.selectMallProduct(query);
			for (ReMallProduct reMallProduct : mallProList) {
				int quantity=Util.queryQtyByStore(reMallProduct.getMall_code(),reMallProduct.getP_code());
				reMallProduct.setQuantity(quantity);
			}
			if(mallProList!=null){
				//查询商品总数
				int mallNums=mallMasterService.selectProductNum(query);
				query.setTotalNums(mallNums);
			}
			request.setAttribute("query", query);
			request.setAttribute("shopProducts", mallProList);
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "查询出错!");
			e.printStackTrace();
		}
		return "mall/mall_product_list";
	}
	
	/**
	 * 批量删除门店商品
	 * @param request
	 * @return
	 */
	@RequestMapping("/delShopProducts")
	public String delShopProducts(HttpServletRequest request,@RequestParam String mpCOdes){
		try{
			int j=0;
			if(mpCOdes!=null&&(!mpCOdes.isEmpty())){
				System.out.println("mpCOdes:"+mpCOdes);
				String[] mpStr=mpCOdes.split("-");
				for (String mp : mpStr) {
					String[] cp=mp.split("@");
					String mall_code=cp[0];
					String p_code=cp[1];
					ReMallProduct mallProduct=new ReMallProduct(mall_code,p_code);
					int num=mallProductStoreService.deleteMallProduct(mallProduct);
					if(num>0){
						j++;
					}
				}
			}
			request.setAttribute("delNums", j);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("status", "fail");
			return "mall/mall_product_list";
		}
		return "redirect:/shop/queryShopProducts";
	}
	
	/**
	 * 批量上下架门店商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/onlineShopProducts")
	public String onlineShopProducts(HttpServletRequest request,@RequestParam String mpCOdes,@RequestParam String type){
		try{
			int j=0;
			if(mpCOdes!=null&&(!mpCOdes.isEmpty())){
				System.out.println("mpCOdes:"+mpCOdes);
				String[] mpStr=mpCOdes.split("-");
				for (String mp : mpStr) {
					String[] cp=mp.split("@");
					String mall_code=cp[0];
					String p_code=cp[1];
					if(type!=null&&(!type.isEmpty())){
						ReMallProduct mallProduct=new ReMallProduct(mall_code,p_code);
						if("1".equals(type)){
							mallProduct.setOnline(1);
						}else if("2".equals(type)){
							mallProduct.setOnline(0);
						}
						int num=mallProductStoreService.updateMallProduct(mallProduct);
						if(num>0){
							j++;
						}
					}
				}
			}
			request.setAttribute("Nums", j);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("status", "fail");
			request.setAttribute("message", "操作异常!");
		}
		return "redirect:/shop/queryShopProducts";
	}
	
	/**
	 * 单个上下架门店商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/onlineShopOneProducts")
	public String onlineShopOneProducts(HttpServletRequest request,@RequestParam String mall_code,@RequestParam String p_code,@RequestParam String type){
		try{
			if(p_code!=null&&(!p_code.isEmpty())&&mall_code!=null&&(!mall_code.isEmpty())){
					if(type!=null&&(!type.isEmpty())){
						ReMallProduct mallProduct=new ReMallProduct(mall_code,p_code);
						if("1".equals(type)){
							mallProduct.setOnline(1);
						}else if("2".equals(type)){
							mallProduct.setOnline(0);
						}else{
							request.setAttribute("message", "操作失败!");
							request.setAttribute("status", "ok");
							return "redirect:/shop/queryShopProducts";
						}
						int num=mallProductStoreService.updateMallProduct(mallProduct);
						if(num>0){
							request.setAttribute("message", "操作失败!");
							request.setAttribute("status", "ok");
						}
					}
			}
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("status", "fail");
			return "mall/mall_product_list";
		}
		return "redirect:/shop/queryShopProducts";
	}
	
	/**
	 * 添加门店
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addShop")
	public String addShop(HttpServletRequest request,MallMaster mallMaster){
		try{
		boolean flag=mallMasterService.insertMallMaster(mallMaster);
		if(flag){
			request.setAttribute("message","添加成功！");
			request.setAttribute("status", "ok");
		}else{
			request.setAttribute("message","添加失败！");
			request.setAttribute("status", "fail");
			request.setAttribute("mall", mallMaster);
			return "mall/mall_add";
		}
	}catch(Exception e){
		request.setAttribute("status", "error");
		request.setAttribute("mall", mallMaster);
		return "mall/mall_add";
	}
		return "redirect:/shop/shopList";
	}
	
	/**
	 * 批量插入门店商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addShopProducts")
	public String addShopProducts(HttpServletRequest request){
		List<ReMallProduct> mallProList=new ArrayList<ReMallProduct>();
		int j=0;
		for (ReMallProduct mallProduct : mallProList) {
			int num=mallProductStoreService.insertMallProduct(mallProduct);
			if(num>0){
				j++;
			}
		}
		return "shop/addShopproducts";
	}
	
	/**
	 * 设置单个门店商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updShopProducts")
	public String updShopProducts(HttpServletRequest request,ReMallProduct mallProduct){
		try{
			int num=mallProductStoreService.updateMallProduct(mallProduct);
			if(num>0){
				request.setAttribute("message","添加成功！");
				request.setAttribute("status", "ok");
			}else{
				request.setAttribute("message","添加失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "更新异常");
		}
		return "shop/updShopproducts";
	}
	
	/**
	 * 批量设置门店商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateBatchProducts")
	@ResponseBody
	public Object updateBatchProducts(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		String fileUrl="";
		int j=0;
		try {
			if (request instanceof DefaultMultipartHttpServletRequest) {
				MultipartFile file = ((MultipartRequest) request).getFile("file");
				if(file!=null){
					// 文件名
					String fileName1 = file.getOriginalFilename();
					// 后缀名
					String suffix = fileName1.substring(fileName1.lastIndexOf(Common.POINT) + 1);
					if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(suffix)) {	
						//保存在apache-tomcat-7.0.70/webapps/linjia_1/upload文件夹下
				        String path=request.getSession().getServletContext().getRealPath("upload")+"\\";
	//			        String fileName = file.getOriginalFilename();
				        String dateStr=DateComFunc.formatDate(new Date(), "yyyyMMdd");
				        String fileName ="mallSetProducts"+dateStr+".xls";
	//		        	String fileName = new Date().getTime()+".jpg";
	//					String fileName = UUID.randomUUID() + orignName.substring(orignName.indexOf("."));
						File picFile = new File(path+fileName);
						if(picFile.exists()){  
							picFile.delete();
					    }
						picFile.mkdirs();  
				        //保存  
						file.transferTo(picFile);
				        fileUrl=path+fileName;
				        
				        File f=new File(fileUrl);
				        if(f.exists()){
						    List<MallProductStore> list = (List<MallProductStore>) readExcel.readExcel(fileUrl,2);
//						    if (list != null) {
//						        for (MallProductStore mallPro : list) {
//						            System.out.println("MallCode: " + mallPro.getMallCode() + ", pCode : " + mallPro.getpCode() + ", SalePrice : " +mallPro.getSalePrice()+", marketPrice : " +mallPro.getMarketPrice()+ ", SafeQuantity : " + mallPro.getSafeQuantity()+", Quantity:" + mallPro.getQuantity()+ ", Online:" + mallPro.getOnline());
//						        }
//						    }
						    if(list!=null&&list.size()>0){
//						       int num=mallProductStoreService.updateBatchProducts(list);
						       int num=0;
				        		//数组拆分
				        		List<List<MallProductStore>> sublist=Util.bigListSub(list);
				        		int i=1;
				        		for (List<MallProductStore> list2 : sublist) {
				        			num=mallProductStoreService.updateBatchProducts(list2);
				        			i++;
				        		}
						        if(num>0){
						           j=list.size();
						           map.put("status", "ok");
						           map.put("message", "导入成功！");
						           map.put("nums",j);
						        }else{
						           map.put("status", "fail");
						           map.put("message", "导入数据为空！");
						        }
						    }else{
						    	map.put("status", "fail");
						    	map.put("message", "数据格式有误,未读取到文档内数据！");
						    }
				        }
					} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(suffix)) {
						map.put("status", "fail");
						request.setAttribute("message", "请下载模板进行导入，暂不支持xlsx类型文件导入。");
						// 预留
						// readXlsx(file.getInputStream());
					} else {
						map.put("status", "fail");
						map.put("message", "导入失败,选择的文件格式不正确。");
					}  
				}else{
					map.put("status", "fail");
					map.put("message", "请选择xls文件上传!");
				}
			}
		}catch(FileNotFoundException fe){
			map.put("message", "文件读取失败！");
			map.put("status", "error");
//		     fe.printStackTrace();
		    return map;
		} catch (IllegalStateException | IOException e) {
			 map.put("status", "error");
			 map.put("message", "文件上传失败！");
//		     e.printStackTrace();
		     return map;
		}
		return map;
	}
	
	/**
	 *门店商品批量导入
	 * @param request
	 * @return
	 */
	@RequestMapping("/leadInProducts")
	@ResponseBody
	public Object leadInProducts(HttpServletRequest request) {  
		Map<String,Object> map=new HashMap<String, Object>();
		String fileUrl="";
		int j=0;
		try {
			if (request instanceof DefaultMultipartHttpServletRequest) {
				MultipartFile file = ((MultipartRequest) request).getFile("file");
				if(file!=null){
					// 文件名
					String fileName1 = file.getOriginalFilename();
					// 后缀名
					String suffix = fileName1.substring(fileName1.lastIndexOf(Common.POINT) + 1);
					if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(suffix)) {	
						//保存在apache-tomcat-7.0.70/webapps/linjia_1/upload文件夹下
				        String path=request.getSession().getServletContext().getRealPath("upload")+"\\";
	//			        String fileName = file.getOriginalFilename();
				        String dateStr=DateComFunc.formatDate(new Date(), "yyyyMMdd");
				        String fileName ="mallProducts"+dateStr+".xls";
	//		        	String fileName = new Date().getTime()+".jpg";
	//					String fileName = UUID.randomUUID() + orignName.substring(orignName.indexOf("."));
						File picFile = new File(path+fileName);
						if(picFile.exists()){  
							picFile.delete();
					    }
						picFile.mkdirs();  
				        //保存  
						file.transferTo(picFile);
				        fileUrl=path+fileName;
				        File f=new File(fileUrl);
				        if(f.exists()){
				        	List<MallProductStore> list = (List<MallProductStore>) readExcel.readExcel(fileUrl,1);
	//					    if (list != null) {
	//					        for (MallProductStore mallPro : list) {
	//					            System.out.println("MallCode: " + mallPro.getMallCode() + ", pCode : " + mallPro.getpCode() + ", SalePrice : " +mallPro.getSalePrice()+ ", SafeQuantity : " + mallPro.getSafeQuantity()+ ", Online:" + mallPro.getOnline());
	//					        }
	//					    }
				        	if(list!=null&&list.size()>0){
				        		int num=0;
				        		//数组拆分
				        		List<List<MallProductStore>> sublist=Util.bigListSub(list);
				        		int i=1;
				        		for (List<MallProductStore> list2 : sublist) {
				        			num=mallProductStoreService.insertLeadInPro(list2);
				        			i++;
				        		}
				        		if(num>0){
				        			j=list.size();
				        			map.put("status", "ok");
				        			map.put("message", "导入成功！");
				        			map.put("nums",j);
				        		}else{
				        			map.put("status", "fail");
				        			map.put("message", "导入数据为空！");
				        		}
				        	}else{
				        		map.put("status", "fail");
				        		map.put("message", "未读取到导入数据文件！");
				        	}
				        }
			        } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(suffix)) {
			        	map.put("status", "fail");
			        	map.put("message", "请下载模板进行导入，暂不支持xlsx类型文件导入。");
						// 预留
						// readXlsx(file.getInputStream());
					} else {
						map.put("status", "fail");
						map.put("message", "导入失败,选择的文件格式不正确。");
					} 
				}else{
					map.put("status", "fail");
					map.put("message", "请选择xls文件上传!");
				}
			}
		}catch(FileNotFoundException fe){
			map.put("message", "文件读取失败！");
			map.put("status", "error");
//		     fe.printStackTrace();
		    return map;
		} catch (IllegalStateException | IOException e) {
			map.put("status", "error");
			map.put("message", "文件上传失败！");
//		     e.printStackTrace();
		     return map;
		}
		return map;
	}

	/**
	 * 导出模板
	 */
	@RequestMapping("/leadOutProTemp") 
    public void leadOutProTemp(HttpServletRequest request,HttpServletResponse response){  
        response.setContentType("text/html;charset=UTF-8");   
        BufferedInputStream in = null;  
        BufferedOutputStream out = null;  
        try {  
        	request.setCharacterEncoding("UTF-8");  
        	String path=request.getSession().getServletContext().getRealPath("/")+"template/mallProducts.xls";
            File f = new File(path);  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Content-Disposition", "attachment; filename="+"mallProducts.xls");  
            response.setHeader("Content-Length",String.valueOf(f.length()));  
            in = new BufferedInputStream(new FileInputStream(f));  
            out = new BufferedOutputStream(response.getOutputStream());  
            byte[] data = new byte[1024];  
            int len = 0;  
            while (-1 != (len=in.read(data, 0, data.length))) {  
                out.write(data, 0, len);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
                try {
                	if (in != null) {  
                		in.close();
                	}  
                	if (out != null) {  
                		out.close();  
                	}  
				} catch (IOException e) {
					e.printStackTrace();
				}  
        }  
    } 

	/**
	 * 导出门店商品
	 */
	@RequestMapping("/leadOutProducts") 
    public void download(HttpServletRequest request,HttpServletResponse response,String mall_name,String mall_code,String p_code,String p_name,String status){
		//导出结果查询
		ReMallProductQuery query=new ReMallProductQuery();
		query.setMall_code(mall_code);
		query.setMall_name(mall_name);
		query.setP_code(p_code);
		query.setName(p_name);
		query.setExportFlag(1);
		List<ReMallProduct> mallProList=mallMasterService.selectMallProduct(query);
		for (ReMallProduct reMallProduct : mallProList) {
			int quantity=Util.queryQtyByStore(reMallProduct.getMall_code(),reMallProduct.getP_code());
			reMallProduct.setQuantity(quantity);
		}  
		//poi导出excel
        response.setContentType("text/html;charset=UTF-8");   
        ServletOutputStream out=null;
        try {  
        	request.setCharacterEncoding("UTF-8");  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            String filename = "门店商品列表" + DateComFunc.formatDate(new Date(), "yyyyMMddHHmmss") + ".xls";
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename,"UTF-8"));  
            ExportExcel<ReMallProduct> ex = new ExportExcel<ReMallProduct>();
			String[] headers = {"门店id","门店编号", "门店名称","商品id","商品名称", "商品条形码","市场价格","销售价格","库存","安全库存","商品状态(0:下线;1:上线)"};
			out = response.getOutputStream();
			ex.exportExcel(headers, mallProList, out);
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
	 * 批量新增门店商品(测试导入保留)
	 * @param request
	 * @return
	 */
	@RequestMapping("/leadInMallProducts")
	public String leadInMallProducts(HttpServletRequest request){
		try{
	    	String path=request.getSession().getServletContext().getRealPath("/")+"upload/mallProducts.xls";
	        List<MallProductStore> list = (List<MallProductStore>) readExcel.readExcel(path,1);
	        if (list != null) {
	            for (MallProductStore mallPro : list) {
	                System.out.println("MallCode: " + mallPro.getMallCode() + ", pCode : " + mallPro.getpCode() + ", SalePrice : " +mallPro.getSalePrice()+ ", SafeQuantity : " + mallPro.getSafeQuantity()+ ", Online:" + mallPro.getOnline());
	            }
	        }
	        if(list!=null&&list.size()>0){
	        	int num=mallProductStoreService.insertLeadInPro(list);
	        	if(num>0){
		        	request.setAttribute("status", "ok");
		        	request.setAttribute("message", "导入成功！");
		        	request.setAttribute("nums",list.size());
	        	}else{
	        		request.setAttribute("status", "fail");
		        	request.setAttribute("message", "导入数据为空！");
	        	}
	        }else{
	        	request.setAttribute("status", "fail");
	        	request.setAttribute("message", "未读取到导入数据文件！");
	        }
		}catch(Exception e){
			request.setAttribute("status", "error");
			return "mall/mall_product_list";
		}
		return "redirect:/shop/queryShopProducts";
	}
	
	/**
	 * 查询弹出店铺列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/shopwinList")
	public String shopwinList(HttpServletRequest request,MallMasterQuery query){
		try{
			List<MallMaster> shopList=mallMasterService.selectSendPriceByRegion(query);
			if(shopList!=null){
				int num=mallMasterService.selectSendPriceByRegionNum(query);
				query.setTotalNums(num);
			}
			request.setAttribute("shopList",shopList);
			request.setAttribute("query",query);
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "查询出错!");
			e.printStackTrace();
		}
		return "mall/mallwindow_list";
	}
	
	/**
	 * 查询门店详细信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryOneShopInfo")
	public String queryOneShopInfo(HttpServletRequest request,String mall_code){
		try{
			MallMaster shop=mallMasterService.selectByMallCode(mall_code);
			request.setAttribute("mall",shop);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "查询出错!");
			e.printStackTrace();
		}
		return "mall/mall_detail";
	}
	
	/**
	 * 修改门店
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updShop")
	public String updShop(HttpServletRequest request,MallMaster mallMaster){
		try{
		boolean b=mallMasterService.updateMallByCode(mallMaster);
		if(b){
			request.setAttribute("message","更新成功！");
			request.setAttribute("status", "ok");
		}else{
			request.setAttribute("message","更新失败！");
			request.setAttribute("status", "fail");
			request.setAttribute("mall", mallMaster);
			return "mall/mall_edit";
		}
	}catch(Exception e){
		request.setAttribute("status", "error");
		request.setAttribute("message","更新异常！");
		request.setAttribute("mall", mallMaster);
		return "mall/mall_edit";
	}
		return "redirect:/shop/shopList";
	}
	
	/**
	 * 上下线门店
	 * @param request
	 * @return
	 */
	@RequestMapping("/onlineOffShop")
	public String onlineOffShop(HttpServletRequest request,MallMaster mallMaster) {  
		Long bd_map_key=mallMaster.getBd_map_key();
		//批量Mall_codes不为空，暂未支持LBS同步
		String mallCodes=mallMaster.getMall_codes();
		if(mallCodes!=null&&!(mallCodes.isEmpty())){
			List<String> list=Arrays.asList(mallCodes.split(","));
			if(list!=null&&list.size()>0){
				mallMaster.setList(list);
			}
		}
		try{
			if(bd_map_key!=null){
				if(mallMaster.getOperate_type()!=null){
					mallMaster.setUseflg(mallMaster.getOperate_type());
					//同步操作LBS
					Map<String,String> mallMap=new HashMap<String, String>();
					mallMap.put("id",bd_map_key+"");
					mallMap.put("ak", Application.AK);
					mallMap.put("geotable_id", Application.GEOTABLE_ID);
					mallMap.put("useFlg", mallMaster.getOperate_type()+"");
					String httpUrl=Application.LBS_UPDATEURL;
					HttpRequestUtil httpRequest=HttpRequestUtil.getHttpsRequestSingleton();
					JSONObject result= httpRequest.sendPost(httpUrl, mallMap);
					if(result != null&&!((result.toString()).isEmpty())){
						int status=result.getInt("status");
						if(status==0){
							boolean mflag=mallMasterService.updateMallByCode(mallMaster);
							if(mflag){
								request.setAttribute("message", "本地操作成功！");
								request.setAttribute("status", "ok");
							}else{
								request.setAttribute("message", "本地操作失败！");
								request.setAttribute("status", "fail");
							}
						}else{
							request.setAttribute("message", "lbs操作失败！");
							request.setAttribute("status", "fail");
						}
					}
				}
			}else{
				request.setAttribute("message", "lbs主键数据有误,操作失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message","操作异常！");
			request.setAttribute("status", "error");
		}
		return "redirect:/shop/shopList";
	}
	
	/**
	 *LBS门店与数据同步
	 * @param request
	 * @return
	 */
	@RequestMapping("/lbsMallAdd")
	public String lbsMallAdd(HttpServletRequest request,MallMaster mallMaster) {  
		try{
			String mallCode=mallMaster.getMallCode();
			//如果已经添加过门店，禁止重复添加
			MallMaster mm=mallMasterService.selectByMallCode(mallCode);
			if(mm!=null){
				request.setAttribute("mall", mallMaster);
				request.setAttribute("message", "该编码的门店已存在!");
				request.setAttribute("status", "fail");
				return "mall/mall_add";
			}
			 Integer IsSupportSelfDeliver=mallMaster.getIsSupportSelfDeliver();
			 if(IsSupportSelfDeliver==null){
				IsSupportSelfDeliver=0;
				mallMaster.setIsSupportSelfDeliver(IsSupportSelfDeliver);
			 }
			 String Shop_label=mallMaster.getShop_label();
			 if(Shop_label==null||Shop_label.isEmpty()){
				mallMaster.setShop_label("0");
				mallMaster.setIsSend(0);
			 }else{
				 mallMaster.setIsSend(1);
			 }
			 Integer IsSupportThirdDeliver=mallMaster.getIsSupportThirdDeliver();
			 if(IsSupportThirdDeliver==null){
				IsSupportThirdDeliver=0;
				mallMaster.setIsSupportThirdDeliver(IsSupportThirdDeliver);
			 }
			 if(mallMaster.getSendDistance()==null){
				BigDecimal SendDistance=new BigDecimal(Application.LBS_SENDDISTANCE);
				mallMaster.setSendDistance(SendDistance);
			 }
			//默认添加时关店
			mallMaster.setMallStatus(Application.LBS_MALL_STOP);
			mallMaster.setMallType(1);
			mallMaster.setMobile(mallMaster.getPhone());
			mallMaster.setMention(1);
			mallMaster.setSendLimitMoney(new BigDecimal(Application.SEND_LIMIT_MONEY));
			mallMaster.setSendLimitPoints(0);
			mallMaster.setUseflg(Application.LBS_MALL_STOP);
			mallMaster.setMallareaid(0);
			Map<String,String> mallMap=MallMasterToLBSMap.mallMasterToMap(mallMaster);
			String httpUrl=Application.LBS_CREATEURL;
			HttpRequestUtil httpRequest=HttpRequestUtil.getHttpsRequestSingleton();
			JSONObject result= httpRequest.sendPost(httpUrl, mallMap);
			Long mapId=null;
			if(result != null&&!((result.toString()).isEmpty())){
				int status=result.getInt("status");
				if(status==0){
					mapId=result.getLong("id");
					mallMaster.setBd_map_key(mapId);
					boolean mflag=mallMasterService.insertMallMaster(mallMaster);
					if(mflag){
						String mc="";
						String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";  
						if(mallCode==null||mallCode.isEmpty()||(!mallCode.matches(regex))){
							mc="999999";
						}else{
							mc=(Integer.valueOf(mallCode)-Constants.SHOP_USE.MALLCODEBEGIN)+"";
						}
						//插入店铺初始化登录信息
						ShopUser shopUser=new ShopUser();
						String account=Constants.SHOP_USE.ACCOUNTBEGIN+mc;
						String pname=mallMaster.getProvinceName();
						String cname=mallMaster.getCityName();
						String dname=mallMaster.getCountyName();
						String aname=mallMaster.getAddress();
						if(pname!=null&&(!pname.isEmpty())&&((pname.trim()).equals(cname.trim()))){
							cname="";
						}
						String detailaddress=pname+cname+dname+aname;
						shopUser.setAccount(account);
						shopUser.setBaiduShopId(mallCode);
						shopUser.setMall_address(detailaddress);
						shopUser.setMall_code(mallCode);
						shopUser.setMall_name(mallMaster.getMallName());
						shopUser.setMall_phone(mallMaster.getPhone());
						shopUser.setMeituanShopId(mallCode);
						shopUser.setPassword(Util.getMD5(account));
						shopUser.setStatus(0);
						int s=shopUserService.insertShop(shopUser);
						if(s>0){
							request.setAttribute("message", "数据保存成功！");
							request.setAttribute("status", "ok");
						}else{
							request.setAttribute("message", "账户信息保存失败！");
							request.setAttribute("status", "fail");
						}
					}else{
						request.setAttribute("mall", mallMaster);
						request.setAttribute("message", "数据保存失败！");
						request.setAttribute("status", "fail");
						return "mall/mall_add";
					}
				}else{
					request.setAttribute("mall", mallMaster);
					request.setAttribute("message", "lbs创建失败！"+result.getString("message"));
					request.setAttribute("status", "fail");
					return "mall/mall_add";
				}
			}else{
				request.setAttribute("mall", mallMaster);
				request.setAttribute("message", "lbs创建失败！");
				request.setAttribute("status", "fail");
				return "mall/mall_add";
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message","添加失败！");
			request.setAttribute("status", "error");
			request.setAttribute("mall", mallMaster);
			return "mall/mall_add";
		}
		return "redirect:/shop/shopList";
	}
	
	/**
	 *LBS门店修改与数据同步
	 * @param request
	 * @return
	 */
	@RequestMapping("/lbsMallupd")
	public String lbsMallupd(HttpServletRequest request,MallMaster mallMaster) {  
		Integer IsSupportSelfDeliver=mallMaster.getIsSupportSelfDeliver();
		 if(IsSupportSelfDeliver==null){
			IsSupportSelfDeliver=0;
			mallMaster.setIsSupportSelfDeliver(IsSupportSelfDeliver);
		 }
		 String Shop_label=mallMaster.getShop_label();
		 if(Shop_label==null||Shop_label.isEmpty()){
			mallMaster.setShop_label("0");
		 }
		 Integer IsSupportThirdDeliver=mallMaster.getIsSupportThirdDeliver();
		 if(IsSupportThirdDeliver==null){
			IsSupportThirdDeliver=0;
			mallMaster.setIsSupportThirdDeliver(IsSupportThirdDeliver);
		 }
		 if(mallMaster.getSendDistance()==null){
			BigDecimal SendDistance=new BigDecimal(Application.LBS_SENDDISTANCE);
			mallMaster.setSendDistance(SendDistance);
		 }
		try{
			Long mapId=mallMaster.getBd_map_key();
			if(mapId!=null){
				Map<String,String> mallMap=MallMasterToLBSMap.mallMasterToMap(mallMaster);
				String httpUrl=Application.LBS_UPDATEURL;
				HttpRequestUtil httpRequest=HttpRequestUtil.getHttpsRequestSingleton();
				JSONObject result= httpRequest.sendPost(httpUrl, mallMap);
				if(result != null&&!((result.toString()).isEmpty())){
					int status=result.getInt("status");
					if(status==0){
						boolean mflag=mallMasterService.updateMallByCode(mallMaster);
						if(mflag){
							request.setAttribute("message", "数据更新成功！");
							request.setAttribute("status", "ok");
						}else{
							request.setAttribute("mall", mallMaster);
							request.setAttribute("message", "数据更新失败！");
							request.setAttribute("status", "fail");
							return "mall/mall_detail";
						}
					}else{
						request.setAttribute("mall", mallMaster);
						request.setAttribute("message", "lbs更新失败！"+result.getString("message"));
						request.setAttribute("status", "fail");
						return "mall/mall_detail";
					}
				}
			}else{
				request.setAttribute("mall", mallMaster);
				request.setAttribute("message", "lbs更新失败！");
				request.setAttribute("status", "fail");
				return "mall/mall_detail";
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message","更新失败！");
			request.setAttribute("status", "error");
			request.setAttribute("mall", mallMaster);
			return "mall/mall_detail";
		}
		return "redirect:/shop/shopList";
	}
	
	/**
	 *LBS门店删除与数据同步
	 * @param request
	 * @return
	 */
	@RequestMapping("/lbsMalldel")
	public String lbsMalldel(HttpServletRequest request,String bd_map_key,String mall_code) {  
		JSONObject result=null;
		try{
			if(bd_map_key!=null&&!(bd_map_key.isEmpty())){
				Map<String,String> mallMap=new HashMap<String, String>();
				mallMap.put("id",bd_map_key);
				mallMap.put("ak", Application.AK);
				mallMap.put("geotable_id", Application.GEOTABLE_ID);
				String httpUrl=Application.LBS_DELETEURL;
				HttpRequestUtil httpRequest=HttpRequestUtil.getHttpsRequestSingleton();
				result= httpRequest.sendPost(httpUrl, mallMap);
				if(result != null&&!((result.toString()).isEmpty())){
					int status=result.getInt("status");
					if(status==0){
						boolean mflag=mallMasterService.deleteMall(mall_code);
						if(mflag){
							request.setAttribute("message", "数据删除成功！");
							request.setAttribute("status", "ok");
						}else{
							request.setAttribute("message", "数据删除失败！");
							request.setAttribute("status", "fail");
						}
					}else{
						request.setAttribute("message", "lbs删除失败！"+result.getString("message"));
						request.setAttribute("status", "fail");
					}
				}
			}else{
				request.setAttribute("message", "lbs删除失败！");
				request.setAttribute("status", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message","删除失败！");
			request.setAttribute("status", "error");
		}
		return "redirect:/shop/shopList";
	}
}
