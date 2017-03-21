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
	window.onload=function(){
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
	}


	 function cunrentPage(){
		 $("#cunrentPage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
		 $('#formain').submit();
	} 
	
	 function nextPage(){
		 $("#nextPage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 pg=1;
		 }
		 var nextPg=parseInt(pg)+1;
		 $("#pageIndex").val(nextPg);
		 var pg1=$("#pageIndex").val();
		 $('#formain').submit();
	 }
	 
	 function beforePage(){
		 $("#beforePage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 pg=1;
		 }else if(pg>0){
			 pg=pg-1;
		 }
		 $("#pageIndex").val(pg);
		 $('#formain').submit();
	 }
 
	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
 
	 
		//全选功能
			function doChoose(){
				//首先要取到"全选"复选框的选中状态
				var state = document.getElementById('all').checked;
				//让所有的single复选框的状态和state保持一致
				var singles = document.getElementsByName('id');
				//循环遍历每一个single
				for(var i=0;i<singles.length;i++){
					singles[i].checked = state;
				}
			}
		
			//当我们将每一个single都选中的时候,让"全选"复选框自动选中
			function chooseSingle(){
				var count = 0;
				//判断每一个single是否都选中了呢 ?
				var singles = document.getElementsByName('id');
				for(var i=0;i<singles.length;i++){
					if(singles[i].checked){
						count++;
					}
				}
				//根据选中的single的个数,来确定"全选"复选框的状态
				if(count == singles.length){
					document.getElementById('all').checked = true;
				}else{
					document.getElementById('all').checked = false;
				}
			}

			function delAll(type){
					var ids="";
						//判断每一个single是否都选中了呢 ?
						var singles = document.getElementsByName('id');
						for(var i=0;i<singles.length;i++){
							if(singles[i].checked){
								var svalue=singles[i].value;
								if(svalue){
									ids=ids+svalue+"-";
								}
							}
						}
						
						if(ids){
							if(confirm("你确定要删除选中数据吗?")){
								if(ids.charAt(ids.length-1)=="-"){
									ids=ids.substr(0,ids.length-1);
								}
							}else{
								return;
							}
						}else{
							alert("请选择数据！");
							return;
						}
						
						if(ids){
							var data1=ids;
							$.ajax({			
									url:"<%=path%>/promotion/deleteActInfoById",
									type:"POST",
									data: 'ids='+data1,
									dataType: 'text',
									success:function(data){
										console.log(data);
									},
									error:function(err){
										alert(err);
									}
								})
						}
			}
			
			function addNew(){
				window.location.href="<%=path%>/jsp/views/advitise_manage/advitise_page_add.jsp";
			}

</script>
<style>
     a:link{
        color:#2285C5;
     }
	a:hover{
	
		color:#3BB3E0;
	}
	a:active{
		color:#19699D;
	}
</style>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">制作页面</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<span style="color:#3bb3e0;">制作页面</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="section_table">
							<table class="table_hover" cellspacing="none">
						<div class="click">
							<span class="left back_dblue btn onbtn" onclick="addNew()"><i class="icon-btn icon-add"></i>新增</span>
						</div>
						<thead style="background:#EBEBEB;">
							<th>ID</th>
							<th>创建时间</th>
							<th>页面名称</th>
							<th>页面类型</th>
							<th>页面链接</th>
							<th>操作</th>
						</thead>
						<tbody>
						    <c:forEach var="advPage" items="${advPagelist}" varStatus="status">	
						    <tr class="goods_tr">
								<td>${advPage.id}</td>
								<td><fmt:formatDate value="${advPage.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${advPage.page_name}</td>
								<td>
									<c:choose>  
	  									<c:when test="${advPage.page_type==1}">
	  										H5页面
	   									</c:when> 
	   									<c:when test="${advPage.page_type==2}">
	  										模板
	   									</c:when>
	   								</c:choose> 
								</td>
								<td>${advPage.page_link}</td>
								<td>
								<a href="<%=path%>/advPage/deleteAdvPageById?id=${advPage.id}"><i class="icon-op icon-op-delete"></i>删除</a>
								</td>
							</tr>
						    </c:forEach>
						   </tbody>
						</table>
					</div>	
				</div>					
		  </section>
		  </div>
	</body>
</html>
<script type="text/javascript">
var browser=navigator.appName
var b_version=navigator.appVersion
var version=b_version.split(";");
var trim_Version=version[1].replace(/[ ]/g,""); 
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
   $(".click .onbtn").css("margin","10px 0px 7px 15px")
}
</script>
