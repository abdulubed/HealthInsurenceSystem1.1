package com.usa.state.gov.his.dc.model;

import lombok.Data;

@Data
public class DcCaseEducationDetailsModel {
	
	private Long caseId;
	
	private String indivName;

	private String highestQlfy;

	private Integer completedYear;

	private String grade;
}
