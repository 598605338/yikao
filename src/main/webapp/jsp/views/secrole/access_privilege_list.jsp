<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
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
	.height{
       width:25%;
       display: inline;
       float:left;
	}
</style>
<body>
	<section class="cont_section_section_border">
	<!-- <header class="cont_section_header">访问授权</header> -->
	<header class="cont_section_header_bread">
		<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
		<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
		<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">权限管理</a><span>&gt;</span>
		<span style="color:#3bb3e0;">访问授权</span>
	</header>
	<form class="goods_new height_auto" id="formSubmit" action="updatePrivilege" method="post">
	<input type="hidden" name="secroleId" id="secroleId" value="<c:out value="${secroleId }"/>" />
     <div style="width:100%;display:inline;float:left;">
	     	<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_1"  value="1" /><label class="left">商品管理：</label> 
			</div>
			<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_2" value="2" /><label class="left">活动管理：</label> 
			</div>	
			<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_3" value="3" /><label class="left">门店管理：</label> 
			</div>
			<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_4" value="4" /><label class="left">卡券管理：</label> 
			</div>
     </div>
     <div style="width:100%;display:inline;">
	     	<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_5" value="5" /><label class="left">订单管理：</label> 
			</div>
			<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_6" value="6" /><label class="left">运营管理：</label> 
			</div>
			<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_7" value="7" /><label class="left">财务管理：</label> 
			</div>
			<div class="height">
				<input class="left" type="checkbox" <shiro:lacksRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">disabled = "disabled"</shiro:lacksRole>
					name="privilegeIds" id="privilegeIds_8" value="8" /><label class="left">会员管理：</label> 
			</div>
    </div>
	</form>
	</section>
	<div class="bgbtn">
		<!-- <input type="submit" value="保存" class="left btn back_dblue" /> 
		<input type="button" value="返回" class="left btn back_dblue" onclick="window.history.back()" /> -->
		<button type="button" onclick="document.getElementById('formSubmit').submit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
</body>
</html>

<script>
var l = [];
l= <c:out value="${privilegeListStr}"/>;
for(i=1;i<=l.length;i++){
$("#privilegeIds_"+l[i-1]).attr("checked",true);
}

</script>
