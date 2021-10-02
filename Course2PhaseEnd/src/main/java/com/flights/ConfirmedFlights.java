package com.flights;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_confirmed")
public class ConfirmedFlights {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int confKey;
	private String fname;
	private String lname;
	private String streetname;
	private String state;
	private String zipcode;
	private String airlinename;
	private String flightnum;
	private int numPass;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAirlinename() {
		return airlinename;
	}
	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}
	public int getConfKey() {
		return confKey;
	}
	public String getFlightnum() {
		return flightnum;
	}
	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
	}
	public int getNumPass() {
		return numPass;
	}
	public void setNumPass(int numPass) {
		this.numPass = numPass;
	}
	public ConfirmedFlights(String fname, String lname, String streetname, String state, String zipcode,
			String airlinename, String flightnum, int numPass) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.streetname = streetname;
		this.state = state;
		this.zipcode = zipcode;
		this.airlinename = airlinename;
		this.flightnum = flightnum;
		this.numPass = numPass;
	}
	public ConfirmedFlights() {
		super();
	}

	
	
	
	
	
}
