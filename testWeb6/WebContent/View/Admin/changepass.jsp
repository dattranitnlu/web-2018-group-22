<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="modal fade" id="changePass" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form method="post" action="ChangePassController">
					<div class="modal-body">
						<div class="form-group">
							<div class="form-label-group">
								<label for="newPassword">Password:</label>
								<input style="color: black" autofocus="autofocus" name="memberpass"
									class="form-control" placeholder="Password" required="required">
								<label for="password"></label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<label for="newPassword">New Password:</label> <input
									style="color: black" name="newmemberpass" type="password" id="newPassword"
									class="form-control" placeholder="Password" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<label for="retypePassword">Retyping New Password:</label> <input
									style="color: black" name="retypememberpass" type="password" id="retypePassword"
									class="form-control" placeholder="Password" required="required">
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Exit</button>
						<button class="btn btn-primary" type="submit">OK</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>