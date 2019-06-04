<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<jsp:include page="linkCSS.jsp" />
</head>
<body class="nav-md">

	<div class="container body">
		<div class="main_container">

			<jsp:include page="menu.jsp" />

			<!-- begin member manager -->
			<div class="right_col" role="main">
				<div class="container-fluid">

					<c:if test="${msgtable != null}">
						<p style="color: red;">${msgtable}</p>
					</c:if>
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> Account List
						</div>
						<div class="card-body">
							<button class="btn btn-success" data-toggle="modal"
								data-target="#addUser">
								<i class="fa fa-user-plus"></i>Add Account
							</button>

							<div class="table-responsive">
								<table class="table table-striped jambo_table bulk_action table table-bordered" id="dataTable">
									<thead>
										<tr>
											<th>ID</th>
											<th>Username</th>
											<th>Fullname</th>
											<th>Type</th>
											<th>Avatar</th>
											<th>Update</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${members}" var="member">
											<tr>
												<td>${member.memberid}</td>
												<td>${member.membername}</td>
												<td>${member.fullname}</td>
												<c:choose>
													<c:when test="${member.categorymemberid == 1}">
														<td>Người dùng</td>
													</c:when>
													<c:when test="${member.categorymemberid == 2}">
														<td>Quản Trị Viên</td>
													</c:when>
												</c:choose>
												<td><img width="30" height="30"
													src="${member.memberimage}"></td>
												<td>
													<button class="btn btn-info" data-toggle="modal"
														data-target="#infoUser${member.memberid}">
														<i class="fa fa-info-circle"></i>
													</button>
													<button class="btn btn-warning" data-toggle="modal"
														data-target="#editUser${member.memberid}">
														<i class="fa fa-retweet"></i>
													</button>
													<button class="btn btn-danger" data-toggle="modal"
														data-target="#removeUser${member.memberid}">
														<i class="fa fa-times"></i>
													</button>
												</td>

											</tr>
											<c:set var="member" value="${member}" scope="request"></c:set>
											<jsp:include page="infouser.jsp" />
											<jsp:include page="edituser.jsp" />
											<jsp:include page="removeuser.jsp" />
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end member manager -->
			<jsp:include page="adduser.jsp" />
			<jsp:include page="footer.jsp" />

		</div>
	</div>

	<jsp:include page="linkJS.jsp" />
</body>
</html>