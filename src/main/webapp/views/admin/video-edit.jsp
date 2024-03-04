<%@ include file="/common/taglib.jsp"%>

<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Add/Edit Video</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="<c:url value='/admin'/>">Home</a></li>
						<li class="breadcrumb-item active">Add - Edit Video</li>
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
							<h3 class="card-title">Add/Edit Video</h3>

							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse" title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="title">Title</label> <input type="text" id="title"
									value="${video != null ? video.title : ''}"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="href">Href</label> <input type="text" id="href"
									value="${video != null ? video.href : ''}" class="form-control">
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-9">
										<div class="row">
											<div class="col-12 form-group">
												<label for="description">Description</label>
												<textarea id="description" class="form-control" rows="4">${video != null ? video.description : ''}</textarea>
											</div>
											<div class="col-12 form-group">
												<label for="poster">Poster</label> <input type="text"
													id="poster" value="${video != null ? video.poster : ''}"
													class="form-control"> <input type="hidden"
													id="isEdit" value="${isEdit}" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-3">
										<label for="inputProjectLeader">Preview</label>
										<div
											style="width: 100%; height: 200px; border: 1px dotted gray">
											<img id="imgPreview"
												src="${video != null ? video.poster : ''}" height="100%"
												width="100%" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row" style="margin: auto auto;">
					<button type="button" id="resetBtn"
						class="btn btn-primary float-right" style="margin-right: 15px;">
						<i class="ion ion-ios-refresh-empty"></i>
						 Reset
					</button>
					<button type="button" id="submitBtn"
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
