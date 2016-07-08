<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>课程列表</title>
<style>
</style>
<link href="./css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%@ include file="../WEB-INF/header.html"%>
		<table class="table table-hover table-bordered">
			<tr>
				<a class="btn " href="studentManager.jsp"><span aria-hidden="true">&larr;</span>返回</a>
				<td>课程号</td>
				<td>课程名</td>
				<td>授课教师</td>
				<td>学分</td>
				<td>考查形式</td>
				<td>学时</td>
			</tr>
			<c:forEach var="cou" items="${requestScope.list}">
				<tr>
					<%--用EL访问作用域变量的成员--%>
					<td>${cou.id}</td>
					<td>${cou.name}</td>
					<td>${cou.teaName}</td>
					<td>${cou.credit}</td>
					<td>${cou.checkType}</td>
					<td>${cou.period}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>