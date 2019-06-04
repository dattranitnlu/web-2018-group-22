<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="addImage${list.grammarguidelineid}"
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
				action="AddImageController?grammarguidelineid=${list.grammarguidelineid}">
				<div class="modal-body">
					<c:choose>
						<c:when test="${msgGrammarGuidelineImage != null}">
							<h5>
								<p style="color: red;">${msgGrammarGuidelineImage}</p>
							</h5>
						</c:when>
						<c:when test="${msgGrammarGuidelineImage == null}">
							<h5>
								<p style="color: red;">${msgGrammarGuidelineImage}</p>
							</h5>
						</c:when>
					</c:choose>
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
