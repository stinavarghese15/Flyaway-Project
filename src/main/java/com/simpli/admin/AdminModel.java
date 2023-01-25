package com.simpli.admin;
import com.simpli.customer.Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simpli.customer.DBConnectUser;
import com.simpli.customer.Model;

public class AdminModel {
	private Connection con = null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/flyawaydb";
	String user="root";
	String pwd="mysql";
	
	
public List<ModelAdmin> getAdminData(){

		List<ModelAdmin> mArrayList=new ArrayList<ModelAdmin>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			String sql="select * from admin";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				ModelAdmin mlist=new ModelAdmin();
				mlist.setAdmin_id(rs.getInt(1));
				mlist.setAdmin_uname(rs.getString(2));
				mlist.setAdmin_pwd(rs.getString(3));
				mlist.setAdmin_email(rs.getString(4));
				mlist.setAdmin_role(rs.getString(5));
			
				mArrayList.add(mlist);
				
			}
			
				//return false;
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mArrayList;
	}



public List<Model> getFlightData(){

	List<Model> mArrayFlightList=new ArrayList<Model>();
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pwd);
		String sql="select * from flightdetails";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			
			Model mflightlist=new Model();
			
			mflightlist.setFlightnumber(rs.getString(1));
			mflightlist.setFlightnumber(rs.getString(1));
			mflightlist.setAirline(rs.getString(2));
			mflightlist.setSource(rs.getString(3));
			mflightlist.setDestination(rs.getString(4));
			mflightlist.setTraveldate(rs.getDate(5));
			mflightlist.setFlighttime(rs.getTime(6));
			mflightlist.setPrice(rs.getInt(7));
			mflightlist.setDuration(rs.getString(8));
			mflightlist.setBaggage(rs.getInt(9));
		
			mArrayFlightList.add(mflightlist);
			
		}
		
			//return false;
					
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mArrayFlightList;
}

}
