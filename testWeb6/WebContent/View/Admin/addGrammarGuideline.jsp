<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="addGrammarGuideline" role="dialog">
	<div class="modal-dialog">
		<form action="AddGrammarGuidelineController" method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Grammar Guideline</h4>
				</div>
				<div class="modal-body">
					<!-- begin content -->
					<div class="form-group">
						<h2>Title</h2>
						<input type="text" class="form-control" name="grammarname">
					</div>

					<h2>Content</h2>
					<div class="row">
						<div class="col-md-12">
							<textarea id="comment-md" name="comment"
								placeholder="Say something..."></textarea>
							<br />
							<div id="comment-md-preview-container">
								<div class="well well-sm well-light md-preview margin-top-10"
									id="comment-md-preview"></div>
							</div>
						</div>
					</div>

					<!-- end content -->
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default">OK</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</form>
	</div>
</div>