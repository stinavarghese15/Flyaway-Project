<%@page import="com.simpli.customer.Model"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>FlyAway Welcomes you...</h2>

<TABLE BORDER="1">
<TR>
<TH>FLIGHT NUMBER</TH>
<TH>AIRLINE</TH>
<TH>SOURCE</TH>
<TH>DESTINATION</TH>
<TH>FLIGHT DATE</TH>
</TR>

<%
List<Model> mArrayList=(List<Model>)session.getAttribute("list");
for(Model mlist: mArrayList){

%>

<tr><td><%=mlist.getFlightnumber() %></td><td><%=mlist.getAirline() %></td><td><%=mlist.getSource() %></td><td><%=mlist.getDestination() %></td><td><%=mlist.getTraveldate() %></td>
<td><a href="DisplayFlightDetails?flightnumber=<%=mlist.getFlightnumber()%>"> Details</a></td></tr>
<%
} 
%>
</body>
</html>