package com.api.dmat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.api.dmat.model.OptionsMaster;


public interface OptionsMasterRepo extends JpaRepository<OptionsMaster,Integer>{
	@Transactional
	@Modifying
    @Query(value = "select * from optionsmaster o where o.questionid=:questionid",nativeQuery = true)
    public List<String> findProcessOptions(@Param("questionid") int questionid);

	@Query(value = "SELECT e.score FROM OptionsMaster e WHERE e.optionname=:opname AND e.questionid=:quesid")
	String scoreByOption(@Param("opname") String string,@Param("quesid") int i);

}
