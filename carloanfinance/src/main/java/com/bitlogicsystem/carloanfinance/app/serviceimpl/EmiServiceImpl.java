package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.EmiCalculator;
import com.bitlogicsystem.carloanfinance.app.service.EmiService;

@Service
public class EmiServiceImpl implements EmiService {

	@Override
	public EmiCalculator calculatedEmi(EmiCalculator e) {
		
		double p = e.getPrincipal_Amount();
		double rates = e.getInterest_rates()/(12*100);
		double n = e.getMonthly_installment();
		double monthly_emi = (p*rates*Math.pow(1+rates,n))/(Math.pow(1+rates,n)-1);	
		double interestAmount = (monthly_emi*n)-p;
		double totalpayableAmount = p+interestAmount;
		
		e.setEmi(monthly_emi);
		e.setInterest_Amount(interestAmount);
		e.setTotal_payable_Amount(totalpayableAmount);
		return e;
	}	

}
