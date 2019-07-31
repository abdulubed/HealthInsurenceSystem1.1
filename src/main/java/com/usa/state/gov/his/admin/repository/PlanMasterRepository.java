package com.usa.state.gov.his.admin.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.state.gov.his.admin.entity.PlanMasterEntity;

@Repository
public interface PlanMasterRepository extends JpaRepository<PlanMasterEntity, Serializable>{

	@Query(value = "from PlanMasterEntity where planName=:planName")
	public PlanMasterEntity findByPlanName(String planName);
	
	@Transactional
	@Modifying
	@Query(value = "update PlanMasterEntity set status= 'inActive' WHERE planId =:planId")
	public void planStatusInActiveQuery(Long planId);
	
	@Transactional
	@Modifying
	@Query(value = "update PlanMasterEntity set status= 'active' WHERE planId =:planId")
	public void planStatusActiveQuery(Long planId);

}
