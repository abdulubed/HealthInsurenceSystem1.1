package com.usa.state.gov.his.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_CASE_MEDICAID_DETAILS_MASTER")
@Data
public class DcCaseMedicaidEntity {
	
	@Id
	@Column(name = "CASE_ID")
	private Long caseId;
	
	@Column(name = "INDIV_NAME")
	private String indivName;
	
	@Column(name = "EMPLOYMENT_INCOME")
	private String employmentIncome;
	
	@Column(name = "PROPERTIES_COST")
	private Float propertiesCost;
	
	@Column(name = "OTHER_INCOME")
	private Float otherIncome;
	

}
