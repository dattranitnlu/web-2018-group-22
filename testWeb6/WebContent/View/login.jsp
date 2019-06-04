<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>

<link href="Template/Backend/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link href="Template/Backend/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<link href="Template/Backend/css/sb-admin.css" rel="stylesheet">
</head>
<body style="background: #0D2C62">
	
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
				<form action="LoginController" method="post">
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" name="membername" id="membername" class="form-control"
								placeholder="Account" required="required" autofocus="autofocus">
							<label for="membername">Account</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" name="memberpass" id="inputPassword" class="form-control"
								placeholder="Password" required="required"> <label
								for="inputPassword">Password</label>
						</div>
					</div>
					<c:if test="${msglogin != null}">
					<p style="color: red;">${msglogin}</p>
					</c:if>
					<button type="submit" class="btn btn-primary btn-block" >Login</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="RegisterForward">Register account</a>
					<a class="d-block small mt-3" href="HomeForward">Return home page</a>
				</div>
			</div>
		</div>
	</div>

	<script src="Template/Backend/vendor/jquery/jquery.min.js"></script>
	<script
		src="Template/Backend/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script
		src="Template/Backend/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>