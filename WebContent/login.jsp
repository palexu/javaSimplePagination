<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登陆</title>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/styles.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function check(){
		var myForm=document.getElementById("form");
		var username=myForm[0].value;
		if(myForm[1].value==""){
			alert("用户名不能为空");
			return false;
		}else if(myForm[2].value==""){
			alert("密码不能为空");
			return false;
		}
		return true;
	}
</script>
<body>
	
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<ul class="nav nav-tabs ">
				  <li role="presentation" class="active" id="student"><a href="#" >学生</a></li>
				  <li role="presentation" id="teacher" class=""><a href="#" >教师</a></li>
				  <li role="presentation" id="admin" class=""><a href="#" >管理员</a></li>
				</ul>
				<div class="panel-body">
				
				<form id="form" action="LoginServlet.do" method="post">
				<fieldset>			
						<div class="form-group">
							<input id="username" class="form-control" placeholder="学号" name="username" type="username" autofocus="">
						</div>		
		
						<div class="form-group">
							<input class="form-control" placeholder="密码" name="password" type="password" value="">
						</div>		
						<input id="userType" type="hidden" name="userType" value="student">
						<input type="submit" value="登陆" class="btn btn-primary" onclick="return check()">
						<!-- <a href="register.html">注册</a> -->
					</div>
				</fieldset>
				</form>

			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	<script src="./js/jquery-1.7.2.min.js"></script>
	<script>
		$(function(){
			$("#teacher").on("click",function(){
				$("#student").removeClass("active");
				$("#admin").removeClass("active");
				$("#teacher").addClass("active");
				$('#userType').val("teacher");
				$('#username').attr("placeholder","教师号");
			})
			$("#student").on("click",function(){
				$("#admin").removeClass("active");
				$("#teacher").removeClass("active");
				$("#student").addClass("active");
				$('#userType').val("student");
				$('#username').attr("placeholder","学号");
			})
			$("#admin").on("click",function(){
				$("#teacher").removeClass("active");
				$("#student").removeClass("active");
				$("#admin").addClass("active");
				$('#userType').val("admin");
				$('#username').attr("placeholder","管理员账户名");
			})
		})
	</script>
</body>

</html>
