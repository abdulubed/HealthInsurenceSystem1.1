package com.usa.state.gov.his.util;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "his")
@Data
public class AppProperties {
	
	private String enrollSuccess;
	private String enrollFailure;
	private String message;
	private String userRegistration;
	private String updateSuccess;
	private String editForm;
	private String loginForm;
	private String loginMessage;
	private String loginSuccess;
	private String invalidMessage;
	private String invalidCredentials;
	private String userInactive;
	private String caseWorkerDashboard;
	private String adminDashboard;
	private String arRegistration;

}
