<%@ include file="/common/taglib.jsp"%>
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<div class="d-flex justify-content-end align-items-center">
				<form action="" class="text-warning">
					Page <span class="">${videos.number + 1}</span> of ${videos.totalPages}
				</form>
			</div>
		</div>
		<div class="row tm-mb-90 tm-gallery">
			<c:forEach items="${videos.content}" var="video">
				<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
					<h5 class="" style="white-space: nowrap; overflow: hidden;">
						${video.title}
					</h5>
					<figure class="effect-ming tm-video-item">
						<img src="${video.poster}" alt="Image" class="img-fluid">
						<figcaption class="d-flex align-items-center justify-content-center">
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
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  	<li class="page-item ${videos.number == 0 ?'disabled':''}">
		      <a href="/index?page=0" class="page-link">First</a>
			</li>
			<li class="page-item ${videos.number == 0 ?'disabled':''}">
			  <a href="/index?page=${videos.number-1 }" class="page-link">&laquo;</a>
			</li>
			<c:forEach varStatus="i" begin="1" end="${videos.totalPages }">
				<li class="page-item ${videos.number == i.index - 1 ? 'active' : ''}">
					<a href="/index?page=${i.index - 1}" class="page-link">${i.index}</a>
				</li>
			</c:forEach>
			<li class="page-item ${videos.number == videos.totalPages-1 ?'disabled':''} ${videos.totalPages == 0 ?'disabled':''}">
			  <a class="page-link" href="/index?page=${videos.number+1 }">&raquo;</a>
			</li>
			<li class="page-item ${videos.number == videos.totalPages-1 ?'disabled':''} ${videos.totalPages == 0 ?'disabled':''}">
		 		  <a href="/index?page=${videos.totalPages-1 }" class="page-link">Last</a>
		    </li>
		  </ul>
		</nav>
		
	</div>