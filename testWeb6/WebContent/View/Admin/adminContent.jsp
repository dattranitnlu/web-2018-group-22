<%@page import="BEAN.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- page content -->
<div class="right_col" role="main">
	<div class="container-fluid" style="padding-top: 50px;">
		<div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-user"></i>Personal information
			</div>
			<div class="card-body">

				<div class="row">
					<div class="col-md-4">
						<img src="${sessionadmin.memberimage }" width="250" height="250" />
					</div>

					<div class="col-md-7">
						<c:set var="pass" value=""></c:set>
						<c:forEach var="i" begin="0"
							end="${fn:length(sessionadmin.memberpass) }">
							<c:set var="pass" value="${pass }*"></c:set>
						</c:forEach>

						<h3>Account: ${sessionadmin.membername}</h3>

						<h3>Password:${pass}</h3>
						<h3>Full name: ${sessionadmin.fullname}</h3>
						<h3>ID: ${sessionadmin.memberid}</h3>
						<h3>Account type: Admin</h3>
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#changeAvatar">Change your avatar</button>
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#changePass">Change your password</button>
						<c:set var="member" value="${sessionadmin}" scope="request"></c:set>
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#editUser${member.memberid}">Update information</button>
					</div>
				</div>

				<c:if test="${msgchangepass != null }">
					<h5 style="text-align: center; color: red">${msgchangepass}</h5>
					<c:remove var="msgadmin" scope="session" />
				</c:if>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->