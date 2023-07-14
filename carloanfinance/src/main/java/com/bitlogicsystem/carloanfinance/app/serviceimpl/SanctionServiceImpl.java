package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.GenerateSanctionPDF;
import com.bitlogicsystem.carloanfinance.app.model.LoanApplication;
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
	public ByteArrayInputStream createSanctionpdf(int sanctionId) {

		Optional<SanctionLetter> sacLetter = sr.findById(sanctionId);
		List<SanctionLetter> stus= sr.getAllDataId(sanctionId);

		SanctionLetter aapForm = sacLetter.get();

		

		String title = "Welcome to CarLoanFinance";
		
	
		String content = "\n\n\n" + "To, \n" 
		        + "Mr/Mrs. " 
		        +"ApplicantName:"+ aapForm.getApplicantName() + "ContactDetails: "
				+ aapForm.getContactDetails()  + "\n"
				+ "LoanAmountSanctiond : " + aapForm.getLoanAmmountSanctioned() + "\n" + "InteresrType : "
				+ aapForm.getInterestType() + "\n" + "RateOfInterest : " + aapForm.getRateOfInterest()+  "\n" + "LoanTenure : " + aapForm.getLoanTenure()+ "\n" + "MonthalyEmiAmount : " + aapForm.getMonthlyEmiAmmount()+ "\n" + "ModeOfPayment : " + aapForm.getModeOfPayment()+ "\n" + "Remark : " + aapForm.getRemarks()+ "\n" + "TermAndCondition : " + aapForm.getTermCondition()+ "\n" + "Status : " + aapForm.getStatus();

		GenerateSanctionPDF generatePdf = new GenerateSanctionPDF();
		ByteArrayOutputStream out = generatePdf.generatePdf(title, content,sanctionId,stus);

		byte[] pdf = out.toByteArray();
		aapForm.setSanctionPdf(pdf);

		sr.save(aapForm);

		return new ByteArrayInputStream(out.toByteArray());
	}

	@Override
	public void sendSanctionMail(int sanctionId) {

		Optional<SanctionLetter> sacLetter = sr.findById(sanctionId);
//		SanctionDetails sc = sacLetter.get();

		Optional<LoanApplication> loanApp = loanAppRepo.findBySanctionId(sanctionId);

		byte[] pdfData = sacLetter.get().getSanctionPdf();

		ByteArrayDataSource sd = new ByteArrayDataSource(pdfData, "application/octet-stream");

		try {

			MimeMessage mm = sender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mm, true);

			// SimpleMailMessage mailMessage=new SimpleMailMessage();
			mimeMessageHelper.setFrom(fromEmailId);
			mimeMessageHelper.setTo(loanApp.get().getCustomerEmail());
//			mimeMessageHelper.setText("Dear Mr/Mrs. " + sacLetter.get().get + " "
//					+ sacLetter.get().getTenureyearsanctioned() + "\n" + "   "
//					+ " We are pleased to inform you that based on your online loan application to our Buldana Urban co.op.credyt society PVT. LTD. "
//					+ "\n" + "   " + " Bearing Application Number : " + sacLetter.get().getMonthalyEmisanctioned()
//					+ " we are offering you an in-princile e-Sanction based on the information provided by you, under the "
//					+ " program. \n" + "         "
//					+ " This in principle e-Sanction for your loan is subject to the following terms and conditions. \n"
//					+ "\n" + "Loan Amount     : " + sacLetter.get().getLoanamountSanction() + "\n"
//					+ "Buldana urban Pvt Ltd.");

			mimeMessageHelper.setSubject("Your Loan Is Sanctioned");

			mimeMessageHelper.addAttachment("sd.pdf", sd);

			sender.send(mm);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

	@Override
	public List<SanctionLetter> getallSanctiondetails(int sanctionId) {

		return sr.getAllDataId(sanctionId);
		
	}

}
