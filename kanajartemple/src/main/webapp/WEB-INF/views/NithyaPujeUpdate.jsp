
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />

<div class="colorboxbody">
	<c:url value="#" var="url" />
	<form:form action="${url}" commandName="sashwathaPoojebean"
		method="post">


		<table>

			<tr>
				<th><spring:message code="label.recno" /></th>
				<td><form:input path="recNo" readonly="true" /></td>
			</tr>

			<tr>
				<th><spring:message code="label.name" /> *</th>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<th><spring:message code="label.address" /> *</th>
				<th><form:textarea path="address" /></th>

			</tr>
			<tr>
				<th><spring:message code="label.poojedate" /> *</th>
				<td><form:input path="pdate" readonly="true" /></td>
			</tr>

			<tr>
				<th><spring:message code="label.mobileno" /></th>
				<th><core:bind path="sashwathaPoojebean.MobileNo">
						<div class="error">${status.errorMessage}</div>
						<input type="number" value='${status.value}' name="MobileNo"
							id="mobile" />
					</core:bind></th>
			</tr>
			<tr>
				<th><spring:message code="label.email" /></th>
				<th><core:bind path="sashwathaPoojebean.Email">
						<div class="error">${status.errorMessage}</div>
						<input name="Email" value='${status.value}' id="Email"
							type="email" />
					</core:bind></th>
			</tr>


			<tr>
				<th></th>
				<td><input type="submit"
					value="<spring:message code="label.update" /> " /></td>
			</tr>

		</table>
	</form:form>
</div>
