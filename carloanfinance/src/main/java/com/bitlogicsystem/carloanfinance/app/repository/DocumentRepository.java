package com.bitlogicsystem.carloanfinance.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlogicsystem.carloanfinance.app.model.Documents;

@Repository
public interface DocumentRepository extends JpaRepository<Documents,Integer>
{

}
