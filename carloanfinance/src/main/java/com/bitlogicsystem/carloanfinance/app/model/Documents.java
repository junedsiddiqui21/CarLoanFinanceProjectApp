package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
