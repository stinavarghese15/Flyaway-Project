package com.simpli.customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Time;
import java.util.Date;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Model")
public class Model {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String flightnumber;
	String airline;
	String source;
	String destination;
	Date traveldate;
	Time flighttime;
	int price;
	String duration;
	int baggage;
	
	
	public Time getFlighttime() {
		return flighttime;
	}
	public void setFlighttime(Time flighttime) {
		this.flighttime = flighttime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getBaggage() {
		return baggage;
	}
	public void setBaggage(int baggage) {
		this.baggage = baggage;
	}
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getTraveldate() {
		return traveldate;
	}
	public void setTraveldate(Date traveldate) {
		this.traveldate = traveldate;
	}

}
