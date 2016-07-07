<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<title>addStudent</title>
</head>
<body>
	<div class="container">
		<%@ include file="../WEB-INF/header.html"%>
		<a class="btn " href="studentManager.jsp"><span aria-hidden="true">&larr;</span>返回</a>
		<form action="../addTeacher.do" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">教师号</label>
				<div class="col-sm-10">
					<input type="text" name="id">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-10">
					<input type="text" name="name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">性别</label>
				<div class="col-sm-10">
					<select name="gender">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">年龄</label>
				<div class="col-sm-10">
					<input type="text" name="age">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">职位</label>
				<div class="col-sm-10">
					<input type="text" name="position">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">电话</label>
				<div class="col-sm-10">
					<input type="text" name="tel">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">确认</button>
				</div>
			</div>
		</form>


	</div>

</body>
</html>