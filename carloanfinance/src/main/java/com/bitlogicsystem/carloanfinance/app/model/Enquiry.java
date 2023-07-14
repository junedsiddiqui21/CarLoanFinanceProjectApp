package com.bitlogicsystem.carloanfinance.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String firstName;
	private String lastName;
	private Long mobileNo;
	private String dateofBirth;
	private String gender;
	private int age;
	private String panCard;
	private String address;
	private String cibilstatus;
	private int cibilscore;

}
