package com.bitlogicsystem.carloanfinance.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.EmiCalculator;
import com.bitlogicsystem.carloanfinance.app.service.EmiService;

@RestController
public class EMIController {

	@Autowired
	private EmiService es;
	
	@PostMapping("/emi")
	public EmiCalculator emiCalculator(@RequestBody EmiCalculator e) {
			
		return es.calculatedEmi(e);
	}

}
