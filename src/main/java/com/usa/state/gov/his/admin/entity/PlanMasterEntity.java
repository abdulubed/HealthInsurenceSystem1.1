package com.usa.state.gov.his.admin.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class PlanMasterEntity {
	
	
	@Id
	@SequenceGenerator(sequenceName = "adminPlan_seq", name = "adminPlan_seq", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "adminPlan_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="PLAN_ID")
	private Long planId;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_DESCRIPTION")
	private String planDescription;
	
	@Column(name = "START_DATE")
	private String startDate;
	
	@Column(name = "END_DATE")
	private String endDate;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@UpdateTimestamp
	private Timestamp updateDate;
	

}
