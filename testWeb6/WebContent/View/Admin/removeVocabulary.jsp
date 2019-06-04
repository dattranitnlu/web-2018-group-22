<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="removeVocabulary${vocabulary.vocabularyguidelineid}"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Remove account</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form action="RemoveVocabularyController" method="post">
				<input name="vocabularyguidelineid" type="hidden" value="${vocabulary.vocabularyguidelineid}">
				<div class="modal-body">Select "Remove" below if you want to remove this account</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="submit"
						data-dismiss="modal">Cancel</button>
					<button type="submit" class="btn btn-primary">Remove</button>
				</div>
			</form>
		</div>
	</div>
</div>