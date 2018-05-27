<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户角色</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>

	<form action="/alterRole">
		<input type="hidden" name="id" value="${uid }">
		<c:forEach items="${selectAllRole }" var="selectAllRole">
			<c:choose>
				<c:when test="${selectRoleByUserId=='[]' }">
					<input type="checkbox" name="rid" value="${selectAllRole.rId }">${selectAllRole.rName } 
				</c:when>
				<c:otherwise>
					<c:set var="exit" value="0" />
					<c:forEach items="${selectRoleByUserId }" var="selectRoleByUserId"
						varStatus="stat">
						<c:if test="${selectAllRole.rId==selectRoleByUserId.rId }">
							<label class="checkbox-inline"> <input type="checkbox"
								checked="checked" name="rid" value="${selectAllRole.rId }">${selectAllRole.rName }
							</label>
							<c:set var="exit" value="1" />
						</c:if>
						<c:if test="${exit!=1 }">
							<c:if test="${stat.last}">
								<label class="checkbox-inline"> <input type="checkbox"
									name="rid" value="${selectAllRole.rId }">${selectAllRole.rName }
								</label>
							</c:if>
						</c:if>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<input class="btn btn-default" type="submit" value="保存">
	</form>
</body>
</html>