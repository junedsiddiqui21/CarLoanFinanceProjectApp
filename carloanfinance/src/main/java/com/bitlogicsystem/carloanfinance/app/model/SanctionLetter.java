package com.bitlogicsystem.carloanfinance.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor   
@AllArgsConstructor
@Entity
public class SanctionLetter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Lob
	private byte[] sanctionPdf;
}
