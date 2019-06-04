<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Grammar Management</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script data-require="bootstrap@3.1.1" data-semver="3.1.1"
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script data-require="marked@*" data-semver="0.3.1"
	src="http://cdnjs.cloudflare.com/ajax/libs/marked/0.3.1/marked.js"></script>
<script
	src="https://cdn.rawgit.com/toopay/bootstrap-markdown/master/js/bootstrap-markdown.js
"></script>
<script
	src="https://rawgit.com/lodev09/jquery-filedrop/master/jquery.filedrop.js
"></script>
<script
	src="https://rawgit.com/jeresig/jquery.hotkeys/master/jquery.hotkeys.js"></script>

<link data-require="bootstrap-css@3.1.1" data-semver="3.1.1"
	rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
<link data-require="fontawesome@4.1.0" data-semver="4.1.0"
	rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://cdn.rawgit.com/toopay/bootstrap-markdown/master/css/bootstrap-markdown.min.css" />
<link rel="stylesheet" href="style.css" />
<script src="script.js"></script>

<jsp:include page="linkCSS.jsp" />



</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<jsp:include page="menu.jsp" />
			<!-- begin content -->
			<div class="right_col" role="main">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>List Grammar Guideline</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i
											class="fa fa-chevron-up"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>

							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#addGrammarGuideline">
								<i class="fa fa-user-plus"></i>Add grammar guideline
							</button>

							<c:if test="${msgListGrammarGuideline != null}">
								<p style="color: red;">${msgListGrammarGuideline}</p>
							</c:if>

							<div class="x_content">

								<div class="table-responsive">
									<table
										class="table table-striped jambo_table bulk_action table table-bordered">
										<thead>
											<tr class="headings">
												<th class="column-title">ID</th>
												<th class="column-title">Grammar Lesson Name</th>
												<th class="column-title">Image Name</th>
												<th class="column-title"><span class="nobr">Actions</span></th>

											</tr>
										</thead>

										<tbody>
											<c:forEach items="${listGrammarGuideline}" var="list">
												<tr class="even pointer">
													<td class=" ">${list.grammarguidelineid}</td>
													<td class=" ">${list.grammarname}</td>
													<td>
														<button class="btn btn-success" data-toggle="modal"
															data-target="#addImage${list.grammarguidelineid}">
															<i class="fa fa-plus"></i>
														</button> <jsp:include page="addImage.jsp" />
													</td>
													<td>
														<button class="btn btn-warning" data-toggle="modal"
															data-target="#editGrammar${list.grammarguidelineid}">
															<i class="fa fa-retweet"></i>
														</button>
														<button class="btn btn-danger" data-toggle="modal"
															data-target="#removeGrammar${list.grammarguidelineid}">
															<i class="fa fa-times"></i>
														</button>
													</td>
													<c:set var="list" value="${list}" scope="request"></c:set>
													<jsp:include page="addImage.jsp" />
													<jsp:include page="removeGrammar.jsp" />
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end content -->

			<jsp:include page="addGrammarGuideline.jsp" />
			<jsp:include page="footer.jsp" />
		</div>
	</div>

	<!-- FastClick -->
	<script src="Template/Admin/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="Template/Admin/vendors/nprogress/nprogress.js"></script>
	<!-- Chart.js -->
	<script src="Template/Admin/vendors/Chart.js/dist/Chart.min.js"></script>
	<!-- gauge.js -->
	<script src="Template/Admin/vendors/gauge.js/dist/gauge.min.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="Template/Admin/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="Template/Admin/vendors/iCheck/icheck.min.js"></script>
	<!-- Skycons -->
	<script src="Template/Admin/vendors/skycons/skycons.js"></script>
	<!-- Flot -->
	<script src="Template/Admin/vendors/Flot/jquery.flot.js"></script>
	<script src="Template/Admin/vendors/Flot/jquery.flot.pie.js"></script>
	<script src="Template/Admin/vendors/Flot/jquery.flot.time.js"></script>
	<script src="Template/Admin/vendors/Flot/jquery.flot.stack.js"></script>
	<script src="Template/Admin/vendors/Flot/jquery.flot.resize.js"></script>
	<!-- Flot plugins -->
	<script
		src="Template/Admin/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
	<script
		src="Template/Admin/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
	<script src="Template/Admin/vendors/flot.curvedlines/curvedLines.js"></script>
	<!-- DateJS -->
	<script src="Template/Admin/vendors/DateJS/build/date.js"></script>
	<!-- JQVMap -->
	<script src="Template/Admin/vendors/jqvmap/dist/jquery.vmap.js"></script>
	<script
		src="Template/Admin/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
	<script
		src="Template/Admin/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="Template/Admin/vendors/moment/min/moment.min.js"></script>
	<script
		src="Template/Admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="Template/Admin/build/js/custom.min.js"></script>

</body>
</html>