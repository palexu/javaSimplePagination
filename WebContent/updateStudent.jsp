<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<title>addStudent</title>
</head>
<body>
	<div class="container">
		<%@ include file="./WEB-INF/header.html"%>
		<form action="updateStudent.do" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">学号</label>
				<div class="col-sm-10">
					<input type="text"  value="${student.stu_id}" disabled>
				</div>
			</div>
			<input type="hidden" name="stu_id" value="${student.stu_id}"/>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-10">
					<input type="text" name="name" value="${student.name}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">性别</label>
				<div class="col-sm-10">
					<input type="text" name="sex" value="${student.sex}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">专业</label>
				<div class="col-sm-10">
					<input type="text" name="speciality" value="${student.speciality}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">入学年份</label>
				<div class="col-sm-10">
					<input type="text" name="schoolYear" value="${student.schoolYear}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">电话</label>
				<div class="col-sm-10">
					<input type="text" name="tel" value="${student.tel}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">邮件</label>
				<div class="col-sm-10">
					<input type="text" name="email" value="${student.email}">
				</div>
			</div>
			<input type="hidden" name="q" value="m">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">确认</button>
				</div>
			</div>
		</form>


	</div>

</body>
</html>