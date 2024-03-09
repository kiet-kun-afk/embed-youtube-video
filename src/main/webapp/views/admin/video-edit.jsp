<%@ include file="/common/taglib.jsp" %>

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

		<section class="content">
			<div class="container-fluid">
				<form method="post" class="was-validated" <c:choose>
					<c:when test='${isEdit}'>action="/admin/video/update?oldHref=${video.href}"</c:when>
					<c:otherwise>action="/admin/video/new"</c:otherwise>
					</c:choose> >
					<div class="row">
						<div class="col-md-12">
							<div class="card card-secondary">
								<div class="card-header">
									<h3 class="card-title">Add/Edit Video</h3>

									<div class="card-tools">
										<button type="button" class="btn btn-tool" data-card-widget="collapse"
											title="Collapse">
											<i class="fas fa-minus"></i>
										</button>
									</div>
								</div>
								<div class="card-body">
									<div class="form-group">
										<label for="title">Title</label> <input type="text" id="title" name="title"
											placeholder="Title" required value="${video != null ? video.title : ''}"
											class="form-control">
									</div>
									<div class="form-group">
										<label for="href">Href</label> <input type="text" id="href" name="href"
											placeholder="Href" required value="${video != null ? video.href : ''}"
											class="form-control">
									</div>
									<div class="form-group">
										<label for="youtube_link">Youtube link</label> <input type="text"
											id="youtube_link" name="youtube_link" placeholder="Youtube link" required
											class="form-control" <c:choose>
										<c:when test='${isEdit}'>value="https://www.youtube.com/watch?v=${video.href}"
										</c:when>
										<c:otherwise></c:otherwise>
										</c:choose>
										>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-9">
												<div class="row">
													<div class="col-12 form-group">
														<label for="description">Description</label>
														<textarea id="description" class="form-control"
															name="description" placeholder="Description"
															rows="4">${video != null ? video.description : ''}</textarea>
													</div>
													<div class="col-12 form-group">
														<input type="hidden" id="isEdit" value="${isEdit}"
															class="form-control">
													</div>
												</div>
											</div>
											<div class="col-3">
												<label for="inputProjectLeader">Preview</label>
												<div style="width: 100%; height: 200px; border: 1px dotted gray">
													<img id="imgPreview"
														src="https://img.youtube.com/vi/${video != null ? video.href : ''}/maxresdefault.jpg"
														height="100%" width="100%" />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row" style="margin: auto auto;">
							<button type="button" id="resetBtn" class="btn btn-primary float-right"
								style="margin-right: 15px;">
								<i class="ion ion-ios-refresh-empty"></i>
								Reset
							</button>
							<button type="submit" id="submitBtn" class="btn btn-primary float-right">
								<i class="fas fa-save"></i>
								Submit
							</button>
						</div>
						<div>
							<h5 class="danger">${error}</h5>
						</div>
					</div>
				</form>
			</div>
		</section>
		<br />
		<br />
	</div>