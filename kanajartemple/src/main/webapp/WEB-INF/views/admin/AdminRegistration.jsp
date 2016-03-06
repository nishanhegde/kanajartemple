<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
	
	<div class="mainbody">
		<a href="login">Back</a>
		<center>
			<c:url value="/RegistrationSuccess" var="url" />
			<form:form commandName="Register" action="${url}" required=""
				name="Register" method="post" class="form" id="Register">
				<table>
					<tr>
						<th><spring:message code="label.name" /></th>
						<td><core:bind path="Register.fullName">
								<div class="error">${status.errorMessage}</div>
								<input type="text" placeholder="<spring:message code="label.name" />" onfocus="enable('fullName')" required
									name="fullName" id="fullName" value='${status.value}' />
							</core:bind></td>
					</tr>
					<tr>
						<th><spring:message code="label.password" /> *</th>
						<td><core:bind path="Register.password">
								<div class="error">${status.errorMessage}</div>
								<input type="password" placeholder="<spring:message code="label.password" />" required
									name="password" />
							</core:bind></td>
					</tr>
					<tr>
						<th><spring:message code="label.confirm.password" />*</th>
						<td><core:bind path="Register.confirmPassword">
								<div class="error">${status.errorMessage}</div>
								<input type="password" placeholder="<spring:message code="label.confirm.password" />" required
									class="passbox" name="confirmPassword" />
							</core:bind></td>
					</tr>
					<tr>
						<th><spring:message code="label.email" />*</th>
						<td><core:bind path="Register.emailId">
								<div class="error">${status.errorMessage}</div>
								<input type="email" placeholder="<spring:message code="label.email" />" required
									name="emailId" value='${status.value}' />
							</core:bind></td>
					</tr>
					<tr>
						<th><spring:message code="label.mobileno" />*</th>
						<td><core:bind path="Register.phoneNumber">
								<div class="error">${status.errorMessage}</div>
								<input type="number" placeholder="<spring:message code="label.mobileno" />" required
									name="phoneNumber" value='${status.value}' />
							</core:bind></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="<spring:message code="label.submit" />" class="button" /></td>
					</tr>
				</table>
			</form:form>
	</div>

	</center>

	<jsp:include page="Adminfooter.jsp"></jsp:include>

