<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<link href="Template/Backend/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link href="Template/Backend/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<link href="Template/Backend/css/sb-admin.css" rel="stylesheet">

</head>
<body style="background: #0D2C62">

	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Register account</div>
			<div class="card-body">
				<form method="post" action="RegisterController">
					<div class="form-group">
						<div class="form-label-group">
							<input name="fullname" type="text" id="fullname"
								class="form-control" placeholder="First name"
								required="required" autofocus="autofocus"> <label
								for="fullname">Full name</label>
						</div>
					</div>

					<div class="form-group">
						<div class="form-label-group">
							<input name="membername" id="membername" class="form-control"
								placeholder="Account" required="required"> <label
								for="membername">Account</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<div class="form-label-group">
									<input name="memberpass" type="password" id="inputPassword"
										class="form-control" placeholder="Password"
										required="required"> <label for="inputPassword">Password</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-label-group">
									<input name="retypememberpass" type="password"
										id="confirmPassword" class="form-control"
										placeholder="Confirm password" required="required"> <label
										for="confirmPassword">Retype Password</label>
								</div>
							</div>
						</div>
					</div>
					<c:if test="${msgregister != null}">
					<p style="color: red;">${msgregister}</p>
					</c:if>
					<button class="btn btn-primary btn-block" type="submit">Register</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="LoginForward">Return Login
						page</a> <a class="d-block small mt-3" href="HomeForward">Return Home Page</a>
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