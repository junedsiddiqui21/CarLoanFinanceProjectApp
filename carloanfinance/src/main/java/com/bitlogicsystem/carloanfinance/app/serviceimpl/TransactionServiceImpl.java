package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.BankTransaction;
import com.bitlogicsystem.carloanfinance.app.model.BaseResponse;
import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.repository.TransactionRepository;
import com.bitlogicsystem.carloanfinance.app.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public BaseResponse saveTransaction(int cid, BankTransaction bt) 
	{
		Optional<LoanApplication> loanapp=transactionRepository.findById(cid);
		
		if(loanapp.isPresent())
		{
			LoanApplication lapp=loanapp.get();
			
			if (bt.getTransactionType().equals("Withdrawl")) 
			{
				double preacbal=lapp.getBankDetails().getAccountBalance();
				
				lapp.getBankDetails().setAccountBalance(preacbal-bt.getTransactionAmmount());
				
				bt.setRemainingAccountBalance(preacbal);
				
				lapp.getBankTransaction().add(bt);
				
				transactionRepository.save(lapp);
				
				return new BaseResponse(201,"Ammount Withdraw Successfully");
			}
			else if(bt.getTransactionType().equals("credit"))
			{
				double preacbal=lapp.getBankDetails().getAccountBalance();
				
				lapp.getBankDetails().setAccountBalance(preacbal+bt.getTransactionAmmount());
				
				bt.setRemainingAccountBalance(preacbal);
				
				lapp.getBankTransaction().add(bt);
				
				transactionRepository.save(lapp);
				
				return new BaseResponse(201,"Ammount Credit Successfully");
			}
		}
		
				return new BaseResponse(404,"Invalid User");	
	}       

	@Override
	public LoanApplication getTransaction(int cid) 
	{
		Optional<LoanApplication> lapp=transactionRepository.findById(cid);
		
		if (lapp.isPresent())
		{
			LoanApplication loanapp=lapp.get();
			
			return loanapp;
		}
		return null;
	 }

}
