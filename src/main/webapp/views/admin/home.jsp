<%@ include file="/common/taglib.jsp"%>

<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Home</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item">Home</li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<!-- Main content -->
	<section class="content">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Favorites Statistic</h3>
			</div>
			<div class="card-body">
				<table id="example1" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>Link</th>
							<th>Total like</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${videos}" var="item">
							<tr>
								<td>${item.title}</td>
								<td><a href="video?action=watch&id=${item.href}">${item.href}</a></td>
								<td>${item.totalLike}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Favorites Info</h3>
			</div>
			<div class="card-body">
				<div class="form-group">
					<label>List video</label> <select id="selectVideo"
						class="form-control">
						<option selected disabled>Select one</option>
						<c:forEach items="${videos}" var="item">
							<option value="${item.href}">${item.title}</option>
						</c:forEach>
					</select>
				</div>
				<table id="example2" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Username</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
	</section>
</div>
