package com.api.dmat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.dmat.model.DisplayCategories;

public interface DisplayCategoriesRepo extends JpaRepository<DisplayCategories,Integer>{

	List<DisplayCategories> findAll();

	DisplayCategories findByDisplaycategoryid(int displaycategoryid);
	
	@Query(value="select sum(maxscore) from DisplayCategoriesmaster d inner join QuestionsMaster q on d.displaycategoryid=q.displaycategoryid where q.devopscategoryid=:id group by q.devopscategoryid", nativeQuery=true)
    String maxScoreById(@Param("id") Integer  id);

	@Query(value = "Select count(*) from questionsmaster where displaycategoryid=(select displaycategoryid from displaycategoriesmaster where name=:name)", nativeQuery = true)
	int noOfQuesbyDisCat(@Param("name") String name);

	@Query(value="Select distinct devopscategoryid from devopspracticesmaster " ,nativeQuery=true)
	List<Integer> getDisplayCategoryIds();
	
}
