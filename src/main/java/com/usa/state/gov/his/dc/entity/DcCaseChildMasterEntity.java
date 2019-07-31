package com.usa.state.gov.his.dc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "child_master")
public class DcCaseChildMasterEntity {
	@Id
	@SequenceGenerator(sequenceName = "child_seq", name = "child_seq", initialValue = 25000, allocationSize = 1)
	@GeneratedValue(generator = "child_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="CHILD_ID")
	private Long childId;
	
	@Column(name="CASE_ID")
	private Long caseId;
	
	@Column(name="INDIV_NAME")
	private String indivName;
	
	@Column(name="CHILD_NAME")
	private String childName;

	@Column(name="CHILD_GENDER")
	private String childGender;
	
	@Column(name="CHILD_DOB")
	private Date childDob;
	
	@Column(name="CHILD_SSN")
	private Long ssnNumber;
}
