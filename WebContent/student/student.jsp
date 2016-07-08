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
				<a class="btn " href="student/studentManager.jsp"><span aria-hidden="true">&larr;</span>返回</a>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>生源地</td>
				<td>地区</td>
				<td>学分</td>
				<td>操作</td>
				<td>删除</td>
			</tr>
			<c:forEach var="student" items="${requestScope.stuList}">
				<tr>
					<%--用EL访问作用域变量的成员--%>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.gender}</td>
					<td>${student.age}</td>
					<td>${student.origin}</td>
					<td>${student.area}</td>
					<td>${student.credit}</td>
					<td><a href="updateStudent.do?q=toM&id=${student.id}">修改</a></td>
					<td><a href="deleteStudent.do?stu_id=${student.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>