package com.flights;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int schedId;
	private String flightNum;
	private String Airline;
	private Time departTime;
	private Time arriveTime;
	private double ticketPrice;
	private int flightCap;
	
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getAirline() {
		return Airline;
	}
	public void setAirline(String airline) {
		Airline = airline;
	}
	public Time getDepartTime() {
		return departTime;
	}
	public void setDepartTime(Time departTime) {
		this.departTime = departTime;
	}
	public Time getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Time arriveTime) {
		this.arriveTime = arriveTime;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getFlightCap() {
		return flightCap;
	}
	public void setFlightCap(int flightCap) {
		this.flightCap = flightCap;
	}
	public int getSchedId() {
		return schedId;
	}
	public Schedule(int schedId, String flightNum, String airline, Time departTime, Time arriveTime, double ticketPrice,
			int flightCap) {
		super();
		this.schedId = schedId;
		this.flightNum = flightNum;
		Airline = airline;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.ticketPrice = ticketPrice;
		this.flightCap = flightCap;
	}
	public Schedule() {
		super();
	}
	


}
