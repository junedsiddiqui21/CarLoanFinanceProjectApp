package com.bitlogicsystem.carloanfinance.app.service;


import java.util.Optional;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;

public interface LoanApplicationService 
{

	public LoanApplication saveloan(LoanApplication loanapp);

	public Optional<LoanApplication> getloan(int cid);

}
