<%@ include file="/common/taglib.jsp" %>

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
				<div class="card-body">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Title</th>
								<th>Description</th>
								<c:choose>
									<c:when test="${ativeAsideDown!='B3'}">
										<th>Link</th>
									</c:when>
								</c:choose>
								<th>Poster</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${videos}" var="item">
								<tr>
									<td>${item.title}</td>
									<td>${item.description}</td>
									<c:choose>
										<c:when test="${ativeAsideDown!='B3'}">
											<td><a href="/video/watch?p=${item.href}">${item.href}</a></td>
										</c:when>
									</c:choose>
									<td><img src="${item.poster}" width="200px" height="150px"></td>
									<td>
										<c:choose>
											<c:when test="${ativeAsideDown!='B3'}">
												<a id="edit${item.href}"
													href="<c:url value='/admin/video/edit?href=${item.href}'/>"
													type="button" class="btn btn-block btn-info btn-sm"><i
														class="fas fa-pencil-alt"></i> Edit
												</a>
												<button id="delete${item.href}" type="button"
													onclick="deleteVideo('${item.href}')"
													class="btn btn-block btn-danger btn-sm"><i class="fas fa-trash"></i>
													Delete
												</button>
											</c:when>
											<c:when test="${ativeAsideDown=='B3'}">
												<button id="recover${item.href}" type="button"
													onclick="recoverVideo('${item.href}')"
													class="btn btn-block btn-success btn-sm"><i
														class="fas fa-reply"></i>
													Recover
												</button>
											</c:when>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</div>