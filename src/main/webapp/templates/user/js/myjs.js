$(window).on("load", function() {
	$('body').addClass('loaded');
});
$('#likeOrUnlikeBtn').click(function() {
	var videoId = $('#videoIdHdn').val();
	$.ajax({
		url: './like?p=' + videoId
	}).then(function() {
		var text = $('#likeOrUnlikeBtn').text();
		if (text.indexOf('Like') != -1) {
			$('#likeOrUnlikeBtn').text('Unlike');
		} else {
			$('#likeOrUnlikeBtn').text('Like');
		}
	}).fail(function() {
		alert('Oops!!! Please try again ^^');
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