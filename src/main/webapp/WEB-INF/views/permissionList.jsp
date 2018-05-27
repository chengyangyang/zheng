<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>


<!-- 权限的样式 -->
<div class="row" style="margin-top: 5%">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<table id="permission_table" class="table table-striped">
			<p class="text-right">
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#myModal">新增</button>
				&nbsp;
				<button type="button" class="btn btn-danger" id="deletepermission">删除</button>
			</p>
			<thead align="center">
				<tr>
					<td><input type="checkbox" id="check_all"></td>
					<td>主键</td>
					<td>权限名称</td>
					<td>删除</td>
				</tr>
			</thead>
			<tbody align="center"></tbody>
		</table>
	</div>
	<div class="col-md-3"></div>
</div>

<!-- 新增权限的模态框 -->
<form action="/addpermission">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增权限</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">请输入权限名称</span>
						<input type="text" name="permissionname" class="form-control" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">确定</button>
				</div>
			</div>
		</div>
	</div>
</form>

<!-- 页面加载完成后发送查询全部请求 -->
<script type="text/javascript">

/* 查询所有人列表  和修改请求总和*/
	 $(function(){
		permissionlist();
		
	}); 
		
		/* 查询所有人列表 */
		function permissionlist(){
			$.ajax({
				url:"/permission/list",
				type:"GET",
				success:function(result){
					$("#permission_table tbody").empty();
					
					var permission = result.extend.permissionlist;
					$.each(permission,function(index,item){
						var checkbox =$("<input type='checkbox' class='check_item'>");
						var permissionId = $("<td></td>").append(item.pId);
						var permissionName = $("<td></td>").append(item.pName);						
						/* 添加一个删除按钮 */					
						var permissionbutton =  $("<button></button>").addClass("btn btn-warning deletepermission")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append(" ").append("删除");
						/* 将按钮放到表格中 */
						var permission = $("<td></td>").append(permissionbutton);		
						//添加按钮的自定义属性
						permissionbutton.attr("btnid",item.pId);
						
						$("<tr></tr>").append($("<td></td>").append(checkbox)).append(permissionId).append(permissionName).append(permission).appendTo("#permission_table");					
					});
				}	
			});
			}
		

		
		//点击发送删除请求
		$(document).on("click",".deletepermission",function(){
			var permissionName = $(this).parents("tr").find("td:eq(2)").text();
			var id = $(this).attr("btnid");
			if(confirm("确认删除"+permissionName+" 并删除权限相关角色信息吗？")){
				$.ajax({
					url:"/deletepermission"+id,
					type:"POST",
					success:function(result){
						alert(result.msg);
						permissionlist();
					}
				})				
			}			
		})
		
	/* 完成全选或者不选 */
	$("#check_all").click(function(){
			/* prop的修改和读取是dom原生的值 ，attr是自定义的*/
		$(".check_item").prop("checked",$(this).prop("checked"));
	});
	
	/* 修改check_all */
	$(document).on("click",".check_item", function(){			
		var flag =	$(".check_item:checked").length==$(".check_item").length;
		$("#check_all").prop("checked",flag);
	});	
	
	/* 全部删除 */
	$("#deletepermission").click(function(){	
		var permission ="";
		var permissionid="";
		$.each($(".check_item:checked"),function(){
			permission+=$(this).parents("tr").find("td:eq(2)").text()+",";		
			permissionid+=$(this).parents("tr").find("td:eq(1)").text()+"-";		
		})
		/* 去除多余的字符 */
		permission=permission.substring(0,permission.length-1);
		permissionid=permissionid.substring(0,permissionid.length-1);
		if(permission!=""){
		if(confirm("确认删除"+permission+" 并删除权限相关角色信息吗？")){
			$.ajax({
				url:"/deletepermission"+permissionid,
				type:"POST",
				success:function(result){
					alert(result.msg);
					permissionlist();
				}
			})
		}
		}
	})
	
</script>
</body>
</html>