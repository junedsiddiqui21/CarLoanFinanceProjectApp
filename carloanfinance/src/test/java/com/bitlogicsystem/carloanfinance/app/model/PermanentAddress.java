package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PermanentAddress 
{
	@Id
	private int permanentAddressId;
	private String areaName;
	private String cityName;
	private String streetName;
	private String districtName;
	private String stateName;
	private long pincode;	
}
