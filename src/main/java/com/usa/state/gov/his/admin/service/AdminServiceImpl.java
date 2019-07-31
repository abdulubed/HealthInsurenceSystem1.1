package com.usa.state.gov.his.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.state.gov.his.admin.entity.AdminMasterEntity;
import com.usa.state.gov.his.admin.entity.PlanMasterEntity;
import com.usa.state.gov.his.admin.entity.RolesMasterEntity;
import com.usa.state.gov.his.admin.model.AdminModel;
import com.usa.state.gov.his.admin.model.LoginModel;
import com.usa.state.gov.his.admin.model.PlanModel;
import com.usa.state.gov.his.admin.model.RoleModel;
import com.usa.state.gov.his.admin.repository.AdminMasterRepository;
import com.usa.state.gov.his.admin.repository.PlanMasterRepository;
import com.usa.state.gov.his.admin.repository.RolesMasterRepository;
import com.usa.state.gov.his.util.AppProperties;
import com.usa.state.gov.his.util.EmailSending;
import com.usa.state.gov.his.util.PasswordEncrypt;

@Service
public class AdminServiceImpl extends Exception implements AdminService {

	@Autowired
	private AdminMasterRepository adminMasterRepository;

	@Autowired
	private RolesMasterRepository rolesMasterRepository;
	
	@Autowired
	private PlanMasterRepository planMasterRepository;
	
	@Autowired
	private PasswordEncrypt passwordEncrypt;
	
	@Autowired
	private EmailSending emailSending;
	
	@Autowired
	private AppProperties appProperties;
	
	@Override
	public void insertUserData(AdminModel model) throws Exception {
		String encryptedPassword = passwordEncrypt.doEncrypt(model.getPassword());
		model.setPassword(encryptedPassword);
		AdminMasterEntity entity = new AdminMasterEntity();
		BeanUtils.copyProperties(model, entity);
		entity.setStatus("active");
		AdminMasterEntity res = adminMasterRepository.save(entity);
		BeanUtils.copyProperties(res, model);
		Long serialNumber = model.getSerialNumber();
		if(serialNumber > 0) {
			String decryptPassword = passwordEncrypt.doDecrypt(model.getPassword());
			model.setPassword(decryptPassword);
			emailSending.emailSending(model,"Email/EmailMessage.txt");
		}
		
	}

	@Override
	public List getRolesList() {
		List<RolesMasterEntity> rolesMasterEntity = rolesMasterRepository.findAll();
		List roleModelList = new ArrayList();
		for (RolesMasterEntity entity : rolesMasterEntity) {
			RoleModel rolesModel = new RoleModel();
			BeanUtils.copyProperties(entity, rolesModel);
			roleModelList.add(rolesModel.getRoles());
		}
		return roleModelList;
	}

	@Override
	public List<AdminModel> getAllAccounts() {
		List<AdminModel> adminModelList = new ArrayList();
		List<AdminMasterEntity> adminMasterEntityList = adminMasterRepository.findAll();
		for (AdminMasterEntity adminMasterOne : adminMasterEntityList) {
			AdminModel adminModelOne = new AdminModel();
			BeanUtils.copyProperties(adminMasterOne, adminModelOne);
			adminModelList.add(adminModelOne);
		}
		//System.out.println(adminMasterEntityList);
		return adminModelList;
	}

	@Override
	public String validateEmail(String email) {
		String emailId = null;
		int count=0;
		count = adminMasterRepository.findEmail(email);
		//System.out.println(count);
		if (count == 0) {
			return "success";
		}else {
			return "duplicate";
		}
	}

	@Override
	public void insertPlanData(PlanModel model) {
		PlanMasterEntity planMasterEntity = new PlanMasterEntity();
		BeanUtils.copyProperties(model, planMasterEntity);
		planMasterEntity.setStatus("active");
		PlanMasterEntity planEntity = planMasterRepository.save(planMasterEntity);
		BeanUtils.copyProperties(planEntity, model);
	}
	


	@Override
	public List<PlanModel> getAllPlans() {
		List<PlanModel> planLists = new ArrayList<PlanModel>();
		List<PlanMasterEntity> planMasterEntitiyList = planMasterRepository.findAll();
		for(PlanMasterEntity plan: planMasterEntitiyList) {
			PlanModel planModel = new PlanModel();
			BeanUtils.copyProperties(plan, planModel);
			planLists.add(planModel);
		}
		return planLists;
	}

	@Override
	public void statusInActive(Long serialNumber) {		
		adminMasterRepository.statusInActiveQuery(serialNumber);
		AdminMasterEntity entity = adminMasterRepository.findById(serialNumber).get();
		AdminModel model = new AdminModel();
		BeanUtils.copyProperties(entity, model);
		emailSending.emailSending(model, "Email/AccountStatusChanges.txt");
		//System.out.println(serialNumber);		
	}
	
	@Override
	public void statusActive(Long serialNumber) {		
		adminMasterRepository.statusActiveQuery(serialNumber);
		AdminMasterEntity entity = adminMasterRepository.findById(serialNumber).get();
		AdminModel model = new AdminModel();
		BeanUtils.copyProperties(entity, model);
		emailSending.emailSending(model, "Email/AccountStatusChanges.txt");
		//System.out.println(serialNumber);		
	}
	
	@Override
	public void planStatusInActive(Long planId) {		
		planMasterRepository.planStatusInActiveQuery(planId);
	}
	
	@Override
	public void planStatusActive(Long planId) {		
		planMasterRepository.planStatusActiveQuery(planId);
	}
	
	@Override
	public PlanModel editPlanDetails(Long planId) {
		PlanMasterEntity allData = null;
		PlanMasterEntity planMaster = planMasterRepository.findById(planId).get();
		PlanModel planModel = new PlanModel();
		BeanUtils.copyProperties(planMaster, planModel);
		return planModel;
	}

	@Override
	public void updatePlanDetails(PlanModel model) {		
		PlanMasterEntity entity = new PlanMasterEntity();
		BeanUtils.copyProperties(model, entity);
		entity.setStatus("active");
		PlanMasterEntity planMasterEntity = planMasterRepository.save(entity);		
		BeanUtils.copyProperties(planMasterEntity, model);
	}	

	@Override
	public AdminModel editAccountDetails(Long serialNumber) throws Exception {
		AdminMasterEntity allData = null;
		Optional<AdminMasterEntity> adminMaster = adminMasterRepository.findById(serialNumber);
		
		AdminModel adminModel = new AdminModel();
		if(adminMaster.isPresent()) {
			allData = adminMaster.get();
			String decryptPassword = passwordEncrypt.doDecrypt(allData.getPassword());
			allData.setPassword(decryptPassword);
			BeanUtils.copyProperties(allData, adminModel);
		}
		return adminModel;
	}

	@Override
	public void updateAccountDetails(AdminModel model) throws Exception {
		String encryptedPassword = passwordEncrypt.doEncrypt(model.getPassword());
		model.setPassword(encryptedPassword);
		
		AdminMasterEntity entity = new AdminMasterEntity();
		BeanUtils.copyProperties(model, entity);
		System.out.println("status come from update" +entity.getStatus());
		entity.setStatus("active");
		AdminMasterEntity res = adminMasterRepository.save(entity);
		BeanUtils.copyProperties(res, model);
		Long serialNumber = model.getSerialNumber();
		
		if(serialNumber > 0) {
			String decryptPassword = passwordEncrypt.doDecrypt(model.getPassword());
			model.setPassword(decryptPassword);
			emailSending.emailSending(model,"Email/UpatedAccountInformation.txt");
		}

		
		
	}

	
	
	/*@Override
	public String findUserByEmail(String email, String password) throws Exception {
		
		String encryptedPassword = passwordEncrypt.doEncrypt(password);		
		
		AdminModel model = new AdminModel();
		AdminMasterEntity entity = adminMasterRepository.getUserByEmail(email , encryptedPassword);
		System.out.println(entity);
		if(model != null) {
			BeanUtils.copyProperties(entity, model);
			System.out.println(model);
			if(model.getStatus().equals("active")) {
				if(model.getRole().equals("admin")){
					System.out.println("welcome to admin dashboard");
				}else {
					
					System.out.println("welcome to caseworker dashboard");
				}
				
			}else {
				System.out.println("user status is inactive");//Account De-Activated" error 	msg.
			}
			
		}else {
			System.out.println("invalid credentials");
			String message = "invalid credentials";
			return message;
			
			
		}
		
		
		
		
		return null;
	}
*/
	
	@Override
	public String findUserByEmail(String email, String password) throws Exception {
		
		String message = null;
		
		String encryptedPassword = passwordEncrypt.doEncrypt(password);		
		
		AdminMasterEntity entity = adminMasterRepository.getUserByEmail(email , encryptedPassword);

		if(entity != null) {
			System.out.println(entity);
			if(entity.getStatus().equals("active")) {
				if(entity.getRole().equals("admin")){
					System.out.println("welcome to admin dashboard");
					message = "adminDashboard";
					return message;
				}else {
					
					System.out.println("welcome to caseworker dashboard");
					message = "caseworkerDashboard";
					return message;
				}
				
			}else {
				System.out.println("user status is inactive");//Account De-Activated" error 	msg.
				message = appProperties.getUserInactive();
				return message;
			}
			
		}else {
			System.out.println("invalid credentials");
			message = appProperties.getInvalidCredentials();
			return message;			
		}		
		
		
	}

	public void forgetPassword(String email) throws Exception {
		AdminModel model = new AdminModel();
		AdminMasterEntity entity = adminMasterRepository.forgetPasswordByEmail(email);
		if(entity != null) {
			BeanUtils.copyProperties(entity, model);
			System.out.println(model.getPassword());
			model.setPassword(passwordEncrypt.doDecrypt(model.getPassword()));
			System.out.println(model.getPassword());
			emailSending.emailSending(model,"Email/ForgetPassword.txt");
			
		}
		
	}
	


	
}
