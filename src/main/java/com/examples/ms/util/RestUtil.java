package com.examples.ms.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;

public class RestUtil {

	public static HttpHeaders getHttpHeaders() {

		return new HttpHeaders();
	}

	public static HttpHeaders getHeaders(String username, String password) {

		return getHeaders(username, password, null);
	}

	public static HttpHeaders getHeaders(String username, String password, MediaType mediaType) {

		String auth = username + ":" + password;
		byte[] encodedAuth = Base64Utils.encode(auth.getBytes(StandardCharsets.UTF_8));
		String authHeader = "Basic " + new String(encodedAuth);

		HttpHeaders httpHeaders = getHttpHeaders();
		httpHeaders.set(HttpHeaders.AUTHORIZATION, authHeader);
		httpHeaders.set(HttpHeaders.CONTENT_TYPE, mediaType.toString());

		return httpHeaders;

	}

	public static HttpHeaders getHeaders(String accessToken) {
		HttpHeaders httpHeaders = getHttpHeaders();
		httpHeaders.setBearerAuth(accessToken);

		return httpHeaders;
	}

	public static <T> HttpEntity<T> getResquestEntity(T body, HttpHeaders headers) {

		HttpEntity<T> httpEntity = new HttpEntity<T>(body, headers);

		return httpEntity;
	}

	public static <T> HttpEntity<T> getResquestEntity(HttpHeaders headers) {
		HttpEntity<T> httpEntity = new HttpEntity<T>(headers);

		return httpEntity;
	}
}
