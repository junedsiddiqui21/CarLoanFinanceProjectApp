package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.repository.LoanApplicationRepository;
import com.bitlogicsystem.carloanfinance.app.service.LoanApplicationService;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService
{
	@Autowired
	LoanApplicationRepository loanapprepository;
	
	@Override
	public LoanApplication saveloan(LoanApplication loanapp) 
	{
		return loanapprepository.save(loanapp);
	}

	@Override
	public Optional<LoanApplication> getloan(int cid) 
	{
		Optional<LoanApplication> loanapp =loanapprepository.findById(cid);
	
		if (loanapp.isPresent()) 
		{
			loanapp.get();
			
			return loanapp;
		}
		return null;
	}

}
