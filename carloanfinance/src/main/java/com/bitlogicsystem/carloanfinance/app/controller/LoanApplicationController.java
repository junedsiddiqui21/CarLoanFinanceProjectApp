package com.bitlogicsystem.carloanfinance.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.service.LoanApplicationService;


@RestController
public class LoanApplicationController 
{
	@Autowired
	LoanApplicationService loanappservice;
	
	@PostMapping("save_loandata")
	public LoanApplication loanDetail(@RequestBody LoanApplication loanapp)
	{
		return loanappservice.saveloan(loanapp);
	}
	
	@GetMapping("get_loandata/{customerId}")
	public Optional<LoanApplication> getLoanDetail(@PathVariable("customerId")int cid)
	{
		return loanappservice.getloan(cid);
	}
	
}
