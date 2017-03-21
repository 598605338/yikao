<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	var cardCouponId = form.cardCouponId.value;
	var name = form.name.value;
	var publishStartTimeStr = form.publishStartTimeStr.value;
	var publishEndTimeStr = form.publishEndTimeStr.value;
	var publishNum = form.publishNum.value;
	if(cardCouponId==null || cardCouponId==''){
        document.editForm.name.focus();
        alert("请选择卡券！");return false;
	}
	if(name==null || name==''){
        document.editForm.name.focus();
        alert("请输入活动名称！");return false;
	}
	if(publishStartTimeStr==null || publishStartTimeStr==''){
        document.editForm.publishStartTimeStr.focus();
        alert("请输入发放开始时间！");return false;
	}
	if(publishEndTimeStr==null || publishEndTimeStr==''){
        document.editForm.publishEndTimeStr.focus();
        alert("请输入发放结束时间！");return false;
	}
	if(publishNum==null || publishNum==''){
        document.editForm.publishNum.focus();
        alert("请输入发放卡券张数！");return false;
	}
	
	//发放数量不能超过所选卡券的剩余数量
	if(!countSurplusNum()){
		return false;
	}
	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}

window.onload=function(){
	var startDateTextBox = $('#publishStartTimeStr');
	var endDateTextBox = $('#publishEndTimeStr');

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
		display:block;
		margin-left:-18%;
	}
	.height{
		height:40px;
	}
	.td_left{
		width:22%;
	}
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">领券中心管理</header> -->
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">领券中心管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
	<section class="cont_section_section_border">
	<form class="goods_new" name="editForm" action="edit" method="post">
		<input type="hidden" name="id" id="id" value="<c:out value="${receiveCardCoupon.id }"/>"/>
	
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>活动名称：</label>
					<input  class="td_text_w" type="hidden" name="cardCouponId" id="cardCouponId" value="<c:out value="${receiveCardCoupon.cardCouponId }"/>" />
					<input class="td_text_w" type="text" name="name" id="name" value="<c:out value="${receiveCardCoupon.name }"/>" maxlength="50" />
				</div>
				<div class="row-list">
					<label>发放时间：</label>
					<input style="width: 31%;" type="text" name="publishStartTimeStr" id="publishStartTimeStr" value="<fmt:formatDate value="${receiveCardCoupon.publishStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"  class="datatime-input"  />
					<input style="width: 32%;" type="text" name="publishEndTimeStr" id="publishEndTimeStr" value="<fmt:formatDate value="${receiveCardCoupon.publishEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"  class="datatime-input"  />
				</div>
				<div class="row-list">
					<label>发放方式：</label>
					<input style="float:left;border:none;"  type="radio" name="publishType" id="publishType" value="1" checked="checked" /><span style="margin-top: 2px;">投放到领券中心</span>
				</div>
				<div class="row-list">
					<label>卡券：</label>
					<input style="width: 25%;" type="text" name="publishNum" id="publishNum" value="<c:out value="${receiveCardCoupon.publishNum }"/>"  maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><b style="float: left;">张</b> 
					<input style="width: 23%;margin-right: 1.5%;" type="text" name="cardName" id="cardName" readonly="readonly" value="<c:out value="${receiveCardCoupon.cardName }"/>" /><a href="<%=basePath%>/cardCoupon/select?popupFlg=1&params=cardCouponId,cardName" target="popupWin" onclick="popupProOpen();"><span style="margin:0;position: relative;margin-top: 1px;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
				</div>
			</div>
			<div class="line"></div>
			<div class="editRight">
				<div class="row-list">
				
				</div>
			</div>
		</div>
	
	</form>
	</section>
	<div class="bgbtn">
		<!-- <input style="margin-left:-231%" type="button" value="保存" class="left btn back_dblue" onclick="doSubmit()" /> 
		<input style="margin-left:-177%" type="button" value="返回" class="left btn back_dblue" onclick="doBack()" /> -->
		<button type="button" onclick="doSubmit()" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue btn" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" class="iframeWrap">
        <span class="dispnew" onclick="popupProClose();" >×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   </div>
</body>
</html>
<script>

//查询剩余的卡券数量 
function countSurplusNum(){
	var cardCouponId = $("#cardCouponId").val();
	var publishNum = $("#publishNum").val();
	var re = false;
	$.ajax({
		cache:false,
		async:false,
		type:"POST",
		url:"countSurplusNum",
		data:{"cardId":cardCouponId},
		success:function(result){
			if(publishNum > result["count"]){
				alert("发放数量最多为" + result["count"] +"张");
				re = false;
			}else{
				re = true;
			}
		}
	});
	
	return re;
}
</script>
	<script type="text/javascript">
	var browser=navigator.appName
	var b_version=navigator.appVersion
	var version=b_version.split(";");
	var trim_Version=version[1].replace(/[ ]/g,""); 
	 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
	  $(".td_left").css("width","7%")
	}
</script>