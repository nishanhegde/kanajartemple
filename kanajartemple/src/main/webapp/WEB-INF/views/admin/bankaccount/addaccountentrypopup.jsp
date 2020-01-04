<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/admin/tcal.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/tcal.js"/>"></script>

<jsp:include page="../kannadalanguage.jsp"></jsp:include>
<div class="mainbody">
	
		<form:form commandName="bankAccountEntry" method="post">
			<table>

				<tr>
					<th><spring:message code="label.bankaccountentry.name" /> *</th>
					<td><div class="success">${message}</div><select name="bankAccountId">

							<c:forEach items="${bankAccounts}" var="bank">
								<option value="${bank.id}">${bank.bankName}
									(${bank.accountNo})</option>
							</c:forEach>
					</select>
				</tr>

				<tr>
					<th><spring:message code="label.bankaccountentry.amount" /> *</th>
					<td><input type="number" name="amount" id="amount" placeholder="&#8377"
						required="required" /></td>
				</tr>

<tr>
					<th><spring:message code="label.bankaccountentry.description" /> </th>
					<td><textarea name="description" rows="5" cols="22" id="description"
							></textarea>
				</tr>
				
				<tr>
					<th><spring:message code="label.bankaccountentry.transaction" />
						*</th>
					<td><select name="transaction"><c:forEach
								var="transaction" items="${transactions}">
								<option value="${transaction}">${transaction}</option>
							</c:forEach></select></td>
				</tr>

				<%-- <tr>
					<th><spring:message code="label.bankaccountentry.type" /> *</th>
					<td><select name="type"><c:forEach var="type"
								items="${types}">
								<option value="${type}">${type}</option>
							</c:forEach></select></td>
				</tr> --%>

				<tr>
					<th><spring:message
							code="label.bankaccountentry.chequeorrefno" /> </th>
					<td><input type="text" name="chequeOrRefNo" id="chequeOrRefNo"
						 /></td>
				</tr>

				<tr>
					<th><spring:message
							code="label.bankaccountentry.transactiondate" /> *</th>
					<td><input type="text" id="transactionDate"
						name="transactionDate" class="tcal" required /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit"
						value="<spring:message code="label.submit" />" /><input
						type="reset" value="<spring:message code="label.clear" /> " /></td>
				</tr>

			</table>
		</form:form>

</div>

