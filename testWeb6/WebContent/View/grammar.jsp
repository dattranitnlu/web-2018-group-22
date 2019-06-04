<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Grammar Lesson</title>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

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

<link rel="stylesheet" type="text/css"
	href="Template/FrontEnd/styles/blog.css">

<%@ include file="linkCSS.jsp"%>

</head>
<body>
	<div class="super_container">
		<%@ include file="menu.jsp"%>
		<%@ include file="search.jsp"%>
		<div class="features">
			<div class="container" id="searchresult">
				<h1 style="padding-bottom: 30px;">
					<c:out value="${title}"></c:out>
				</h1>

				<c:set var="content"
					value="${fn:replace(content,ketthucindamdb,ketthucindamhtml)}"></c:set>
				<c:set var="content"
					value="${fn:replace(content,ketthucindamdb1,ketthucindamhtml)}"></c:set>
				<c:set var="content"
					value="${fn:replace(content,xuonghangdb,xuonghanghtml)}"></c:set>
				<c:set var="content"
					value="${fn:replace(content,xuonghangdb1,xuonghanghtml)}"></c:set>
				<c:set var="content"
					value="${fn:replace(content,batdauindamdb,batdauindamhtml)}"></c:set>
				<p style="color: black">
					<c:out value="${content}" escapeXml="false"></c:out>
				</p>



				<h1>Comment:</h1>



				<div class="newsletter_form_container">

					<c:if test="${sessionuser == null}">
						<form name="comment" id="newsletter_form"
							class="newsletter_form d-flex flex-row align-items-center justify-content-center">

							<input disabled="disabled" type="text" name="content"
								class="newsletter_input" placeholder="Login to comment"
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
								type="hidden" name="id" value="${grammarid}"> <input
								type="hidden" name="page" value="grammar"> <input
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
		<%@ include file="footer.jsp"%>
		<%@ include file="Admin/logout.jsp"%>
	</div>
	<%@ include file="linkJS.jsp"%>
</body>
</html>