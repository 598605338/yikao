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
	var collegeName = form.collegeName.value;
	if(collegeName==null || collegeName==''){
        document.editForm.collegeName.focus();
        alert("请输入院校名称！");return false;
	}

    //提交选择的科目值
    checkedSpecs();
    var containSpecialtyIds = form.containSpecialtyIds.value;
    if(containSpecialtyIds==null || containSpecialtyIds==''){
        alert("请选择科目！");return false;
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
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">院校管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
	<section class="cont_section_section_border">
	<form id="formSubmit" class="goods_new" action="edit" name="editForm" method="post">
	<input type="hidden" id="id" name="id" value="<c:out value="${college.id }" />"/>
		<div class="editPage">
			<div class="editLeft">
				<div class="row-list">
					<label>院校名称<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="collegeName" id="collegeName" value="<c:out value="${college.collegeName}"/>" />
				</div>
				<div class="row-list">
					<label>所属省<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="provinceName" id="provinceName" value="<c:out value="${college.provinceName}"/>" />
					<select name="provinceId" id="provinceId" class="td_text_w">
						<option value="">请选择</option>
						<c:forEach items="${provinceList }" var="item" varStatus="status">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>所属市<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="cityName" id="cityName" value="<c:out value="${college.cityName}"/>" />
					<select name="cityId" id="cityId" class="td_text_w">
						<option value="">请选择</option>
						<c:forEach items="${cityList }" var="item" varStatus="status">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row-list">
					<label>所属区<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="hidden" name="countyName" id="countyName" value="<c:out value="${college.countyName}"/>" />
					<select name="countyId" id="countyId" class="td_text_w" onchange="setRegionName(this,3);">
						<option value="">请选择</option>
						<c:forEach items="${countyList }" var="item" varStatus="status">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="line"></div>
			<div class="editRight">
				<div class="row-list">
					<label>详细地址<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="address" id="address" value="<c:out value="${college.address}"/>" />
				</div>
				<div class="row-list">
					<label>固定电话<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="mobile" id="mobile" value="<c:out value="${college.mobile}"/>" />
				</div>
				<div class="row-list">
					<label>移动电话<span style="color:red">*</span>：</label>
					<input class="td_text_w" type="text" name="phone" id="phone" value="<c:out value="${college.phone}"/>" />
				</div>
				<div class="row-list">
					<label>院校科目选择<span style="color:red">*</span>：</label>
					<div style="width:100%;display:inline;float:left;">
						<div class="height">
							<input type="hidden" name="containSpecialtyIds" id="containSpecialtyIds" value="<c:out value="${college.containSpecialtyIds}"/>" />
							<c:forEach items="${specialtyList }" var="item" varStatus="status">
								<input class="left" type="checkbox" name="specialtyIds" id="specialtyIds_${item.id}"  value="${item.id}" /><b class="left">${item.specialtyName}</b>
							</c:forEach>
						</div>
					</div>
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
</body>
</html>

<script>

    /**2017.2.9
     * 初始化
     */
    $("#provinceId").val(<c:out value="${college.provinceId}"/>);
    $("#cityId").val(<c:out value="${college.cityId}"/>);
    $("#countyId").val(<c:out value="${college.countyId}"/>);

    //选中的科目
    var checkSpecIds = '<c:out value="${college.containSpecialtyIds}"/>';
    if(checkSpecIds != ''){
        var arraySpecIds = checkSpecIds.split(",");
    	if(arraySpecIds != null && arraySpecIds.length > 0){
            $.each(arraySpecIds,function(i,e){
//                alert(e);
				$("#specialtyIds_"+e).attr("checked",true);
			});
		}
	}

    /**2017.2.9
     * 提交选择科目值
     */
    function checkedSpecs() {
        var specArray=[];
        $("[name='specialtyIds']").each(function(i,e){
            if(e.checked){
                specArray.push(e.value);
            }
        });
        $("#containSpecialtyIds").val(specArray.join(","));
    }

    /**2017.2.9
     * 为区域name赋值
     */
    function setRegionName(o,type) {
        $("#provinceName").val($(o).children('option:selected').text());
        if(type == 1){
            $("#provinceName").val($(o).children('option:selected').text());
        }else if(type == 2){
            $("#cityName").val($(o).children('option:selected').text());
        }else if(type == 3){
            $("#countyName").val($(o).children('option:selected').text());
        }
    }

    /**2017.2.9
     * 区域选择
     */
    function requestRegion(o,type) {
        if(type == 1){
            $("#cityId").html("<option value=''>请选择城市列表</option>");
            $("#countyId").html("<option value=''>请选择区县列表</option>");
            setRegionName(o,1);
        }else if(type == 2){
            $("#countyId").html("<option value=''>请选择区县列表</option>");
            setRegionName(o,2);
        }

        $.ajax({
            cache:false,
            type:"POST",
            url:"../region/getRegionByParentId",
            data:{"parentId":$(o).children('option:selected').val()},
            success:function(result){
                if(result != null && result.status=='ok'){
                    var regionList = result.regionList;
                    if(regionList.length > 0){
                        $.each(regionList,function(i,item){
                            var _temp=$("<option>");
                            var _id=item.id;
                            var _name=item.name;
                            _temp.attr("value",_id).text(_name);
                            if(type == 1){
                                $("#cityId").append(_temp)
                            }else if(type == 2){
                                $("#countyId").append(_temp)
                            }
                        });
                    }else{
                        alert("没有所属区域信息");
                    }
                }
            },
            error:function(result){
                alert("请求错误");
            }
        });
    }

    /**2017.2.9
     * 区域选择事件绑定
     */
    $("#provinceId").on("change",function(){requestRegion(this,1);});
    $("#cityId").on("change",function(){requestRegion(this,2);});


</script>