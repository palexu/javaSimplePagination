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
		<div class="alert " role="alert">欢迎,${user.name}!</div>
		<div class="col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">查询模块</h3>
				</div>
				<div class="panel-body">查询功能</div>
				<ul class="list-group">
					<li class="list-group-item">
						<form class="form-inline" action="../queryStudentGrade.do">
							<input type="hidden" name="id" value="${user.id}">
							<div class="form-group input-group">
								<span class="input-group-addon">学年</span> <select name="openSchoolTerm"
									class="form-control">
									<option value="2015">2015</option>
									<option value="2016">2016</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">查询课程成绩</button>
						</form>
					</li>
					<li class="list-group-item"><a href="../coursesLearned">查询已修学分</a></li>
					<li class="list-group-item">
						<form class="form-inline" action="../queryCourse.do">
							<input type="hidden" name="id" value="${user.id}">
							<div class="form-group input-group">
								<span class="input-group-addon">学年</span> <select name="openSchoolTerm"
									class="form-control">
									<option value="2015">2015</option>
									<option value="2016">2016</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">查询班级课表</button>
						</form>
					</li>
				</ul>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">个人管理</h3>
				</div>
				<div class="panel-body">
					<a href="updateStudent.jsp">修改个人信息</a>
				</div>
			</div>
		</div>


	</div>

</body>
</html>