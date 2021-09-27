package com.flights;


import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_itin")
public class Itinerary {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itinKey;
	private String itinID;
	private String departDate;
	private String departLoc;
	private String destLoc;
	Schedule schedule;
	Airlines airline;
	
	
	public String getItinID() {
		return itinID;
	}
	public void setItinID(String itinID) {
		this.itinID = itinID;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	public String getDepartLoc() {
		return departLoc;
	}
	public void setDepartLoc(String departLoc) {
		this.departLoc = departLoc;
	}
	public String getDestLoc() {
		return destLoc;
	}
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Airlines getAirline() {
		return airline;
	}
	public void setAirline(Airlines airline) {
		this.airline = airline;
	}
	public int getItinKey() {
		return itinKey;
	}
	public Itinerary(String itinID, String departDate, String departLoc, String destLoc, Schedule schedule,
			Airlines airline) {
		super();
		this.itinID = itinID;
		this.departDate = departDate;
		this.departLoc = departLoc;
		this.destLoc = destLoc;
		this.schedule = schedule;
		this.airline = airline;
	}
	public Itinerary() {
		super();
	}

	
	
	
	
	
}
