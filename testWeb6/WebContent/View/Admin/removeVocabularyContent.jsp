<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade"
	id="removeVocabularyContent${content.vocabularycontentid}"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Remove Vocabulary Content</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form action="RemoveVocabularyContentController" method="post">
				<input name="vocabularyguidelineid" type="hidden"
					value="${content.vocabularyguidelineid}"> <input
					name="vocabularycontentid" type="hidden"
					value="${content.vocabularycontentid}">
				<div class="modal-body">Select "Remove" below if you want to
					remove this content</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="submit"
						data-dismiss="modal">Cancel</button>
					<button type="submit" class="btn btn-primary">Remove</button>
				</div>
			</form>
		</div>
	</div>
</div>