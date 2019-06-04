package com.example.ms.model.user;

public class Group {
	
	private String display;
	private String type;
	private String value;

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ClassPojo [display = " + display + ", type = " + type + ", value = " + value + "]";
	}
}
