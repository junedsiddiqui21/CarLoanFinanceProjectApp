package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.Enquiry;
import com.bitlogicsystem.carloanfinance.app.repository.EnquiryRepository;
import com.bitlogicsystem.carloanfinance.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl  implements EnquiryService{

	@Autowired
	private EnquiryRepository enquiryRepository;
	
	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {
		
		
		Enquiry id = enquiryRepository.save(enquiry);
		  
		  return  id;
	}

	@Override
	public List<Enquiry> getEnquiry() {
		
		return  enquiryRepository.findAll();
	}

	@Override
	public void deleteEnquiry(int cid) {
		
		 enquiryRepository.deleteById(cid);
	}

	@Override
	public Enquiry getSingleEnquiry(int cid) {
		
		Optional<Enquiry> optional = enquiryRepository.findById(cid);
		 Enquiry et=optional.get();
		return et;
	}

	@Override
	public Enquiry checkCibilScore(Enquiry enq) {
	return enquiryRepository.save(enq);
	}

}
