<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
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
	function Score() {
		var xhttp;
		var options = document.forms[1];
		var txt = "";
		var i;
		for (i = 0; i < options.length; i++) {
			if (options[i].checked) {
				txt = options[i].value;
			}
		}
		if (txt != "") {

			var pageid = document.score.pageid.value;
			var url = "ScoreController?option=" + txt + "&pageid=" + pageid;
			if (window.XMLHttpRequest) {
				xhttp = new XMLHttpRequest();
			} else {
				xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4) {
					var data = xhttp.responseText;
					document.getElementById("listoption").innerHTML = data;
				}
			}
			xhttp.open("POST", url, true);
			xhttp.send();
		}
	}
</script>

</head>
<body>

	<div class="super_container">
		<!-- Header -->
		<%@ include file="menu.jsp"%>
		<%@ include file="search.jsp"%>
		<div class="features">
			<div class="container">

				<h2>
					Question
					<c:out value=" ${examinationquestion.getNum()}"></c:out>
					:
				</h2>
				<div class="about_item"
					style="background: #F4F6FF; border-radius: 10px;">
					<div
						class="about_item_image d-flex flex-row align-items-center justify-content-center">
						<c:if test="${examinationquestion.getImagequestion() != null}">
							<img style="height: 225px; width: 22 5px;"
								src="${examinationquestion.getImagequestion()}" alt="">
						</c:if>
					</div>

					<div class="about_item_title ">
						<c:if test="${examinationquestion.getAudiomp3() != null}">
							<center>
								<audio controls>Listen <source
									src="${examinationquestion.getAudiomp3()}" type="audio/mpeg">
								Trình duyệt của bạn không hỗ trợ HTML5</audio>
							</center>
						</c:if>
						<c:if test="${examinationquestion.getQuestion() != null}">
							<p style="font-size: 20px;">
								<b><c:out value=" ${examinationquestion.getQuestion()}"></c:out></b> 
							</p>
						</c:if>
						<c:if test="${examinationquestion.getParagraph() != null}">
							<p style="text-align: center; font-size: 20px;">
								<b><c:out value=" ${examinationquestion.getParagraph()}"></c:out></b>
							</p>
						</c:if>
						<div id="listoption">
							<form name="score">
								<input type="hidden" name="pageid" value="${pageid}">
								<c:if test="${examinationquestion.getParagraph() != null}">
									<input type="radio" name="option"
										value="<c:out value="${examinationquestion.getOption1()}"></c:out>">
									<label for="option1" style="color:black; font-size: 20px;">${examinationquestion.getOption1()}</label>
									<br>
									<input type="radio" name="option"
										value="<c:out value="${examinationquestion.getOption2()}"></c:out>">
									<label for="option2" style="color:black;font-size: 20px;">${examinationquestion.getOption2()}</label>
									<br>
									<input type="radio" name="option"
										value="<c:out value="${examinationquestion.getOption3()}"></c:out>">
									<label for="option3" style="color:black;font-size: 20px;">${examinationquestion.getOption3()}</label>
									<br>
									<input type="radio" name="option"
										value="<c:out value="${examinationquestion.getOption4()}"></c:out>">
									<label for="option4" style="color:black;font-size: 20px;">${examinationquestion.getOption4()}</label>


								</c:if>
								<c:if test="${examinationquestion.getParagraph() == null}">
									<input type="radio" name="option"
										value="<c:out value="${examinationquestion.getOption1()}"></c:out>">
									<label for="option1" style="color:black;font-size: 20px;">A</label>
									<br>
									<input type="radio" name="option"
										value="<c:out value="${examinationquestion.getOption2()}"></c:out>">
									<label for="option2" style="color:black;font-size: 20px;">B</label>
									<br>
									<input type="radio" name="option"
										value="<c:out value="${examinationquestion.getOption3()}"></c:out>">
									<label for="option3" style="color:black;font-size: 20px;">C</label>
									<c:if test="${examinationquestion.getImagequestion() != null}">
										<br>
										<input type="radio" name="option"
											value="<c:out value="${examinationquestion.getOption4()}"></c:out>">
										<label for="option4" style="color:black;font-size: 20px;">D</label>
									</c:if>
								</c:if>
							</form>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<ul
							class="pager newsletter_form d-flex flex-row align-items-center justify-content-center">
							<div class=" col text-center">
								<button style="color: white;" type="button" onclick="Score()"
									class="btn btn-primary load_more trans_200">SUBMIT</button>
							</div>
							<c:if test="${pageid == 0 && pageid != maxpage}">
								<div class=" col text-center">
									<div class="disabled load_more trans_200">
										<a href="">Previous</a>
									</div>
								</div>

								<div class="col text-center">
									<div class="load_more trans_200">
										<a
											href="ExaminationQuestionForward?index=${index}&pageid=${pageid+1}">Next</a>
									</div>
								</div>
							</c:if>
							<c:if test="${pageid == maxpage && pageid != 0}">

								<div class="col text-center">
									<div class="load_more trans_200">
										<a
											href="ExaminationQuestionForward?index=${index}&pageid=${pageid-1}">Previous</a>
									</div>
								</div>
								<div class=" col text-center">
									<div class="disabled load_more trans_200">
										<a href="">Next</a>
									</div>
								</div>

							</c:if>
							<c:if test="${pageid != maxpage && pageid != 0}">

								<div class="col text-center">
									<div class="load_more trans_200">
										<a
											href="ExaminationQuestionForward?index=${index}&pageid=${pageid-1}">Previous</a>
									</div>
								</div>
								<div class=" col text-center">
									<div class="load_more trans_200">
										<a
											href="ExaminationQuestionForward?index=${index}&pageid=${pageid+1}">Next</a>
									</div>
								</div>

							</c:if>
							<c:if test="${maxpage == 0}">

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

		<%@ include file="footer.jsp"%>
		<%@ include file="Admin/logout.jsp"%>
	</div>

	<%@ include file="linkJS.jsp"%>
</body>
</html>