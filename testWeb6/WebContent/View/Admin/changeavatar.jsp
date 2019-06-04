<html>
<head>
</head>
<div class="modal fade" id="changeAvatar" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Change Avatar</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form method="post" enctype="multipart/form-data"
				action="ChangeAvatarController">
				<div class="modal-body">
					<input type="file" name="file">
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<button class="btn btn-primary" type="submit" value="upload">OK</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>