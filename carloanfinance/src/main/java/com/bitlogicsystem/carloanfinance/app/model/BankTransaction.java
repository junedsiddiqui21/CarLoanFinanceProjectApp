package com.bitlogicsystem.carloanfinance.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankTransaction 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int transactionId;     
	@CreationTimestamp
	private Date transactionDate;
	private String transactionType;
	private double transactionAmmount;
	private double remainingAccountBalance;
}
