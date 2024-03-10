<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>VIDEOS</title>
			<link rel="icon" href="/templates/user/img/home.png" type="image/x-icon">
			<%@ include file="/common/head.jsp" %>
		</head>

		<body>
			<%@ include file="/common/header.jsp" %>

				<jsp:include page="${view}" />

				<%@ include file="/common/footer.jsp" %>
					<script>
						<c:if test="${not empty change_pass}">
							alert("${change_pass}");
						</c:if>
						<c:if test="${not empty share_video}">
							alert("${share_video}");
						</c:if>
					</script>
		</body>

		</html>