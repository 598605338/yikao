<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script>
//返回
function doBack(){
	document.location.href="select";
}
</script>
<style>
 td{
    border:none;
 }
.td_right{
display:inline-block;
  width:80%;
  margin-left:-38%;
}
.height{
   height:45px;
}
</style>
<body>
	<div id="wrap">
	<!-- <header class="cont_section_header">秒杀商品管理</header> -->
	<header class="cont_section_header_bread">
					<i class="icon-op icon-op-address" style="margin-right:5px;"></i>当前位置：
					<a href="javascript:void(0);" class="topNavClick" style="color: #323232;">活动</a><span>&gt;</span>
					<a href="javascript:void(0);" class="leftNavClick" style="color: #323232;">秒杀管理</a><span>&gt;</span>
					<span style="color:#3bb3e0;">秒杀商品管理</span>
				</header>
	<section id="section" class="cont_section_section">
	<c:if test="${productList == null || productListSize==0}">
		<jsp:forward page="activity_miaosha_product_add.jsp" />
	</c:if>
	<div id="tab_list">
        <div class="tab_title clear">
            <span class="left leftBtn" href="javascript:void(0);"><img src="<%=path%>/dist/images/1.png" style="transform: rotate(180deg);margin-top: 7px;"></span>
            <div class="fixed_wrap">
                <div class="tab_wrap">
                    <ul>
                        <li class="hid"><a href="javascript:void(0);">新增商品</a><span class="delIcon">x</span></li>
                        <c:forEach items="${productList }" var="item" varStatus="status">
                        <li id="${item.id }"><a href="javascript:void(0);">${item.pName }</a><span class="delIcon">x</span></li>
                        </c:forEach>
                    </ul>
                    <span class="more" href="#">添加商品</span>
                </div>
            </div>
            <span class="right rightBtn" href="javascript:void(0);"><img src="<%=path%>/dist/images/1.png" style="margin-top: 7px;"></span>
        </div>
        <div class="tab_body">
            <div class="tab_main hid">
                <form class="goods_new cont_section_section_border" action="" name="saveForm" method="post">
					<input class="left" type="hidden" name="panicBuyingStartTimeStr" id="panicBuyingStartTimeStr" value='<fmt:formatDate value="${miaoshaActivityBase.panicBuyingStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' />
					<input class="left" type="hidden" name="panicBuyingEndTimeStr" id="panicBuyingEndTimeStr" value='<fmt:formatDate value="${miaoshaActivityBase.panicBuyingEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' />
					<input class="left" type="hidden" name="shangouBaseId" id="shangouBaseId" value="<c:out value="${miaoshaActivityBase.id }"/>" />
					<input type='hidden' name='id' id='id' value='' lang="addItem"/>
			
					<div class="editPage">
						<div class="editLeft">
							<div class="row-list">
								<label>商品名称<span style="color:red">*</span>：</label>
								<input class="td_text_w" style="width: 47.5%;margin-right: 1.7%;" type="text" name="pName" id="pName" readonly="readonly" value=""  lang="addItem"/>
								<input class="td_text_w" type="hidden" name="productId" id="productId" value=""  lang="addItem"/>
								<input class="td_text_w" type="hidden" name="pSendType" id="pSendType" value=""  lang="addItem"/>
								<a lang="popupLink" href="" target="popupWin" onclick="popupProOpen();"><span style="margin: 0;width: 9.5%;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
							</div>
							<div class="row-list">
								<label>商品条形码<span style="color:red">*</span>：</label>
								<input class="td_text_w" type="text" name="pCode" id="pCode" readonly="readonly"  value=""  lang="addItem"/>
							</div>
							<div class="row-list">
								<label>商品图片地址：</label>
	        					<img src="<%=path %>/js/inputFile/btn.png" style="width: 182px; height: 142px;" name="imageSrc" id="imageSrc" class="img1"  lang="addItem"/>
	        					<input type="hidden" value="" name="imagePath" id="imagePath" lang="addItem"/>
							</div>
							<div class="row-list">
								<label>商品价格：</label>
								<input class="td_text_w" type="text" name="marketPrice" id="marketPrice" readonly="readonly" value=""  lang="addItem"/>
							</div>
							<div class="row-list">
								<label>参与秒杀价<span style="color:red">*</span>：</label>
								<input class="td_text_w" type="text" name="pbPrice" id="pbPrice" value="" />
							</div>
							<div class="row-list">
								<label>秒杀库存数<span style="color:red">*</span>：</label>
								<input class="td_text_w" type="text" name="quantity" id="quantity" value="" />
							</div>
							<div class="row-list">
								<label>排序：</label>
								<input class="td_text_w" type="text" name="sortIndex" id="sortIndex" value="" />
							</div>
						</div>
						<div class="line"></div>
						<div class="editRight">
							<div class="row-list">
							
							</div>
						</div>
					</div>
					
			</form>
			<div class="bgbtn">
				<!-- <input  type="button" value="保存" onclick="submitAddForm(this);return false;" class="left btn back_dblue" />
			    <input  type="button" value="删除" onclick="deleteFrom(this);return false;" class="left btn back_dblue deleteBtn" />  -->
			    <button type="button" onclick="submitAddForm(this);return false;" class="left btn back_dblue" ><i class="icon-btn icon-save"></i>保存</button>
			    <button type="button" class="left btn back_dblue" onclick="doBack()" ><i class="icon-btn icon-goback"></i>返回</button>
			    <button type="button" style="display:none;" onclick="deleteFrom(this);return false;" class="left btn back_dblue deleteBtn" ><i class="icon-btn icon-delete"></i>删除</button>
			</div>
            </div>
            <c:forEach items="${productList }" var="item" varStatus="status">
            <div class="tab_main">
                <form class="goods_new cont_section_section_border" action="" name="editForm" method="post">
                    <input class="left" type="hidden" name="panicBuyingStartTimeStr" id="panicBuyingStartTimeStr" value="<fmt:formatDate value='${miaoshaActivityBase.panicBuyingStartTime }' pattern='yyyy-MM-dd HH:mm:ss'/>" />
                    <input class="left" type="hidden" name="panicBuyingEndTimeStr" id="panicBuyingEndTimeStr" value="<fmt:formatDate value='${miaoshaActivityBase.panicBuyingEndTime }' pattern='yyyy-MM-dd HH:mm:ss'/>" />
                    <input class="left" type="hidden" name="shangouBaseId" id="shangouBaseId" value="<c:out value="${miaoshaActivityBase.id }"/>" />
                    <input class="left" type="hidden" name="id" id="id" value="<c:out value="${item.id }"/>" />

                    <div class="editPage">
						<div class="editLeft">
							<div class="row-list">
								<label>商品名称：</label>
                                <input class="td_text_w" style="width: 47.5%;margin-right: 1.7%;" type="text" name="pName" id="pName${status.index }" readonly="readonly" value="<c:out value="${item.pName }"/>" />
                                <input class="td_text_w" type="hidden" name="productId" id="productId${status.index }" value="<c:out value="${item.productId }"/>" />
                                <input class="td_text_w" type="hidden" name="pSendType" id="pSendType${status.index }" value="<c:out value="${item.pSendType }"/>" />
                                <a href="<%=basePath%>/product/select?popupFlg=1&params=productId${status.index },pCode${status.index },pName${status.index },pSendType${status.index },imageSrc${status.index },marketPrice${status.index },imagePath${status.index }" target="popupWin" onclick="popupProOpen();"><span style="margin: 0; width: 9.5%;" class="back_dblue btn"><i class="icon-btn icon-enable"></i>选择</span></a>
							</div>
							<div class="row-list">
								<label>商品条形码<span style="color:red">*</span>：</label>
                                <input class="td_text_w" type="text" name="pCode" id="pCode${status.index }" readonly="readonly" value="<c:out value="${item.pCode }"/>" />
							</div>
							<div class="row-list">
								<label>商品图片地址：</label>
                                <img src="<c:out value="${item.imagePath }"/>" style="width: 182px; height: 142px;" name="imageSrc" id="imageSrc${status.index }" class="img1" />
                                <input type="hidden" value="<c:out value="${item.imagePath }"/>" name="imagePath" id="imagePath${status.index }"/>
							</div>
							<div class="row-list">
								<label>商品价格：</label>
                                <input class="td_text_w" type="text" name="marketPrice" id="marketPrice${status.index }" readonly="readonly" value="<c:out value="${item.marketPrice }"/>" /><b>元</b>
							</div>
							<div class="row-list">
								<label>参与秒杀价<span style="color:red">*</span>：</label>
                                <input class="td_text_w" type="text" name="pbPrice" id="pbPrice" value="<c:out value="${item.pbPrice }"/>" maxlength="10" onkeyup="clearNoNum(this);"/><b>元</b>
							</div>
							<div class="row-list">
								<label>秒杀库存数<span style="color:red">*</span>：</label>
                                <input class="td_text_w" type="text" name="quantity" id="quantity" value="<c:out value="${item.quantity }"/>" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
							</div>
							<div class="row-list">
								<label>排序：</label>
                                <input class="td_text_w" type="text" name="sortIndex" id="sortIndex" value="<c:out value="${item.sortIndex }"/>" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
							</div>
						</div>
						<div class="line"></div>
						<div class="editRight">
							<div class="row-list">
							
							</div>
						</div>
					</div>
                                        
                </form>
                <div class="bgbtn">
                    <button type="button" onclick="submitForm(this);return false;" class="left btn back_dblue subMit" ><i class="icon-btn icon-save"></i>保存</button>
                    <button type="button" class="left btn back_dblue" onclick="doBack()" ><i class="icon-btn icon-goback"></i>返回</button>
                    <button type="button" style="display:none;" onclick="deleteFrom(this);return false;" class="left btn back_dblue deleteBtn" ><i class="icon-btn icon-delete"></i>删除</button>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
	
	</section>
	
	
	
	
	
	
	<!-- 弹出框 -->
	<div id="fade" class="black_overlay">
    </div>
    <div id="popupDiv" style="position: absolute;z-index:1002;display:none;width: 90%; height: 90%; background-color: white; position: absolute; left: 5%; top:6%;padding: 0 14px;">
        <span class="disp" onclick="popupProClose();" style="cursor:pointer;position:absolute;top:-15px;right:-15px;height:40px;width:40px;border-radius:20px;line-height:34px;color:#000;text-align:center;font-size:30px;">×</span>  
		<iframe style="position: absolute; width: 98%; height: 100%; border-radius: 3px;" id="popupWin" name="popupWin" frameborder="0">
		</iframe>  
   	</div> 	
   	</div>
</body>
</html>

<script>
$(function(){
	/**2017.2.10
	 * 默认显示第二个，第一个为隐藏模板。
	 */
	$(".tab_title li").eq(1).addClass("active");
    $(".tab_body .tab_main").eq(1).addClass("active");
    /**2017.2.10
     * 标签页切换事件
     */
    $(".tab_title").on("click","li",function(){
        $(this).addClass("active").siblings().removeClass("active");
        $(".tab_main.active").removeClass("active");
        $(".tab_main").eq($(this).index()).addClass("active");
        return false;
    });
    /**2017.2.10
  	 * 添加按钮点击事件
  	 */
    $(".more").click(function(){
    	$(".tab_title li.active").removeClass("active");
        $(".tab_body .tab_main.active").removeClass("active");
    	var tempLi = $(".tab_title li").eq(0).clone();
    	tempLi.removeClass("hid").addClass("active").appendTo($(".tab_title ul"));
        var tempDom = $(".tab_body .tab_main").eq(0).clone();
        addItem(tempDom);
        tempDom.removeClass("hid").addClass("active").appendTo($(".tab_body"));
        tabWrapWidth();
        isNotAllowed();
    })

    tabWrapWidth();
    /**2017.2.10
     * 初始化tab Ul 宽度
     */
    function tabWrapWidth(){
        var oWrap = $(".tab_wrap");
        var oli = oWrap.find("li");
        oWrap.css("width",(oli.length-1)*141+70);
    }
    fixedWrapWidth();
    /**2017.2.10
     * 初始化fixed_wrap宽度
     */
    function fixedWrapWidth(){
        $(".fixed_wrap").css("width",$(".tab_title").width()-60);
    }
    /**
     * 窗口改变时改变fexed_wrap的宽度
     */
    window.onresize = function(){
        fixedWrapWidth();
        isNotAllowed();
    }
    /**
     * 左右点击事件，默认li（tab标签）初始位置为0
     */
    var ulIndex = 0;
    /**2017.2.10
     * 左边按钮点击事件
     */
    $("#tab_list .left").click(function(){
        if(ulIndex-1>=0){
            ulIndex--;
            $(".tab_wrap").animate({marginLeft:-141*ulIndex});
        }
        isNotAllowed();
    });
    /**2017.2.10
     * 右边按钮的点击事件
     */
    $("#tab_list .right").click(function(){
        if($(".tab_wrap").width()>141*ulIndex+$(".fixed_wrap").width()){
            ulIndex++;
            $(".tab_wrap").animate({marginLeft:-141*ulIndex});
        }
        isNotAllowed();
    });
    /**2017.2.10
     * 判断左右点击事件，是否禁用。
     */
    isNotAllowed();
    //是否禁用左右点击事件
    function isNotAllowed(){
        if($(".tab_wrap").width()<141*ulIndex+$(".fixed_wrap").width()){
            $("#tab_list .rightBtn").css("cursor","not-allowed");
        }else{
            $("#tab_list .rightBtn").css("cursor","pointer");
        }
        //console.log(parseInt($(".tab_wrap").css("marginLeft")))
        if(ulIndex==0){
            $("#tab_list .leftBtn").css("cursor","not-allowed");
        }else{
            $("#tab_list .leftBtn").css("cursor","pointer");
        }
    }
    
    /**2017.2.10
     * 绑定删除事件。
     */
    deleteFunc();
})

function deleteFunc(){
	
	$(".tab_title").on("click",".delIcon",function(){
		//删除事件
	    var oDel = $(".delIcon");
		var oMain = $(".tab_body").find(".tab_main");
		var tmp =  $(this).parents("li").index() - 1;
		var num = $(this).parents("li").siblings("li").length-1;
		$(oMain[$(this).parents("li").index()]).css("display","none");
		$(oMain[$(this).parents("li").index()]).find(".deleteBtn").trigger("click"); 
    	$(this).parents("li").remove(); 
    	
    	
    	$(".tab_title li.active").removeClass("active");
	    $(".tab_body .tab_main.active").removeClass("active");
    	console.log(tmp)
		setTimeout(function(){
			if(num>=1){
				console.log("111111111111111");
				if(tmp==0)
					tmp++;
				console.log($(".tab_body .tab_main").eq(tmp))
				$(".tab_title li").eq(tmp).addClass("active");
			    $(".tab_body .tab_main").eq(tmp).addClass("active");
			}else{
				console.log("2222222222222");
				if(tmp==0){
					$(".more").trigger("click");
				}
				//默认选中第一个
				//console.log($(".tab_body .tab_main").eq(1));
				$(".tab_title li").eq(1).addClass("active");
			    $(".tab_body .tab_main").eq(1).addClass("active");
			}
		},50);
    	return false;
	})
	
}

var addItemCount = "<c:out value="${productListSize}"/>";
function addItem(_addItem){
	//console.log("进入addItem函数")
	//var _addItem=$("#addItem").clone();
	_addItem.find("[lang='addItem']").each(function(i,item){
		var _str = $(item).attr("id");
		//console.log(item)
		$(item).attr({"id":_str+""+addItemCount});
	});
	var _a=_addItem.find("[lang='popupLink']");
	var _params="productId"+addItemCount+",pCode"+addItemCount+",pName"+addItemCount+",pSendType"+addItemCount+",imageSrc"+addItemCount+",marketPrice"+addItemCount+",imagePath"+addItemCount;
	var _href = "<%=basePath%>/product/select?popupFlg=1&params=" + _params;
	_a.attr("href",_href);
	
	//$("#section").append(_addItem.html());
	
	addItemCount++;
}

function submitForm(o){
	var _JqueryForm = $(o).parent().prev("[name='saveForm']");
	var form = _JqueryForm.get(0);
	var pCode = form.pCode.value;
	var pbPrice = form.pbPrice.value;
	var quantity = form.quantity.value;
	var pName = form.pName.value;
	if(pCode==null || pCode==''){
        alert("请选择商品！");return false;
	}
	if(pbPrice==null || pbPrice==''){
        document.editForm.pbPrice.focus();
        alert("请输入秒杀价格！");return false;
	}
	if(quantity==null || quantity==''){
        document.editForm.quantity.focus();
        alert("请输入秒杀库存数！");return false;
	}
	
	$.ajax({
		cache:false,
		type:"POST",
		url:"editProduct",
		data:_JqueryForm.serialize(),
		success:function(result){
			alert(result.message);
			$(".tab_title li.active a").html(pName);
		},
		error:function(result){
			alert("请求错误");
		}
	});
}

function submitAddForm(o){
	var _JqueryForm = $(o).parent().prev("[name='saveForm']");
	var form = _JqueryForm.get(0);
	var pCode = form.pCode.value;
	var pbPrice = form.pbPrice.value;
	var quantity = form.quantity.value;
	var pName = form.pName.value;
	if(pCode==null || pCode==''){
        alert("请选择商品！");return false;
	}
	if(pbPrice==null || pbPrice==''){
        document.saveForm[1].pbPrice.focus();
        alert("请输入秒杀价格！");return false;
	}
	if(quantity==null || quantity==''){
        document.saveForm[1].quantity.focus();
        alert("请输入秒杀库存数！");return false;
	}
	
	$.ajax({
		cache:false,
		type:"POST",
		url:"addMiaoshaProduct",
		data:_JqueryForm.serialize(),
		success:function(result){
			$(".tab_title li.active a").html(pName);
			alert(result.message);
		},
		error:function(result){
			alert("请求错误");
		}
	
	});
}

function deleteFrom(o){
	var _JqueryForm = $(o).parent().prev("form");
	console.log(_JqueryForm)
	if(_JqueryForm.children("[name='id']").val()){
		var id = _JqueryForm.children("[name='id']").val();
	}
	console.log(_JqueryForm.closest("#wrap").find(".tab_wrap li[id="+id+"]"));
	if(id){
		$.ajax({
			cache:false,
			type:"POST",
			url:"deleteMiaoshaProduct",
			data:{"id":id},
			success:function(result){
				alert(result.message);
				if(result["status"]=='ok'){
					_JqueryForm.children("[name='id']").val(result["id"]);	
					_JqueryForm.closest("#wrap").find(".tab_wrap li[id="+id+"]").remove();
					_JqueryForm.closest(".tab_main").remove();
					//_JqueryForm.remove();
				}
			},
			error:function(result){
				alert("请求错误");
			}
		
		});
	}else{
		_JqueryForm.closest(".tab_main").remove();
	}
}

</script>