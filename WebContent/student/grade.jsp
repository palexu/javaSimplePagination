<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>成绩列表</title>
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
				<td>课程名称</td>
				<td>课程成绩</td>
				<td>任课教师</td>
			</tr>
			<c:forEach var="g" items="${requestScope.list}">
				<tr>
					<td>${g.couName}</td>
					<td>${g.grade}</td>
					<td>${g.teaName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>