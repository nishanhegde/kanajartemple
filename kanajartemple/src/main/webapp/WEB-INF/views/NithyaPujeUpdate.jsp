
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>


<link rel="stylesheet"
	href="<c:url value="/resources/css/colorbox.css"/>" />

<div class="colorboxbody">
	<div class="success">${message}</div>
	<c:url value="/NithyaPooje/update" var="url" />
	<form:form action="${url}" commandName="sashwathaPoojebean"
		method="post">


		<table>

			<tr>
				<th><spring:message code="label.recno" /></th>
				<td><core:bind path="sashwathaPoojebean.RecNo">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="RecNo" id="RecNo" value='${status.value}'
							readonly="readonly" />
					</core:bind></td>
			</tr>

			<tr>
				<th><spring:message code="label.name" /></th>
				<td><core:bind path="sashwathaPoojebean.Name">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Name" id="Name" value='${status.value}'
							required />
					</core:bind></td>
			</tr>

			<tr>
				<th><spring:message code="label.address" /></th>
				<th><core:bind path="sashwathaPoojebean.Address">
						<div class="error">${status.errorMessage}</div>
						<textarea name="Address" rows="5" cols="22" id="Address" required>${status.value}</textarea>
					</core:bind></th>
			</tr>
			<tr>
				<th><spring:message code="label.poojedate" /></th>
				<th><core:bind path="sashwathaPoojebean.Pdate">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Pdate" id="date" value='${status.value}'
							readonly="readonly" />
					</core:bind></th>
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
