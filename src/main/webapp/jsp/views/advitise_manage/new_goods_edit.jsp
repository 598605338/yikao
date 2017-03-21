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
<c:out value="${message }" />
		<section class="cont_section height_all">
				<header class="cont_section_header">新品推荐修改</header>
				<div class="height">
					<span class="right back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
				</div>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="<%=path%>/advManage/updateBannerInfoById" enctype="multipart/form-data" >
						<table cellspacing="none" style="width:50%;text-align:center;">
						<tbody>
							<tr class="goods_tr" >
								<td style="width:40%">banner名称：</td>
								<td><input name="banner_name" id="banner_name" type="text" class="left" value="${bannerInfo.banner_name}"/></td>
							</tr>	
							<tr class="goods_tr" >
								<td>图片：</td>	
								<td class="td_right">
								<div class="imgbox" style="border:1px solid #999999;">
    								<div class="imgnum">
        								<input name="uploadImage" id="uploadImage" type="file" value="${bannerInfo.ban_picture}" class="filepath"/>
       									<span class="close" style="top:0px; !important">X</span>
        								<img src="${bannerInfo.ban_picture}" class="img2" />
        								<img src="<%=path%>/js/inputFile/btn.png" class="img1" />
    								</div>
								</div>
								</td>
							</tr>	
							<tr class="goods_tr" >
								<td>链接：</td>
								<td><input name="ban_link" id="ban_link" type="text" class="left" value="${bannerInfo.ban_link}"/></td>
							</tr>	
							<tr class="goods_tr" >
								<td>排序：</td>
								<td><input name="order_px" id="order_px" type="text" class="left" value="${bannerInfo.order_px}"/>
								<input type="hidden" id="id" name="id" value=${bannerInfo.id}>
								<input type="hidden" id="ad_id" name="ad_id" value=${bannerInfo.ad_id}>
								<input type="hidden" id="ad_type" name="ad_type" value=${bannerInfo.ad_type}>
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
	</body>
</html>
