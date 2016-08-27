
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>


<link rel="stylesheet"
	href="<c:url value="/resources/css/colorbox.css"/>" />

<div class="colorboxbody">
	<table>

		<tr>
			<th><spring:message code="label.recno" /></th>
			<td><input type="text" name="RecNo" id="RecNo"
				value='${sashwathaPoojebean.recNo}' readonly="readonly" /></td>
		</tr>

		<tr>
			<th><spring:message code="label.name" /> </th>
			<td><input type="text" name="Name" id="Name"
				value='${sashwathaPoojebean.name}'
				readonly="readonly" />
					</td>
			</tr>
			
			<tr>
				<th><spring:message code="label.address" /> </th>
				<th>
						<textarea name="Address" rows="5" cols="22" id="Address" readonly="readonly" >${sashwathaPoojebean.address}</textarea>
					</th>
			</tr>
			<tr>
				<th><spring:message code="label.poojedate" /> </th>
				<th>
						<input type="text" name="Pdate"  id="date" value='${sashwathaPoojebean.pdate}'
							readonly="readonly" />
					</th>
			</tr>

			<tr>
				<th><spring:message code="label.mobileno" /></th>
				<th>
						<input type="text" value='${sashwathaPoojebean.mobileNo}' name="MobileNo" readonly="readonly"
							id="mobile"  />
				</th>
			</tr>
			<tr>
				<th><spring:message code="label.email" /></th>
				<th>
						<input name="text" value='${sashwathaPoojebean.email}' id="Email"
				readonly="readonly" type="email" />
			</th>
			</tr>



		</table>
	
</div>
