package com.simpli.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/ShowFlight")
/**
 * Servlet implementation class ShowFlight
 */
public class ShowFlight extends HttpServlet {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	int totalPrice;
	int numofpass;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		
		java.util.Date selectedDate;
		java.sql.Date selectedSQLDate = null ;
		try {
			selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("traveldate"));
			
	        
	      selectedSQLDate =  new java.sql.Date(selectedDate.getTime());
	      System.out.println(selectedSQLDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		PrintWriter out=response.getWriter();
		
		Model m=new Model();
	/*	int totalfare=m.getPrice() *  numofpass;
		System.out.println("hiii hloo"+totalfare);*/
		
		//m.setSource(source);
		//m.setDestination(destination);
		//m.setTraveldate(selectedSQLDate);
		
		try {
		
			
			con=DBConnectUser.getConnection();
			
			String sql="select * from flightdetails where traveldate=? and source=? and destination=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setDate(1, selectedSQLDate);
			pstmt.setString(2,source);
			pstmt.setString(3,destination);
		
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				
			
				FlightModel fm=new FlightModel();
				List<Model> list=fm.getAvailFlights();
				session.setAttribute("list",list);
				response.sendRedirect("/FlyAwayP2/DisplayFlight.jsp");
				
			}
			else {
				response.sendRedirect("/FlyAwayP2/NoFlight.html");
			}
	
		}
		catch( Exception e){
			response.sendRedirect("/FlyAwayP2/index.html");
			
		}
		
	}

	

}
