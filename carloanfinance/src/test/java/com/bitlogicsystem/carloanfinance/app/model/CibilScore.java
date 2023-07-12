package com.bitlogicsystem.carloanfinance.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CibilScore 
{
	@Id
	private int cibilid;
	private long cibilscore;
	@CreationTimestamp
	private Date cibilScoreDateTime;
	private String status;
	private String remark;
}
