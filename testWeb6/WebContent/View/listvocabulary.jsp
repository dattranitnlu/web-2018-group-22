<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List Vocabulary</title>


<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/bootstrap4/bootstrap.min.css">
<link
	href="Template/FrontEnd/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="Template/FrontEnd/plugins/colorbox/colorbox.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/about.css">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/about_responsive.css">

<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/main_styles.css">
<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/responsive.css">

<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/blog.css">
</head>
<body>
	<div class="super_container">
		<!-- Header -->
		<%@ include file="menu.jsp"%>
		<%@ include file="search.jsp"%>
		<div class="features">
			<div class="container" id="searchresult">
				<c:set var="index" value="0"></c:set>
				
				<div class="row about_row ">
					<c:forEach items="${listvocabulary}" var="vocabulary">
						<div class="col-lg-4 about_col about_col_left ">
							<div class="about_item">
								<div class="about_item_image">
									<a href="VocabularyForward?index=${index}&pageid=1">
									<img style="height: 225px; width: 225px;"  src="${vocabulary.getVocabularyguidelineimage()}" alt="">
									</a>
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


				</div>
				
				
				
				<!-- pager -->
				
				<div class="row">
					<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<ul
							class="pager newsletter_form d-flex flex-row align-items-center justify-content-center">
							<c:if test="${pageid == 1 && pageid != maxpage}">
								<div class=" col text-center">
									<div class="disabled load_more trans_200">
										<a href="">Previous</a>
									</div>
								</div>
								<div class="col text-center">
									<div class="load_more trans_200">
										<a href="ListVocabularyForward1?pageid=${pageid+1}">Next</a>
									</div>
								</div>
							</c:if>
							<c:if test="${pageid == maxpage && pageid != 1}">

								<div class="col text-center">
									<div class="load_more trans_200">
										<a href="ListVocabularyForward1?pageid=${pageid-1}">Previous</a>
									</div>
								</div>
								<div class=" col text-center">
									<div class="disabled load_more trans_200">
										<a href="">Next</a>
									</div>
								</div>

							</c:if>
							<c:if test="${pageid != maxpage && pageid != 1}">

								<div class="col text-center">
									<div class="load_more trans_200">
										<a href="ListVocabularyForward1?pageid=${pageid-1}">Previous</a>
										</div>
								</div>
								<div class=" col text-center">
									<div class="disabled load_more trans_200">
										<a href="ListVocabularyForward1?pageid=${pageid+1}">Next</a>
									</div>
								</div>

							</c:if>
							<c:if test="${maxpage == 1}">

								<div class=" col text-center">
									<div class="disabled load_more trans_200">
										<a href="">Previous</a>
									</div>
								</div>
								<div class="col text-center">
									<div class="disabled load_more trans_200">
										<a href="">Next</a>
									</div>
								</div>

							</c:if>

						</ul>
					</div>
					<div class="col-lg-4"></div>
				</div>

				
				

			</div>
		</div>
		<!-- Footer -->
		<%@ include file="footer.jsp"%>
		<%@ include file="Admin/logout.jsp"%>
	</div>
	<%@ include file="linkJS.jsp"%>
</body>
</html>