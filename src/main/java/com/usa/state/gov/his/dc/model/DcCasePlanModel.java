package com.usa.state.gov.his.dc.model;

import lombok.Data;

@Data
public class DcCasePlanModel {

	private Long caseId;
	
	private Long planId;
	
	private String firstName;

	private String lastName;

	private String planName;
	
	private String planDescription;
	
	private String status;
	
	private String startDate;
	
	private String endDate;
	
}
