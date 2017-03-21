<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<script>
function doSubmit(){
	var form = document.saveForm;
	var cardName = form.cardName.value;
	var cardType = form.cardType.value;
	var description = form.description.value;
	var mallSupportType = form.mallSupportType.value;
	var totalNum = form.totalNum.value;
	var startTimeStr = form.startTimeStr.value;
	var endTimeStr = form.endTimeStr.value;
	var timeType = form.timeType.value;
	var useStartTimeStr = form.useStartTimeStr.value;
	var useEndTimeStr = form.useEndTimeStr.value;
	var validBeginDay = form.validBeginDay.value;
	var validDay = form.validDay.value;
	var supportCondition = form.supportCondition.value;
	if(cardType==null || cardType==''){
        alert("卡券类型为空，请重新添加！");return false;
	}
	if(cardName==null || cardName==''){
		 document.saveForm.cardName.focus();
        alert("请输入卡券名！");return false;
	}
	if(cardType==1){
		var pCode = form.pCode.value;
		if(pCode==null || pCode==''){
			document.saveForm.pCode.focus();
	        alert("请选择关联的商品！");return false;
		}
	}
	if(cardType==3){
		var amount = form.amount.value;
		if(amount==null || amount==''){
			document.saveForm.amount.focus();
	        alert("请填写代金券金额！");return false;
		}
	}
	if(description==null || description==''){
        document.saveForm.description.focus();
        alert("请编辑优惠券使用规则！");return false;
	}
	if(cardType==3 || cardType==5){
		var limitMoney = form.limitMoney.value;
		if(limitMoney==null || limitMoney==''){
      	  	document.saveForm.limitMoney.focus();
        	alert("请输入使用门槛！");return false;
			}
	}
	if(mallSupportType==null || mallSupportType==''){
        alert("请选择参与门店！");return false;
	}
	if(mallSupportType ==2){
		var mallCode = form.mallCode.value;
		if(mallCode==null || mallCode==''){
        	alert("请选择使用门店！");return false;
			}
	}
	if(totalNum==null || totalNum==''){
        document.saveForm.totalNum.focus();
        alert("请输入发券张数！");return false;
	}
	if(startTimeStr==null || startTimeStr==''){
        document.saveForm.startTimeStr.focus();
        alert("请选择发放有效期开始日期！");return false;
	}
	if(endTimeStr==null || endTimeStr==''){
        document.saveForm.endTimeStr.focus();
        alert("请选择发放有效期结束日期！");return false;
	}
	if(timeType==null || timeType==''){
        alert("请选择使用有效期类型！");return false;
	}
	
	if(timeType == 1){
		//固定时间
		if(useStartTimeStr==null || useStartTimeStr==''){
       	 	document.saveForm.useStartTimeStr.focus();
        	alert("请选择使用有效期开始时间！");return false;
		}
		if(useEndTimeStr==null || useEndTimeStr==''){
       		document.saveForm.useEndTimeStr.focus();
        	alert("请选择使用有效期结束时间！");return false;
		}
	}else if(timeType == 2){
		//动态时间
		if(validBeginDay==null || validBeginDay==''){
       	 	document.saveForm.validBeginDay.focus();
        	alert("请输入领取后几天生效！");return false;
		}
		if(validDay==null || validDay==''){
       		document.saveForm.validDay.focus();
        	alert("请输入有效期天数！");return false;
		}
	}
	if(supportCondition==null || supportCondition==''){
        alert("请选择使用场景！");return false;
	}
	form.submit();
}

//返回
function doBack(){
	/* document.location.href="select"; */
	window.history.go(-1);
}

window.onload=function(){
	var startDateTextBox = $('#startTimeStr');
	var endDateTextBox = $('#endTimeStr');

	$.timepicker.datetimeRange(
		startDateTextBox,
		endDateTextBox,
		{
			minInterval: (1000*60*60*24-1), // 23:59:59
			dateFormat: 'yy-mm-dd', 
			timeFormat: 'HH:mm:ss',
			start: {}, // start picker options
			end: {} // end picker options					
		}
	);
	
	var startDateTextBox = $('#useStartTimeStr');
	var endDateTextBox = $('#useEndTimeStr');

	$.timepicker.datetimeRange(
		startDateTextBox,
		endDateTextBox,
		{
			minInterval: (1000*60*60*24-1), // 23:59:59
			dateFormat: 'yy-mm-dd', 
			timeFormat: 'HH:mm:ss',
			start: {}, // start picker options
			end: {} // end picker options					
		}
	);
}
</script>
<style>
	td{
		border:none;
	}
	.td_right{
		border:none;
		width:87%;
	}
	.td_left{
		width:12%;
		height:55px;
	}
	.td_right{
		height:50px;
	}
	
	.lab{
	   display:block;
	   width:60%;
	   word-wrap: break-word; 
       word-break: normal; 
	}
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">卡券管理</header> -->
	<header class="cont_section_header_bread">
		<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
		<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">卡券</a><span>&gt;</span>
		<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">卡券管理</a><span>&gt;</span>
		<span style="color:#3bb3e0;">新增</span>
	</header>
	<section class="cont_section_section_border">
	<form name="saveForm" class="goods_new" action="add" method="post">
	<input type="hidden" value="<c:out value="${cardType }"/>" name="cardType" id="cardType" />
	<input type="hidden" value="" name="productId" id="productId" />
	
	<div class="editPage">
		<div class="editLeft">
			<div class="row-list">
				<label>卡券名称<span style="color:red">*</span>：</label>
				<c:choose>
					<c:when test="${cardType==1 }">
						<input style="width: 48.5%;" class="td_text_w" type="text" name="cardName" id="cardName" value="" maxlength="255" />
						<a href="<%=basePath%>/product/select?popupFlg=1&params=productId,pCode,pName,null,imageSrc,marketPrice" target="popupWin" onclick="popupProOpen();"><span class="back_dblue btn" style="width: 9.5%;margin: 0;"><i class="icon-btn icon-enable"></i>选择</span></a>
					</c:when>
					<c:otherwise>
						<input class="td_text_w" type="text" name="cardName" id="cardName" value="" maxlength="255" />
					</c:otherwise>
				</c:choose>
			</div>
			<c:if test="${cardType==1 }">
				<div class="row-list">
					<label>商品名：</label>
					<input class="td_text_w" type="text" name="pName" id="pName" value="" readonly="readonly"/>
				</div>
				<div class="row-list">
					<label>商品编码：</label>
					<input class="td_text_w" type="text" name="pCode" id="pCode" value="" readonly="readonly"/>
				</div>
				<div class="row-list">
					<label>市场价：</label>
					<input class="td_text_w" type="text" name="marketPrice" id="marketPrice" value="" readonly="readonly"/>元
				</div>
				<div class="row-list">
					<label>商品图片：</label>
					<img src="" width="120px" name="imageSrc" id="imageSrc" class="img1" />
				</div>
			</c:if>
			<c:if test="${cardType==3 }">
				<div class="row-list">
					<label>卡券金额<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="amount" id="amount" value="" maxlength="10" onkeyup="clearNoNum(this);"/><b>元</b>
				</div>
			</c:if>
			<div class="row-list">
				<label style="font-size: 12px;">卡券使用规则<span style="color:red">*</span>：</label>
				<textarea name="description" id="description" class="td_text_w" maxlength="255"
					style="width: 63.5%;height:66px;margin-left:0%;"><c:if test="${cardType==1 }">
1、此券为新品试吃提货券；
2、领取后当天生效，有效期为7天（自领券日起）；
3、此券适用于邻家所有门店；
4、若有任何问题请及时联系微信号：linjiali888888</c:if><c:if test="${cardType==3 }">
1. 此券只适用于邻家商城购物； 
2. 此券为商城满减现金券；
3. 在邻家商城提交订单时，选择“可用代金券”； 
4. 此券领取后当天生效，有效期7天（自领取日起算）。</c:if><c:if test="${cardType==5 }">
1. 此券只适用于邻家商城购物； 
2. 此券为商城免运券；
3. 在邻家商城提交订单时，选择“可用代金券”； 
4. 此券领取后当天生效，有效期7天（自领取日起算）。</c:if>	
				</textarea>
			</div>
			<c:if test="${cardType ==3 || cardType ==5 }">
				<div class="row-list">
					<label>使用门槛<span style="color:red">*</span>：</label>
					<b style="float: left;">满</b><input style="width: 60.1%;margin-left: 1%;" class="td_text_w" type="text" name="limitMoney" id="limitMoney" value="0" maxlength="10" onkeyup="clearNoNum(this);" /><label>元</label>
				</div>
			</c:if>
			<div class="row-list">
				<label>参与门店<span style="color:red">*</span>：</label>
				<input class="left" style="border:none;" type="radio" name="mallSupportType" value="1" onchange="mallChange('1');" /> <span class="left" style="margin-top:2px;">全部门店</span>
				<input class="left" style="border:none;" type="radio" name="mallSupportType" value="2" onchange="mallChange('2');" /> <span class="left" style="margin-top:2px;">部分门店</span>
				<label><a id="addMallBtn" style="display:none;" href="<%=basePath%>/shop/shopwinList?pageIndex=1" target="popupWin1" onclick="popupProOpen1();"><span style="margin: 0;" class="back_dblue left btn">添加门店</span></a></label>
				<input type="hidden" id="mall_codes" value="${query.mall_codes}" name="mallCode">
			</div>
			<div class="row-list" id="mallNamesDiv" style="display:none;">
				<label>已选择门店:</label>
				<input class="td_text_w" type="text" readonly='readonly' id="mall_names" name="mallname" value="" />
			</div>
			<div class="row-list">
				<label>发券张数<span style="color:red">*</span>：</label>
				<input class="td_text_w" type="text" name="totalNum" id="totalNum" value="0" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /><label>张</label>
			</div>
		</div>
		<div class="line"></div>
		<div class="editRight">
			<div class="row-list">
				<label>卡券有效期<span style="color:red">*</span>：</label>
				<input type="text" style="width: 31%;" placeholder="卡券有效期起" name="startTimeStr" id="startTimeStr" class="datatime-input" />
				<input type="text" style="width: 32%;" placeholder="卡券有效期止" name="endTimeStr" id="endTimeStr" class="datatime-input" />
			</div>
			<div class="row-list">
				<label>使用有效期<span style="color:red">*</span>：</label>
				<input type="radio" style="border:none;" name="timeType" value="1" class="left" /> <span class="left" style="margin-top: 2px;">固定时间</span>
				<input style=" height:30px;width:25%;" type="text" name="useStartTimeStr" id="useStartTimeStr"  class="datatime-input left" />
				<span style="float:left;margin-top: 2px;">至</span>
				<input style=" height:30px;width:25%;type="text" name="useEndTimeStr" id="useEndTimeStr"  class="datatime-input left" /><br>
			</div>
			<div class="row-list">
				<label></label>
				<input type="radio" style="border:none;" name="timeType" value="2" class="left"/>
	 			<span class="left" style="margin-top: 2px;">领取后，</span>
				<input style="width:53.6%;" class="left" type="text" name="validBeginDay" id="validBeginDay" value="0" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span class="left" style="margin-top: 2px; ">天生效</span>
			</div>
			<div class="row-list">
				<label></label>
				<span style="float: left;margin-top: 2px;">有效期</span>
				<input style="width:58.1%;" class="left" type="text" name="validDay" id="validDay" value="" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span class="left" style="margin-top: 2px;">天 (0表示当天生效)</span>	
			</div>
			<div class="row-list">
				<label>使用场景<span style="color:red">*</span>：</label>
				<input class="left" style="border:none;"  type="radio" name="supportCondition" value="1" /><span class="left"  style="border:none;margin-top:2px;">线上使用</span>
				<input class="left" style="border:none;" type="radio" name="supportCondition" value="2" /><span class="left" style="border:none;margin-top:2px;">线下使用</span>
				<input class="left" style="border:none;" type="radio" name="supportCondition" value="3" /><span class="left"  style="border:none;margin-top:2px;">线上线下都支持</span>
			</div>
		</div>
	</div>
		
	</form>
	</section>
	<div class="bgbtn">
			<!-- <input style="margin-left:-202%;" type="button" value="保存" class="left btn back_dblue" onclick="doSubmit();"/> 
			<input style="margin-left:-140%;" type="button" value="返回" class="left btn back_dblue" onclick="doBack()" /> -->
			<button type="button" onclick="doSubmit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
			<button type="button" class="left back_dblue btn" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
		</div>
	
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" style="position: absolute;z-index:1002;display:none;width: 80%; height: 80%; background-color: white; position: absolute; left: 10%; top:12%;">
        <span class="disp" onclick="popupProClose();" style="cursor:pointer;position:absolute;top:-20px;right:-20px;height:40px;width:40px;border-radius:20px;line-height:40px;font-size:18px;color:#323232;text-align:center;">×</span>  
		<iframe style="position: absolute; width: 100%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	
	<div id="fade1" class="black_overlay">  
    </div>
    <div id="popupDiv1" style="position: absolute;z-index:1002;display:none;width: 80%; height: 80%; background-color: white; position: absolute; left: 10%; top:12%;">
        <span class="disp" onclick="popupProClose1();" style="cursor:pointer;position:absolute;top:-20px;right:-20px;height:40px;width:40px;border-radius:20px;line-height:40px;font-size:18px;color:#fff;text-align:center;">×</span>  
		<iframe style="position: absolute; width: 100%; height: 100%; border-radius: 3px;" id="popupWin1" name="popupWin1" frameborder="0">
		</iframe>  
   	</div> 
   </div>
</body>
</html>

<script>
function mallChange(o){
	if(o=='1'){
		$("#addMallBtn").hide();
		$("#mall_codes").val('');
		$("#mall_names").val('');
		$("#mallNamesDiv").hide();
	}else if(o=='2'){
		$("#addMallBtn").show();
		$("#mallNamesDiv").show();
	}
}
$("#useStartTimeStr").focus(function(){
	 $(this).siblings("input[name='timeType']").prop('checked', 'checked');
})
$("#useStartTimeStr").focus(function(){
	 $(this).siblings("input[name='timeType']").prop('checked', 'checked');
})
$("#validBeginDay").focus(function(){
	 $(this).siblings("input[name='timeType']").prop('checked', 'checked');
})
</script>