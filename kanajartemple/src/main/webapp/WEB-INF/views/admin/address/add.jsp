<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="../kannadalanguage.jsp"></jsp:include>
<div class="mainbody">


	<form:form action="" commandName="address" method="post">
		<table>
			<tr>
				<th><spring:message code="label.name" /> *</th>
				<td><div class="success">${message}</div><core:bind path="address.fullname">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="fullname" id="fullname"
							onfocus="enable('fullname')" required value='${status.value}' />
					</core:bind></td>
			</tr>
			<tr>
			<th><spring:message code="label.address" /> *</th>
			<th><core:bind path="address.address">
					<div class="error">${status.errorMessage}</div>
					<textarea name="address" rows="5" cols="22" id="address"
						onfocus="enable('address')" required>${status.value}</textarea>
				</core:bind></th>

			</tr>

			<tr>
				<th><spring:message code="label.mobileno" /></th>
				<th><core:bind path="address.mobile">
						<div class="error">${status.errorMessage}</div>
						<input type="number" name="mobile" id="mobile"
							value='${status.value}' />
					</core:bind></th>
			</tr>
			<tr>
				<th><spring:message code="label.email" /></th>
				<th><core:bind path="address.email">
						<div class="error">${status.errorMessage}</div>
						<input name="email" id="email" type="email"
							value='${status.value}' />
					</core:bind></th>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" 
					value="<spring:message code="label.submit" /> " /><input
					type="reset" value="<spring:message code="label.clear" />" /></td>
			</tr>

		</table>
	</form:form>

</div>
