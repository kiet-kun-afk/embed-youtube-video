	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

	<div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-12">${video.title}</h2>
        </div>
        <div class="row tm-mb-90">            
            <div class="col-xl-8 col-lg-7 col-md-6 col-sm-12">
			<iframe id="tm-video"
				src="https://www.youtube.com/embed/${video.href}?autoplay=1"
				style="height: 650px"
				allow="autoplay; encrypted-media"></iframe>
			<div class="tm-bg-gray tm-video-details mt-3" style="max-height: 500px; overflow: hidden; overflow-wrap: break-word;">
			    	<c:if test="${not empty sessionScope.currentUser}">
			    		<div class="d-flex">
				       		<div class="mb-5 p-2">
				            	<button id="likeOrUnlikeBtn" class="btn btn-secondary">
			                		<c:choose>
				                		<c:when test="${flagLikedBtn == true}">
				                			<i class="fas fa-times-circle"></i> Unlike
				                		</c:when>
				                		<c:otherwise><i class="far fa-heart"></i> Like</c:otherwise>
				                	</c:choose>
				                </button>
				            </div>
				            <div class="mb-5 p-2">
				                <button class="btn btn-secondary" data-toggle="modal" data-target="#shareModal"><i class="fas fa-paperclip"></i> Share</button>
				            </div>
				    		</div>
		       		</c:if>
		           	<div class="mb-4">
		               <h3 class="tm-text-gray-dark mb-3">Description</h3>
		               <p>${video.description}</p>
		           	</div>
		           	<input id="videoIdHdn" type="hidden" value="${video.href}">
		       	</div>
            </div>
            <div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
                <div class="row tm-mb-90 tm-gallery">
					<c:forEach items="${videos.content}" var="item">
						<div class="col-12 mb-5">
							<figure class="effect-ming tm-video-item">
								<img src="${item.poster}" alt="Image" class="img-fluid w-100">
								<figcaption class="d-flex align-items-center justify-content-center">
									<h2 style="overflow: hidden;">${item.title}</h2>
									<a href="<c:url value='/video/watch?p=${item.href}'/>"></a>
								</figcaption>
							</figure>
						</div>
					</c:forEach>
				</div>
            </div>
        </div>
	</div>
<div class="modal fade" id="shareModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form action="./share" method="post" class="was-validated">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Share</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="email" name="recipient" id="recipient" class="form-control rounded-0" placeholder="E-mail recipient?" required />
        </div>
       	<input type="hidden" name="p" class="form-control rounded-0" value="${video.href }"/>
        <h5 class="text-danger" id="messageShare"></h5>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-warning">Send</button>
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
      </div>
      </form>
    </div>
  </div>
</div>