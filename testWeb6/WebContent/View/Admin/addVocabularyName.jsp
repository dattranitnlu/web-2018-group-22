<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="addVocabularyName" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Vocabulary Topic</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form method="post" action="AddVocabularyNameController">
				<div class="modal-body">
					<div class="form-group">
						<div class="form-label-group">
							<label for="vocabularyguidelinename">Vocabulary name:</label> <input name="vocabularyguidelinename"
								type="text" id="vocabularyguidelinename" class="form-control"
								placeholder="Vocabulary name" required="required"
								autofocus="autofocus">
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<button class="btn btn-primary" type="submit">Add Vocabulary Topic</button>
				</div>
			</form>
		</div>
	</div>
</div>