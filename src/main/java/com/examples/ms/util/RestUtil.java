package com.examples.ms.util;

import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;

public class RestUtil {

	public static HttpHeaders getHeaders(String username, String password) {

		return getHeaders(username, password, null);
	}

	public static HttpHeaders getHeaders(String username, String password, MediaType mediaType) {

		return new HttpHeaders() {

			private static final long serialVersionUID = 1L;

			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64Utils.encode(auth.getBytes(StandardCharsets.UTF_8));
				String authHeader = "Basic " + new String(encodedAuth);
				set(HttpHeaders.AUTHORIZATION, authHeader);
				set(HttpHeaders.CONTENT_TYPE, mediaType.toString());
			}
		};
	}

	public static <T> HttpEntity<T> getResquestEntity(T body, HttpHeaders headers) {

		HttpEntity<T> httpEntity = new HttpEntity<T>(body, headers);

		return httpEntity;
	}

}
