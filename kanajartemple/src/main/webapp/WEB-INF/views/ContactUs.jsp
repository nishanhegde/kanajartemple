<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kanajar Brahmalingeshwara Temple</title>
 <link rel="icon" href="<c:url value="/resources/images/templeicon.png"/>"" type="image/x-icon">
	  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="mainbody"> 
<span class="fon16">Contact Us</span>
<hr/>

<br/>

<div class="contleftbox">
<p>Shree Brahmalingeshwara Temple<br/>
Kananjar, Karkala Taluk, Udupi Dist.<br/>
Pin:574102<br/>
Ph: 08258 275244 <br/>
Mob: 09141502033 <br/>
Email:shreebrahmalingeshwara@kanajartemple.com</p>
<br/>
<p style="text-align: center"><b>OR</b></p>

<br/>
<p >
Nishan Hegde<br/>
Dugganbail House Kananjar, <br/>
Karkala Taluk, Udupi Dist.<br/>
Pin:574102<br/>
Ph: 09663559596 <br/>
Email:nishanhegde@kanajartemple.com</p>
</div>


<div class="floatingleft">
<form action="?" method="post">
<table cellspacing="25">
<tr>
	<th>Name</th>
	<th><input type="text" name="name" id="name"/></th>
</tr>

<tr>
	<th>Email</th>
	<th ><input name="email" type="text" onchange="return checkmail(this.form.email)" id="email1" /></th>
	
</tr>
	

<tr>

	<th>Your Query</th>
	<th><textarea  name="message" rows="3" cols="22" id="message" ></textarea></th>
</tr>
<tr>
	<th></th>
	<th><input type="submit" name="Register" value="Submit"style="width: 100px"/></th>
</tr>
</table>	

</form>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>