<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<jsp:include page="../Adminheader.jsp"></jsp:include>
<div class="mainbody">

	<jsp:include page="../AdminPaginationheader.jsp"></jsp:include>

	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th><spring:message code="label.bankaccount.id" /></th>
					<th><spring:message code="label.bankaccount.name" /></th>
					<th><spring:message code="label.bankaccount.accountno" /></th>
					<th><spring:message code="label.bankaccount.openingbalance" /></th>
					<th><spring:message code="label.edit" /></th>
					<th><spring:message code="label.delete" /></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(bankAccounts) > 0}">
					<c:forEach items="${bankAccounts}" var="app">

						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.id}</p>

							</td>
							<td><p class="desc">${app.bankName}</td>
							
							<td><p >${app.accountNo}</td>
							
							<td><p >&#8377 ${app.openingBalance}</td>


							<td class="td-block">

								<p>
									<a
										onclick="popupCenter('../Admin/editaccount/${app.id}', 'Kanajar Temple',400,290);"
										href="javascript:void(0);"><spring:message
											code="label.edit" /></a>
								</p>

							</td>
							<td class="td-block">
								<p>
									<a onclick="return confirmDelete()"
										href="<c:url value="../Admin/deleteaccount/${app.id}"/>"><spring:message
											code="label.delete" /></a>
								</p>
							</td>


						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="../AdminPaginationfooter.jsp"></jsp:include>
</div>
<jsp:include page="../Adminfooter.jsp"></jsp:include>
