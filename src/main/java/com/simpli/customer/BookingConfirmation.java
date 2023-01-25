package com.simpli.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookingConfirmation")
public class BookingConfirmation extends HttpServlet {

	

	private ServletRequest sc;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String passengername=req.getParameter("passengername");
		String passportnumber=req.getParameter("passportnumber");
		String nationality=req.getParameter("nationality");
		int numofpass=0;
		try {
		String s=req.getParameter("numofpass");
		numofpass=Integer.parseInt(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String s2=req.getParameter("ticketPrice");
		System.out.println(s2);
		int ticketPrice=Integer.parseInt(s2);
		
		int totalFare=0;
		
		
		HttpSession session=req.getSession();
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		totalFare=(numofpass * ticketPrice);
		System.out.println(totalFare);
		if(passengername.isEmpty()&& passportnumber.isEmpty()&& nationality.isEmpty()&&numofpass==0) {
			resp.sendRedirect("/FlyAwayP2/WentWrongMessage.html");
		}
		else {
		resp.sendRedirect( "/FlyAwayP2/BookingConfirmation.jsp?totalFare="+totalFare );
		}
		//req.setAttribute("TotalFare", totalFare);
	//	RequestDispatcher rd = req.getRequestDispatcher("/FlyAwayP2/BookingConfirmation.jsp");
	//	resp.sendRedirect("/FlyAwayP2/BookingConfirmation.jsp");
	//	rd.include(req, resp);
		
		
	
	}

	
}
