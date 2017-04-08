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
<jsp:include page="../header.jsp" />
<script>
function doSubmit(){
	var form = document.editForm;
	var name = form.name.value;
	if(name==null || name==''){
        document.editForm.name.focus();
        alert("请输入批次名称！");return false;
	}

	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}
</script>
<style>
  td{
  	border:none;
  }
  .domit{
  	margin:2% 0% 0% -230%;
  }
  .doack{
  	margin:2% 0% 0% -180%;
  }
  .td_left{
  	width:22%;
  }
</style>
<body>
<div id="wrap">
	<font color="red"><c:out value="${message }" /></font>
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">基本信息</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">批次管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
	<section class="cont_section_section_border">
	<form id="formSubmit" class="goods_new" action="edit" name="editForm" method="post">
	<input type="hidden" id="id" name="id" value="<c:out value="${admissionInfo.id }" />"/>
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>院校名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="collegeName" id="collegeName" value="" />
					<select name="collegeId" id="collegeId" class="td_text_w" >
						<option value="">请选择</option>
						<c:forEach items="${collegeList }" var="item" varStatus="status">
							<option value="${item.id }">${item.collegeName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>科目名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="specialtyName" id="specialtyName" value="" />
					<select name="specialtyId" id="specialtyId" class="td_text_w" >
						<option value="">请选择</option>
						<c:forEach items="${specialtyList }" var="item" varStatus="status">
							<option value="${item.id }">${item.specialtyName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>批次名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="batchName" id="batchName" value="" />
					<select name="batchId" id="batchId" class="td_text_w" >
						<option value="">请选择</option>
						<c:forEach items="${batchList }" var="item" varStatus="status">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>年份<span style="color:red">*</span>：</label>
					<select name="year" id="year" class="td_text_w" >
						<option value="">请选择</option>
						<option value="2011">2011</option>
						<option value="2012">2012</option>
						<option value="2013">2013</option>
						<option value="2014">2014</option>
						<option value="2015">2015</option>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
					</select>
				</div>
				<div class="row-list">
					<label>录取人数<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="admissionNum" id="admissionNum" value="" />
				</div>

			</div>
			<div class="line"></div>
			<div class="editRight">
				<div class="row-list">
					<label>类型<span style="color:red">*</span>：</label>
					<input class="left" style="border:none;" type="radio" name="type" value="0" onchange="pSendTypeChange(0);"  />
					<span class="left">文化</span>
					<input class="left" style="border:none;" type="radio" name="type" value="1" onchange="pSendTypeChange(1);"  />
					<span class="left">专业</span>
				</div>
				<div class="row-list">
					<label>最高分<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="highScore" id="highScore" value="" />
				</div>
				<div class="row-list">
					<label>最低分<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="lowScore" id="lowScore" value="" />
				</div>
				<div class="row-list">
					<label>平均分<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="averageScore" id="averageScore" value="" />
				</div>
			</div>

			<table cellspacing="none" class="table_hover">
				<thead style="background:#EBEBEB ;">
				<th>选择</th>
				<th>规则描述</th>
				<th>操作</th>
				</thead>
				<tbody>
				<c:forEach var="item" items="${admissionRuleList }" varStatus="status">
					<tr class="goods_tr">
						<td style="width:5%;"><input style="margin-left:20%;" type="radio" name="id" value="<c:out value="${item.id }" />"/></td>
						<td  style="width:15%;" ><c:out value="${item.description }"/></td>
						<td  style="width:10%;">
							<a href="javascript:void(0)" class="mr10" onclick="location.href='toEditRule?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-edit"></i>修改</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	
	</form>
	</section>
	<div class="bgbtn">
		<button type="button" onclick="doSubmit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue btn" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
</body>
</html>

<script>


</script>