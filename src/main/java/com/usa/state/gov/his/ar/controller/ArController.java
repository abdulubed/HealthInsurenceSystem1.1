package com.usa.state.gov.his.ar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.state.gov.his.ar.model.ARModel;
import com.usa.state.gov.his.ar.service.ArService;
import com.usa.state.gov.his.util.AppProperties;

@Controller
public class ArController {

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private ArService arService;


	/**
	 * This method is used for display Application Registration Form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/displayARForm", method = RequestMethod.GET)
	public String displayARForm(Model model) {
		model.addAttribute("arModel", new ARModel());
		initializerValues(model);
		return appProperties.getArRegistration();
	}

	/**
	 * This method is used for Load genders
	 * 
	 * @param model
	 * @return
	 */
	public String initializerValues(Model model) {
		List<String> gendersList = new ArrayList<String>();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("gendersList", gendersList);
		return appProperties.getArRegistration();
	}

	/**
	 * This method is used for citizen registration
	 * 
	 * @param model
	 * @param redirectAttributes
	 * @param arModel
	 * @param result
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(method = RequestMethod.POST, value = "/insertARData")
	public String applicationRegistration(Model model, RedirectAttributes redirectAttributes,
			@ModelAttribute("arModel") @Valid ARModel arModel, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			initializerValues(model);
			return appProperties.getArRegistration();
		}
		initializerValues(model);
		Long ssnNumber = arModel.getSsnNumber();

		String stateName = restClientForStateValidation.getStateName(ssnNumber);
		String givenStateName = "washington";
		if (stateName.equals(givenStateName)) {
			Long applicationNumber = arService.insertArData(arModel);
			redirectAttributes.addFlashAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
			redirectAttributes.addFlashAttribute("applicationNumber" , applicationNumber);
			return "caseCreation";
		} else {
			redirectAttributes.addFlashAttribute("stateNameMessage", "Citizen not from washington");
			return "redirect:/displayARForm";
		}

	}*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/insertARData")
	public String applicationRegistration(Model model, RedirectAttributes redirectAttributes,
			@ModelAttribute("arModel") @Valid ARModel arModel, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			initializerValues(model);
			return appProperties.getArRegistration();
		}
		initializerValues(model);
		Long ssnNumber = arModel.getSsnNumber();
		
		Long applicationNumber = arService.appRegistration(arModel, ssnNumber);
		if(applicationNumber == 0) {
			redirectAttributes.addFlashAttribute("stateNameMessage", "Citizen Already Registred");
			return "redirect:/displayARForm";
		}else if(applicationNumber == 1){
			redirectAttributes.addFlashAttribute("stateNameMessage", "Citizen not from washington");
			return "redirect:/displayARForm";
		}else {
			//redirectAttributes.addFlashAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
			//redirectAttributes.addFlashAttribute("applicationNumber" , applicationNumber);
			//return "redirect:/caseCreationDisplay";
			model.addAttribute("applicationNumber" , applicationNumber);
			return "caseCreation";
		}
		
	}


	/**
	 * This method is used for Unique Email Ajax validation
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/arEmail")
	public @ResponseBody String arEmailValidation(HttpServletRequest req) throws Exception {
		String email = null;
		String msg = null;
		email = req.getParameter("email");
		msg = arService.arEmailValidation(email);
		return msg;
	}

	/**
	 * This method is used for show all citizens data
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/getCitizensAccounts")
	public String showAllAccounts(Model model) {
		List<ARModel> accountRecords = arService.getCitizensAccounts();
		model.addAttribute("accountRecords", accountRecords);
		return "getCitizensAccounts";
	}

		
	

}
