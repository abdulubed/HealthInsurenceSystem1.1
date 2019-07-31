package com.usa.state.gov.his.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.state.gov.his.dc.entity.DcMasterEntity;

@Repository
public interface DcMasterRepository extends JpaRepository< DcMasterEntity , Serializable>{

	
	

}
