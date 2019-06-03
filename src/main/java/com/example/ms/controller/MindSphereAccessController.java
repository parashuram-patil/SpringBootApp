package com.example.ms.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms.model.asset.SearchAssetsByNameResponseModel;
import com.example.ms.model.token.TokenResponseModel;
import com.example.ms.service.asset.AssetService;
import com.example.ms.service.token.TokenService;

@RestController
@RequestMapping("/ms")
public class MindSphereAccessController {

	private TokenService tokenService;
	private AssetService assetService;

	public MindSphereAccessController(TokenService getToken, AssetService assetService) {
		this.tokenService = getToken;
		this.assetService = assetService;
	}

	@RequestMapping(value = "/token", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
	public TokenResponseModel getToken() {

		return tokenService.getToken();
	}

	@RequestMapping(value = "/asset/{assetName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
	public SearchAssetsByNameResponseModel getAssetsByName(@PathVariable String assetName) {

		return assetService.getAssetsByName(assetName);
	}

}
