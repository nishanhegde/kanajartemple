<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
table{
table-layout: fixed;
width: 8.23in;
}
tr {
	font: 16px/1.4 Georgia, serif;
	
	
	height: 1.65in;
		
}
td{
text-align:center;
border:1px;
border-style:  solid;
}
</style>
</head>
<body>
<table>
<%
int k=700;
for(int i=1;i<=75;i++)
	{
	%>
	<tr>
	<%for(int j=1;j<=4;j++)
	{ k++;%>
	<td><%=k%><br/>K.S.B.T</td>	
<% }%>
</tr>
<%	}
	%>
</table>

</body>
</html>