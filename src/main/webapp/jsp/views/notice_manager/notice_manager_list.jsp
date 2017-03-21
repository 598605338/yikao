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
<script>
</script>
</head>
<body>
<div id="wrap">
unit_list.jsp <br>
<c:out value="${message }" />
<c:forEach var="item" items="${brandList }" varStatus="status">
	<c:out value="${item.name }" />
	<c:out value="${item.description }" />
	<a href="javascript:void()" onclick="javascript:location.href='${basePath }/brand/toEdit?id=<c:out value="${item.id }" />'">编辑</a><br>
	<a href="javascript:void()" onclick="javascript:location.href='${basePath }/brand/deleteBrand?brandIds=<c:out value="${item.id }" />'">删除</a><br>
</c:forEach>
<form action="${basePath }/brand/add" method="POST">
<input type="submit" value="新增"/>
</form>
</div>
</body>
</html>