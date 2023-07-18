package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bitlogicsystem.carloanfinance.app.model.EmiCalculator;
import com.bitlogicsystem.carloanfinance.app.service.EmiService;

@Service
public class EmiServiceImpl implements EmiService {
	
	@Override
	public EmiCalculator calculatedEmi(EmiCalculator e) {
		
		DecimalFormat df=new DecimalFormat("#.##");
		
		double p = e.getLoan_Amount();
		double rates = e.getInterest_rates()/(12*100);
		double n = e.getTenure();
		double monthly_emi = (p*rates*Math.pow(1+rates,n))/(Math.pow(1+rates,n)-1);	
		double interestAmount = (monthly_emi*n)-p;
		double totalpayableAmount = p+interestAmount;
		
		e.setEmi(df.format(monthly_emi));
		e.setInterest_Amount(df.format(interestAmount));
		e.setTotal_payable_Amount(df.format(totalpayableAmount));
		System.out.println(monthly_emi);
		
		return e;
	}
	

}
