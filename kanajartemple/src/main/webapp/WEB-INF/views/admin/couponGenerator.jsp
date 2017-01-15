<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<h1>
			<spring:message code="label.coupon" />
		</h1>
		<br/>
		<form:form commandName="coupon" method="post" target="_blank">
		
		<span class="invalid"><spring:message code="label.coupon.note" /> </span>
			<table>
				<tr>
					<th><spring:message code="label.coupon.from" /> *</th>
					<td><input type="number" name="noFrom" 
								id="noFrom" required />
					</td>
				</tr>
				<tr>
					<th><spring:message code="label.coupon.to" /> *</th>
					<td><input type="number" name="noTo" id="noTO" required />
					</td>
				</tr>
				<tr>
					<th><spring:message code="label.coupon.title" /> *</th>
					<td><input type="text" name="title" onfocus="enable('title')"
								id="title" required />
					</td>
				</tr>


				<tr>
					<th></th>
					<td><input type="submit"
						value="<spring:message code="label.submit" /> " /><input
						type="reset" value="<spring:message code="label.clear" /> " /></td>
				</tr>

			</table>
		</form:form>


	</center>

</div>

<jsp:include page="Adminfooter.jsp"></jsp:include>
