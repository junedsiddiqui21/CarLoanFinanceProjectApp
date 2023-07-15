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
public class FamilyDependentInformation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dependentinfoId;
	private String fatherName;
	private String motherName;
	private String spouseName;
	private int noOffamilyMember;
	private int noOfChild;
	private String maritalStatus;
	private double familyincome;
}
