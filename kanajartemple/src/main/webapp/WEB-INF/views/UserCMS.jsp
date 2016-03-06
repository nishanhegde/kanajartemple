<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
	<title>Home</title>
 <link rel="icon" href="<c:url value="/resources/images/templeicon.png"/>"" type="image/x-icon">
	  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="mainbody"> 
<c:forEach items="${CMScontent}"  var="cont">
  ${cont.Content}
        </c:forEach>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>