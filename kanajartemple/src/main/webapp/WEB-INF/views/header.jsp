<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.title" /></title>
<link rel="icon"
	href="<c:url value="/resources/images/templeicon.png"/>"
	type="image/x-icon">
</head>


<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
<div class="header">
	<h6>
		<spring:message code="label.title" />
	</h6>
</div>
<div class="welname">
	<spring:message code="label.language" />
	:<span class="lang"> <a href="?lang=en"
		onclick="changeLang(':english');">English</a> | <a href="?lang=kn"
		onclick="changeLang('pramukhindic:kannada');">ಕನ್ನಡ</a></span>
</div>