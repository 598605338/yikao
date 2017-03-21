<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<style>
/*body{
   
}*/
   td{
      border:none;
   }
   .td_left{
   width:7.5%;
   	text-align:right;
  
   }
   .td_right{
     width:10%;
     height:40px;
   }
   .td_text_w{
     width:30%;
   }
   .bgbtn{
    width:20%;
    position:absolute;
    left:45%;top:56%;
   }
   @media screen and (max-width: 1300px) {
    .bgbtn{
        position:absolute;
        left:42%;
        top:56%;
    }
}
	.opty{
    width: 100%;
    height: 133%;
    background-color:#FFFFFF;
    z-index:500;
    -moz-opacity: 0.8;
    opacity: 0.60;
   /* filter: alpha(opacity=100);*/
   progid:DXImageTransform.Microsoft.Alpha(Opacity=100).
}
.play{
	display:none;
}
</style>
<script>
function doSubmit(){
	var form = document.saveForm;
	var oldPassword = form.oldPassword.value;
	var newPassword = form.newPassword.value;
	var confirmPassword = form.confirmPassword.value;
	if(oldPassword==null || oldPassword==''){
        document.saveForm.oldPassword.focus();
        alert("请填写原密码！");return false;
	}
	if(newPassword==null || newPassword==''){
        document.saveForm.newPassword.focus();
        alert("请填写密码！");return false;
	}else if(newPassword.length < 6){
		document.saveForm.newPassword.focus();
        alert("密码长度不能小于6位！");return false;
	}
	if(confirmPassword==null || confirmPassword==''){
        document.saveForm.confirmPassword.focus();
        alert("请填写确认密码！");return false;
	}else if(confirmPassword != newPassword){
        alert("新密码与确认密码不一致！");return false;
	}
	
	$.ajax({
		cache:false,
		type:"POST",
		url:"<%=basePath%>secuser/updatePassword",
		data:$(form).serialize(),
		success:function(result){
			alert(result.message);
			location.href = "<%=basePath%>doLogout";
		},
		error:function(result){
			alert("请求错误");
			<%-- location.href = "<%=basePath%>doLogout"; --%>
		}
	});
}

//返回
function doBack(){
$(".pass_a").css("display","none");
 /*  $("body").removeClass("opty"); */
 $(".zezhaoc").hide();
}
</script>
<body>
<div id="wrap">
 <div style="width:20%;height:279px;border:1px solid #AAAAAA;position:absolute;top:35%;left:40%;background:#BEEBEE;z-index:1000;display:block;" class="pass_a">
     <font color="red"><c:out value="${message }" /></font>
	<header class="cont_section_header" style="text-align:center;background:none;color:#3BB3E0;">用户密码修改</header>
	<!-- <header class="cont_section_header_bread">
		<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
		<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
		<span style="color:#3bb3e0;">用户密码修改</span>
	</header> -->
	<section class="cont_section_section">
	<form class="goods_new" name="saveForm" action="" method="post">
	<input type="hidden" name="id" id="id" value="${id }"/>
		<table cellpadding="0" cellspacing="0">
			<tbody>
				<tr class="height">
					<td class="td_left"  style="text-align:center;">
						<label style="letter-spacing:4px;">原密码：</label>
					</td>
					<td class="td_right">
						<input style="width:100%;margin-left:-18%;" class="td_text_w" type="password" name="oldPassword" id="oldPassword" value="" />
					</td>
				</tr>
				<tr class="height">
					<td class="td_left" style="text-align:center;">
						<label style="letter-spacing:4px;">新密码：</label>
					</td>
					<td class="td_right">
						<input style="width:100%;margin-left:-18%;" class="td_text_w" type="password" name="newPassword" id="newPassword" value="" />
					</td>
				</tr>
				<tr class="height">
					<td class="td_left"  style="text-align:center;">
						<label>确认密码：</label>
					</td>
					<td class="td_right">
						<input style="width:100%;margin-left:-18%;" class="td_text_w" type="password" name="confirmPassword" id="confirmPassword" value="" />
					</td>
				</tr>
			</tbody>
		</table>
			<!-- <p style="width:40%;height:30px;display:inline-block;float:left;"><input style="margin:10% 0% 0% 28%;width:85%;height:33px;text-align:center;"  type="button" value="保存" class="left btn back_dblue" onclick="doSubmit()"/></p> 
			<p style="width:40%;display:inline-block;float: right;"><input style="margin:10% 0% 0% 5%;width:85%;height:33px;text-align:center;"  type="button" value="返回" class="left btn back_dblue" onclick="doBack()" /></p> -->
			<p style="width:40%;height:30px;display:inline-block;float:left;"><button type="button" style="margin:10% 0% 0% 28%;width:85%;height:33px;text-align:center;"  class="left btn back_dblue" onclick="doSubmit()"><i class="icon-btn icon-save"></i>保存</button></p> 
			<p style="width:40%;display:inline-block;float: right;"><button type="button" style="margin:10% 0% 0% 5%;width:85%;height:33px;text-align:center;" class="goBack left btn back_dblue" onclick="doBack()" ><i class="icon-btn icon-goback"></i>返回</button></p>
	</form>
	</section>
</div>

</div>
	
</body>
</html>