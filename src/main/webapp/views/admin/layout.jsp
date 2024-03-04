<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manager</title>
<%@ include file="/common/admin/head.jsp"%>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<%@ include file="/common/admin/header.jsp"%>

		<jsp:include page="${layout}"></jsp:include>

		<%@ include file="/common/admin/footer.jsp"%>
	</div>
	<%@ include file="/common/admin/bottoms.jsp"%>
</body>
<script>
	$(function() {
		$("#example1").DataTable({
			"responsive" : true,
			"lengthChange" : false,
			"autoWidth" : false,
			"buttons" : [ "copy", "csv", "excel", "pdf", "print", "colvis" ]
		}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
		$('#example2').DataTable({
			"paging" : true,
			"lengthChange" : false,
			"searching" : false,
			"ordering" : true,
			"info" : true,
			"autoWidth" : false,
			"responsive" : true,
		});
	});

	$('#selectVideo').change(function() {
		var videoHref = $(this).val();
		$.ajax({
			url : 'admin/favorites?href=' + videoHref,
			type : 'GET',
			contentType : 'application/json'
		}).done(function(data) {
			$('#example2').DataTable({
				destroy : true,
				"paging" : true,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false,
				"responsive" : true,
				"aaData" : data,
				"columns" : [ {
					"data" : "username"
				}, {
					"data" : "email"
				} ]
			});
		}).fail(function(error) {
			$('#example2').dataTable().fnClearTable();
		})
	})
</script>
<script>
	var titleOrigin, hrefOrigin, descriptionOrigin, posterOrigin;
	$(document).ready(function() {
		titleOrigin = $('#title').val();
		hrefOrigin = $('#href').val();
		descriptionOrigin = $('#description').val();
		posterOrigin = $('#poster').val();
	});
	$('#resetBtn').click(function() {
		$('#title').val(titleOrigin);
		$('#href').val(hrefOrigin);
		$('#description').val(descriptionOrigin);
		$('#poster').val(posterOrigin);
		if (posterOrigin.length > 0) {
			$('#imgPreview').attr('src', posterOrigin);
		}
	});
	$('#submitBtn').click(function() {
		$('#message').text('');
		var url;
		var isEdit = $('#isEdit').val();
		if (isEdit == 'true') {
			url = '/asm-java4/admin/video?action=edit&href='
					+ hrefOrigin;
		} else {
			url = '/asm-java4/admin/video?action=add';
		}

		var formData = {
			'hrefOrigin' : hrefOrigin,
			'title' : $('#title').val(),
			'description' : $('#description').val(),
			'newHref' : $('#href').val(),
			'poster' : $('#poster').val()
		};

		$.ajax({
			url : url,
			type : 'POST',
			data : formData
		})
		.then(function() {
			window.location.href = "http://localhost:8080/asm-java4/admin/video?action=view";
		}).fail(function() {
			$('#message').text('Opps! Please try again!');
		});
	});

	$('#poster').change(function() {
		var newSrc = $('#poster').val();
		$('#imgPreview').attr('src', newSrc);
	})
</script>
<script>
	var usernameOrigin, passwordOrigin, emailOrigin, isadminOrigin;
	$(document).ready(function() {
		usernameOrigin = $('#username').val();
		passwordOrigin = $('#password').val();
		emailOrigin = $('#email').val();
		isadminOrigin = $('input[name="isadmin"]:checked').val();
	});
	$('#resetUserBtn').click(function() {
		$('#username').val(usernameOrigin);
		$('#password').val(passwordOrigin);
		$('#email').val(emailOrigin);
		$('#isadmin').val(isadminOrigin);
	});
	$('#submitUserBtn').click(function() {
		$('#message').text('');
		var url;
		var isEdit = $('#isEdit').val();
		if (isEdit == 'true') {
			url = '/asm-java4/admin/user?action=edit&username='
					+ usernameOrigin;
		} else {
			url = '/asm-java4/admin/user?action=add';
		}

		var formData = {
			'usernameOrigin' : usernameOrigin,
			'password' : $('#password').val(),
			'email' : $('#email').val(),
			'newUsername' : $('#username').val(),
			'isadmin' : $('input[name="isadmin"]:checked').val()
		};

		$.ajax({
			url : url,
			type : 'POST',
			data : formData
		}).then(function() {
			window.location.href = "http://localhost:8080/asm-java4/admin/user?action=view";
		}).fail(function() {
			$('#message').text('Opps! Please try again!');
		});
	});
</script>
<script>
	function deleteVideo(href) {
		$.ajax({
			url : '/asm-java4/admin/video?action=delete&href=' + href
		}).then(function() {
			window.location.href = "http://localhost:8080/asm-java4/admin/video?action=view";
		}).fail(function() {
			alert("Oops! error.");
		});
	};
</script>
<script>
	function deleteUser(username) {
		$.ajax({
			url : '/asm-java4/admin/user?action=delete&username=' + username
		}).then(function() {
			window.location.href = "http://localhost:8080/asm-java4/admin/user?action=view";
		}).fail(function() {
			alert("Oops! error.");
		});
	};
</script>
</html>
