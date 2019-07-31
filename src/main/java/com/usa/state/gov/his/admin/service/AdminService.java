package com.usa.state.gov.his.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usa.state.gov.his.admin.entity.AdminMasterEntity;
import com.usa.state.gov.his.admin.model.AdminModel;
import com.usa.state.gov.his.admin.model.LoginModel;
import com.usa.state.gov.his.admin.model.PlanModel;
import com.usa.state.gov.his.admin.model.RoleModel;

@Service
public interface AdminService {
	
	public void insertUserData(AdminModel model) throws Exception;
	
	public List<RoleModel> getRolesList();
	
	public List<AdminModel> getAllAccounts();
	
	public String validateEmail(String email);
	
	public void insertPlanData(PlanModel model);
	
	public  List<PlanModel> getAllPlans();
	
	public void statusInActive(Long serialNumber);
	
	public void statusActive(Long serialNumber);
	
	public void planStatusInActive(Long planId);
	
	public void planStatusActive(Long planId);
	
   public PlanModel editPlanDetails(Long planId);
	
	public void updatePlanDetails(PlanModel model);

	
	public AdminModel editAccountDetails(Long serialNumber) throws Exception;
	
	public void updateAccountDetails(AdminModel model) throws Exception;
	
	public String findUserByEmail(String email, String password) throws Exception;
	
	public void forgetPassword(String email) throws Exception;
	
	
	//public byte[] getImageById(Long ssnNumber);
		

}
