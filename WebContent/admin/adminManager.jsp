<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>StudentManager</title>
<style>
#search {
	padding: 9px;
	height: 40px;
	width: 450px;
}

ul {
	margin-top: 20px;
}

a {
	margin-right: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../WEB-INF/header.html"%>
		<!-- <form action="findStudent.do" method="post" class="center-block">
			<input id="search" type="text" name="search" placeholder="关键词">
			<input type="submit" class="btn btn-info" value="搜索">
		</form> -->
		<div class="alert " role="alert">欢迎,${user.username}!</div>
		<div class="col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">管理模块</h3>
				</div>
				<div class="panel-body">提供管理功能</div>
				<ul class="list-group">
					<li class="list-group-item">
						<a href="addCourse.jsp">添加课程</a>
					</li>
					<li class="list-group-item">
						<a href="../findStudent.do">查看学生</a>
					</li>
					<li class="list-group-item">
						<a href="addStudent.jsp">添加学生</a>
					</li>
					<li class="list-group-item">
						<a href="addTeacher.jsp">添加教师</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>