package com.bitlogicsystem.carloanfinance.app.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.service.DocumentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
public class DocumentController 
{
	@Autowired
	private DocumentService documentService;
	
	
	@PostMapping(value="/save_document",consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<LoanApplication> uploadfile(
							   @RequestParam(value="customeraddressproof")MultipartFile file,
							   @RequestParam(value="customerpancard")MultipartFile file1,
							   @RequestParam(value="customerincometax")MultipartFile file2,
							   @RequestParam(value="customeraddharcard")MultipartFile file3,
							   @RequestParam(value="customerphoto")MultipartFile file4,
							   @RequestParam(value="customersignature")MultipartFile file5,
							   @RequestParam(value="customerbankCheque")MultipartFile file6,
							   @RequestParam(value="customersalaryslip")MultipartFile file7,
							   @RequestParam(value="customercarquotation")MultipartFile file8,
							   @RequestParam(value ="professionsalaryslip")MultipartFile file9,
							   @RequestParam(value="data")String json)throws IOException
	{
		ObjectMapper om=new ObjectMapper();
		
		LoanApplication ldoc=om.readValue(json,LoanApplication.class);
		ldoc.getDocuments().setCustomeraddressproof(file.getBytes());
		ldoc.getDocuments().setCustomerpancard(file1.getBytes());
		ldoc.getDocuments().setCustomerincometax(file2.getBytes());
		ldoc.getDocuments().setCustomeraddharcard(file3.getBytes());
		ldoc.getDocuments().setCustomerphoto(file4.getBytes());
		ldoc.getDocuments().setCustomersignature(file5.getBytes());
		ldoc.getDocuments().setCustomerbankCheque(file6.getBytes());
		ldoc.getDocuments().setCustomersalaryslip(file7.getBytes());
		ldoc.getDocuments().setCustomercarquotation(file8.getBytes());
		ldoc.getProfession().setProfessionsalaryslip(file9.getBytes());
		
		documentService.saveDocument(ldoc);
		
		
		return  new ResponseEntity<LoanApplication>(ldoc,HttpStatus.CREATED);
	}	
}
