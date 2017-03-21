<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js"></script>
<script type="text/javascript">
	 function cunrentPage(){
		 $("#cunrentPage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
		 $('#formain').submit();
	} 
	
	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
	 /**2017.2.10
	  * 提交表单时判断非空。
	  */
	 function doSubmitCheck(){
			var form = document.formain;
			var bannerName = form.ad_position_name.value;
			var adLink = form.ad_link.value;
			if(adLink==null || adLink==''){
		        alert("链接不能为空！");
		        return false;
			}
			if(bannerName==null || bannerName==''){
		        alert("广告名称不能为空！");
		        return false;
			}
			document.getElementById('formain').submit();
			return true;
		}

</script>
<body>
<div id="wrap">
<c:out value="${message }" />
		<section class="cont_section height_all">
				<!-- <header class="cont_section_header">广告修改</header>  -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClickList" style="color: #323232;">广告位管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">广告修改</span>
				</header>
				<div class="height">
					<span class="right back_dblue btn" onclick="window.history.back()">返回</span>
				</div>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="<%=path%>/advManage/updateAdvInfoById" enctype="multipart/form-data" >
						<table cellspacing="none" style="width:50%;text-align:center;">
						<tbody>
							<tr class="goods_tr" >
								<td style="width:40%">广告位名称：</td>
								<td><input name="ad_position_name" id="ad_position_name" type="text" class="left" value="${advitise.ad_position_name}"/></td>
							</tr>	
							<tr>
								<td>图片：</td>
								<td class="td_right">
									<div class="imgbox">
	    								<div class="imgnum">
	        								<input name="uploadImage" id="uploadImage" type="file" class="filepath"/>
	       									<span class="close" style="top:0px; !important">X</span>
	        								<img src="${advitise.picture}" class="img2" />
	        								<img src="<%=path %>/js/inputFile/btn.png" class="img1" />
	    								</div>
									</div>
								</td>
							</tr>	
							<tr class="goods_tr" >
								<td>链接：</td>
								<td><input name="ad_link" id="ad_link" type="text" class="left" value="${advitise.ad_link}"/>
								<input name="id" id="id" type="hidden" class="left" value="${advitise.id}"/>
								<input name="ad_type" id="ad_type" type="hidden" class="left" value="${advitise.ad_type}"/>
								</td>
							</tr>	
							</tbody>
							</table>
							<div class="height">
								<div class="bgbtn flex">
									<!-- <span ><input type="submit" value="保存" class="left back_dblue col_white btn"/></span>
									<span ><input type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span> -->
									<span ><button type="button" onclick="doSubmitCheck();" class="left back_dblue col_white btn"><i class="icon-btn icon-save"></i>保存</button></span>
									<span ><button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button></span>
								</div>								
							</div>
						</form>
						</div>						
				</section>
			</section>
			</div>
	</body>
</html>
