<%@ include file="/common/taglib.jsp"%>

<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Video - Overview</h1>
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
				<h3 class="card-title">List video</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<table id="example1" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Link</th>
							<th>Poster</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${videos}" var="item">
							<tr>
								<td>${item.title}</td>
								<td>${item.description}</td>
								<td><a href="/asm-java4/video?action=watch&id=${item.href}">${item.href}</a></td>
								<td><img src="${item.poster}" width="200px" height="150px"></td>
								<td>
									<a id="edit${item.href}"
										href="<c:url value='/admin/video?action=edit&href=${item.href}'/>"
										type="button" class="btn btn-block btn-info btn-sm"><i class="fas fa-pencil-alt"></i> Edit </a>
									<button id="delete${item.href}" type="button"
										onclick="deleteVideo('${item.href}')"
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
