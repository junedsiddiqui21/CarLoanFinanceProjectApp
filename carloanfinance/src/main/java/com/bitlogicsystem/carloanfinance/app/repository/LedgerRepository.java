package com.bitlogicsystem.carloanfinance.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlogicsystem.carloanfinance.app.model.Ledger;
@Repository
public interface LedgerRepository extends JpaRepository<Ledger,Integer> {

}
