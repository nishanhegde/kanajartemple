<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/admin/tcal.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/tcal.js"/>"></script>

<jsp:include page="../kannadalanguage.jsp"></jsp:include>
<div class="mainbody">
 
 <c:url value="/cash/edit" var="url" />
	<form:form action="${url}" commandName="cashDisbursement" method="post">
		<table>

		
			<tr>
				<th><spring:message code="label.cash.description" /> *</th>
				<td><div class="success">${message}</div>
				<input type="hidden" name="id" value="${cashDisbursement.id}" />
				<core:bind path="cashDisbursement.description">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="description" id="description"
							onfocus="enable('description')" required value='${status.value}' />
					</core:bind></td>
			</tr>

			<tr>
					<th><spring:message code="label.amount" /> *</th>
					<td><core:bind path="cashDisbursement.amount">
							<div class="error">${status.errorMessage}</div>
							<input type="number" name="amount" required
								value='${status.value}' placeholder="&#8377" />
						</core:bind></td>
			</tr>


			<tr>
				<th></th>
				<td><input type="submit"
					value="<spring:message code="label.update" />" /></td>
			</tr>

		</table>
	</form:form>
</div>