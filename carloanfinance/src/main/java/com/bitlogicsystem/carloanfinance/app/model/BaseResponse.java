package com.bitlogicsystem.carloanfinance.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse 
{    
	private int responseStatus;
	private String responsemassage;
	
	
}
