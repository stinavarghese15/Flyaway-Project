package com.simpli.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayFlightDetails
 */
@WebServlet("/DisplayFlightDetails")
public class DisplayFlightDetails extends HttpServlet {

		private Connection con;
		private PreparedStatement pstmt;
		private ResultSet rs;

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			String flightnumber=request.getParameter("flightnumber");
			
			
			
			HttpSession session=request.getSession();
			PrintWriter out=response.getWriter();
			
			response.setContentType("text/html");
			
			try {
			
				System.out.println("Reached");
				con=DBConnectUser.getConnection();
				String sql="select * from flightdetails where flightnumber='"+flightnumber+"'";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			
				while(rs.next()) {
					
					System.out.println("While loop");
					session.setAttribute("flightnumber",flightnumber);
					session.setAttribute("airline",(rs.getString(2)));
					session.setAttribute("source", (rs.getString(3)));
					session.setAttribute("destination", (rs.getString(4)));
					session.setAttribute("traveldate",(rs.getDate(5)));
					session.setAttribute("flighttime",(rs.getTime(6)));
					session.setAttribute("price",(rs.getInt(7)));
					
					
					session.setAttribute("duration",(rs.getString(8)));
					session.setAttribute("baggage",(rs.getInt(9)));
					
					
					response.sendRedirect("/FlyAwayP2/FlightDetails.jsp");
					
					
				
				}
				
			}		
							
		
			
			catch( Exception e){
				response.sendRedirect("/FlyAwayP2/index.html");
				
			}
		}	
}
