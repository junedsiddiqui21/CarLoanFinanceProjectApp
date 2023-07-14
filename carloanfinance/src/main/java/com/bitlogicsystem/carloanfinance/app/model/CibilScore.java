package com.bitlogicsystem.carloanfinance.app.model;

import java.util.Date;

import javax.annotation.Generated;
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
public class CibilScore 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cibilid;
	private long cibilscore;
	@CreationTimestamp
	private Date cibilScoreDateTime;
	private String status;
	private String remark;
}
