package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LocalAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int localAddressId;
	private String areaName;
	private String cityName;
	private String streetName;
	private String districtName;
	private String stateName;
	private long pincode;	
}
