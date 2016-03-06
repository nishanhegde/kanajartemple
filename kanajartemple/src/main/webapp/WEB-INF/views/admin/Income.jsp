<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<h1>
			<spring:message code="label.income" />
		</h1>
		<c:url value="../Admin/AddIncomeSuccess" var="url" />
		<form:form action="${url}" commandName="income" method="post" target="_blank">
			<span class="invalid">${message}</span>
			<table >

				<tr>
					<th><spring:message code="label.income.title" /></th>
					<td><core:bind path="income.title">
							<div class="error">${status.errorMessage}</div>
							<input type="text" name="title" onfocus="enable('title')"
								id="title" required  value='${status.value}' />
						</core:bind></td>
				</tr>
				<tr>
					<th><spring:message code="label.amount" /></th>
					<td><core:bind path="income.Amount">
							<div class="error">${status.errorMessage}</div><input
						type="number" name="Amount" required  value='${status.value}' placeholder="&#8377"/></core:bind></td>
				</tr>


				<tr>
					<th><spring:message code="label.date" /></th>
					<td><core:bind path="income.Edate">
							<div class="error">${status.errorMessage}</div><input type="text" id="date"
						name="Edate" id="date" class="tcal" required  value='${status.value}'/></core:bind></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit"
						value="<spring:message code="label.submit" /> " /><input type="reset"
						value="<spring:message code="label.clear" /> " /></td>
				</tr>

			</table>
		</form:form>


	</center>

</div>

<jsp:include page="Adminfooter.jsp"></jsp:include>
