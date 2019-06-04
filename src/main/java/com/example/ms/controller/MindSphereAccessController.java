package com.example.ms.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms.exception.user.SearchUserException;
import com.example.ms.model.asset.SearchAssetsByNameResponseModel;
import com.example.ms.model.token.TokenResponseModel;
import com.example.ms.model.user.UserModel;
import com.example.ms.service.asset.AssetService;
import com.example.ms.service.token.TokenService;
import com.example.ms.service.user.UserService;

@RestController
@RequestMapping("/ms")
public class MindSphereAccessController {

	private TokenService tokenService;
	private AssetService assetService;
	private UserService userService;

	public MindSphereAccessController(TokenService getToken, AssetService assetService, UserService userService) {
		this.tokenService = getToken;
		this.assetService = assetService;
		this.userService = userService;
	}

	@RequestMapping(value = "/token", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TokenResponseModel getToken() {

		return tokenService.getToken();
	}
	
	@RequestMapping(value = "/asset/{assetName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SearchAssetsByNameResponseModel getAssetsByName(@PathVariable String assetName) throws Exception {

		return assetService.getAssetsByName(assetName);
	}
	
	@RequestMapping(value = "/users/{userName:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserModel getUserByUserName(@PathVariable String userName) throws SearchUserException {

		return userService.getUserByUserName(userName);
	}
}
