package com.usa.state.gov.his.dc.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.state.gov.his.admin.entity.AdminMasterEntity;
import com.usa.state.gov.his.admin.entity.PlanMasterEntity;
import com.usa.state.gov.his.admin.model.PlanModel;
import com.usa.state.gov.his.admin.repository.AdminMasterRepository;
import com.usa.state.gov.his.admin.repository.PlanMasterRepository;
import com.usa.state.gov.his.ar.entity.ARMasterEntity;
import com.usa.state.gov.his.ar.model.ARModel;
import com.usa.state.gov.his.ar.repository.ARMasterRepository;
import com.usa.state.gov.his.dc.entity.DcCaseChildMasterEntity;
import com.usa.state.gov.his.dc.entity.DcCasePlanMasterEntity;
import com.usa.state.gov.his.dc.entity.DcMasterEntity;
import com.usa.state.gov.his.dc.model.DcCaseChildModel;
import com.usa.state.gov.his.dc.model.DcCasePlanModel;
import com.usa.state.gov.his.dc.model.DcModel;
import com.usa.state.gov.his.dc.repository.DcCasePlanMasterRepository;
import com.usa.state.gov.his.dc.repository.DcChildMasterRepository;
import com.usa.state.gov.his.dc.repository.DcMasterRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class DcServiceImpl implements DcService {
	
	@Autowired
	private PlanMasterRepository planMasterRepository;
	
	
	@Autowired
	private ARMasterRepository arMasterRepository;
	
	@Autowired
	private DcMasterRepository dcMasterRepository;
	
	@Autowired
	private DcChildMasterRepository dcChildMasterRepository;
	
	@Autowired
	private DcCasePlanMasterRepository dcCasePlanMasterRepository;
	
	@Override
	public List<PlanModel> getPlanNames() {
		//List<PlanModel> planModelList = new ArrayList<PlanModel>();
		List planModelList = new ArrayList();
		List<PlanMasterEntity> allPlans = planMasterRepository.findAll();
		for(PlanMasterEntity singlePlan : allPlans) {
			PlanModel planModel = new PlanModel();
			BeanUtils.copyProperties(singlePlan, planModel);
			if(planModel.getStatus().equals("active")) {
			//planModelList.add(planModel.getPlanName());
			planModelList.add(planModel);
			}
			
		}
		return planModelList;
	}
	
	
	@Override
	public ARModel getCitizen(Long applicationNumber) {
		Optional<ARMasterEntity> arMasterEntity = arMasterRepository.findById(applicationNumber);
		if(arMasterEntity.isPresent()) {
			ARMasterEntity entity = arMasterEntity.get();
			ARModel arModel = new ARModel();
			BeanUtils.copyProperties(entity, arModel);
			return arModel;
		}
		return null;
	}
	
	@Override
	public DcModel caseGenerate(DcModel dcModel) {
		DcMasterEntity dcMasterEntity = new DcMasterEntity();
		BeanUtils.copyProperties(dcModel, dcMasterEntity);
		DcMasterEntity saved = dcMasterRepository.save(dcMasterEntity);
		BeanUtils.copyProperties(saved, dcModel);
		return dcModel;
	}

	@Override
	public void childPlanRegistration(DcCaseChildModel childModel) {
		DcCaseChildMasterEntity dcChildCaseEntity = new DcCaseChildMasterEntity();
		BeanUtils.copyProperties(childModel, dcChildCaseEntity);
		dcChildMasterRepository.save(dcChildCaseEntity);
		
	}


	@Override
	public PlanModel getPlanIds(String planName) {
		PlanMasterEntity planId = planMasterRepository.findByPlanName(planName);
		PlanModel planModel = new PlanModel();
		BeanUtils.copyProperties(planId, planModel);
		System.out.println(planId);
		return planModel;
	}


	@Override
	public DcCasePlanModel casePlan(DcCasePlanModel dcCasePlanModel) {
		DcCasePlanMasterEntity dcCasePlanMasterEntity = new DcCasePlanMasterEntity();
		BeanUtils.copyProperties(dcCasePlanModel, dcCasePlanMasterEntity);
		DcCasePlanMasterEntity dcCasePlanTable = dcCasePlanMasterRepository.save(dcCasePlanMasterEntity);
		BeanUtils.copyProperties(dcCasePlanTable, dcCasePlanModel);
		return dcCasePlanModel;
	}

}
