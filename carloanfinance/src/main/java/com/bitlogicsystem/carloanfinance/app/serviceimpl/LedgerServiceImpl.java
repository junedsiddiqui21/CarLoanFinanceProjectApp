package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.Ledger;
import com.bitlogicsystem.carloanfinance.app.repository.LedgerRepository;
import com.bitlogicsystem.carloanfinance.app.service.LedgerService;
@Service
public class LedgerServiceImpl implements LedgerService {
	@Autowired
    private LedgerRepository ledgerrepository;
	
	@Override
	public Ledger saveLedger(Ledger ledger) {
		
		return ledgerrepository.save(ledger);
	}

	@Override
	public List<Ledger> getLedger() {
		
		return ledgerrepository.findAll();
	}

	@Override
	public Ledger singleLedger(int ledgerId) {
	  Optional<Ledger> lt=ledgerrepository.findById(ledgerId);
	   if(lt.isPresent()) {
		   Ledger l=lt.get();
		   return l;
	   }
	  
		return null;    
	}
	

}
