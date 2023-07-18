package com.bitlogicsystem.carloanfinance.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.model.LoanDetails;

@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanApplication,Integer> 
{

	

}
