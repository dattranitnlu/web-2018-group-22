<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-3 left_col">
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="AdminForward" class="site_title"><i class="fa fa-paw"></i>
				<span>${sessionadmin.membername}</span></a>
		</div>

		<div class="clearfix"></div>

		<br />

		<!-- sidebar menu -->
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
			<div class="menu_section">
				<h3>General</h3>
				<ul class="nav side-menu">
					<li><a href="TableForward"><i class="fa fa-home"></i>Member Management</a></li>
					<li><a href="ListGrammarGuidelineForward"><i class="fa fa-desktop"></i>Grammar Management</a></li>
					<li><a href="ListVocabularyTopicForward"><i class="fa fa-desktop"></i>Vocabulary Management</a></li>
				</ul>
			</div>
		</div>
		<!-- /sidebar menu -->

	</div>
</div>

<!-- top navigation -->
<div class="top_nav">
	<div class="nav_menu">
		<nav>
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li class=""><a href="javascript:;"
					class="user-profile dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> <img
						src="${sessionadmin.memberimage}" width="30" height="30"
						alt="">${sessionadmin.membername}<span
						class=" fa fa-angle-down"></span>
				</a>
					<ul class="dropdown-menu dropdown-usermenu pull-right">
						<li><a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal"> <i
								class="fa fa-sign-out pull-right"></i> Log Out
						</a></li>
					</ul></li>
					<jsp:include page="logout.jsp"/>
				<li role="presentation" class="dropdown"><a href="javascript:;"
					class="dropdown-toggle info-number" data-toggle="dropdown"
					aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span
						class="badge bg-green">6</span>
				</a>
					<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
						role="menu">
						<li><a> <span class="image"><img
									src="${sessionadmin.memberimage}" alt="Profile Image" /></span> <span> <span>John
										Smith</span> <span class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li>
							<div class="text-center">
								<a> <strong>See All Alerts</strong> <i
									class="fa fa-angle-right"></i>
								</a>
							</div>
						</li>
					</ul></li>
			</ul>
		</nav>
	</div>
</div>
<!-- /top navigation -->