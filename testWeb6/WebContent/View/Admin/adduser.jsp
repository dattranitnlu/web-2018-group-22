<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="addUser" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add account</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form method="post" action="AddUserController">
				<div class="modal-body">
					<div class="form-group">
						<div class="form-label-group">
							<label for="fullname">Full name:</label> <input name="fullname"
								type="text" id="fullname" class="form-control"
								placeholder="First name" required="required"
								autofocus="autofocus">
						</div>
					</div>

					<div class="form-group">
						<div class="form-label-group">
							<label for="membername">Account:</label> <input
								name="membername" id="membername" class="form-control"
								placeholder="Account" required="required">
						</div>
					</div>

					<div class="form-group">
						<div class="row">
							<div class="col-md-6">
								<div class="form-label-group">
									<label for="inputPassword">Password:</label> <input
										name="memberpass" type="password" id="inputPassword"
										class="form-control" placeholder="Password"
										required="required">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-label-group">
									<label for="confirmPassword">Confirm Password:</label> <input
										name="retypememberpass" type="password" id="confirmPassword"
										class="form-control" placeholder="Confirm password"
										required="required">
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>Account type:</label><br> <select
								name="categorymemberid" style="height: 25px;">
								<option value="1">User</option>
								<option value="2">Admin</option>
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<button class="btn btn-primary" type="submit">Add account</button>
				</div>
			</form>
		</div>
	</div>
</div>