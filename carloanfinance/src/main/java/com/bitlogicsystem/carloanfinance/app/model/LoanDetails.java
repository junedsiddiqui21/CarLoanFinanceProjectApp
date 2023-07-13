package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
