<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>TeacherManager</title>
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
			<form action="../getGradeOrderBy.do">
				<input type="hidden" name="id" value="${user.id}">

				<select name="couId">
					<option value="0001">0001</option>
				</select>
				<button type="submit" class="btn btn-primary">查看我的学生成绩（排列）</button>
			</form>
			
			<a href="../showAvgGrade.do" class="btn btn-success">查看所授课程平均分</a>
			<a href="../getTeacherCourse.do?id=${user.id}&openSchoolTerm=2015" class="btn btn-success">查看本学期的授课表</a>		
			<a href="../showAddGrade.do?id=01&couId=0001" class="btn btn-success">录入考试成绩</a>	
			<a>修改个人信息</a>
		</ul>

	</div>

</body>
</html>