<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
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
				<!-- <header class="cont_section_header">积分商城管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<span style="color:#3bb3e0;">积分商城管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
					<form name="form" id="formSubmit" action="select" method="post">
						<div class="row">
							<input type="text" name="name" placeholder="名称" id="name" value="<c:out value="${query.name }"/>" class="td_text_w" />
							<input type="text" name="creDateStart" placeholder="创建时间起" id="creDateStart" value="<c:out value="${query.creDateStart }"/>" class="datatime-input" />
							<input type="text" name="creDateEnd" placeholder="创建时间止" id="creDateEnd" value="<c:out value="${query.creDateEnd }"/>" class="datatime-input" />
							<select name="type" id="type" class="left">
								<option value="">类型</option>
								<option value="1">商品券</option>
								<option value="3">代金券</option>
								<option value="5">免运费券</option>
								<option value="6">链接券</option>
								<option value="7">券码</option>
							</select>
						</div>
						<div class="col-click">
							<button type="button" onclick="document.getElementById('formSubmit').submit();" class="left back_dblue col_white btn" ><i class="icon-btn icon-search"></i>查询</button>
							<button type="button" class="left back_dblue col_white btn" onClick="resetForm();" ><i class="icon-btn icon-reset"></i>重置</button>
						</div>
					</form>	
						</div>		
						<div class="section_table">
							<table cellspacing="none" class="table_hover">
						<shiro:hasPermission name="9">
						<div class="click">
							<a href="javascript:void(0)" onclick="javascript:location.href='toAdd'"><span class="left back_dblue btn"><i class="icon-btn icon-add"></i>新增</span></a>
							<a href="javascript:void(0)" onclick="deleteRecord();"><span class="left back_dblue btn"><i class="icon-btn icon-delete"></i>删除</span></a>
						</div>
						</shiro:hasPermission>
						<thead style="background:#ebebeb;">
							<th><input style="margin-left:21%;" type="checkbox" name="selAll" onclick="selAll(this);"/></th>
							<th style="width:15%">创建时间</th>
							<th style="width:15%">名称</th>
							<th style="width:10%">劵码</th>
							<th style="width:10%">支付方式</th>
							<th style="width:10%">价格</th>
							<th style="width:10%">类型</th>
							<th style="width:10%;">状态</th>
							<shiro:hasPermission name="9">
							<th style="width:20%">操作</th>
							</shiro:hasPermission>
						</thead>
						<tbody>
						<c:forEach var="item" items="${scoreProductList }" varStatus="status">
							<tr class="goods_tr">
								<td style="width:2.5%;"><input style="margin-left:23%;" type="checkbox" name="id" value="<c:out value="${item.id }" />"/></td>
								<td><fmt:formatDate value="${item.creDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><c:out value="${item.name }"/></td>
								<td><c:out value="${item.cardCouponId }"/></td>
								<td><c:if test="${item.exchangeType==0 }">积分</c:if><c:if test="${item.exchangeType==1 }">金钱+积分</c:if></td>
								<td><c:if test="${item.exchangeType==0 }"><c:out value="${item.score }"/></c:if><c:if test="${item.exchangeType==1 }">￥<c:out value="${item.price }"/>+<c:out value="${item.score }"/></c:if>积分</td>
								<td><c:if test="${item.type==1 }">商品券</c:if><c:if test="${item.type==3 }">代金券</c:if><c:if test="${item.type==5 }">免运费券</c:if><c:if test="${item.type==6 }">链接券</c:if><c:if test="${item.type==7 }">券码</c:if></td>
								<td style=""><c:if test="${item.useStatus==false }">上架</c:if><c:if test="${item.useStatus==true}">下架</c:if></td>
								<shiro:hasPermission name="9">
								<td>
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toEdit?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='delete?recordIds=<c:out value="${item.id }" />'"><i class="icon-op icon-op-delete"></i>删除</a>
									<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toDetail?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-details"></i>商品详情</a>
									<a href="javascript:void(0)" onclick="javascript:location.href='updateStatus?id=<c:out value="${item.id }" />&useStatus=<c:out value="${item.useStatus }" />'"><c:if test="${item.useStatus==false }"><i class="icon-op icon-op-offShelf"></i>下架</c:if><c:if test="${item.useStatus==true}"><i class="icon-op icon-op-shelves"></i>上架</c:if></a>
								</td>
								</shiro:hasPermission>
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
				    <input type="hidden" name="creDateStart" id="creDateStart" value="<c:out value="${query.creDateStart}"/>" />
				    <input type="hidden" name="creDateEnd" id="creDateEnd" value="<c:out value="${query.creDateEnd}"/>" />
				    <input type="hidden" name="type" id="type" value="<c:out value="${query.type}"/>" />
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
window.onload=function(){
	 var startDateTextBox = $('#creDateStart');
	 var endDateTextBox = $('#creDateEnd');

	 $.timepicker.dateRange(
	 	startDateTextBox,
	 	endDateTextBox,
	 	{
	 		minInterval: (1000*60*60*24*0), // 4 days
	 		maxInterval: (1000*60*60*24*30), // 8 days
	 		start: {}, // start picker options
	 		end: {} // end picker options
	 	}); 
}

//初始化
$("#type").val(<c:out value="${query.type }" />);

//总记录数数
var totalRecords = ${pnums};
//每页记录数
var pageSize=10;
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
	$("#creDateStart").val(null);
	$("#creDateEnd").val(null);
	$("#type").val("");
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
		document.location.href="delete?recordIds=" + recordIds;
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