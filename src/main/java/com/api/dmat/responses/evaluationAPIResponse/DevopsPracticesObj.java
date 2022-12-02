package com.api.dmat.responses.evaluationAPIResponse;

import org.springframework.stereotype.Component;

@Component
public class DevopsPracticesObj {
	private float score ;
	private String recommendations ;
	private int currentLevel ;
	private int recommendedLevel ;
	private int maxlevel ;
	
	public DevopsPracticesObj() {
	}
	
	public DevopsPracticesObj(float score, String recommendations, int currentLevel, int recommendedLevel,int maxlevel) {
		super();
		this.score = score;
		this.recommendations = recommendations;
		this.currentLevel = currentLevel;
		this.recommendedLevel = recommendedLevel;
		this.maxlevel = maxlevel;
	}
	public float getScore() {
		return score;
	}
	public String getRecommendations() {
		return recommendations;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public int getRecommendedLevel() {
		return recommendedLevel;
	}
	public int getMaxlevel() {
		return maxlevel;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	public void setRecommendedLevel(int recommendedLevel) {
		this.recommendedLevel = recommendedLevel;
	}
	public void setMaxlevel(int maxlevel) {
		this.maxlevel = maxlevel;
	}
	
}
