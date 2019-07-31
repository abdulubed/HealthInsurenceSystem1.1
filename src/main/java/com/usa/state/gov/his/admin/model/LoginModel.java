package com.usa.state.gov.his.admin.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginModel {
	
	@NotEmpty(message = "Please enter UserName")
	private String userName;
	
	@NotEmpty(message = "Please enter Password")
	private String password;

}
