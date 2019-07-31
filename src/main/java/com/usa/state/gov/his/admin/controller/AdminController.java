package com.usa.state.gov.his.admin.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.state.gov.his.admin.model.AdminModel;
import com.usa.state.gov.his.admin.model.LoginModel;
import com.usa.state.gov.his.admin.model.PlanModel;
import com.usa.state.gov.his.admin.service.AdminService;
import com.usa.state.gov.his.util.AppProperties;

/**
 * This class is used to Handle Admin module related functionalities
 * 
 * @author shaik
 *
 */
@Controller
public class AdminController {

	@Autowired
	private AdminService hisService;

	@Autowired
	private AppProperties appProperties;

	/**
	 * This method is used for display User Registration page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/displayForm", method = RequestMethod.GET)
	public String accountRegistrationForm(Model model) {
		model.addAttribute("adminModel", new AdminModel());
		initializerValues(model);
		return appProperties.getUserRegistration();
	}

	/**
	 * This method is used for Register user account
	 * 
	 * @param model
	 * @param redirectAttributes
	 * @param adminModel
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/insertUserData")
	public String accountRegistartion(Model model, RedirectAttributes redirectAttributes,
			@ModelAttribute("adminModel") @Valid AdminModel adminModel, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			initializerValues(model);
			return appProperties.getUserRegistration();
		}
		redirectAttributes.addFlashAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
		initializerValues(redirectAttributes);
		hisService.insertUserData(adminModel);
		return "redirect:/displayForm";
	}

	/**
	 * This method is used for load roles and genders
	 * 
	 * 
	 * @param model
	 * @return
	 */
	public String initializerValues(Model model) {

		List<?> list = hisService.getRolesList();
		model.addAttribute("rolesList", list);
		List<String> gendersList = new ArrayList<String>();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("gendersList", gendersList);
		return appProperties.getUserRegistration();

	}

	/**
	 * This method is used for view all acounts in table
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/getAllAccounts")
	public String viewAccounts(Model model) {
		List<AdminModel> accountRecords = hisService.getAllAccounts();
		model.addAttribute("accountRecords", accountRecords);
		return "getAllAccounts";

	}
	
	/**
	 * This method is used for DeActivating the account
	 * 
	 * @param serialNumber
	 * @return
	 */
	@RequestMapping(value = "/statusInActive/{serialNumber}", method = RequestMethod.GET)
	public String statusInActive(@PathVariable("serialNumber") Long serialNumber) {
		System.out.println("serial number is" + serialNumber);
		hisService.statusInActive(serialNumber);
		return "redirect:/getAllAccounts";
	}

	/**
	 * This method is used for Activating the account
	 * 
	 * @param serialNumber
	 * @return
	 */
	@RequestMapping(value = "/statusActive/{serialNumber}", method = RequestMethod.GET)
	public String statusActive(@PathVariable("serialNumber") Long serialNumber) {
		System.out.println("serial number is" + serialNumber);
		hisService.statusActive(serialNumber);
		return "redirect:/getAllAccounts";
	}

	
	/**
	 * This method is used for diplay updating account details
	 * 
	 * @param serialNumber
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit/{serialNumber}", method = RequestMethod.GET)
	public String editAccountForm(@PathVariable("serialNumber") Long serialNumber, Model model) throws Exception {
		System.out.println("serial number is" + serialNumber);
		AdminModel adminModel = hisService.editAccountDetails(serialNumber);
		initializerValues(model);
		model.addAttribute("adminModel", adminModel);
		System.out.println(adminModel);
		return appProperties.getEditForm();
	}

	/**
	 * This method is used for Account Updation
	 * 
	 * @param model
	 * @param redirectAttributes
	 * @param adminModel
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "editAccountDetails", method = RequestMethod.POST)
	public String editAccountDetails(Model model, RedirectAttributes redirectAttributes,
			@ModelAttribute("adminModel") @Valid AdminModel adminModel, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			initializerValues(model);
			return appProperties.getUserRegistration();
		}
		redirectAttributes.addFlashAttribute(appProperties.getMessage(), appProperties.getUpdateSuccess());
		initializerValues(redirectAttributes);
		System.out.println(adminModel);
		hisService.updateAccountDetails(adminModel);
		return "redirect:/displayForm";
	}


	/**
	 * This method is used for email validation using ajax
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/email")
	public @ResponseBody String emailValidation(HttpServletRequest req) throws Exception {
		String email = null;
		String msg = null;
		email = req.getParameter("email");
		msg = hisService.validateEmail(email);
		return msg;
	}

	/**
	 * This method is used for displaying Plan Registration form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/displayPlanForm")
	public String displayPlanRegistrationForm(Model model) {
		model.addAttribute("planModel", new PlanModel());
		return "planForm";
	}

	/**
	 * This method is used for Plan Registration
	 * 
	 * @param planModel
	 * @param redirectAttributes
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/insertPlanData")
	public String planCreation(@ModelAttribute("planModel") PlanModel planModel, RedirectAttributes redirectAttributes,
			Model model) {
		redirectAttributes.addFlashAttribute("plan", "Plan registered Successfull");
		hisService.insertPlanData(planModel);
		return "redirect:/displayPlanForm";
	}

	/**
	 * This method is used for displaying all Plans
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/getAllPlans")
	public String viewAllPlans(Model model) {
		List<PlanModel> planRecords = hisService.getAllPlans();
		model.addAttribute("planRecords", planRecords);
		return "getAllPlans";
	}
	
	/**
	 * This method is used for DeActivating the plan
	 * 
	 * @param serialNumber
	 * @return
	 */
	@RequestMapping(value = "/planStatusInActive/{planId}", method = RequestMethod.GET)
	public String planStatusInActive(@PathVariable("planId") Long planId) {
		System.out.println("planId number is" + planId);
		hisService.planStatusInActive(planId);
		return "redirect:/getAllPlans";
	}

	/**
	 * This method is used for Activating the plan
	 * 
	 * @param serialNumber
	 * @return
	 */
	@RequestMapping(value = "/planStatusActive/{planId}", method = RequestMethod.GET)
	public String planStatusActive(@PathVariable("planId") Long planId) {
		System.out.println("planId number is" + planId);
		hisService.planStatusActive(planId);
		return "redirect:/getAllPlans";
	}

	/**
	 * This method is used for diplay updating plan details
	 * 
	 * @param serialNumber
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editPlan/{planId}", method = RequestMethod.GET)
	public String editPlanForm(@PathVariable("planId") Long planId, Model model) throws Exception {
		System.out.println("planId number is" + planId);
		PlanModel planModel = hisService.editPlanDetails(planId);
		model.addAttribute("planModel", planModel);
		System.out.println(planModel);
		return "editPlanForm";
	}

	/**
	 * This method is used for Account Updation
	 * 
	 * @param model
	 * @param redirectAttributes
	 * @param adminModel
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editPlanDetails", method = RequestMethod.POST)
	public String editPlan(@ModelAttribute("planModel") PlanModel planModel , RedirectAttributes redirectAttributes) {
		hisService.updatePlanDetails(planModel);
		redirectAttributes.addFlashAttribute("message", "Plan Updated Successfull");
		return "redirect:/displayPlanForm";
	}


	/**
	 * This method is used for display Login Form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "loginDisplayForm", method = RequestMethod.GET)
	public String loginDisplayForm(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return appProperties.getLoginForm();
	}

	/**
	 * This method is uded for Login
	 * 
	 * @param redirectAttributes
	 * @param loginModel
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "validateLoginData", method = RequestMethod.POST)
	public String validateLoginData(RedirectAttributes redirectAttributes,
			@ModelAttribute("loginModel") @Valid LoginModel loginModel, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return appProperties.getLoginForm();
		}
		String message = hisService.findUserByEmail(loginModel.getUserName(), loginModel.getPassword());

		if (message.equals("adminDashboard")) {
			return "adminDashboard";
		} else if (message.equals("caseworkerDashboard")) {
			return "caseworkerDashboard";
		} else {
			redirectAttributes.addFlashAttribute(appProperties.getLoginMessage(), message);
			return "redirect:loginDisplayForm";
		}

	}

	/**
	 * This method is used for diplaying forget password form
	 * 
	 * @return
	 */
	@RequestMapping(name = "forgetPassword", method = RequestMethod.GET)
	public String forgetPasswordDisplay() {
		return "forgetPassword";
	}

	/**
	 * This method is used for perform forget password operation
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(name = "passwordSendToEmail", method = RequestMethod.POST)
	public String forgetPassword(@RequestParam("email") String email) throws Exception {
		System.out.println(email);
		hisService.forgetPassword(email);
		return "redirect:loginDisplayForm";
	}
}
