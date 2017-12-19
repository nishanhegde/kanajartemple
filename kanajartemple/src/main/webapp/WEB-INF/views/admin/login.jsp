<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kanajar temple</title>
 <link rel="icon" href="<c:url value="/resources/images/templeicon.png"/>"" type="image/x-icon">

    <link rel="stylesheet" href="<c:url value="/resources/css/admin/admin.css"/>" media="screen" type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/admin/reveal.css"/>" type="text/css" />

<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery-1.6.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery.reveal.js"/>"></script>
</head>

<body>

  <div class="login-card">
    <h1>Login</h1>
    <center><div class="invalid">${invalid}</div></center>
  <form action="<c:url value='j_spring_security_check' />" method='POST'>
    <input type="text" name="j_username" placeholder="Email / Phone No" required="">
    <input type="password" name="j_password" placeholder="Password" required="">
    Remember Me: <input type="checkbox" name="remember-me" />
    <br/>
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>

  <div class="login-help">
    <a href="Registration">Register</a> <!-- | <a href="#" class="big-link" data-reveal-id="myModal">Forgot Password</a> -->
  </div>
</div>


<div id="myModal" class="reveal-modal">
	<center>
	<form action="<c:url value="/forgotpassword"/>">
		<table cellspacing="20" cellpadding="10">
			<tr>
				<th>Email Id/Phone No</th>
				<td><input type="text" name="id" required/></td>
			</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Submit"/></td>
		</tr>
		</table>
		</form>
	</center>
	<a class="close-reveal-modal">&#215;</a>
</div>

</body>
</html>