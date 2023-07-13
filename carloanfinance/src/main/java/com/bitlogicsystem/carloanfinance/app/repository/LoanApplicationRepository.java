package com.bitlogicsystem.carloanfinance.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Integer> 
{

	List<LoanApplication> findByCustomerId(int cid);

}
