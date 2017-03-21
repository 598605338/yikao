<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<jsp:include page="../header.jsp" />
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js"></script>
<script>
function doSubmit(){
	var form = document.editForm;
	var cardCouponId = form.cardCouponId.value;
	var exchangeType = form.exchangeType.value;
	var score = form.score.value;
	var quantity = form.quantity.value;
	var limitQuantity = form.limitQuantity.value;
	if(cardCouponId==null || cardCouponId==''){
        alert("请选择卡券！");return false;
	}
	if(exchangeType==null || exchangeType==''){
        document.editForm.exchangeType.focus();
        alert("请选择兑换方式！");return false;
	}
	if(score==null || score==''){
		document.editForm.score.focus();
        alert("请填写积分数！");return false;
	}
	if(quantity==null || quantity==''){
        document.editForm.activityPrice.focus();
        alert("请输入可兑换数量！");return false;
	}
	if(limitQuantity==null || limitQuantity==''){
        document.editForm.limitQuantity.focus();
        alert("请输入没人可兑换数量！");return false;
	}
	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}
</script>
<style>
	td{
		border:none;
	}
	.td_right{
		display:block;
		margin-left:-14%;
	}
	.height{
		height:40px;
	}
	.td_left{
		width:23%;
	}
	  .td_ss{
     	width:50%;
    	word-wrap:break-word
    	border:1px solid red;
    }
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<!-- <header class="cont_section_header">积分商城管理</header> -->
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">积分商城管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
	<section class="cont_section_section">
	<form class="goods_new" id="formSubmit" name="editForm" action="edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" id="id" value="<c:out value="${scoreProduct.id }"/>" />
		<table cellpadding="0" cellspacing="0">
			<tbody>
				<tr class="height">
					<td class="td_left">
						<label>名称：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="name" id="name" value="<c:out value="${scoreProduct.name }"/>" maxlength="50" />
						<input class="td_text_w" type="hidden" name="cardCouponId" id="cardCouponId" value="<c:out value="${scoreProduct.cardCouponId }"/>" />
						<input class="td_text_w" type="hidden" name="type" id="type" value="<c:out value="${scoreProduct.type }"/>" />
						<a href="<%=basePath%>/cardCoupon/select?popupFlg=1&params=cardCouponId,name,type" target="popupWin" onclick="popupProOpen();"><span style="display:inline-block;" class="back_dblue btn">选择</span></a>
					</td>
				</tr>
				<%-- <tr class="height">
					<td class="td_left">
						<label>列表图片：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="imagePath" id="imagePath" value="<c:out value="${scoreProduct.imagePath }"/>" />
					</td>
				</tr> --%>
				<tr class="height">
					<td class="td_left">
						<label>兑换方式<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right">
						<input style="border:none;" class="left" type="radio" name="exchangeType" onclick="changeDisplay(0);" value="0" /><label class="left">积分</label> 
						<input style="border:none" class="left" type="radio" name="exchangeType" onclick="changeDisplay(1);" value="1" /><label class="left">金钱+积分</label> 
					</td>
				</tr>
				<tr class="height">
							<td class="td_left">
								<label>商品图片<span style="color:red">*</span>：</label>
								<p class="td_ss">(请上传1242*834尺寸的图片)</p>
							</td>
							<td class="td_right">
								<div class="imgbox">
    								<div class="imgnum">
        								<input type="file" class="filepath" name="uploadImage" id="uploadImage" />
       									<span class="close" style="top:0px; !important">X</span>
        								<img src="<c:out value="${scoreProduct.imagePath }"/>" class="img1" />
        								<img src="" class="img2" />
    								</div>
								</div>
							</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>请输入积分数<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="score" id="score" value="<c:out value="${scoreProduct.score }"/>"  maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</td>
				</tr>
				<tr id="priceDiv" class="height">
					<td class="td_left">
						<label>请输入金钱数<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="price" id="price" value="<c:out value="${scoreProduct.price }"/>" maxlength="10" onkeyup="clearNoNum(this);" />
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>参与活动数量<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="quantity" id="quantity" value="<c:out value="${scoreProduct.quantity }"/>"  maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><label>张</label> 
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>每人可兑换数量<span style="color:red">*</span>：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="limitQuantity" id="limitQuantity" value="<c:out value="${scoreProduct.limitQuantity }"/>"  maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><label>张</label> 
					</td>
				</tr>
				<tr class="height">
					<td class="td_left">
						<label>排序：</label>
					</td>
					<td class="td_right">
						<input class="td_text_w" type="text" name="sortIndex" id="sortIndex" value="<c:out value="${scoreProduct.sortIndex }"/>"  maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		<div class="bgbtn">
			<!-- <input style="margin-left:-202%;" type="submit" value="保存" class="left btn back_dblue" /> 
			<input style="margin-left:-146%;" type="button" value="返回" class="left btn back_dblue" onclick="window.history.back()" /> -->
			<button type="button" style="margin-left:-202%;" onclick="document.getElementById('formSubmit').submit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
			<button type="button" style="margin-left:-146%;" class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</button>
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
var exchangeType = <c:out value="${scoreProduct.exchangeType }"/>
$("[name='exchangeType'][value="+exchangeType+"]").attr("checked",true);
changeDisplay(exchangeType);

function changeDisplay(exchangeType){
	if(exchangeType == 1){
		$("#priceDiv").show();
	}else{
		$("#priceDiv").hide();
	}
}
</script>
<script type="text/javascript"> 
var browser=navigator.appName 
var b_version=navigator.appVersion 
var version=b_version.split(";"); 
var trim_Version=version[1].replace(/[ ]/g,"");  
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") { 
$(".td_left").css("width","11%")
} 
</script>