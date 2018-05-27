<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${ path}/static/bootstrapvalidator/css/bootstrapValidator.min.css" rel="stylesheet">  
<script src="${ path}/static/bootstrapvalidator/js/bootstrapValidator.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="head.jsp"></jsp:include>
</head>



<body>

<div class="row" style="margin-top: 5%">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<p class="text-right">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#myModal">添加</button>
			<!-- <button type="button" class="btn btn-danger">删除</button> -->
		</p>
		<!-- 新增角色模态框 -->
		 <form action="/addRole" > 	
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">新增角色</h4>
						</div>
						<div class="modal-body">
							<div class="input-group">
								<span class="input-group-addon"  id="basic-addon1">请输入角色名称</span>
								<input   type="text" name="rolename"   class="form-control" />
							</div>
						</div>
						<div class="modal-footer">
							<button id="sub" type="submit" class="btn btn-primary">确定</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<table class="table table-hover" border="1px">
			<thead align="center">
				<tr>
					<td>主键</td>
					<td>名称</td>
					<td>删除/权限管理</td>
				</tr>
			</thead>
			<c:forEach items="${selectAllRole}" var="role">
				<tbody align="center">
					<tr>
						<td>${role.rId }</td>
						<td>${role.rName }</td>
						<td><a href="/deleteRole?id=${role.rId }"><button
									type="button" class="btn btn-danger" id="deleterole">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除
								</button></a> <a href="/selectpermission?name=${role.rName }"><button
									type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;权限
								</button></a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="col-md-4"></div>
</div>
</body>

</html>