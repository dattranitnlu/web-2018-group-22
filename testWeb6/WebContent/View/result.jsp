<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Result</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/about.css">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/about_responsive.css">
<%@ include file="linkCSS.jsp"%>
</head>
<body>
	<div class="super_container">

		<%@ include file="menu.jsp"%>
		<%@ include file="menu.jsp"%>
		<%@ include file="search.jsp"%>
		<div class="features">
			<div class="container" id="searchresult">
				<h2>Result:</h2>
				<br>
				<c:if test="${result != null}">
					<c:out value="${result}"></c:out>
					<c:set var="result" value="" scope="request"></c:set>
				</c:if>
				<div class="container">
					<c:set var="index" value="0"></c:set>

					<div class="row about_row ">
					
						<c:if test="${fn:contains(type,'grammar')}">
						<c:forEach items="${listsearch}" var="grammar">

							<div
								class="col-lg-4 about_col about_col_left d-flex flex-row align-items-center justify-content-center">
								<div class="about_item">
									<div class="about_item_image d-flex flex-row align-items-center justify-content-center ">
										<img src="${grammar.getGrammarimage()}" alt="">
									</div>

									<div class="about_item_title">

										<a href="GrammarForward?index=${index}">${grammar.getGrammarname()}</a>
										<c:set var="index" value="${index +1}"></c:set>
									</div>
									<div>
										<br> <br> <br>
									</div>
								</div>
							</div>

						</c:forEach>
						</c:if>
						<c:if test="${fn:contains(type,'vocabulary')}">
						<c:forEach items="${listsearch}" var="vocabulary">

							<div
								class="col-lg-4 about_col about_col_left d-flex flex-row align-items-center justify-content-center">
								<div class="about_item">
									<div class="about_item_image d-flex flex-row align-items-center justify-content-center ">
										<img src="${vocabulary.getVocabularyguidelineimage()}" alt="">
									</div>

									<div class="about_item_title">

										<a href="VocabularyForward?index=${index}&pageid=1">${vocabulary.getVocabularyguidelinename()}</a>
										<c:set var="index" value="${index +1}"></c:set>
									</div>
									<div>
										<br> <br> <br>
									</div>
								</div>
							</div>

						</c:forEach>
						</c:if>
						
					</div>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
		<%@ include file="Admin/logout.jsp"%>
	</div>
	<%@ include file="linkJS.jsp"%>
</body>
</html>