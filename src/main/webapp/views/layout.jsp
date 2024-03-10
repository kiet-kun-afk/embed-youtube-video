<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<title>MANAGEMENT</title>
			<link rel="icon" href="/templates/user/img/home.png" type="image/x-icon">
			<%@ include file="/common/admin/head.jsp" %>
		</head>

		<body class="hold-transition sidebar-mini layout-fixed">
			<div class="wrapper">
				<%@ include file="/common/admin/header.jsp" %>

					<jsp:include page="${layout}"></jsp:include>

					<%@ include file="/common/admin/footer.jsp" %>
			</div>
			<%@ include file="/common/admin/bottoms.jsp" %>
		</body>
		<script src="<c:url value='/templates/user/js/admin.js'/>"></script>

		</html>