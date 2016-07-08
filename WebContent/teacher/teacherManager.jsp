<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="alert " role="alert">欢迎,${user.name}!</div>
		<div class="col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">成绩管理</h3>
				</div>
				<div class="panel-body">
				管理学生成绩
				</div>
				<ul class="list-group">
					<li class="list-group-item">
						<form class="form-inline" action="../getGradeOrderBy.do">
							<input type="hidden" name="id" value="${user.id}">
							<div class="form-group input-group">
								<span class="input-group-addon">班级</span> <select name="info"
									class="form-control">
									<c:forEach var="cou" items="${requestScope.list}">
										<option value="${cou.id}&${cou.claId}">${cou.claId}班${cou.name}</option>
									</c:forEach>

								</select>
							</div>
							<button type="submit" class="btn btn-primary">查看我的学生成绩(从高到低排列）</button>
						</form>
					</li>
					<li class="list-group-item"><a href="../showAvgGrade.do">对所售课程分别统计平均分</a></li>
					<li class="list-group-item">
						<form class="form-inline" action="../showAddGrade.do">
							<input type="hidden" name="id" value="${user.id}">
							<div class="form-group input-group">
								<span class="input-group-addon">班级</span> <select name="info"
									class="form-control">
									<c:forEach var="cou" items="${requestScope.list}">
										<option value="${cou.id}:${cou.claId}">${cou.claId}班${cou.name}</option>
									</c:forEach>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">录入考试成绩</button>
						</form>
					</li>
				</ul>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">课程管理</h3>
				</div>
				<div class="panel-body">
					<a href="../getTeacherCourse.do?id=${user.id}&openSchoolTerm=2015"
						class="btn btn-success">查看本学期的授课表</a>
				</div>
			</div>
		</div>




		<!-- <a>修改个人信息</a>
 -->

	</div>

</body>
</html>