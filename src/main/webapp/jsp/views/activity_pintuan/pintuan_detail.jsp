<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<jsp:include page="../../../js/timepicker/timepicker.jsp" />
<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js"></script>
<script type="text/javascript">
window.onload=function(){	 
	 $('#startTimeStr').datetimepicker({
			dateFormat:'yy-mm-dd',
			timeFormat: 'HH:mm:ss',
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1
		});
	
	 $('#endTimeStr').datetimepicker({
		 	dateFormat:'yy-mm-dd',
			timeFormat: 'HH:mm:ss',
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1
	});
	 
	 var desc=$("#description").val();
		if(desc){
			$("#content").val(desc);
		}
	}

	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
 
	 function doWithAmount(){
		 var amounts="";
			//判断每一个single是否都选中了呢 ?
			var singles = document.getElementsByName('amount');
			for(var i=0;i<singles.length;i++){
				var svalue=singles[i].value;
				if(svalue){
					amounts=amounts+svalue+"-";
				}
			}
			
			if(amounts){
				if(amounts.charAt(amounts.length-1)=="-"){
					amounts=amounts.substr(0,amounts.length-1);
				}
			}
			
			if(amounts){
				$("#amountListStr").val(amounts);
			}
		 
	 }   
	      
	    function addInput(){
	    	event.preventDefault();
	    	var btn=$("#addInput");
	      	btn.append('<input name="amount" id="amount" type="text" class="left" value="${cashAmount.amount}"/><button  onclick="removeInput()">Del</button><br />');
	    }
	    
	    function removeInput(){
	    	event.preventDefault();
	    	$(this).closest('input').remove(); 
	    }
	    
	    
	    function colsePage(){
	    	window.location.href=history.go(-1);
	    }
	    
	    function doSubmitCheck(){
			var form = document.formain;
			var startTimeStr = form.startTimeStr.value;
			var endTimeStr = form.endTimeStr.value;
			var lowerLimit = form.lowerLimit.value;
			var upperLimit = form.upperLimit.value;
			var work_time = form.work_time.value;
			var pName= form.pName.value;
			var pCode= form.pCode.value;
			var marketPrice= form.marketPrice.value;
			var ptPrice = form.ptPrice.value;
			var quantity = form.quantity.value;
			var giveScore = form.giveScore.value;
			var sortIndex = form.sortIndex.value;
			if(startTimeStr==null || startTimeStr==''){
		        alert("发布开始时间不能为空！");
		        return false;
			}
			if(endTimeStr==null || endTimeStr==''){
		        alert("发布结束时间不能为空！");
		        return false;
			}
			if(lowerLimit==null || lowerLimit==''){
		        alert("活动人数下限不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$"); 
				if(!reg.test(lowerLimit)){  
			        alert("活动人数下限请输入数字!");  
			        return false;
			    } 
			}
			if(upperLimit==null || upperLimit==''){
		        alert("活动人数上限不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$"); 
				if(!reg.test(upperLimit)){  
			        alert("活动人数上限请输入数字!");  
			        return false;
			    } 
			}
			if(lowerLimit&&upperLimit){
				if(parseInt(lowerLimit)>parseInt(upperLimit)){
					 alert("活动人数下限人数应小于活动上限人数!");  
				     return false;
				}
			}
			if(work_time==null || work_time==''){
		        alert("活动有效时间不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$"); 
				if(!reg.test(work_time)){  
			        alert("活动有效时间请输入数字!");  
			        return false;
			    } 
			}
			if(pName==null || pName==''){
		        alert("商品名称不能为空！");
		        return false;
			}
			if(pCode==null || pCode==''){
		        alert("商品code不能为空！");
		        return false;
			}
			if(marketPrice==null || marketPrice==''){
		        alert("市场销售金额不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$");
				var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
				if(!(reg.test(marketPrice)||reg1.test(marketPrice))){  
			        alert("市场销售金额格式有误!");  
			        return false;
			    } 
			}
			if(ptPrice==null || ptPrice==''){
		        alert("拼团价格不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$");
				var reg1 = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
				if(!(reg.test(ptPrice)||reg1.test(ptPrice))){  
			        alert("拼团价格格式有误!");  
			        return false;
			    } 
			}
			if(quantity==null || quantity==''){
		        alert("活动库存不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$"); 
				if(!reg.test(quantity)){  
			        alert("活动库存请输入数字!");  
			        return false;
			    } 
			}
			if(giveScore){
				var reg = new RegExp("^[0-9]*$"); 
				if(!reg.test(quantity)){  
			        alert("赠送积分请输入数字!");  
			        return false;
			    } 
			}
			
			if(sortIndex==null || sortIndex==''){
		        alert("排序不能为空！");
		        return false;
			}else{
				var reg = new RegExp("^[0-9]*$"); 
				if(!reg.test(sortIndex)){  
			        alert("排序请输入数字!");  
			        return false;
			    } 
			}
			
			 var descripe=$("#content").val();
				if(descripe){
					$("#description").val(descripe);
				}
			document.getElementById('formain').submit();
			return true;
		}
	    
	    function gbcount(){
	    	  var max=150; 
	    	  var content = document.getElementById("content");
	    	  var used = document.getElementById("used");
	    	  var remain = document.getElementById("remain");
	    	  if(content.value.length > max){ 
	    	   content.value = content.value.substring(0,max); 
	    	   used.innerHTML = max; 
	    	   remain.innerHTML = 0; 
	    	   alert("最多只能输入150字！");
	    	  }else{ 
	    	   used.innerHTML = content.value.length; 
	    	   remain.innerHTML = max - content.value.length; 
	    	  } 
	    	 }
</script>
<style>
	td{
		border:none;
		height:40px;
	}
	.addLeft{
	display:block;
	margin-left:10%;
}
.goods_tr{
	margin-top:5px;
}
.aleft{
	margin-left:5%;
}
.disp{
	display:inline-block;
	width:100%;
	text-align:left;
	border:1px solid red;
	word-break:break-all;
}
.goods_time{
    text-align: left;
    width:8%;
    height:auto;
    word-wrap: break-word;
}
</style>
<body>
<div id="wrap">
<c:out value="${message }" />
				<!-- <header class="cont_section_header">拼团商品详情</header> -->
				<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">拼团管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">详情</span>
				</header>
				<section class="cont_section_section_border">					
					<div class="goodsManage">
						<div>
						<form name="formain" id="formain" method="post" action="<%=path%>/pintuan/updBaseInfo" enctype="multipart/form-data" >
						<div class="editPage">
								<div class="editLeft">
									<div class="row-list">
										<label class="left">发布时间：</label>
										<input class="datatime-input td_text_w" style="width: 30%;" placeholder="发布时间起" type="text"  name="startTimeStr" id="startTimeStr" value="${BaseDetail.startTimeStr}" >
										<p style=" float:left;width:3%;display:inline-block;margin-left: -1px; margin-right: 1px;line-height: 32px;text-align: center;">~</p>
										<input class="datatime-input td_text_w" style="width: 30%;" placeholder="发布时间止" type="text" name="endTimeStr" id="endTimeStr" value="${BaseDetail.endTimeStr}">
									</div>
									<div class="row-list">
										<label class="left">活动人数：</label>
										<input style="float:left;width:30%;"  name="lowerLimit" id="lowerLimit" type="text" class="left" value="${BaseDetail.lowerLimit}" readonly="readonly" />
										<p style=" float:left;width:3%;display:inline-block;margin-left: -1px; margin-right: 1px;line-height: 32px;text-align: center;">~</p>
										<input style="width: 30%;"  name="upperLimit" id="upperLimit" type="text" class="left" value="${BaseDetail.upperLimit}" readonly="readonly" />
									</div>
									<div class="row-list">
										<label class="left">活动时间：</label>
										<input  name="work_time" id="work_time" readonly="readonly" type="text" value="${BaseDetail.work_time}" class="left td_text_w"  />
									</div>
									<div class="row-list">
										<label class="left">商品名称：</label>
										<input class="left td_text_w" style="width: 47.5%;margin-right: 1.7%;" name="pName" id="pName" value="${BaseDetail.pName}" type="text" />
										<a  href="<%=basePath%>/product/select?popupFlg=1&params=productId,pCode,pName,pSendType,imageSrc,marketPrice,imagePath" target="popupWin" onclick="popupProOpen();"><span style="position: relative; top: 1px;margin: 0;width: 9.5%;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
									</div>
									<div class="row-list">
										<label class="left">商品条形码：</label>
										<input class="td_text_w" name="pCode" id="pCode" value="${BaseDetail.pCode}" type="text"  readonly="readonly" />
									</div>
									<div class="row-list">
										<label class="left">商品市场价格：</label>
										<input class="td_text_w" name="marketPrice" id="marketPrice" type="text" value="${BaseDetail.marketPrice}" readonly="readonly" />
									</div>
									<div class="row-list">
										<label class="left">描述：</label>
										<textarea class="td_text_w" id="content" cols="60" rows="6" onkeydown="gbcount();" onkeyup="gbcount();"></textarea>
										<input name="description" id="description" type="hidden" value="${BaseDetail.description}"/>
										<p style="margin-left: 120px;">
										    请勿超过<span id="total" style="color:#FF0000">150</span>字，您已经输入了<span id="used" style="color:#FF0000">0</span>字，
		  								   还可以继续输入<span id="remain" style="color:#FF0000">150</span>字
										</p>	
									</div>
								</div>
								<div class="line"></div>
								<div class="editRight">
									<div class="row-list">
										<label class="left">团购价：</label>
										<input class="td_text_w" name="ptPrice" id="ptPrice" type="text" value="${BaseDetail.ptPrice}"/>
									</div>
									<div class="row-list">
										<label class="left">参与活动库存：</label>
										<input class="td_text_w"  name="quantity" id="quantity" type="text" value="${BaseDetail.quantity}"/>
									</div>
									<div class="row-list">
										<label class="left">赠送积分：</label>
										<input class="td_text_w"  name="giveScore" id="giveScore" type="text"  value="${BaseDetail.giveScore}"/>
									</div>
									<div class="row-list">
										<label class="left">商品图：</label>
										<div class="imgbox" ">
		    								<div class="imgnum">
		        								<input name="uploadImage" id="uploadImage" type="file" value="${bannerInfo.ban_picture}" class="filepath"/>
		       									<span class="close" style="display: none;color:#fff;">×</span>
		        								<img src="${BaseDetail.imagePath}" name="imageSrc" id="imageSrc" class="img2" />
		        								<img src="<%=path%>/js/inputFile/btn.png" class="img1" />
		    								</div>
										</div>
										<small>(请上传1242*834尺寸的图片)</small>
									</div>
									<div class="row-list">
										<label class="left">排序：</label>
										<input class="td_text_w" name="sortIndex" id="sortIndex" type="text"  value="${BaseDetail.sortIndex}"/>
										<input name="productId" id="productId" type="hidden"  value="${BaseDetail.productId}"/>
										<input name="id" id="id" type="hidden" class="left td_text_w" value="${BaseDetail.id}"/>
									</div>
								</div>
							</div>			
										
						</form>
						</div>	
					</div>					 
				</section>
				<div class="bgbtn">
					<!-- <input type="submit" class="left back_dblue col_white btn" value="保存" />
					<input style="margin-left:5%;" type="button" class="left back_dblue col_white btn" onclick="colsePage()" value="返回"/> -->
					<button type="button" class="left back_dblue btn" onclick="doSubmitCheck()"><i class="icon-btn icon-search"></i>保存</button>
					<button type="button" class="left back_dblue btn" onclick="colsePage()"><i class="icon-btn icon-goback"></i>返回</button>
				</div>		
					<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" style="position: absolute;z-index:1002;display:none;width: 90%; height: 90%; background-color: white; position: absolute; left: 5%; top:6%;padding: 0 14px;">
        <span onclick="popupProClose();" style="cursor:pointer;position:absolute;top:-15px;right:-15px;height:40px;width:40px;border-radius:20px;line-height:34px;color:#000;text-align:center;font-size:30px;">×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	</div>
	</body>
</html>
