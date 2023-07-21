package com.bitlogicsystem.carloanfinance.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.BankDetails;
import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.service.LoanApplicationService;

@CrossOrigin("*")
@RestController
public class LoanApplicationController 
{
	@Autowired
	LoanApplicationService loanappservice;
	
	//<-------------------------------Loan Application----------------------------------------->
	
	@PostMapping("/save_loanappdata")
	public ResponseEntity<LoanApplication> loanDetail(@RequestBody LoanApplication loanapp)
	{
		LoanApplication lapp = loanappservice.saveloan(loanapp);
		
		return new ResponseEntity<LoanApplication>(lapp,HttpStatus.CREATED);
	}
	
	@GetMapping("/get_loanappdata/{customerId}")
	public ResponseEntity<List<LoanApplication>> getloanDetail(@PathVariable("customerId")int cid)
	{
		List<LoanApplication> listloan=loanappservice.getloan(cid);
		
		return new ResponseEntity<List<LoanApplication>>(listloan,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_loanappdata/{customerId}")
	public ResponseEntity<String> deleteLoanDetail(@PathVariable("customerId")int cid)
	{
		 loanappservice.deleteloan(cid);
		 
		 return new ResponseEntity<String>("Record Deleted",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/edit_loanappdata/{customerId}")
	public ResponseEntity<LoanApplication> editLoanDetail(@PathVariable("customerId")int cid)
	{
		
		LoanApplication eloan=loanappservice.editloan(cid);
	
		return new ResponseEntity<LoanApplication>(eloan,HttpStatus.OK);
	}
	
	@PutMapping("/update_loanappdata")
	public ResponseEntity<LoanApplication> updateloanDetail(@RequestBody LoanApplication loanapp)
	{
		LoanApplication lapp1=loanappservice.updateloan(loanapp);
		
		return new ResponseEntity<LoanApplication>(lapp1,HttpStatus.OK);
	}     
	
	//<----------------------------------For Transaction----------------------------------------->
	
	@PostMapping("/save_bankdetail")
	public ResponseEntity<LoanApplication> saveBankDetails(@RequestBody LoanApplication lapp)
	{
		LoanApplication bankloan=loanappservice.saveBankDetail(lapp);
		
		return new ResponseEntity<LoanApplication>(bankloan,HttpStatus.CREATED);
	}
	
	@GetMapping("/get_bankdetail/{customerId}")
	public ResponseEntity<LoanApplication> getBankDetails(@PathVariable("customerId")int cid)
	{
		LoanApplication bank=loanappservice.getBankDetail(cid);
		
		return new ResponseEntity<LoanApplication>(bank,HttpStatus.OK);
	}
	
	@GetMapping("/get_bankdetail")
	public ResponseEntity<List<LoanApplication>> getBankDetails()
	{
		List<LoanApplication> bankdata=loanappservice.getBankDetais();
		
		return new ResponseEntity<List<LoanApplication>>(bankdata,HttpStatus.OK);
	}
}
