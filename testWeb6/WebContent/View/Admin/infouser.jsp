<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="infoUser${member.memberid}" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Information</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-4">
						<img width="150" height="150" src="${member.memberimage}">
					</div>
					<div class="col-md-8">
						<h5>
							Account: <b>${member.membername}</b>
						</h5>
						<h5>
							ID: <b>${member.memberid}</b>
						</h5>
						<h5>
							Full name: <b>${member.fullname}</b>
						</h5>
						<c:choose>
							<c:when test="${member.categorymemberid == 1}">
								<h5>
									Account type: <b>User</b>
								</h5>
							</c:when>
							<c:when test="${member.categorymemberid == 2}">
								<h5>
									Account type: <b>Admin</b>
								</h5>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>
