package com.api.dmat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.api.dmat.model.QuestionsMaster;

public interface QuestionMasterRepo extends JpaRepository<QuestionsMaster, Integer> {

	QuestionsMaster findByQuestionid(int questionid);

	boolean existsByQuestionid(int questionId);

	@Transactional
	@Modifying
	@Query(value = "select * from questionmaster", nativeQuery = true)
	public Iterable<QuestionsMaster> findProcessQuestions();

	// Gets the max score that is possible for a DisplayCategory
	@Query(value = "select sum(maxscores)from (select max(score) as maxscores from questionsmaster q ,optionsmaster o  where  q.questionid=o.questionid and  q.displaycategoryid = :id  group by q.questionid ) as new_table ", nativeQuery = true)
	String maxScoreByDisplayCategoryId(@Param("id") Integer id);

	// Gets the max score that is possible for a DisplayCategory
	@Query(value = "select sum(maxscores)from (select max(score) as maxscores from questionsmaster q ,optionsmaster o  where  q.questionid=o.questionid and  q.devopscategoryid = :id group by q.questionid ) as new_table " , nativeQuery = true)
	String maxScoreByDevopsPracticesId(@Param("id") Integer id);
}
