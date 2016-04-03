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
		<form:form  commandName="incomeData" method="post"
			target="_blank">
			<span class="invalid">${message}</span>
			<table>
				<tr>
					<th><spring:message code="label.income.name" /> *</th>
					<td><select name="Iid">
							<c:forEach items="${IncomeDetails}" var="income">
								<option value="${income.Iid}">${income.IncomeName}</option>
							</c:forEach>
					</select>
				</tr>
				<tr>
					<th><spring:message code="label.income.title" /></th>
					<td><core:bind path="incomeData.title">
							<div class="error">${status.errorMessage}</div>
							<input type="text" name="title" onfocus="enable('title')"
								id="title" required value='${status.value}' />
						</core:bind></td>
				</tr>
				<tr>
					<th><spring:message code="label.amount" /></th>
					<td><core:bind path="incomeData.Amount">
							<div class="error">${status.errorMessage}</div>
							<input type="number" name="Amount" required
								value='${status.value}' placeholder="&#8377" />
						</core:bind></td>
				</tr>


				<tr>
					<th><spring:message code="label.date" /></th>
					<td><core:bind path="incomeData.Edate">
							<div class="error">${status.errorMessage}</div>
							<input type="text" id="date" name="Edate" id="date" class="tcal"
								required value='${status.value}' />
						</core:bind></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit"
						value="<spring:message code="label.submit" /> " /><input
						type="reset" value="<spring:message code="label.clear" /> " /></td>
				</tr>

			</table>
		</form:form>


	</center>

</div>

<jsp:include page="Adminfooter.jsp"></jsp:include>
