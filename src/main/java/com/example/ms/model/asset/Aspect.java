package com.example.ms.model.asset;

import java.util.List;

public class Aspect {
	
	private List<Variables> variables;

	private String name;

	public List<Variables> getVariables() {
		return variables;
	}

	//@JsonDeserialize(contentAs = Variables.class)
	public void setVariables(List<Variables> variables) {
		this.variables = variables;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassPojo [variables = " + variables + ", name = " + name + "]";
	}
}
