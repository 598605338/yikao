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
<script type="text/javascript">
	window.onload=function(){
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
	}


	 function cunrentPage(){
		 $("#cunrentPage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 $("#pageIndex").val(1);
		 }
		 $('#formain').submit();
	} 
	
	 function nextPage(){
		 $("#nextPage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 pg=1;
		 }
		 var nextPg=parseInt(pg)+1;
		 $("#pageIndex").val(nextPg);
		 var pg1=$("#pageIndex").val();
		 $('#formain').submit();
	 }
	 
	 function beforePage(){
		 $("#beforePage").addClass("left page page_chose");
		 var pg=$("#pageIndex").val();
		 if(!pg){
			 pg=1;
		 }else if(pg>0){
			 pg=pg-1;
		 }
		 $("#pageIndex").val(pg);
		 $('#formain').submit();
	 }
 
	 function cleanForm(){
		 $(':input','#formain').not(':button, :submit, :reset, :hidden').val(''); 
	 }
 
	 
		//全选功能
			function doChoose(){
				//首先要取到"全选"复选框的选中状态
				var state = document.getElementById('all').checked;
				//让所有的single复选框的状态和state保持一致
				var singles = document.getElementsByName('activity_id');
				//循环遍历每一个single
				for(var i=0;i<singles.length;i++){
					singles[i].checked = state;
				}
			}
		
			//当我们将每一个single都选中的时候,让"全选"复选框自动选中
			function chooseSingle(){
				var count = 0;
				//判断每一个single是否都选中了呢 ?
				var singles = document.getElementsByName('activity_id');
				for(var i=0;i<singles.length;i++){
					if(singles[i].checked){
						count++;
					}
				}
				//根据选中的single的个数,来确定"全选"复选框的状态
				if(count == singles.length){
					document.getElementById('all').checked = true;
				}else{
					document.getElementById('all').checked = false;
				}
			}

			function delAll(type){
					var activity_ids="";
						//判断每一个single是否都选中了呢 ?
						var singles = document.getElementsByName('activity_id');
						for(var i=0;i<singles.length;i++){
							if(singles[i].checked){
								var svalue=singles[i].value;
								if(svalue){
									activity_ids=activity_ids+svalue+"-";
								}
							}
						}
						
						if(activity_ids){
							if(activity_ids.charAt(activity_ids.length-1)=="-"){
								activity_ids=activity_ids.substr(0,activity_ids.length-1);
							}
						}
						
						if(activity_ids){
							var data1=activity_ids;
							$.ajax({			
									url:"<%=path%>/promotion/deleteActInfoById",
									type:"POST",
									data: 'activity_ids='+data1+"&activity_type="+1,
									dataType: 'text',
									success:function(data){
										console.log(data);
									},
									error:function(err){
										alert(err);
									}
								})
						}
				}
			}
			
			function addNew(ad_id){
				window.location.href="<%=path%>/jsp/views/advitise_manage/new_goods_add.jsp?ad_id="+ad_id;
			}
			
			
			function doWithGoods(){
				var jsonArr=new Array();
				var ad_id=$("#ad_id").val();
				var ad_type=$("#ad_type").val();
				$('#pro_item tr').each(function(){
					var order_px= $(this).find('td').eq(0).find("input[name='order_px']").val();
					var productId= $(this).find('td').eq(0).find("input[name='productId']").val();
					var p_code= $(this).find('td').eq(0).find("input[name='p_code']").val();
					var id= $(this).find('td').eq(0).find("input[name='id']").val();
					var banner_name= $(this).find('td').eq(1).find("input[name='banner_name']").val();
					var ban_picture= $(this).find('td').eq(2).find("img")[0].src;
					var obj={};
					obj.order_px=order_px;
					obj.productId=productId;
					obj.p_code=p_code;
					obj.id=id;
					obj.banner_name=banner_name;
					if(ban_picture){
						ban_picture=ban_picture.replace("http://www.linjia-cvs.cn","");
					}
					obj.ban_picture=ban_picture;
					if(ad_id){
						ad_id=parseInt(ad_id);
					}
					obj.ad_id=ad_id;
					obj.ad_type=ad_type;
					jsonArr.push(obj);
				});

				if(jsonArr!=null&&jsonArr.length){
					var jstor=JSON.stringify(jsonArr);
					$("#baseInfos").val(jstor);
				}else{
					return false;
				}
				document.getElementById('formain').submit();
				return true;
		}

</script>
<body>
<div id="wrap">
<c:out value="${message }" />
				<header class="cont_section_header">新品推荐列表</header>
				<div class="height">
					<span class="right back_dblue btn" onclick="window.history.back()"><i class="icon-btn icon-goback"></i>返回</span>
				</div>
				<section class="cont_section_section">					
					<div class="goodsManage">
					<div class="height" style="display:none;">
							<span class="left back_dblue btn" onclick="addNew(${ad_id})"><i class="icon-btn icon-add"></i>新增新品</span>
							<span class="left back_dblue btn" onclick="doWithGoods()"><i class="icon-btn icon-reset"></i>test</span>
					</div>
						<div class="section_table">
							<table cellspacing="none">
						<thead>
							<th style="width:15%;">排序</th>
							<th style="width:35%;">商品名称</th>
							<th>图片</th>
							<th style="width:10%;">操作</th>
						</thead>
						<tbody id="pro_item">
						<c:forEach var="banner" items="${bannerlist}" varStatus="status">
						 	<tr class="goods_tr">
								<td><input type="text" id="order_px" value="${banner.order_px}" name="order_px" />
									<input type="hidden" id="productId${status.index}" value="${banner.productId}" name="productId" />
									<input type="hidden" id="pCode${status.index}" value="${banner.p_code}" name="p_code" />
									<input type="hidden" id="id" value="${banner.id}" name="id" />
								</td>
								<td><input type="text" id="pName${status.index}" value="${banner.banner_name}" name="banner_name" /></td>
								<td><img style="width:80px;" id="imageSrc${status.index}" src="${banner.ban_picture}"/>
									<input type="hidden" value="${banner.ban_picture}" name="ban_picture" />
								</td>
								<td>
								<a style="margin-left:10%;" href="<%=basePath%>/product/select?popupFlg=1&params=productId${status.index},pCode${status.index},pName${status.index},pSendType${status.index},imageSrc${status.index},marketPrice${status.index},imagePath${status.index}" target="popupWin" onclick="popupProOpen();"><span style="display:inline-block;" class="back_dblue btn">选择</span></a></td>
							</tr>
						</c:forEach>
						</tbody>
						</table>
						<div class="height">
								<div class="bgbtn flex">
						<form name="formain" id="formain" method="post" action="<%=path%>/advManage/updBatchBaseInfos" >
							<input type="hidden" id="ad_id" value=${ad_id} name="ad_id" />
							<input type="hidden" id="ad_type" value=10 name="ad_type" />
							<input type="hidden" id="baseInfos" value="" name="baseInfos" />
							<!-- <span ><input type="submit" value="保存" class="left back_dblue col_white btn"/></span> -->
							<span ><button type="button" onclick="doWithGoods()" class="left back_dblue col_white btn"><i class="icon-btn icon-save"></i>保存</button></span>
						</form>
								</div>								
							</div>
						</div>
					</div>					
				</section>
				
			<!-- 弹出框 -->
	<div id="fade" class="black_overlay">  
    </div>
    <div id="popupDiv" style="position: absolute;z-index:1002;display:none;width: 80%; height: 80%; background-color: white; position: absolute; left: 10%; top:12%;">
        <span class="disp" onclick="popupProClose();" style="cursor:pointer;position:absolute;top:-20px;right:-20px;height:40px;width:40px;border-radius:20px;line-height:40px;font-size:18px;color:#fff;text-align:center;">×</span>  
		<iframe style="position: absolute; width: 100%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 
   	</div> 
	</body>
</html>
