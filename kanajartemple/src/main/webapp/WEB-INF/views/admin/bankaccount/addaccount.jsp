<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="../Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>

		<form:form commandName="bankAccount" method="post">
			<table>

				<tr>
					<th><spring:message code="label.bankaccount.name" /> *</th>
					<td><input type="text" name="bankName" id="bankName"
						required="required" /></td>
				</tr>

				<tr>
					<th><spring:message code="label.bankaccount.accountno" /> *</th>
					<td><input type="number" name="accountNo" id="accountNo"
						required="required" /></td>
				</tr>

				<tr>
					<th><spring:message code="label.bankaccount.address" /> *</th>
					<td><textarea name="address" rows="5" cols="22" id="address"
							required></textarea>
				</tr>
				<tr>
					<th><spring:message code="label.bankaccount.ifsccode" /> *</th>
					<td><input type="text" name="ifscCode" id="ifscCode"
						required="required" /></td>
				</tr>
				
				<tr>
					<th><spring:message code="label.bankaccount.openingbalance" /> *</th>
					<td><input type="double" name="openingBalance" id="openingBalance"
						required="required" placeholder="&#8377" /></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit"
						value="<spring:message code="label.submit" />" /><input
						type="reset" value="<spring:message code="label.clear" /> " /></td>
				</tr>

			</table>
		</form:form>
	</center>
</div>
<jsp:include page="../Adminfooter.jsp"></jsp:include>
