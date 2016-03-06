<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<c:url value="/Admin/AddPoojeReceipt" var="url" />
		<form:form action="${url}" commandName="poojebean" method="post"
			target="_blank">
			<table>

				<tr>
					<th><spring:message code="label.poojename" /> *</th>
					<td><input type="hidden" name="Pid" value="${Pooje.pid}" /><input
						type="text" name="PoojeName" value="${Pooje.poojeName}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<th><spring:message code="label.amount" /> *</th>
					<td><input type="text" name="Amount" value="${Pooje.amount}"
						readonly="readonly"  placeholder="&#8377"/></td>
				</tr>

				<tr>
					<th><spring:message code="label.quantity" /> *</th>
					<th><core:bind path="poojebean.Quantity">
							<div class="error">${status.errorMessage}</div>
							<input type="number" name="Quantity" id="Quantity" value="1" />
						</core:bind></th>

				</tr>
				<tr>
					<th><spring:message code="label.name" /> *</th>
					<td><core:bind path="poojebean.Name">
							<div class="error">${status.errorMessage}</div>
							<input type="text" onfocus="enable('Name')" name="Name" id="Name"
								class="Name" required value='${status.value}' />
						</core:bind></td>
				</tr>

				<tr>
					<th><spring:message code="label.poojedate" /> *</th>
					<th><core:bind path="poojebean.PDate">
							<div class="error">${status.errorMessage}</div>
							<input type="text" id="date" name="PDate" id="PDate" class="tcal"
								required value='${status.value}' />
						</core:bind></th>
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
<jsp:include page="Adminfooter.jsp"></jsp:include>
