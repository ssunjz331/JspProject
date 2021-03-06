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

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/resource/css/shop-item.css" rel="stylesheet">
<style type="text/css">

.logincomponent{
	padding: 2em;
    width: 400px;
    margin-left: 30%;
    padding-top: 100px;
    padding-bottom: 200px;
}


body{
	font:Apple SD Gothic Neo;
}
.btn{
	width: 100%;
}
.btn_login,
.btn_signup{
	display: inline-block;
}
</style>

</head>
<body>
	<!-- Navigation -->
	<%@include file ="/views/common/header.jsp" %>
	<!-- Page Container -->
	<div class="container">
	<div class = "logincomponent">
		
		<form action="${pageContext.request.contextPath }/LoginController" name="f" method="post">
			<fieldset>
				<legend style="text-align:center;">LOG IN</legend>
					<br>
				<div class="form-group1">
					<!-- <label for="InputID">ID</label>  -->
					<input type="text" class="form-control" id="id" name="id" placeholder="ID">
				</div>
					<br>
				<div class="form-group1">
					<!-- <label for="InputPwd">Password</label>  -->
					<input type="password" class="form-control" id="pwd" name="pwd"
						placeholder="Password">
				</div>
					<br>
				<div class="btn">
					<div class="btn_login">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
					<div class="btn_signup">
						<input type="button" class="btn btn-outline-primary" value="SignUp"
							onclick="location.href='signup.jsp'">
					</div>
				</div>
					<br>
					<br>
				<div class="searchUser" style="text-align:center;">
					<a href="${pageContext.request.contextPath }/views/member/searchId.jsp">아이디 찾기/</a>
					<a href="${pageContext.request.contextPath }/views/member/searchPwd.jsp">비밀번호 찾기</a>
				</div>
			</fieldset>
			
		</form>
		</div>
	</div>






	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>