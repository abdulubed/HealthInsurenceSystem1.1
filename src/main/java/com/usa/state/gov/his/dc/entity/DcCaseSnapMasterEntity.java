package com.usa.state.gov.his.dc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_CASE_INCOME_DETAILS_MASTER")
public class DcCaseSnapMasterEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CASE_ID")
	private Long caseId;
	
	@Column(name="INDIV_NAME")
	private String indivName;
	
	@Column(name="IS_EMPLOYEE")
	private String isEmployee;
	
	@Column(name="WEEKLY_INCOME")
	private Float weeklyIncome;
	
	@Column(name="OTHER_INCOME")
	private Float otherIncome;
}
