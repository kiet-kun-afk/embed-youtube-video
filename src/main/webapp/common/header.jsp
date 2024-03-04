<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid">
		<a id="getindex" class="navbar-brand text-warning" href="<c:url value='/index'/>"> <i class="text-danger fa-regular fa-face-kiss-wink-heart"></i>
			ONLINE ENTERTAINMENT
		</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${not empty currentUser}">
					<li class="nav-item">
						<a class="nav-link nav-link-1" aria-current="page" href="" data-toggle="modal" data-target="#changePassModal">Welcome, ${sessionScope.currentUser.username}</a>
					</li>
					<c:if test="${currentUser.role() == 'ADMIN'}">
						<li class="nav-item">
							<a id="getmanager" class="nav-link nav-link-2" href="admin">Management</a>
						</li>
					</c:if>
					<li class="nav-item">
						<a class="nav-link nav-link-2" href="favorites">Favorite</a>
					</li>
					<li class="nav-item">
						<a class="nav-link nav-link-3" href="history">History</a>
					</li>
					<li class="nav-item">
						<a id="getlogout" class="nav-link nav-link-2" href="logout">Log out</a>
					</li>
					</c:when>
					<c:otherwise>
					<li class="nav-item">
						<a id="getlogin" class="nav-link nav-link-4" href="login">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link nav-link-3" href="register">Sig up</a>
					</li>
					<li class="nav-item">
						<a class="nav-link nav-link-1" href="forgotPass">Forgot password?</a>
					</li>
					</c:otherwise>
				</c:choose>
			</ul>
			<div class="dropdown mb-2 mb-lg-0">
			  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
			    <i class="fas fa-globe"></i>
			  </button>
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="language=en">English</a></li>
			    <li><a class="dropdown-item" href="language=vi">Tiếng Việt</a></li>
			  </ul>
			</div>
		</div>
	</div>
</nav>

<div class="tm-hero d-flex justify-content-center align-items-center"
	data-parallax="scroll"
	data-image-src="<c:url value='/templates/user/img/banner.png'/>" style="height: 200px">
	<%--
	<form class="d-flex tm-search-form">
		<input class="form-control tm-search-input" type="search"
			placeholder="Search" aria-label="Search">
		<button class="btn btn-outline-success tm-search-btn" type="submit">
			<i class="fas fa-search"></i>
		</button>
	</form>
	--%>
</div>
<!-- Modal -->
<div class="modal fade" id="changePassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="password" name="currentPass" id="currentPass" class="form-control rounded-0" placeholder="Current password" required />
        </div>
        <div class="form-group">
        	<input type="password" name="newPass" id="newPass" class="form-control rounded-0" placeholder="New password" required />
        </div>
        <h5 class="text-danger" id="messageChangePass"></h5>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-warning" id="changePassBtn">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>