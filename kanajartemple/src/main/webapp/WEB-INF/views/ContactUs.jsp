<%@include file="/WEB-INF/views/tagdefinition.jsp"%>

<link rel="stylesheet"
	href="<c:url value="/resources/css/colorbox.css"/>" />
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="mainbody">
	<span class="fon16">${CMSbean.pagename}</span>
	<hr />

	<br />

	<div class="contleftbox">${CMSbean.content}</div>


	<div class="floatingleft colorboxbody">

		<form action="<c:url value="/query"/>" method="post">
			<table cellspacing="25">

				<tr>
					<div class="error">${message}</div>
					<th><spring:message code="label.query.name"/></th>
					<th><input type="text" name="name" id="name" required /></th>
				</tr>

				<tr>
					<th><spring:message code="label.query.email"/></th>
					<th><input name="email" type="text" required id="email1" /></th>

				</tr>

				<tr>
					<th><spring:message code="label.query.yourquery"/></th>
					<th><textarea name="query" rows="3" cols="22" id="query"
							required></textarea></th>
				</tr>
				<tr>
					<th></th>
					<th><input type="submit" name="Register" value='<spring:message code="label.submit"/>'
						style="width: 100px" /></th>
				</tr>
			</table>

		</form>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
