<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="editVocabulary${vocabulary.vocabularyguidelineid}" tabindex="-1"
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
			<form method="post" action="EditVocabularyController">
				<div class="modal-body">
					<div class="form-group">
						<div class="form-label-group">
							<label>ID:</label> <input style="color: black" name="vocabularyguidelineid" class="form-control"
								placeholder="ID" value="${vocabulary.vocabularyguidelineid}"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>Name:</label> <input style="color: black" name="vocabularyguidelinename"
								class="form-control" placeholder="Name"
								value="${vocabulary.vocabularyguidelinename}">
						</div>
					</div>
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