package com.examples.ms.util;

import java.nio.charset.StandardCharsets;

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
		//httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		//httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		//httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		httpHeaders.setBearerAuth(accessToken);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
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
