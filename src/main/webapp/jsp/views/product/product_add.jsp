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
<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<jsp:include page="../header.jsp" />
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js"></script>
<script>
function doSubmit(){
	var form = document.saveForm;
	var pSendType = form.pSendType.value;
	var name = form.name.value;
	var pCode = form.pCode.value;
	var marketPrice = form.marketPrice.value;
	//var brandId = form.brandId.value;
	var unitId = form.unitId.value;
	var largeCatagoryId = form.largeCatagoryId.value;
	var middleCatagoryId = form.middleCatagoryId.value;
	var uploadImage = form.uploadImage.value;
	if(pSendType==null || pSendType==''){
        alert("请选择商品类型！");return false;
	}
	if(name==null || name==''){
        document.saveForm.name.focus();
        alert("请输入商品名称！");return false;
	}
	if(pCode==null || pCode==''){
        alert("商品条形码不能为空！");return false;
	}
	if(marketPrice==null || marketPrice==''){
        document.saveForm.marketPrice.focus();
        alert("请输入商品价格！");return false;
	}
	/* if(brandId==null || brandId==''){
        document.saveForm.brandId.focus();
        alert("请选择商品品牌！");return false;
	} */
	if(unitId==null || unitId==''){
        document.saveForm.unitId.focus();
        alert("请选择商品单位！");return false;
	}
	if(largeCatagoryId==null || largeCatagoryId==''){
        document.saveForm.largeCatagoryId.focus();
        alert("请选择商品分类！");return false;
	}
	/* if(middleCatagoryId==null || middleCatagoryId==''){
        document.saveForm.middleCatagoryId.focus();
        alert("请选择商品二级分类！");return false;
	} */
	if(uploadImage==null || uploadImage==''){
        document.saveForm.uploadImage.focus();
        alert("请选择上传图片！");return false;
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
	.td_left{
		 width:15%;
		 word-wrap:break-word; 
		 word-break:normal;
		 padding:5px 0;
	}
	.addheight{
		margin-top:10px;
	}
</style>
<body>
<div id="wrap" style="height:1072px;">
<c:out value="${message }" />
		<!-- <header class="cont_section_header">商品管理</header> -->
		<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">商品</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">商品管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">新增商品</span>
				</header>
<section class="cont_section_section_border">
					<form class="goods_new" name="saveForm" action="add" enctype="multipart/form-data" method="post">		
								
					<div class="editPage">
						<div class="editLeft">
							<div class="row-list">
								<label>商品类型<span style="color:red">*</span>：</label>
								<input class="left" style="border:none;" type="radio" name="pSendType" value="0" onchange="pSendTypeChange(0);"  />
								<span class="left">门店商品</span>
								<input class="left" style="border:none;" type="radio" name="pSendType" value="1" onchange="pSendTypeChange(1);"  />
								<span class="left">非门店商品</span>
							</div>
							<div id="noMallProInfo" style="display:none;">
								<div class="row-list">
									<label>销售价格：</label>
									<input class="td_text_w" type="text" name="salePrice" id="salePrice" value="" maxlength="10"  onkeyup="clearNoNum(this);"/>
								</div>
								<div class="row-list">
									<label>商品库存数：</label>
									<input class="td_text_w" type="text" name="quantity" id="quantity" value="" maxlength="4"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
								</div>
								<div class="row-list">
									<label>商品条形码<span style="color:red">*</span>：</label>
									<input class="td_text_w" type="text" name="pCode" id="pCode" readonly="readonly" value="<c:out value="${pCode}"/>" />
								</div>
							</div>
							<div class="row-list">
								<label>商品名称<span style="color:red">*</span>：</label>
								<input class="td_text_w" type="text" name="name" id="name" value="" maxlength="50" />
							</div>
							<div class="row-list">
								<label>商品描述：</label>
								<textarea class="td_text_w" name="description" id="description" maxlength="200" style="height:100px;"></textarea>
							</div>
							<div class="row-list">
								<label>市场价格<span style="color:red">*</span>：</label>
								<input class="td_text_w" type="text" name="marketPrice" id="marketPrice" value="" maxlength="10"  onkeyup="clearNoNum(this);"/><b >元</b>
							</div>
							<div class="row-list">
								<label>商品保质期：</label>
								<input class="td_text_w" type="text" name="shelfLife" id="shelfLife" maxlength="50"  value="" />
							</div>
							<div class="row-list">
								<label>商品品牌：</label>
								<input class="td_text_w" type="hidden" name="brandName" id="brandName" value="" />
								<select name="brandId" id="brandId" class="td_text_w">
									<option value="">请选择</option>
									<c:forEach items="${brandList }" var="item" varStatus="status">
										<option value="${item.id }">${item.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="row-list">
								<label>商品单位<span style="color:red">*</span>：</label>
								<input class="td_text_w" type="hidden" name="unitName" id="unitName" value="" />
								<select name=unitId id="unitId" class="td_text_w">
									<option value="">请选择</option>
									<c:forEach items="${productUnitList }" var="item" varStatus="status">
										<option value="${item.id }">${item.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="row-list">
								<label>商品分类<span style="color:red">*</span>：</label>
								<select name="largeCatagoryId" id="largeCatagoryId" class="td_text_w">
									<option value="">请选择一级分类</option>
									<c:forEach items="${largeCatagoryList }" var="item" varStatus="status">
										<option value="${item.id }">${item.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="row-list" id="middleCatagory" style="display:none;">
								<label></label>
								<select name="middleCatagoryId" id="middleCatagoryId"  class="td_text_w">
									<option value="">请选择二级分类</option>
								</select>
							</div>
							<div class="row-list">
								<label>赠送积分：</label>
								<input class="td_text_w" type="text" name="sendScore" id="sendScore" value="" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
								<b>分</b>
							</div>
						</div>
						<div class="line"></div>
						<div class="editRight">
							<div class="row-list">
								<label>商品图片<span style="color:red">*</span>：</label>
								<div class="imgbox">
    								<div class="imgnum">
        								<input type="file" class="filepath" name="uploadImage" id="uploadImage" />
       									<span class="close" style="top:0px;display:none;">×</span>
        								<img src="<%=path %>/js/inputFile/btn.png" class="img1" />
        								<img src="" class="img2" />
    								</div>
								</div>
								<small>(请上传1242*834尺寸的图片)</small>
							</div>
							<div class="row-list">
								<label>商品标签：</label>
								<c:forEach items="${productTagsList }" var="item" varStatus="status">
									<input class="left" style="border:none;" type="checkbox" value="${item.id }" name="pLabel"/>
									<span class="left">${item.name }</span>
								</c:forEach>
							</div>
							<div class="row-list">
								<label>重量：</label>
								<input class="td_text_w" type="text" name="pWeight" id="pWeight" value="" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">克(g)</b>
							</div>
							<div class="row-list">
								<label>商品体积(长)：</label>
								<input class="td_text_w" type="text" name="pLength" id="pLength" value="" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">mm</b>
							</div>
							<div class="row-list">
								<label>商品体积(宽)：</label>
								<input class="td_text_w" type="text" name="pWidth" id="pWidth" value="" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">mm</b>
							</div>
							<div class="row-list">
								<label>商品体积(高)：</label>
								<input class="td_text_w" type="text" name="pHigh" id="pHigh" value="" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">mm</b>
							</div>
						</div>
					</div>
						
					</form>
					</section>
					<div class="bgbtn">
							<!-- <input type="button" value="保存" class="left btn back_dblue" onclick="doSubmit();"/> 
							<input type="button" value="返回" class="left btn back_dblue" onclick="doBack();" /> -->
							<button type="button" class="left btn back_dblue" onclick="doSubmit();"><i class="icon-btn icon-save"></i>保存</button> 
							<button type="button" class="left btn back_dblue" onclick="doBack();" ><i class="icon-btn icon-goback"></i>返回</button>
						</div>
</body>
</html>
<script>
/**2017.2.9
 * 商品分类选择
 */
$("#largeCatagoryId").on("change",function(){
    alert("largeCatagoryId");
	$("#middleCatagoryId").html("<option value=''>请选择二级分类</option>");
	 //请求二级菜单数据
	 $.ajax({
		cache:false,
		type:"POST",
		url:"queryMidCatagoryByLargeId",
		data:{"largeId":$(this).children('option:selected').val()},
		success:function(result){
			if(result != null && result.status=='ok'){
				var middleCatagoryList = result.middleCatagoryList;
				if(middleCatagoryList.length > 0){
				$.each(middleCatagoryList,function(i,item){
					var _temp=$("<option>");
					var _id=item.id;
					var _name=item.name;
					_temp.attr("value",_id).text(_name);
					$("#middleCatagoryId").append(_temp);
				});
				$("#middleCatagory").show();
				}else{
					$("#middleCatagory").hide();
				}
			}
		}, 
		error:function(result){
			alert("请求错误");
		}
	});
}); 
/**2017.2.9
 * 如果是非门店商品，需要填写价格和库存
 */
function pSendTypeChange(o){
	if(o==0){
		$("#noMallProInfo").hide();
	}else if(o==1){
		$("#noMallProInfo").show();
	}
}


/**2017.2.9
 * 商品品牌选择。
 */
$("#brandId").on("change",function(){
	var val = $(this).children('option:selected').val();
	var name = $(this).children('option:selected').text();
	if(val != ''){
		$("#brandName").val(name);
	}
});

/**2017.2.9
 * 商品单位选择。
 */
$("#unitId").on("change",function(){
	var val = $(this).children('option:selected').val();
	var name = $(this).children('option:selected').text();
	if(val != ''){
		$("#unitName").val(name);
	}
});

</script>