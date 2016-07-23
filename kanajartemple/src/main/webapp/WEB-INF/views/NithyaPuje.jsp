   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>kanajar temple</title>
 <link rel="icon" href="<c:url value="/resources/images/templeicon.png"/>"" type="image/x-icon">
<link rel="stylesheet" href="<c:url value="/resources/css/admin/reveal.css"/>" type="text/css"/>
	  	
				<script type="text/javascript" src="<c:url value="/resources/js/admin/jquery-1.6.min.js"/>"></script> 
		<script type="text/javascript" src="<c:url value="/resources/js/admin/jquery.reveal.js"/>"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="mainbody">
<br/>
<center><h1>Nithya Pooje Address</h1></center>

        <%int i=0; %>  

         <!--Pagination Header  -->
         
  <jsp:include page="admin/AdminPaginationheader.jsp"/>              
                
          
    <!-- data --> 
<div class="box text-shadow">
    <table class="demo-tbl">
	<thead>
        	<tr>
                	<th>ID</th>
			<th>Name</th>
			<th>Puja Date</th>
                 <th>Full View</th>       
                        <th>Edit</th>
                        
		</tr>
	</thead>
    <tbody>
        <c:if test="${fun:length(NithyaPooje) > 0}">
        <c:forEach items="${NithyaPooje}" var="app">
            
            <tr class="tbl-item">					
	
				
		<!-- data -->
                <td class="td-block">
		
                     <p class="title">${app.RecNo}</p>
		
		</td>
                <td><p class="desc">${app.Name} </td>
               
               <td><p class="td-block">${app.PDate} </td>
                <td class="td-block">
		
		<p ><a href=""  data-reveal-id="Pooje<%=i%>" >view</a></p>
		
		</td>
                <td class="td-block">
		
                    <p ><a href="#">Edit</a></p></td>
          	
	</tr>
	
	
	
	<div  id="Pooje<%=i%>" class="reveal-modal">
							<center>
							<p class="headingfont">Full Details</p>
							<hr/>
							<div id="fulladd">
							<ul><li class="fon12B">ID</li><li>:</li><li class="fon12">${app.id}</li></ul>
							<ul><li class="fon12B">Name</li><li>:</li><li class="fon12">${app.Name}</li></ul>
							<ul><li class="fon12B">Puja Date</li><li>:</li><li class="fon12">${app.Pujadate}</li></ul>
							
							<ul><li class="fon12B">Email</li><li>:</li><li class="fon12">${app.Email}</li></ul>
							<ul><li class="fon12B">Phone</li><li>:</li><li class="fon12">${app.Phoneno}</li></ul>
							
							<ul><li class="fon12B">Address</li><li>:</li><li class="fon12"><textarea cols="25" rows="3" readonly="readonly">${app.Address}</textarea></li></ul>
							</div>
							</center>          
                                        <a class="close-reveal-modal">&#215;</a>
                                        </div>  
                                        
                                        <% i++; %> 
              </c:forEach>
            </c:if>
        </tbody>
          
</table>
          
            
        </div>
              
    <jsp:include page="admin/AdminPaginationfooter.jsp"></jsp:include>
        
      
        
     
                
                
   
    </div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>