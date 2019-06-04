<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Vocabulary</title>
<jsp:include page="linkCSS.jsp" />
</head>
<body class="nav-md">

	<div class="container body">
		<div class="main_container">
			<jsp:include page="menu.jsp" />
			<!-- begin Vocabulary manager -->
			<div class="right_col" role="main">
				<div class="container-fluid">

					<c:if test="${msgVocabulary != null}">
						<p style="color: red;">${msgVocabulary}</p>
					</c:if>
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-table"></i> Vocabulary Topic List
						</div>
						<div class="card-body">
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#addVocabularyName">
								<i class="fa fa-plus"></i>Add Topic
							</button>

							<div class="table-responsive">
								<table class="table table-striped jambo_table bulk_action table table-bordered" id="dataTable">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Image</th>
											<th>Content</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${vocabularies}" var="vocabulary">
											<tr>
												<td>${vocabulary.vocabularyguidelineid}</td>
												<td>${vocabulary.vocabularyguidelinename}</td>

												<td>
													<button class="btn btn-primary" data-toggle="modal"
														data-target="#addVocabularyImage${vocabulary.vocabularyguidelineid}">
														<i class="fa fa-plus"> </i>
													</button>

												</td>
												<td>
												<c:set var="vocabularyguidelineid" value="${vocabulary.vocabularyguidelineid}" scope="request"></c:set>
												<a
													href="ListVocabularyContentForward?vocabularyguidelineid=${vocabulary.vocabularyguidelineid}">
														<button class="btn btn-dark">
														<i class="fa fa-television"></i>
													</button> </a></td>
												<td>
													<button class="btn btn-info" data-toggle="modal"
														data-target="#infoVocabulary${vocabulary.vocabularyguidelineid}">
														<i class="fa fa-info-circle"></i>
													</button>
													<button class="btn btn-warning" data-toggle="modal"
														data-target="#editVocabulary${vocabulary.vocabularyguidelineid}">
														<i class="fa fa-retweet"></i>
													</button>
													<button class="btn btn-danger" data-toggle="modal"
														data-target="#removeVocabulary${vocabulary.vocabularyguidelineid}">
														<i class="fa fa-times"></i>
													</button>
												</td>

											</tr>
											<c:set var="vocabulary" value="${vocabulary}" scope="request"></c:set>
											<jsp:include page="addVocabularyImage.jsp" />
											<jsp:include page="infoVocabulary.jsp" />
											<jsp:include page="editVocabulary.jsp" />
											<jsp:include page="removeVocabulary.jsp" />
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end vocabulary manager -->
			<jsp:include page="addVocabularyName.jsp" />
			<jsp:include page="footer.jsp" />
		</div>
	</div>
</body>
<jsp:include page="linkJS.jsp" />
</html>