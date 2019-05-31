package com.example.ms.service.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.ms.model.TokenResponseModel;
import com.example.psp.constants.Constants;
import com.example.psp.constants.ConstantsValues;
import com.examples.ms.util.RestUtil;

@Service
public class GetToken {

	@Autowired
	private RestTemplate restTemplate;

	public TokenResponseModel getToken() {

		HttpHeaders headers = RestUtil.getHeaders(ConstantsValues.CLIENT_ID,  ConstantsValues.CLIENT_SECRETE, MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");
		HttpEntity<MultiValueMap<String, String>> resquestEntity = RestUtil.getResquestEntity(body, headers);

		ResponseEntity<TokenResponseModel> exchange = restTemplate.exchange(Constants.GET_MS_TOKEN_URL, HttpMethod.POST, resquestEntity, TokenResponseModel.class);

		return exchange.getBody();
	}
}
