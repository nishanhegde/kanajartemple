<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<c:url value="/Admin/EditProfileSuccess" var="url" />
<div class="error">${message}</div>
		<form:form commandName="Register" action="${url}" required=""
				name="Register" method="post" class="form" id="Register">
			<table>
				<tr>
					<th><spring:message code="label.name" /></th>
					<td>
						<core:bind path="Register.fullName">
								<div class="error">${status.errorMessage}</div>
							<input type="hidden" name="id" value="${Data.id}" />
							<input type="text" placeholder="FullName"
								onfocus="enable('fullName')" id="fullName" class="textbox"
								name="fullName" value='${Data.fullName}' />
						</core:bind></td>
				</tr>
				<tr>
					<th><spring:message code="label.email" /></th>
					<th><core:bind path="Register.emailId">
							<div class="error">${status.errorMessage}</div>
							<input type="email" placeholder="Email Address" class="textbox"
								required name="emailId" value='${Data.emailId}' />
						</core:bind></th>

				</tr>

				<tr>
					<th><spring:message code="label.mobileno" /></th>
					<td><core:bind path="Register.phoneNumber">
							<div class="error">${status.errorMessage}</div>
							<input type="number" placeholder="Phone Number" class="textbox"
								required name="phoneNumber" value='${Data.phoneNumber}' />
						</core:bind></td>
				</tr>


				<tr>
					<th></th>
					<td><input type="submit"
						value="<spring:message code="label.update" />" class="button" /></td>
				</tr>

			</table>
		</form:form>
	</center>
</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>

