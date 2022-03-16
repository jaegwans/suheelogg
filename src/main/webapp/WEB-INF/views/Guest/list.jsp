<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%-- <link rel="stylesheet" type="text/css" href="${R}common.css"> --%>
<%-- <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${R}common.js"></script> --%>
<style>
form {
	width: 600px;
	margin: auto;
	box-shadow: 0 0 4px lightgray, 2px 2px 4px gray;
	overflow: auto;
}

div.title {
	font-size: 20pt;
	padding: 10px;
	background-color: #eee;
}

table {
	margin: 20px;
}

td {
	min-width: 100;
	padding: 5px;
}

td:nth-child(1) {
	text-align: right;
}

div.buttons {
	padding: 10px 20px 20px 20px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>목록</h1>
		<form:form method="post" modelAttribute="student">

			<table>

				<%-- 	<tr>
					<td>id</td>
					<td><form:input path="id" /></td>
				</tr> --%>
				<tr>
					<td>이름</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><form:input path="content" /></td>
				</tr>
			</table>
			<hr />
			<div>
				<button type="submit" class="btn">저장</button>

			</div>
		</form:form>



		<table class="table table-bordered table-condensed">
			<thead>
				<tr>
					<td>id
					</th>
					<th>name</th>
					<th>content</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ students }">
					<tr>
						<td>${ student.id }</td>
						<td>${ student.name }</td>
						<td>${ student.content }</td>

					</tr>


				</c:forEach>
			</tbody>
		</table>
		<my:pagination pageSize="${ pagination.sz }"
			recordCount="${ pagination.recordCount }" queryStringName="pg" />
	</div>

</body>
</html>