package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;
import com.bitlogicsystem.carloanfinance.app.repository.LoanApplicationRepository;
import com.bitlogicsystem.carloanfinance.app.repository.SanctionLetterRepository;
import com.bitlogicsystem.carloanfinance.app.service.SanctionService;
@Service
public class SanctionServiceImpl implements SanctionService {

	@Autowired
	private SanctionLetterRepository sr;

	
	@Autowired
	JavaMailSender sender;

	@Autowired
	LoanApplicationRepository loanAppRepo;

	@Value("${spring.mail.username}")
	private String fromEmailId;
	@Override
	public SanctionLetter saveSanctionLetter(SanctionLetter scl) {
		
		SanctionLetter ap = sr.save(scl);

		return ap;
	}

	@Override
	public ByteArrayInputStream createSanctionpdf(int sanctionid) {

		Optional<SanctionLetter> sacLetter = sr.findById(sanctionid);
		List<SanctionLetter> stus= sr.getAllDataId(sanctionid);

		SanctionLetter aapForm = sacLetter.get();

		

		String title = "Welcome to CarLoanFinance";
		
	
		String content = "\n\n\n" + "To, \n" + "Mr/Mrs. " +"LoanType:"+ aapForm.getLoantype() + "Tenureyearsanctioned: "
				+ aapForm.getTenureyearsanctioned()  + "\n"
				+ "MonthalyEmisanctioned : " + aapForm.getMonthalyEmisanctioned() + "\n" + "LoanamountSanction : "
				+ aapForm.getLoanamountSanction() + "\n" + "Sanctionid : " + aapForm.getSanctionid();

		GenerateSanctionPDF generatePdf = new GenerateSanctionPDF();
		ByteArrayOutputStream out = generatePdf.generatePdf(title, content,sanctionid,stus);

		byte[] pdf = out.toByteArray();
		aapForm.setSanctionPdf(pdf);

		sr.save(aapForm);

		return new ByteArrayInputStream(out.toByteArray());
	}

	@Override
	public void sendSanctionMail(int sanctionid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SanctionLetter> getallSanctiondetails(int sanctionid) {
		// TODO Auto-generated method stub
		return null;
	}

}
