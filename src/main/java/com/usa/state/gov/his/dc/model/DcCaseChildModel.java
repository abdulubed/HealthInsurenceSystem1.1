package com.usa.state.gov.his.dc.model;


import lombok.Data;

@Data
public class DcCaseChildModel{
	
	private Long childId;

	private Long caseId;
	
	private String indivName;
	
	private String childName;

	private String childGender;
	
	private String childDob;
	
	private Long ssnNumber;

}