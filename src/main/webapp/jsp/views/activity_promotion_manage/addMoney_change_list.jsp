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
<link href="<%=path%>/js/divPage/dividePage.css" type="text/css" rel="Stylesheet" />
<script type="text/javascript" src="<%=path%>/js/divPage/dividePage.js"></script>
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<script type="text/javascript">
/**
 * 日期插件
 * API：http://www.malot.fr/bootstrap-datetimepicker/demo.php
 */
	window.onload=function(){
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
		 
		 $('#beginDate').datetimepicker({
				dateFormat:'yy-mm-dd',
				timeFormat: 'HH:mm:ss',
				stepHour: 1,
				stepMinute: 1,
				stepSecond: 1
			});
		
		 $('#endDate').datetimepicker({
			 	dateFormat:'yy-mm-dd',
				timeFormat: 'HH:mm:ss',
				stepHour: 1,
				stepMinute: 1,
				stepSecond: 1
		});
		 
		 $("[name='status'][value='<c:out value="${query.status}"/>']").attr("checked",true);
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
							alert("请选择活动!");
							return;
						}
						
						if(activity_ids){
							var data1=activity_ids;
							<%-- $.ajax({			
									url:"<%=path%>/promotion/deleteActInfoById",
									type:"POST",
									data: 'activity_ids='+data1+"&activity_type="+4,
									dataType: 'text',
									success:function(data){
										console.log(data);
									},
									error:function(err){
										alert(err);
									}
								}) --%>
							window.location.href="<%=path%>/promotion/deleteActInfoById?activity_ids="+data1+"&activity_type=4";
						}
			}
			
			function addNew(){
				window.location.href="<%=path%>/jsp/views/activity_promotion_manage/addMoney_change_add.jsp";
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
<c:out value="${message }" />
	<div id="wrap">
				<!-- <header class="cont_section_header">加钱换购列表</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<span style="color:#3bb3e0;">加钱换购列表</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
						<form name="formain" id="formain" method="post" action="<%=path%>/promotion/selectActInfoAll">
							<div class="row">
								<input name="activity_name" placeholder="促销名称" id="activity_name" type="text" class="left" value="${query.activity_name}"/>   
								<input class="datatime-input" placeholder="促销日期起" type="text" name="beginDate" id="beginDate" value="${query.beginDate}" />
								<input class="datatime-input" placeholder="促销日期止" type="text" name="endDate" id="endDate" value="${query.endDate}" />
								<select name="status" id="status" class="left">
									<option value="">使用状态</option>
									<option value=1>启用</option>
									<option value=0>禁用</option>
								</select>
								<input type="hidden" id="activity_type" name="activity_type" value=2>
								<input type="hidden" id="pageIndex" name="pageIndex" value="${query.pageIndex}">
							</div>
							<div class="col-click">
								<!-- <span ><input type="submit" value="查询" class="left back_dblue col_white btn"/></span>
								<span ><input type="button" class="left back_dblue col_white btn" onclick="cleanForm()" value="重置"/></span> -->
								<button class="left back_dblue col_white btn" onclick="document.getElementById('formain').submit();"><i class="icon-btn icon-search"></i>查询</button>
								<button class="left back_dblue col_white btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>重置</button>
							</div>
						</form>
						</div>					
						<div class="section_table">
							<table cellspacing="none" style="margin-top:-6px;" class="table_hover">
						<div class="height compa" style="margin:7px 0px -1px -5px" >
							<span ><button class="left back_dblue btn" onclick="addNew()"><i class="icon-btn icon-add"></i>新增</button>
							<button class="left back_dblue btn" onclick="delAll()"><i class="icon-btn icon-delete"></i>删除</button>
							</span>
							<span class="right">共${query.totalNums}条活动信息&nbsp;</span>
						</div>	
						<thead style="background:#EBEBEB;">
							<th><input style="margin-left:29%;" type="checkbox" name="all" id="all" onclick="doChoose()"/></th>
							<th>创建时间</th>
							<th>促销名称</th>
							<th>活动类型</th>
							<th>开始日期</th>
							<th>结束日期</th>
							<th>优先级</th>
							<th>使用状态</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="activity" items="${activitylist}" varStatus="status">
						 	<tr class="goods_tr">
								<td><input style="margin-left:29%;" type="checkbox" name="activity_id" id="activity_id" value="${activity.activity_id}" onclick="chooseSingle()"></td>
								<td><fmt:formatDate value="${activity.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${activity.activity_name}</td>
								<td>
								<c:choose>  
  										<c:when test="${activity.activity_type==1}">
  											满减活动
   										</c:when>  
									    <c:when test="${activity.activity_type==2}">
  											商品折扣
   										</c:when> 
   										<c:when test="${activity.activity_type==3}">
  											第二件半价
   										</c:when> 
   										<c:when test="${activity.activity_type==4}">
  											加钱换购
   										</c:when> 
									</c:choose>
								</td>
								<td><fmt:formatDate value="${activity.start_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${activity.end_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${activity.priority}</td>
								<td>
									<c:choose>  
  										<c:when test="${activity.status==0}">
  											禁用
   										</c:when>  
									    <c:otherwise>
											启用
									    </c:otherwise>  
									</c:choose>
								</td>
								<td><a class="mr10" href="<%=path%>/promotion/selectActInfoById?activity_id=${activity.activity_id}&activity_type=${activity.activity_type}"><i class="icon-op icon-op-edit"></i>修改</a>
								<c:choose>  
  										<c:when test="${activity.status==0}">
  										<a class="mr10" href="<%=path%>/promotion/updateActInfoById?activity_id=${activity.activity_id}&activity_type=${activity.activity_type}&status=1"><i class="icon-op icon-op-able"></i>启用</a>
   										</c:when>  
									    <c:when test="${activity.status==1}">
  										<a class="mr10" href="<%=path%>/promotion/updateActInfoById?activity_id=${activity.activity_id}&activity_type=${activity.activity_type}&status=0"><i class="icon-op icon-op-disable"></i>禁用</a>
   										</c:when> 
									</c:choose>
								</td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						
					</div>					
				</section>
				<footer class="cont_section_footer">
					<div id="div_pager"></div>
				</footer>
		</div>
	</body>
	<script>
	/**2017.2.10
	 * 分页插件
	 */
	//总记录数数
	var totalRecords =${query.totalNums};
	//每页记录数
	var pageSize=${query.pageSize};
	//当前页
	var pageNo = ${query.pageIndex}; //这里设置参数名
	if (!pageNo) {
		pageNo = 1;
	}
	
	var totalPage = dividePage.getTotals(totalRecords,pageSize);
	//生成分页控件 根据分页的形式在这里设置
	dividePage.init({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		//链接前部
		hrefFormer : 'promotion/selectActInfoAll',
		//链接尾部
		hrefLatter :'',
		getLink : function(n) {
			return this.hrefFormer + this.hrefLatter + "?pageIndex=" + n+"&pageSize="+pageSize //参数名跟上面相同
		},
		getLink2 : function(pageIndex,pageSize) {
			return "javascript:submitPageForm("+pageIndex+","+pageSize+");" //参数名跟上面相同
		}
	});
	dividePage.generPageHtml2();
	
	function submitPageForm(pageIndex,pageSize){
		$("#pageIndex").val(pageIndex);
		$("#pageSize").val(pageSize);
		$("[name='formain']").submit();
	}
	</script>
	<script type="text/javascript">
	var browser=navigator.appName
	var b_version=navigator.appVersion
	var version=b_version.split(";");
	var trim_Version=version[1].replace(/[ ]/g,""); 
	 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
	  $(".compa").css("margin","19px 0px 0px 0px")
	}
	</script>
</html>
