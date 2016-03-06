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

		<table id="poojetable">
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
			<tr>
				<td>&nbsp</td>

				<td>&nbsp</td>
				<td></td>
			</tr>
			<tr>
				<td id="recno">${PoojeData.recNo}</td>

				<td>&nbsp</td>
				<td id="tdate">${tdate}</td>
			</tr>
			<tr>
				<td id="name" colspan="3">${PoojeData.name}</td>
			</tr>
			<tr>
				<td id="poojename">${Pooje.poojeName}</td>
				<td id="poojedate">${PoojeData.PDate}</td>
				<td id="poojequantity">${PoojeData.quantity}</td>
			</tr>
			<tr>
				<td id="amountinwords" colspan="3">${InWords}</td>
			</tr>
			<tr>
				<td>&nbsp</td>

				<td>&nbsp</td>
				<td></td>
			</tr>
			<tr>
				<td id="amount">${Amount}</td>

				<td></td>
				<td id="signature">${Signature}</td>
			</tr>
			<tr>
				<td>&nbsp</td>
				<td></td>
				<td></td>

			</tr>
			<tr>
				<td>&nbsp</td>
				<td></td>
				<td></td>

			</tr>
		</table>
</body>
</html>