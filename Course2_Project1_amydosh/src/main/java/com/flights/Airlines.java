package com.flights;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_airlines")
public class Airlines {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int airlineId;
	private String name;
	private String departLoc;
	private String destLoc;
	
	
	
}
