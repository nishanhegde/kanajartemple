<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<br />

	<center>
		<h1><spring:message code="label.reject.admin" /></h1>
	</center>


	<jsp:include page="AdminPaginationheader.jsp"></jsp:include>





	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th><spring:message code="label.id" /></th>
					<th><spring:message code="label.name" /></th>

					
					<th><spring:message code="label.reject" /></th>
					
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(Admins) > 0}">
					<c:forEach items="${Admins}" var="app">

						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.id}</p>

							</td>
							<td><p class="desc">${app.FullName}</td>

							
							<td class="td-block">

								<p>
									<a href="<c:url value="/SuperAdmin/Reject/${app.id}"/>"><spring:message code="label.reject" /></a>
								</p>

							</td>
							

						</tr>




					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="AdminPaginationfooter.jsp"></jsp:include>







</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
