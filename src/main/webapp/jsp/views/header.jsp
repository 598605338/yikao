<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="utf-8" />
<title></title>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link rel="stylesheet" href="<%=basePath %>dist/css/common.css" />
<link rel="stylesheet" href="<%=basePath %>dist/css/goods.css" />
<script src="<%=basePath %>dist/js/jquery-1.11.2.js"></script>
<script src="<%=basePath %>dist/js/common.js?timestamp="+Math.random()></script>
<script src="<%=basePath %>dist/js/goods.js"></script>
</head>
<script type="text/javascript">
    /**2017.2.9
     * 检测浏览器，如果是IE9。。。改变一些样式。
     */
    var browser=navigator.appName;
    var b_version=navigator.appVersion;
    var version=b_version.split(";");
    var trim_Version=version[1].replace(/[ ]/g,"");
    if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0") {
        $(".classify").css({"margin-left":"0px","width":"100%"});
        $(".td_left").css("width","11%")
    }
</script>