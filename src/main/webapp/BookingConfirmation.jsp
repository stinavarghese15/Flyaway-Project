<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 

int s= Integer.parseInt(request.getParameter("totalFare"));%>
<h2><%out.println("Your total bill is " +s+" INR"); %></h2>


<form action="FinalPage.html">

	<h5>Kindly fill the details </h5>
	<table style="with: 50%">
    
     <tr>   
      	<td>Name n the card</td>
       	<td> <input type="text" placeholder="Name on the card" name="name"/></td>
          
       </tr>  
       
       <tr>   
      	
      		<td>Card number</td>
       		<td> <input type="text" placeholder="number on the card" name="number" value=<%= request.getParameter("price") %>></td>
          
       </tr> 
       <tr> 
        	<td>Enter cvv </td> 
        	<td><input type="text" placeholder="enter card cvv" name="cvv"/></td>
        </tr>
       
         
        </table>
<h3>Kindly give a confirmation to proceed with the payment</h3>

 <button type="submit">MAKE PAYMENT</button>
  </form>		
</body>
</html>