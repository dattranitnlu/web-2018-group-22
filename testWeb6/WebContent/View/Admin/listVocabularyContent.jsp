<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vocabulary Content List</title>
<jsp:include page="linkCSS.jsp" />
</head>
<body class="nav-md">

	<div class="container body">
		<div class="main_container">

			<jsp:include page="menu.jsp" />

			<!-- begin member manager -->
			<div class="right_col" role="main">
				<div class="container-fluid">

					<c:if test="${msgVocabularyContent != null}">
						<p style="color: red;">${msgVocabularyContent}</p>
					</c:if>
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> Vocabulary List
						</div>
						<div class="card-body">
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#addVocabularyContent">
								<i class="fa fa-user-plus"></i>Add Vocabulary Content
							</button>

							<div class="table-responsive">
								<table class="table table-striped jambo_table bulk_action table table-bordered" id="dataTable">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Transcribe</th>
											<th>Audio</th>
											<th>Mean</th>
											<th>Image</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${vocabularyContentList}" var="content">
										<c:set var="vocabularycontentid" value="${content.vocabularycontentid}" scope="session"></c:set>
										<c:set var="vocabularyguidelineid" value="${vocabularyguidelineid}" scope="session"></c:set>
											<tr>
												<td>${content.vocabularycontentid}</td>
												<td>${content.vocabularycontentname}</td>
												<td>${content.transcribe}</td>
												<td>
													<button class="btn btn-dark" data-toggle="modal"
														data-target="#editVocabularyContentAudio${vocabularycontentid}">
														<i class="fa fa-retweet"></i>
													</button>
												</td>
												<td>${content.mean}</td>
												<td>
													<button class="btn btn-dark" data-toggle="modal"
														data-target="#editVocabularyContentImage${vocabularycontentid}">
														<i class="fa fa-retweet"></i>
													</button>
												</td>
												<td>
													<button class="btn btn-primary" data-toggle="modal"
														data-target="#infoVocabularyContent${content.vocabularycontentid}">
														<i class="fa fa-info-circle"></i>
													</button>
													<button class="btn btn-warning" data-toggle="modal"
														data-target="#editVocabularyContent${content.vocabularycontentid}">
														<i class="fa fa-retweet"></i>
													</button>
													<button class="btn btn-danger" data-toggle="modal"
														data-target="#removeVocabularyContent${content.vocabularycontentid}">
														<i class="fa fa-times"></i>
													</button>
												</td>

											</tr>
											<c:set var="content" value="${content}" scope="request"></c:set>
											
											<jsp:include page="infoVocabularyContent.jsp" />
											<jsp:include page="editVocabularyContent.jsp" />
											<jsp:include page="removeVocabularyContent.jsp" />
											
											<jsp:include page="editVocabularyContentImage.jsp" />
											<jsp:include page="editVocabularyContentAudio.jsp" />
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end member manager -->
			<jsp:include page="addVocabularyContent.jsp" />
			<jsp:include page="footer.jsp" />

		</div>
	</div>

	<jsp:include page="linkJS.jsp" />
</body>
</html>