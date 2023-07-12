package com.bitlogicsystem.carloanfinance.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiCalculator {
	
	
	private double principal_Amount;
	private double interest_rates;
	private double monthly_installment;  // In Months
	private double emi;

}
