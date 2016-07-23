 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kanajar Brahmalingeshwara Temple</title>
 <link rel="icon" href="<c:url value="/resources/images/templeicon.png"/>"" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ShowHideBox.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.29473.js"/>"></script>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="mainbody"> 
<div class="floatingleft">
<form:form commandName="SevaBook" action="" method="post">
<table cellspacing="25" >
<tr align="left">
	<th>Name *</th>
	<th><input type="text" name="name" id="name" style="width: 200px"/></th>
</tr>



<tr align="left">
	<th>Mobile no *</th>
	<th><input type="text" name="mob" id="mob" onchange="return mob1()" style="width: 200px"/></th>
</tr>
<tr  align="left">
	<th>Email *</th>
	<th ><input name="myemail" id="email" type="text" onchange="return checkmail(this.form.myemail)" style="width: 200px" /></th>
</tr>

<tr  align="left">
<th>Address *</th>
	<th><textarea  name="add" rows="3" cols="26" id="add" ></textarea></th>

</tr>

<tr  align="left">
	<th>Seva Details *</th>
	<th><select  name="seva" style="width: 200px;" >
	<option >Select one</option>
	<option>Shashvatha Nithya Puja</option>
<option>Hoovina puja</option>
<option>Serva seve</option>
<option>Rudrabhisheka</option></select> </th>
</tr>

<tr  align="left">
	<th>Puja Date *</th>
	<th>
     <input type="text" id="datepicker" name="date1"  style="width: 200px"/></th>
</tr>

<tr  align="left">
	<th>Occasion *</th>
	<th><input typ="text" name="occasion" id="occasion" style="width: 200px"/></th>
</tr>



<tr  align="left">
	<th>Date of payment *</th>
	<th> <input type="text"  style="width: 200px" name="date2" id="inputField" />
</th>
</tr>


<tr  >
	<th></th>
	<th><input type="submit" name="Submit" value="Submit" style="width:100px;" onclick="sub()" /></th>
</tr>
</table>
</form:form>
</div>
<div style="float:right;">
<section class="ac-container">

				<div>
					<input id="ac-2" name="accordion-1" type="checkbox" checked />
					<label for="ac-2">Before booking please see the instructions.</label>
					<article class="ac-medium">
						<p>The seva charges is to be credited to the temples account with syndicate bank kanajar .<br/>
Account no : 01962200002816<br/>
IFSC code  : SYNB0000196 
<table>
<tr>

<th colspan=3>Seva charges</th>

</tr>

<tr>
<td>Shashvatha Nithya Puja</td><td> :</td>
<td><img src="<c:url value="/resources/images/rupees.JPG"/>" />
550</td> 
</tr>

<tr>
<td>Hoovina puja </td><td>:</td>
<td><img src="<c:url value="/resources/images/rupees.JPG"/>" />
500</td>
</tr>

<tr>
<td>Serva seve </td><td>:</td>
<td><img src="<c:url value="/resources/images/rupees.JPG"/>" />
250</td>
</tr>
 
<tr>
<td>Rudrabhisheka </td><td>:</td>
<td><img src="<c:url value="/resources/images/rupees.JPG"/>" />
100</td>
</tr>
</table>
<br/><br/>
<b>* Mandatory Fields </b></p>
					</article>
				</div>
				
				
			</section>
			
			
			
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>