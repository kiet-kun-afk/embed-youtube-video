<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-info navbar-dark">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
		</li>
		<li class="nav-item d-none d-sm-inline-block">
			<a href="/admin" class="nav-link">Home</a>
		</li>
		<li class="nav-item d-none d-sm-inline-block">
			<a href="/admin/video?action=view" class="nav-link">Video</a>
		</li>
		<li class="nav-item d-none d-sm-inline-block">
			<a href="/admin/user?action=view" class="nav-link">User</a>
		</li>
		<li class="nav-item d-none d-sm-inline-block">
			<a href="/index" class="nav-link">Back OE</a>
		</li>
		<li class="nav-item d-none d-sm-inline-block">
			<a href="/logout" class="nav-link">Log out</a>
		</li>
	</ul>
	<!-- Right navbar links -->
	<ul class="navbar-nav ml-auto">
		<li class="nav-item">
		<a class="nav-link" data-widget="fullscreen"
			href="#" role="button"> <i class="fas fa-expand-arrows-alt"></i>
		</a>
		</li>
	</ul>
</nav>

<aside class="main-sidebar sidebar-light-info elevation-4">
	<div class="sidebar">
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="<c:url value='/templates/admin/dist/img/user3-128x128.jpg'/>"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block">${sessionScope.currentUser.username}</a>
			</div>
		</div>

		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<li class="nav-item menu-open">
					<a href="<c:url value='/admin'/>" class="nav-link ${ativeAside=='A'?'active':''}">
					<i class="nav-icon far fa-image"></i>
							<p>Home</p>
					</a>
				</li>
				<li class="nav-item ${ativeAside=='B'?'menu-open':''}">
					<a id="getvideomenu" href="#"
						class="nav-link ${ativeAside=='B'?'active':''}">
						<i class="nav-icon fas fa-edit"></i>
						<p>Video<i class="right fas fa-angle-left"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a id="getoverview"
							href="<%= request.getContextPath() %>/admin/video?action=view" class="nav-link ${ativeAsideDown=='B1'?'active':''}">
								<i class="far fa-circle nav-icon"></i>
								<p>Overview</p>
						</a>
						</li>
						<li class="nav-item">
						<a id="getneworedit"
							href="<%= request.getContextPath() %>/admin/video?action=add" class="nav-link ${ativeAsideDown=='B2'?'active':''}">
								<i class="far fa-circle nav-icon"></i>
								<p>New or edit</p>
						</a>
						</li>
					</ul>
				</li>
				<li class="nav-item ${ativeAside=='C'?'menu-open':''}">
					<a id="getusermenu" href="#"
						class="nav-link ${ativeAside=='C'?'active':''}">
						<i class="nav-icon fas fa-edit"></i>
						<p>User<i class="right fas fa-angle-left"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						<a id="getoverviewuser"
							href="<%= request.getContextPath() %>/admin/user?action=view" class="nav-link ${ativeAsideDown=='C1'?'active':''}">
								<i class="far fa-circle nav-icon"></i>
								<p>Overview</p>
						</a>
						</li>
						<li class="nav-item">
						<a id="getneworedituser"
							href="<%= request.getContextPath() %>/admin/user?action=add" class="nav-link ${ativeAsideDown=='C2'?'active':''}">
								<i class="far fa-circle nav-icon"></i>
								<p>New or edit</p>
						</a>
						</li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</aside>