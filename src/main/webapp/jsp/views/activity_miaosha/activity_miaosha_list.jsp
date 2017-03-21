<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<!-- <header class="cont_section_header">秒杀管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<span style="color:#3bb3e0;">秒杀管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
					<form name="form" id="formSearch" action="select" method="post">
						<div class="row">
							<input type="text" name="name" placeholder="活动名称" id="name" value="<c:out value="${query.name }"/>" class="td_text_w" />
							<input type="text" name="publishDateStart" placeholder="发布日期起" id="publishDateStart" value="<c:out value="${query.publishDateStart }" />" class="datatime-input" readonly='readonly'  />
							<input type="text" name="publishDateEnd" placeholder="发布日期止" id="publishDateEnd" value="<c:out value="${query.publishDateEnd }"/>" class="datatime-input" readonly='readonly'  />
							<select name="timeNode" id="timeNode" class="left" style="box-sizing:border-box;">
								<option value="">活动时间段</option>
								<option value="1">09:00</option>
								<option value="2">12:00</option>
								<option value="3">15:00</option>
								<option value="4">18:00</option>
							</select>
							<input type="text" name="creDateStartStr" placeholder="创建时间起" id="creDateStartStr" value="<c:out value="${query.creDateStartStr }"/>" class="datatime-input" readonly='readonly' />
							<input type="text" name="creDateEndStr" placeholder="创建时间止" id="creDateEndStr" value="<c:out value="${query.creDateEndStr }"/>" class="datatime-input" readonly='readonly'  />
							<select name="activityStatus" id="activityStatus" class="left" style="box-sizing:border-box;">
								<option value="">活动状态</option>
								<option value="1">即将开始</option>
								<option value="2">抢购中</option>
								<option value="3">已结束</option>
							</select>
						</div>
						<div class="col-click">
							<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSearch').submit();"><i class="icon-btn icon-search"></i>查询</button>
							<button type="button" class="left back_dblue col_white btn" onClick="resetForm();"><i class="icon-btn icon-reset"></i>重置</button>
						</div>
					</form>		
							
						</div>		
						<div class="section_table">
							<table cellspacing="none" class="table_hover">
						<div class="click">
							<a href="javascript:void(0)" onclick="javascript:location.href='toAdd'"><span class="left back_dblue btn"><i class="icon-btn icon-add"></i>新增</span></a>
							<a href="javascript:void(0)" onclick="deleteRecord();"><span class="left back_dblue btn"><i class="icon-btn icon-delete"></i>删除</span></a>
						</div>
						<thead style="background:#EBEBEB;">
							<th><input style="margin-left:20%;" type="checkbox" name="selAll" onclick="selAll(this);"/></th>
							<th>创建时间</th>
							<th>活动名称</th>
							<th>发布日期</th>
							<th>有效期</th>
							<th>活动时间段</th>
							<th>活动状态</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${miaoshaActivityBaseList }" varStatus="status">
							<tr class="goods_tr">
								<td style="width:2.5%;"><input class="wojia" style="margin-left:20%;" type="checkbox" name="id" value="<c:out value="${item.id }" />"/></td>
								<td style="width:15%"><fmt:formatDate value="${item.creDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td style="width:10%"><c:out value="${item.name }"/></td>
								<td style="width:10%"><fmt:formatDate value="${item.publishDate }" pattern="yyyy-MM-dd"/></td>
								<td style="width:27%">
									<fmt:formatDate value="${item.panicBuyingStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
									～
									<fmt:formatDate value="${item.panicBuyingEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td style="width:10%"><c:if test="${item.timeNode==1 }">09:00</c:if><c:if test="${item.timeNode==2 }">12:00</c:if><c:if test="${item.timeNode==3 }">15:00</c:if><c:if test="${item.timeNode==4 }">18:00</c:if></td>
								<td style="width:10%"><c:out value="${item.activityStatus }"/></td>
								<td style="width:15%">
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toEdit?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
									<a href="javascript:void(0)" onclick="javascript:location.href='deleteMiaoshaBase?recordIds=<c:out value="${item.id }" />'" ><i class="icon-op icon-op-delete"></i>删除</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
						
					</div>					
				</section>
				
				<footer class="cont_section_footer">
				   <form name="pageForm" action="select" method="post">
				    <input type="hidden" name="pageIndex" id="pageIndex" value="" />
				    <input type="hidden" name="pageSize" id="pageSize" value="" />
				    <input type="hidden" name="name" id="name" value="<c:out value="${query.name}"/>" />
				    <input type="hidden" name="publishDateStart" id="publishDateStart" value="<c:out value="${query.publishDateStart}"/>" />
				    <input type="hidden" name="publishDateEnd" id="publishDateEnd" value="<c:out value="${query.publishDateEnd}"/>" />
				    <input type="hidden" name="creDateStartStr" id="creDateStartStr" value="<c:out value="${query.creDateStartStr}"/>" />
				    <input type="hidden" name="creDateEndStr" id="creDateEndStr" value="<c:out value="${query.creDateEndStr}"/>" />
				    <input type="hidden" name="timeNode" id="timeNode" value="<c:out value="${query.timeNode}"/>" />
				    <input type="hidden" name="activityStatus" id="activityStatus" value="<c:out value="${query.activityStatus}"/>" />
					<%-- <a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex-1 }" />);"><span class="left page">上一页</span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex }" />);"><span class="left page page_chose"><c:out value="${query.pageIndex }" /></span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex+1 }" />);"><span class="left page">下一页</span></a> --%>
				   </form>
				   <div id="div_pager"></div>
				</footer>
	</div>
</body>
</html>

<script>
/**2017.2.10
 * 这是一个日期插件
 * Demo地址：http://www.cnblogs.com/linJie1930906722/p/6066071.html
 * 第六个开始结束区间(第二种写法)
 */
window.onload=function(){
	 
	 var startDateTextBox = $('#publishDateStart');
	 var endDateTextBox = $('#publishDateEnd');

	 $.timepicker.dateRange(
	 	startDateTextBox,
	 	endDateTextBox,
	 	{
	 		minInterval: (1000*60*60*24*0), // 4 days
	 		maxInterval: (1000*60*60*24*30), // 8 days
	 		start: {}, // start picker options
	 		end: {} // end picker options
	 	}); 
	 
	 var startDateTextBox1 = $('#creDateStartStr');
	 var endDateTextBox1 = $('#creDateEndStr');

	 $.timepicker.dateRange(
	 	startDateTextBox1,
	 	endDateTextBox1,
	 	{
	 		minInterval: (1000*60*60*24*0), // 4 days
	 		maxInterval: (1000*60*60*24*30), // 8 days
	 		start: {}, // start picker options
	 		end: {} // end picker options
	 	}); 
}
/**
 * 日期初始化。
 */
//1、初始化
$("#timeNode").val(<c:out value="${query.timeNode}"/>);
$("#activityStatus").val(<c:out value="${query.activityStatus}"/>);


//2、总记录数数
var totalRecords = ${pnums};
//3、每页记录数
var pageSize=10;
//4、当前页
var pageNo = ${query.pageIndex}; //这里设置参数名
if (!pageNo) {
	pageNo = 1;
}

var totalPage = dividePage.getTotals(totalRecords,pageSize);
//5、生成分页控件 根据分页的形式在这里设置
dividePage.init({
	pno : pageNo,
	//总页码
	total : totalPage,
	//总数据条数
	totalRecords : totalRecords,
	//链接前部
	hrefFormer : 'select',
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


/*
 * 重置
 */
function resetForm(){
	$("#name").val(null);
	$("#publishDateStart").val(null);
	$("#publishDateEnd").val(null);
	$("#creDateStartStr").val(null);
	$("#creDateEndStr").val(null);
	$("#timeNode").val("");
	$("#activityStatus").val("");
}


/*
 * 全选
 */
function selAll(o){
	var selFlg = o.checked;
	$("[name='id']").each(function(i,item){
		if(selFlg){
			item.checked=true;
		}else{
			item.checked=false;
		}
	});
}

/*
 * 删除
 */
function deleteRecord(){
	var recordIds = new Array();
	$("[name='id']").each(function(i,item){
		if(item.checked==true)
			recordIds.push(item.value);
	});
	if(recordIds.length > 0){
		document.location.href="deleteMiaoshaBase?recordIds=" + recordIds;
	}else{
		alert("请选择要删除的记录");
	}
}

function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}
</script>