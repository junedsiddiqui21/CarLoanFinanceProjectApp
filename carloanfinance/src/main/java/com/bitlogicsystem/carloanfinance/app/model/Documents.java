package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Documents 
{
	@Id
	private int customerdocumentId;
	@Lob
	private byte[] customeraddressproof;
	@Lob
	private byte[] customerpancard;
	@Lob
	private byte[] customerincometax;
	@Lob
	private byte[] customeraddharcard;
	@Lob
	private byte[] customerphoto;
	@Lob
	private byte[] customersignature;
	@Lob
	private byte[] customerbankCheque;
	@Lob
	private byte[] customersalaryslip;
	@Lob
	private byte[] customercarquotation;
}
