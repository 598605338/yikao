<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>
<script type="text/javascript">
window.onload=function(){
	 $('#sendBegintimeStr').timepicker({
			timeFormat: 'HH:mm:ss',
			timeInput: true
	 });
	
	 $('#sendEndhourStr').timepicker({
			timeFormat: 'HH:mm:ss',
			timeInput: true
	 });
	 
	 $('#getbyselfBegintimeStr').timepicker({
			timeFormat: 'HH:mm:ss',
			timeInput: true
	 });
	 
	 $('#getbyselfEndhourStr').timepicker({
			timeFormat: 'HH:mm:ss',
			timeInput: true
	 });
	 
	//setup();preselect('北京市');promptinfo();
	
	var isSupportSelfDeliver='<c:out value="${mall.isSupportSelfDeliver}"/>';
	var isSupportThirdDeliver='<c:out value="${mall.isSupportThirdDeliver}"/>';
	if(isSupportSelfDeliver==1){
		$("[name='isSupportSelfDeliver']:checkbox").attr("checked", true);
	}else{
		$("[name='isSupportSelfDeliver']:checkbox").attr("checked", false);
	}
	if(isSupportThirdDeliver==1){
		$("[name='isSupportThirdDeliver']:checkbox").attr("checked", true);
	}else{
		$("[name='isSupportThirdDeliver']:checkbox").attr("checked", false);
	}
	
	 $(":radio[name='shop_label'][value='<c:out value="${mall.shop_label}"/>']").prop("checked", "checked");
};

function promptinfo(){
  var address = document.getElementById('address').value;
  var s1 = document.getElementById('provinceName').value;
  var s2 = document.getElementById('cityName').value;
  var s3 = document.getElementById('countyName').value;
//var s4 = document.getElementById("address")
  
  address=address+s1+ s2 + s3;
  return address;
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
	    
	    function selSetVal(){
	    	var pro=$('#province option:selected');
	    	var proId=pro.val();
	    	var proVal=pro.text();
	    	var city=$('#city option:selected');
	    	var cityId=city.val();
	    	var cityVal=city.text();
	    	var county=$('#county option:selected');
	    	var countyId=county.val();
	    	var countyVal=county.text();
	    	$("#provinceId").val(proId);
	    	$("#provinceName").val(proVal);
	    	$("#cityId").val(cityId);
	    	$("#cityName").val(cityVal);
	    	$("#countyId").val(countyId);
	    	$("#countyName").val(countyVal);
	    	console.info(proId);
	    	console.info(proVal);
	    	console.info(cityId);
	    	console.info(cityVal);
	    	console.info(countyId);
	    	console.info(countyVal);
	    }
	    
		 function doSubmitCheck(){
			 selSetVal();
				var form = document.formain;
				var mallName = form.mallName.value;
				var mallCode = form.mallCode.value;
				var phone = form.phone.value;
				var sendBegintimeStr = form.sendBegintimeStr.value;
				var sendEndhourStr = form.sendEndhourStr.value;
				var getbyselfBegintimeStr = form.getbyselfBegintimeStr.value;
				var getbyselfEndhourStr = form.getbyselfEndhourStr.value;
				var sendPrice = form.sendPrice.value;
				var sendDistance = form.sendDistance.value;
				var shop_label = form.shop_label.value;
				var provinceName = form.provinceName.value;
				var cityName = form.cityName.value;
				var countyName = form.countyName.value;
				var address = form.address.value;
				var latitude = form.latitude.value;
				var longitude = form.longitude.value;
				if(mallName==null || mallName==''){
			        alert("门店名称不能为空！");
			        return false;
				}
				if(mallCode==null || mallCode==''){
			        alert("门店编码不能为空！");
			        return false;
				}
				if(phone==null || phone==''){
			        alert("联系电话不能为空！");
			        return false;
				}else{
					if(!(/^1[34578]\d{9}$/.test(phone))){ 
				        alert("手机号码格式有误，请重填!");  
				        return false; 
				    } 
				}
				if(sendBegintimeStr==null || sendBegintimeStr==''){
			        alert("配送开始时间不能为空！");
			        return false;
				}
				if(sendEndhourStr==null || sendEndhourStr==''){
			        alert("配送结束时间不能为空！");
			        return false;
				}
				if(getbyselfBegintimeStr==null || getbyselfBegintimeStr==''){
			        alert("自提开始时间不能为空！");
			        return false;
				}
				if(getbyselfEndhourStr==null || getbyselfEndhourStr==''){
			        alert("自提结束时间不能为空！");
			        return false;
				}
				if($("#isSupportSelfDeliver").is(":checked")){ 
					$("#isSupportSelfDeliver").val(1);
				}else{
					$("#isSupportSelfDeliver").val(0);
				}
				if($("#isSupportThirdDeliver").is(":checked")){ 
					$("#isSupportThirdDeliver").val(1);
				}else{
					$("#isSupportThirdDeliver").val(0);
				}
				var isSupportSelfDeliver = form.isSupportSelfDeliver.value;
				var isSupportThirdDeliver = form.isSupportThirdDeliver.value;
				if(!(isSupportSelfDeliver||isSupportThirdDeliver)){
			        alert("请选择配送方式！");
			        return false;
				}
				if(sendPrice==null || sendPrice==''){
			        alert("配送费不能为空！");
			        return false;
				}
				if(sendDistance==null || sendDistance==''){
			        alert("配送距离不能为空！");
			        return false;
				}
				if(shop_label==null || shop_label==''){
			        alert("标签名称不能为空！");
			        return false;
				}
				if(provinceName==null || provinceName==''){
			        alert("省市不能为空！");
			        return false;
				}
				if(cityName==null || cityName==''){
			        alert("城市不能为空！");
			        return false;
				}
				if(countyName==null || countyName==''){
			        alert("区不能为空！");
			        return false;
				}
				if(address==null || address==''){
			        alert("详细地址不能为空！");
			        return false;
				}
				if(latitude==null || latitude==''){
			        alert("纬度不能为空！");
			        return false;
				}
				if(longitude==null || longitude==''){
			        alert("经度不能为空！");
			        return false;
				}
				document.getElementById('formain').submit();
				return true;
			}
		 

</script>
<style>
  .Wdate{
  	height:26px;
  }
  .oeft{
  	margin-right:-17%;
  }
td{
   border:none;
}
.goods_tr input{
     border:1px solid #B3B3B3;
}
.goods_tr{
   height:45px;
}
.disleft{
	float:left;
}
</style>
<body>
<div id="wrap">
	<c:out value="${message }" />
	<!-- <header class="cont_section_header">修改门店</header>  -->
	<header class="cont_section_header_bread">
		<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
		<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">门店</a><span>&gt;</span>
		<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">门店管理</a><span>&gt;</span>
		<span style="color:#3bb3e0;">修改门店</span>
	</header>
	<section class="cont_section_section_border">
	<div class="goodsManage">
		<div>
			<form name="formain" id="formain" method="post"
				action="<%=path%>/shop/lbsMallupd" >
				
				<div class="editPage">
					<div class="editLeft">
						<div class="row-list">
							<label>门店名称：</label>
							<input class="td_text_w" name="mallName" id="mallName" type="text"
								 value="${mall.mallName}" />
						</div>
						<div class="row-list">
							<label>门店编号：</label>
							<input class="td_text_w" name="mallCode" id="mallCode" type="text"
								 value="${mall.mallCode}" />
						</div>
						<div class="row-list">
							<label>联系电话：</label>
							<input class="td_text_w" name="phone" id="phone" type="text"
								value="${mall.phone}" />
						</div>
						<div class="row-list">
							<label>配送时间：</label>
							<input style="width:30%;" class="datatime-input" type="text" 
									name="sendBegintimeStr" id="sendBegintimeStr" value="<fmt:formatDate value="${mall.sendBegintime}" pattern="HH:mm:ss"/>" >
							<p style=" float:left;width:3%;display:inline-block;text-align: center; margin-left: -1px; margin-right: 1px;line-height: 32px;">~</p>
							<input style="width:30%;" class="datatime-input" type="text"
									name="sendEndhourStr" id="sendEndhourStr" value="<fmt:formatDate value="${mall.sendEndhour}" pattern="HH:mm:ss"/>" >
						</div>
						<div class="row-list">
						   <label>自提时间：</label>
						   <input style="width:30%;" class="datatime-input" type="text"
									name="getbyselfBegintimeStr" id="getbyselfBegintimeStr" value="<fmt:formatDate value="${mall.getbyselfBegintime}" pattern="HH:mm:ss"/>" >
							<p style=" float:left;width:3%;display:inline-block;text-align: center; margin-left: -1px; margin-right: 1px;line-height: 32px;">~</p>
						   <input  class="datatime-input" style="width:30%;"  type="text"
									name="getbyselfEndhourStr" id="getbyselfEndhourStr" value="<fmt:formatDate value="${mall.getbyselfEndhour}" pattern="HH:mm:ss"/>" >
						</div>
						<div class="row-list">
							<label>配送方式：</label>
							<input name="isSupportSelfDeliver"
							    id="isSupportSelfDeliver" value="" type="checkbox" class="left" />
								<span style="float: left;margin-top: 3px;">自提</span>	
							<input name="isSupportThirdDeliver" id="isSupportThirdDeliver"
								value="" type="checkbox" class="left" />
								<span style="float: left;margin-top: 3px;">配送</span>
						</div>
						<div class="row-list">
							<label>配送费：</label>
							<input class="td_text_w" name="sendPrice" id="sendPrice" type="text"
								 value="${mall.sendPrice}" />
							<input class="disleft" name="bd_map_key" id="bd_map_key" type="hidden" value="${mall.bd_map_key}" />
						</div>
						<div calss="row-list">
							<label>配送距离：</label>
							<input class="td_text_w" name="sendDistance" id="sendDistance" type="text"
								class="oeft disleft"  value="${mall.sendDistance}" />
								<b>Km</b>
						</div>
						<div class="row-list">
							<label>标&ensp;&ensp;&ensp;签：</label>
							<input style="display:inline-block;" name="shop_label" id="shop_label" value=0
							    type="radio" class="left" />
						    <span style="float:left;margin-top: 2px;">自提</span>
						    <input name="shop_label"
							    id="shop_label" value=1 type="radio" class="left" />
						    <span style="float:left;margin-top: 2px;">配送</span>
						    <input name="shop_label"
							    id="shop_label" value=2 type="radio" class="left" />
						    <span style="float:left;margin-top: 2px;">全部</span>
						    <input name="useflg" id="useflg" value="${mall.useflg}" type="hidden" class="left" />
						    <input name="sendLimitMoney" id="sendLimitMoney" value="${mall.sendLimitMoney}" type="hidden" class="left" />
						    <input name="id" id="id" value="${mall.id}" type="hidden" class="left" />
						</div>
						<div class="row-list">
							<label>门店地址：</label>
							<select style="width:21%;" id="province">
									<option value="">省份（市）</option>
							</select> 
    						<input type="hidden" value="" id="provinceName" name="provinceName" />
    						<input type="hidden" value="" id="provinceId" name="provinceId" />
							<select style="width:21%;" id="city">
									<option value="">市（区）</option>
							</select> 
							<input type="hidden" value="" id="cityId" name="cityId" />
							<input type="hidden" value="" id="cityName" name="cityName" />
							<select style="width:21%;" id="county">
									 <option value="">县、镇、区</option>
							</select> 
							<input type="hidden" value="" id="countyId" name="countyId" />
							<input type="hidden" value="" id="countyName" name="countyName" />
						</div>
						<div class="row-list">
							<label></label>
							<input name="address" id="address" type="text" class="disleft" style="width: 45%;"
								value="${mall.address}" />
							<input style="margin-left: 1%;display:inline-block;background:#3BB3E0;color:#FFFFFF;height:33px;border-radius:5%;border: 0;" type="button"
								value="根据地址获取经纬度" onclick="searchByStationName();" />
						</div>
						<div class="row-list">
							<label>经纬度：</label>
							<input style="width: 31.5%;" name="latitude" id="latitude" type="text" value="${mall.latitude}" /> 
							<input style="width: 32%;" name="longitude" id="longitude" type="text"  value="${mall.longitude}" />
						</div>
					</div>
					<div class="line"></div>
					<div class="editRight">
						<div class="row-list">
							<div id="container" style="width: 100%; height: 590px;overflow: hidden;"></div>
						</div>
					</div>
				</div>
				
			</form>
		</div>
		
	</div>
	</section>
	<div class="bgbtn">
		<span ><button type="button" onclick="doSubmitCheck();" class="left back_dblue btn"><i class="icon-btn icon-save"></i>保存</button></span>
		<!-- <span ><button type="button" class="left back_dblue btn" onclick="cleanForm()"><i class="icon-btn icon-reset"></i>取消</button></span> -->
		<span class="left back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
	</div>
	</div>
</body>
<script type="text/javascript">
    var map = new BMap.Map("container");
    map.centerAndZoom("北京", 12);
    map.enableScrollWheelZoom();    
    map.enableContinuousZoom();    
    map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
    map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
    map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));   //右下角，打开
    var localSearch = new BMap.LocalSearch(map);
    localSearch.enableAutoViewport(); //允许自动调节窗体大小
   function searchByStationName() {
    map.clearOverlays();//清空原来的标注
     var keyword = promptinfo();
    localSearch.setSearchCompleteCallback(function (searchResult) {
    var poi = searchResult.getPoi(0);
    if(!poi){
    	alert("未定位到位置,请确认地址是不是正确!");
    }
    document.getElementById("latitude").value = poi.point.lat;
    document.getElementById("longitude").value = poi.point.lng; 
       var map = new BMap.Map("container"); // 创建地图实例   
       map.centerAndZoom(poi.point, 18);  // 初始化地图，设置中心点坐标和地图级别
       map.addControl(new BMap.NavigationControl());//放大地图
       var marker = new BMap.Marker(poi.point); // 创建标注 
       map.addOverlay(marker); 
       marker.enableDragging();
       //标注拖拽后的位置
       marker.addEventListener("dragend", function (e) {
           document.getElementById("latitude").value = e.point.lat;
           document.getElementById("longitude").value = e.point.lng;
       });
    });
    localSearch.search(keyword);
} 
</script>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/ProvincesAndRegions/ProJson.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/ProvincesAndRegions/CityJson.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/ProvincesAndRegions/DistrictJson.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/ProvincesAndRegions/geo.js'></script>
<script type="text/javascript">
	var pr='<c:out value="${mall.provinceId}"/>';
	var c='<c:out value="${mall.cityId}"/>';
	var d='<c:out value="${mall.countyId}"/>';
	$.each(province, function (k, p) {
	    var option = "<option value='" + p.ProID + "'>" + p.ProName + "</option>";
	    $("#province").append(option);
	});
	$("#province").find("option").each(function(i){
		if(Number($("#province").find("option").eq(i).val())===Number(pr)){
			$(this).attr({"selected":"selected"});
			 $.each(city, function (k, p) { 
                 if (p.ProID == Number(pr)) {
                     var option = "<option value='" + p.CityID + "'>" + p.CityName + "</option>";
                     $("#city").append(option);                    
                 }
             });
			 $("#city").find("option").each(function(j){
				 if(Number($("#city").find("option").eq(j).val())===Number(c)){
					 $(this).attr({"selected":"selected"})
				 }
			 });
			 $.each(District, function (k, dr) {
                 if (dr.CityID == c) {
                     var option = "<option value='" + dr.Id + "'>" + dr.DisName + "</option>";
                     $("#county").append(option);
                 }
             });
			 $("#county").find("option").each(function(m){
				 if(Number($("#county").find("option").eq(m).val())===Number(d)){
					 $(this).attr({"selected":"selected"})
				 }
			 });
		}
	});
</script>
</html>
