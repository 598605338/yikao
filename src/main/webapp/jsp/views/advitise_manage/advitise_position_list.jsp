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
				var singles = document.getElementsByName('activity_id');
				//循环遍历每一个single
				for(var i=0;i<singles.length;i++){
					singles[i].checked = state;
				}
			}
		
			//当我们将每一个single都选中的时候,让"全选"复选框自动选中
			function chooseSingle(){
				var count = 0;
				//判断每一个single是否都选中了呢 ?
				var singles = document.getElementsByName('activity_id');
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
					var activity_ids="";
						//判断每一个single是否都选中了呢 ?
						var singles = document.getElementsByName('activity_id');
						for(var i=0;i<singles.length;i++){
							if(singles[i].checked){
								var svalue=singles[i].value;
								if(svalue){
									activity_ids=activity_ids+svalue+"-";
								}
							}
						}
						
						if(activity_ids){
							if(confirm("你确定要删除选中数据吗?")){
								if(activity_ids.charAt(activity_ids.length-1)=="-"){
									activity_ids=activity_ids.substr(0,activity_ids.length-1);
								}
							}else{
								return;
							}
						}else{
							alert("请选择数据！");
							return;
						}
						
						if(activity_ids){
							var data1=activity_ids;
							$.ajax({			
									url:"<%=path%>/promotion/deleteActInfoById",
									type:"POST",
									data: 'activity_ids='+data1+"&activity_type="+1,
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
			}
			
			function addNew(){
				window.location.href="<%=path%>/jsp/views/activity_promotion_manage/fulll_minus_add.jsp";
			}

</script>
<style>
	a{
	    color: #2285C5;
	}
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
				<!-- <header class="cont_section_header">广告位管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<span style="color:#3bb3e0;">广告位管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="section_table">
							<table class="table_hover" cellspacing="none">
						<thead style="background:#EBEBEB">
							<th>首页功能区位</th>
							<th>广告位名称</th>
							<th>图片</th>
							<th>链接</th>
							<th>数量</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="advitise" items="${advlist}" varStatus="status">
						 	<tr class="goods_tr">
								<td>${advitise.position}</td>
								<td style="text-transform:capitalize">${advitise.ad_position_name}</td>
								<td><img style="width:45px;" src="${advitise.picture}"/></td>
								<td>${advitise.ad_link}</td>
								<td>${advitise.nums}</td>
								<td>
									<c:choose>  
	  									<c:when test="${advitise.ad_type==1}">
	  										<a class="mr10" href="<%=path%>/advManage/selectBannerInfoAll?ad_id=${advitise.id}&ad_type=${advitise.ad_type}"><i class="icon-op icon-op-details"></i>详情</a>
	   									</c:when> 
	   									<c:when test="${advitise.ad_type==10}">
	  										<a class="mr10" href="<%=path%>/advManage/selectBannerInfoAll?ad_id=${advitise.id}&ad_type=${advitise.ad_type}"><i class="icon-op icon-op-details"></i>详情</a>
	   									</c:when>
	   									<c:otherwise>
	   										<a class="mr10" href="<%=path%>/advManage/selectAdvInfoById?id=${advitise.id}"><i class="icon-op icon-op-details"></i>详情</a>
	   									</c:otherwise>		
	   								</c:choose> 
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
