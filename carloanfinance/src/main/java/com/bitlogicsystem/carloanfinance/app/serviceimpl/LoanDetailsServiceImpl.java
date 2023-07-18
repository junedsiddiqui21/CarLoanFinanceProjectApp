package com.bitlogicsystem.carloanfinance.app.serviceimpl;


import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.model.LoanDetails;
import com.bitlogicsystem.carloanfinance.app.repository.LoanDetailsRepository;
import com.bitlogicsystem.carloanfinance.app.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService
{
	@Autowired
	LoanDetailsRepository loanDetailsRepository;
	
	@Override
	public LoanApplication LoanDetail(LoanApplication lapp) 
	{	
		DecimalFormat df=new DecimalFormat("#.##");
		
		double principle=lapp.getLoandetails().getCustemorLoanAmmount();
		
		double rate=lapp.getLoandetails().getCustomerInterestRate()/(12*100);
		
		double n=lapp.getLoandetails().getCustomerLoanTenure();
	
		double monthlyemi=(principle*rate*Math.pow(1+rate,n))/(Math.pow(1+rate,n)-1);
		//df.format(monthlyemi);
		
		double processfees=principle*(0.5/100);
		
		lapp.getLoandetails().setCustomerEMI(df.format(monthlyemi));
		lapp.getLoandetails().setCustomerProcessingFees(processfees);
		
		System.out.println("Processing fees"+processfees);
		System.out.println("Monthly Emi"+(monthlyemi));
		
		
		return loanDetailsRepository.save(lapp);
	}

	@Override
	public List<LoanApplication> getLoanDetails() 
	{
		return loanDetailsRepository.findAll();
	}

	@Override
	public LoanApplication getLoanData(int cid) {
		
		 Optional<LoanApplication> loanapp=loanDetailsRepository.findById(cid);
		 if (loanapp.isPresent()) 
		{
			 LoanApplication lapp=loanapp.get();
			 return lapp;
		}
		 return null;
	}

	
}
