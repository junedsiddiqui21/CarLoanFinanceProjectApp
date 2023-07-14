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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.Enquiry;
import com.bitlogicsystem.carloanfinance.app.service.EnquiryService;

@RestController
@RequestMapping("/Enquiry")
@CrossOrigin("*")
public class EnquiryController {
	@Autowired
	private EnquiryService enquiryservice;
	
	
	@PostMapping("/SaveEnquiry")
	public ResponseEntity<Enquiry> SaveEnquiry(@RequestBody Enquiry enquiry){
		
		  Enquiry eq=enquiryservice.saveEnquiry(enquiry);
		
		return new ResponseEntity<Enquiry>(eq,HttpStatus.OK);
		
	}
	@GetMapping("/GetEnquiry")
	public ResponseEntity<List<Enquiry>> getEnquiry(){
		
		List<Enquiry> elist=	enquiryservice.getEnquiry();
		return new ResponseEntity<List<Enquiry>>( elist,HttpStatus.OK);
		
	}
	@DeleteMapping("/DeleteEnquiry/{cid}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable int cid){
		
		enquiryservice.deleteEnquiry(cid);
		return new ResponseEntity<String>("Delete EnquirySucessfully",HttpStatus.OK);
		
	}
	@GetMapping("/singleEnquiry/{cid}")
	public ResponseEntity<Enquiry> getSingleEnquiry(@PathVariable int cid){
		
		Enquiry et=enquiryservice.getSingleEnquiry(cid);
		return new ResponseEntity<Enquiry>(et,HttpStatus.OK);
		
		
	}

}
