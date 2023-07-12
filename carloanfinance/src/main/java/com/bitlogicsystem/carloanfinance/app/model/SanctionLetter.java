package com.bitlogicsystem.carloanfinance.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class SanctionLetter 
{
	@Id
	private int sanctionId;
	@CreationTimestamp
	private Date sanctionDate;
	private String applicantName;
	private long contactDetails;
	private double loanAmmountSanctioned;
	private String interestType;
	private double rateOfInterest;
	private int loanTenure;
	private double monthlyEmiAmmount;
	private String modeOfPayment;
	private String remarks;
	private String termCondition;
	private String status;
}