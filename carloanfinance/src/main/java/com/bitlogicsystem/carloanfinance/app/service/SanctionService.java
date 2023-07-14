package com.bitlogicsystem.carloanfinance.app.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;

public interface SanctionService {
	SanctionLetter saveSanctionLetter(SanctionLetter scl);

	ByteArrayInputStream createSanctionpdf(int sanctionid);

      void sendSanctionMail(int sanctionid);

	List<SanctionLetter> getallSanctiondetails(int sanctionid);

}
