<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>学生列表</title>
<style>
</style>
<link href="./css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%@ include file="../WEB-INF/header.html"%>
		<table class="table table-hover table-bordered">
			<tr>
				<a class="btn " href="teacher/teacherManager"><span aria-hidden="true">&larr;</span>返回</a>
				<td>学号</td>
				<td>姓名</td>
				<td>课程</td>
				<td>成绩</td>
				<td>修改成绩</td>
			</tr>
			<c:forEach var="student" items="${requestScope.all}">
				<tr>
					<%--用EL访问作用域变量的成员--%>
					<td>${student.stuId}</td>
					<td>${student.stuName}</td>
					<td>${student.couName}</td>
					<td>${student.grade}</td>
					<td><a href="gradeTransfer.do?stuId=${student.stuId}&teaId=${student.teaId}&info=${student.couId}:${student.claId}">录入/修改成绩</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>