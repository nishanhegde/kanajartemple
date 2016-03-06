<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="kannadalanguage.jsp"></jsp:include>
<div class="mainbody">
	<c:url value="/Admin/UpdateExpense" var="url" />
	<form:form action="${url}" commandName="expense" method="post">

		<table>
			<tr>
				<th><spring:message code="label.income.title" /></th>
				<td><div class="success">${message}</div>
					<core:bind path="expense.Title">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Title" onfocus="enable('Title')"
							id="Title" value="${Data.title}" required />
						<input type="hidden" name="RecNo" value="${Data.recNo}" />
					</core:bind></td>
			</tr>
			<tr>
				<th><spring:message code="label.expense.description" /></th>
				<th><core:bind path="expense.Description">
						<div class="error">${status.errorMessage}</div>
						<textarea name="Description" onfocus="enable('Description')"
							rows="5" cols="22" id="Description" required>${Data.description}</textarea>
					</core:bind></th>

			</tr>
			<tr>
				<th><spring:message code="label.amount" /></th>
				<td><core:bind path="expense.Amount">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Amount" value="${Data.amount}" required />
					</core:bind></td>
			</tr>

			<tr>
				<th><spring:message code="label.date" /></th>
				<td><core:bind path="expense.EDate">
						<div class="error">${status.errorMessage}</div>
						<input type="text" id="date" name="EDate" id="date" class="tcal"
							value="${Data.EDate}" required />
					</core:bind></td>
			</tr>


			<tr>
				<th></th>
				<td><input type="submit"
					value="<spring:message code="label.update" /> " /></td>
			</tr>

		</table>
	</form:form>
</div>