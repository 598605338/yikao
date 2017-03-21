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
<link href="<%=path%>/js/divPage/dividePage.css" type="text/css" rel="Stylesheet" />
<script type="text/javascript" src="<%=path%>/js/divPage/dividePage.js"></script>
<jsp:include page="../header.jsp" />
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<script>
//返回
function doBack(){
	document.location.href="select";
}
</script>
<style>
	.cont_section_head span,input{
		border: 0;
	}
	.section_table tr input{display: inline;}
</style>
<body>
<div id="wrap">
<font color="red"><c:out value="${message }" /></font>
				<!-- <header class="cont_section_header">新品推荐管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新品推荐管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="" style="border:none;">
					<form name="form" action="edit" method="post">
						<div class="section_table">
						<table class="table_hover" cellspacing="none">
						<thead style="background:#EBEBEB;">
							<th>排序</th>
							<th>商品名称</th>
							<th>商品编码</th>
							<th>商品图片</th>
							<th>市场价</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${newProductRecommendList }" varStatus="status">
							<tr class="goods_tr">
								<td style="width:2.5%;">
									<input style="text-align:center;" type = "text" name="sortIndex" id="sortIndex${status.index }" value="${item.sortIndex }" readonly='readonly'/>
									<input style="text-align:center;" type = "hidden" name="id" id="id${status.index }" value="${item.id }"/> 
									<input style="text-align:center;" type = "hidden" name="productId" id="productId${status.index }" value="${item.productId }"/> 
								</td>
								<td><input style="text-align:center;" type = "text" name="pName" id="pName${status.index }" value="${item.pName }" readonly='readonly'/></td>
								<td><input style="text-align:center;" type = "text" name="pCode" id="pCode${status.index }" value="${item.pCode }" readonly='readonly'/></td>
								<td style="text-align:center;"><img style="display:inline-block;width:80px;height: 60px;margin-left:5%;" name="imageSrc" id="imageSrc${status.index }" src="${item.imagePath }" />
									<input type = "hidden" name="imagePath" id="imagePath${status.index }" value="${item.imagePath }"/> 
								</td>
								<td><input style="text-align:center;" type = "text" name="marketPrice" id="marketPrice${status.index }" value="${item.marketPrice }" readonly='readonly'/></td>
								<td class="amend" style="text-align:center;">
									<a href="<%=basePath%>/product/select?popupFlg=1&params=productId${status.index },pCode${status.index },pName${status.index },null,imageSrc${status.index },marketPrice${status.index },imagePath${status.index }" target="popupWin" onclick="popupProOpen();"><span style="display:inline-block;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
					</form>				
						</div>		
					</div>					
				</section>
				<div class="bgbtn">
					<button type="button" onclick="document.form.submit()" class="left back_dblue col_white btn"><i class="icon-btn icon-save"></i>保存</button>
					<!-- <input style="margin-left:-176%;" type="button" value="返回" class="left btn back_dblue" onclick="doBack();" /> -->
				</div>	
				
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" style="position: absolute;z-index:1002;display:none;width: 90%; height: 90%; background-color: white; position: absolute; left: 5%; top:6%;padding: 0 14px;">
        <span class="disp" onclick="popupProClose();" style="cursor:pointer;position:absolute;top:-15px;right:-15px;height:40px;width:40px;border-radius:20px;line-height:34px;color:#000;text-align:center;font-size:30px;">×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	</div>
</body>
</html>

