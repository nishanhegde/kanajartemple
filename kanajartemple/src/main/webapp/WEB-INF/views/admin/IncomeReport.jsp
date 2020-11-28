<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">

	<center>
		<form method="post" target="_blank">
			<table>
				<tr>
					<th><spring:message code="label.income.name" /></th>
					<td><select name="id" required>
							<c:forEach items="${IncomeDetails}" var="income">
								<option value="${income.Iid}">${income.IncomeName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th><spring:message code="label.date" /></th>
					<td><select name="dates">

							<option value="BDate">Booked Date</option>
							<option value="EDate">Entered Date</option>
					</select></td>
				</tr>
						<tr>
					<th><spring:message code="label.amounttype" /></th>
					<td><select name="amountType" required>
							<option value="ALL">ALL</option>
							<option value="CASH">CASH</option>
							<option value="BANK">BANK</option>

					</select></td>
				</tr>
				<tr>
					<th><spring:message code="label.datefrom" /></th>
					<td><input type="text" id="date" name="FromDate" id="date"
						class="tcal" required /></td>
				</tr>
				<tr>
					<th><spring:message code="label.dateto" /></th>
					<td><input type="text" id="date" name="ToDate" id="date"
						class="tcal" required /></td>
				</tr>
				<tr>
					<th><spring:message code="label.sortby" /></th>
					<td><select name="sortby">
							<option value="RecNo" selected="id">RecNo</option>
							<option value="Amount">Amount</option>

					</select> <select name="order">
							<option value="ASC" selected="">Ascending</option>
							<option value="DESC">Descending</option>

					</select></td>
				</tr>
				<tr>
					<th><spring:message code="label.saveas" /></th>
					<td><select name="SaveAs">
							<option value="html">HTML</option>
							<option value="pdf">Pdf</option>
							<option value="xls">Excel</option>
							<option value="csv">CSV</option>

					</select></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value=" Submit " /><input
						type="reset" value=" Clear " /></td>
				</tr>

			</table>
		</form>
	</center>


</div>

<jsp:include page="Adminfooter.jsp"></jsp:include>
