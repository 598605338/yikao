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
	var form = document.editForm;
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
        document.editForm.name.focus();
        alert("请输入商品名称！");return false;
	}
	if(pCode==null || pCode==''){
        alert("商品条形码不能为空！");return false;
	}
	if(marketPrice==null || marketPrice==''){
        document.editForm.marketPrice.focus();
        alert("请输入商品价格！");return false;
	}
	/* if(brandId==null || brandId==''){
		document.editForm.brandId.focus();
        alert("请选择商品品牌！");return false;
	} */
	if(unitId==null || unitId==''){
		document.editForm.unitId.focus();
        alert("请选择商品单位！");return false;
	}
	if(largeCatagoryId==null || largeCatagoryId==''){
        document.editForm.largeCatagoryId.focus();
        alert("请选择商品分类！");return false;
	}
	/* if(middleCatagoryId==null || middleCatagoryId==''){
        document.editForm.middleCatagoryId.focus();
        alert("请选择商品二级分类！");return false;
	}
	if(uploadImage==null || uploadImage==''){
        document.editForm.uploadImage.focus();
        alert("请选择上传图片！");return false;
	} */
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
/*	line-height:35px;*/
}
 .spaceLeft{
 	display:block;
 	margin-left:-16%;
 }
 /*.height{
   height:33px;
   line-height:33px;
 }
 */
 .td_right{
 	line-height:40px;
 	height:40px;
 }
  .td_left{
   width:23%;
 }
</style>
<body>
<div id="wrap">
<c:out value="${message }" />
<!-- <header class="cont_section_header">商品管理</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">商品</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">商品管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">修改</span>
				</header>
<section class="cont_section_section_border">
					<form class="goods_new" name="editForm" action="edit" enctype="multipart/form-data" method="post">
					<input type="hidden" name="id" value="<c:out value="${product.id }"/>" />	
					<input type="hidden" name="pageIndex" id="pageIndex" value="<c:out value="${pageIndex }"/>" />	
						<div class="editPage">
							<div class="editLeft">
								<div class="row-list">
									<label>商品类型<span style="color:red">*</span>：</label>
									<input class="left" type="radio" name="pSendType" value="0" checked onchange="pSendTypeChange(0);"/>
									<span class="left">门店商品</span>
									<input class="left" type="radio" name="pSendType" value="1" onchange="pSendTypeChange(1);"/>	
									<span class="left">非门店商品</span>
								</div>
								<div id="noMallProInfo" style="display:none;">
									<div class="row-list">
										<label>销售价格：</label>
										<input class="td_text_w" type="text" name="salePrice" id="salePrice" value="<c:out value="${product.salePrice }"/>" maxlength="10"  onkeyup="clearNoNum(this);"/>
									</div>
									<div class="row-list">
										<label>商品库存数：</label>
										<input class="td_text_w" type="text" name="quantity" id="quantity" maxlength="4" value="<c:out value="${product.quantity }"/>"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
									</div>
								</div>
								<div class="row-list">
									<label>商品名称<span style="color:red">*</span>：</label>
									<input class="td_text_w" type="text" name="name" id="name" value="<c:out value="${product.name }"/>" maxlength="50"/>
								</div>
								<div class="row-list">
									<label>商品条形码<span style="color:red">*</span>：</label>
									<input class="td_text_w" type="text" name="pCode" id="pCode" readonly="readonly" value="<c:out value="${product.pCode }"/>" />
								</div>
								<div class="row-list">
									<label>商品描述：</label>
									<textarea style="height:80px;" class="td_text_w" name="description" id="description" maxlength="200" style="width:360px;height:100px;max-width:360px;max-height:100px;"><c:out value="${product.description }"/></textarea>
								</div>
								<div class="row-list">
									<label>市场价格<span style="color:red">*</span>：</label>
									<input class="td_text_w" name="marketPrice" id="marketPrice" type="text" value="<c:out value="${product.marketPrice }"/>" maxlength="10" onkeyup="clearNoNum(this);"/><b>元</b>
								</div>
								<div class="row-list">
									<label>商品保质期：</label>
									<input type="text" name="shelfLife" id="shelfLife" class="td_text_w" value="<c:out value="${product.shelfLife }"/>" maxlength="50" />
								</div>
								<div class="row-list">
									<label>商品品牌：</label>
									<input type="hidden" name="brandName" id="brandName" value="<c:out value="${product.brandName }"/>"/>
									<select name="brandId" id="brandId" class="td_text_w">
										<option value="">请选择</option>
										<c:forEach items="${brandList }" var="item" varStatus="status">
											<option value="${item.id }">${item.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="row-list">
									<label>商品单位：</label>
									<input type="hidden" name="unitName" id="unitName" value="<c:out value="${product.unitName }"/>"/>
									<select name=unitId id="unitId" class="td_text_w">
										<option value="">请选择</option>
										<c:forEach items="${productUnitList }" var="item" varStatus="status">
											<option value="${item.id }">${item.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="row-list">
									<label>商品分类<span style="color:red">*</span>：</label>
									<select class="classify td_text_w " name="largeCatagoryId" id="largeCatagoryId">
										<option value="">请选择一级分类</option>
										<c:forEach items="${largeCatagoryList }" var="item" varStatus="status">
											<option value="${item.id }">${item.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="row-list" id="middleCatagory">
									<label></label>
									<select class="classify td_text_w " name="middleCatagoryId" id="middleCatagoryId" >
										<option value="">请选择二级分类</option>
										<c:forEach items="${middleCatagoryList }" var="item" varStatus="status">
											<option value="${item.id }">${item.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="row-list">
									<label>赠送积分：</label>
									<input type="text" name="sendScore" id="sendScore" class="td_text_w" value="<c:out value="${product.sendScore }"/>"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
									<b>分</b>
								</div>
							</div>
							<div class="line"></div>
							<div class="editRigth">
								<div class="row-list">
									<label >商品图片<span style="color:red">*</span>：</label>
									 <div class="imgbox">
		   								<div class="imgnum">
		       								<input type="file" class="filepath" name="uploadImage" id="uploadImage" />
		      									<span class="close" style="top:0px; display:none;">×</span>
		       								<img src="<c:out value="${product.imagePath }"/>" class="img1" />
		       								<img src="" class="img2" />
		   								</div>
									</div> 
									<small>(请上传1242*834尺寸的图片)</small>
								</div>
								<div class="row-list">
									<label>商品标签：</label>
									<c:forEach items="${productTagsList }" var="item" varStatus="status">
										<input style="border:none;height:35px;"  class="left" type="checkbox" value="${item.id }" name="pLabel"/>
										<span class="left" style="margin-top:2px;">${item.name }</span>
									</c:forEach>
								</div>
								<div class="row-list">
									<label>重量：</label>
									<input class="td_text_w" type="text" name="pWeight" id="pWeight" value="<c:out value="${product.pWeight }"/>" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">克(g)</b>
								</div>
								<div class="row-list">
									<label>商品体积(长)：</label>
									<input class="td_text_w" type="text" name="pLength" id="pLength" value="<c:out value="${product.pLength }"/>" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">mm</b>
								</div>
								<div class="row-list">
									<label>商品体积(宽)：</label>
									<input class="td_text_w" type="text" name="pWidth" id="pWidth" value="<c:out value="${product.pWidth }"/>" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">mm</b>
								</div>
								<div class="row-list">
									<label>商品体积(高)：</label>
									<input class="td_text_w" type="text" name="pHigh" id="pHigh" value="<c:out value="${product.pHigh }"/>" maxlength="10" onkeyup="clearNoNum(this);"/><b style="margin-left:5px">mm</b>
								</div>
							</div>
						</div>
						
					</form>
					</section>
					<div class="bgbtn">
						<!-- <input type="button" value="保存" class="left btn back_dblue domit" onclick="doSubmit();"/> 
						<input type="button" value="返回" class="left btn back_dblue doack" onclick="doBack();" /> -->
						<button type="button" class="left btn back_dblue" onclick="doSubmit();"><i class="icon-btn icon-save"></i>保存</button> 
						<button type="button" class="left btn back_dblue" onclick="doBack();" ><i class="icon-btn icon-goback"></i>返回</button>
					</div>
					</div>
</body>
</html>
<script>

/**2017.2.9
 * 一级分类选完之后选择二级分类。
 */
function catagoryChange(){
	$("#middleCatagoryId").html("<option value=''>请选择二级分类</option>")
	 $.ajax({
		cache:false,
		type:"POST",
		url:"queryMidCatagoryByLargeId",
		data:{"largeId":$("#largeCatagoryId").children('option:selected').val()},
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
}


function pSendTypeChange(o){
	if(o==0){
		$("#noMallProInfo").hide();
	}else if(o==1){
		$("#noMallProInfo").show();
	}
}

$("#largeCatagoryId").on("change",catagoryChange); 
/**2017.2.9
 * 商品品牌
 * id='brandName'是一个影藏的表单，选择之后，表单内容也会跟着变。
 */
$("#brandId").on("change",function(){
	var val = $(this).children('option:selected').val();
	var name = $(this).children('option:selected').text();
	if(val != ''){
		$("#brandName").val(name);
	}
});

/**2017.2.9
 * 商品单位
 * 同上。
 */
$("#unitId").on("change",function(){
	var val = $(this).children('option:selected').val();
	var name = $(this).children('option:selected').text();
	if(val != ''){
		$("#unitName").val(name);
	}
});


/**2017.2.9
 * 初始化数据
 */
$("[name='pSendType'][value=<c:out value="${product.pSendType}"/>]").attr("checked",true);
$("#brandId").val(<c:out value="${product.brandId}"/>);
$("#unitId").val(<c:out value="${product.unitId}"/>);
$("#largeCatagoryId").val(<c:out value="${product.largeCatagoryId}"/>);
$("#middleCatagoryId").val(<c:out value="${product.middleCatagoryId}"/>);

var pSendType = "<c:out value="${product.pSendType}"/>";
if(pSendType == 1){
	$("#noMallProInfo").show();
}

//商品标签
var pLabel = "<c:out value="${product.pLabel}"/>";
var pLabelArray;
if(pLabel != null && pLabel !=''){
	pLabelArray = pLabel.split(",");
	for(var i=0;i<pLabelArray.length;i++){
		$("[name='pLabel'][value="+pLabelArray[i]+"]").attr("checked",true);
	}
}

//促销标签
var pPromotionLabel = "<c:out value="${product.pPromotionLabel}"/>";
var pPromotionLabelArray;
if(pPromotionLabel != null && pPromotionLabel !=''){
	pPromotionLabelArray = pPromotionLabel.split(",");
	for(var i=0;i<pPromotionLabel.length;i++){
		$("[name='pPromotionLabel'][value="+pPromotionLabelArray[i]+"]").attr("checked",true);
	}
}

</script>
<script type="text/javascript">
/**2017.2.9
 * 检测浏览器，如果是IE9。。。改变一些样式。
 */
var browser=navigator.appName
var b_version=navigator.appVersion
var version=b_version.split(";");
var trim_Version=version[1].replace(/[ ]/g,""); 
 if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
    $(".classify").css({"margin-left":"0px","width":"100%"})
    $(".td_left").css("width","11%")
}
</script>
