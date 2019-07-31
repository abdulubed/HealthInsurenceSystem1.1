package com.usa.state.gov.his.ar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.state.gov.his.admin.repository.PlanMasterRepository;
import com.usa.state.gov.his.ar.entity.ARMasterEntity;
import com.usa.state.gov.his.ar.model.ARModel;
import com.usa.state.gov.his.ar.repository.ARMasterRepository;
import com.usa.state.gov.his.dc.entity.DcMasterEntity;
import com.usa.state.gov.his.dc.model.DcModel;
import com.usa.state.gov.his.dc.repository.DcMasterRepository;
import com.usa.state.gov.his.restclient.RestClientForStateValidation;

@Service
public class ArServiceImple implements ArService {
	
	@Autowired
	private ARMasterRepository arMasterRepository;
	
	@Autowired
	private RestClientForStateValidation restClientForStateValidation;
	

	

/*
	@Override
	public Long insertArData(ARModel arModel) {
			
			ARMasterEntity entity = new ARMasterEntity(); 
			BeanUtils.copyProperties(arModel, entity);
			ARMasterEntity res = arMasterRepository.save(entity);
			//System.out.println(res.getSsnNumber() + "" + (res.getSsnNumber() > 0));
			//System.out.println(res.getSsnNumber());
			BeanUtils.copyProperties(res, arModel);
			//System.out.println("from serviceimpl"+res.getDateOfBirth());
			return res.getApplicationNumber();
			}*/
	
	@Override
	public String arEmailValidation(String email) {
		String emailId = null;
		int count=0;
		count = arMasterRepository.findEmail(email);
		//System.out.println(count);
		if (count == 0) {
			return "success";
		}else {
			return "duplicate";
		}
	}
	
	@Override
	public List<ARModel> getCitizensAccounts() {
		List<ARModel> arModelList = new ArrayList();
		List<ARMasterEntity> arMasterEntityList = arMasterRepository.findAll();
		for (ARMasterEntity arMasterOne : arMasterEntityList) {
			ARModel arModelOne = new ARModel();
			BeanUtils.copyProperties(arMasterOne, arModelOne);
			arModelList.add(arModelOne);
		}
		//System.out.println(adminMasterEntityList);
		return arModelList;
	}

	@Override
	public Long appRegistration(ARModel arModel, Long ssnNumber) {
		Long dbSsnNumbercount=0l;
		dbSsnNumbercount = arMasterRepository.findssnNumber(ssnNumber);
		if(dbSsnNumbercount == 0) {
			String stateName = restClientForStateValidation.getStateName(ssnNumber);
			String givenStateName = "washington";
			if (stateName.equals(givenStateName)) {
				ARMasterEntity entity = new ARMasterEntity(); 
				BeanUtils.copyProperties(arModel, entity);
				ARMasterEntity res = arMasterRepository.save(entity);
				BeanUtils.copyProperties(res, arModel);
				return arModel.getApplicationNumber();
			}else {
				return 1l;
			}
		}else {
			return 0l;
		}
	
	}

	
}


