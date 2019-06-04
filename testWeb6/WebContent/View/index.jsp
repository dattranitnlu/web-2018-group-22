<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Group22 English Learning</title>


<%@ include file="linkCSS.jsp"%>

</head>
<body>
	<div class="super_container">
		<div class="headerContent">
			<!-- Header -->
			<%@ include file="menu.jsp"%>
			<%@ include file="search.jsp"%>
		</div>
		<div class="homeContent">
			<!-- Home -->
			<%@ include file="indexContent.jsp"%>
		</div>

		<div class="footerContent">
			<!-- Footer -->
			<%@ include file="footer.jsp"%>
			<%@ include file="Admin/logout.jsp"%>
		</div>
	</div>
	<%@ include file="linkJS.jsp"%>
</body>
</html>