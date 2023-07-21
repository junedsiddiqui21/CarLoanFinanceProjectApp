package com.bitlogicsystem.carloanfinance.app.service;

import com.bitlogicsystem.carloanfinance.app.model.BankTransaction;
import com.bitlogicsystem.carloanfinance.app.model.BaseResponse;
import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;

public interface TransactionService 
{
	BaseResponse saveTransaction(int cid, BankTransaction bt);

	LoanApplication getTransaction(int cid);
}
     