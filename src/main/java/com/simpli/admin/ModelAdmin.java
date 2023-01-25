package com.simpli.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
@WebServlet("/ModelAdmin")
public class ModelAdmin {
	String url="jdbc:mysql://localhost:3306/flyawaydb";
	String user="root";
	String pwd="mysql";
	
	String admin_uname;
	String admin_pwd;
	int admin_id;
	String admin_email;
	String admin_role;
	

	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public String getAdmin_uname() {
		return admin_uname;
	}
	public void setAdmin_uname(String admin_uname) {
		this.admin_uname = admin_uname;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	public ModelAdmin() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pwd);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean adminverify() {
	
		try {
			String sql="select * from admin where admin_uname=? and admin_pwd=?";
			
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,admin_uname);
			pstmt.setString(2, admin_pwd);
			rs=pstmt.executeQuery();
			while(rs.next()==true) {
				//admin_uname=rs.getString(2);
				if((admin_uname.equals(rs.getString(2)))&&(admin_pwd.equals(rs.getString(3)))){
					System.out.println("successs");
					return true;
				}
				else {
					return false;
				}
			}
			
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean updatePwd() {
		
		try {
			String sql="update admin set admin_pwd=? where admin_id=?";
			
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,admin_pwd);
			pstmt.setInt(2,admin_id);
			
			int x=pstmt.executeUpdate();
			
			if(admin_pwd.isEmpty()) {
				//admin_uname=rs.getString(2);
				//System.out.println("successs");
				return false;
			}
			
			else {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
}
