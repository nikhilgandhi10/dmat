package com.api.dmat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dmat.model.DevopsPractice;

public interface DevopsPracticeRepo extends JpaRepository<DevopsPractice, Integer> {

	DevopsPractice findByDevopscategoryid(int devopscategoryid);

}
