package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profession 
{
	@Id
	private int professionid;
	private String professiontype;
	private double professionsalary;
	private String professionsalarytype;
	private String professionworkingperiod;
	private String professionDesignation;
	private byte professionsalaryslip;
}
