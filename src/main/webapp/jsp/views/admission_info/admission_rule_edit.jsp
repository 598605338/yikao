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
	var description = form.description.value;
	if(description==null || description==''){
        document.editForm.description.focus();
        alert("请输入录取规则描述！");return false;
	}

	form.submit();
}

//返回
function doClose(){
    $(".pass_a").css("display","none");
	/*  $("body").removeClass("opty"); */
    $(".zezhaoc").hide();
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
  .td_text_wh{
	  margin:3px 0px 0px;
  	  width:637px;
	  height:195px;
  }
  .editLeft {
	  width: 80%;
	  float: left;
  }
</style>
<body>
<div id="wrap">
	<div style="width:60%;height:479px;border:1px solid #AAAAAA;position:absolute;top:15%;left:20%;background:#BEEBEE;z-index:1000;display:block;" class="pass_a">
	<font color="red"><c:out value="${message }" /></font>
	<header class="cont_section_header_bread">
					录取规则修改
				</header>
	<section class="cont_section_section_border">
	<form id="formSubmit" class="goods_new" action="edit" name="editForm" method="post">
	<input type="hidden" id="ruleId" name="ruleId" value="<c:out value="${admissionRule.id }" />"/>
	<input type="hidden" id="collegeId" name="collegeId" value="<c:out value="${admissionRule.collegeId }" />"/>
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>录取规则<span style="color:red">*</span>：</label>
					<textarea class="td_text_wh" type="text" rows="5" cols="80" name="description_e" id="description_e" ><c:out value="${admissionRule.description}"/></textarea>
				</div>
			</div>
			<div class="editRight">
			</div>

		</div>
	
	</form>
	</section>
	<div class="bgbtn">
		<button type="button" onclick="editRule();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button>
		<button type="button" class="left back_dblue btn" onclick="doClose();"><i class="icon-btn icon-goback"></i>返回</button>
	</div>
	</div>
	</div>
</body>
</html>

<script>

    function editRule(){
        var _ruleId = $("#ruleId").val();
        var _collegeId = $("#collegeId").val();
        var description = $("#description_e").val();

        $.ajax({
            cache:false,
            type:"post",
            url:"editRule?ruleId="+_ruleId+"&collegeId="+_collegeId,
            data:{"description":description},
            success: function (result) {
                if (result != null && result.status == 'ok') {
                    alert("编辑成功");
                    $(".pass_a").css("display","none");
                    $(".zezhaoc").hide();

                    //重新加载录取规则信息
                    var admissionRuleList = result.admissionRuleList;
                    fileRuleList(admissionRuleList);
                }
            },
            error: function (result) {
                alert("请求错误");
            }
        });
    }
</script>