package com.usa.state.gov.his.dc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_CASE_PLAN_MASTER")
public class DcCasePlanMasterEntity implements Serializable {
	
	
	@Id
	@Column(name = "CASE_ID")
	private Long caseId;
	
	@Column(name="PLAN_ID")
	private Long planId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_DESCRIPTION")
	private String planDescription;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name="END_DATE")
	private String endDate;
	
}
