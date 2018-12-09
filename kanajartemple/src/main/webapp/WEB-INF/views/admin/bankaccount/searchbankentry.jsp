<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="core" uri="http://www.springframework.org/tags"%>

<tr id="bankentry" class="bankentry">
<th><spring:message code="label.reference"/></th>
					<td><select name="bankentryid" class="chosen" style="width:500px;">
						<c:forEach items="${bankEntries}" var="entry">
								<option value="${entry.id}">${entry.description} / ${entry.amount}</option>
							</c:forEach>

					</select></td>
</tr>

 

