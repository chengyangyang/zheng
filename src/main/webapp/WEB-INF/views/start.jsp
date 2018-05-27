<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="head.jsp"></jsp:include>

<link href="${ path}/static/bootstrapvalidator/css/bootstrapValidator.min.css" rel="stylesheet">  
<script src="${ path}/static/bootstrapvalidator/js/bootstrapValidator.min.js"></script>

<script type="text/javascript">
$(function(){  
    $('#casLoginForm').bootstrapValidator({  
        feedbackIcons: {  
            valid: 'glyphicon glyphicon-ok',  
            invalid: 'glyphicon glyphicon-remove',  
            validating: 'glyphicon glyphicon-refresh'  
        },  
        fields: {  
            username: {  
                    validators: {  
                        notEmpty: {  
                            message: '用户名称不能为空！'  
                        },
                        stringLength: {     //输入　长度限制　　校验
                            min: 1,
                            max: 5,
                            message: '长度不能超过5位'
                        },
                    }  
            },  
           	password:{  
                 validators: {  
                     notEmpty: {  
                         message: '用户密码不能为空！'  
                     }  
                  }  
            }  
        }  
    })  
})  




/* function login(){  
    var bootstrapValidator = $('#casLoginForm').data('bootstrapValidator');  
    bootstrapValidator.validate();  
    if(bootstrapValidator.isValid()){//如果校验成功后执行的操作  
        loginCheck();  
    }  
}   */

</script>

</head>
<body background="${ path}/img/WMMA32Q040SX.jpg" style="width: 100% ;height: 100%">

<form action="/login" method="post" class="form-horizontal" id="casLoginForm"   >
<div class="container-fluid">
    <center>
    	<h2 class="text-info">配网防雷项目登录页面</h2>
        	<hr /><br /><br />
            <div style="height:80px; width:300px">	
               
               <div class="form-group">                
                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" name="username" class="form-control" placeholder="用户名">
                </div><br />          
   			  </div>      
               
               <div class="form-group">        
                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" name="password" class="form-control" placeholder="密码">
                </div><br />      
    </div>  
               
            
                <div>  
               		 <input type="text" style="width: 185px; height: 40px" name="kaptcha"  placeholder="请输入验证码">
        			<img alt="验证码" onclick = "this.src='/defaultKaptcha?d='+new Date()*1" src="/defaultKaptcha" />  
    			</div> 
                <br/>
                 
                 <div class="form-group">    
                <button  class="btn btn-lg btn-primary btn-block" type="submit">登录</button><br /> 
           		<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
          </div> 
          
            </div>
    </center>
</div>   
</form> 
</body>

</html>