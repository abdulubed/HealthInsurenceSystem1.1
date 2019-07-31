package com.usa.state.gov.his.admin.repository;

import java.io.Serializable;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.state.gov.his.admin.entity.AdminMasterEntity;

/**  
 * this interface is for implementing admin database table operations 
 * @author Abdul
 *
 */
@Repository
public interface AdminMasterRepository extends JpaRepository<AdminMasterEntity, Serializable>{
	
	@Query(value = "select count(*) from AdminMasterEntity where email=:email" )
	public int findEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update AdminMasterEntity set status= 'inActive' WHERE serialNumber =:serialNumber")
	public void statusInActiveQuery(Long serialNumber);
	
	@Transactional
	@Modifying
	@Query(value = "update AdminMasterEntity set status= 'active' WHERE serialNumber =:serialNumber")
	public void statusActiveQuery(Long serialNumber);
	
	@Query(value = "from AdminMasterEntity where email=:email and password=:password")
	public AdminMasterEntity getUserByEmail(String email, String password);
	
	@Query(value = "from AdminMasterEntity where email=:email")
	public AdminMasterEntity forgetPasswordByEmail(String email);

	

}
