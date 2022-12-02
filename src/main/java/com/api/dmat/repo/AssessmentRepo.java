package com.api.dmat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.api.dmat.model.Assessment;
import com.api.dmat.model.Users;

public interface AssessmentRepo extends JpaRepository<Assessment, Integer> {

	Assessment findByAssessmentid(int assessmentid);
	

	@Transactional
	@Modifying
    @Query(value = "update assessment a set a.userId=:userId where assessmentid=:assessId",nativeQuery = true)
	void updateUserIdWhereAssessmentIdEquals(@Param("assessId")int assessId, @Param("userId")int userId);

	@Transactional
	@Modifying
	@Query(value= "update assessment a set a.status='OBSOLETE' where (a.status = 'ACTIVE') AND (TIMESTAMPDIFF(day,a.creationdatetime,current_timestamp()) >= 7 ) ",nativeQuery = true)
	void setStatusForAssessments();

	
	public Assessment findByUserid(int userId);
	public List<Assessment> findAll();
}
