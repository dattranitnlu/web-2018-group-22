<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Personal Information</title>
<%@ include file="linkCSS.jsp"%>
</head>
<body>
	<div class="super_container">
		<!-- Header -->
		<%@ include file="menu.jsp"%>

		<div class="container" style="padding-top: 150px;">

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-user"></i> Personal information
				</div>
				<div class="card-body">

					<div class="row">
						<div class="col-md-4">
							<img src="${sessionuser.memberimage }" width="250" height="250" />
						</div>

						<div class="col-md-7">
							<c:set var="pass" value=""></c:set>
							<c:forEach var="i" begin="0"
								end="${fn:length(sessionuser.memberpass)}">
								<c:set var="pass" value="${pass}*"></c:set>
							</c:forEach>

							<h4>Account:  ${sessionuser.membername}</h4>
							<br>
							<h4>Password:  ${pass}</h4>
							<br>

							<h4>Full name:  ${sessionuser.fullname}</h4>
							<br>

							<h4>ID:  ${sessionuser.memberid}</h4>
							<br>

							<h4>Account type:  User</h4>
							<br>

							<button class="btn btn-primary" data-toggle="modal"
								data-target="#changeAvatar">Change avatar</button>
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#changePass">Change password</button>
							<c:set var="member" value="${sessionuser}" scope="request"></c:set>
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#editUser${member.memberid}">Update
								information</button>
						</div>
					</div>

					<c:if test="${msgtable != null }">
						<h5 style="text-align: center; color: red">${msgtable}</h5>
						<c:remove var="msgtable" scope="request" />
					</c:if>
					<c:if test="${msgchangepass != null }">
						<h5 style="text-align: center; color: red">${msgchangepass}</h5>
						<c:remove var="msgchangepass" scope="session" />
					</c:if>
					<c:if test="${msgchangeavatar != null }">
						<h5 style="text-align: center; color: red">${msgchangeavatar}</h5>
						<c:remove var="msgchangeavatar" scope="request" />
					</c:if>
				</div>
			</div>

		</div>
	</div>

	<%@ include file="footer.jsp"%>
	<%@ include file="Admin/logout.jsp"%>
	<%@ include file="Admin/changeavatar.jsp"%>
	<%@ include file="Admin/changepass.jsp"%>
	<%@ include file="Admin/edituser.jsp"%>



	<%@ include file="linkJS.jsp"%>
</body>
</html>