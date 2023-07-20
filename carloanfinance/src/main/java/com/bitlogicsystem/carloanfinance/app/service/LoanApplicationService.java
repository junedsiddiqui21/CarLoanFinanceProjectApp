package com.bitlogicsystem.carloanfinance.app.service;


import java.util.List;


import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;

public interface LoanApplicationService 
{
	//<-----------------------Loan Application------------------------------->
	public LoanApplication saveloan(LoanApplication loanapp);
	public List<LoanApplication> getloan(int cid);
	public void deleteloan(int cid);
	public LoanApplication editloan(int cid);
	public LoanApplication updateloan(LoanApplication loanapp);
	
	
	//<----------------------Bank Details----------------------------------->
	public LoanApplication saveBankDetail(LoanApplication lapp);
	public LoanApplication getBankDetail(int cid);
	public List<LoanApplication> getBankDetais();
	
}
