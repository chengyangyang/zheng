<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<jsp:include page="head.jsp"></jsp:include>
</head>

<body>

	<!-- 员工列表的样式 -->
<table id="user_table" class="table table-striped">
	<thead>
		<tr>
			<td>主键</td>
			<td>用户姓名</td>
			<td>邮箱</td>
			<td>权限</td>
		</tr>
	</thead>
	<tbody></tbody>
</table>

<!-- 分页标签 -->

<nav aria-label="Page navigation">
<ul class="pagination pagination-lg" id="pageination">
</ul>
</nav>


<!-- 页面加载完成后发送查询全部请求 -->
<script type="text/javascript">

/* 查询所有人列表  和修改请求总和*/
	 $(function(){
		userlist(1);
		
	}); 
		
		/* 查询所有人列表 */
		function userlist(pn){
			$.ajax({
				url:"/userAllSelect",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					$("#user_table tbody").empty();
					var user = result.extend.userlist.list;
					$.each(user,function(index,item){
						var userId = $("<td></td>").append(item.uId);
						var userName = $("<td></td>").append(item.uName);	
						var userMail = $("<td></td>").append(item.uMail);		
						/* 添加按钮 */	
						var rolesbutton =  $("<button></button>").addClass("btn btn-warning role")
						.append($("<span></span>").addClass("glyphicon glyphicon-user")).append("更改角色");
						/* 将按钮放到表格中 */
						var roelhref = $("<a></a>").append(rolesbutton);
						//添加按钮链接的属性
						roelhref.prop("href","/selectRole?uid="+item.uId);
						var userbutton = $("<td></td>").append(roelhref);								
						$("<tr></tr>").append(userId).append(userName).append(userMail).append(userbutton).appendTo("#user_table");					
					});
					
					//分页的显示
					//当前页码数
					var pageNum = result.extend.userlist.pageNum;
					//总页数
					var pages = result.extend.userlist.pages;
				
					$("#pageination").empty();
					//构建上一页
					var previous = 	$("<li></li>").append($("<a></a>").append($("<span></span>").append("&laquo;").attr("aria-hidden","true")).attr("aria-label","Previous")).appendTo("#pageination");					
				
					if(pageNum>1){
					previous.click(function(){
					userlist(pageNum-1);
				
					})
					}
					//构建首页
					var firstpage =	$("<li></li>").append($("<a></a>").append("首页")).appendTo("#pageination");
					firstpage.click(function(){
					userlist(1);
				
					})
					
					
					//构建链接标签
					if(pageNum>3){
						var pagepre3 =	$("<li></li>").append($("<a></a>").append(pageNum-3)).appendTo("#pageination");
						pagepre3.click(function(){
						userlist(pageNum-3);
				
					})
					
					}
					if(pageNum>2){
						var pagepre2 =	$("<li></li>").append($("<a></a>").append(pageNum-2)).appendTo("#pageination");
						pagepre2.click(function(){
						userlist(pageNum-2);
				
					})
					
					}
					if(pageNum>1){
						var pagepre1 = 	$("<li></li>").append($("<a></a>").append(pageNum-1)).appendTo("#pageination");
						pagepre1.click(function(){
						userlist(pageNum-1);
				
					})
					
					
					}
					
					$("<li class='active'></li>").append($("<a></a>").append(pageNum)).appendTo("#pageination");
					
					if(pageNum<pages){
						var pagenext1 =	$("<li></li>").append($("<a></a>").append(pageNum+1)).appendTo("#pageination");
						pagenext1.click(function(){
						userlist(pageNum+1);
				
						})
				
					}					
					if(pageNum+1<pages){
						var pagenext2 =	$("<li></li>").append($("<a></a>").append(pageNum+2)).appendTo("#pageination");
						pagenext2.click(function(){
							userlist(pageNum+2);
						
							})
					}
					if(pageNum+2<pages){
						var pagenext3 =	$("<li></li>").append($("<a></a>").append(pageNum+3)).appendTo("#pageination");
							pagenext3.click(function(){
							userlist(pageNum+3);
				
					})
					}	
					
					var lastpage =	$("<li></li>").append($("<a></a>").append("末页")).appendTo("#pageination");
					lastpage.click(function(){
					userlist(pages);
				
					})
				
					//构建下一页
					var nextpage =	$("<li></li>").append($("<a></a>").append($("<span></span>").append("&raquo;").attr("aria-hidden","true")).attr("aria-label","Next")).appendTo("#pageination");
				
					if(pageNum<pages){
					nextpage.click(function(){
					userlist(pageNum+1);
					})
					}
				}	
			});
			}
		
		
		
	
	
		
</script>

</html>