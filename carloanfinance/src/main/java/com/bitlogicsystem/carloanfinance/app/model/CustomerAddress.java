package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerAddressId;
	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress permanentAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private LocalAddress localAddress;
}
