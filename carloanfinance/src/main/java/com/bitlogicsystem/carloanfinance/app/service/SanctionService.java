package com.bitlogicsystem.carloanfinance.app.service;

import java.io.ByteArrayInputStream;   
import java.util.List;
import java.util.Optional;

import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;

public interface SanctionService {
	public ByteArrayInputStream createSanctionpdf(int sanctionid);

	public void sendSanctionMail(int sanctionid);

	public LoanApplication saveSanctionLetter(LoanApplication sc);

	public void updateLoanStatus(SanctionLetter sanletter);

	public SanctionLetter getsacLetter(int sanctionId);

}
