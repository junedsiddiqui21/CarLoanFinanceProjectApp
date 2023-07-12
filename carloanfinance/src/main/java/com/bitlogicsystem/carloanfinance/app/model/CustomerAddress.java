package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CustomerAddress 
{
	@Id
	private int customerAddressId;
	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress permanentAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private LocalAddress localAddress;
}
