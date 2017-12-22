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
	height: 1.6in;
	text-align: center;
	border: 2px;
	border-style: solid;
	width: 1.8in;
	float: left;
	margin: 5px;
}

.coupon .number {
	font: 22px/1.4 Georgia, serif;
	font-weight: bold;
}

.coupon .title {
	font: 14px/1.4 Georgia, serif;
}

.text {
	margin-top: 50px;
}
</style>
</head>
<body>
	<div id="page-wrap">
		<c:forEach var="i" begin="${coupon.noFrom}" end="${coupon.noTo}">
			<div class="coupon">
				<div class="text">
					<span class="number">${i}</span><br /> <span class="title">${coupon.title}</span>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>