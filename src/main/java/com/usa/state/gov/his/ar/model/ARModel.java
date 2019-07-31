package com.usa.state.gov.his.ar.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ARModel {
	
	private Long applicationNumber;
	

	@Size(min = 2, max = 20, message = "minimum 2 maximum 20 characters are allowed")
	@NotEmpty(message = "please enter first name")
	private String firstName;

	@Size(min = 2, max = 20, message = "minimum 2 maximum 20 characters are allowed")
	@NotEmpty(message = "please enter first name")
	private String lastName;

	@NotEmpty(message = "please choose gender")
	private String gender;

	@NotEmpty(message = "please enter email")
	private String email;

	@NotNull(message = "please enter Date of birth")
	private String dateOfBirth;

	@Min(value = 9, message = "ssn number should be 9Numbers")
	@NotNull(message = "please enter ssn number")
	private Long ssnNumber;
 
	@Min(value = 10, message = "phno should be 10 Numbers")
	@NotNull(message = "please enter phno")
	private String phoneNumber;


}
