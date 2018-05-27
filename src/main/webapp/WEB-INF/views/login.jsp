<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>

<div class="row" style="background-color: rgb(64,0,128);">
  <div class="col-md-4" style="padding-top: 20px ; ">&nbsp;&nbsp;<img  src="${ path}/img/logo.png"><h5 style="color: white;">&nbsp;&nbsp;国网陕西省电力科学研究院</h5></div>
  <div class="col-md-4" style="padding-top: 20px ; padding-bottom: 20px ;color: white;font-size: 35px">配网雷电信息系统</div>
  <div class="col-md-4" style="padding-top: 20px ; padding-bottom: 5px ; text-align: right; "><a  href="#" class="btn  btn-default" role="button" style="margin-top: 15px">用户:${sessionScope.user.uName}</a>
				&nbsp;&nbsp;&nbsp;
				<a href="/logOut" class="btn  btn-default" role="button" style="margin-top: 15px">退出登录</a>
				&nbsp;&nbsp;&nbsp;
				</div>
</div>


		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column">
						<div class="panel-group" id="panel-254389">
							<div class="panel panel-default">
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<!-- 第一个容器 -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a href="#collapse1" data-toggle="collapse"
													data-parent="#accordion">系统管理</a>
											</h4>
										</div>
										<div id="collapse1" class="panel-collapse collapse">
											<!-- 折叠菜单的部分collapse:开始时先隐藏 -->
											<shiro:hasPermission name="查询用户">
												<div class="panel-body">
													<a href="/userAll" target="a">查询所有用户</a>
												</div>
											</shiro:hasPermission>
											<div class="panel-body">
												<a href="#">修改个人信息</a>
											</div>
											<shiro:hasPermission name="权限管理">
												<div class="panel-body">
													<a href="/permission" target="a">权限管理</a>
												</div>
											</shiro:hasPermission>
											<shiro:hasPermission name="角色管理">
												<div class="panel-body">
													<a href="/RoleSelectAll" target="a">角色管理</a>
												</div>
											</shiro:hasPermission>
										</div>
									</div>

									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a href="#collapse2" data-toggle="collapse"
													data-parent="#accordion">雷电信息</a>
											</h4>
										</div>
										<div id="collapse2" class="panel-collapse collapse">
											<div class="panel-body">
												<a href="#">雷电落雷信息展现</a>
											</div>
											<div class="panel-body">
												<a href="#">雷电落雷信息检索</a>
											</div>
											<div class="panel-body">
												<a href="#">雷击故障快速定位</a>
											</div>
											<div class="panel-body">
												<a href="#">雷电参数统计分析</a>
											</div>
											<div class="panel-body">
												<a href="#">雷电信息图形展现</a>
											</div>
										</div>
									</div>

									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a href="#collapse3" data-toggle="collapse"
													data-parent="#accordion">配网管理</a>
											</h4>
										</div>
										<div id="collapse3" class="panel-collapse collapse">
											<div class="panel-body">
												<a href="#">配网台账信息新增</a>
											</div>
											<div class="panel-body">
												<a href="#">配网台账信息检索</a>
											</div>
											<div class="panel-body">
												<a href="#">配网台账信息删除</a>
											</div>
											<div class="panel-body">
												<a href="#">配网台账信息修改</a>
											</div>
											<div class="panel-body">
												<a href="#">配网拓扑网络结构图</a>
											</div>
										</div>
									</div>

									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a href="#collapse5" data-toggle="collapse"
													data-parent="#accordion">常用工具</a>
											</h4>
										</div>
										<div id="collapse5" class="panel-collapse collapse">
											<div class="panel-body">
												<a href="#">复制</a>
											</div>
											<div class="panel-body">
												<a href="#">剪切</a>
											</div>
											<div class="panel-body">
												<a href="#">粘贴</a>
											</div>
										</div>
									</div>

									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a href="#collapse4" data-toggle="collapse"
													data-parent="#accordion">接口软件</a>
											</h4>
										</div>
										<div id="collapse4" class="panel-collapse collapse">
											<div class="panel-body">
												<a href="#">配网线路接口软件客户端</a>
											</div>
											<div class="panel-body">
												<a href="#">配网线路接口软件服务端</a>
											</div>
											<div class="panel-body">
												<a href="#">客户端，服务端联调开发</a>
											</div>
											<div class="panel-body">
												<a href="#">雷电数据接口软件客户端</a>
											</div>
											<div class="panel-body">
												<a href="#">雷电数据接口软件服务端</a>
											</div>
											<div class="panel-body">
												<a href="#">客户端，服务端联调开发</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<iframe name="a" width="1000" height="600"> </iframe>

				
			
</body>

</html>