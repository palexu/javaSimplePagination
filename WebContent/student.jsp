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
		<%@ include file="./WEB-INF/header.html"%>
		<table class="table table-hover table-bordered">
			<tr>
				<a class="btn " href="studentManager.jsp"><span aria-hidden="true">&larr;</span>返回</a>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>专业</td>
				<td>入学年份</td>
				<td>电话</td>
				<td>邮箱</td>
				<td>操作</td>
				<td>删除</td>
			</tr>
			<c:forEach var="student" items="${requestScope.stuList}">
				<tr>
					<%--用EL访问作用域变量的成员--%>
					<td>${student.stu_id}</td>
					<td>${student.name}</td>
					<td>${student.sex}</td>
					<td>${student.speciality}</td>
					<td>${student.schoolYear}</td>
					<td>${student.tel}</td>
					<td>${student.email}</td>
					<td><a href="updateStudent.do?q=toM&stu_id=${student.stu_id}">修改</a></td>
					<td><a href="deleteStudent.do?stu_id=${student.stu_id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="./WEB-INF/pagination.jsp"%>
	</div>

</body>
</html>