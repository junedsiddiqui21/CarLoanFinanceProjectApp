package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
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
	private int professionid;
	private String professiontype;
	private double professionsalary;
	private String professionsalarytype;
	private String professionworkingperiod;
	private String professionDesignation;
	@Lob
	private byte professionsalaryslip;
}
