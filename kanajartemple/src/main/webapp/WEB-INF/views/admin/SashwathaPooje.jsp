<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<c:url value="/Admin/SashwathaPoojeReceipt" var="url" />
		<form:form action="${url}" commandName="sashwathaPoojebean"
			method="post" target="_blank">
			<table>

				<tr>
					<th><spring:message code="label.poojename" /> *</th>
					<td><input type="hidden" name="Pid" value="${Pooje.pid}" /><input
						type="text" name="PoojeName" value="${Pooje.poojeName}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<th><spring:message code="label.amount" /> *</th>
					<td><input type="text" name="Amount" placeholder="&#8377" value="${Pooje.amount}"
						readonly="readonly" /></td>
				</tr>


				<tr>
					<th><spring:message code="label.name" /> *</th>
					<td><core:bind path="sashwathaPoojebean.Name">
							<div class="error">${status.errorMessage}</div>
							<input type="text" onfocus="enable('Name')" name="Name" id="Name"
								value='${status.value}' required />
						</core:bind></td>
				</tr>
				<tr>
					<th><spring:message code="label.address" /> *</th>
					<th><core:bind path="sashwathaPoojebean.Address">
							<div class="error">${status.errorMessage}</div>
							<textarea name="Address" rows="5" cols="22" id="Address"
								onfocus="enable('Address')"  required>${status.value}</textarea>
						</core:bind></th>

				</tr>
				<tr>
					<th><spring:message code="label.poojedate" /> *</th>
					<th><core:bind path="sashwathaPoojebean.Pdate">
							<div class="error">${status.errorMessage}</div>
							<input type="text" id="date" name="Pdate" id="date" class="tcal"
								value='${status.value}' required />
						</core:bind></th>
				</tr>

				<tr>
					<th><spring:message code="label.mobileno" /></th>
					<th><core:bind path="sashwathaPoojebean.MobileNo">
							<div class="error">${status.errorMessage}</div>
							<input type="number" value='${status.value}' name="MobileNo"
								id="mobile" />
						</core:bind></th>
				</tr>
				<tr>
					<th><spring:message code="label.email" /></th>
					<th><core:bind path="sashwathaPoojebean.Email">	<div class="error">${status.errorMessage}</div>
							<input name="Email" value='${status.value}' id="Email"
								type="email" />
						</core:bind></th>
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
