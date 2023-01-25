package com.simpli.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddAirline")
public class AddAirline extends HttpServlet {
	String url="jdbc:mysql://localhost:3306/flyawaydb";
	String user="root";
	String pwd="mysql";
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		int price = 0;
		int baggage=0;
		String flightnumber=req.getParameter("flightnumber");
		String airline=req.getParameter("airline");
		String source=req.getParameter("source");
		String destination=req.getParameter("destination");
		java.util.Date selectedDate;
		java.sql.Date selectedSQLDate = null ;
		try {
			selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("traveldate"));
			
	        
	      selectedSQLDate =  new java.sql.Date(selectedDate.getTime());
	      System.out.println(selectedSQLDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String time= req.getParameter("flighttime");
		try{
			String rate=req.getParameter("price");
			price=Integer.parseInt(rate);
			String weight=req.getParameter("baggage");
			baggage=Integer.parseInt(weight);
		} catch(NumberFormatException ex){
			ex.printStackTrace();
		}
		
		String duration=req.getParameter("duration");
		
		resp.setContentType("text/html");
		if(price!=0&&baggage!=0 && duration!="" &&source!="" &&destination!=" "&&flightnumber!=" "&&airline!=" "&&time!="" ) {
		ModelAdmin m=new ModelAdmin();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pwd);
			
			String sql="insert into  flightdetails values (?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, flightnumber);
			pstmt.setString(2, airline);
			pstmt.setString(3, source);
			pstmt.setString(4, destination);
			pstmt.setDate(5, selectedSQLDate);
			pstmt.setString(6, time);
			pstmt.setInt(7,price);
			pstmt.setString(8,duration);
			pstmt.setInt(9, baggage);
			int value=pstmt.executeUpdate();
			if(value>0) {
				System.out.println("values inserted successfully");
				resp.sendRedirect("/FlyAwayP2/AdminSuccess.html"); 
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			//resp.sendRedirect("/FlyAwayP2/WentWrongMessage.html");
		}
		
		}else {
			resp.sendRedirect("/FlyAwayP2/WentWrongMessage.html");
		}
		//resp.sendRedirect("/FlyAwayP2/WentWrongMessage.html");
	}
	

}
