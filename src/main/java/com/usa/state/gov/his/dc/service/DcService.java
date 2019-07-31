package com.usa.state.gov.his.dc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usa.state.gov.his.admin.model.PlanModel;
import com.usa.state.gov.his.ar.model.ARModel;
import com.usa.state.gov.his.dc.model.DcCaseChildModel;
import com.usa.state.gov.his.dc.model.DcCasePlanModel;
import com.usa.state.gov.his.dc.model.DcModel;

@Service
public interface DcService {

	public  List<PlanModel> getPlanNames();
	
	public ARModel getCitizen(Long applicationNumber);
	
	/**
	 * this method is used for storing the citizen data along with case id 
	 * 
	 * @param dcModel
	 * @return
	 */
	public DcModel caseGenerate(DcModel dcModel);	
	
	public void childPlanRegistration(DcCaseChildModel childModel); 
	
	public PlanModel getPlanIds(String planName);

	public DcCasePlanModel casePlan(DcCasePlanModel dcCasePlanModel);
	
}
