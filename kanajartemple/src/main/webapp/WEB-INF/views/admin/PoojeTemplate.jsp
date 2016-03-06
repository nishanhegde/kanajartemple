<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<br />
	<center>
		<div class="invalid">${message}</div>

</center>


		<jsp:include page="AdminPaginationheader.jsp"></jsp:include>





		<!-- data -->
		<div class="box text-shadow">
			<table class="demo-tbl">
				<thead>
					<tr>
						<th><spring:message code="label.id" /></th>
						<th><spring:message code="label.poojename" /></th>
						<th><spring:message code="label.amount" /></th>
						<th><spring:message code="label.edit" /></th>
						<th><spring:message code="label.delete" /></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fun:length(Poojedata) > 0}">
						<c:forEach items="${Poojedata}" var="app" varStatus="status">

							<div id="Pooje${status.count}" class="reveal-modal">
																	
									<form action="<c:url value="/SuperAdmin/CUDPooje/update"/>"
										id="pooje" name="pooje" method="post">

										<input type="hidden" name="pid" value="${app.Pid}" /> <spring:message code="label.poojename" /> <input
											type="text" name="PoojeName" required="required"
											id="PoojeName" onfocus="enable('PoojeName')" value="${app.PoojeName}" /><br /> <spring:message code="label.amount" /><input
											type="number" name="Amount" placeholder="&#8377" required="required" id="Amount"
											value="${app.Amount}" /> <input type="submit"
											value="<spring:message code="label.update" /> " />
									</form>
								
								<a class="close-reveal-modal">&#215;</a>
							</div>

							<tr class="tbl-item">


								<!-- data -->
								<td class="td-block">

									<p class="title">${app.pid}</p>

								</td>
								<td><p class="desc">${app.PoojeName}</td>
								<td class="td-block"><p>
										&#8377 ${app.Amount}</p></td>

								<td class="td-block">

									<p>
										<a href="#" class="big-link"
											data-reveal-id="Pooje${status.count}"><spring:message
												code="label.edit" /></a>
									</p>
								</td>


								<td class="td-block">

									<p>
										<a
											href="<c:url value="/SuperAdmin/CUDPooje/delete/${app.pid}"/>"
											onclick="return confirmDelete()"><spring:message
												code="label.delete" /></a>
									</p>
								</td>



							</tr>

						</c:forEach>

					</c:if>

				</tbody>

			</table>



		</div>

		<jsp:include page="AdminPaginationfooter.jsp"></jsp:include>
</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
