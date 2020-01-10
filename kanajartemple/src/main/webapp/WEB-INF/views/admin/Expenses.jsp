<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>


<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery-1.6.min.js"/>"></script>	
	<script type="text/javascript"
	src="<c:url value="/resources/js/admin/bank.js"/>"></script>	
<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<h1>
			<spring:message code="label.expense" />
		</h1>

		<form:form commandName="expenseData" method="post" target="_blank">

			<table>
				<tr>
					<th><spring:message code="label.expense.name" /> *</th>
					<td><select name="Eid">
							<c:forEach items="${ExpenseDetails}" var="expense">
								<option value="${expense.Eid}">${expense.ExpenditureName}</option>
							</c:forEach>
					</select>
				</tr>
				<tr>
					<th><spring:message code="label.income.title" /></th>
					<td><core:bind path="expenseData.Title">
							<div class="error">${status.errorMessage}</div>
							<input type="text" name="Title" required
								onfocus="enable('Title')" id="Title" value='${status.value}' />
						</core:bind></td>
				</tr>
				<tr>
					<th><spring:message code="label.expense.description" /></th>
					<th><core:bind path="expenseData.Description">
							<div class="error">${status.errorMessage}</div>
							<textarea name="Description" rows="5" cols="22" id="Description"
								onfocus="enable('Description')" required>${status.value}</textarea>
						</core:bind></th>

				</tr>
				<tr>
					<th><spring:message code="label.amount" /></th>
					<td><core:bind path="expenseData.Amount">
							<div class="error">${status.errorMessage}</div>
							<input type="number" name="Amount" required
								value='${status.value}' placeholder="&#8377" />
						</core:bind></td>
				</tr>
				<tr>
					<th><spring:message code="label.amounttype" /></th>
					<td><select name="amountType" id="amounttype">
							<option value="CASH">CASH</option>
							<option value="BANK">BANK</option>

					</select></td>
				</tr>
				
				<tr id="bankentry" class="bankentry">
					
				</tr>
				<tr>
					<th><spring:message code="label.date" /></th>
					<td><core:bind path="expenseData.EDate">
							<div class="error">${status.errorMessage}</div>
							<input type="text" id="date" name="EDate" id="date" class="tcal"
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
