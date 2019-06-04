<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment</title>

</head>
<body>
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

</body>
</html>