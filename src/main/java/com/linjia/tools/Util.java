package com.linjia.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import com.linjia.constants.Application;
import com.linjia.constants.Constants;
import com.linjia.web.model.SecUser;
import com.linjia.web.query.OrderDirectionBean;
import com.linjia.web.query.QueryConditionBean;
import com.linjia.web.query.QueryDefinitionBean;
import com.linjia.web.query.QueryParameterBean;
import com.linjia.web.query.ScoreSubjectBean;
import com.linjia.web.query.ScoreTypeBean;
import com.linjia.web.query.SubjectAccountsBean;
import com.linjia.web.thirdService.eleme.oauth.OAuthClient;
import com.linjia.web.thirdService.eleme.oauth.Token;

public class Util {

	/**
	 * 取得分隔后值
	 * @param strVaue 值
	 * @param flag    标记
	 * @return 值数组
	 */
	public static String[] stringToKenizer(String strVaue, String flag) {
		StringTokenizer st = new StringTokenizer(strVaue, flag);

		int len = st.countTokens();
		String[] strs = new String[len];

		for (int k = 0; k < len; k++) {
			strs[k] = st.nextToken();
		}

		return strs;
	}

	public static String getStringFromArray(String[] strData) {
		StringBuffer sbResult = new StringBuffer("");

		if (strData == null)
			return sbResult.toString();

		for (int i = 0; i < strData.length; i++) {
			if (strData[i] != null && strData[i].trim().length() > 0)
				sbResult.append(",").append(strData[i].trim());
		}

		return sbResult.toString();
	}

	/**
	 * 计算MD5
	 * @param input
	 * @return
	 */
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * 删除当天之外的文件
	 * @throws Exception
	 * @author lizhl
	 */
	public static void removeFolder(String dateValue, String picPath) throws Exception {
		File fileOut = new File(picPath);
		File[] files = fileOut.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (file.getName().startsWith(dateValue)) {// 当天生成的文件不做操作
			} else {// 非今天生成的文件都删除
				if (file.exists()) {// 验证文件是否存在
					file.delete();
				}
			}
		}
	};

	public static String filterOffUtf8Mb4(String text) throws UnsupportedEncodingException {
		byte[] bytes = text.getBytes("utf-8");
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		int i = 0;
		while (i < bytes.length) {
			short b = bytes[i];
			if (b > 0) {
				buffer.put(bytes[i++]);
				continue;
			}

			b += 256;

			if (((b >> 5) ^ 0x6) == 0) {
				buffer.put(bytes, i, 2);
				i += 2;
			} else if (((b >> 4) ^ 0xE) == 0) {
				buffer.put(bytes, i, 3);
				i += 3;
			} else if (((b >> 3) ^ 0x1E) == 0) {
				i += 4;
			} else if (((b >> 2) ^ 0x3E) == 0) {
				i += 5;
			} else if (((b >> 1) ^ 0x7E) == 0) {
				i += 6;
			} else {
				buffer.put(bytes[i++]);
			}
		}
		buffer.flip();
		return new String(buffer.array(), "utf-8");
	}

	public static void writeOk(Map<String, Object> resMap) {
		resMap.put("status", "ok");
	}

	public static void writeError(Map<String, Object> resMap) {
		resMap.put("status", "error");
	}
	
	public static void writeSuccess(Map<String, Object> resMap) {
		resMap.put("message", "success");
	}
	
	public static void writeFail(Map<String, Object> resMap) {
		resMap.put("message", "系统错误");
	}
	
	public static void writeResultData(Map<String, Object> resMap, Object data) {
		resMap.put("resultData", data);
	}
	
	/********************************************************************/
	/**                        CRM系统接口调用部分                                                                                  */
	/********************************************************************/
	/**
	 * 根据手机号取得会员信息(当会员绑定的手机号变更后将匹配不到原来的会员，因此尽量少用)
	 * lixinling
	 * 2016年7月21日 上午10:17:36
	 * @param pCode
	 * @return
	 */
	public static JSONObject queryMemberByMobile(String phone) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/member/query_by_mobilenum?mobilenum=" + phone;
		String Authorization = "guest:guest";
		JSONObject result = NetRequest.requestGet(urlstr, null, Authorization);
		return result;
	}

	/**
	 * 根据"登录名"查找会员
	 * lixinling
	 * 2016年7月21日 上午10:17:36
	 * @param pCode
	 * @return
	 */
	public static JSONObject queryMemberByLogin(String login) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/member/query_by_login?login=" + login + "&appname=HDCARD";
		String Authorization = "guest:guest";
		JSONObject result = NetRequest.requestGet(urlstr, null, Authorization);
		return result;
	}

	/**
	 * 根据账户识别码查询储值账户的余额和积分
	 * lixinling
	 * 2016年7月21日 上午10:17:36
	 * @param pCode
	 * @return
	 * {
	"balance": 0, //余额
	"score": 144, //积分
	"accountAccesss": [],
	"scoreAccount": {
	"subjectAccounts": [
	  {
	    "scoreType": {
	      "uuid": "scoretypeuuid",
	      "code": "-",
	      "name": "系统默认"
	    },
	    "scoreSubject": {
	      "uuid": "-",
	      "code": "101",
	      "name": "消费"
	    },
	    "score": 144,
	    "remark": null
	  }
	]
	}
	}
	 */
	public static JSONObject queryDesaccount(String phone) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/desaccount/query?account_accesscode=" + phone
				+ "&account_accesstype=1";
		String Authorization = "guest:guest";
		JSONObject result = NetRequest.requestGet(urlstr, null, Authorization);
		return result;
	}

	/**
	 * 根据自定义查询条件, 查询储值流水
	 * lixinling 
	 * 2016年8月4日 下午4:00:09
	 * @param begin_trandate  业务发生起始时间, 格式为:yyyy-MM-dd, 可为空
	 * @param end_trandate  业务发生截至时间, 格式为:yyyy-MM-dd, 可为空	
	 * @param origincode  来源会员号, 不能为空
	 * @param action  动作, 可为空, 为空时查询所有动作
	 * @return
	 * {
	"paging": {
	    "pageSize": 300,
	    "page": 0,
	    "pageCount": 1,
	    "recordCount": 20,
	    "more": false
	},
	"records": [
	    {
	        "xid": "ed312014-d2ad-4c2c-b37f-272339e7bb30",
	        "tranId": "7501e6d0a57645869456cef5b4105c68",
	        "terminalId": "100019B",
	        "created": "2016-05-11 18:33:40",
	        "originCode": "WEB151215000099",
	        "cardNum": "1000751139146997",
	        "occur": 580,
	        "state": "未撤销",
	        "tranTime": "2016-05-11 18:30:54",
	        "action": "充值",
	        "remark": null
	    },
	    {
	        "xid": "402881a0549a8b4d01549f6057f13795",
	        "tranId": "40288056549f2df201549f6415a823d8",
	        "terminalId": "100019B",
	        "created": "2016-05-11 18:36:57",
	        "originCode": "WEB151215000099",
	        "cardNum": "1000751139146997",
	        "occur": 42.2,
	        "state": "未撤销",
	        "tranTime": "2016-05-11 18:34:25",
	        "action": "消费",
	        "remark": null
	    }
	  ]
	 }
	 */
	public static JSONObject queryDesaccounthst(String begin_trandate, String end_trandate, String origincode, String action) {
		StringBuilder pamram = new StringBuilder();
		if (!Tools.isEmpty(begin_trandate)) {
			pamram.append("begin_trandate=").append(begin_trandate);
		}
		if (!Tools.isEmpty(end_trandate)) {
			pamram.append(pamram.length() == 0 ? "end_trandate=" : "&end_trandate=").append(end_trandate);
		}
		if (!Tools.isEmpty(origincode)) {
			pamram.append(pamram.length() == 0 ? "origincode=" : "&origincode=").append(origincode);
		}
		if (!Tools.isEmpty(action)) {
			pamram.append(pamram.length() == 0 ? "action=" : "&action=").append(action);
		}

		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/desaccounthst/query?" + pamram.toString();

		// 组装请求参数(目前只使用了origincode，其他的条件暂时没有找到数据库对应的字段)
		QueryDefinitionBean queryBean = new QueryDefinitionBean(300, 0, -1);
		List<QueryConditionBean> conditions = new ArrayList<QueryConditionBean>();
		List<OrderDirectionBean> orders = new ArrayList<OrderDirectionBean>();

		QueryConditionBean queryConditionBean = new QueryConditionBean();
		queryConditionBean.setOperation(" origincode equals ");
		List<QueryParameterBean> parameters = new ArrayList<QueryParameterBean>();

		QueryParameterBean queryParameterBean = new QueryParameterBean();
		queryParameterBean.setType("java.lang.String");
		queryParameterBean.setValue(origincode);
		parameters.add(queryParameterBean);
		queryConditionBean.setParameters(parameters);
		conditions.add(queryConditionBean);

		OrderDirectionBean orderDirectionBean = new OrderDirectionBean();
		orderDirectionBean.setField("tranTime");
		orderDirectionBean.setDirection("desc");
		orders.add(orderDirectionBean);

		queryBean.setConditions(conditions);
		queryBean.setOrders(orders);
		// System.out.println("body:" + new JSONObject(queryBean));

		String Authorization = "guest:guest";
		JSONObject result = NetRequest.requestPost(urlstr, new JSONObject(queryBean), Authorization);
		return result;
	}

	/**
	 * 根据门店code和商品code取得该商品的门店库存
	 * lixinling
	 * 2016年7月21日 上午10:17:36
	 * @param mallCode
	 * @param pCode
	 * @return
	 */
	public static int queryQtyByStore(String mallCode, String pCode) {
//		int qty = 0;
//		String urlstr = "http://124.193.154.242:37080/h4rest-server/rest/h5rest-server/core/invservice/businv/query";
//		JSONObject body = new JSONObject();
//		JSONArray conditions = new JSONArray();
//		JSONArray parameters1 = new JSONArray();
//		JSONArray parameters2 = new JSONArray();
//		JSONObject condition1 = new JSONObject();
//		JSONObject condition2 = new JSONObject();
//		JSONObject parameter1 = new JSONObject();
//		JSONObject parameter2 = new JSONObject();
//		condition1.put("operation", "store code equals ");
//		parameter1.put("type", "java.lang.String");
//		parameter1.put("value", mallCode);
//		parameters1.put(parameter1);
//		condition1.put("parameters", parameters1);
//		conditions.put(condition1);
//
//		condition2.put("operation", "skuid equals ");
//		parameter2.put("type", "java.lang.String");
//		parameter2.put("value", pCode);
//		parameters2.put(parameter2);
//		condition2.put("parameters", parameters2);
//		conditions.put(condition2);
//		body.put("conditions", conditions);
//		JSONObject result = NetRequest.requestPost(urlstr, body, null);
//		if (result != null) {
//			JSONArray businvs = result.optJSONArray("businvs");
//			if (businvs != null && businvs.length() > 0) {
//				JSONObject businv = businvs.optJSONObject(0);
//				qty = businv.optInt("qty");
//			}
//		}
//		return qty;
		// 读取Redis中商品库存
		String key = "store_store:" + mallCode;
		String strQty = RedisUtil.hget(key, pCode);
		Integer qty = 0;
		if (!Tools.isEmpty(strQty)) {
			qty = Integer.valueOf(strQty);
			if (qty < 0)
				qty = 0;
			}
		return qty;
	}

	/**
	 * 根据手机号注册会员
	 * lixinling
	 * 2016年7月21日 上午10:17:36
	 * @param pCode
	 * @return
	 */
	public static JSONObject registMember(String phone, Long xid) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/member/regist?xid=" + xid + "&orgcode=WEB";
		String Authorization = "guest:guest";
		JSONObject body = new JSONObject();
		body.put("name", phone);
		body.put("cellPhone", phone);
		JSONObject result = NetRequest.requestPut(urlstr, body, Authorization);
		return result;
	}

	/**
	 * 更新CRM会员信息
	 * lixinling
	 * 2016年7月21日 上午10:17:36
	 * @param pCode
	 * @return
	 */
	public static JSONObject updateMember(JSONObject data) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/member/modify?xid=1&orgcode=WEB";
		String Authorization = "guest:guest";

		String dataUni = StringEscapeUtils.escapeJava(data.toString());
		JSONObject body = new JSONObject(dataUni);
		JSONObject result = NetRequest.requestPost(urlstr, body, Authorization);
		return result;
	}

	/**
	 * 减积分操作：/scoreaccount/dec
	 * lixinling 
	 * 2016年8月8日 下午4:25:17
	 * @param xid 外部交易号
	 * @param account_accesscode 账户识别码 (例如：WEB160209000045)
	 * @param remark 备注
	 * @param scoreSubjectCode 积分项目code
	 * @param score 积分值
	 * 
	 * requestBody:{"subjectAccounts":[{"remark":"\u8ba2\u53551201608050000044763\u6263\u51cf","scoreType":{"code":"-"},"scoreSubject":{"code":107},"score":120}]} 
	 * @return {"subjectAccounts":[{"scoreType":{"uuid":"scoretypeuuid","code":"-","name":"系统默认"},"scoreSubject":{"uuid":"-","code":"107","name":"兑奖"},"score":-2090,"remark":null},{"scoreType":{"uuid":"scoretypeuuid","code":"-","name":"系统默认"},"scoreSubject":{"uuid":"-","code":"101","name":"消费"},"score":2649,"remark":null}]}
	 */
	public static JSONObject decScoreAccount(Long xid, String account_accesscode, String remark, int scoreSubjectCode, int score) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/scoreaccount/dec?xid=" + xid + "&orgcode=WEB&account_accesscode="
				+ account_accesscode + "&account_accesstype=2";
		String Authorization = "guest:guest";

		// 构造请求参数
		JSONObject data = new JSONObject();
		JSONArray subjectAccounts = new JSONArray();
		data.put("subjectAccounts", subjectAccounts);
		SubjectAccountsBean subjectAccountsBean = new SubjectAccountsBean();
		subjectAccountsBean.setRemark(remark);
		subjectAccountsBean.setScore(score);
		ScoreTypeBean scoreTypeBean = new ScoreTypeBean();
		scoreTypeBean.setCode("-");
		subjectAccountsBean.setScoreType(scoreTypeBean);
		ScoreSubjectBean scoreSubjectBean = new ScoreSubjectBean();
		scoreSubjectBean.setCode(scoreSubjectCode);
		subjectAccountsBean.setScoreSubject(scoreSubjectBean);
		subjectAccounts.put(subjectAccountsBean);

		String dataUni = StringEscapeUtils.escapeJava(data.toString());
		JSONObject body = new JSONObject(dataUni);
		JSONObject result = NetRequest.requestPost(urlstr, body, Authorization);
		return result;
	}

	/**
	 * 增积分操作：/scoreaccount/inc
	 * lixinling 
	 * 2016年8月8日 下午4:25:17
	 * @param xid 外部交易号
	 * @param account_accesscode 账户识别码
	 * @param remark 备注
	 * @param scoreSubjectCode 积分项目code
	 * @param score 积分值
	 * 
	 * requestBody:{"subjectAccounts":[{"remark":"\u8ba2\u53551201608050000044763\u6263\u51cf","scoreType":{"code":"-"},"scoreSubject":{"code":107},"score":120}]} 
	 * @return {"subjectAccounts":[{"scoreType":{"uuid":"scoretypeuuid","code":"-","name":"系统默认"},"scoreSubject":{"uuid":"-","code":"107","name":"兑奖"},"score":-2090,"remark":null},{"scoreType":{"uuid":"scoretypeuuid","code":"-","name":"系统默认"},"scoreSubject":{"uuid":"-","code":"101","name":"消费"},"score":2649,"remark":null}]}
	 */
	public static JSONObject incScoreAccount(Long xid, String account_accesscode, String remark, int scoreSubjectCode, int score) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/scoreaccount/inc?xid=" + xid + "&orgcode=WEB&account_accesscode="
				+ account_accesscode + "&account_accesstype=2";
		String Authorization = "guest:guest";

		// 构造请求参数
		JSONObject data = new JSONObject();
		JSONArray subjectAccounts = new JSONArray();
		data.put("subjectAccounts", subjectAccounts);
		SubjectAccountsBean subjectAccountsBean = new SubjectAccountsBean();
		subjectAccountsBean.setRemark(remark);
		subjectAccountsBean.setScore(score);
		ScoreTypeBean scoreTypeBean = new ScoreTypeBean();
		scoreTypeBean.setCode("-");
		subjectAccountsBean.setScoreType(scoreTypeBean);
		ScoreSubjectBean scoreSubjectBean = new ScoreSubjectBean();
		scoreSubjectBean.setCode(scoreSubjectCode);
		subjectAccountsBean.setScoreSubject(scoreSubjectBean);
		subjectAccounts.put(subjectAccountsBean);

		String dataUni = StringEscapeUtils.escapeJava(data.toString());
		JSONObject body = new JSONObject(dataUni);
		JSONObject result = NetRequest.requestPost(urlstr, body, Authorization);
		return result;
	}

	/**
	 * 修改钱包支付密码
	 * lixinling
	 * 2016年7月21日 上午10:17:36
	 * @param pCode
	 * @return
	 * 
	 * {
	"exceptionClass": "com.hd123.rumba.exception.BusinessException",
	"message": "输入的原密码与账户密码不一致",
	"stackTrace": [],
	"cause": null,
	"error_code": -1
	}
	 */
	public static JSONObject updatePursePayPwd(String account_accesscode, String new_password, String old_password) {
		String urlstr = "http://124.193.154.242:58280/hdcard-services/api/password/change_pay_password?xid=1&orgcode=WEB&account_accesscode="
				+ account_accesscode + "&account_accesstype=1&new_password=" + new_password + "&old_password=" + old_password;
		String Authorization = "guest:guest";

		JSONObject result = NetRequest.requestPost(urlstr, null, Authorization);
		return result;
	}
	
	/**
	 * 
	 * @param realPath tomcate根路径
	 * @param htmlContent
	 * @return
	 */
	public static String createHtml(String realPath,String htmlContent,String fileName){
		//返回相对路径
		String rePath=null;
		try {  
			System.out.println("htmlContent:"+htmlContent);
			if(htmlContent!=null&&htmlContent.startsWith("<html>")){
				String path="";
				if(fileName!=null){
					fileName=fileName+Constants.CUST_PAGE_URL.FILE_TYPE;
					rePath=Constants.CUST_PAGE_URL.PAGE_DIR+fileName;
					path=new File(realPath).getParent() +Constants.CUST_PAGE_URL.PAGE_DIR;
					File f=new File(path);
					File f1=new File(path+fileName);
					if(!f.exists()){
						f.mkdirs();
					}else if(!f1.exists()){
						f1.createNewFile();
					}
					FileOutputStream fos=new FileOutputStream(f1);
					//通过fos将str的内容写到文件中
					byte[] bytes=htmlContent.getBytes("UTF-8");
					int bl = bytes.length;   
					fos.write(bytes,0,bl);
					fos.flush();
					fos.close();
				}
			}	
		}catch (IOException e) {
			rePath=null;
			e.printStackTrace();
		}catch (Exception e) {  
			rePath=null;
			e.printStackTrace();  
		}  
		return rePath;
	}
	

	/**
	 * 替换商品图片路径
	 * @param imgPath 商品图片路径
	 * @param htmlContent
	 * @return
	 */
	public static String replacePath(String imgPath){
		if(imgPath == null)
			return null;
		return imgPath.replace(Application.SERVER_BASE_PATH, "");
	}

	/**
	 * 删除文件
	 * @param fpath 文件路径
	 * @return
	 */
	public static boolean deleteFile(String fpath){
		boolean flag = false;
		File file = new File(fpath);
		
		// 路径为文件且不为空则进行删除  
		if(file.isFile() && file.exists()){
			file.delete();
			flag = true;
		}
		return flag;
	}
	
	//数组拆分
	public static <T> List<List<T>> bigListSub(List<T> dataList) {  
		List<List<T>> list=new ArrayList<List<T>>();
			int pointsDataLimit = 1000;//限制条数  
			Integer size = dataList.size();
			int part=0;
			//分批处理  
			if(null!=dataList&&size>0){
				//判断是否有必要分批
				if(pointsDataLimit<size){
					for (int i = 0; i < size; i++) {
						//1000条  
						if(i+pointsDataLimit+1<=size){
							List<T> listPage = dataList.subList(i,i+pointsDataLimit);  
							list.add(listPage);
							i=i+pointsDataLimit;
						}else{
							List<T> listPage = dataList.subList(i,size-1);  
							list.add(listPage);
							i=size-1;
						}
						part=part+1;
					}
				}else{
					//不用拆分的数组
					list.add(dataList);
					part=part+1;
				}
			} 
			System.out.println("共有 ： "+dataList.size()+"条,!"+" 分为 ："+part+"批");
			return list;
	}
	
	/**  
	 * 从session中取得用户信息
	 * @param v1 被加数  
	 * @param v2 加数  
	 * @return 两个参数的和  
	 */  
	public static SecUser getUser(HttpServletRequest request){   
		SecUser user = (SecUser)request.getSession().getAttribute("user");
		return user; 
	}  

	//客户退款接口签名生成
	public static String getKfSign(Long groupId, String userId, Integer orderType, Integer source, Long refundId) {
		SortedMap<String, Object> prePayParams = new TreeMap<String, Object>();
		prePayParams.put("groupId", groupId);
	    prePayParams.put("userId",userId);
	    prePayParams.put("orderType",orderType);
	    prePayParams.put("source",source);
	    prePayParams.put("refundId",refundId);
	    String strs="";
	    for(Entry<String, Object> p : prePayParams.entrySet()){
	    	strs=strs+p.getKey()+"="+p.getValue()+"&";
       }
		String keystr=strs+Application.getljKey();
		String sign=getMD5(keystr);
		return sign;
	}
	
	//当天第几单
		public static Integer getTodayOrderNum(String orderSource,String mallCode){
			//orderSource: M:美团;L:邻家;B:百度 ;J:京东;E:饿了么;
			Integer value=null;
			try{
				String key1=DateComFunc.formatDate(new Date(),"yyyMMdd");
				String key=orderSource+mallCode+key1;
				String val=RedisUtil.get(key);
				if(val==null||val.isEmpty()){
					RedisUtil.put(key,"1",86400);
					value=1;
				}else{
//					Integer vals=Integer.valueOf(RedisUtil.get(key))+1;
					RedisUtil.incr(key);
					value=Integer.valueOf(RedisUtil.get(key));
				}
			}catch(Exception e){
				value=0;
			}
			return value;
		}
	
	//饿了么token存取
	public static Token getElemeToken(){
		Token token=null;
		try{
			String eleme_access_token=RedisUtil.get("eleme_access_token");
			if(Tools.isEmpty(eleme_access_token)){
				OAuthClient client=new OAuthClient();
				token=client.getTokenInClientCredentials();
				String eleme_access_token_new=token.getAccessToken();
				String eleme_token_type=token.getTokenType();
				String eleme_refresh_token=token.getRefreshToken();
				if(eleme_refresh_token==null){
					eleme_refresh_token="";
				}
				Long eleme_expires_in=token.getExpires();
				int putTime=0;
				if(eleme_expires_in==null||eleme_expires_in<=1800){
					putTime=0;
				}else{
					putTime=eleme_expires_in.intValue()-1800;
				}
				RedisUtil.put("eleme_access_token",eleme_access_token_new,putTime);
				RedisUtil.put("eleme_token_type",eleme_token_type,putTime);
				RedisUtil.put("eleme_expires_in",eleme_expires_in+"",putTime);
				RedisUtil.put("eleme_refresh_token",eleme_refresh_token,putTime);
				RedisUtil.put("eleme_token_savetime",(new Date().getTime())+"",putTime);
			}else{
				String eleme_access_token_old=RedisUtil.get("eleme_access_token");
				String eleme_token_type_old=RedisUtil.get("eleme_token_type");
				String eleme_expires_in_old=RedisUtil.get("eleme_expires_in");
//				String eleme_refresh_token_old=RedisUtil.get("eleme_refresh_token");
				Long expires_in=Long.valueOf(eleme_expires_in_old);
				token=new Token();
				token.setAccessToken(eleme_access_token_old);
				token.setExpires(expires_in);
				token.setTokenType(eleme_token_type_old);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return token;
	}
}
