<%@ include file="/common/taglib.jsp"%>

<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Add/Edit User</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<c:url value='/admin'/>">Home</a></li>
						<li class="breadcrumb-item active">Add - Edit User</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card card-secondary">
						<div class="card-header">
							<h3 class="card-title">Add/Edit User</h3>

							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse" title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="title">Username</label>
								<input type="text" id="username" value="${user != null ? user.username : ''}"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="href">Password</label>
								<input type="password" id="password" value="${user != null ? user.password : ''}" class="form-control">
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-9">
										<div class="row">
											<div class="col-12 form-group">
												<label for="description">Email</label>
												<input type="email" id="email" value="${user != null ? user.email : ''}" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-3">
										<div class="col-12 form-group">
											<label for="poster">Is admin?</label>
											<div class="form-check">
												<input value="true" class="form-check-input" type="radio" name="isadmin" id="yes" ${user.admin ? 'checked' : ''}>
												<label class="form-check-label" for="yes"> Admin </label>
											</div>
											<div class="form-check">
												<input value="false" class="form-check-input" type="radio" name="isadmin" id="no" ${user.admin ? '' : 'checked'}>
												<label class="form-check-label" for="no"> User </label>
											</div>
											<input type="hidden" id="isEdit" value="${isEdit}" class="form-control">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row" style="margin: auto auto;">
					<button type="button" id="resetUserBtn"
						class="btn btn-primary float-right" style="margin-right: 15px;">
						<i class="ion ion-ios-refresh-empty"></i>
						 Reset
					</button>
					<button type="button" id="submitUserBtn"
						class="btn btn-primary float-right">
						<i class="fas fa-save"></i>
						 Submit
					</button>
				</div>
				<center>
					<h5 id="message"></h5>
				</center>
			</div>
		</div>
	</section>
	<br />
	<br />
</div>
