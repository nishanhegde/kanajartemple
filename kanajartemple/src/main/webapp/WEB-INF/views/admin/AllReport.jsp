<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">


	<center>
		<h1>
			<spring:message code="label.allreport" />
		</h1>
		<form action="<c:url value="../Admin/AllReportSuccess"/>"
			method="post" target="_blank">
			<table cellspacing="15" cellpadding="20">

<input type="hidden" name="dates" value="BDate" />

				<tr>
					<th><spring:message code="label.datefrom" /></th>
					<td><input type="text" id="date" name="FromDate"
						required="required" id="date" class="tcal" /></td>
				</tr>
				<tr>
					<th><spring:message code="label.dateto" /></th>
					<td><input type="text" id="date" name="ToDate"
						required="required" id="date" class="tcal" /></td>
				</tr>

				<tr>
					<th><spring:message code="label.saveas" /></th>
					<td><select name="SaveAs" required="required">
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
