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
	
	//<-------------------------------------Loan Application--------------------------------------------------->
	@Override
	public LoanApplication saveloan(LoanApplication loanapp) 
	{
		return loanapprepository.save(loanapp);
	}

	@Override
	public List<LoanApplication> getloan(int cid) 
	{
		return loanapprepository.findByCustomerId(cid);
	}

	@Override
	public void deleteloan(int cid)
	{
		loanapprepository.deleteById(cid);
	}

	@Override
	public LoanApplication editloan(int cid) 
	{
		Optional<LoanApplication> loanapp=loanapprepository.findById(cid);
		if (loanapp.isPresent())
		{
			LoanApplication l=loanapp.get();
			return l;
		}
		return null;
	}

	@Override
	public LoanApplication updateloan(LoanApplication loanapp) 
	{
		return loanapprepository.save(loanapp);
	}
	
	//<----------------------------------Bank Details-------------------------------------------->
	
	@Override
	public LoanApplication saveBankDetail(LoanApplication lapp)
	{
		return loanapprepository.save(lapp);
	}

	@Override
	public LoanApplication getBankDetail(int cid) 
	{
		 Optional<LoanApplication> oploan =loanapprepository.findById(cid);
		 if (oploan.isPresent())
		{
			 LoanApplication la=oploan.get();
			 return la;
		}
		 return null;
	}

	@Override
	public List<LoanApplication> getBankDetais() 
	{
		return loanapprepository.findAll();
	}

}
