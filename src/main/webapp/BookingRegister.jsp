<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<form action="BookingConfirmation">
<h2>Glad we could find a flight for you!!!</h2>

	<h3>Please register with us to confirm your tickets.</h3>
	<br><br>
	
	<table style="with: 50%">
    
     <tr>   
      	
      		<td>Name of the passenger</td>
       		<td> <input type="text" placeholder="Name" name="passengername"/></td>
          
       </tr>  
       
       <tr>   
      	
      		<td>price</td>
       		<td> <input type="text" placeholder="Name" name="ticketPrice" value=<%= request.getParameter("price") %>></td>
          
       </tr> 
       <tr> 
        	<td>Passport Number</td> 
        	<td><input type="text" placeholder="you passport number" name="passportnumber"/></td>
        </tr>
        
        <tr>
         <td>Nationality</td>
         <td><input type="text" placeholder="your nationality" name="nationality"/></td>
         
       </tr>
       
       <tr>
        	<td>Number of passengers</td> 
         <td><input type="text" placeholder="total seats to book" name="numofpass"/></td>
         </tr>
         
        </table>
       
      <button type="submit">CONFIRM</button>  
  		
     
  
 </form>
 <a href="SearchFlight.html">Search Again</a>
</body>
</html>