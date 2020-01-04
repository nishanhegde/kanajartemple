<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="../Adminheader.jsp"></jsp:include>
<div class="mainbody">
<center>
	<form:form action="" commandName="cashDisbursement" method="post">
		<table>
			<tr>
				<th><spring:message code="label.cash.description" /> *</th>
				<td><div class="success">${message}</div><core:bind path="cashDisbursement.description">
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
					value="<spring:message code="label.submit" /> " /><input
					type="reset" value="<spring:message code="label.clear" />" /></td>
			</tr>

		</table>
	</form:form>
</center>
</div>
<jsp:include page="../Adminfooter.jsp"></jsp:include>
