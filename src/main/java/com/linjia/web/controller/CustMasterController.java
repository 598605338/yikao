package com.linjia.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.linjia.tools.JSONUtil;
import com.linjia.tools.Util;
import com.linjia.web.model.AccountcashdepositConfigAmount;
import com.linjia.web.model.AccountcashdepositConfigBase;
import com.linjia.web.model.AccountcashdepositRecord;
import com.linjia.web.model.CustMaster;
import com.linjia.web.model.QueryCustMaster;
import com.linjia.web.query.AccountcashdepositRecordQuery;
import com.linjia.web.query.MemberQuery;
import com.linjia.web.service.AccountcashdepositConfigService;
import com.linjia.web.service.AccountcashdepositRecordService;
import com.linjia.web.service.CustMasterService;

/** 
 * @author  xiangsy: 
 * @date 2016年8月30日 下午4:16:39 
 * @version 1.0 
 */
@Controller
@RequestMapping("/cust")
public class CustMasterController {
	
	@Autowired
	private CustMasterService  custMasterService;
	
	@Autowired
	private AccountcashdepositRecordService accountcashdepositRecordService;
	
	@Autowired
	private AccountcashdepositConfigService accountcashdepositConfigService;
	
	/**
	 * 新增会员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertCust")
	public String insertCust(HttpServletRequest request,@RequestBody CustMaster model){
		String phone=model.getCreator();
		CustMaster memeber=custMasterService.insertOrUpdate(JSONUtil.ObjToJSON(model), phone);
		return "cust/insertCust";
	}
	
	/**
	 * 查询会员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryCust")
	public String testPool(HttpServletRequest request,MemberQuery query){
		try{
			List<QueryCustMaster> custlist=custMasterService.selectMembers(query);
			for (QueryCustMaster queryCustMaster : custlist) {
				JSONObject json=Util.queryDesaccount(queryCustMaster.getCreator());
				//{"balance":290.1,"scoreAccount":{"subjectAccounts":[{"remark":null,"score":-50,"scoreSubject":{"name":"抵扣","code":"108","uuid":"-"},"scoreType":{"name":"系统默认","code":"-","uuid":"scoretypeuuid"}},{"remark":null,"score":3072,"scoreSubject":{"name":"调整","code":"104","uuid":"-"},"scoreType":{"name":"系统默认","code":"-","uuid":"scoretypeuuid"}},{"remark":null,"score":-8438,"scoreSubject":{"name":"兑奖","code":"107","uuid":"-"},"scoreType":{"name":"系统默认","code":"-","uuid":"scoretypeuuid"}},{"remark":null,"score":6315,"scoreSubject":{"name":"消费","code":"101","uuid":"-"},"scoreType":{"name":"系统默认","code":"-","uuid":"scoretypeuuid"}}]},"accountAccesss":[],"score":899}
				if(json!=null){
					int custScore=json.getInt("score");
					queryCustMaster.setCustScore(custScore);
				}
			}
			//查询会员数
			if(custlist!=null){
				int custs=custMasterService.selectCustNums(query);
				query.setTotalNums(custs);
			}
			request.setAttribute("custlist", custlist);
			request.setAttribute("query",query);
		}catch(Exception e){
			request.setAttribute("status", "fail");
			request.setAttribute("message", "查询异常");
			e.printStackTrace();
		}
		return "member/member_list";
	}
	
	/**
	 * 启用会员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/enableCust")
	public String enableCust(HttpServletRequest request,@RequestBody String phone){
		Integer deleted=null;
		Integer useFlg=1;
		int num=custMasterService.updateMember(phone, deleted, useFlg);
		return "cust/viewCust";
	}
	
	/**
	 * 禁用会员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/unableCust")
	public String unableCust(HttpServletRequest request,@RequestBody String phone){
		Integer deleted=null;
		Integer useFlg=0;
		int num=custMasterService.updateMember(phone, deleted, useFlg);
		return "cust/viewCust";
	}
	
	/**
	 * 删除会员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteCust")
	public String deleteCust(HttpServletRequest request,@RequestBody String phone){
		Integer deleted=1;
		Integer useFlg=null;
		int num=custMasterService.updateMember(phone, deleted, useFlg);
		return "cust/viewCust";
	}
	

	/**
	 * 会员充值记录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAccountcashdepositRecordList")
	public String getAccountcashdepositRecordList(HttpServletRequest request, AccountcashdepositRecordQuery query){
		try{
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
				query.setStartTrantime(sdf.parse(beginDate));
			}
			if(endDate!=null&&(!endDate.isEmpty())){
				query.setEndTrantime(sdf.parse(endDate));
			}
			List<AccountcashdepositRecord> accountcashdepositRecordList = accountcashdepositRecordService.selectByPageList(query);
			if(accountcashdepositRecordList!=null){
				int accountsNum = accountcashdepositRecordService.selectByPageListNum(query);
				query.setTotalNums(accountsNum);
			}
			request.setAttribute("recordlist",accountcashdepositRecordList);
			request.setAttribute("query", query);
			request.setAttribute("status", "ok");
		}catch(Exception e){
			request.setAttribute("status", "fail");
			request.setAttribute("message", "异常");
			e.printStackTrace();
		}
		return "member/member_recharge_list";
	}
	
	
	/**
	 * 会员充值查询
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/accountcashdepositConfig")
	public String accountcashdepositConfig(HttpServletRequest request,String id){
		int aid=1;
		AccountcashdepositConfigBase accountcashdepositConfigBase=null;
		if(id!=null&&(!id.isEmpty())){
			aid=Integer.parseInt(id);
		}
		accountcashdepositConfigBase = accountcashdepositConfigService.selectExistRecord(aid);
		if(accountcashdepositConfigBase == null){
			accountcashdepositConfigBase = new AccountcashdepositConfigBase();
		}else{
			List<AccountcashdepositConfigAmount> amountList = accountcashdepositConfigService.selectAllByBaseId(accountcashdepositConfigBase.getId());
			accountcashdepositConfigBase.setAmountList(amountList);
		}
		request.setAttribute("depConfig",accountcashdepositConfigBase);
		return "member/member_recharge_set";
	}
	
	/**
	 * 保存会员充值设置
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveAccountcashdepositConfig")
	public String saveAccountcashdepositConfig(HttpServletRequest request, AccountcashdepositConfigBase baseModel){
		Map<String,Object> resMap = new HashMap<String,Object>();
		String amlist=baseModel.getAmountSetStr();
		boolean result = false;
		try{
			if(amlist!=null&&(!amlist.isEmpty())){
				List<AccountcashdepositConfigAmount> amountList=JSONUtil.json2List(amlist, AccountcashdepositConfigAmount.class);
				if(amountList!=null&&amountList.size()>0){
					for (AccountcashdepositConfigAmount accountcashdepositConfigAmount : amountList) {
						accountcashdepositConfigAmount.setBaseId(baseModel.getId());
					}
				}
				baseModel.setAmountList(amountList);
			}
			if(baseModel.getId() == null || baseModel.getId().intValue() ==0){
				result = accountcashdepositConfigService.insert(baseModel) == 1 ? true : false;
			}else{
				result = accountcashdepositConfigService.update(baseModel);
			}
			
			if(result){
				List<AccountcashdepositConfigAmount> base=accountcashdepositConfigService.selectAllByBaseId(baseModel.getId());
				int num=0;
				if(base!=null&&base.size()>0){
					num=accountcashdepositConfigService.deleteAll(baseModel.getId());
				}else{
					num=1;
				}
				if(num>0){
					accountcashdepositConfigService.insertSelectiveBatch(baseModel.getAmountList());
					resMap.put("message", "保存成功");
					resMap.put("status", "ok");
				}
			}else{
				resMap.put("message", "保存失败");
				resMap.put("status", "fail");
			}
		}catch(Exception e){
			resMap.put("message", "异常");
			resMap.put("status", "error");
			e.printStackTrace();
		}
		return "redirect:/cust/accountcashdepositConfig";
	}
	
}
