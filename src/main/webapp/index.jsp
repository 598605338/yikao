<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>河北艺考志愿网--首页</title>
    <link rel="stylesheet" href="./dist/css/common.css"/>
    <link rel="stylesheet" href="./dist/css/style.css"/>
</head>

<body>
<header class="common_top linear">
    <aside class="top_aside left">
        <img class="common_logo" src="dist/images/linjialogo.png" alt=""/>
    </aside>
    <section class="top_section right">
        <header class="top_header">
            <div class="right flex" style="display:inline;width:90%;margin-top:15px;">
                <span class="bord_right" style="display:inline-block;margin-bottom:5px;">欢迎您&nbsp;&nbsp;<span
                        style="color: #fedb03;">${ sessionScope.user.name}</span></span><br/>
                <span class="bord_right"><a href="javascript:"><span style="margin-left: -29px;" class="san"><i
                        class="icon-btn icon-setting"></i>个人设置</span></a></span>
                <span style="margin: 0px 19px 0 12px;">|</span>
                <span class="bord_right" style="border:none;"><a class="logon" href="<%=basePath%>doLogout"><span
                        class="san"><i class="icon-btn icon-logon"></i>注销</span></a></span>
            </div>
        </header>
        <nav class="top_nav"> <!-- flex -->
            <!--<a href="javascript:void(0);" onclick="changeLeft(this,'channel');">导航</a>-->
            <shiro:hasPermission name="11">
                <a class="top_act" href="javascript:void(0);" onclick="changeLeft(this,'goods');">商品</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="21">
                <a href="javascript:void(0);" onclick="changeLeft(this,'activities');">活动</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="31">
                <a href="javascript:void(0);" onclick="changeLeft(this,'mallshops');">门店</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="41">
                <a href="javascript:void(0);" onclick="changeLeft(this,'coupons');">卡券</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="51">
                <a href="javascript:void(0);" onclick="changeLeft(this,'orders');">订单</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="6">
                <a href="javascript:void(0);" onclick="changeLeft(this,'operate');">运营</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="71">
                <a href="javascript:void(0);" onclick="changeLeft(this,'finance');">报表 </a>
            </shiro:hasPermission>
            <shiro:hasPermission name="8">
                <a href="javascript:void(0);" onclick="changeLeft(this,'leaguer');">会员</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="7">
                <a href="javascript:void(0);" onclick="changeLeft(this,'base');">基本</a>
            </shiro:hasPermission>
        </nav>
    </section>
    <div class="emp"></div>
</header>
<section class="common_cont height_auto">
    <!--<aside id="left_channel" class="cont_aside height_auto left">
        <ul class="one">
            <li class="">
               <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="javascript:;" >导航</a>
                    <p class="ac"><img src="dist/images/1.png"/></p>
               </div>
            </li>
            <li>
                <div class="cont_aside_item">
                       <a class="a ab" href="javascript:;" >待办事项</a>
                         <p class="ac"><img src="dist/images/1.png"/></p>
                </div>
            </li>
        </ul>
    </aside>-->
    <aside id="left_goods" class="cont_aside height_auto left left_channel">
        <ul class="one">
            <li class="cont_aside_header">
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/product/select" target="target"><i
                            style="width:18px;height:18px;background-size:204%;background-position:0 -18px;"
                            class="small icon icon-goods icon-2"></i>商品管理<p class="ac"><img src="dist/images/1.png"/>
                    </p></a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/productCatagory/selectLargeCatagory" target="target"><i
                            style="width:18px;height:18px;background-size:204%;background-position:0 -37px;"
                            class="small icon icon-goods icon-3"></i>商品分类<p class="ac"><img src="dist/images/1.png"/>
                    </p></a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">

                    <a class="a ab" href="<%=basePath%>/brand/select" target="target"><i
                            class="icon icon-goods icon-1"></i>商品品牌<p class="ac"><img src="dist/images/1.png"/></p></a>

                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/unit/select" target="target"><i
                            class="icon icon-goods icon-4"></i>商品单位<p class="ac"><img src="dist/images/1.png"/></p></a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/tags/select" target="target"><i
                            class="icon icon-goods icon-5"></i>商品标签<p class="ac"><img src="dist/images/1.png"/></p></a>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_activities" class="cont_aside height_auto left">
        <ul class="one">

            <li class="cont_aside_header">
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/activityMiaosha/select" target="target"><i
                            class="icon icon-activities icon-4"></i>秒杀管理<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            <li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/pintuan/getPtBaseList" target="target"><i
                            class="icon icon-activities icon-5"></i>团购管理<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/tailGoodsClear/select" target="target"><i
                            class="icon icon-activities icon-6"></i>尾货清仓<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/activityPrepare/select" target="target"><i
                            class="icon icon-activities icon-8"></i>预约购买<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/scoreProduct/select" target="target"><i
                            class="icon icon-activities icon-2"></i>积分商城<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="javascript:" target="target"><i class="icon icon-activities icon-1"></i>促销管理<p
                            class="ac myDir"><img src="dist/images/1.png"/></p></a>
                    <ul class="two" style="display:none">
                        <li class="list listt"><span class="span1">.</span><a
                                href="<%=basePath%>/promotion/selectActInfoAll?activity_type=1" target="target"
                                class="a orderr">满减</a></li>
                        <li class="list listt"><span class="span1">.</span><a
                                href="<%=basePath%>/promotion/selectActInfoAll?activity_type=2" target="target"
                                class="a discoun">商品折扣</a></li>
                        <li class="list listt ding"><span class="span1">.</span><a
                                href="<%=basePath%>/promotion/selectActInfoAll?activity_type=4" target="target"
                                class="a discoun">加钱换购</a></li>
                        <li class="list listt"><span class="span1">.</span><a
                                href="<%=basePath%>/promotion/selectActInfoAll?activity_type=3" target="target"
                                class="a halff">第二件半价</a></li>
                    </ul>
                </div>
            </li>
            <li class="cont_aside_header">
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/receiveCardCoupon/select" target="target"><i
                            class="icon icon-activities icon-3"></i>领券中心<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li class="cont_aside_header">
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/newProductRecommend/select" target="target"><i
                            class="icon icon-activities icon-7"></i>新品推荐<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li class="cont_aside_header">
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/hotsell/select" target="target"><i
                            class="icon icon-activities icon-7"></i>热销推荐<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_mallshops" class="cont_aside height_auto left">
        <ul class="one">
            <li>
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/shop/shopList" target="target"><i
                            class="icon icon-mallshops icon-2"></i>基本管理<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/shop/queryShopProducts" target="target"><i
                            class="icon icon-mallshops icon-1"></i>门店商品<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_coupons" class="cont_aside height_auto left">
        <ul class="one">
            <li>
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/cardCoupon/select" target="target"><i
                            class="icon icon-coupons icon-1"></i>卡券管理<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/cardCoupon/selectThird" target="target"><i
                            class="icon icon-coupons icon-2"></i>三方卡券<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_orders" class="cont_aside height_auto left">
        <ul class="one">
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/orderQuery/getOrderList" target="target"><i
                            class="icon icon-orders icon-1"></i>订单列表<p class="ac"><img src="dist/images/1.png"/></p></a>
                </div>
            </li>
            <!--<li>
				   <div class="cont_aside_item">
				         <a class="a ab" href="<%=basePath%>/orderQuery/getOrderList" target="target"><i class="icon icon-orders icon-5"></i>预约订单<p class="ac"><img src="dist/images/1.png"/></p></a>
				   </div>
				</li>-->
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/orderQuery/scorelist" target="target"><i
                            class="icon icon-orders icon-2"></i>积分订单<p class="ac"><img src="dist/images/1.png"/></p></a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/orderQuery/pinTuanlist" target="target"><i
                            class="icon icon-orders icon-3"></i>团购订单<p class="ac"><img src="dist/images/1.png"/></p></a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/orderQuery/refundOrderlist" target="target"><i
                            class="icon icon-orders icon-4"></i>退款订单<p class="ac myDir"><img src="dist/images/1.png"/>
                    </p></a>
                    <ul class="two" style="display:none">
                        <li class="list listt"><span class="span1">.</span><a
                                href="<%=basePath%>/jsp/views/order/refund_order_add.jsp" target="target"
                                class="a detaa">添加退款单</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_operate" class="cont_aside height_auto left">
        <ul class="one">
            <%--<li>
                <div class="cont_aside_item cont_aside_header">
                     <a class="a ab" href="<%=basePath%>/advManage/selectAdvInfoAll" target="target"><i class="icon icon-operate icon-2"></i>广告管理<p class="ac myDir"><img src="dist/images/1.png"/></p></a>
                     <ul class="two" style="display:none">
                        <li class="list listt"><span class="span1">.</span><a href="<%=basePath%>/advManage/selectAdvInfoAll" target="target" class="a">广告管理</a>
                        </li>
                        <li class="list listt "><span class="span1">.</span><a href="<%=basePath%>/advPage/selectAdvPageAll" target="target" class="a">制作页面</a>
                        </li>
                        <li class="list listt"><span class="span1">.</span><a href="<%=basePath%>/advManage/selectAyAdvInfoAll" target="target" class="a">活动管理</a>
                        </li>
                    </ul>
                </div>
            <li>
               <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/feedback/select" target="target" ><i class="icon icon-operate icon-1"></i>反馈管理<p class="ac myDir"><img src="dist/images/1.png"/></p></a>
               </div>
            </li>--%>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/secrole/select" target="target"><i
                            class="icon icon-operate icon-3"></i>权限管理<p class="ac myDir"><img src="dist/images/1.png"/>
                    </p></a>
                </div>
            </li>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/secuser/select" target="target"><i
                            class="icon icon-operate icon-4"></i>系统用户<p class="ac myDir"><img src="dist/images/1.png"/>
                    </p></a>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_finance" class="cont_aside height_auto left ">
        <ul class="one">
            <li>
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumAllSales.jsp" target="target"><i
                            class="icon icon-finance icon-10"></i>总销报表<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumSalesByPriceInterval.jsp" target="target"><i
                            class="icon icon-finance icon-3"></i>客单分布<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>

                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumMallsSales.jsp" target="target"><i
                            class="icon icon-finance icon-1"></i>店铺销售<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumSalesByTimeInterval.jsp" target="target"><i
                            class="icon icon-finance icon-9"></i>销售时段<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>

            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumHotProductsSales.jsp" target="target"><i
                            class="icon icon-finance icon-6"></i>热销商品<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumSalesCategories.jsp" target="target"><i
                            class="icon icon-finance icon-7"></i>商品类别<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumSendExposure.jsp" target="target"><i
                            class="icon icon-finance icon-8"></i>商城配送<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumInventorySales.jsp" target="target"><i
                            class="icon icon-finance icon-5"></i>清仓销售<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumLackProducts.jsp" target="target"><i
                            class="icon icon-finance icon-4"></i>门店缺货<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/jsp/views/report/sumMallsSalesByDate.jsp" target="target"><i
                            class="icon icon-finance icon-4"></i>店铺销售<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_leaguer" class="cont_aside height_auto left">
        <ul class="one">
            <li>
                <div class="cont_aside_item cont_aside_header">
                    <a class="a ab" href="<%=basePath%>/cust/queryCust" target="target"><i
                            class="icon icon-leaguer icon-3"></i>会员管理<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/cust/getAccountcashdepositRecordList" target="target"><i
                            class="icon icon-leaguer icon-1"></i>充值记录<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/cust/accountcashdepositConfig?id=1" target="target"><i
                            class="icon icon-leaguer icon-2"></i>充值设置<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
        </ul>
    </aside>
    <aside id="left_base" class="cont_aside height_auto left">
        <ul class="one">
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/studentScore/select?pageSize=20" target="target"><i
                            class="icon icon-leaguer icon-1"></i>考生成绩查询<p class="ac"><img src="dist/images/1.png"/>
                    </p></a>
                </div>
            </li>
            <shiro:hasPermission name="9">
            <li>
                <div class="cont_aside_item">
                    <a class="a ab" href="<%=basePath%>/admissionInfo/select?pageSize=100" target="target"><i
                            class="icon icon-leaguer icon-2"></i>成绩管理<p class="ac"><img src="dist/images/1.png"/></p>
                    </a>
                </div>
            </li>
                <li>
                    <div class="cont_aside_item cont_aside_header">
                        <a class="a ab" href="<%=basePath%>/specialty/select" target="target"><i
                                class="icon icon-leaguer icon-3"></i>科目管理<p class="ac"><img src="dist/images/1.png"/>
                        </p></a>
                    </div>
                </li>
                <li>
                    <div class="cont_aside_item">
                        <a class="a ab" href="<%=basePath%>/college/select" target="target"><i
                                class="icon icon-leaguer icon-1"></i>院校管理<p class="ac"><img src="dist/images/1.png"/>
                        </p></a>
                    </div>
                </li>
                <li>
                    <div class="cont_aside_item">
                        <a class="a ab" href="<%=basePath%>/collegeType/select" target="target"><i
                                class="icon icon-leaguer icon-1"></i>院校类型管理<p class="ac"><img src="dist/images/1.png"/>
                        </p></a>
                    </div>
                </li>
                <li>
                    <div class="cont_aside_item">
                        <a class="a ab" href="<%=basePath%>/admissionBatch/select" target="target"><i
                                class="icon icon-leaguer icon-1"></i>批次管理<p class="ac"><img src="dist/images/1.png"/>
                        </p></a>
                    </div>
                </li>
            </shiro:hasPermission>

            <%--<li>
                <div class="cont_aside_item">
                      <a class="a ab" href="<%=basePath%>/admissionInfo/select" target="target"><i class="icon icon-leaguer icon-1"></i>录取规则管理<p class="ac"><img src="dist/images/1.png"/></p></a>
                </div>
            </li>--%>
        </ul>
    </aside>
    <iframe class="cont_section right" id="target" name="target" frameborder="0" scrolling="no"></iframe>
    <script>

    </script>
    <div class="emp"></div>
    <footer class="common_bot">
        <p class="height ft_sm" style="margin-top:0;">冀ICP备17008009号&nbsp;www.hbart.cc 保留所有权利。</p>
    </footer>
</section>

<div class="back_bg" style="display:none;">
    <%-- <iframe src="<%=basePath%>secuser/toUpdatePwd?login=${ sessionScope.user.login}">
    </iframe>
    <jsp:include page="jsp/views/secuser/secuser_update_password.jsp" /> --%>
</div>
<div class="zezhaoc"
     style="display:none;position: absolute;top: 0;left: 0;right: 0;bottom: 0;background: rgba(0,0,0,0.5);"></div>
</body>
<script src="./dist/js/jquery-1.11.2.js"></script>
<script src="./dist/js/common.js"></script>
</html>
<script>
    /*2017。2.9
     作用：通过iframe的高度，来设置.cont_aside的高度，为了实现无滚动条。
     1、通过ID，获取到iframe框。
     2、如果iframe框里面有id='wrpa'，则获取wrap的高度，设置外面.cont_aside的高度。
     */
    var iframe = $("#target").get(0);
    if (iframe.attachEvent) {
        iframe.attachEvent("onload", function () {
            if (window.frames["target"].document.getElementById("wrap")) {
                window.frames["target"].document.getElementById("wrap").style.overflow = "hidden";
                var tmpHeight = window.frames["target"].document.getElementById("wrap").offsetHeight + 70 < 864 ? 794 : window.frames["target"].document.getElementById("wrap").offsetHeight;
                $("#target").css("height", tmpHeight);
                $(".cont_aside").css("height", tmpHeight + 70);
            }
        });
    } else {
        iframe.onload = function () {
            if (window.frames["target"].document.getElementById("wrap")) {
                window.frames["target"].document.getElementById("wrap").style.overflow = "hidden";
                var tmpHeight = window.frames["target"].document.getElementById("wrap").offsetHeight + 70 < 864 ? 794 : window.frames["target"].document.getElementById("wrap").offsetHeight;
                $("#target").css("height", tmpHeight);
                $(".cont_aside").css("height", tmpHeight + 70);
            }
        };
    }
    /*2017。2.9
     作用：点击个人设置，加载出个人设置页面。
     1、个人设置，load进来一个页面。
     2、显示页面、显示遮罩层。
     */
    $(".top_header .san").click(function () {
        $(".back_bg").load('<%=basePath%>secuser/toUpdatePwd?login=${ sessionScope.user.login}');
        $(".pass_a").css("display", "block");
        $(".back_bg").css("display", "block");
        /* $("body").addClass("opty"); */
        $(".zezhaoc").show();
    });

    /*  2017。2.9
     1、初始化隐藏侧边栏
     2、只有第一个有.left_channel类,显示第一个。
     3、.cont_aside_item:first，第一个的cont_aside_item添加active类.
     已弃用。在后面用到了navFirst()函数。
     */
    //$(".cont_aside").hide();
    //$(".left_channel").show();
    //$(".cont_aside_item:first").addClass("active");
    //$("iframe").attr({"src":$('.cont_aside_item:first').find(".a").attr("href")});


    /**2017。2.9
     * top导航的点击事件，传过来this和name，
     * this用来指定top_act类。
     * name用来拼接侧边栏
     */
    function changeLeft(o, name) {
        $("nav a").attr("class", "");
        $(o).attr("class", "top_act");
        $(".cont_aside").hide();
        $("#left_" + name).show();
    }

    /**2017。2.9
     * 左侧边栏的点击事件。
     */
    $(".ab").each(function (i) {
        $(".ab").eq(i).on("click", function () {
            $(".cont_aside_item:first").removeClass("active");
            $(".ab").removeClass("word");
            $(".list span").removeClass("word");
            $(".list a").removeClass("word");
            $(".cont_aside_item").removeClass("active");
            $(this).addClass("word");
            $(this).parent(".cont_aside_item").addClass("active");
            if ($(this).parent().children().size() > 2) {
                if ($(this).parent().find(".myDir img").hasClass("turnDown") == true) {
                    $(this).parent().find(".myDir img").removeClass("turnDown");
                } else {
                    $(this).parent().find(".myDir img").addClass("turnDown");
                }
            }
            //点击其它侧边栏导航菜单应该收起二级菜单。
            if ($(this).parents("ul").find("ul").css('display') != 'none') {
                $(this).parents("ul").find(".at").removeClass("at");
                //控制自身菜单下子菜单隐藏
                $(this).parents("ul").find("ul").slideUp(50);
                $(this).parents("ul").find("ul").children('li').children('ul').slideUp(50);
            }
        });
    });

    /**2017。2.9
     * 头部导航的点击事件，并且设置iframe的src地址
     */
    $(".top_nav a").each(function (i) {
        $(".top_nav a").eq(i).on("click", function () {
            //$(".cont_aside_item:first").css("background","#ffffff");
            $(".cont_aside_item:first").removeClass("active");
            $(".cont_aside_item").removeClass("active");
            $(".ab").removeClass("word");
            $(".common_cont .cont_aside").each(function (j) {
                if ($(".common_cont .cont_aside").eq(j).css("display") == "block") {
                    $(this).find(".cont_aside_item").eq(0).addClass("active");
                    $("iframe").attr({"src": $(this).find(".cont_aside_item").eq(0).find(".a").attr("href")});
                }
            });
        });
    });

    /**2017。2.9
     *二级菜单选中样式。
     *判断标志旋转条件
     */
    $(".list a").each(function (i) {
        $(".list a").eq(i).on("click", function () {
            $(".ab").removeClass("word");
            $(".list a").removeClass("word");
            $(".list span").removeClass("word");
            $(".list a").eq(i).addClass("word");
            $(".list span").eq(i).addClass("word");
        });
    });

    /**2017。2.9
     * 默认选中第一个。
     * 在jQready事件中执行
     */
    function navFirst() {
        //默认选中第一个
        $(".top_nav").find("a").eq(0).trigger("click");
        $(".cont_aside:visible").find("li").eq(0).find("a").trigger("click");
        var tmpSrc = $(".cont_aside:visible").find("li").eq(0).find("a").get(0).href;
        $("#target").attr("src", tmpSrc);
    }


    $(document).ready(function () {
        /**2017。2.9
         * 1、如果有二级菜单，控制二级菜单的显示和影藏
         * 2、用的是slideDown和slideUp
         */
        $('.a').click(function () {
            if ($(this).siblings('ul').css('display') == 'none') {
                $(this).children(".ac").addClass("at");
                $(this).siblings('ul').slideDown(50).children('li');
                if ($(this).parents('li').siblings('li').children('ul').css('display') == 'block') {
                    $(this).parents('li').siblings('li').children('ul').slideUp(50);
                }
            } else {
                $(this).children(".ac").removeClass("at");
                //控制自身菜单下子菜单隐藏
                $(this).siblings('ul').slideUp(50);
                $(this).siblings('ul').children('li').children('ul').slideUp(50);
            }
        });

        //默认选中第一个
        navFirst();
    });


</script>


