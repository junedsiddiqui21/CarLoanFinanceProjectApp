package com.bitlogicsystem.carloanfinance.app.service;

import java.util.List;

import com.bitlogicsystem.carloanfinance.app.model.Enquiry;

public interface EnquiryService {

	Enquiry saveEnquiry(Enquiry enquiry);

	List<Enquiry> getEnquiry();

	void deleteEnquiry(int cid);

	Enquiry getSingleEnquiry(int cid);

	Enquiry checkCibilScore(Enquiry enq);

	Enquiry getCibilScoreStatus(String cibilstatus);

	List<Enquiry> getForwardedForm(String forwardStatus);

}