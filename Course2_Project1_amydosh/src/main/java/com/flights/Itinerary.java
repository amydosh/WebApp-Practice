package com.flights;

import java.util.Date;
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
	private int itinId;
	private String departDate;
	private String departLoc;
	private String destLoc;
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
	public int getItinId() {
		return itinId;
	}
	public Itinerary(int itinId, String departDate, String departLoc, String destLoc) {
		super();
		this.itinId = itinId;
		this.departDate = departDate;
		this.departLoc = departLoc;
		this.destLoc = destLoc;
	}
	public Itinerary() {
		super();
	}
	public Itinerary(String departDate, String departLoc, String destLoc) {
		super();
		this.departDate = departDate;
		this.departLoc = departLoc;
		this.destLoc = destLoc;
	}
	
}
