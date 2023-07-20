package com.bitlogicsystem.carloanfinance.app.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;
import com.bitlogicsystem.carloanfinance.app.service.LoanApplicationService;
import com.bitlogicsystem.carloanfinance.app.service.SanctionService;

@CrossOrigin("*")
@RestController
public class SanctionLetterController {

	@Autowired
	private SanctionService si;

	@PostMapping(value = "/saveSanctionLetter")
	public ResponseEntity<LoanApplication> SanctionLetterpost(@RequestBody LoanApplication sc) {

		LoanApplication sacletter = si.saveSanctionLetter(sc);

		ByteArrayInputStream pdf = si.createSanctionpdf(sacletter.getCustomerId());

		return new ResponseEntity<LoanApplication>(sacletter, HttpStatus.OK);

	}

	@PutMapping(value = "/updatesanctionStatus/{customerId}")
	public ResponseEntity<String> updateLoanStatus(@RequestBody SanctionLetter sanletter,
			@PathVariable int customerId) {
//		si.updateLoanStatus(sanletter);
		si.sendSanctionMail(sanletter.getSanctionId());

		return new ResponseEntity<String>("Emailsucessfullysend", HttpStatus.OK);
	}

	@GetMapping(value = "/getSanctionLetterById/{sanctionId}")
	public ResponseEntity<SanctionLetter> getsacLetter(@PathVariable int sanctionId) {
		
		
		SanctionLetter	st= si.getsacLetter(sanctionId);

		

		return new ResponseEntity<SanctionLetter>(st, HttpStatus.OK);
	}
}
