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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

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
	enquiry.setCibilstatus("pending");
		  Enquiry eq=enquiryservice.saveEnquiry(enquiry);
		
		return new ResponseEntity<Enquiry>(eq,HttpStatus.OK);	
	}
	
	@GetMapping("/GetEnquiry")
	public ResponseEntity<List<Enquiry>> getEnquiry(){
		
		List<Enquiry> elist=	enquiryservice.getEnquiry();
		return new ResponseEntity<List<Enquiry>>( elist,HttpStatus.OK);
		
	}
	
	@GetMapping("/CheckCIBIL/{cid}")
	public ResponseEntity<Enquiry> checkCibilScore(@PathVariable("cid") Integer cid)
	{
		
		Enquiry enq=enquiryservice.getSingleEnquiry(cid);

		Random ramdom=new Random();
		int cibilScore = ramdom.nextInt(300, 900);
		
		if(cibilScore>=600 && cibilScore<=900) 
		{
			enq.setCibilstatus("Approved");
			enq.setCibilscore(cibilScore);

		    Enquiry enquiry = enquiryservice.checkCibilScore(enq);

		   
			return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
		}
		else
		{
			enq.setCibilstatus("Rejected");
			enq.setCibilscore(cibilScore);
			
			Enquiry enqc = enquiryservice.checkCibilScore(enq);
			
		}
		return  new ResponseEntity<Enquiry>(enq,HttpStatus.OK);
	}
	
	@GetMapping("/getCibil/{cibilstatus}")
	public ResponseEntity<Enquiry> getCibilScore(@PathVariable("cibilstatus")String cibilstatus)
	{
		Enquiry cibil =enquiryservice.getCibilScoreStatus(cibilstatus);
		
		return new ResponseEntity<>(cibil,HttpStatus.OK);
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
	
	
	@GetMapping("/forwarded/{cid}")
	public ResponseEntity<Enquiry> forwardStatus(@PathVariable("cid") Integer cid)
	{
		Enquiry enq=enquiryservice.getSingleEnquiry(cid);
		enq.setForwardStatus("Forwarded");
		 Enquiry enquiry = enquiryservice.checkCibilScore(enq);
		return new ResponseEntity<>(enquiry,HttpStatus.OK);
	}
	
	@GetMapping("/getForwardForm/{forwardStatus}")
	public ResponseEntity<List<Enquiry>> getForwardedForm(@PathVariable("forwardStatus")String forwardStatus)
	{
		List<Enquiry> forwardform=enquiryservice.getForwardedForm(forwardStatus);
		return new ResponseEntity<>(forwardform,HttpStatus.OK);
	}
	
	

}
