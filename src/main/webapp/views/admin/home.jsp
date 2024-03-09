<%@ include file="/common/taglib.jsp" %>

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
									<td><a href="video/watch?p=${item.href}">${item.href}</a></td>
									<td>${item.like}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</div>