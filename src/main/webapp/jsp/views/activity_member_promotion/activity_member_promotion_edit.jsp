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
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<header class="cont_section_header">会员促销管理</header>
	<section class="cont_section_section">
	<form class="goods_new" name="form" action="" method="post">
	<input type="hidden" name="id" id="id" value="${activityMemberPromotion.id }"/>
		<table cellpadding="0" cellspacing="0">
			<tbody>
				<tr class="height">
					<td class="td_left">
						<label>活动类型：</label>
					</td>
					<td class="td_right">
						<input class="left" type="radio" name="activityType" id="activityType" checked="checked" value="1"/><label class="left">注册 </label>  
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>促销名称：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="activityName" id="activityName" value="<c:out value="${activityMemberPromotion.activityName }"/>"/>
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>促销时间：</label>
					</td>
					<td class="td_right">
						<input class="datatime-input" type="text" name="startTimeStr" id="startTimeStr" value="<fmt:formatDate value="${activityMemberPromotion.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" />
						<label class="left">～</label> 
						<input class="datatime-input" type="text" name="endTimeStr" id="endTimeStr" value="<fmt:formatDate value="${activityMemberPromotion.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" />
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>奖项类型：</label>
					</td>
					<td class="td_right">
						<input class="left" type="radio" name="prizeType" value="1" onclick="changePrizeType(1);" disabled="disabled" /><label class="left">积分</label>
						<input class="left" type="radio" name="prizeType" value="2" onclick="changePrizeType(2);" /><label class="left">卡券</label>
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>奖品名称：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="prizeName" id="prizeName" value="<c:out value="${activityMemberPromotion.prizeName }"/>" />
						<input class="td_text_w" type="hidden" name="cardCouponId" id="cardCouponId" value="<c:out value="${activityMemberPromotion.cardCouponId }"/>" />
						<a href="<%=basePath%>/cardCoupon/select?popupFlg=1&params=cardCouponId,prizeName" target="popupWin" onclick="popupProOpen();"><span style="display:inline-block;" class="back_dblue btn">选择</span></a>
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>奖品数量：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="prizeNum" id="prizeNum" value="<c:out value="${activityMemberPromotion.prizeNum }"/>" />
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>排序：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="sortIndex" id="sortIndex" value="<c:out value="${activityMemberPromotion.sortIndex }"/>" />
					</td>
				</tr>
			</tbody>
		</table>
	
	
		<div class="bgbtn">
			<!-- <input type="submit" value="保存" onclick="submitForm();return false;" class="left btn back_dblue" /> 
			<input type="button" value="返回" class="left btn back_dblue" onclick="window.history.back()" /> -->
			<button type="button" onclick="submitForm();return false;" class="left btn back_dblue" ><i class="icon-btn icon-save"></i>保存</button> 
			<button type="button" class="left btn back_dblue" onclick="window.history.back()" ><i class="icon-btn icon-goback"></i>返回</button>
		</div>
	</form>
	</section>
	
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" style="position: absolute;z-index:1002;display:none;width: 80%; height: 80%; background-color: white; position: absolute; left: 10%; top:12%;">
        <span class="disp" onclick="popupProClose();" style="cursor:pointer;position:absolute;top:-20px;right:-20px;height:40px;width:40px;border-radius:20px;line-height:40px;font-size:18px;color:#fff;text-align:center;">×</span>  
		<iframe style="position: absolute; width: 100%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	</div>
</body>
</html>
<script>
/**
 * 初始化日期插件
 */
window.onload=function(){		 
	$('#startTimeStr').datetimepicker({
		dateFormat:'yy-mm-dd',
		timeFormat: 'HH:mm:ss',
		stepHour: 1,
		stepMinute: 1,
		stepSecond: 1
	});
	
	$('#endTimeStr').datetimepicker({
	 	dateFormat:'yy-mm-dd',
		timeFormat: 'HH:mm:ss',
		stepHour: 1,
		stepMinute: 1,
		stepSecond: 1
	});
}
var prizeType = <c:out value="${activityMemberPromotion.prizeType }"/>
$("[name='prizeType'][value="+prizeType+"]").attr("checked",true);
if(prizeType ==2){
	$("#cardCouponIdDiv").show();
}else{
	$("#cardCouponIdDiv").hide();
}

function changePrizeType(prizeType){
	if(prizeType == 2){
		$("#cardCouponIdDiv").show();
	}else{
		$("#cardCouponIdDiv").hide();
	}
}

function submitForm(){
	$.ajax({
		cache:false,
		type:"POST",
		url:"edit",
		data:$("[name='form']").serialize(),
		success:function(result){
			if(result.status=='ok'){
				location.href="select";
			}else{
				alert(result.message);
			}
		}
	});
}
</script>