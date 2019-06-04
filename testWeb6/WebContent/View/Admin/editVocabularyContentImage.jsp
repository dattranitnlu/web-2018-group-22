<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade"
	id="editVocabularyContentImage${content.vocabularycontentid}"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Image</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form method="post" enctype="multipart/form-data"
				action="EditVocabularyContentImageController">
				<div class="form-group">
					<div class="form-label-group">
						<input name="vocabularyguidelineid" type="hidden"
							id="vocabularyguidelineid" class="form-control"
							value="${vocabularyguidelineid}">
					</div>
				</div>
				<div class="form-group">
					<div class="form-label-group">
						<input name="vocabularycontentid" type="hidden"
							id="vocabularycontentid" class="form-control"
							value="${content.vocabularycontentid}">
					</div>
				</div>
				<div class="modal-body">
					<input type="file" name="vocabularyimage">
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