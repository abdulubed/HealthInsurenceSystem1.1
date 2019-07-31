package com.usa.state.gov.his.ar.controller;
/*package com.usa.state.gov.his.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.state.gov.his.model.LoginModel;
import com.usa.state.gov.his.service.HisServiceImpl;
import com.usa.state.gov.his.util.AppProperties;

@Controller
public class LoginController {
	
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private HisServiceImpl hisServiceImpl;
	
	@RequestMapping(value ="loginDisplayForm" , method = RequestMethod.GET)
	public String loginDisplayForm(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return appProperties.getLoginForm();
	}
	
	@RequestMapping(value = "validateLoginData" , method = RequestMethod.POST)
	public String validateLoginData(RedirectAttributes redirectAttributes , @ModelAttribute("loginModel") @Valid LoginModel loginModel , BindingResult result) {
		if(result.hasErrors()) {
			return appProperties.getLoginForm();
		}
		redirectAttributes.addFlashAttribute(appProperties.getLoginSuccess(),appProperties.getLoginMessage());
		hisServiceImpl.findUserByEmail(loginModel.getUserName());
		return "redirect:loginDisplayForm";
	}
	

}



*/







