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

<jsp:include page="kannadalanguage.jsp"></jsp:include>
<div class="mainbody">
	<c:url value="/Admin/UpdatePooje" var="url" />
	<form:form action="${url}" commandName="poojebean" method="post">

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
				<th><spring:message code="label.quantity" /></th>
				<td><core:bind path="poojebean.Quantity">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Quantity" value="${Data.quantity}"
							required />
					</core:bind></td>
			</tr>
			<tr>
				<th><spring:message code="label.name" /></th>
				<td><core:bind path="poojebean.Name">
						<div class="error">${status.errorMessage}</div>
						<input type="text" name="Name" value="${Data.name}"
							onfocus="enable('Name')" id="Name" required />
					</core:bind></td>
			</tr>
			<tr>
				<th><spring:message code="label.poojedate" /></th>
				<td><core:bind path="poojebean.PDate">
						<div class="error">${status.errorMessage}</div>
						<input type="text" id="date" name="PDate" id="date" class="tcal"
							value="${Data.PDate}" required />
					</core:bind></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"
					value="<spring:message code="label.update" /> " /></td>
			</tr>

		</table>
	</form:form>
</div>