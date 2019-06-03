package com.example.psp.constants;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyValues {

	@Value("${spring.profiles.active}")
	private String activeProfile;

	public static String MINDSPHERE_CLIENT_ID;
	public static String MINDSPHERE_CLIENT_SECRET;
	public static String MINDSPHERE_TENANT;

	public static String ACTIVE_PROFILE;

	/*
	 * static { CLIENT_ID = System.getenv("CLIENT_ID"); CLIENT_SECRETE =
	 * System.getenv("CLIENT_SECRETE"); }
	 */

	@PostConstruct
	private void initializeConstants() {
		MINDSPHERE_CLIENT_ID = System.getenv(Constants.MINDSPHERE_CLIENT_ID);
		MINDSPHERE_CLIENT_SECRET = System.getenv(Constants.MINDSPHERE_CLIENT_SECRET);
		MINDSPHERE_TENANT = System.getenv(Constants.MINDSPHERE_TENANT);

		ACTIVE_PROFILE = activeProfile;
	}

}
