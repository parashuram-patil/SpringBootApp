package com.example.psp.main;

public class Test {
	
	private static final String message = "City :msg not found";

	public static void main(String[] args) {
		System.out.println("**********	Test	**********");
		
		System.out.println(message.replace(":msg", "XXX"));
		System.out.println(message);
		System.out.println(message.replace(":msg", "YYYY"));
		System.out.println(message);
		
	}

}
