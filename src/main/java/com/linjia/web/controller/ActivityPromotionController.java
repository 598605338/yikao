package com.linjia.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.linjia.base.controller.BaseController;
import com.linjia.tools.JSONUtil;
import com.linjia.web.model.ActivityInfo;
import com.linjia.web.model.ActivityProduct;
import com.linjia.web.model.ActivityTradeProduct;
import com.linjia.web.query.ActivityInfoQuery;
import com.linjia.web.service.ActivityPromotionService;

/**
 * 促销模块
 * 
 * @author xiangsy
 *
 */
@Controller
@RequestMapping("/promotion")
public class ActivityPromotionController extends BaseController{
	
	private static Logger LOG = LoggerFactory.getLogger(ActivityPromotionController.class);
	
	@Autowired
	private ActivityPromotionService activityPromotionService;
	
	/**
	 * 插入活动基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertActInfo")
	@ResponseBody
	public Object insertActInfo(HttpServletRequest request,@RequestBody ActivityInfo info){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=activityPromotionService.insertActInfo(info);
		map.put("resultData", info);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 更新活动基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateActInfoById")
	public String updateActInfoById(HttpServletRequest request,ActivityInfo info){
		Integer type=info.getActivity_type();
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String beginDate=info.getBeginDate();
			String endDate=info.getEndDate();  
			if(beginDate!=null&&(!beginDate.isEmpty())){
				info.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				info.setEnd_time(sdf.parse(endDate));
			}
			String sctp=info.getActProducts();
			String tradepro=info.getActTradeProducts();
			if(sctp!=null&&(!sctp.isEmpty())){
				List<ActivityProduct> ll=JSONUtil.json2List(sctp, ActivityProduct.class);
				info.setProducts(ll);
			}
			
			if(tradepro!=null&&(!tradepro.isEmpty())){
				List<ActivityTradeProduct> lltrad=JSONUtil.json2List(tradepro, ActivityTradeProduct.class);
				info.setTradeProducts(lltrad);;
			}
			if(info.getPromotion_condition_1()==null&&info.getPromotion_condition_2()==null){
				info.setConditionFlag(1);
			}
			boolean b=activityPromotionService.updateActInfoById(info);
			if(!b){
				request.setAttribute("status", "fail");
				request.setAttribute("message", "更新失败！");
			}
			if(type==null||type==0){
				type=1;
			}
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "更新异常");
			e.printStackTrace();
			return "activity_promotion_manage/fulll_minus_list";
		}
		return "redirect:/promotion/selectActInfoAll?activity_type="+type;
	}
	
	/**
	 * 删除活动基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteActInfoById")
	public String deleteActInfoById(HttpServletRequest request,String activity_ids,int activity_type){
		int j=0;
		try{
			if(activity_ids!=null&&(!activity_ids.isEmpty())){
				String[] activity_idArr=activity_ids.split("-");
				for (String activity_id : activity_idArr) {
					int actId=Integer.parseInt(activity_id);
					boolean b=activityPromotionService.deleteActInfoById(actId);
					if(b){
						j++;
					}
				}
			}
			request.setAttribute("delNums", j);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "redirect:/promotion/selectActInfoAll?activity_type="+activity_type;
	}
	
	/**
	 * 查询单个活动及关联商品信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectActInfoById")
	public String selectActInfoById(HttpServletRequest request,int activity_id,int activity_type){
		ActivityInfo info=null;
		List<ActivityProduct> proList=null;
		List<ActivityTradeProduct> tproList=null;
		Map<String, Object> parmMap1=new HashMap<String, Object>();
		Map<String, Object> parmMap2=new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pageUrl="";
		try{
			switch (activity_type) {
			case 1:
				pageUrl="activity_promotion_manage/fulll_minus_edit";
				break;
			case 2:
				pageUrl="activity_promotion_manage/product_discount_edit";
				break;
			case 3:
				pageUrl="activity_promotion_manage/second_half_edit";
				break;
			case 4:
				pageUrl="activity_promotion_manage/addMoney_change_edit";
				break;
			default:
				pageUrl="activity_promotion_manage/fulll_minus_list";
				break;
			}
			info=activityPromotionService.selectActInfoById(activity_id);
			if(info!=null){
				Date bgtime=info.getStart_time();
				Date endtime=info.getEnd_time();
				if(bgtime!=null){
					info.setBeginDate(sdf.format(bgtime));
				}
				if(endtime!=null){
					info.setEndDate(sdf.format(endtime));
				}
				//查询活动商品
				parmMap1.put("activity_id", activity_id);
				proList=activityPromotionService.selectActProductAll(parmMap1);
				info.setProducts(proList);
				if(activity_type==4){
					//查询加钱换购商品
					parmMap2.put("activity_id", activity_id);
					tproList=activityPromotionService.selectActTradeProAll(parmMap2);
					info.setTradeProducts(tproList);
				}
				
				//拼接活动商品id
				handleActProductIds(info, proList, tproList);
			}
			request.setAttribute("activityInfo", info);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return pageUrl;
	}
	
	/**
	 * 拼接活动商品id
	 * lixinling 
	 * 2016年12月20日 上午10:40:44
	 * @param info
	 * @param proList
	 * @param tproList
	 */
	public void handleActProductIds(ActivityInfo info, List<ActivityProduct> proList, List<ActivityTradeProduct> tproList){
		if(proList != null && proList.size() >0){
			StringBuilder proIds = new StringBuilder();
			for(ActivityProduct item : proList){
				proIds.append(item.getProduct_id()).append(",");
			}
			info.setProductIds(proIds.substring(0, proIds.length()-1));
		}
		if(tproList != null && tproList.size() >0){
			StringBuilder tproIds = new StringBuilder();
			for(ActivityTradeProduct item : tproList){
				tproIds.append(item.getProduct_id()).append(",");
			}
			info.setTradeProductIds(tproIds.substring(0, tproIds.length()-1));
		}
	}
	
	/**
	 * 查询多个活动基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectActInfoAll")
	public String selectActInfoAll(HttpServletRequest request,ActivityInfoQuery query){
		List<ActivityInfo> list=null;
		int type=query.getActivity_type();
		String pageUrl="";
		try{
			switch (type) {
			case 1:
				pageUrl="activity_promotion_manage/fulll_minus_list";
				break;
			case 2:
				pageUrl="activity_promotion_manage/product_discount_list";
				break;
			case 3:
				pageUrl="activity_promotion_manage/second_half_list";
				break;
			case 4:
				pageUrl="activity_promotion_manage/addMoney_change_list";
				break;
			default:
				pageUrl="activity_promotion_manage/fulll_minus_list";
				break;
			}
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String curdate=sdf.format(new Date());
			String beginDate=query.getBeginDate();
			String endDate=query.getEndDate();  
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				query.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				query.setEnd_time(sdf.parse(endDate));
			}
			 list=activityPromotionService.selectActInfoAll(query);
			 //查询总条数
			 if(list!=null&&list.size()>0){
				 query.setExportFlag(1);
				 List<ActivityInfo> ll=activityPromotionService.selectActInfoAll(query);
				 query.setTotalNums(ll.size());
			 }
			 request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		request.setAttribute("query", query);
		request.setAttribute("activitylist", list);
		return pageUrl;
	}
	
	
	
	/**
	 * 插入活动兑换商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertActTradePro")
	@ResponseBody
	public Object insertActTradePro(HttpServletRequest request,@RequestBody ActivityTradeProduct info){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=activityPromotionService.insertActTradePro(info);
		map.put("resultData", info);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 更新活动兑换商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateActTradeProById")
	@ResponseBody
	public Object updateActTradeProById(HttpServletRequest request,@RequestBody ActivityTradeProduct info){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=activityPromotionService.updateActTradeProById(info);
		map.put("resultData", info);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 删除活动兑换商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteActTradeProById")
	@ResponseBody
	public Object deleteActTradeProById(HttpServletRequest request,@RequestParam int id){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=activityPromotionService.deleteActTradeProById(id);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 查询活动兑换商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectActTradeProById")
	@ResponseBody
	public Object selectActTradeProById(HttpServletRequest request,@RequestParam int id){
		Map<String, Object> map = new HashMap<String, Object>();
		ActivityTradeProduct info=activityPromotionService.selectActTradeProById(id);
		map.put("resultData", info);
		return map;
	}
	
	/**
	 * 查询多个活动兑换商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectActTradeProAll")
	@ResponseBody
	public Object selectActTradeProAll(HttpServletRequest request,@RequestParam String p_name,@RequestParam String activity_id){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parmMap=new HashMap<String, Object>();
		parmMap.put("p_name", p_name);
		int s=0;
		if(activity_id!=null&&activity_id!=""){
			s=Integer.parseInt(activity_id);
			parmMap.put("activity_id",s);
		}else{
			parmMap.put("activity_id",null);
		}
		List<ActivityTradeProduct> list=activityPromotionService.selectActTradeProAll(parmMap);
		map.put("resultData", list);
		return map;
	}
	
	
	
	
	/**
	 * 插入活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertActProduct")
	@ResponseBody
	public Object insertActProduct(HttpServletRequest request,@RequestBody ActivityProduct info){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=activityPromotionService.insertActProduct(info);
		map.put("resultData", info);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 更新活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateActProductById")
	@ResponseBody
	public Object updateActProductById(HttpServletRequest request,@RequestBody ActivityProduct info){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=activityPromotionService.updateActProductById(info);
		map.put("resultData", info);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 删除活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteActProductById")
	@ResponseBody
	public Object deleteActProductById(HttpServletRequest request,@RequestParam int id){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean b=activityPromotionService.deleteActProductById(id);
		map.put("flag", b);
		return map;
	}
	
	/**
	 * 查询活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectActProductById")
	@ResponseBody
	public Object selectActProductById(HttpServletRequest request,@RequestParam int id){
		Map<String, Object> map = new HashMap<String, Object>();
		ActivityProduct info=activityPromotionService.selectActProductById(id);
		map.put("resultData", info);
		return map;
	}
	
	/**
	 * 查询多个活动商品基本信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectActProductAll")
	@ResponseBody
	public Object selectActProductAll(HttpServletRequest request,@RequestParam String p_name,@RequestParam String activity_id){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parmMap=new HashMap<String, Object>();
		int s=0;
		if(activity_id!=null&&activity_id!=""){
			s=Integer.parseInt(activity_id);
			parmMap.put("activity_id",s);
		}else{
			parmMap.put("activity_id",null);
		}
		parmMap.put("p_name", p_name);
		List<ActivityProduct> list=activityPromotionService.selectActProductAll(parmMap);
		map.put("resultData", list);
		return map;
	}
	
	/**
	 * 活动满减活动信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertFullMinus")
	public String insertFullMinus(HttpServletRequest request, ActivityInfo info){
		Integer type=info.getActivity_type();
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String curdate=sdf.format(new Date());
			String beginDate=info.getBeginDate();
			String endDate=info.getEndDate(); 
			String mallCodes=info.getMall_codes();
			if(mallCodes.isEmpty()){
				info.setMall_codes(null);
			}
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				info.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				info.setEnd_time(sdf.parse(endDate));
			}
			String sctp=info.getActProducts();
			String tradepro=info.getActTradeProducts();
			if(sctp!=null&&(!sctp.isEmpty())){
				List<ActivityProduct> ll=JSONUtil.json2List(sctp, ActivityProduct.class);
				info.setProducts(ll);
			}
			
			if(tradepro!=null&&(!tradepro.isEmpty())){
				List<ActivityTradeProduct> lltrad=JSONUtil.json2List(tradepro, ActivityTradeProduct.class);
				info.setTradeProducts(lltrad);;
			}
			
			boolean b=activityPromotionService.insertActInfo(info);
			if(!b){
				request.setAttribute("status", "fail");
				request.setAttribute("message", "添加失败！");
			}
			if(type==null||type==0){
				type=1;
			}
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "异常");
			e.printStackTrace();
			return "activity_promotion_manage/fulll_minus_list";
		}
		return "redirect:/promotion/selectActInfoAll?activity_type="+type;
	}
	
	/**
	 * 更新活动满减活动信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateActivityInfo")
	public String updateActivityInfo(HttpServletRequest request, ActivityInfo info){
		Integer type=info.getActivity_type();
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String curdate=sdf.format(new Date());
			String beginDate=info.getBeginDate();
			String endDate=info.getEndDate();  
			if("".equals(beginDate)&&!"".equals(endDate)){
				beginDate=curdate;
			}
			if(!"".equals(beginDate)&&"".equals(endDate)){
				endDate=curdate;
			}
			if(beginDate!=null&&(!beginDate.isEmpty())){
				info.setStart_time(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				info.setEnd_time(sdf.parse(endDate));
			}
			String sctp=info.getActProducts();
			String tradepro=info.getActTradeProducts();
			if(sctp!=null&&(!sctp.isEmpty())){
				List<ActivityProduct> ll=JSONUtil.json2List(sctp, ActivityProduct.class);
				info.setProducts(ll);
			}
			
			if(tradepro!=null&&(!tradepro.isEmpty())){
				List<ActivityTradeProduct> lltrad=JSONUtil.json2List(tradepro, ActivityTradeProduct.class);
				info.setTradeProducts(lltrad);;
			}
			
			boolean b=activityPromotionService.updateActInfoById(info);
			if(!b){
				request.setAttribute("status", "fail");
				request.setAttribute("message", "更新失败！");
			}
			if(type==null||type==0){
				type=1;
			}
		}catch(Exception e){
			request.setAttribute("status", "error");
			request.setAttribute("message", "更新异常");
			e.printStackTrace();
			return "activity_promotion_manage/fulll_minus_list";
		}
		return "redirect:/promotion/selectActInfoAll?activity_type="+type;
	}
}
