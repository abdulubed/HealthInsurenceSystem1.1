package com.usa.state.gov.his.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Data;

@Entity
@Data
@Table(name = "AR_MASTER")
public class ARMasterEntity {
	
	@Id
	@SequenceGenerator(sequenceName = "ar_seq", name = "ar_seq", initialValue = 15000, allocationSize = 1)
	@GeneratedValue(generator = "ar_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "APPLICATION_NUMBER")
	private Long applicationNumber;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "EMAIL")
	private String email;


	@Column(name = "DATE_OF_BIRTH")
	//@Type(type = "date")
	//@Temporal(TemporalType.DATE)
	private String dateOfBirth;
	
	@Column(name = "SSN_NUMBER")
	@NumberFormat(style = Style.NUMBER)
	private Long ssnNumber;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;


}
