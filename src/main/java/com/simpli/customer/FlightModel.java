package com.simpli.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.simpli.customer.Model;
@WebServlet("/FlightModel")
public class FlightModel {
	
	private Connection con = null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
public List<Model> getAvailFlights(){

		List<Model> mArrayList=new ArrayList<Model>();
		try {
			con = DBConnectUser.getConnection();
			String sql="select * from flightdetails";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				Model mlist=new Model();
				mlist.setFlightnumber(rs.getString(1));
				mlist.setAirline(rs.getString(2));
				mlist.setSource(rs.getString(3));
				mlist.setDestination(rs.getString(4));
				mlist.setTraveldate(rs.getDate(5));
				
				mArrayList.add(mlist);
				
			}
			
				//return false;
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return mArrayList;
	}


public boolean getPrice() {
	try {
		con = DBConnectUser.getConnection();
		String sql="select * from flightdetails";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			
			int price=rs.getInt(7);
			return true;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return false;
}

}
