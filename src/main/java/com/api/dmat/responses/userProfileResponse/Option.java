package com.api.dmat.responses.userProfileResponse;

public class Option {
	private String option1;
	private String option2;
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public Option(String option1, String option2) {
		super();
		this.option1 = option1;
		this.option2 = option2;
	}
	
}
