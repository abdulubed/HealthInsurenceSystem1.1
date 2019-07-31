package com.usa.state.gov.his.dc.model;

import lombok.Data;

@Data
public class DcCaseSnapModel {

	private Long caseId;
	
	private String indivName;
	
	private String isEmployee;
	
	private Float weeklyIncome;
	
	private Float otherIncome;
}
