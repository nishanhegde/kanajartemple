<%@include file="/WEB-INF/views/tagdefinition.jsp"%>


<html>
<head>
<title>${CMSbean.pagename}</title>
<link rel="icon"
	href="<c:url value="/resources/images/templeicon.png"/>"
	" type="image/x-icon">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="mainbody">${CMSbean.content}</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>