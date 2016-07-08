<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>成绩录入</title>

</head>
<body>
	<div class="container">
		<%@ include file="../WEB-INF/header.html"%>
		<div class="col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">成绩录入 教师:${grade.teaName}</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="../addGrade.do" method="post]">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<label class="col-sm-3 control-label"><c:if
										test="${grade.stuName==null}">
								未选中学生
							</c:if> <c:if test="${grade.stuName!=null}">
								${grade.stuName}
							</c:if></label>
							</div>
						</div>
							<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">课程</label>
							<div class="col-sm-10">
								<label class="col-sm-3 control-label"><c:if
										test="${grade.couName==null}">
								未选中课程
							</c:if> <c:if test="${grade.couName!=null}">
								${grade.couName}
							</c:if></label>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">成绩</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="grade"
									<%-- value="${grade.grade}" --%>>
							</div>
						</div>
						
						<input type="hidden" name="couId" value="${grade.couId}">
						<input type="hidden" name="teaId" value="${grade.teaId}">
						<input type="hidden" name="stuId" value="${grade.stuId}">
						<input type="hidden" name="claId" value="${grade.claId}">
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">录入</button>
							</div>
						</div>
					</form>

				</div>
			</div>

		</div>
	</div>

</body>
</html>