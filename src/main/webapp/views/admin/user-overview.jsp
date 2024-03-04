<%@ include file="/common/taglib.jsp"%>

<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">User - Overview</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<c:url value='/admin'/>">Home</a></li>
						<li class="breadcrumb-item active">Overview</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<section class="content">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">List user</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<table id="example1" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Username</th>
							<th>Email</th>
							<th>IsAdmin</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="item">
							<tr>
								<td>${item.username}</td>
								<td>${item.email}</td>
								<td>${item.admin?'Admin':'User'}</a></td>
								<td>
									<a id="edit${item.username}"
										href="<c:url value='/admin/user?action=edit&username=${item.username}'/>"
										type="button" class="btn btn-block btn-info btn-sm"><i class="fas fa-pencil-alt"></i> Edit </a>
									<button id="delete${item.username}" type="button"
										onclick="deleteUser('${item.username}')"
										class="btn btn-block btn-danger btn-sm"><i class="fas fa-trash"></i> Delete </button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</div>
