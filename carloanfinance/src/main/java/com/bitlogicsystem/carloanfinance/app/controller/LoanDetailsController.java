package com.bitlogicsystem.carloanfinance.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.service.LoanDetailsService;

@RestController
public class LoanDetailsController 
{
	@Autowired
	LoanDetailsService loanDetailsService;
	
	@PostMapping("save_loandetail")
	public ResponseEntity<LoanApplication> LoanDetail(@RequestBody LoanApplication lapp)
	{
		LoanApplication loanapp=loanDetailsService.LoanDetail(lapp);
		
		return new ResponseEntity<LoanApplication>(loanapp,HttpStatus.CREATED);
	}
	
	@GetMapping("get_loandetail")
	public ResponseEntity<List<LoanApplication>> getLoanDetails()
	{
		List<LoanApplication> ld=loanDetailsService.getLoanDetails();
		
		return new ResponseEntity<List<LoanApplication>> (ld,HttpStatus.OK);
	}
	
	@GetMapping("get_loandetail/{customerId}")
	public ResponseEntity<LoanApplication> getLoanData(@PathVariable("customerId")int cid)
	{
		LoanApplication lapp=loanDetailsService.getLoanData(cid);
		
		return new ResponseEntity<LoanApplication>(lapp,HttpStatus.OK);
	}	
}
