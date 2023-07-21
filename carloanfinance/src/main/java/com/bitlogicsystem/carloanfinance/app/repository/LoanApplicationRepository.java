package com.bitlogicsystem.carloanfinance.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Integer> 
{
	@Query (value ="SELECT * FROM carloanproject.loan_application Where sanction_id = ?1",nativeQuery = true )
	Optional<LoanApplication> findBySanctionId(int sanctionid);

	List<LoanApplication> findByCustomerId(int cid);
	
	    
}
