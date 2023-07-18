package com.bitlogicsystem.carloanfinance.app.service;



import java.util.List;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;


public interface LoanDetailsService 
{

	LoanApplication LoanDetail(LoanApplication lapp);

	List<LoanApplication> getLoanDetails();

	LoanApplication getLoanData(int cid);
}
