<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<jsp:include page="linkCSS.jsp" />
</head>
<body class="nav-md">

	<div class="container body">
		<div class="main_container">

			<jsp:include page="menu.jsp" />
			<jsp:include page="adminContent.jsp" />
			<jsp:include page="changeavatar.jsp" />
			<jsp:include page="edituser.jsp" />
			<jsp:include page="changepass.jsp" />
			<jsp:include page="footer.jsp" />
			
		</div>
	</div>

	<jsp:include page="linkJS.jsp" />
</body>
</html>