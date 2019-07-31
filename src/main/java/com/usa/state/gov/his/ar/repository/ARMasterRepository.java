package com.usa.state.gov.his.ar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.state.gov.his.ar.entity.ARMasterEntity;

@Repository
public interface ARMasterRepository extends JpaRepository<ARMasterEntity, Serializable>{
	
	@Query(value = "select count(*) from ARMasterEntity where email=:email" )
	public int findEmail(String email);
	
	@Query(value = "select count(*) from ARMasterEntity where ssnNumber=:ssnNumber" )
	public Long findssnNumber(Long ssnNumber);

}
