package com.simpli.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginVerify")
public class AdminLoginVerify extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String admin_uname=req.getParameter("admin_uname");
		String admin_pwd=req.getParameter("admin_pwd");
		
		ModelAdmin m=new ModelAdmin();
		m.setAdmin_uname(admin_uname);
		m.setAdmin_pwd(admin_pwd);
		PrintWriter out=resp.getWriter();
		boolean b=m.adminverify();
		System.out.println("thanks");
		if(b==true) {
			System.out.println("okk");
			out.print("done");
			resp.sendRedirect("/FlyAwayP2/AdminSuccess.html");
		}
		else {
			resp.sendRedirect("/FlyAwayP2/AdminVerifyFail.html");
		}
	}

	
}
