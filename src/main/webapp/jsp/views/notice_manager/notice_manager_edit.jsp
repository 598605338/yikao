<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
</head>
<body>
<div id="wrap">
brand_add.jsp<br>
<c:out value="${message }" />
<form id="form" name="form" action="${basePath}/brand/edit" method="post" >
<input type="hidden" name="id" value="${brand.id }"/>
	品牌名称：<input type="text" name="name" value="${brand.name }" /><br>
	品牌描述：<input type="text" name="description" value="${brand.description }" /><br>
	
	<input type="submit" value="确认" />
</form>
</div>
</body>
</html>