package com.simpli.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simpli.customer.DBConnectUser;
import com.simpli.customer.FlightModel;
import com.simpli.customer.Model;

@WebServlet("/AllDataDisplay")
public class AllDataDisplay extends HttpServlet{

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	int admin_id= Integer.parseInt(req.getParameter("admin_id"));
		
		
		String driver = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/flyawaydb";
		String user="root";
		String pwd="mysql";
		
		
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		
		ModelAdmin m=new ModelAdmin();
		
		try {
			
			System.out.println("Reached");
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			String sql="select * from admin";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				
				
				
				AdminModel am=new AdminModel();
				List<ModelAdmin> list=am.getAdminData();
				session.setAttribute("list",list);
				resp.sendRedirect("/FlyAwayP2/AdminDetails.jsp");
				
			}
			
		}		
						
	
		
		catch( Exception e){
			resp.sendRedirect("/FlyAwayP2/AdminSuccess.html");
			
		}
		
	}

	
}
