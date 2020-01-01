<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<tr id="bankentry" class="bankentry">
	<th><spring:message code="label.reference" /></th>
	<td><p><select name="bankentryid" class="chosen"
		style="width: 500px;">

			<c:forEach items="${bankEntries}" var="entry">
				<option value="${entry.id}">${entry.description} /
					${entry.amount}</option>
			</c:forEach>
	</select>
	</p><p>
	<a
		onclick="popupCenter('../Admin/addaccountentrypopup', 'Kanajar Temple',500,400);"
		href="javascript:void(0);"><spring:message code="label.create" /></a>
		&nbsp&nbsp <a id="refresh" onclick="refresh();"  href="javascript:void(0);" > <spring:message
				code="label.refresh"/></a>
				</p></td></td>
</tr>



