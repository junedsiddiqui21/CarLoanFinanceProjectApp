package com.bitlogicsystem.carloanfinance.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<LoanApplication> loanDetail(@RequestBody LoanApplication loanapp)
	{
		LoanApplication lapp = loanappservice.saveloan(loanapp);
		
		return new ResponseEntity<LoanApplication>(lapp,HttpStatus.CREATED);
	}
	
	@GetMapping("get_loandata/{customerId}")
	public ResponseEntity<List<LoanApplication>> getloanDetail(@PathVariable("customerId")int cid)
	{
		List<LoanApplication> listloan=loanappservice.getloan(cid);
		
		return new ResponseEntity<List<LoanApplication>>(listloan,HttpStatus.OK);
	}
	
	@DeleteMapping("delete_loandata/{customerId}")
	public ResponseEntity<String> deleteLoanDetail(@PathVariable("customerId")int cid)
	{
		 loanappservice.deleteloan(cid);
		 
		 return new ResponseEntity<String>("Record Deleted",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("edit_loandata/{customerId}")
	public ResponseEntity<LoanApplication> editLoanDetail(@PathVariable("customerId")int cid)
	{
		
		LoanApplication eloan=loanappservice.editloan(cid);
	
		return new ResponseEntity<LoanApplication>(eloan,HttpStatus.OK);
	}
	
	@PutMapping("update_loandata")
	public ResponseEntity<LoanApplication> updateloanDetail(@RequestBody LoanApplication loanapp)
	{
		LoanApplication lapp1=loanappservice.updateloan(loanapp);
		
		return new ResponseEntity<LoanApplication>(lapp1,HttpStatus.OK);
	}
}
