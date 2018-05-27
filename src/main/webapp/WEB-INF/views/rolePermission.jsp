<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
<!-- 拥有的权限 -->
<form action="/withpermiss?rolename=${name }" method="get">

	<input type="hidden" name="permiss" value="${name }">
	<c:forEach items="${haspermission }" var="haspermission">
		<label class="checkbox-inline"> <input type="checkbox"
			name="permission" checked="checked" value="${haspermission }">
			${haspermission }
		</label>
	</c:forEach>
	<!-- 没有拥有的权限 -->
	<c:forEach items="${nothaspermission }" var="nothaspermission">
		<label class="checkbox-inline"> <input type="checkbox"
			name="permission" value="${nothaspermission }">
			${nothaspermission }
		</label>
	</c:forEach>

	<input class="btn btn-default" type="submit" value="保存">
</form>


</body>
</html>