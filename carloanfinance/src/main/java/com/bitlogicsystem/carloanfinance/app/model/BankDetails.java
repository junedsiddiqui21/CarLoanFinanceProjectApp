package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankDetails 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int bankDetailsId;
	private String bankHolderName;
	private String bankName;
	private long bankAccountNumber;
	private String bankIFSC_code;
	private double accountBalance;
}
