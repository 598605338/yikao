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
    var collegeId = form.collegeId.value;
    var specialtyId = form.specialtyId.value;
    var batchId = form.batchId.value;
    var year = form.year.value;
    var type = form.type.value;
    var highScore = form.highScore.value;
    var lowScore = form.lowScore.value;
    var averageScore = form.averageScore.value;
    var admissionNum = form.admissionNum.value;
    var ruleTab = form.ruleTab.value;

    if (collegeId == null || collegeId == '') {
        document.editForm.collegeId.focus();
        alert("请选择院校！");
        return false;
    }
    if (specialtyId == null || specialtyId == '') {
        document.editForm.specialtyId.focus();
        alert("请选择科目！");
        return false;
    }
    if (batchId == null || batchId == '') {
        document.editForm.batchId.focus();
        alert("请选择批次！");
        return false;
    }
    if (year == null || year == '') {
        document.editForm.year.focus();
        alert("请选择年代！");
        return false;
    }
    if (type == null || type == '') {
        document.editForm.type.focus();
        alert("请选择类型！");
        return false;
    }
    if (highScore == null || highScore == '') {
        document.editForm.highScore.focus();
        alert("请输入最高分！");
        return false;
    }
    if (lowScore == null || lowScore == '') {
        document.editForm.lowScore.focus();
        alert("请输入最低分！");
        return false;
    }
    if (averageScore == null || averageScore == '') {
        document.editForm.averageScore.focus();
        alert("请输入平均分！");
        return false;
    }
    if (admissionNum == null || admissionNum == '') {
        document.editForm.admissionNum.focus();
        alert("请输入录取人数！");
        return false;
    }

    if (ruleTab == 0) {
        //选择已有
        var admissionRuleId = form.admissionRuleId.value;
        if (admissionRuleId == null || admissionRuleId == '') {
            alert("请选择录取规则！");
            return false;
        }
    } else {
        var description = form.description.value;
        if (description == null || description == '') {
            document.editForm.description.focus();
            alert("请输入录取规则！");
            return false;
        }
    }

	form.submit();
}

//返回
function doBack(){
	document.location.href="select";
}

function ruleTabChange(v) {
    if (v == 0) {
        $("#ruleAlready").show();
        $("#ruleAdd").hide();
    } else if (v == 1) {
        $("#ruleAlready").hide();
        $("#ruleAdd").show();
    }
}
</script>
<style>
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
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">录取信息管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
	<section class="cont_section_section_border">
	<form id="formSubmit" class="goods_new" action="edit" name="editForm" method="post">
	<input type="hidden" id="id" name="id" value="<c:out value="${admissionInfo.id }" />"/>
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>院校名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="collegeName" id="collegeName" value="<c:out value="${admissionInfo.collegeName}"/>" />
					<select name="collegeId" id="collegeId" class="td_text_w" >
						<option value="">请选择</option>
						<c:forEach items="${collegeList }" var="item" varStatus="status">
							<option value="${item.id }">${item.collegeName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>科目名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="specialtyName" id="specialtyName" value="<c:out value="${admissionInfo.specialtyName}"/>" />
					<select name="specialtyId" id="specialtyId" class="td_text_w" >
						<option value="">请选择</option>
						<c:forEach items="${specialtyList }" var="item" varStatus="status">
							<option value="${item.id }">${item.specialtyName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>批次名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="batchName" id="batchName" value="<c:out value="${admissionInfo.batchName}"/>" />
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
					<input class="td_text_w" type="text" name="admissionNum" id="admissionNum" value="<c:out value="${admissionInfo.admissionNum}"/>" />
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
					<input class="td_text_w" type="text" name="highScore" id="highScore" value="<c:out value="${admissionInfo.highScore}"/>" />
				</div>
				<div class="row-list">
					<label>最低分<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="lowScore" id="lowScore" value="<c:out value="${admissionInfo.lowScore}"/>" />
				</div>
				<div class="row-list">
					<label>平均分<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="averageScore" id="averageScore" value="<c:out value="${admissionInfo.averageScore}"/>" />
				</div>
			</div>

			<hr style="clear: both;"/>
			<!--录取规则-->
			<header class="cont_section_header_bread">
				<i class="" style="margin-right:5px;"></i>录取规则：
			</header>
			<div style="text-align: center;">
				<input class="left" style="border:none;" type="radio" name="ruleTab" value="0"
					   onchange="ruleTabChange('0');" checked="true"/>
				<span class="left">选择已有</span>
				<input class="left" style="border:none;" type="radio" name="ruleTab" value="1"
					   onchange="ruleTabChange('1');"/>
				<span class="left">新增</span>
			</div>
			<div style="clear: both"></div>
			<div id="ruleAlready">
				<table cellspacing="none" class="table_hover">
					<thead style="background:#EBEBEB ;">
					<th>选择</th>
					<th>规则描述</th>
					<th>操作</th>
					</thead>
					<tbody id="ruleList">
					<c:forEach var="item" items="${admissionRuleList }" varStatus="status">
						<tr class="goods_tr">
							<td style="width:5%;"><input style="margin-left:20%;" type="radio" name='admissionRuleId' value="<c:out value="${item.id }" />" <c:if test="${item.id==admissionInfo.admissionRuleId}">checked = "true"</c:if> /></td>
							<td  style="width:15%;" ><c:out value="${item.description }"/></td>
							<td  style="width:10%;">
								<a href="javascript:void(0)" class="mr10" onclick="toEditRule(<c:out value="${item.id }" />)"><i class="icon-op icon-op-edit"></i>修改</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="ruleAdd" style="display: none;">
				<div>
					<label>录取规则描述：</label>
					<textarea class="td_text_w" name="description" id="description" rows="5"></textarea>
				</div>
			</div>
		</div>
	
	</form>
	</section>
	<div class="bgbtn">
		<button type="button" onclick="doSubmit();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue btn" onclick="doBack();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>

<div class="back_bg" style="display:none;">
	<%-- <iframe src="<%=basePath%>secuser/toUpdatePwd?login=${ sessionScope.user.login}">
    </iframe>
    <jsp:include page="jsp/views/secuser/secuser_update_password.jsp" /> --%>
</div>
<div class="zezhaoc" style="display:none;position: absolute;top: 0;left: 0;right: 0;bottom: 0;background: rgba(0,0,0,0.5);"></div>
</body>
</html>

<script>
$("#collegeId").val(<c:out value="${admissionInfo.collegeId}"/>);
$("#specialtyId").val(<c:out value="${admissionInfo.specialtyId}"/>);
$("#batchId").val(<c:out value="${admissionInfo.batchId}"/>);
$("#year").val(<c:out value="${admissionInfo.year}"/>);
$("[name='type'][value=<c:out value="${admissionInfo.type}"/> ]").attr("checked",true);
$("[name='type'][value=<c:out value="${admissionInfo.type}"/> ]").attr("checked",true);

$("#collegeId").on("change", function () {
    //alert("aaaaa");
    $("#collegeName").val($(this).children("option:selected").text());
    $("#specialtyName").val("");
    $("#specialtyId").html("<option value=''>请选择</option>");
    //请求院校相关的科目和录取规则
    $.ajax({
        cache: false,
        type: "post",
        url: "querySpecAndRuleListByCollegeId",
        data: {"collegeId": $(this).children("option:selected").val()},
        success: function (result) {
            if (result != null && result.status == 'ok') {
                var specialtyList = result.specialtyList;
                var admissionRuleList = result.admissionRuleList;

                //填充科目列表
                if (specialtyList != null && specialtyList.length > 0) {
                    $.each(specialtyList, function (i, item) {
                        var _temp = $("<option>");
                        var _id = item.id;
                        var _name = item.specialtyName;
                        _temp.attr("value", _id).text(_name);
                        $("#specialtyId").append(_temp);
                    });
                }

                //填充录取规则列表
                fileRuleList(admissionRuleList);
            }
        },
        error: function (result) {
            alert("请求错误");
        }
    });
});

//科目选择
$("#specialtyId").on("change", function () {
    $("#specialtyName").val($(this).children("option:selected").text());
});

//批次选择
$("#batchId").on("change", function () {
    $("#batchName").val($(this).children("option:selected").text());
});


function toEditRule(_ruleId){
    $(".back_bg").load('<%=basePath%>admissionInfo/toEditRule?ruleId='+_ruleId);
    $(".pass_a").css("display","block");
    $(".back_bg").css("display","block");
	/* $("body").addClass("opty"); */
    $(".zezhaoc").show();
}

/**
 *填充规则列表
 */
function fileRuleList(admissionRuleList) {
    $("#ruleList").html("");
    if (admissionRuleList != null && admissionRuleList.length > 0) {
        var _ruleId = "";
        var _ruleDesc = "";

        $.each(admissionRuleList, function (i, item) {
            _ruleId = item.id;
            _ruleDesc = item.description;
            $("#ruleList").append(
                "<tr class='goods_tr'>" +
                "<td style='width:5%;'><input style='margin-left:20%;' type='radio' name='admissionRuleId' value='" + _ruleId + "'/></td>" +
                "<td  style='width:15%;' >" + _ruleDesc + "</td>" +
                "<td  style='width:10%;'>" +
                "<a href='javascript:void(0)' class='mr10' onclick='toEditRule("+_ruleId+")'><i class='icon-op icon-op-edit'></i>修改</a>" +
                "<a href='javascript:void(0)' class='mr10' onclick='deleteRule(this,"+_ruleId+");'><i class='icon-op icon-op-edit'></i>删除</a>" +
                "</td></tr>"
            );
        });
    }
}

function deleteRule(o,_ruleId){
    $.ajax({
        cache:false,
        type:"post",
        url:"deleteRule?ruleId="+_ruleId,
        data:{},
        success: function (result) {
            if (result != null && result.status == 'ok') {
                $(o).closest("tr").remove();
            }
        },
        error: function (result) {
            alert("请求错误");
        }
    });
}
</script>