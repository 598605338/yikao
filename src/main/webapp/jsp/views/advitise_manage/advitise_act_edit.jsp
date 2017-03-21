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
	 /**2017.2.10
	  * 清空非 button按钮 提交按钮 重置按钮 隐藏表单。
	  */
	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
	 
	 function doSubmitCheck(){
			var form = document.formain;
			var activityRule = form.activity_rule;
			if(activityRule){
				var actRule=activityRule.value;
				if(bannerName==null || bannerName==''){
			        alert("规则不能为空！");
			        return false;
				}
			}
			document.getElementById('formain').submit();
			return true;
		}

</script>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">编辑页面</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClickList" style="color: #323232;">活动广告管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">活动广告编辑</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="<%=path%>/advManage/updateAyAdvInfoById" enctype="multipart/form-data">
							
							<div class="editPage">
								<div class="editLeft">
									<div class="row-list">
										<label>主题图编辑：</label>
										<div class="imgbox" style="border:1px solid #999999;">
		    								<div class="imgnum">
		        								<input name="uploadImage" id="uploadImage" type="file" class="filepath"/>
		       									<span class="close" style="top:0px; !important">x</span>
		        								<img src="${actAdvitise.picture}" class="img2" />
		        								<img src="<%=path %>/js/inputFile/btn.png" class="img1" />
		    								</div>
										</div>
										<input name="id" id="activity_id" type="hidden" class="left" value="${actAdvitise.id}"/>
										<input name="activity_name" id="activity_name" type="hidden" class="left" value="${actAdvitise.activity_name}"/>
										<input name="activity_id" id="activity_id" type="hidden" class="left" value="${actAdvitise.activity_id}"/>
										<input name="activity_type" id="activity_type" type="hidden" class="left" value="${actAdvitise.activity_type}"/>
									</div>
									<c:choose>  
			  							<c:when test="${actAdvitise.activity_type==2}">
			  								<div class="row-list">
			  									<label>活动规则：</label>
												<input name="activity_rule" class="td_text_w" id="activity_rule" type="text" class="left" value="${actAdvitise.activity_rule}"/>
			  								</div>
			   							</c:when> 
			   							<c:when test="${actAdvitise.activity_type==3}">
			  								<div class="row-list">
			  									<label>活动规则：</label>
												<input name="activity_rule" class="td_text_w" id="activity_rule" type="text" class="left" value="${actAdvitise.activity_rule}"/>
			  								</div>
			   							</c:when>
			   						</c:choose>
									<div class="row-list">
										
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
					<!-- <span ><input style="margin-top:20%;" type="submit" value="保存" class="left back_dblue col_white btn"/></span>
					<span ><input style="margin-top:20%;" type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span> -->
					<span ><button type="button" onclick="doSubmitCheck()" class="left back_dblue col_white btn"><i class="icon-btn icon-save"></i>保存</button></span>
					<span ><button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button></span>
					<span class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
				</div>		
				</div>
	</body>
</html>
