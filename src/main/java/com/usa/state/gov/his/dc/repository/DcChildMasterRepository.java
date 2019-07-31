package com.usa.state.gov.his.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.state.gov.his.dc.entity.DcCaseChildMasterEntity;

@Repository
public interface DcChildMasterRepository extends JpaRepository<DcCaseChildMasterEntity, Serializable>{

}
