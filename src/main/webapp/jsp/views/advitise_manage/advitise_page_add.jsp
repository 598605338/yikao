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
	 /**
	  * 提交时判断非空
	  */
	 function doSubmitCheck(){
			var form = document.formain;
			var pageName = form.page_name.value;
			var pageType = form.page_type.value;
			if(pageName==null || pageName==''){
		        alert("页面名称不能为空！");
		        return false;
			}
			if(pageType==null || pageType==''){
		        alert("页面类型不能为空！");
		        return false;
			}
			document.getElementById('formain').submit();
			return true;
		}

</script>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">新增页面</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClickList" style="color: #323232;">制作页面</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增页面</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<form name="formain" id="formain" method="post" action="<%=path%>/advPage/insertAdvPage" >
					
							<div class="editPage">
								<div class="editLeft">
									<div class="row-list">
										<label>请选择页面类型：</label>
								 		<input name="page_type" id="page_type" value=1 type="radio" class="left" /><b>H5静态页面</b>
									</div>
									<div class="row-list">
										<label></label>
										<input name="page_type" id="page_type" value=2 type="radio" class="left"  /><b>使用模板</b>
									</div>
									<div class="row-list">
										<label>页面名称：</label>
										<input class="td_text_w" name="page_name" id="page_name" type="text"  value="${pageInfo.page_name}"/>
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
					<!-- <span ><input type="submit" value="保存" class="left back_dblue col_white btn"/></span>
					<span ><input type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span> -->
					<span ><button type="button" onclick="doSubmitCheck();" class="left back_dblue col_white btn"><i class="icon-btn icon-save"></i>保存</button></span>
					<span ><button type="button" class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button></span>
					<span class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
				</div>	
		</div>
	</body>
</html>
