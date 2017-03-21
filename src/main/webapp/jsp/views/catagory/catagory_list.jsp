<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="<%=path%>/js/divPage/catagoryStyle.css" type="text/css" rel="Stylesheet" />
<link href="<%=path%>/js/divPage/dividePage.css" type="text/css" rel="Stylesheet" />
<script type="text/javascript" src="<%=path%>/js/divPage/dividePage.js"></script>
<jsp:include page="../header.jsp" />
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
				<!-- <header class="cont_section_header">分类管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">商品</a><span>&gt;</span>
					<span style="color:#3bb3e0;">分类管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
					<div class="cont_section_head">
					<form id="formSubmit" name="form" <c:if test="${level=='large'}">action="selectLargeCatagory"</c:if> <c:if test="${level=='middle'}">action="selectMiddleCatagory"</c:if> method="post">
						<div class="row">
							<input type="text" placeholder="分类名称" name="name" id="name" value="<c:out value="${query.name }"/>" class="td_text_w" />
							<input type="hidden" name="largeCatagoryId" id="largeCatagoryId" value="<c:out value="${largeCatagoryId }"/>" />
						</div>
						<div class="col-click">
							<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
							<button type="button" class="left back_dblue col_white btn" onclick="resetForm()"><i class="icon-btn icon-reset"></i>重置</button>
						</div>
					</form>
					
					
					</div>

			<div class="section_table">
						<table cellspacing="none" class="table_hover">
						<div class="click">
							<a href="javascript:void(0)" onclick="javascript:location.href='toAdd?largeCatagoryId=<c:out value="${largeCatagoryId }"/>'"><span class="left back_dblue btn"><i class="icon-btn icon-add"></i>新增分类</span></a>
							<span class="left back_dblue btn btn_import"><i class="icon-btn icon-import"></i>批量编辑</span>
							<c:if test="${level=='middle'}">
							<a href="javascript:void(0)" onclick="javascript:location.href='selectLargeCatagory'"><span class="left back_dblue btn"><i class="icon-btn icon-goback"></i>返回一级分类</span></a>
							</c:if>
						</div>
						<thead>
							<th><input style="margin-left:20%;" type="checkbox" name="selAll" onclick="selAll(this);"/></th>
							<c:if test="${level=='large'}">
							<th>一级分类名称(ID)</th>
							</c:if>
							<c:if test="${level=='middle'}">
							<th>二级分类名称(ID)</th>
							</c:if>
							<th>使用状态</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${catagoryList }" varStatus="status">
							<tr class="goods_tr">
								<td style="width:2.5%;"><input style="margin-left:20%;" type="checkbox" name="id" value="<c:out value="${item.id }" />"/></td>
								<td style="width:30%;"><c:out value="${item.name }"/>(<c:out value="${item.id }" />)</td>
								<td style="width:30%;"><c:if test="${item.useStatus==false }">启用</c:if><c:if test="${item.useStatus==true }">禁用</c:if></td>
								<td style="width:30%;">
								<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='toEdit?id=<c:out value="${item.id }" />&largeCatagoryId=<c:out value="${largeCatagoryId }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
								<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='deleteCatagory?catagoryIds=<c:out value="${item.id }" />&largeCatagoryId=<c:out value="${largeCatagoryId }" />'"><i class="icon-op icon-op-delete"></i>删除</a>
								<c:if test="${level=='large'}">
								<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='selectMiddleCatagory?largeCatagoryId=<c:out value="${item.id }" />'"><i class="icon-op icon-op-twoLevel"></i>二级分类</a>
								</c:if>
								<a href="javascript:void(0)" class="mr10" onclick="javascript:location.href='updateUseStatus?id=<c:out value="${item.id }" />&useStatus=<c:out value="${item.useStatus }" />&largeCatagoryId=<c:out value="${largeCatagoryId }" />'"><c:if test="${item.useStatus==false }"><i class="icon-op icon-op-disable"></i>禁用</c:if><c:if test="${item.useStatus==true}"><i class="icon-op icon-op-able"></i>启用</c:if></a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						</div>
					</div>					
				</section>
				
				<footer class="cont_section_footer">
				   <form name="pageForm" action="" method="post">
				    <input type="hidden" name="pageIndex" id="pageIndex" value="" />
				    <input type="hidden" name="pageSize" id="pageSize" value="" />
				    <input type="hidden" name="name" id="name" value="<c:out value="${query.name}"/>" />
					<%-- <a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex-1 }" />);"><span class="left page">上一页</span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex }" />);"><span class="left page page_chose"><c:out value="${query.pageIndex }" /></span></a>
					<a href="javascript:void()" onclick="javascript:submitPageForm(<c:out value="${query.pageIndex+1 }" />);"><span class="left page">下一页</span></a> --%>
				   </form>
				   <div id="div_pager"></div>
				</footer>
				
		<!-- 将弹出层下面的页面变成不可操作状态，成半透明状态 --> 		
		<div class="div_hid" id="spm" style="display: none;"></div>		
		<!-- 弹出导入页面 -->				
			<div class="div_alert">
				<header class="div_alert_top">导入商品</header>
					<section class="div_alert_mid">
				 <form action="" id="upfile" name="upfile" method="post" enctype="multipart/form-data">
						<input type="file"  class="btn_file left"  name="file" />
						<a href="javascript:void()" onclick="importProduct();"><span class="btn left btn_post">上传文件</span></a>
						<a href="javascript:void()" onclick="javascript:location.href='download'"><span class="btn left btn_load">下载模板</span></a>
				</form>	
					</section>
				<footer class="div_alert_bot">
					<a href="javascript:void()" onclick="closePopup();"><span class="btn btn_alertClose">关闭</span></a>
				</footer>
				<a href="javascript:void()" onclick="closePopup();"><span class="close">×</span></a>
			</div>
	</div>
</body>
</html>

<script>

$(".btn_import").on("click",function(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"block"}); 
	_div.css({"display":"block"});
	return false; 
});

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
	var catagoryIds = new Array();
	$("[name='id']").each(function(i,item){
		if(item.checked==true)
			catagoryIds.push(item.value);
	});
	if(catagoryIds.length > 0){
		document.location.href="deleteCatagory?catagoryIds=" + catagoryIds;
	}else{
		alert("请选择要删除的分类");
	}
}

function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	var largeCatagoryId = $("#largeCatagoryId").val();
	if(largeCatagoryId==null || largeCatagoryId==''){
		$("[name='pageForm']").attr("action","selectLargeCatagory");
	}else{
		$("[name='pageForm']").attr("action","selectMiddleCatagory?largeCatagoryId="+largeCatagoryId);	
	}
	
	$("[name='pageForm']").submit();
}

/*
 * 导入
 */
function importProduct(){
		var formData = new FormData();
		var files = $('input[name="file"]').prop('files');
		if(files == null){
			alert("请先选择上传文件");
			return false;
		}
		formData.append("file",files[0]);
		$.ajax({ 
			url : "importEditProduct", 
			type : 'POST', 
			data : formData, 
			// 告诉jQuery不要去处理发送的数据
			processData : false, 
			// 告诉jQuery不要去设置Content-Type请求头
			contentType : false,
			beforeSend:function(){
			console.log("正在进行，请稍候");
			},
			success : function(result) { 
				alert(result["message"]);
			}, 
			error : function(r) { 
				alert(result["message"]);
			} 
			});
}


function popupImport(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"block"}); 
	_div.css({"display":"block"});
	return false; 
}
function closePopup(){
	var target=$("#spm");
	var _div=$(".div_alert");
	target.css({"display":"none"}); 
	_div.css({"display":"none"});
	return false; 
}
</script>