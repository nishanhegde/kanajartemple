<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css'
	href='<c:url value="/resources/css/admin/print.css"/>' media="print" />
<link rel='stylesheet' type='text/css'
	href='<c:url value="/resources/css/admin/reciept.css"/>' />
<title><spring:message code="label.title" /></title>
</head>
<body onload="window.print()">

	<div id="page-wrap">

		<table id="expensetable">
			<tr>
				<td>&nbsp</td>

				<td>&nbsp</td>
				<td></td>
			</tr>
			<tr>
				<td>&nbsp</td>

				<td>&nbsp</td>
				<td></td>
			</tr>
			<tr>
				<td id="expenserecno">${Income.recNo}</td>

				<td>&nbsp</td>
				<td id="expensetdate">${tdate}</td>
			</tr>
			<tr>
				<td id="title" colspan="3">${Income.title}</td>
			</tr>
			<tr>
				<td id="description" colspan="3"></td>
				
			</tr>
			<tr>
				<td id="expenseamountinwords" colspan="3">${InWords}</td>
			</tr>
			<tr>
				<td id="expenseamount">${Amount}</td>

				<td>${IncomeName}</td>
				<td></td>
			</tr>
			<tr>				
				<td>&nbsp</td>
				<td></td>
				<td id="incomesignature">${Signature}</td>
			</tr>
			<tr>
				<td>&nbsp</td>
				<td></td>
				<td></td>

			</tr>
			<tr>
				<td>&nbsp</td>

				<td>&nbsp</td>
				<td></td>
			</tr>
		</table>
</body>
</html>