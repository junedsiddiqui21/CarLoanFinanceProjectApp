package com.bitlogicsystem.carloanfinance.app.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

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

import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;
import com.bitlogicsystem.carloanfinance.app.service.SanctionService;

@CrossOrigin("*")
@RestController
public class SanctionLetterController {

	@Autowired
	private SanctionService si;

	@PostMapping(value = "/saveSanctionLetter")
	public ResponseEntity<SanctionLetter> SanctionLetterpost(@RequestBody SanctionLetter sc) {

		System.out.println("hiii");
//		sc.setSanctionLetterPdf(sanctionLetterPdf.getBytes());

		SanctionLetter sacletter = si.saveSanctionLetter(sc);

		ByteArrayInputStream pdf = si.createSanctionpdf(sacletter.getSanctionId());

		return new ResponseEntity<SanctionLetter>(sacletter, HttpStatus.OK);

	}

	@PutMapping(value = "/updatesanctionStatus/{sanctionid}")
	public ResponseEntity<String> updateLoanStatus(@PathVariable int sanctionId) {

		si.sendSanctionMail(sanctionId);

		return new ResponseEntity<String>("Emailsucessfullysend", HttpStatus.OK);
	}

	@GetMapping("/getSanctiondetails/{sanctionId}")
	public List<SanctionLetter> getallSanctiondetails(@PathVariable int SanctionId) {

		return si.getallSanctiondetails(SanctionId);

	}
}
