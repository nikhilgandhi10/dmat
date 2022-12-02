package com.api.dmat.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evaluation_response_sequence")
public class Evaluations_Response_Sequence {
	@Id
	private int next_val ;

	public Evaluations_Response_Sequence() {}
	
	public Evaluations_Response_Sequence(int next_val) {
		super();
		this.next_val = next_val;
	}

	public int getNext_val() {
		return next_val;
	}

	public void setNext_val(int next_val) {
		this.next_val = next_val;
	}
	
	
	
}
