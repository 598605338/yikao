<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
					<span style="color:#3bb3e0;">考生成绩查询</span>
				</header>
				<section class="cont_section_section">					
					<div class="goodsManage">
						<div class="cont_section_head">
					<form name="form" id="formSubmit" action="select" method="post">
						<div class="row">
							<input type="text" name="candidateNum" id="candidateNum" placeholder="考生考号" value="<c:out value="${query.candidateNum }"/>" class="td_text_w" />
							<input type="text" name="candidateName" id="candidateName" placeholder="考生名称" value="<c:out value= "${query.candidateName }"/>" class="td_text_w" />
							<input type="text" name="collegeName" id="collegeName" placeholder="院校名称" value="<c:out value="${query.collegeName }"/>" class="td_text_w" />
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
                          <shiro:hasPermission name="9">
							<div class="click">
							<span class="left back_dblue btn btn_import"><i
									class="icon-btn icon-import"></i>导入</span>
						    </div>
                          </shiro:hasPermission>
						<thead style="background:#EBEBEB ;">
							<%--<th><input style="margin-left:20%;" type="checkbox" name="selAll" onclick="selAll(this);"/></th>--%>
							<th>考生考号</th>
							<th>考生姓名</th>
							<th>考生性别</th>
							<th>院校名称</th>
							<th>专业名称</th>
							<th>校考成绩</th>
							<th>名次</th>
							<%--<th>操作</th>--%>
						</thead>
						<tbody>
						<c:forEach var="item" items="${studentScoreList }" varStatus="status">
							<tr class="goods_tr">
								<%--<td style="width:2.5%;"><input style="margin-left:20%;" type="checkbox" name="id" value="<c:out value="${item.id }" />"/></td>--%>
								<td  style="width:15%;" ><a href="javascript:void(0)" onclick="searchByClick('<c:out value="${item.candidateNum }"/>',1)"><c:out value="${item.candidateNum }"/></a></td>
									<td  style="width:12%;" ><a href="javascript:void(0)" onclick="searchByClick('<c:out value="${item.candidateName }"/>',2)"><c:out value="${item.candidateName }"/></a></td>
								<td  style="width:8%;" ><c:if test="${item.sex==0}">男</c:if><c:if test="${item.sex==1}">女</c:if></td>
									<td  style="width:20%;" ><a href="javascript:void(0)" onclick="searchByClick('<c:out value="${item.collegeName }"/>',3)"><c:out value="${item.collegeName }"/></a></td>
									<td  style="width:20%;" ><a href="javascript:void(0)" onclick="searchByClick('<c:out value="${item.specialtyName }"/>',4)"><c:out value="${item.specialtyName }"/></a></td>
								<td  style="width:10%;" ><c:out value="${item.score }"/></td>
								<td  style="width:10%;" ><c:out value="${item.rank }"/></td>
									<%--<td  style="width:20%;">--%>
									<%--<a href="javascript:void(0)" class="mr10" onclick="location.href='toEdit?id=<c:out value="${item.id }" />'"><i class="icon-op icon-op-edit"></i>修改</a>--%>
								<%--</td>--%>
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
				    <input type="hidden" name="candidateNum" id="candidateNum1" value="<c:out value="${query.candidateNum}"/>" />
				    <input type="hidden" name="candidateName" id="candidateName1" value="<c:out value="${query.candidateName}"/>" />
				    <input type="hidden" name="collegeName" id="collegeName1" value="<c:out value="${query.collegeName}"/>" />
				    <input type="hidden" name="specialtyName" id="specialtyName1" value="<c:out value="${query.specialtyName}"/>" />
					</form>
				   <div id="div_pager"></div>
				</footer>

		<!-- 将弹出层下面的页面变成不可操作状态，成半透明状态 -->
		<div class="div_hid" id="spm" style="display: none;"></div>
		<!-- 弹出导入页面 -->
		<div class="div_alert">
			<header class="div_alert_top">导入成绩录取信息</header>
			<section class="div_alert_mid">
				<form action="" id="upfile" name="upfile" method="post"
					  enctype="multipart/form-data">
					<input type="file" class="btn_file left" name="file" /> <a
						href="javascript:void();" onclick="importProduct(this);"><span
						class="btn left btn_post">上传文件</span></a>
					<%--<a href="javascript:void()" onclick="javascript:location.href='download'"><span class="btn left btn_load">下载模板</span></a>--%>
				</form>
			</section>
			<footer class="div_alert_bot"> <a href="javascript:void()"
											  onclick="closePopup();"><span class="btn btn_alertClose">关闭</span></a>
			</footer>
			<a href="javascript:void()" onclick="closePopup();"><span
					class="close">×</span></a>
		</div>
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
var pageSize=20;
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
dividePage.generPageHtml2(pageSize);



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


/**2017.2.9
 * 导入按钮。
 */
$(".btn_import").on("click",function(){
    var target=$("#spm");
    var _div=$(".div_alert");
    target.css({"display":"block"});
    _div.css({"display":"block"});
    return false;
});

/*
 * 导入
 */
function importProduct(o){
    var formData = new FormData();
    var files = $('input[name="file"]').prop('files');
    if(files == null){
        alert("请先选择上传文件");
        return false;
    }
    formData.append("file",files[0]);
    $.ajax({
        url : "importStudentScore",
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
            $(o).attr("disabled",false);
            $(o).attr("onclick","importProduct(this)");
        },
        error : function(r) {
            alert(result["message"]);
        }
    });

    //按钮变灰
    $(o).attr("disabled",true);
    $(o).attr("onclick","javascript:return false;");
}

function closePopup(){
    var target=$("#spm");
    var _div=$(".div_alert");
    target.css({"display":"none"});
    _div.css({"display":"none"});
    return false;
}

function searchByClick(val,type){
    var form = document.form;
    switch (type){
		case 1:
		    $("#candidateNum").val(val);
		    break;
		case 2:
            $("#candidateName").val(val);
            break;
        case 3:
            $("#collegeName").val(val);
            break;
        case 4:
            $("#specialtyName").val(val);
            break;
	}
    form.submit();
}
</script>