package com.linjia.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjia.base.controller.BaseController;
import com.linjia.tools.DateComFunc;
import com.linjia.tools.Tools;
import com.linjia.web.model.Feedback;
import com.linjia.web.query.FeedbackQuery;
import com.linjia.web.service.FeedbackService;

/**
 * 反馈管理模块
 * 
 * @author lixinling
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController extends BaseController {

	@Autowired
	private FeedbackService feedbackService;

	/**
	 * 取得反馈列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/select")
	public String getFeedbackList(FeedbackQuery query, Model model) {
		if(!Tools.isEmpty(query.getComment()))
			query.setCommentQuery("%" + query.getComment() + "%");
		
		if(!Tools.isEmpty(query.getContactWay()))
			query.setContactWayQuery("%" + query.getContactWay() + "%");
		
		if(!Tools.isEmpty(query.getCreDateStartStr()))
			query.setCreDateStart(DateComFunc.strToDate(query.getCreDateStartStr(), "yyyy-MM-dd HH:mm:ss"));
		
		if(!Tools.isEmpty(query.getCreDateEndStr()))
			query.setCreDateEnd(DateComFunc.strToDate(query.getCreDateEndStr(), "yyyy-MM-dd HH:mm:ss"));
		
		List<Feedback> feedbackList = feedbackService.selectByPageList(query);
		if(feedbackList != null && feedbackList.size() != 0){
			for(Feedback o : feedbackList){
				if(!Tools.isEmpty(o.getCustname())){
					try {
						o.setCustname(URLDecoder.decode(o.getCustname(),"UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		int pnums = feedbackService.countByExample(query);
		model.addAttribute("feedbackList",feedbackList);
		model.addAttribute("pnums",pnums);
		model.addAttribute("query",query);

		return "feedback/feedback_list";
	}
	
	/**
	 * 取得反馈列表
	 * lixinling 
	 * 2016年8月22日 下午2:23:04
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectDetail")
	public String getDetail(Long id, Model model) {
		
		Feedback feedback = feedbackService.selectById(id);
		model.addAttribute("feedback",feedback);

		return "feedback/feedback_detail";
	}
}
