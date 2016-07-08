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
		<h5>欢迎,${user.name}</h5>
		<ul>
			<form action="../queryStudentGrade.do">
				<input type="hidden" name="id" value="${user.id}">

				<select name="openSchoolTerm">
					<option value="2015">2015</option>
				</select>
				<button type="submit" class="btn btn-primary">查询课程成绩</button>
			</form>
			<form action="../queryCourse.do">
				<input type="hidden" name="id" value="${user.id}">

				<select name="openSchoolTerm">
					<option value="2015">2015</option>
				</select>
				<button type="submit" class="btn btn-primary">查询班级课表</button>
			</form>
			<a href="addStudent.jsp" class="btn btn-success">查询已修学分</a>	
			<a>修改个人信息</a>
		</ul>

	</div>

</body>
</html>