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
.addressbox {
	height: 1in;
	text-align: left;
	border: 1px;
	border-style: solid;
	width: 3.6in;
	float: left;
	padding: 3px;
	margin: 4px;
}

.addressbox .name {
	font: 16px/1.4 Georgia, serif;
	font-weight: bold;
}

.addressbox .adress {
	font: 14px/1.4 Georgia, serif;
}
</style>
</head>
<body>
	<div id="page-wrap">
		<c:forEach items="${PoojeDetails}" var="pooje">
			<div class="addressbox">

				<span class="name">${pooje.name}</span><br /> <span class="address">${pooje.address}</span>

			</div>
		</c:forEach>

	</div>
</body>
</html>