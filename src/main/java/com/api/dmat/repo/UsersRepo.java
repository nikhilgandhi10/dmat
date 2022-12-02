package com.api.dmat.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.api.dmat.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {
	
	Users findByUserid(int assessmentid);

	@Transactional
	@Modifying
	@Query(value = "Insert into users(buname,emailid,projectid,projectname,contact,creationdatetime) select :buname,:emailid,:projectid,:projectname,:contact,:creationdatetime from Dual", nativeQuery = true)
	public int enterUserDetails(@Param("buname") String buname, @Param("emailid") String emailid,
			@Param("projectid") String projectid, @Param("projectname") String projectname,
			@Param("contact") Integer contact,@Param("creationdatetime") Date creationdatetime);

	
	@Query(value = "select u.userid from Users u order by u.userid desc limit 1", nativeQuery = true)
	public int getLatestUserId();

	
	//Fetch All Users detail for respective Email id
	public List<Users> findByEmailid(String emailId);
	
	public List<Users>findAll();
	
}
