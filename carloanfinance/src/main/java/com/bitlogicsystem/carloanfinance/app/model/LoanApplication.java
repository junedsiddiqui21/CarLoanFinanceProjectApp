package com.bitlogicsystem.carloanfinance.app.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoanApplication 
{	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerGender;
	private String customerDateOfBirth;
	private int customerAge;	
	private String customerEmail;
	private long customerMobileNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private EducationalInfo educationalInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private Profession profession;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails loandetails;
	@OneToOne(cascade = CascadeType.ALL)
	private Documents documents;
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionLetter;
	@OneToOne(cascade = CascadeType.ALL)
	private FamilyDependentInformation dependentInformation;
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanBank previousLoanBank;
	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<BankTransaction> bankTransaction;
}
