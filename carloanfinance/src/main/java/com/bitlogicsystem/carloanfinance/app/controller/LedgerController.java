package com.bitlogicsystem.carloanfinance.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.Ledger;
import com.bitlogicsystem.carloanfinance.app.service.LedgerService;
@CrossOrigin("*")
@RestController
public class LedgerController {
	
	@Autowired
	private LedgerService ledgerservice;
	
	@PostMapping("/saveLedger")
	public ResponseEntity<Ledger> saveLedger(@RequestBody Ledger ledger){
		 
	Ledger l=ledgerservice.saveLedger(ledger);
		
		return new ResponseEntity<Ledger>(l,HttpStatus.CREATED);
		
	}
	@GetMapping("/getLedger")
	public ResponseEntity<List<Ledger>> getLedger(){
		List<Ledger> ledgerlist=ledgerservice.getLedger();
		
		return new ResponseEntity<List<Ledger>>(ledgerlist,HttpStatus.OK) ;
		
	}
	@GetMapping("/singleLedger/{ledgerId}")
	public ResponseEntity<Ledger> singleLedger(@PathVariable int ledgerId ){
		
		Ledger singleLedger=ledgerservice.singleLedger(ledgerId);
		return new ResponseEntity<Ledger>(singleLedger,HttpStatus.OK);
		
	}
	
	

}
