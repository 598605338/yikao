<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">基本信息</a><span>&gt;</span>
					<span style="color:#3bb3e0;">科目管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
					<form name="form" id="formSubmit" action="select" method="post">
						<div class="row">
							<input type="text" name="specialtyName" id="specialtyName" placeholder="科目名称" value="<c:out value="${query.specialtyName }"/>" class="td_text_w" />
						</div>
						<div class="col-click">
							<button type="button" class="left back_dblue col_white btn" onclick="document.getElementById('formSubmit').submit();"><i class="icon-btn icon-search"></i>查询</button>
						<button type="button" class="left back_dblue col_white btn"
							onclick="resetForm()">
							<i class="icon-btn icon-reset"></i>重置
						</button>
					</div>
					</form>		
						</div>		
						<div class="section_table">
							<table cellspacing="none" class="table_hover">
							<div class="click">
							<a href="javascript:void(0)" onclick="location.href='toAdd'"><span class="left back_dblue btn"><i class="icon-btn icon-add"></i>新增科目</span></a>
							<a href="javascript:void(0)" onclick="deleteRecord();"><span class="left back_dblue btn"><i class="icon-btn icon-delete"></i>删除</span></a>
						</div>
						<thead style="background:#EBEBEB ;">
							<th><input style="margin-left:20%;" type="checkbox" name="selAll" onclick="selAll(this);"/></th>
							<th>科目名称</th>
							<th>操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${specialtyList }" varStatus="status">
							<tr class="goods_tr">
								<td style="width:2.5%;"><input style="margin-left:20%;" type="checkbox" name="id" value="<c:out value="${item.id }" />"/></td>
								<td  style="width:20%;" ><c:out value="${item.specialtyName }"/></td>
								<td  style="width:20%;">
									<a href="javascript:void(0)" class="mr10" onclick="location.href='toEdit?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
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
				    <input type="hidden" name="name" id="name" value="<c:out value="${query.specialtyName}"/>" />
					</form>
				   <div id="div_pager"></div>
				</footer>
	</div>
</body>
</html>

<script>
/**2017.2.10
 * 分页插件
 */
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
		return this.hrefFormer + this.hrefLatter + "?pageIndex=" + n+"&pageSize="+pageSize; //参数名跟上面相同
	},
	getLink2 : function(pageIndex,pageSize) {
		return "javascript:submitPageForm("+pageIndex+","+pageSize+");"; //参数名跟上面相同
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
	var ids = [];
	$("[name='id']").each(function(i,item){
		if(item.checked==true)
            ids.push(item.value);
	});
	if(ids.length > 0){
		document.location.href="deleteSpecialty?ids=" + ids;
	}else{
		alert("请选择要删除的科目");
	}
}

function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}
</script>