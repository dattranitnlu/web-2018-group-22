<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="removeGrammar${list.grammarguidelineid}"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Remove Grammar Guideline</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form action="RemoveGrammarGuidelineController" method="post">
				<input name="grammarguidelineid" type="hidden" value="${list.grammarguidelineid}">
				<div class="modal-body">Would you like to remove this guideline?</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Yes</button>
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">No</button>
				</div>
			</form>
		</div>
	</div>
</div>