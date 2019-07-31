package com.usa.state.gov.his.dc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.state.gov.his.admin.model.PlanModel;
import com.usa.state.gov.his.ar.model.ARModel;
import com.usa.state.gov.his.dc.model.DcCaseChildModel;
import com.usa.state.gov.his.dc.model.DcCaseMedicaidModel;
import com.usa.state.gov.his.dc.model.DcCaseSnapModel;
import com.usa.state.gov.his.dc.model.DcCasePlanModel;
import com.usa.state.gov.his.dc.model.DcModel;
import com.usa.state.gov.his.dc.service.DcService;

@Controller
public class DcController {
	
	@Autowired
	private DcService dcService;
	
	@RequestMapping("/caseCreationDisplay")
	public String createCaseForm(Model model) {
		model.addAttribute("arModel" , new ARModel());
		return "caseCreation";
	}
	/*
	@RequestMapping("/citizenSerarch")
	public String createCase(@ModelAttribute("arModel") ARModel arModel1 , Model model) {
		//Long applicationNumber = arModel.getApplicationNumber();
		ARModel arModel = dcService.getCitizen(arModel1.getApplicationNumber());
		if(arModel != null) {
			model.addAttribute("arModel" , arModel);
			return "caseCreation";			
		}else {
			model.addAttribute("errMessage","Citizen Not Found");
			return "caseCreation";
		}
		
	}*/
	
	@RequestMapping("/citizenSerarch")
	public String createCase(HttpServletRequest req,Model model) {
		//Long applicationNumber = arModel.getApplicationNumber();
		//System.out.println(applicationNumber);
		String apNumber= req.getParameter("applicationNumber");
		if(apNumber != null) {		
		System.out.println(apNumber);
		Long convertedNumber =Long.parseLong(apNumber);
		System.out.println(convertedNumber);
		
		model.addAttribute("arModel", new ARModel());
		ARModel citizenDetails = dcService.getCitizen(convertedNumber);
		if(citizenDetails != null) {
			model.addAttribute("citizenDetails" , citizenDetails);
			return "caseCreation";			
		}else {
			model.addAttribute("errMessage","Citizen Not Found");
			System.out.println("error comming");
			return "caseCreation";
		}
	}else {
		return "caseCreation";
	}
	}
	/*
	 * @RequestMapping("/getPlansDetailsDisplay") public String
	 * getAllPlansForm(Model model) { model.addAttribute("arModel", new ARModel());
	 * return "planSelection"; }
	 */

	@RequestMapping("/getPlansDetails")
	public String getAllPlans(Model model, @ModelAttribute("dcModel") DcModel dcModel, HttpServletRequest req) {
		DcModel caseData = dcService.caseGenerate(dcModel);
		model.addAttribute("caseData", caseData);
		
		model.addAttribute("planRecords" , new DcCasePlanModel());
		List<PlanModel> planNames = dcService.getPlanNames();
		model.addAttribute("planNames", planNames);
		return "planSelection";
	}
	
	
	
	@RequestMapping("/planSelected")
	public String selectPlan(@ModelAttribute("planModel") DcCasePlanModel dcCasePlanModel, Model model) {
		PlanModel planDetails = dcService.getPlanIds(dcCasePlanModel.getPlanName());
		dcCasePlanModel.setPlanId(planDetails.getPlanId());
		dcCasePlanModel.setPlanDescription(planDetails.getPlanDescription());
		dcCasePlanModel.setStatus(planDetails.getStatus());
		DcCasePlanModel savedDcCasePlan = dcService.casePlan(dcCasePlanModel);
		String planName = savedDcCasePlan.getPlanName();
		
		if(planName.equalsIgnoreCase("ccap")) {
			System.out.println("ccapPlan");
			model.addAttribute("childModel" , new DcCaseChildModel());
			initializerValues(model);
			return "childPlan";
		}else if(planName.equalsIgnoreCase("snap")) {
			model.addAttribute("snapModel" , new DcCaseSnapModel());
			List<String> isEmployee = new ArrayList<String>();
			isEmployee.add("Yes");
			isEmployee.add("No");
			model.addAttribute("isEmployee", isEmployee);
			return "snapPlan";
		}else if(planName.equalsIgnoreCase("medicaid")) {
			model.addAttribute("medicaidModel" , new DcCaseMedicaidModel());
			return "medicaidPlan";
		}
		return null;
		
		
	}
	
	
	
	
	//@RequestMapping("/planSelected")
	private String childFormDisplay(Model model) {
		model.addAttribute("childModel" , new DcCaseChildModel());
		initializerValues(model);
		return "childPlan";
	}
	
	public String initializerValues(Model model) {
		List<String> gendersList = new ArrayList<String>();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("gendersList", gendersList);
		return "childPlan";
	}
	
	@RequestMapping("/childPlanRegister")
	private String childPlan(@ModelAttribute("dcChildCaseModel") DcCaseChildModel dcChildCaseModel,Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {
	
		String caseId = req.getParameter("caseId");
		Long convertedCaseNumber =Long.parseLong(caseId);
		System.out.println("come from child plan data"+caseId);
		System.out.println(dcChildCaseModel.getCaseId());
		dcChildCaseModel.setCaseId(convertedCaseNumber);
		dcService.childPlanRegistration(dcChildCaseModel);
		System.out.println("comming from child" +dcChildCaseModel);
		redirectAttributes.addAttribute("succMsg","child data added successfully");
		return "redirect:/childDisplayForm";
	}
	
	

}
