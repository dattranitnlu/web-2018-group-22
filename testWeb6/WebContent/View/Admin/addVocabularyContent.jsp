<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="addVocabularyContent" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Vocabulary
					Content</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form method="post" action="AddVocabularyContentController">
				<div class="modal-body">
					<div class="form-group">
						<div class="form-label-group">
							<input name="vocabularyguidelineid" type="hidden"
								id="vocabularyguidelineid" class="form-control" value="${vocabularyguidelineid}">
						</div>
					</div>

					<div class="form-group">
						<div class="form-label-group">
							<label for="vocabularycontentname">Name:</label> <input
								name="vocabularycontentname" type="text"
								id="vocabularycontentname" class="form-control"
								placeholder="Vocabulary Content" required="required"
								autofocus="autofocus">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label for="transcribe">Transcribe:</label> <input
								name="transcribe" type="text" id="transcribe"
								class="form-control" placeholder="Transcribe"
								required="required" autofocus="autofocus">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label for="mean">Mean:</label> <input name="mean" type="text"
								id="mean" class="form-control" placeholder="Mean"
								required="required" autofocus="autofocus">
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<button class="btn btn-primary" type="submit">Add
						Vocabulary Content</button>
				</div>
			</form>
		</div>
	</div>
</div>