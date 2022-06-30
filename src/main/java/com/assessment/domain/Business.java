package com.assessment.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Business {

	private String id;
	private String alias;
	private String name;
	
	public String getId() {
		return id;
	}
	
}
