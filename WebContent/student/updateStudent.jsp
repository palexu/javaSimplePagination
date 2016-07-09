<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>addStudent</title>
</head>
<body>
	<div class="container">
		<%@ include file="../WEB-INF/header.html"%>
		<form action="../updateStudent.do" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">学号</label>
				<div class="col-sm-10">
					<input type="text" value="${user.id}" disabled>
				</div>
			</div>
			<input type="hidden" name="id" value="${user.id}" />
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-10">
					<input type="text" name="name" value="${user.name}">
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
					<input type="text" name="age" value="${user.age}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">生源地</label>
				<div class="col-sm-10">
					<input type="text" name="origin" value="${user.origin}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">地区</label>
				<div class="col-sm-10">
					<input type="text" name="area" value="${user.area}">
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