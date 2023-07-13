package com.bitlogicsystem.carloanfinance.app.service;


import java.util.List;


import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;

public interface LoanApplicationService 
{

	public LoanApplication saveloan(LoanApplication loanapp);
	public List<LoanApplication> getloan(int cid);
	public void deleteloan(int cid);
	public LoanApplication editloan(int cid);
	public LoanApplication updateloan(LoanApplication loanapp);
}
