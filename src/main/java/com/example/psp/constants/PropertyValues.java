package com.example.psp.constants;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyValues {

	@Value("${spring.profiles.active}")
	private String activeProfile;

	public static String CLIENT_ID;
	public static String CLIENT_SECRETE;

	public static String ACTIVE_PROFILE;

	/*
	 * static { CLIENT_ID = System.getenv("CLIENT_ID"); CLIENT_SECRETE =
	 * System.getenv("CLIENT_SECRETE"); }
	 */

	@PostConstruct
	private void initializeConstants() {
		CLIENT_ID = System.getenv("CLIENT_ID");
		CLIENT_SECRETE = System.getenv("CLIENT_SECRETE");

		ACTIVE_PROFILE = activeProfile;
	}

}
