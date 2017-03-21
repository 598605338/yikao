<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	%>
<!DOCTYPE HTML>
<html>

<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<style>
	.imgbox{
		height:150px;
		border:none;
		border:0;
	}
	.imgnum{
		height:142px;
		border:1px solid #ccc;
	}
	.imgnum input{
		margin-bottom:8px;
		border:none;
	}
	.imgnum_del{
		position:absolute;
		bottom:0;
		left:0;
		right:0;
		margin:auto;
	}
	.cont_section_section_border{
		position: relative;
	}
	small{
		position: absolute;
	    bottom: 18px;
	    color: #2285C5;
    }
</style>
<jsp:include page="../header.jsp" />
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js"></script>
<style>
	.domit{
		margin:12% 0% 0% 1%;
	}
	.doack{
		margin:12% 0% 0% 2%;
	}
</style>
<body>
<div id="wrap">
<!-- <header class="cont_section_header">上传商品轮播图</header> -->
<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">商品</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">商品管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">上传商品轮播图</span>
				</header>
<section class="cont_section_section_border">
	<form class="goods_new" name="uploadForm" id="uploadForm" action="" enctype="multipart/form-data" method="post">
	<input type="hidden" name="id" id="id" value="<c:out value="${id }"/>" />	
	<input type="hidden" name="pageIndex" id="pageIndex" value="<c:out value="${pageIndex }"/>" />
		<div id="imgboxGroup">
			<c:forEach var="item" items="${bannerImageList }" varStatus="status">
			<div class="imgbox">
				<div class="imgnum">
					<input type="file" class="filepath" name="uploadImage" value="${item.path }" lang="${item.id }"/> 
					<span class="close" style="top: 0px; !important">X</span> 
					<img src="${item.path }" class="img1" /> 
					<img src="" class="img2" style="display:none;"/>
				</div>
				<a class="imgnum_del" href="javascript:void(0)" onclick="deleteImage(this,<c:out value="${item.id }" />,'<c:out value="${item.path }" />');"><span class="left back_dblue btn"><i class="icon-btn icon-delete"></i>删除</span></a>
			</div>
			</c:forEach>
			<div class="imgbox" >
				<div class="imgnum">
					<input type="file" class="filepath" name="uploadImage" /> 
					<span class="close" style="top: 0px; !important">×</span> 
					<img src="<%=path %>/js/inputFile/btn.png" class="img1" /> 
					<img src="" class="img2" style="display:none;"/>
				</div>
			</div>
			<small>(请上传400*300尺寸的图片)</small>
			<div id="addContent" style="display:none;">
				<div class="imgbox" >
					<div class="imgnum">
						<input type="file" class="filepath" name="uploadImage"  /> 
						<span class="close" style="top: 0px; !important">×</span> 
						<img src="<%=path %>/js/inputFile/btn.png" class="img1" /> 
						<img src="" class="img2" style="display:none;"/>
					</div>
				</div>
			</div>
		</div>
			
		</form>
</section>
<div class="bgbtn">
	<a href="javascript:void(0)" onclick="addImgbox();"><span class="left back_dblue btn"><i class="icon-btn icon-add"></i>添加</span></a>
	<a href="javascript:void(0)" onclick="uploadImages();"><span class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</span></a>
	<a href="javascript:void(0)" onclick="doBack();"><span class="left back_dblue btn"><i class="icon-btn icon-goback"></i>返回</span></a>
</div>
</div>
</body>
</html>
<script>

/*
 * 添加选择框
 */
function addImgbox(){
	var _imgbox = $("#addContent").html();
	$("#imgboxGroup").append(_imgbox);
	
	$(".filepath").on("change",function() {
        var srcs = getObjectURL(this.files[0]);   //获取路径
        $(this).nextAll(".img1").hide();   //this指的是input
        console.log($(this).nextAll(".img2"))
        $(this).nextAll(".img2").show();  //fireBUg查看第二次换图片不起做用
        $(this).nextAll('.close').show();   //this指的是input
        $(this).nextAll(".img2").attr("src",srcs);    //this指的是input
		//$(this).val('');    //必须制空
        $(".close").on("click",function() {
            $(this).hide();     //this指的是span
            $(this).nextAll(".img2").hide();
            $(this).nextAll(".img1").show();
        })
    });
}

/*
 * 上传轮播图
 */
function uploadImages(){
		var id=$("#id").val();
		var count=0;
		var formData = new FormData();
		//var formData2 = new FormData($( "#uploadForm" )[0]);
		var imageArr = $('input[name="uploadImage"]');
		if(imageArr != null && imageArr.length > 0){
			imageArr.each(function(i){
				var files = $(this).prop('files');
				var bannerImageId = $(this).prop('lang');
				if(files != null){
				 	formData.append("uploadImage",files[0]); 
				 	if(files[0]){
				 		if(bannerImageId){
							formData.append("bannerImageId",bannerImageId);
						}else{
					 		formData.append("bannerImageId",0);
				 		}
				 	}
					count++;
				}
			});
		} 
		if(count > 0){
			$.ajax({ 
				url : "uploadBannerImage?id="+id, 
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
					document.location.href = "select?pageIndex="+<c:out value="${pageIndex }"/>
				}, 
				error : function(r) { 
					alert(result["message"]);
				} 
				});
		}else{
			alert("更新完成");
		}
		
}

	/*
 * 删除轮播图
 */
function deleteImage(o,id,path){
	$.ajax({
		cache:false,
		type:"GET",
		url:"deleteBannerImage",
		data:{"id":id,"path":path},
		success:function(result){
			if(result != null && result.status=='ok'){
				$(o).closest(".imgbox").remove();
			}
		}, 
		error:function(result){
			alert("请求错误");
		}
	});
}
//返回
function doBack(){
	document.location.href="select";
}
</script>