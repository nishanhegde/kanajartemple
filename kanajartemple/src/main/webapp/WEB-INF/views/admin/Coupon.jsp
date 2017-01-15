<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/tagdefinition.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css'
	href='<c:url value="/resources/css/admin/print.css"/>' media="print" />
<link rel='stylesheet' type='text/css'
	href='<c:url value="/resources/css/admin/reciept.css"/>' />

<style type="text/css">

.coupon {
	font: 16px/1.4 Georgia, serif;
	height: 1.8in;
	text-align: center;
	border: 2px;
	border-style: solid;
	width: 1.8in;
	flOat:left;
	margin:5px;
	
}
.text
{
margin-top: 60px;
}

</style>
</head>
<body >
<div id="page-wrap">
<c:forEach var="i" begin="${coupon.noFrom}" end="${coupon.noTo}">
	<div class="coupon">
	<div class="text">${i}<br/>
	${coupon.title}</div>
	</div>
</c:forEach>
	
</div>
</body>
</html>