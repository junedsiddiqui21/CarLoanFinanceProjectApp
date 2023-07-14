package com.bitlogicsystem.carloanfinance.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiCalculator {
	
	private double loan_Amount;
	private double interest_rates;
	private double tenure;  // In Months
	private double emi;
	private double interest_Amount;
	private double total_payable_Amount;

}
