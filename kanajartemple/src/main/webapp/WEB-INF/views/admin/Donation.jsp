<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<spring:message code="label.donation.reciept" />
		</h1>
		<c:url value="/Admin/DonationReceipt" var="url" />
		<form:form action="${url}" commandName="donationDetail" method="post"
			target="_blank">
			<table>

				<tr>
					<th><spring:message code="label.donation.name" /> *</th>
					<td><select name="Did">

							<c:forEach items="${DonationDetails}" var="donation">
								<option value="${donation.Did}">${donation.DonationName}</option>
							</c:forEach>
					</select>
				</tr>
				<tr>
					<th><spring:message code="label.amount" /> *</th>
					<td><core:bind path="donationDetail.Amount">
							<div class="error">${status.errorMessage}</div>
							<input type="number" name="Amount" required placeholder="&#8377"
								value='${status.value}' />
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
					<th><spring:message code="label.name" /> *</th>
					<td><core:bind path="donationDetail.Name">
							<div class="error">${status.errorMessage}</div>
							<input type="text" name="Name" id="Name" onfocus="enable('Name')"
								required value='${status.value}' />
						</core:bind></td>
				</tr>

				<th><spring:message code="label.address" /> *</th>
				<th><core:bind path="donationDetail.Address">
						<div class="error">${status.errorMessage}</div>
						<textarea name="Address" rows="5" cols="22" id="Address"
							onfocus="enable('Address')" required>${status.value}</textarea>
					</core:bind></th>

				</tr>

				<tr>
					<th><spring:message code="label.mobileno" /></th>
					<th><core:bind path="donationDetail.MobileNO">
							<div class="error">${status.errorMessage}</div>
							<input type="number" name="MobileNO" id="MobileNO"
								value='${status.value}' />
						</core:bind></th>
				</tr>
				<tr>
					<th><spring:message code="label.email" /></th>
					<th><core:bind path="donationDetail.Email">
							<div class="error">${status.errorMessage}</div>
							<input name="Email" id="Email" type="email"
								value='${status.value}' />
						</core:bind></th>
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
<jsp:include page="Adminfooter.jsp"></jsp:include>
