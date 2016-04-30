<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="kannadalanguage.jsp"></jsp:include>
<div class="mainbody">
	<c:url value="/Admin/UpdateIncome" var="url" />
	<form:form action="${url}" commandName="incomeData" method="post">
		<table>
			<tr>
				<th><spring:message code="label.income.title" /></th>
				<td><div class="success">${message}</div> <core:bind
						path="incomeData.title">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="title" onfocus="enable('title')"
							id="title" value="${Data.title}" required />
						<input type="hidden" name="RecNo" value="${Data.recNo}" />
						<input type="hidden" name="Iid" value="${Data.iid}" />
					</core:bind></td>
			</tr>
			<tr>
			<tr>
				<th><spring:message code="label.amount" /></th>
				<td><core:bind path="incomeData.Amount">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Amount" value="${Data.amount}" required />
					</core:bind></td>
			</tr>

			<tr>
				<th><spring:message code="label.date" /></th>
				<td><core:bind path="incomeData.Edate">
						<div class="error">${status.errorMessage}</div>
						<input type="text" id="date" name="Edate" id="date" class="tcal"
							value="${Data.edate}" required />
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
