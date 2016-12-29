<%@include file="/WEB-INF/views/tagdefinition.jsp"%>

<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
<jsp:include page="Adminheader.jsp" ></jsp:include>
</sec:authorize>
<sec:authorize  access="!hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
<jsp:include page="../header.jsp" ></jsp:include>
 <jsp:include page="../menu.jsp"></jsp:include>  
</sec:authorize>

<div class="mainbody">
	<br />
	<h1 style="color: red;">Page Not Found</h1>
	<br />

</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
