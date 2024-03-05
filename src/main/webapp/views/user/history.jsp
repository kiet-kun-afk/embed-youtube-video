	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-6 text-danger">List History</h2>
		</div>
		<div class="row tm-mb-90 tm-gallery">
			<c:forEach items="${videos}" var="video">
				<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
					<h5 class="text-secondary" style="white-space: nowrap; overflow: hidden;">
						${video.title}
					</h5>
					<figure class="effect-ming tm-video-item">
						<img src="${video.poster}"
							alt="Image" class="img-fluid">
						<figcaption
							class="d-flex align-items-center justify-content-center">
							<h2>View more</h2>
							<a href="<c:url value='/video/watch?p=${video.href}'/>">View more</a>
						</figcaption>
					</figure>
					<div class="d-flex justify-content-between tm-text-gray">
						<span class="tm-text-gray-light">${video.shares} shares</span>
						<span>${video.views} views</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>