<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="Adminheader.jsp"></jsp:include>

<div class="mainbody">

	<center>
		
	</center>
	
		<input type="hidden" name="Pid" value="${CMScontent.pid}" />
		<textarea name="emails" id ="content" readonly="readonly" style="width: 940px; height: 400px;">${emails}</textarea>
	
	
</div>

<jsp:include page="Adminfooter.jsp"></jsp:include>
