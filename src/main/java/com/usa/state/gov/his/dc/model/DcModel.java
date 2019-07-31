package com.usa.state.gov.his.dc.model;

import com.usa.state.gov.his.admin.model.PlanModel;

import lombok.Data;

@Data
public class DcModel {
	
	private Long applicationNumber;
	
	private Long caseId;
	
	private PlanModel planId;
	
	private String firstName;

	private String lastName;

	private String gender;

	private String email;

	private String dateOfBirth;

	private Long ssnNumber;
 
	private String phoneNumber;


}
