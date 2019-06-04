package com.example.ms.model.user;

public class Email {
	
	private String value;
	private String primary;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	@Override
	public String toString() {
		return "ClassPojo [value = " + value + ", primary = " + primary + "]";
	}
}
