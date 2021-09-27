package com.flights;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
public class Airlines {


	private String airlineName;
	private double ticketPrice;
	private int flightCapacity;
	
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getFlightCapacity() {
		return flightCapacity;
	}
	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}
	public Airlines(String airlineName, double ticketPrice, int flightCapacity) {
		super();
		this.airlineName = airlineName;
		this.ticketPrice = ticketPrice;
		this.flightCapacity = flightCapacity;
	}
	public Airlines() {
		super();
	}
	@Override
	public String toString() {
		return "Airline Name: " + airlineName +"\r\n"+ "Ticket Price: " + ticketPrice +"\r\n"+ "Flight Capacity: "	+ flightCapacity;
	}
	
	
	
	
}
