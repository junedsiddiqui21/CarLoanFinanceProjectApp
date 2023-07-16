package com.bitlogicsystem.carloanfinance.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlogicsystem.carloanfinance.app.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry,Integer> {

	Enquiry findByCibilstatus(String cibilstatus);

	List<Enquiry> findByForwardStatus(String forwardStatus);

}
