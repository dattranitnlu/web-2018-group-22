<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${title}"></c:out></title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

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

<script type="text/javascript">
	function Comment() {
		var xhttp;
		var cmtcontent = document.comment.content.value;
		var id = document.comment.id.value;
		var userid = document.comment.userid.value;
		var page = document.comment.page.value;
		var url = "CommentController?id=" + id + "&userid=" + userid
				+ "&cmtcontent=" + cmtcontent + "&page=" + page;

		if (window.XMLHttpRequest) {
			xhttp = new XMLHttpRequest();
		} else {
			xhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				var data = xhttp.responseText;
				document.getElementById("listcomment").innerHTML = data;
			}
		}
		xhttp.open("POST", url, true);
		xhttp.send();

	}
</script>

</head>
<body>
	<div class="super_container">
		<!-- Header -->
		<%@ include file="menu.jsp"%>
		<%@ include file="search.jsp"%>
		<div class="features">
			<div class="container" id="searchresult">
				<h1>${title}</h1>
				<br>

				<div class="row about_row ">
					<c:forEach items="${listvocabulary}" var="vocabulary">
						<div class="col-lg-6 about_col about_col_left ">
							<div class="about_item"
								style="background: #F4F6FF; border-radius: 10px;">
								<div
									class="about_item_image d-flex flex-row align-items-center justify-content-center">
									<img style="height: 225px; width: 22 	5px;" src="${vocabulary.getVocabularyimage()}" alt="">
								</div>

								<div class="about_item_title ">

									<p style="text-align: center; font-size: 35px;">${vocabulary.getVocabularycontentname()}</p>
									<center>
										<audio controls>Listen <source
											src="${vocabulary.getAudiomp3()}" type="audio/mpeg">
										Trình duyệt của bạn không hỗ trợ HTML5</audio>
									</center>
									<p style="text-align: center; font-size: 20px;">${vocabulary.getTranscribe()}</p>
									<p style="text-align: center; font-size: 20px;">${vocabulary.getMean()}</p>
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
										<a href="VocabularyForward?index=${index}&pageid=${pageid+1}">Next</a>
									</div>
								</div>
							</c:if>
							<c:if test="${pageid == maxpage && pageid != 1}">

								<div class="col text-center">
									<div class="load_more trans_200">
										<a href="VocabularyForward?index=${index}&pageid=${pageid-1}">Previous</a>
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
										<a href="VocabularyForward?index=${index}&pageid=${pageid-1}">Previous</a>
									</div>
								</div>
								<div class=" col text-center">
									<div class="disabled load_more trans_200">
										<a href="VocabularyForward?index=${index}&pageid=${pageid+1}">Next</a>
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


				<h1>Comment:</h1>

				<div class="newsletter_form_container">
					<c:if test="${sessionuser == null}">
						<form name="comment" id="newsletter_form"
							class="newsletter_form d-flex flex-row align-items-center justify-content-center">

							<input disabled="disabled" type="text" name="content"
								class="newsletter_input" placeholder="Your Comment"
								required="required">
							<button disabled="disabled" type="button"
								class="newsletter_button">Bình luận</button>
						</form>
					</c:if>

					<c:if test="${sessionuser != null}">
						<form name="comment" id="newsletter_form"
							class="newsletter_form d-flex flex-row align-items-center justify-content-center">
							<input type="hidden" name="userid"
								value="${sessionuser.getMemberid()}"> <input
								type="hidden" name="id" value="${vocabularyid}"> <input
								type="hidden" name="page" value="vocabulary"> <input
								type="text" name="content" class="newsletter_input"
								placeholder="Your Comment" required="required">
							<button type="button" class="newsletter_button"
								onclick="Comment()">Bình luận</button>
						</form>
					</c:if>
				</div>


				<br>
				<div id="listcomment">
					<c:forEach items="${listcomment}" var="cmt">
						<div class="row">
							<div class="col-sm-1">
								<div class="thumbnail">
									<img class="img-responsive user-photo"
										src="${cmt.getMemberimage()}">
								</div>
								<!-- /thumbnail -->
							</div>
							<!-- /col-sm-1 -->

							<div class="col-sm-5">
								<div class="panel panel-default">
									<div class="panel-heading">
										<strong><c:out value="${cmt.getMembername()}"></c:out></strong>
									</div>
									<div class="panel-body">${cmt.getCmtcontent()}</div>
									<!-- /panel-body -->
								</div>
								<!-- /panel panel-default -->
							</div>
							<!-- /col-sm-5 -->
						</div>
					</c:forEach>
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