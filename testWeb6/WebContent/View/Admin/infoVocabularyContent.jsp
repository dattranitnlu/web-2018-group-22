<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade"
	id="infoVocabularyContent${content.vocabularycontentid}" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Information</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-4">
						<img width="150" height="150" src="./${content.vocabularyimage}">
					</div>
					<div class="col-md-8">
						<h5>
							Vocabulary name: <b>${content.vocabularycontentname}</b>
						</h5>
						<h5>
							Transcribe: <b>${content.transcribe}</b>
						</h5>
						<h5>
							Mean: <b>${content.mean}</b>
						</h5>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<audio controls>
							<source src="${content.audiomp3}" type="audio/mpeg">
						</audio>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>