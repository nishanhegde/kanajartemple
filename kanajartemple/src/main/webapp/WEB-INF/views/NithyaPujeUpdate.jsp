
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>


<style>
.colorboxbody input[type=submit] {
	/* border: 1px solid #3079ed; */
	border: 0px;
	color: #fff;
	text-shadow: 0 1px rgba(0, 0, 0, 0.1);
	background-color: #4d90fe;
	/* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}

.colorboxbody input, textarea {
	height: 36px;
	font-size: 14px;
	width: 100%;
	margin-bottom: 5px;
	-webkit-appearance: none;
	border: 1px solid #d9d9d9;
	border-top: 1px solid #c0c0c0;
	/* border-radius: 2px; */
	padding: 0 8px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
}

.colorboxbody {
	width: 325px;
	height: auto;
	margin-top: 5px;
	padding: 10px;
	float: left;
	background: #fff;
	-moz-border-radius: 10px;
	-khtml-border-radius: 10px;
	-webkit-border-radius: 10px;
	-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
	-khtml-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
	position: relative;
}
</style>

<div class="colorboxbody">
	<c:url value="/NithyaPooje/update" var="url" />
	<form:form action="${url}" commandName="sashwathaPoojebean"
		method="post">


		<table>

			<tr>
				<th><spring:message code="label.recno" /></th>
				<td><form:errors path="recNo" /> <form:input path="recNo"
						readonly="true" /></td>
			</tr>

			<tr>
				<th><spring:message code="label.name" /></th>
				<td><form:errors path="name" />
					<form:input path="name" /></td>
			</tr>
			<tr>
				<th><spring:message code="label.address" /></th>
				<th><form:errors path="address" />
					<form:textarea path="address" /></th>

			</tr>
			<tr>
				<th><spring:message code="label.poojedate" /></th>
				<td><form:errors path="pdate" />
					<form:input path="pdate" readonly="true" /></td>
			</tr>

			<tr>
				<th><spring:message code="label.mobileno" /></th>
				<th><core:bind path="sashwathaPoojebean.MobileNo">
						<div class="error">${status.errorMessage}</div>
						<input type="number" value='${status.value}' name="MobileNo"
							id="mobile" />
					</core:bind></th>
			</tr>
			<tr>
				<th><spring:message code="label.email" /></th>
				<th><core:bind path="sashwathaPoojebean.Email">
						<div class="error">${status.errorMessage}</div>
						<input name="Email" value='${status.value}' id="Email"
							type="email" />
					</core:bind></th>
			</tr>


			<tr>
				<th></th>
				<td><input type="submit"
					value="<spring:message code="label.update" /> " /></td>
			</tr>

		</table>
	</form:form>
</div>
