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

	 function doSubmitCheck(){
			var form = document.formain;
			var bannerName = form.banner_name.value;
			var banLink = form.ban_link.value;
			var orderPx = form.order_px.value;
			if(bannerName==null || bannerName==''){
		        alert("banner名称不能为空！");
		        return false;
			}
			if(banLink==null || banLink==''){
		        alert("链接不能为空！");
		        return false;
			}
			if(orderPx==null || orderPx==''){
		        alert("排序不能为空！");
		        return false;
			}
			document.getElementById('formain').submit();
			return true;
		}
	 
</script>
<body>
<div id="wrap">
<c:out value="${message }" />
		<section class=" height_all"><!-- cont_section -->
				<!-- <header class="cont_section_header">banner添加</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClickList" style="color: #323232;">广告位管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">banner添加</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="<%=path%>/advManage/insertBannerInfo" enctype="multipart/form-data" >
						
							<div class="editPage">
								<div class="editLeft">
									<div class="row-list">
										<label>banner名称：</label>
										<input name="banner_name" class="td_text_w" id="banner_name" type="text" class="left" value="${bannerInfo.banner_name}"/>
									</div>
									<div class="row-list">
										<label>图片<span style="color:red">*</span>：</label>
										<div class="imgbox" style="border:1px solid #999999;">
		    								<div class="imgnum">
		        								<input name="uploadImage" id="uploadImage" type="file" value="${bannerInfo.ban_picture}" class="filepath"/>
		       									<span class="close" style="top:0px; !important">x</span>
		        								<img src="${bannerInfo.ban_picture}" class="img2" />
		        								<img src="<%=path %>/js/inputFile/btn.png" class="img1" />
		    								</div>
										</div>
										<small>(请上传1242*834尺寸的图片)</small>
									</div>
									<div class="row-list">
										<label>链接：</label>
										<input name="ban_link" id="ban_link" type="text" class="td_text_w" value="${bannerInfo.ban_link}"/>
									</div>
									<div class="row-list">
										<label>排序：</label>
										<input name="order_px" id="order_px" type="text" class="td_text_w" value="${bannerInfo.order_px}"/>
										<input type="hidden" id="ad_id" value="<%=request.getParameter("ad_id")%>" name="ad_id" />
										<input type="hidden" id="ad_type" value=1 name="ad_type" />
									</div>
								</div>
								<div class="line"></div>
								<div class="editRight">
									<div class="row-list">
									
									</div>
								</div>
							</div>
							
						</form>
						</div>						
				</section>
				<div class="bgbtn">
					<!-- <span ><input style="margin-top:20%" type="submit" value="保存" class="left back_dblue col_white btn"/></span>
					<span ><input style="margin-top:20%;" type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span> -->
					<span ><button type="button" onclick="doSubmitCheck()" class="left back_dblue  btn"><i class="icon-btn icon-save"></i>保存</button></span>
					<span ><button type="button" class="left back_dblue btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button></span>
					<span class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
				</div>		
			</section>
		</div>
	</body>
</html>
