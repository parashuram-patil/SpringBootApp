package com.example.ms.service.token;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.ms.model.token.TokenResponseModel;
import com.example.ms.util.RestUtil;
import com.example.psp.constants.Constants;
import com.example.psp.constants.PropertyValues;

@Service
public class TokenService {

	private RestTemplate restTemplate;

	public TokenService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public TokenResponseModel getToken() {

		HttpHeaders headers = RestUtil.getHeaders(PropertyValues.MINDSPHERE_CLIENT_ID, PropertyValues.MINDSPHERE_CLIENT_SECRET,
				MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");
		HttpEntity<MultiValueMap<String, String>> resquestEntity = RestUtil.getResquestEntity(body, headers);

		ResponseEntity<TokenResponseModel> exchange = restTemplate.exchange(Constants.MS_TOKEN_URL, HttpMethod.POST,
				resquestEntity, TokenResponseModel.class);

		return exchange.getBody();
	}
}
