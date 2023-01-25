<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<TABLE BORDER="1">
<TR>
<TH>flight number</TH>
<TH>Airline Name</TH>
<TH>Source</TH>
<TH>Destination</TH>
<TH>travel Date</TH>
<TH>flight time</TH>
<TH>Price per Ticket</TH>
<TH>Total Fare</TH>
<TH>Time duration</TH> 
<TH>baggage allowance in kg</TH>

</TR>

  <TR>
  		
       <TD> <%= session.getAttribute("flightnumber") %></td>
       <TD> <%= session.getAttribute("airline") %></TD>
       <TD> <%= session.getAttribute("source") %></TD>
       <TD> <%= session.getAttribute("destination") %></TD>;
       <TD> <%= session.getAttribute("traveldate") %></td>
       <TD> <%= session.getAttribute("flighttime") %></TD>
       <TD> <%= session.getAttribute("price") %></TD>
       <TD> <%= session.getAttribute("duration") %></TD>
       <TD> <%= session.getAttribute("baggage") %></TD>
       <TD><a href=BookingRegister.jsp?price=<%=session.getAttribute("price")%>>Confirm Flight</a></TD>
       
      </TR>
    



<a href="SearchFlight.html">Go back to search</a>
</body>
</html>