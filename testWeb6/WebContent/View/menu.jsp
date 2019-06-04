<%@page import="BEAN.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Template/FrontEnd/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="Template/FrontEnd/styles/responsive.css">
</head>
<body>
	<header class="header"> <!-- Top Bar -->
	<div class="top_bar">
		<div class="top_bar_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div
							class="top_bar_content d-flex flex-row align-items-center justify-content-start">
							<div class="top_bar_login ml-auto">
								<c:if test="${sessionuser != null}">
								<ul>
									<div class="row">
										<a class="navbar-brand mr-1" href="UserForward"
											style="color: white;">${sessionuser.getFullname()}</a>
										<li class="nav-item dropdown no-arrow"><a
											class="nav-link dropdown-toggle" href="#" id="userDropdown"
											role="button" data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false"> <img width="30" height="30"
												src="${sessionuser.getMemberimage()}">
										</a>
											<div class="dropdown-menu dropdown-menu-right"
												aria-labelledby="userDropdown">
												<a class="dropdown-item" href="UserForward">Personal information</a> <a
													class="dropdown-item" href="#" data-toggle="modal"
													data-target="#logoutModal"> <i
								class="fa fa-sign-out pull-right"></i> Logout</a>
											</div></li>
									</div>
								</ul>
								</c:if>
								<c:if test="${sessionuser == null}">
								<div class="login_button">
									<a href="LoginForward">Register or Login</a>
								</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Header Content -->
	<div class="header_container">
		<div class="container">
			<div class="row">
				<div class="col">
					<div
						class="header_content d-flex flex-row align-items-center justify-content-start">
						<div class="logo_container">
							<a href="HomeForward">
								<div class="logo_text">
									Group<span>22</span>English
								</div>
							</a>
						</div>
						<nav class="main_nav_contaner ml-auto">
						<ul class="main_nav">
							<li><a href="HomeForward">Home</a></li>
							<li><a href="AboutForward">About us</a></li>
							<li><a href="ListGrammarForward?pageid=1">Grammar</a></li>
							<li><a href="ListVocabularyForward1?pageid=1">Vocabulary</a></li>
							<li><a href="ExaminationForward?pageid=1">Examination</a></li>
						</ul>

						<!-- Hamburger -->


						<div class="hamburger menu_mm">
							<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
						</div>
						</nav>

					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
</body>
</html>