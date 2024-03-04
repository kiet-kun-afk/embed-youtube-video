<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
	<div class="container-fluid tm-container-small">
		<div class="row">
			<div class="col-12 px-5">
				<h3 class="mb-4 tm-footer-title">About ONLINE ENTERTAINMENT</h3>
				<p class="text-dark">
					ONLINE ENTERTAINMENT is a video streaming web site that uses the embed Youtube video.
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-12 px-5 mb-3">Copyright 2023 ONLINE ENTERTAINMENT. No copyright.</div>
		</div>
	</div>
</footer>

<script src="<c:url value='/templates/user/js/plugins.js'/>"></script>
<script>
	$(window).on("load", function() {
		$('body').addClass('loaded');
	});
	$('#changePassBtn').click(function(){
		$('#messageChangePass').text('');
		var currentPass = $('#currentPass').val();
		var newPass = $('#newPass').val();
		var formData = {
				'currentPass': currentPass,
				'newPass': newPass
		};
		$.ajax({
			url: 'changePass',
			type: 'POST',
			data: formData
		}).then(function(data){
			$('#messageChangePass').text('Your password has been changed successfully');
		}).fail(function(error){
			$('#messageChangePass').text('Your password is not correct, try again');
		});
	})
</script>