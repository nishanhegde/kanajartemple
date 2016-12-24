<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<c:url value="/SuperAdmin/resetadminpassword" var="url" />
		${message}
		<form:form action="${url}" commandName="changePassword" method="post">
			<table cellspacing="10" cellpadding="10">
				<tr>
					<th><spring:message code="label.admin" /> *</th>
					<td><select name="admin">

							<c:forEach items="${admins}" var="admin">
								<option value="${admin.id}">${admin.fullname}</option>
							</c:forEach>
					</select>
				</tr>
				<tr>
					<th><spring:message code="label.new.password" /></th>
					<th><core:bind path="changePassword.newpassword">
							<div class="error">${status.errorMessage}</div>
							<input type="password" class="textbox" required
								name="newpassword" />
						</core:bind></th>

				</tr>

				<tr>
					<th><spring:message code="label.confirm.password" /></th>
					<td><core:bind path="changePassword.confirmpassword">
							<div class="error">${status.errorMessage}</div>
							<input type="password" class="textbox" required
								name="confirmpassword" />
						</core:bind></td>
				</tr>


				<tr>
					<th></th>
					<td><input type="submit"
						value="<spring:message code="label.reset" />" class="button" /></td>
				</tr>

			</table>
		</form:form>
	</center>
</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>

