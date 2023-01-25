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
<h1>Flight Details</h1>

<TABLE BORDER="1">
<TR>
<TH>FLIGHT NUMBER</TH>
<TH>AIRLINE</TH>
<TH>SOURCE</TH>
<TH>DESTINATION</TH>
<TH>FLIGHT DATE</TH>
<TH>FLIGHT TIME</TH>
<TH>TICKET PRICE</TH>
<TH>DURATION</TH>
<TH>BAGGAGE ALLOWANCE</TH>

</TR>

<%
List<Model> mArrayFlightList=(List<Model>)session.getAttribute("list");
for(Model mflightlist: mArrayFlightList){

%>

<tr><td><%=mflightlist.getFlightnumber() %></td><td><%=mflightlist.getAirline() %></td><td><%=mflightlist.getSource() %></td><td><%=mflightlist.getDestination() %></td><td><%=mflightlist.getTraveldate() %></td>
<td><%=mflightlist.getFlighttime()%></td><td><%=mflightlist.getPrice() %></td><td><%=mflightlist.getDuration() %></td><td><%=mflightlist.getBaggage() %></td>
</tr>
<%
} 
%>
<a href="AddFlight.html"><h2>ADD MORE FLIGHT</h2></a><br>
<a href="AdminSuccess.html"> <h2>Home</h2></a>
</body>
</html>