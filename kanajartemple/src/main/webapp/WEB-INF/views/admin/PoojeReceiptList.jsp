<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<h1>${PoojeName}</h1>
	</center>

	<jsp:include page="AdminPaginationheader.jsp"></jsp:include>

	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th><spring:message code="label.recno"/></th>
					<th><spring:message code="label.name"/></th>

					<th><spring:message code="label.poojedate"/></th>
					<th><spring:message code="label.edit"/></th>
					<th><spring:message code="label.duplicate"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(PoojeDetails) > 0}">
					<c:forEach items="${PoojeDetails}" var="app">

						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.RecNo}</p>

							</td>
							<td><p class="desc">${app.Name}</td>

							<td class="td-block">

								<p>${app.PDate}</p>

							</td>
							<c:if test="${PoojeName != 'SashwathaPooje'}">
							<td class="td-block">

								<p><a onclick="popupCenter('../../Admin/EditPooje/${app.Pid}/${app.RecNo}', 'Kanajar Temple',400,290);" href="javascript:void(0);"><spring:message code="label.edit"/></a></p>

							</td>
							</c:if>
							<c:if test="${PoojeName == 'SashwathaPooje'}">
							<td class="td-block">

								<p><a onclick="popupCenter('../Admin/EditSashwathaPooje/${app.RecNo}', 'Kanajar Temple',425,400);" href="javascript:void(0);"><spring:message code="label.edit"/></a></p>

							</td>
							</c:if>
							<c:if test="${PoojeName != 'SashwathaPooje'}">
								<td class="td-block">
									<p>
										<a target="_blank"
											href="<c:url value="../../Admin/AddPoojeReceipt/${app.Pid}/${app.RecNo}"/>"><spring:message code="label.print"/></a>
									</p>
								</td>
							</c:if>
							<c:if test="${PoojeName == 'SashwathaPooje'}">
								<td>
									<p>
										<a target="_blank"
											href="<c:url value="../Admin/SashwathaPoojeReceipt/${app.Pid}/${app.RecNo}"/>"><spring:message code="label.print"/></a>
									</p>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="AdminPaginationfooter.jsp"></jsp:include>
</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
