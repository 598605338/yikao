<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				<!-- <header class="cont_section_header">权限管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">运营</a><span>&gt;</span>
					<span style="color:#3bb3e0;">权限管理</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
				<div class="section_table">
							<table class="table_hover" cellspacing="none">
							
							<shiro:hasRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">
								<div class="click">
									<a href="javascript:void()" onclick="javascript:location.href='toAdd'"><span class="left back_dblue btn onbtn"><i class="icon-btn icon-add"></i>添加用户组</span></a>
								</div>
							</shiro:hasRole>
							
						<thead style="background:#EBEBEB">
							<th>用户组</th>
							<th>描述</th>
							<th style="width:45%;">操作</th>
						</thead>
						<tbody>
						<c:forEach var="item" items="${secRoleList }" varStatus="status">
							<tr class="goods_tr" >
								<td><c:out value="${item.name }"/></td>
								<td><c:out value="${item.description }"/></td>
								<td>
									<a class="mr10" href="javascript:void(0)" onclick="javascript:location.href='accessPrivilege?secroleId=<c:out value="${item.id }" />'"><i class="icon-op icon-op-access"></i>访问授权</a>
									<a class="mr10" href="javascript:void(0)" onclick="javascript:location.href='toEdit?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
										<shiro:hasRole name="<%=com.linjia.constants.PrivilegeConstants.ROLE.ID_1%>">
									<a class="mr10" href="javascript:void(0)" onclick="javascript:location.href='deleteSecrole?secroleIds=<c:out value="${item.id }" />'"><i class="icon-op icon-op-delete"></i>删除</a>
									</shiro:hasRole>
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



function submitPageForm(pageIndex,pageSize){
	$("#pageIndex").val(pageIndex);
	$("#pageSize").val(pageSize);
	$("[name='pageForm']").submit();
}
</script>
<script type="text/javascript">
var browser=navigator.appName
var b_version=navigator.appVersion
var version=b_version.split(";");
var trim_Version=version[1].replace(/[ ]/g,""); 
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
   $(".click .onbtn").css("margin","-5px 0px 7px 10px")
}
</script>