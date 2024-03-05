<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NEVER STOP GIVING UP</title>
<%@ include file="/common/head.jsp"%>
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<jsp:include page="${view}"/>

	<%@ include file="/common/footer.jsp"%>
</body>
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
$('#likeOrUnlikeBtn').click(function() {
	var videoId = $('#videoIdHdn').val();
	$.ajax({
		url: './like?p=' + videoId
	}).then(function(data){
		var text = $('#likeOrUnlikeBtn').text();
		if (text.indexOf('Like') != -1) {
			$('#likeOrUnlikeBtn').text('Unlike');
		} else {
			$('#likeOrUnlikeBtn').text('Like');
		}
	}).fail(function(error) {
		alert('Oops!!! Please try again ^^');
	});
});
$('#sendBtn').click(function(){
	$('#messageReturn').text('');
	var email = $('#email').val();
	var formData = {'email': email};
	$.ajax({
		url: 'forgotPass',
		type: 'POST',
		data: formData
	}).then(function(data){
		$('#messageReturn').text('Password has been reset, please check your email');
		setTimeout(function(){
			window.location.href = 'http://localhost:8080/index';
		}, 5 * 1000)
	}).fail(function(error){
		$('#messageReturn').text('Your information is not correct, try again');
	});
});
$('#shareBtn').click(function(){
	$('#messageShare').text('');
	var videoId = $('#videoIdHdn').val();
	var recipient = $('#recipient').val();
	var formData = {'recipient': recipient};
	$.ajax({
		url: './share?p=' + videoId,
		data: formData
	}).then(function(data){
		$('#messageShare').text('Successfully share');
	}).fail(function(error){
		$('#messageShare').text('Fail share');
	});
});
(() => {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false)
	  })
	})()
</script>
</html>