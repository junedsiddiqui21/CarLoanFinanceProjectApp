package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Documents 
{
	@Id
	private int documentId;
	private byte[] addressproof;
	private byte[] pancard;
	private byte[] incometax;
	private byte[] addharcard;
	private byte[] photo;
	private byte[] signature;
	private byte[] bankCheque;
	private byte[] salaryslip;
	private byte[] carquotation;
}
