<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="kannadalanguage.jsp"></jsp:include>
<div class="mainbody">

	<c:url value="/Admin/UpdateSashwathaPooje" var="url" />
	<form:form action="${url}" commandName="sashwathaPoojebean"
		method="post">


		<table>

			<tr>
				<th><spring:message code="label.poojename" /></th>
				<td><div class="success">${message}</div>
					<input type="hidden" name="Pid" value="${Pooje.pid}" /><input
					type="hidden" name="RecNo" value="${Data.recNo}" /><input
					type="text" name="PoojeName" value="${Pooje.poojeName}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th><spring:message code="label.amount" /></th>
				<td><input type="text" name="Amount" value="${Pooje.amount}"
					readonly="readonly" /></td>
			</tr>


			<tr>
				<th><spring:message code="label.name" /> *</th>
				<td><core:bind path="sashwathaPoojebean.Name">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Name" id="Name" onfocus="enable('Name')"
							value="${Data.name}" required />
					</core:bind></td>
			</tr>
			<tr>
				<th><spring:message code="label.address" /> *</th>
				<th><core:bind path="sashwathaPoojebean.Address">
						<div class="error">${status.errorMessage}</div>
						<textarea name="Address" rows="5" onfocus="enable('Address')"
							cols="22" id="Address" required>${Data.address}</textarea>
					</core:bind></th>

			</tr>
			<tr>
				<th><spring:message code="label.poojedate" /> *</th>
				<th><core:bind path="sashwathaPoojebean.Pdate">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Pdate" id="date" class="tcal"
							value="${Data.pdate}" required />
					</core:bind></th>
			</tr>

			<tr>
				<th><spring:message code="label.mobileno" /></th>
				<th><core:bind path="sashwathaPoojebean.MobileNo">
						<div class="error">${status.errorMessage}</div>
						<input type="text" value="${Data.mobileNo}" name="MobileNo"
							id="mobile" />
					</core:bind></th>
			</tr>
			<tr>
				<th><spring:message code="label.email" /></th>
				<th><core:bind path="sashwathaPoojebean.email">
						<div class="error">${status.errorMessage}</div>
						<input name="email" value="${Data.email}" id="email" type="text" />
					</core:bind></th>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit"
					value="<spring:message code="label.update" /> " /></td>
			</tr>

		</table>
	</form:form>

</div>



