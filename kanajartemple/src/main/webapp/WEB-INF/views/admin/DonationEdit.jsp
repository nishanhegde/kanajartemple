<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="kannadalanguage.jsp"></jsp:include>
<div class="mainbody">
<c:url value="/Admin/UpdateDonation" var="url" />
<form:form action="${url}" commandName="donationDetail" method="post">
				
				<table >

		<tr>
			<th><spring:message code="label.donation.name" /></th>
			<td><div class="success">${message}</div><input type="hidden" name="Did"
				value="${Data.did}" /><input type="hidden" name="RecNO"
				value="${Data.recNO}" /><input type="text" name="DonationName"
				value="${Donation.donationName}" readonly="readonly" /></td>
		</tr>
		<tr>
			<th><spring:message code="label.amount" /></th>
			<td><core:bind path="donationDetail.Amount">
							<div class="error">${status.errorMessage}</div><input
				type="text" name="Amount" value="${Data.amount}" required /></core:bind></td>
		</tr>

		<tr>
			<th><spring:message code="label.name" /> *</th>
			<td><core:bind path="donationDetail.Name">
							<div class="error">${status.errorMessage}</div><input type="text" name="Name" onfocus="enable('Name')" 
				id="Name" value="${Data.name}" required /></core:bind></td>
		</tr>

		<th><spring:message code="label.address" /> *</th>
		<th><core:bind path="donationDetail.Address">
						<div class="error">${status.errorMessage}</div><textarea name="Address" rows="5" onfocus="enable('Address')" 
				cols="22" id="Address" required>${Data.address}</textarea></core:bind></th>

		</tr>

		<tr>
			<th><spring:message code="label.mobileno" /></th>
			<th><core:bind path="donationDetail.MobileNO">
							<div class="error">${status.errorMessage}</div><input type="text" name="MobileNO"
				id="MobileNO" value="${Data.mobileNO}" /></core:bind></th>
		</tr>
		<tr>
			<th><spring:message code="label.email" /></th>
			<th><core:bind path="donationDetail.Email">
							<div class="error">${status.errorMessage}</div><input name="Email" id="Email"
				value="${Data.email}" type="text" /></core:bind></th>
		</tr>

		<tr>
			<th></th>
			<td><input type="submit"
				value="<spring:message code="label.update" /> " /></td>
		</tr>

	</table>
</form:form>
</div>