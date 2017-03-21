<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	var form = document.editForm;
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
		 document.editForm.cardName.focus();
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
			document.editForm.amount.focus();
	        alert("请填写代金券金额！");return false;
		}
	}
	if(description==null || description==''){
        document.editForm.description.focus();
        alert("请编辑优惠券使用规则！");return false;
	}
	
	if(cardType==3 || cardType==5){
		var limitMoney = form.limitMoney.value;
		if(limitMoney==null || limitMoney==''){
      	  	document.editForm.limitMoney.focus();
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
        document.editForm.totalNum.focus();
        alert("请输入发券张数！");return false;
	}
	if(startTimeStr==null || startTimeStr==''){
        document.editForm.startTimeStr.focus();
        alert("请选择卡券有效期开始日期！");return false;
	}
	if(endTimeStr==null || endTimeStr==''){
        document.editForm.endTimeStr.focus();
        alert("请选择卡券有效期结束日期！");return false;
	}
	if(timeType==null || timeType==''){
        alert("请选择使用有效期类型！");return false;
	}
	
	if(timeType == 1){
		//固定时间
		if(useStartTimeStr==null || useStartTimeStr==''){
       	 	document.editForm.useStartTimeStr.focus();
        	alert("请选择使用有效期开始时间！");return false;
		}
		if(useEndTimeStr==null || useEndTimeStr==''){
       		document.editForm.useEndTimeStr.focus();
        	alert("请选择使用有效期结束时间！");return false;
		}
	}else if(timeType == 2){
		//动态时间
		if(validBeginDay==null || validBeginDay==''){
       	 	document.editForm.validBeginDay.focus();
        	alert("请输入领取后几天生效！");return false;
		}
		if(validDay==null || validDay==''){
       		document.editForm.validDay.focus();
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
	document.location.href="select";
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
		height:50px;
		line-height:35px;
	}
	.td_left{
		width:12%;
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
		<span style="color:#3bb3e0;">修改</span>
	</header>
	<section class="cont_section_section_border">
	<form name="editForm" class="goods_new" action="edit" method="post">
	<input type="hidden" value="<c:out value="${cardCoupon.cardType }"/>" name="cardType" id="cardType" />
	<input type="hidden" value="<c:out value="${cardCoupon.cardId }"/>" name="cardId" id="cardId" />
	<input type="hidden" value="<c:out value="${cardCouponProduct.productId }"/>" name="productId" id="productId" />
	<input type="hidden" value="<c:out value="${cardCouponProduct.productId }"/>" name="cardCouponProductId" id="cardCouponProductId" />
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>卡券名称<span style="color:red">*</span>：</label>
					<c:choose>
						<c:when test="${cardCoupon.cardType==1 }">
							<input style="width: 48.5%;" class="td_text_w" type="text" name="cardName" id="cardName" value="<c:out value="${cardCoupon.cardName }"/>" maxlength="255" />
							<a href="<%=basePath%>/product/select?popupFlg=1&params=productId,pCode,pName,null,imageSrc,marketPrice" target="popupWin" onclick="popupProOpen();"><span style="margin: 0;width: 9.5%;position: relative;top: 1px;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
						</c:when>
						<c:otherwise>
							<input class="td_text_w" type="text" name="cardName" id="cardName" value="<c:out value="${cardCoupon.cardName }"/>" maxlength="255" />
						</c:otherwise>
					</c:choose>
				</div>
				<c:if test="${cardCoupon.cardType==1 }">
					<div class="row-list">
						<label>商品名：</label>
						<input class="td_text_w" type="text" name="pName" id="pName" value="<c:out value="${cardCouponProduct.pName }"/>" readonly="readonly"/>
					</div>
					<div class="row-list">
						<label>商品编码：</label>
						<input class="td_text_w" type="text" name="pCode" id="pCode" value="<c:out value="${cardCouponProduct.pCode }"/>" readonly="readonly"/><b>元</b>
					</div>
					<div class="row-list">
						<label>市场价：</label>
						<input class="td_text_w" type="text" name="marketPrice" id="marketPrice" value="<c:out value="${cardCouponProduct.marketPrice }"/>" readonly="readonly"/>
					</div>
					<div class="row-list">
						<label>商品图片：</label>
						<img src="<c:out value="${cardCouponProduct.imagePath }"/>" width="120px" name="imageSrc" id="imageSrc" class="img1" />
					</div>
				</c:if>
				<c:if test="${cardCoupon.cardType==3 }">
					<div class="row-list">
						<label>卡券金额<span style="color:red">*</span>：</label>
						<input class="td_text_w" type="text" name="amount" id="amount" value="<c:out value="${cardCoupon.amount }"/>" maxlength="10" onkeyup="clearNoNum(this);" />
					</div>
				</c:if>
				<div class="row-list">
					<label style="font-size: 12px;">卡券使用规则<span style="color:red">*</span>：</label>
					<textarea name="description" id="description" class="td_text_w" maxlength="255"
						style="width: 63.5%; height: 100px;"><c:out value="${cardCoupon.description }"/></textarea>
				</div>
				<c:if test="${cardCoupon.cardType ==3 || cardCoupon.cardType ==5 }">
					<div class="row-list">
						<label>使用门槛<span style="color:red">*</span>：</label>
						<b style="float: left;">满</b><input style="width:60.1%;margin-left: 1%;" class="td_text_w" type="text" name="limitMoney" id="limitMoney" value="<c:out value="${cardCoupon.limitMoney }"/>" maxlength="10" onkeyup="clearNoNum(this);" /><b>元</b>
					</div>
				</c:if>
				<div class="row-list">
					<label>参与门店<span style="color:red">*</span>：</label>
					<input class="left" style="border:none;"  type="radio" name="mallSupportType" value="1" onchange="mallChange('1');" /> <span class="left" style="margin-top:2px;">全部门店</span>
					<input class="left" style="border:none;" type="radio" name="mallSupportType" value="2" onchange="mallChange('2');" /> <span class="left" style="margin-top:2px;">部分门店</span>
					<div style="margin-left:10%;display:none;" id="addMallBtn"><a href="<%=basePath%>/shop/shopwinList?pageIndex=1" target="popupWin1" onclick="popupProOpen1();"><span style="display:inline-block;" class="back_dblue left btn">添加门店</span></a></div>
					<input type="hidden" id="mall_codes" value="${cardCoupon.mallCode}" name="mallCode">
				</div>
				<div class="row-list" id="mallNamesDiv" style="display:none;">
					<label>已选择门店:</label>
					<input class="td_text_w" type="text" readonly='readonly' id="mall_names" name="mallname" value="<c:out value="${cardCoupon.mallname }"/>" />
				</div>
				<div class="row-list">
					<label>发券张数<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="totalNum" id="totalNum" value="<c:out value="${cardCoupon.totalNum }"/>" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /><label>张</label>
				</div>
			</div>
			<div class="line"></div>
			<div class="editRight">
				<div class="row-list">
					<label>卡券有效期<span style="color:red">*</span>：</label>
					<input  style="width: 31%;" type="text" name="startTimeStr" id="startTimeStr" value="<fmt:formatDate value="${cardCoupon.startTime }" pattern="yyyy-MM-dd HH:mm:ss" />" class="datatime-input"  />
					<input style="width: 32%;" type="text" name="endTimeStr" id="endTimeStr" value="<fmt:formatDate value="${cardCoupon.endTime }" pattern="yyyy-MM-dd HH:mm:ss" />"  class="datatime-input"  />
				</div>
				<div class="row-list">
					<label>使用有效期<span style="color:red">*</span>：</label>
					<input  style="border:none;" type="radio" name="timeType" value="1" class="left" /> <span class="left" style="margin-top: 2px;">固定时间</span>
				    <input style=" height:30px;width:25%;" type="text" name="useStartTimeStr" id="useStartTimeStr" value="<fmt:formatDate value="${cardCoupon.useStartTime }" pattern="yyyy-MM-dd HH:mm:ss" />" class="datatime-input left" />
				    <span style="float:left;margin-top: 2px;">至</span>
				    <input style=" height:30px;width:25%;" type="text" name="useEndTimeStr" id="useEndTimeStr" value="<fmt:formatDate value="${cardCoupon.useEndTime }" pattern="yyyy-MM-dd HH:mm:ss" />"  class="datatime-input left"  />
				</div>
				<div class="row-list">
					<label></label>
			        <input class="left" style="border:none;" type="radio" name="timeType" value="2" />
				    <span class="left" style="margin-top: 2px;">领取后，</span>
				    <input style="width:53.6%;" class="left" type="text" name="validBeginDay" id="validBeginDay" value="<c:out value="${cardCoupon.validBeginDay }"/>" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span class="left" style="margin-top: 2px;">天生效</span>
				</div>
				<div class="row-list">
					<label></label>
					<span style="float: left;margin-top: 2px;">有效期</span>
				    <input style="width:58.2%;" class="left" type="text" name="validDay" id="validDay" value="<c:out value="${cardCoupon.validDay }"/>" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /> <span style="margin-top: 2px;" class="left">天 (0表示当天生效)</span>
				</div>
				<div class="row-list">
					<label>使用场景<span style="color:red">*</span>：</label>
					<input class="left" style="border:none;" type="radio" name="supportCondition" value="1" /><span style="margin-top: 3px;" class="left">线上使用</span>
					<input class="left"  style="border:none;" type="radio" name="supportCondition" value="2" /><span style="margin-top: 3px;" class="left">线下使用</span>
					<input class="left"  style="border:none;" type="radio" name="supportCondition" value="3" /><span style="margin-top: 3px;" class="left">线上线下都支持</span>
				</div>
			</div>
		</div>
		
	</form>
	</section>
	<div class="bgbtn">
		<!-- <input style="margin:10% 0% 0% -197%;" type="button" value="保存" class="left btn back_dblue" onclick="doSubmit();"/> 
		<input style="margin:10% 0% 0% -197%;" type="button" value="返回" class="left btn back_dblue" onclick="doBack()" /> -->
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
   	
   		<!-- 弹出门店选择框 -->
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
$("[name='mallSupportType'][value=<c:out value="${cardCoupon.mallSupportType }"/>]").attr("checked",true);
$("[name='timeType'][value=<c:out value="${cardCoupon.timeType }"/>]").attr("checked",true);
$("[name='supportCondition'][value=<c:out value="${cardCoupon.supportCondition }"/>]").attr("checked",true);
$("[name='activityFlg'][value=<c:out value="${cardCoupon.activityFlg }"/>]").attr("checked",true);
var mallSupportVal = '<c:out value="${cardCoupon.mallSupportType }"/>';
mallChange(mallSupportVal);


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