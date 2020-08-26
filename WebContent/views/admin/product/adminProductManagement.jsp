<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Item - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resource/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resource/css/shop-item.css"
	rel="stylesheet">

<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		table, td{
			border: 1px solid black;
		}
		table{
			width: 60%;
			height: 100px;
			margin: auto;
			text-align: center;
		}
	</style>
</head>
<body>

	<!-- Navigation -->
	<%@include file="/views/common/header_example.jsp"%>

	<h1>상품관리 페이지</h1>

	<table border="1">
		<tr>
			<th><input type="checkbox"></th>
			<th>상품번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>상품설명</th>
			<th>가격</th>
			<th>등록일자</th>
			<th>누적 판매량</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="p" items="${products }">
		<tr>
			<td><input type="checkbox"></td>
			<td>${p.num }</td>
			<td><img src="${p.img}" width="50" height="75"></td>
			<td>${p.name }</td>
			<td>${p.content }</td>
			<td>${p.price }</td>
			<td>${p.e_date }</td>
			<td>${p.record }</td>
			<td><input type="button" value="삭제"></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>