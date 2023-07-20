package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import javax.sql.DataSource;

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
	public LoanApplication saveSanctionLetter(LoanApplication scl) {

		LoanApplication ap = loanAppRepo.save(scl);

		return ap;
	}

	@Override
	public ByteArrayInputStream createSanctionpdf(int customerId) {

		Optional<LoanApplication> sacLetter = loanAppRepo.findById(customerId);
		List<SanctionLetter> stus = sr.getSanctionLetterData(sacLetter.get().getSanctionLetter().getSanctionId());

		LoanApplication aapForm = sacLetter.get();

		SanctionLetter sancLatter = new SanctionLetter();

		String title = "Welcome to CarLoanFinance";

		String content = "\n\n\n" + "To, \n" + "Mr/Mrs. " + aapForm.getCustomerFirstName() + " "
				+ aapForm.getCustomerLastName() + "\n" + "Contact Number : " + aapForm.getCustomerMobileNumber() + "\n"
				+ "Email ID : " + aapForm.getCustomerEmail() + "\n\n" + "Dear Mr/Ms. " + sancLatter.getApplicantName()
				+ " " + sancLatter.getContactDetails() + ", \n \n" + "Subject: Sanction of Car Loan of Rs. "
				+ sancLatter.getLoanAmmountSanctioned() + "\n" + "With reference to your Car loan application dated "
				+ sancLatter.getSanctionDate() + " we are pleased to inform you that an Car loan of Rs."
				+ sancLatter.getLoanAmmountSanctioned()
			+ " has been sanctioned for purchasing your dream car on the following terms and conditions: \n\n"
				+ "1. Name of Applicant           :   " + sancLatter.getApplicantName() + " "
				+ sancLatter.getContactDetails() + "\n" + "2. Nature of Loan                :    CarLoan \n"
			+ "3. Amount Sanctioned         :   " + sancLatter.getLoanAmmountSanctioned() + "\n"
			+ "4. Rate of Interest               :   " + sancLatter.getRateOfInterest() + "% per annum \n"
				+ "5. Repayment Period          :   Loan is repayable in " + sancLatter.getLoanTenure()
				+ " equated monthly \n" + "6. Installment                      :   Rs. "
			+ sancLatter.getMonthlyEmiAmmount() + "\n" + "7. Amount With Intrest        :   Rs. "
				+  "\n"
				+ "9. Disbursement                 :   Loan will be disbursed on getting Online Banking. All terms and Conditions of loan are met. \n\n\n"
				+ "Thanking you. \n\n" + "Yours truly, \n" + "CarLoanFinance Pvt Ltd..";

		GenerateSanctionPDF generatePdf = new GenerateSanctionPDF();
		ByteArrayOutputStream out = generatePdf.generatePdf(title, content, customerId, stus);

		byte[] pdf = out.toByteArray();
		sancLatter.setSanctionPdf(pdf);
		SanctionLetter sac = aapForm.getSanctionLetter();
		sac.setSanctionPdf(pdf);
		aapForm.setSanctionLetter(sac);
//		sr.save(sancLatter);
		loanAppRepo.save(aapForm);

		return new ByteArrayInputStream(out.toByteArray());
	}

	@Override
	public void sendSanctionMail(int sanctionId) {

		Optional<SanctionLetter> sancLatter = sr.findById(sanctionId);
		SanctionLetter sc = sancLatter.get();
                   
                
		Optional<LoanApplication> loanApp =loanAppRepo.findBySanctionId(sanctionId);
		
		byte[] pdfData = sc.getSanctionPdf();

                      

	ByteArrayDataSource sd = new ByteArrayDataSource(pdfData, "application/octet-stream");

		try {
			MimeMessage mm = sender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mm, true);
			mimeMessageHelper.setFrom(fromEmailId);
			mimeMessageHelper.setTo(loanApp.get().getCustomerEmail());
			mimeMessageHelper.setSubject("Your Loan Is Sanctioned");
			mimeMessageHelper.setText("Dear Mr/Mrs. " + loanApp.get().getCustomerFirstName() + " "
					+ loanApp.get().getCustomerLastName() + "\n" + "   "
					+ " We are pleased to inform you that based on your online loan application to our Buldana Urban co.op.credyt society PVT. LTD. "
					+ "\n" + "   " + " Bearing Application Number : " + loanApp.get().getCustomerId()
					+ " we are offering you an in-princile e-Sanction based on the information provided by you, under the "
					+ " program. \n" + "         "
					+ " This in principle e-Sanction for your loan is subject to the following terms and conditions. \n"
					+ "\n" + "Loan Amount     : " + loanApp.get().getLoandetails().getCustemorLoanAmmount() + "\n"
					+ "Car LoanFinance Pvt Ltd.");
			mimeMessageHelper.addAttachment("sd.pdf", sd);

			sender.send(mm);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void updateLoanStatus(SanctionLetter sanletter) {
		
		sr.save(sanletter);
		
	}

	@Override
	public SanctionLetter getsacLetter(int sanctionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

//	@Override
//	public List<LoanApplication> getallSanctiondetails(int custId) {
//
//		return sr.getAllDataId(custId);
//		
//	}
}

