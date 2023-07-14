package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profession 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int professionid;
	private String professiontype;
	private double professionsalary;
	private String professionsalarytype;
	private String professionworkingperiod;
	private String professionDesignation;
	@Lob
	private byte[] professionsalaryslip;
}
