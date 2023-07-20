package com.bitlogicsystem.carloanfinance.app.service;

import java.util.List;

import com.bitlogicsystem.carloanfinance.app.model.Ledger;

public interface LedgerService {

	Ledger saveLedger(Ledger ledger);

	List<Ledger> getLedger();

	Ledger singleLedger(int ledgerId);

}
