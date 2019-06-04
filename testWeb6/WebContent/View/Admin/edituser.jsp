<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="editUser${member.memberid}" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Update information</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form method="post" action="EditUserController">
				<div class="modal-body">
					<div class="form-group">
						<div class="form-label-group">
							<label>ID:</label> <input style="color: black" name="memberid" class="form-control"
								placeholder="Account" value="${member.memberid}"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>Account:</label> <input style="color: black" name="membername"
								class="form-control" placeholder="Account"
								value="${member.membername}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>Full name:</label> <input style="color: black" name="fullname"
								class="form-control" placeholder="Account"
								value="${member.fullname}">
						</div>
					</div>
					<c:if test="${sessionuser == null}">
					<c:if test="${sessionadmin.memberid != member.memberid}">
					<div class="form-group">
						<div class="form-label-group">
								<label>Account type:</label><br> <select name="categorymemberid"
									style="height: 25px;">
									<option value="1"
										<c:if test="${member.categorymemberid == 1}">
												selected="selected" 
										</c:if>>User</option>
									<option value="2"
										<c:if test="${member.categorymemberid == 2}">
												selected="selected" </c:if>> Admin</option>
								</select>
						</div>
					</div>
					</c:if>
					</c:if>
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<button class="btn btn-primary" type="submit">Update</button>
				</div>
			</form>
		</div>
	</div>
</div>
