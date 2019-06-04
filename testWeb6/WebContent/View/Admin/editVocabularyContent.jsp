<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade"
	id="editVocabularyContent${content.vocabularycontentid}" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Update
					information</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form method="post" action="EditVocabularyContentController">
				<div class="modal-body">
					<div class="form-group">
						<div class="form-label-group">
							<input name="vocabularyguidelineid" type="hidden"
								id="vocabularyguidelineid" class="form-control"
								value="${vocabularyguidelineid}">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>ID:</label> <input style="color: black"
								name="vocabularycontentid" class="form-control"
								placeholder="vocabularycontentid"
								value="${content.vocabularycontentid}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>Name:</label> <input style="color: black"
								name="vocabularycontentname" class="form-control"
								placeholder="vocabularycontentname"
								value="${content.vocabularycontentname}">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>Transcribe:</label> <input style="color: black"
								name="transcribe" class="form-control" placeholder="transcribe"
								value="${content.transcribe}">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<label>Mean:</label> <input style="color: black" name="mean"
								class="form-control" placeholder="mean" value="${content.mean}">
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