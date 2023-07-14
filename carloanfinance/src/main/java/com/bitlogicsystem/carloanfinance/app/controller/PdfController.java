package com.bitlogicsystem.carloanfinance.app.controller;


import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.service.PdfService;

@RestController
public class PdfController {
	@Autowired
	private PdfService service;

	@GetMapping("/getPdf")
	public ResponseEntity<InputStreamResource> getPdfDocument(){
		ByteArrayInputStream pdfArray=service.sanctionPdf();  
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "inline;filename=mypdf.pdf");
		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdfArray));
		

}
}
