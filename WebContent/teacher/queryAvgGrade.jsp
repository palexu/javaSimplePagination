<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>我的班级平均成绩</title>
<style>
</style>
<link href="./css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%@ include file="../WEB-INF/header.html"%>
		<table class="table table-hover table-bordered">
			<tr>
				<a class="btn " href="teacher/teacherManager.jsp"><span aria-hidden="true">&larr;</span>返回</a>
				<td>班级</td>
				<td>课程</td>
				<td>平均成绩</td>
			</tr>
			<c:forEach var="ob" items="${requestScope.all}">
				<tr>
					<%--用EL访问作用域变量的成员--%>
					<td>${ob.claId}</td>
					<td>${ob.couName}</td>
					<td>${ob.avgGrade}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>