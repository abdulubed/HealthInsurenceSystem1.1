package com.usa.state.gov.his.dc.model;

import lombok.Data;

@Data
public class DcCaseMedicaidModel {

	private Long caseId;
	private String indivName;
	private String employmentIncome;
	private Float propertiesCost;
	private Float otherIncome;

}
