<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>

<script language="javascript" type="text/javascript">

	$( document ).ready(function() {
localStorage.setItem('lang', 'pramukhindic:kannada');
    });


</script>
<div class="mainbody">


        <center>
        		<h2><spring:message code="label.kannadaeditor" /></h2>
        	</center>
		<textarea name="content" onfocus="enable('content')" id ="content" style=" height: 400px;"></textarea>


	
</div>

<jsp:include page="Adminfooter.jsp"></jsp:include>
