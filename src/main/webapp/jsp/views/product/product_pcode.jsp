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
<jsp:include page="../header.jsp" />
<script>
function doSubmitCheck(){
	var form = document.saveForm;
	var pCode = form.pCode.value;
	if(pCode==null || pCode==''){
        alert("商品条形码不能为空！");
        return false;
	}
	var flag=false;
	$.ajax({
		async:false,
		cache:false,
		method:"POST",
		url:"checkPCode",
		data:{"pCode":pCode},
		success:function(result){
			if(result["status"] == 'error'){
				alert(result["message"]);
			}else{
				flag = true;
			}
		}
	});
	document.getElementById('formSubmit').submit();
	return flag;
}

//生成条形码
function generatePcode(){
	$.ajax({
		cache:false,
		method:"POST",
		url:"generatePcode",
		data:{},
		success:function(result){
			if(result["status"] == 'ok'){
				var pCode = result["pCode"];
				$("#pCode").val(pCode);
			}
		}
	});
}

//返回
function doBack(){
	document.location.href="select";
}
</script>
<style>
	.td_text_w{
		width:25%;
		margin-left:-13%;
		padding-left: 5px;
	}
	.ack{
		margin-left:-239%;
		margin-top:7%;
	}
	.bck{
		margin-left:-195%;
		margin-top:7%;
	}
	.dbl{
		margin-left:0%;
	}
</style>
<body>
<div id="wrpa">
		<!-- <header class="cont_section_header">商品管理</header> -->
		<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">商品</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">商品管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增商品</span>
				</header>
<section class="cont_section_section_border">
					<form class="goods_new" id="formSubmit" name="saveForm" action="toAdd" method="post">		
					<table cellpadding="0" cellspacing="0" style="0px;">
					<tbody>
						<tr class="height">
							<td class="td_left barCode" style="border:none;">
								<label style="display:block;width:60%;">商品条形码<span style="color:red">*</span>：</label>
							</td>
							<td class="td_right"  style="border:none;">
								<input class="td_text_w" type="text" name="pCode" id="pCode" value="" maxlength="50" />
								<button type="button" class="btn back_dblue" style="display:inline-block;" onclick="generatePcode();" ><i class="icon-btn icon-createcode"></i>创建条形码</button>
							</td>
						</tr>
					</tbody>
					</table>


		</form>
</section>
<div class="bgbtn">
			<button type="button" class="left btn back_dblue" onclick="doSubmitCheck()"><i class="icon-btn icon-next"></i>下一步</button> 
			<button type="button" class="left btn back_dblue" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
		</div>
</div>
</body>
</html>
