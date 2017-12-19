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
 
 <c:url value="/Admin/editaccount" var="url" />
	<form:form action="${url}" commandName="bankAccount" method="post">
		<table>

			<tr>
				<th><spring:message code="label.bankaccount.name" /> *</th>
				<td><div class="success">${message}</div> <input type="text"
					name="bankName" id="bankName" value="${bankAccount.bankName}"
					required="required" /> <input type="hidden" name="id"
					value="${id}" /></td>
			</tr>

			<tr>
				<th><spring:message code="label.bankaccount.accountno" /> *</th>
				<td><input type="number" name="accountNo" id="accountNo"
					value="${bankAccount.accountNo}" required="required" /></td>
			</tr>

			<tr>
				<th><spring:message code="label.bankaccount.address" /> *</th>
				<td><textarea name="address" rows="5" cols="22" id="address"
						required>${bankAccount.address}</textarea>
			</tr>
			<tr>
				<th><spring:message code="label.bankaccount.ifsccode" /> *</th>
				<td><input type="text" name="ifscCode" id="ifscCode"
					value="${bankAccount.ifscCode}" required="required" /></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit"
					value="<spring:message code="label.update" />" /></td>
			</tr>

		</table>
	</form:form>
</div>