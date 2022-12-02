package com.api.dmat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.dmat.model.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer>{

	
	@Transactional
	@Modifying
    @Query(value = "select * from userprofilemaster",nativeQuery = true)
    public Iterable<UserProfile> findData();

	
}
