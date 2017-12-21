<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/tagdefinition.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.title" /></title>
<link rel="icon"
	href="<c:url value="/resources/images/templeicon.png"/>"
	type="image/x-icon">

<script type="text/javascript"
	src="<c:url value="/resources/js/admin/admin.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/admin/reveal.css"/>" type="text/css" />

<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery-1.6.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery.reveal.js"/>"></script>

<script>
$(document).ready(function () {
	$('.adminmenu').addClass('original').clone().insertAfter('.adminmenu').addClass('cloned').css('position','fixed').css('top','0').css('margin-top','0').css('z-index','500').removeClass('original').hide();
	scrollIntervalID = setInterval(stickIt, 10);
	stickIt()
});
</script>

</head>
<body>
	<jsp:include page="kannadalanguage.jsp"></jsp:include>


	<div class="header">
		<h6>
			<spring:message code="label.title" />
		</h6>
	</div>



	<div class="adminmenu">
		<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
			<c:url value="/Admin/home" var="homeurl" />
			<div class="homeicon">
				<a href="${homeurl}"><img
					src="<c:url value="/resources/images/home.png"/>" /></a>
			</div>

			<div class="logout">
				<a href="<c:url value="/j_spring_security_logout" />"><img
					src="<c:url value="/resources/images/logout.jpg"/>" /></a>
			</div>

			<div class="welname">
				<spring:message code="label.welcome" />
				: <span style="color: white;"><%=session.getAttribute("FullName")%></span>
			</div>
		</sec:authorize>

		<div class="welname">
			<spring:message code="label.language" />
			:<span class="lang"> <a href="?lang=en"
				onclick="changeLang(':english');">English</a> | <a href="?lang=kn"
				onclick="changeLang('pramukhindic:kannada');">ಕನ್ನಡ</a></span>
		</div>
	</div>