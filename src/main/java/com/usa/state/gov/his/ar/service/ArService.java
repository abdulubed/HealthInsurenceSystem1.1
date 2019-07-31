package com.usa.state.gov.his.ar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usa.state.gov.his.admin.entity.PlanMasterEntity;
import com.usa.state.gov.his.admin.model.PlanModel;
import com.usa.state.gov.his.ar.model.ARModel;
import com.usa.state.gov.his.dc.model.DcModel;

@Service
public interface ArService {

//	public Long insertArData(ARModel arModel );
	
	public Long appRegistration(ARModel arModel , Long ssnNumber);
	
	
	public String arEmailValidation(String email);
	
	public List<ARModel> getCitizensAccounts();
	
	
	
	
	
	

}
