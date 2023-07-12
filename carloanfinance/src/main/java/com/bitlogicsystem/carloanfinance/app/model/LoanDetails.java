package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanDetails 
{
	@Id
	private int customerloanid;
	private double custemorLoanAmmount;
	private long customerLoanTenure;
	private double customerInterestRate;
	private double customerEMI;
	private double customerProcessingFees;
}
