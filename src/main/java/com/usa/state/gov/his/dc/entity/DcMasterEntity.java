package com.usa.state.gov.his.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.usa.state.gov.his.admin.entity.PlanMasterEntity;

import lombok.Data;

@Entity
@Data
@Table(name = "Dc_MASTER")
public class DcMasterEntity {
	
		
		@Column(name = "APPLICATION_NUMBER")
		private Long applicationNumber;
		
		@Id
		@SequenceGenerator(sequenceName = "dc_seq", name = "dc_seq", initialValue = 20000, allocationSize = 1)
		@GeneratedValue(generator = "dc_seq", strategy = GenerationType.SEQUENCE)
		@Column(name = "CASE_ID")
		private Long caseId;
		
		@ManyToOne
		@JoinColumn(name = "planId")
		private PlanMasterEntity planId;
		
		
		@Column(name = "FIRST_NAME")
		private String firstName;

		@Column(name = "LAST_NAME")
		private String lastName;

		@Column(name = "GENDER")
		private String gender;

		@Column(name = "EMAIL")
		private String email;


		@Column(name = "DATE_OF_BIRTH")
		private String dateOfBirth;
		
		@Column(name = "SSN_NUMBER")
		@NumberFormat(style = Style.NUMBER)
		private Long ssnNumber;

		@Column(name = "PHONE_NUMBER")
		private String phoneNumber;


	}



