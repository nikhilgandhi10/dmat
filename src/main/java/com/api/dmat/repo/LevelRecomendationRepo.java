package com.api.dmat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.dmat.model.LevelsRecommendations;

@Repository
public interface LevelRecomendationRepo extends JpaRepository<LevelsRecommendations, Integer> {

	@Query(value = "Select recommendations from levelsrecommendationsmaster where devopscategoryid=:devopid and currentlevel=:usercurrentlevel ", nativeQuery = true)
	String recommendation(@Param("devopid") int devopid, @Param("usercurrentlevel") int usercurrentlevel);

	// Returns te max possible level in a level recommendation master
	@Query(value="select max(recommendedlevel) FROM levelsrecommendationsmaster",nativeQuery = true)
	int findMaxRecommendedlevel();

}
