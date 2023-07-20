package com.bitlogicsystem.carloanfinance.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.BankTransaction;
import com.bitlogicsystem.carloanfinance.app.model.BaseResponse;
import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.service.TransactionService;

@RestController
public class TransactionController
{
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/save_transaction/{customerId}")
	public BaseResponse saveTransaction(@PathVariable("customerId")int cid,@RequestBody BankTransaction bt)
	{
		return transactionService.saveTransaction(cid,bt);
	}
	
	@GetMapping("/get_transaction/{customerId}")
	public LoanApplication getTransaction(@PathVariable("customerId") int cid )
	{
		return transactionService.getTransaction(cid);
	}
}
