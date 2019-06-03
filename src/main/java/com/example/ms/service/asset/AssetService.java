package com.example.ms.service.asset;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ms.model.asset.SearchAssetsByNameResponseModel;
import com.example.ms.service.token.TokenService;
import com.example.psp.constants.Constants;
import com.examples.ms.util.RestUtil;

@Service
public class AssetService {

	private RestTemplate restTemplate;
	private TokenService tokenService;

	public AssetService(RestTemplate restTemplate, TokenService tokenService) {
		this.restTemplate = restTemplate;
		this.tokenService = tokenService;
	}

	public SearchAssetsByNameResponseModel getAssetsByName(String assetName) {
		String accessToken = tokenService.getToken().getAccess_token();
		HttpEntity<SearchAssetsByNameResponseModel> resquestEntity = RestUtil.getResquestEntity(RestUtil.getHeaders(accessToken));
		String filter = "?filter={\"name\":{\"eq\":\":" + assetName + "\"}}";
		String url = null;
		try {
			url = Constants.MS_ASSSETS_BASE_URL + URLEncoder.encode(filter, Constants.UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		ResponseEntity<SearchAssetsByNameResponseModel> response = restTemplate.exchange(url, HttpMethod.GET, resquestEntity, SearchAssetsByNameResponseModel.class);

		return response.getBody();
	}

}
