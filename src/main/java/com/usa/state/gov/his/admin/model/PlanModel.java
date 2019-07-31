package com.usa.state.gov.his.admin.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PlanModel {
	
	
	private Long planId;
	private String planName;
	private String planDescription;
	private String startDate;
	private String endDate;
	private String status;
	private String createdBy;
	private String updatedBy;
	private Timestamp createDate;
	private Timestamp updateDate;

	

}
