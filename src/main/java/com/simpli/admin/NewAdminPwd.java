package com.simpli.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NewAdminPwd")
public class NewAdminPwd extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	
			String s1=req.getParameter("admin_id");
			int admin_id=Integer.parseInt(s1);
			String admin_pwd=req.getParameter("admin_pwd");
			String confirm_pwd=req.getParameter("confirm_pwd");
			HttpSession session=req.getSession();
			
			ModelAdmin m=new ModelAdmin();
			m.setAdmin_id(admin_id);
			m.setAdmin_pwd(admin_pwd);
			
			
			PrintWriter out=resp.getWriter();
			
			boolean b=m.updatePwd();
			if(b==true) {
		//		session.setAttribute("Cpwd", confirm_pwd);
		//		session.setAttribute("Adpwd", admin_pwd);
				//req.setAttribute("Cpwd", confirm_pwd);
				//req.setAttribute("Adpwd", admin_pwd);
				out.print("Password changed successfully");
				resp.sendRedirect("/FlyAwayP2/PasswordChange.html");
			}
			else if(confirm_pwd.isEmpty()){
				resp.sendRedirect("/FlyAwayP2/PwdFail.html");
			}
		}
		catch(Exception e) {
			resp.sendRedirect("/FlyAwayP2/AdminSuccess.html");
		}
	}

}
