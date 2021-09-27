package com.flights;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
public class Schedule {
	
	
	private String flightNum;
	private String departTime;
	private String arriveTime;
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public Schedule(String flightNum, String departTime, String arriveTime) {
		super();
		this.flightNum = flightNum;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
	}
	public Schedule() {
		super();
	}
	@Override
	public String toString() {
		
		return "Flight Number: " + flightNum + "\r\n"+"Departure Time: " + departTime +"\r\n" + "Arrival Time: " + arriveTime;				
	}
	

	


}
